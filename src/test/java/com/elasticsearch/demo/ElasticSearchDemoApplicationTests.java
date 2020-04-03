package com.elasticsearch.demo;

import com.elasticsearch.demo.dataobject.DemoDO;
import com.elasticsearch.demo.repository.DemoRepository;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.bucket.terms.ParsedStringTerms;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@SpringBootTest
class ElasticSearchDemoApplicationTests {
    @Autowired
    private ElasticsearchRestTemplate elasticsearchTemplate;
    @Autowired
    private DemoRepository repository;

    private NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder().withIndices("demo");

    /**
     * 分词查询
     */
    @Test
    public void fuzzyQuery() {
        QueryBuilder queryBuilder = QueryBuilders.matchQuery("name", "ae4be7fb");
        out(queryBuilder);
    }

    /**
     * 精确查询
     */
    @Test
    public void query() {
        QueryBuilder queryBuilder = QueryBuilders.matchPhraseQuery("name.keyword", "ae4be7fb-983e-429f-bd73-162b28bcf800");
        out(queryBuilder);
    }

    /**
     * 查询所有
     */
    @Test
    public void queryAll() {
        QueryBuilder queryBuilder = QueryBuilders.matchAllQuery();
        out(queryBuilder);
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
        QueryBuilder queryBuilder = QueryBuilders.termQuery("name.keyword", "cc09c406-df37-4a48-9265-a8bcc2d756e3");
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

    @Test
    public void aggQuery() {
        TermsAggregationBuilder termsAggregationBuilder = AggregationBuilders.terms("popularBrand").field("name.keyword");
        TermsAggregationBuilder termsAggregationBuilder1 = AggregationBuilders.terms("popularBrand1").field("nickName.keyword");
        nativeSearchQueryBuilder = nativeSearchQueryBuilder.addAggregation(termsAggregationBuilder).addAggregation(termsAggregationBuilder1);
        SearchQuery searchQuery = nativeSearchQueryBuilder.build();
        AggregatedPage<DemoDO> result = elasticsearchTemplate.queryForPage(searchQuery, DemoDO.class);
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
    public void deleteAll() {
        repository.deleteAll();
    }

    @Test
    public void count() {
        System.out.println(repository.count());
    }

    @Test
    public void save() {
        DemoDO demoDO = new DemoDO();
        demoDO.setDevice("phone");
        demoDO.setAge((int) (Math.random() * 10 + 1));
        demoDO.setName(UUID.randomUUID().toString());
        demoDO.setNickName(UUID.randomUUID().toString());
        demoDO.setLastLoginDate(new Date());
        repository.save(demoDO);
    }

    @Test
    public void bulkSave() {
        List<IndexQuery> demoDOList = new ArrayList<>();
        for (int i = 0; i < 100000000; i++) {
            DemoDO demoDO = new DemoDO();
            demoDO.setDevice("phone");
            demoDO.setAge((int) (Math.random() * 10 + 1));
            demoDO.setName(UUID.randomUUID().toString());
            demoDO.setNickName(UUID.randomUUID().toString());
            demoDO.setLastLoginDate(new Date());
            IndexQuery indexQuery = new IndexQuery();
            indexQuery.setObject(demoDO);
            demoDOList.add(indexQuery);
            if (demoDOList.size() == 100000) {
                elasticsearchTemplate.bulkIndex(demoDOList);
//                elasticsearchTemplate.refresh(DemoDO.class);
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
        nativeSearchQueryBuilder = nativeSearchQueryBuilder.withFilter(queryBuilder);
        SearchQuery searchQuery = nativeSearchQueryBuilder.build();
        List<DemoDO> demoDOList = elasticsearchTemplate.queryForList(searchQuery, DemoDO.class);
        for (DemoDO demoDO : demoDOList) {
            System.out.println("id: " + demoDO.getId() + " name: " + demoDO.getName());
        }
    }

}
