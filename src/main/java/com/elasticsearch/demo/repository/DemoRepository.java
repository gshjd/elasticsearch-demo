package com.elasticsearch.demo.repository;

import com.elasticsearch.demo.dataobject.DemoDO;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface DemoRepository extends ElasticsearchRepository<DemoDO, String> {
}
