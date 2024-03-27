package com.spring.mvc.chap05.entity;

import com.spring.mvc.chap05.dto.request.BoardWriteRequestDTO;
import lombok.*;

import java.time.LocalDateTime;

/*
 CREATE TABLE tbl_board (
	board_no INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(100) NOT NULL,
    content VARCHAR(2000),
    view_count INT,
    reg_date DATETIME DEFAULT current_timestamp,
    writer VARCHAR(50) NOT NULL
 );
 */
@Setter @Getter @ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Board {

    private int boardNo; // 게시글 번호
    private String title; // 제목
    private String content; // 내용
    private int viewCount; // 조회수
    private LocalDateTime regDate; // 작성일자
    private String writer; // 작성자

    public Board(BoardWriteRequestDTO dto) {
        this.writer = getWriter();
        this.title = getTitle();
        this.content = getContent();
        this.regDate = LocalDateTime.now();
    }
}
