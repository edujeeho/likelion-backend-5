DROP TABLE IF EXISTS articles;

CREATE TABLE articles
(
    id      INTEGER PRIMARY KEY AUTOINCREMENT,
    writer  TEXT default NULL,
    title   TEXT default NULL,
    content TEXT default NULL
);

DROP TABLE IF EXISTS comments;

CREATE TABLE comments (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    writer TEXT DEFAULT NULL,
    content TEXT DEFAULT NULL,
    article_id INTEGER DEFAULT NULL
);