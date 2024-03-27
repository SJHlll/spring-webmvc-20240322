package com.spring.mvc.chap05.dto.request;

import lombok.*;

import java.time.LocalDateTime;

@Setter @Getter @ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class BoardWriteRequestDTO {

    private String title, content, writer;
//    private int boardNo, viewCount;
//    private LocalDateTime regDate;

}


/*
    private int boardNo; // 게시글 번호
    private String title; // 제목
    private String content; // 내용
    private int viewCount; // 조회수
    private LocalDateTime regDate; // 작성일자
    private String writer; // 작성자
 */