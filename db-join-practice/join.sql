-- CROSS JOIN
SELECT *
FROM instructor CROSS JOIN lecture;

SELECT *
FROM lecture, student;

SELECT *
FROM lecture, instructor
WHERE lecture.instructor_id = instructor.id;

-- INNER JOIN
SELECT *
FROM lecture INNER JOIN instructor
    ON lecture.instructor_id = instructor.id;

SELECT *
FROM student INNER JOIN instructor
    ON student.advisor_id = instructor.id;

SELECT *
FROM student INNER JOIN enrolling_lectures
    ON student.id = enrolling_lectures.student_id;

-- INNER 생략
SELECT *
FROM lecture JOIN instructor
    ON lecture.instructor_id = instructor.id;


-- OUTER JOIN
SELECT *
FROM instructor LEFT OUTER JOIN student
    ON instructor.id = student.advisor_id;

SELECT *
FROM instructor LEFT OUTER JOIN lecture
    ON instructor.id = lecture.instructor_id;

SELECT *
FROM lecture RIGHT OUTER JOIN instructor
    ON lecture.instructor_id = instructor.id;

SELECT *
FROM student FULL OUTER JOIN instructor
    ON student.advisor_id = instructor.id;

SELECT *
FROM instructor LEFT JOIN lecture
    ON instructor.id = lecture.instructor_id;

SELECT *
FROM lecture RIGHT JOIN instructor
    ON lecture.instructor_id = instructor.id;

SELECT *
FROM student FULL JOIN instructor
    ON student.advisor_id = instructor.id;

-- MANY TO MANY
SELECT *
FROM student
    INNER JOIN enrolling_lectures
        ON student.id = enrolling_lectures.student_id
    INNER JOIN lecture
        ON enrolling_lectures.lecture_id = lecture.id;


SELECT *
FROM student
    LEFT OUTER JOIN enrolling_lectures
        ON student.id = enrolling_lectures.student_id
    LEFT OUTER JOIN lecture
        ON enrolling_lectures.lecture_id = lecture.id;


SELECT *
FROM lecture
    LEFT OUTER JOIN enrolling_lectures
        ON lecture.id = enrolling_lectures.lecture_id
    LEFT OUTER JOIN student
        ON enrolling_lectures.student_id = student.id;



-- 화요일에 강의를 하는 교수님들만 뽑아보자
SELECT lecture.name, lecture.day, instructor.first_name, instructor.last_name
FROM lecture INNER JOIN instructor
    ON lecture.instructor_id = instructor.id
WHERE lecture.day = 'tue';

SELECT l.name, l.day, i.first_name, i.last_name
FROM lecture as l INNER JOIN instructor i
    ON l.instructor_id = i.id
WHERE l.day = 'tue';

SELECT count(*) as lecture_count, i.first_name, i.last_name
FROM lecture l LEFT JOIN instructor i on l.instructor_id = i.id
GROUP BY i.id;


-- subquery
SELECT s.id AS student_id,
       s.first_name,
       s.last_name,
       subquery.name
FROM student s
 JOIN (
     SELECT el.student_id, l.name
     FROM enrolling_lectures el
      JOIN lecture l on el.lecture_id = l.id
     WHERE l.instructor_id = 2
) subquery ON s.id = subquery.student_id
ORDER BY s.id;

SELECT s.id AS student_id,
       s.first_name,
       s.last_name
FROM student s
WHERE s.id IN (
    SELECT el.student_id
    FROM enrolling_lectures el
     JOIN lecture l on el.lecture_id = l.id
     JOIN instructor i on i.id = l.instructor_id
    WHERE i.id = 2
);
