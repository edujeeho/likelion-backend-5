-- SELECT
SELECT first_name, age FROM users;
SELECT last_name, phone, email FROM users;
SELECT * FROM users;

-- SELECT ORDER BY
SELECT * FROM users ORDER BY age;
SELECT * FROM users ORDER BY age, first_name;
SELECT * FROM users ORDER BY age DESC, first_name;

-- SELECT DISTINCT
SELECT DISTINCT age FROM users ORDER BY age;
SELECT DISTINCT first_name FROM users ORDER BY first_name;
SELECT DISTINCT first_name, last_name FROM users;
SELECT DISTINCT country FROM users ORDER BY country;

-- SELECT WHERE
SELECT first_name FROM users WHERE age < 30;
SELECT first_name, last_name FROM users WHERE age >= 30;
SELECT first_name, age, balance FROM users WHERE balance < 150;
SELECT first_name, last_name, age FROM users WHERE age < 30 and balance > 180;

-- SELECT WHERE LIKE
SELECT first_name FROM users WHERE email LIKE '%naver.com';
SELECT last_name, email FROM users WHERE email LIKE '%q%';
SELECT phone FROM users WHERE phone LIKE '010-%';
SELECT phone FROM users WHERE NOT phone LIKE '010-%';
SELECT last_name FROM users WHERE last_name LIKE '%''%';
SELECT last_name FROM users WHERE last_name LIKE 'O%';
SELECT first_name FROM users WHERE first_name LIKE 'R%';
SELECT first_name, last_name, phone FROM users WHERE phone LIKE '010-%';
SELECT first_name, last_name FROM users WHERE age < 30;
SELECT first_name, last_name, phone FROM users WHERE phone LIKE '%-5%3-%';

-- SELECT WHERE IN

SELECT first_name, last_name
FROM users
WHERE
    last_name IN ('Ashley', 'Briggs', 'Mcintyre');

SELECT first_name, last_name, country
FROM users
WHERE
    country IN ('United States', 'Canada', 'Mexico');

SELECT first_name, last_name, country
FROM users
WHERE
    country NOT IN ('Italy', 'France', 'Germany', 'United Kingdom', 'Spain')
ORDER BY
    country;


-- SELECT WHERE BETWEEN
SELECT first_name, last_name
FROM users
WHERE
    age BETWEEN 30 AND 40;

SELECT first_name, last_name
FROM users
WHERE
    age NOT BETWEEN 20 AND 40;

-- SELECT LIMIT
SELECT id, first_name, last_name
FROM users
WHERE age < 40
LIMIT 10 OFFSET 10;

SELECT id, first_name, last_name
FROM users
WHERE age < 30
LIMIT 20 OFFSET 85;

SELECT id, first_name, age
FROM users
WHERE
    age > 40 OR
    balance > 180
ORDER BY
    age
LIMIT 20;

SELECT id, first_name, age
FROM users
ORDER BY age DESC
LIMIT 50;
