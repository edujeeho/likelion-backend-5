DROP TABLE IF EXISTS students;

-- 가장 기본적인 CREATE TABLE
CREATE TABLE students (
    id INTEGER,
    username VARCHAR(64),
    first_name VARCHAR(32),
    last_name VARCHAR(32),
    email VARCHAR(100)
);


-- Constraints
-- NOT NULL
DROP TABLE IF EXISTS students;
CREATE TABLE students (
    id INTEGER,
    username VARCHAR(64),
    first_name VARCHAR(32),
    last_name VARCHAR(32),
    email VARCHAR(100) NOT NULL
);

-- UNIQUE
DROP TABLE IF EXISTS students;
CREATE TABLE students (
    id INTEGER,
    username VARCHAR(64) UNIQUE,
    first_name VARCHAR(32),
    last_name VARCHAR(32),
    email VARCHAR(100)
);

-- PRIMARY KEY
DROP TABLE IF EXISTS students;
CREATE TABLE students (
    id INTEGER PRIMARY KEY,  -- NOT NULL이 암시적으로 적용됨
    username VARCHAR(64),
    first_name VARCHAR(32),
    last_name VARCHAR(32),
    email VARCHAR(100)
);

-- PRIMARY KEY AUTOINCREMENT
DROP TABLE IF EXISTS students;
CREATE TABLE students (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    username VARCHAR(64),
    first_name VARCHAR(32),
    last_name VARCHAR(32),
    email VARCHAR(100)
);

-- FINAL
DROP TABLE IF EXISTS students;
CREATE TABLE students (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    username VARCHAR(64) UNIQUE ,
    first_name VARCHAR(32),
    last_name VARCHAR(32),
    email VARCHAR(128) NOT NULL
);

-- sqlite rowid

-- ALTER TABLE
ALTER TABLE students RENAME TO students_backup;
ALTER TABLE students_backup RENAME TO students;

-- ALTER TABLE RENAME COLUMN
ALTER TABLE students RENAME COLUMN first_name to given_name;
ALTER TABLE students RENAME COLUMN last_name to sur_name;

-- ALTER TABLE ADD COLUMN
ALTER TABLE students ADD COLUMN address VARCHAR(256);
ALTER TABLE students ADD COLUMN phone VARCHAR(128) NOT NULL;  -- potential problem
ALTER TABLE students ADD COLUMN phone VARCHAR(128) NOT NULL DEFAULT '';  -- DEFAULT
ALTER TABLE students ADD COLUMN phone VARCHAR(128) UNIQUE;  -- SQLITE Not Supported

-- ALTER TABLE DROP COLUMN
ALTER TABLE students DROP COLUMN phone;

-- DROP TABLE
DROP TABLE students;
DROP TABLE IF EXISTS students;
