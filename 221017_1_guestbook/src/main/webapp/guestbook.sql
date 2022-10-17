-- 시퀀스 초기화 방법
-- 모든 데이터를 제거하고 시퀀스를 지우고 다시 만든다.
DELETE FROM guestbook;
DROP sequence guestbook_idx_seq;

-- 자동으로 1씩 증가시키기 위해 시퀀스를 만든다.
CREATE SEQUENCE guestbook_idx_seq;

SELECT * FROM guestbook;
insert into guestbook (idx, name, password, memo, ip) values (guestbook_idx_seq.nextval, '홍길동', '1111', '안녕하세요?', '192.168.0.127');
insert into guestbook (idx, name, password, memo, ip) values (guestbook_idx_seq.nextval, '임꺽정', '2222', '아뇨', '192.168.0.17');
insert into guestbook (idx, name, password, memo, ip) values (guestbook_idx_seq.nextval, '장길산', '3333', '그렇군요.', '192.168.0.1');
insert into guestbook (idx, name, password, memo, ip) values (guestbook_idx_seq.nextval, '일지매', '4444', '감사합니다.', '192.168.0.7');