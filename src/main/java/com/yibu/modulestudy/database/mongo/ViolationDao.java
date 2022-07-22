package com.yibu.modulestudy.database.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

/**
 * @program: module-study
 * @description: 违章DAO
 * @packagename: com.yibu.modulestudy.database.mongo
 * @author: 振振
 * @date: 2022-07-19 17:27
 **/
@Repository
public class ViolationDao {
    @Autowired
    private MongoTemplate mongoTemplate;

    public Long count() {
        return mongoTemplate.count(new Query(), ViolationPO.class);
    }
}
