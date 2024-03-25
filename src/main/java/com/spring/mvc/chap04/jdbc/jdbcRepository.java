package com.spring.mvc.chap04.jdbc;

import com.spring.mvc.chap04.entity.Person;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class jdbcRepository {

    // db 연결 설정 정보 (한 번 세팅해 놓으면 두고두고 쓰기 때문에 외우지 마세요.)
    private String url = "jdbc:mysql://localhost:3306/spring_db?serverTimezone=Asia/Seoul"; // DB url 주소
    private String username = "spring"; // 계정명
    private String password = "spring"; // 비밀번호


    // JDBC 드라이버 로딩
    // 자바 프로그램과 데이터베이스 간의 객체가 드나들 길을 뚫는다 생각


    public jdbcRepository() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


    // 데이터베이스 커넥션 얻기 (Connection 객체 얻기 -> 데이터베이스 접속을 담당하는 객체)
    public Connection getConnection() throws SQLException {
        // 위에 준비한 URL, username, password를 전달해서 DB 접속을 전달하는 Connection을 받아오기
        return DriverManager.getConnection(url, username, password);
    }

    // INSERT 기능 -> 테스트 클래스에 테스트할거임
    public void save(Person person) {

        Connection con = null;

        // 1. DB 연결하고 연결 정보를 얻어와야 함
        try {
            con = getConnection();

            // 2. 트랜잭션 시작
            con.setAutoCommit(false); // 자동 커밋 비활성화

            // 3. 실행할 SQL 완성
            // 들어갈 값이 위치할 곳에 ?를 채워준다
            String sql = "INSERT INTO person (person_name, person_age) " +
                    "VALUES (?, ?)";

            // 4. SQL을 실행시켜주는 객체를 얻어온다
            // prepareStatement의 매개값으로 미완성된 sql을 전달
            PreparedStatement pstmt = con.prepareStatement(sql);

            // 5. ? 채우기 (순서, 값의 타입 고려)
            // ? 채울 때 지목하는 인덱스는 1번부터
            pstmt.setString(1, person.getPersonName());
            pstmt.setInt(2, person.getPersonAge());

            // 6. SQL 실행 명령
            // INSERT, UPDATE, DELETE - executeUpdate();
            // SELECT - executeQuery();
            int result = pstmt.executeUpdate(); // 리턴값은 성공한 쿼리문의 개수

            // 7. 트랜잭션 처리
            if (result == 1) con.commit();
            else con.rollback();


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 8. 접속 해제
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}














