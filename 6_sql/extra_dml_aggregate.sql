-- GROUP BY
SELECT COUNT(*) FROM users;
SELECT COUNT(*)
FROM users
WHERE
    age < 30;

SELECT COUNT(*)
FROM users
WHERE
    balance < 110;

SELECT country, AVG(balance)
FROM users
GROUP BY country;

SELECT country, AVG(balance)
FROM users
GROUP BY country;

SELECT country, AVG(balance)
FROM users
GROUP BY country
ORDER BY country ;

SELECT country, AVG(age)
FROM users
GROUP BY country
ORDER BY country;

SELECT country, MIN(age), MAX(age)
FROM users
GROUP BY country
ORDER BY MIN(age);


SELECT age / 10, AVG(balance)
FROM users
GROUP BY age / 10;


