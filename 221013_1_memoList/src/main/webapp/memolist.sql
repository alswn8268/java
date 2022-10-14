SELECT * FROM memolist;
SELECT * FROM memolist ORDER BY idx DESC;
SELECT * FROM memolist ORDER BY idx DESC LIMIT 10, 11;
SELECT * FROM memolist WHERE idx = 1;

INSERT INTO memolist(NAME, PASSWORD, memo, ip) VALUES ('홍길동', '1111', '안녕하세요~~', '192.168.0.7');
INSERT INTO memolist(NAME, PASSWORD, memo, ip) VALUES ('임꺽정', '2222', '안녕히가세요~~', '192.168.0.6');
INSERT INTO memolist(NAME, PASSWORD, memo, ip) VALUES ('장길산', '3333', '감사합니다~~', '192.168.0.5');
INSERT INTO memolist(NAME, PASSWORD, memo, ip) VALUES ('일지매', '4444', '천만에요~~', '192.168.0.4');

DELETE FROM memolist;
ALTER TABLE memolist AUTO_INCREMENT = 1;
SELECT COUNT(*) FROM memolist;