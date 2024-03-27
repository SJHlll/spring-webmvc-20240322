package com.spring.mvc.chap05.repository;

// 게시판 CRUD 기능 명세

import com.spring.mvc.chap05.entity.Board;

import java.util.List;

public interface BoardRepository {

    // 목록 조회
    List<Board> findAll();


    // 상세 조회
    Board fineOne(int boardNo);


    // 게시물 등록
    void save(Board board);


    // 게시물 삭제
    boolean delete(int boardNo);


}
