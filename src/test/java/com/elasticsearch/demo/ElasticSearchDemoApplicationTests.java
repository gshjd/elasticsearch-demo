package com.elasticsearch.demo;

import com.elasticsearch.demo.dataobject.DemoDO;
import com.elasticsearch.demo.dataobject.DwsLabelDO;
import com.elasticsearch.demo.repository.DemoRepository;
import org.elasticsearch.index.query.*;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.bucket.terms.ParsedStringTerms;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.elasticsearch.search.aggregations.metrics.Sum;
import org.elasticsearch.search.aggregations.metrics.SumAggregationBuilder;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.*;

import java.util.*;

@SpringBootTest
class ElasticSearchDemoApplicationTests {
    @Autowired
    private ElasticsearchRestTemplate elasticsearchTemplate;
    @Autowired
    private DemoRepository repository;
    private final Logger logger = LoggerFactory.getLogger(ElasticSearchDemoApplicationTests.class);

    private NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();

    /**
     * 增
     */
    @Test
    public void save() {
        for (int i = 0; i < 100000; i++) {
            DemoDO demoDO = new DemoDO();
            demoDO.setDevice("phone");
            demoDO.setAge((int) (Math.random() * 10 + 1));
            demoDO.setName(UUID.randomUUID().toString());
            demoDO.setNickName(UUID.randomUUID().toString());
            demoDO.setLastLoginDate(new Date());
            repository.save(demoDO);
        }
    }

    /**
     * 修改
     */
    @Test
    public void update() {
        DemoDO demoDO = new DemoDO();
        demoDO.setId("");
        demoDO.setDevice("phone");
        demoDO.setAge((int) (Math.random() * 10 + 1));
        demoDO.setName(UUID.randomUUID().toString());
        demoDO.setNickName(UUID.randomUUID().toString());
        demoDO.setLastLoginDate(new Date());
        repository.save(demoDO);
    }

    /**
     * 分词查询
     */
    @Test
    public void matchQuery() {
        QueryBuilder queryBuilder = QueryBuilders.matchQuery("name", "ae4be7fb");
        out(queryBuilder);
    }

    /**
     * 模糊查询
     */
    @Test
    public void fuzzyQuery() {
        QueryBuilder queryBuilder = QueryBuilders.fuzzyQuery("name", "e82022d3");
        out(queryBuilder);
    }

    /**
     * 精确查询
     */
    @Test
    public void matchPhraseQuery() {
        QueryBuilder queryBuilder = QueryBuilders.matchPhraseQuery("name.keyword", "ae4be7fb-983e-429f-bd73-162b28bcf800");
        out(queryBuilder);
    }

    @Test
    public void query() {
        long start = new Date().getTime();
        Iterable<DemoDO> demoDOIterator = repository.findAll();
        System.out.println(demoDOIterator.spliterator().getExactSizeIfKnown());
        System.out.println("spend time: " + (new Date().getTime() - start));
    }


    /**
     * 过滤器搜索
     * 名字为 e82022d3-6c61-4495-bc60-86bde67ec409
     * 且
     * 年龄大于 1
     */
    @Test
    public void findFilter() {
        QueryBuilder queryBuilder = QueryBuilders.matchQuery("name.keyword", "e82022d3-6c61-4495-bc60-86bde67ec409");
        QueryBuilder filter = QueryBuilders.rangeQuery("age").gt(1);
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery().must(queryBuilder).filter(filter);
        out(boolQueryBuilder);
    }

    /**
     * 年龄等于9 或 名字为e82022d3-6c61-4495-bc60-86bde67ec409
     * 且
     * 昵称不能等于123
     */
    @Test
    public void filtered() {
        QueryBuilder termQuery = QueryBuilders.termQuery("age", 9);
        QueryBuilder termQuery1 = QueryBuilders.termQuery("name.keyword", "e82022d3-6c61-4495-bc60-86bde67ec409");
        QueryBuilder mustNotQuery = QueryBuilders.termQuery("nickName", "123");
        QueryBuilder shouldQuery = QueryBuilders.boolQuery().should(termQuery).should(termQuery1).mustNot(mustNotQuery);
        out(shouldQuery);
    }

