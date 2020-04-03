package com.elasticsearch.demo.service.impl;

import com.elasticsearch.demo.dataobject.DemoDO;
import com.elasticsearch.demo.repository.DemoRepository;
import com.elasticsearch.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    private DemoRepository demoRepository;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void demo() {
        DemoDO demoDO = new DemoDO();
        demoDO.setDevice("phone");
        demoDO.setLastLoginDate(new Date());
        demoDO.setName("李小熊");
        demoDO.setNickName("小熊");
        demoDO.setAge((int) (Math.random() * 10 + 1));
        // 增
        demoDO = demoRepository.save(demoDO);
        // 总数
        long count = demoRepository.count();
        System.out.println(count);
        // 查
        Optional<DemoDO> optional = demoRepository.findById(demoDO.getId());
        if (optional.isPresent()) {
            demoDO = optional.get();
        } else {
            return;
        }
        System.out.println(demoDO);
        // 改
        demoDO.setName(UUID.randomUUID().toString());
        demoDO = demoRepository.save(demoDO);
        System.out.println(demoDO);
        // 删
//        demoRepository.deleteById(demoDO.getId());
//        demoRepository.deleteAll();
    }
}
