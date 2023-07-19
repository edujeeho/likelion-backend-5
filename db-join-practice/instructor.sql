DROP TABLE IF EXISTS instructor;

CREATE TABLE instructor (
  id integer primary key autoincrement,
  first_name varchar(255) default NULL,
  last_name varchar(255) default NULL
);

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