    /**
     * 查询所有
     */
    @Test
    public void queryAll() {
        QueryBuilder queryBuilder = QueryBuilders.matchAllQuery();
        out(queryBuilder);
    }

    @Test
    public void deleteById() {
        String id = "";
        repository.deleteById(id);
    }

    @Test
    public void deleteAll() {
        repository.deleteAll();
    }

    @Test
    public void deleteIndex() {
        elasticsearchTemplate.deleteIndex(DemoDO.class);
    }

    /**
     * 多字段匹配
     */
    @Test
    public void multiMatch() {
        QueryBuilder queryBuilder = QueryBuilders.multiMatchQuery("39446462-d653-40d4-ab01-acb9f07a3161", "name.keyword", "nickName.keyword");
        out(queryBuilder);
    }

    /**
     * 全字段匹配
     */
    @Test
    public void queryString() {
        QueryBuilder queryBuilder = QueryBuilders.queryStringQuery("小熊");
        out(queryBuilder);
    }

    /**
     * 精确查询，不支持分词
     */
    @Test
    public void term() {
        QueryBuilder queryBuilder = QueryBuilders.termQuery("name.keyword", "e82022d3-6c61-4495-bc60-86bde67ec409");
        out(queryBuilder);
    }

    /**
     * 真·模糊查询 和 SQL中的like一致
     */
    @Test
    public void wildcardQuery() {
        QueryBuilder wildcardBuilder = QueryBuilders.wildcardQuery("name.keyword", "*e*");
        out(wildcardBuilder);
    }

    /**
     * 后模糊查询 性能比wildcard要高
     */
    @Test
    public void prefixQuery() {
        QueryBuilder queryBuilder = QueryBuilders.prefixQuery("name.keyword", "e");
        out(queryBuilder);
    }

    /**
     * 正则表达式查询
     */
    @Test
    public void regexpQuery() {
        QueryBuilder regexpQuery = QueryBuilders.regexpQuery("name.keyword", "");
        out(regexpQuery);
    }

    /**
     * 不评分精确查询
     */
    @Test
    public void constantScoreTerm() {
        QueryBuilder termQuery = QueryBuilders.termQuery("name.keyword", "e82022d3-6c61-4495-bc60-86bde67ec409");
        QueryBuilder queryBuilder = QueryBuilders.constantScoreQuery(termQuery);
        out(queryBuilder);
    }

    /**
     * 包含查询
     */
    @Test
    public void range() {
        // lt小于 lte小于等于
        QueryBuilder queryBuilder = QueryBuilders.rangeQuery("lastLoginDate").lt(new Date().getTime());
        // gt大于 gte大于等于
//		queryBuilder = QueryBuilders.rangeQuery("lastLoginDate").lt(new Date().getTime());
        out(queryBuilder);
    }

    /**
     * 组合查询
     */
    @Test
    public void jointQuery() {
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        QueryBuilder queryBuilder = QueryBuilders.matchPhraseQuery("name.keyword", "ae4be7fb-983e-429f-bd73-162b28bcf800");
        QueryBuilder queryBuilder1 = QueryBuilders.matchPhraseQuery("nickName.keyword", "小熊");
        boolQueryBuilder.must(queryBuilder);
        boolQueryBuilder.must(queryBuilder1);
        out(boolQueryBuilder);
    }

    /**
     * 组合过滤器
     */
    @Test
    public void combinationFilter() {
        QueryBuilder termQuery = QueryBuilders.termQuery("name.keyword", "小熊");
        QueryBuilder termQuery1 = QueryBuilders.termQuery("age", 11);
        QueryBuilder termQuery2 = QueryBuilders.termQuery("nickName", "乖乖熊");
        QueryBuilder queryBuilder = QueryBuilders.boolQuery().should(termQuery).should(termQuery1).mustNot(termQuery2);
        out(queryBuilder);
    }

