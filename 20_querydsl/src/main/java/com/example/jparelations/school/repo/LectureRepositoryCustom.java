package com.example.jparelations.school.repo;

import com.example.jparelations.school.entity.Lecture;

import java.util.List;

// JpaRepository 와 Querydsl 을 같이 활용하고 싶을때 택할만한 방법.
// 추가하고 싶은 조회 기능을 나타내는 메소드를 만들고, 구현 클래스를 만든다 (LectureRepositoryCustomImpl 에서 계속)
// 주의할 점은 이름을 달리하면 안된다. <Entity>RepositoryCustom 이어야 한다.
// 이는 구현 클래스도 마찬가지.
public interface LectureRepositoryCustom {
    List<Lecture> lectureByTime(String day, Integer startTime, Integer endTime);
}
