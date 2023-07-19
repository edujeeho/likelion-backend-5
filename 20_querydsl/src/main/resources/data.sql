INSERT INTO instructor (first_name,last_name)
VALUES
    ('Vivien','Moran'),
    ('Tanisha','Gordon'),
    ('Sharon','Harrell'),
    ('Christopher','Mcclain'),
    ('Edan','Brian'),
    ('Plato','Best'),
    ('Uriah','Nguyen'),
    ('Jesse','Romero'),
    ('Nehru','Huff'),
    ('Jolene','Roach');

INSERT INTO lecture (name,day,start_time,end_time,instructor_id)
VALUES
    ('Nullam vitae','mon',12,13,2),
    ('dictum magna.','fri',12,12,9),
    ('Aenean gravida','thu',9,14,5),
    ('Curabitur sed','fri',11,14,2),
    ('ligula eu','fri',9,14,6),
    ('accumsan neque','tue',9,13,6),
    ('nulla. Donec','thu',12,14,2),
    ('dignissim pharetra.','tue',9,14,3),
    ('nibh dolor,','tue',12,12,4),
    ('gravida molestie','tue',11,13,7);

INSERT INTO student (first_name,last_name)
VALUES
    ('Leo','Kaufman'),
    ('Damon','Holder'),
    ('Angela','Cross'),
    ('Marsden','Gay'),
    ('Georgia','Martinez');

INSERT INTO student (first_name,last_name, advisor_id)
VALUES
    ('Octavius','Mckay', 1),
    ('Rigel','Guy', 1),
    ('Lionel','Battle', 1),
    ('Tiger','Mooney', 2),
    ('Sade','Watkins', 2),
    ('Kelly','Daniel', 2),
    ('Armando','Simon', 3),
    ('Gregory','Strong', 4),
    ('Rogan','Aguilar', 4),
    ('Vaughan','May', 5),
    ('Rhona','Elliott', 5),
    ('Kay','Wise', 7),
    ('Darrel','Mcbride', 9),
    ('Rhea','Gaines', 9),
    ('Leonard','Giles', 10);

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
