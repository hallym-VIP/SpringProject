package com.example.study;

import com.example.study.data.DbEntity;
import com.example.study.data.JpaCopyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JpaCopyRepositoryImplTest {
    @Autowired
    JpaCopyRepository jpaCopyRepository;

    @Test
    void test(){
        DbEntity testDb = new DbEntity();
        jpaCopyRepository.save(testDb);
        jpaCopyRepository.findAll().forEach(System.out::println);
    }
}
