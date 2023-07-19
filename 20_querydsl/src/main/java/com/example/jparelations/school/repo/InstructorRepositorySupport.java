package com.example.jparelations.school.repo;

import com.example.jparelations.school.entity.Instructor;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.jparelations.school.entity.QInstructor.instructor;

// 평범하게 Querydsl 만 사용할때 활용할만한 방법.
// 하나의 Entity 에 대해서 추가 기능(페이징 등)이 적용된
// RepositorySupport
@Repository
public class InstructorRepositorySupport extends QuerydslRepositorySupport {
    private final JPAQueryFactory queryFactory;

    public InstructorRepositorySupport(JPAQueryFactory queryFactory) {
        super(Instructor.class);
        this.queryFactory = queryFactory;
    }

    // first_name을 기준으로 조회하는 Querydsl식 조회
    public List<Instructor> findByFirstName(String name) {
        /*
        SELECT * FROM instructor WHERE first_name = name
         */
        return queryFactory
                .selectFrom(instructor)
                // 어떤 테이블의 레코드의 어떤 컬럼이 무엇과 일치하는지
                .where(instructor.firstName.eq(name))
                .fetch();
    }

    public List<Instructor> findByFirstNameOrLastName(String name) {
        /*
        SELECT * FROM instructor WHERE first_name = name OR last_name = name
         */
        return queryFactory
                .selectFrom(instructor)
                // 어떤 테이블의 레코드의 어떤 컬럼이 무엇과 일치하는지
                .where(instructor.firstName.eq(name)
                        .or(instructor.lastName.eq(name)))
                .fetch();
    }
}
