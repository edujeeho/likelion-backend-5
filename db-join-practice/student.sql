DROP TABLE IF EXISTS student;

CREATE TABLE student (
  id integer primary key autoincrement ,
  first_name varchar(255) default NULL,
  last_name varchar(255) default NULL,
  advisor_id integer
);

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
