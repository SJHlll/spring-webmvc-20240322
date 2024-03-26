package com.spring.mvc.chap04.jdbc;

import com.spring.mvc.chap04.entity.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class JdbcRepositoryTest {

    @Autowired
    JdbcRepository repository;

    @Test
    @DisplayName("Person 객체 정보를 DB에 정상 삽입하기")
    void saveTest() {
        Person p = new Person(0, "민식이", 22);

        repository.save(p);
    }

    @Test
    @DisplayName("id가 2인 회원의 이름과 나이 수정하기")
    void updateTest() {
        // given : 테스트를 위해 데이터를 세팅
        int id = 2;
        String newName = "개구리";
        int newAge = 15;
        Person p  = new Person(id, newName, newAge);

        // when : 테스트 목표를 확인해 실제 테스트가 진행되는 구간
        repository.update(p);

        // then : 테스트 결과를 확인하는 구간 (단언 기법 -> Assertion)

    }

    @Test
    @DisplayName("회원번호가 1인 회원을 삭제하기")
    void deleteTest() {

        repository.delete(1);

    }


    @Test
    @DisplayName("더미 데이터 10개 만들기")
    void vulkInsert() {
        for (int i = 0; i < 10; i++) {
            Person p = new Person(0, "하나둘셋" + i, i + 10);
            repository.save(p);
        }
    }


    @Test
    @DisplayName("전체 회원을 조회하면 회원 리스트의 사이즈는 14일 것이다")
    void findAllTest() {
        List<Person> people = repository.findAll();

        for (Person person : people) {
            System.out.println(person);
        }

        // people.size()가 14와 같을 것이다
        Assertions.assertEquals(14, people.size());
        assertNotNull(people);

    }

    @Test
    @DisplayName("특정 아이디 회원을 조회하면 하나의 회원만 조회, 없는 아이디를 전달하면 null이 리턴됨")
    void findOneTest() {
        int id = 6;

        Person p = repository.findOne(id);
        System.out.println(p);

        assertNotNull(p);




    }


}