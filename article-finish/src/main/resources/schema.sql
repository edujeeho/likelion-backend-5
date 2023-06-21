DROP TABLE IF EXISTS articles;

CREATE TABLE articles
(
    id      INTEGER PRIMARY KEY AUTOINCREMENT,
    writer  TEXT default NULL,
    title   TEXT default NULL,
    content TEXT default NULL
);