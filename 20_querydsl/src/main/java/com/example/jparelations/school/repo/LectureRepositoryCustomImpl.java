package com.example.jparelations.school.repo;

import com.example.jparelations.school.entity.Lecture;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.util.StringUtils;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.example.jparelations.school.entity.QLecture.lecture;


@RequiredArgsConstructor
// 구현 클래스는 그냥 만든다. Bean 객체로 등록할 필요 없다.
// JpaRepository 의 상속 인터페이스 처럼
// Spring Boot Data JPA 가 잘 할당해 준다.
public class LectureRepositoryCustomImpl implements LectureRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    /*
    @Override
    public List<Lecture> lectureByTime(String day, Integer startTime, Integer endTime) {
        return queryFactory
                .selectFrom(lecture)
                .where(lecture.day.eq(day))
                .fetch();
    }
     */

    /*
    @Override
    public List<Lecture> lectureByTime(
            String day,
            Integer startTime,
            Integer endTime
    ) {
        // BooleanBuilder로 동적 쿼리 구성
        // day, startTime, endTime을 기준으로, 전달되는 값이 존재하면
        // 해당 데이터를 바탕으로 조회를 진행한다.
        BooleanBuilder builder = new BooleanBuilder();
        if (!StringUtils.isNullOrEmpty(day)) {
            // and 조건, 즉 모두 만족해야 한다.
            builder.and(lecture.day.eq(day));
        }
        if (startTime != null) {
            builder.and(lecture.startTime.eq(startTime));
        }
        if (endTime != null) {
            builder.and(lecture.endTime.eq(endTime));
        }
        // 하나의 빌더를 이용해 전달해야 되서, 복잡해질 경우
        // 조회 조건이 눈에 잘 안들어올 가능성이 높아진다.
        return queryFactory
                .selectFrom(lecture)
                .where(builder)
                .fetch();
    }
     */

    @Override
    // 나중에 실제로 실행되는 메소드이다.
    public List<Lecture> lectureByTime(
            String day,
            Integer startTime,
            Integer endTime
    ) {
        return queryFactory
                .selectFrom(lecture)
                .where(
                        // BooleanExpression 여러개를 엮으면
                        // 모든 조건을 만족하는 데이터를 조회한다.
                        eqDay(day),
                        eqStartTime(startTime),
                        eqEndTime(endTime)
                ).fetch();
    }

    // Boolean Expression 하나가 하나의 조건을 의미한다.
    private BooleanExpression eqDay(String day) {
        // null 조건은 무시한다.
        if (StringUtils.isNullOrEmpty(day)) {
            return null;
        }
        return lecture.day.eq(day);
    }

    // 즉 사용자의 입력에 따라 조회되는 방식이 달라질 수 있다.
    private BooleanExpression eqStartTime(Integer startTime) {
        if (startTime == null) {
            return null;
        }
        return lecture.startTime.eq(startTime);
    }

    private BooleanExpression eqEndTime(Integer endTime) {
        if (endTime == null) {
            return null;
        }
        return lecture.startTime.eq(endTime);
    }
}
