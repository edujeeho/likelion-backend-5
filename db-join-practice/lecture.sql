DROP TABLE IF EXISTS lecture;
CREATE TABLE lecture (
  id integer primary key autoincrement ,
  name TEXT default NULL,
  day TEXT default NULL,
  start_time mediumint default NULL,
  end_time mediumint default NULL,
  instructor_id mediumint default NULL
);

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