    /**
     * 嵌套布尔查询
     */
    @Test
    public void nestedBooleanQuery() {
        QueryBuilder termQuery = QueryBuilders.termQuery("name.keyword", "小熊");
        QueryBuilder termQuery1 = QueryBuilders.termQuery("nickName", "小笨熊");
        QueryBuilder termQuery2 = QueryBuilders.termQuery("age", 10);
        QueryBuilder queryBuilder1 = QueryBuilders.boolQuery().must(termQuery1).must(termQuery2);
        QueryBuilder queryBuilder = QueryBuilders.boolQuery().must(termQuery).must(queryBuilder1);
        out(queryBuilder);
    }

    /**
     * 查找多个精确值
     */
    @Test
    public void termsQuery() {
        QueryBuilder queryBuilder = QueryBuilders.termsQuery("name.keyword", "小熊", "小笨熊");
        out(queryBuilder);
    }

    /**
     * 范围搜索
     */
    @Test
    public void rangeQuery() {
        QueryBuilder queryBuilder = QueryBuilders.rangeQuery("age").gte(10).lte(30);
        out(queryBuilder);
    }

    /**
     * 查询某个字段非空的
     */
    @Test
    public void notNullQuery() {
        QueryBuilder queryBuilder = QueryBuilders.existsQuery("name.keyword");
        QueryBuilders.matchQuery("name.keyword", "小熊 小笨熊").operator(Operator.AND);
        out(queryBuilder);
    }

    /**
     * 多词查询
     */
    @Test
    public void multiWordQuery() {
        QueryBuilder queryBuilder = QueryBuilders.matchQuery("name", "addb8e53 4d3029a6").operator(Operator.AND);
        out(queryBuilder);
    }

    @Test
    public void aggQuery() {
        TermsAggregationBuilder termsAggregationBuilder = AggregationBuilders.terms("popularBrand").field("name.keyword");
        TermsAggregationBuilder termsAggregationBuilder1 = AggregationBuilders.terms("popularBrand1").field("nickName.keyword");
        nativeSearchQueryBuilder = nativeSearchQueryBuilder.addAggregation(termsAggregationBuilder).addAggregation(termsAggregationBuilder1);
        NativeSearchQuery searchQuery = nativeSearchQueryBuilder.build();
        SearchHits<DemoDO> result = elasticsearchTemplate.search(searchQuery, DemoDO.class);
        Aggregations aggregations = result.getAggregations();
        //获取指定名称的聚合
        Terms terms = aggregations.get("popularBrand");
        //获取桶
        List<? extends Terms.Bucket> buckets = terms.getBuckets();
        //遍历打印
        for (Terms.Bucket bucket : buckets) {
            System.out.println("key = " + bucket.getKeyAsString());
            System.out.println("DocCount = " + bucket.getDocCount());
        }

        //获取指定名称的聚合
        ParsedStringTerms terms1 = aggregations.get("popularBrand1");
        //获取桶
        List<? extends Terms.Bucket> buckets1 = terms1.getBuckets();
        //遍历打印
        for (Terms.Bucket bucket : buckets1) {
            System.out.println("key = " + bucket.getKeyAsString());
            System.out.println("DocCount = " + bucket.getDocCount());
        }
    }

    @Test
    public void sum() {
        SumAggregationBuilder termsAggregationBuilder = AggregationBuilders.sum("popularBrand").field("age");
        nativeSearchQueryBuilder = nativeSearchQueryBuilder.addAggregation(termsAggregationBuilder);
        NativeSearchQuery searchQuery = nativeSearchQueryBuilder.build();
        SearchHits<DemoDO> result = elasticsearchTemplate.search(searchQuery, DemoDO.class);
        Aggregations aggregations = result.getAggregations();
        //获取指定名称的聚合
        Sum terms = aggregations.get("popularBrand");
        //获取桶
        Double buckets = terms.value();
        //遍历打印
        /*for (Terms.Bucket bucket : buckets) {
            System.out.println("key = " + bucket.getKeyAsString());
            System.out.println("DocCount = " + bucket.getDocCount());
        }*/
    }

