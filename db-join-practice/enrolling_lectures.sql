DROP TABLE IF EXISTS enrolling_lectures;
CREATE TABLE enrolling_lectures (
  lecture_id mediumint default NULL,
  student_id mediumint default NULL
);

INSERT INTO enrolling_lectures (lecture_id,student_id)
VALUES
    (2,16),
    (10,5),
    (5,18),
    (3,10),
    (8,15),
    (8,1),
    (7,18),
    (2,18),
    (3,13),
    (8,13),
    (10,12),
    (3,4),
    (4,6),
    (8,10),
    (5,19),
    (7,10),
    (4,8),
    (2,17),
    (9,8),
    (5,4);
