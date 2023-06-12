-- INSERT
INSERT INTO users(first_name, last_name, age, balance, phone, email, country)
VALUES ('jeeho', 'park', 99, 100, '010-1111-2222', 'jeeho@gmail.com', 'South Korea');

-- UPDATE
UPDATE users
SET phone = '010-1111-1111',
    age = 5
WHERE first_name = 'jeeho';
-- WHERE가 없을 경우 모든 데이터가 업데이트 된다
UPDATE users
SET phone = '010-1111-1111',
    age = 50;

-- DELETE
DELETE FROM users
WHERE first_name = 'jeeho';
-- WHERE가 없을 경우 모든 데이터가 삭제된다.
DELETE FROM users;

