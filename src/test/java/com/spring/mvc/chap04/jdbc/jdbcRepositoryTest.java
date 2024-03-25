package com.spring.mvc.chap04.jdbc;

import com.spring.mvc.chap04.entity.Person;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class jdbcRepositoryTest {

    @Autowired
    jdbcRepository repository;

    @Test
    @DisplayName("Person 객체 정보를 DB에 정상 삽입하기")
    void saveTest() {
        Person p = new Person(2, "라이언", 25);

        repository.save(p);
    }

}