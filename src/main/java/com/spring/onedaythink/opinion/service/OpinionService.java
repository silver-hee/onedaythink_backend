package com.spring.onedaythink.opinion.service;

import com.spring.onedaythink.opinion.vo.Opinion;

public interface OpinionService {


    // 의견 전체 조회
    // => 내가 좋아요 누를 의견 조회(동적쿼리)

    // 특정 의견 좋아요 조작(생성/삭제)

    // 나의 의견 전체 조회

    // 나의 의견 조회

    // 오늘의 나의 의견 조회
    Opinion getTodayOpinion(Opinion opinion);

    // 나의 의견 생성
    int addOpinions(Opinion opinion);
    // 나의 의견 수정

    // 나의 의견 삭제
}