    @Test
    public void count() {
        System.out.println(repository.count());
    }

    @Test
    public void bulkSave() {
        List<IndexQuery> demoDOList = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            DemoDO demoDO = new DemoDO();
            demoDO.setDevice("phone");
            demoDO.setAge((int) (Math.random() * 10 + 1));
            demoDO.setName(UUID.randomUUID().toString());
            demoDO.setNickName(UUID.randomUUID().toString());
            demoDO.setLastLoginDate(new Date());
            IndexQuery indexQuery = new IndexQueryBuilder().withObject(demoDO).build();
            indexQuery.setObject(demoDO);
            demoDOList.add(indexQuery);
            if (demoDOList.size() == 10000) {
                long start = new Date().getTime();
                IndexCoordinates indexCoordinates = IndexCoordinates.of(DemoDO.INDEX_NAME);
                elasticsearchTemplate.bulkIndex(demoDOList, indexCoordinates);
                logger.info("第" + ((i / 10000) + 1) + "次, 耗时：" + (new Date().getTime() - start));
                demoDOList.clear();
            }
        }
    }

    /**
     * 查询构造器
     *
     * @param queryBuilder es语句
     */
    private void out(QueryBuilder queryBuilder) {
        nativeSearchQueryBuilder = nativeSearchQueryBuilder.withQuery(queryBuilder);
        NativeSearchQuery searchQuery = nativeSearchQueryBuilder.build();
        SearchHits<DemoDO> demoDOList = elasticsearchTemplate.search(searchQuery, DemoDO.class);
        logger.info("总数：" + Objects.requireNonNull(demoDOList.getAggregations()).asList().size());
        for (SearchHit<DemoDO> demoDOSearchHit : demoDOList) {
            DemoDO demoDO = demoDOSearchHit.getContent();
            System.out.println("id: " + demoDO.getId() + " name: " + demoDO.getName() + " age: " + demoDO.getAge() + " nickName: " + demoDO.getNickName());
        }
    }

    @Test
    public void test() {
        QueryBuilder queryBuilder = QueryBuilders.matchPhraseQuery("memberId", "0007c0a59c59f3578b41c96ab5f99ace");
        QueryBuilder queryBuilder1 = QueryBuilders.matchPhraseQuery("year", "2019");
        QueryBuilder queryBuilder2 = QueryBuilders.matchPhraseQuery("month", "10");
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        boolQueryBuilder.must(queryBuilder).must(queryBuilder1).must(queryBuilder2);
        NativeSearchQuery searchQuery = new NativeSearchQuery(boolQueryBuilder);
        SearchHits<DwsLabelDO> dwsLabelDOSearchHits = elasticsearchTemplate.search(searchQuery, DwsLabelDO.class);
        logger.info(String.valueOf(dwsLabelDOSearchHits.getTotalHits()));
        System.out.println(dwsLabelDOSearchHits.getSearchHit(0).getContent().toString());
    }

    @Test
    public void test1() {
//        IdsQueryBuilder idsQueryBuilder = QueryBuilders.idsQuery();
//        Query query = (new NativeSearchQueryBuilder()).withQuery(idsQueryBuilder).build();
        IndexCoordinates indexCoordinates = IndexCoordinates.of("dws_label");
//        elasticsearchTemplate.delete(query, DwsLabelDO.class, indexCoordinates);
        List<IndexQuery> indexQueryList = new ArrayList<>();
        DwsLabelDO dwsLabelDODelete = new DwsLabelDO();
        dwsLabelDODelete.setUserId("0007c0a59c59f3578b41c96ab5f99ace");
        dwsLabelDODelete.setYear("2019");
        dwsLabelDODelete.setMonth("10");
        elasticsearchTemplate.delete(dwsLabelDODelete);
        IndexQuery indexQuery = new IndexQueryBuilder().withObject(dwsLabelDODelete).build();
        indexQueryList.add(indexQuery);

    }
}