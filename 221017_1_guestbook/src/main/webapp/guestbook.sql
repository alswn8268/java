-- 시퀀스 초기화 방법
-- 모든 데이터를 제거하고 시퀀스를 지우고 다시 만든다.
DELETE FROM guestbook;
DROP sequence guestbook_idx_seq;

-- 자동으로 1씩 증가시키기 위해 시퀀스를 만든다.
CREATE SEQUENCE guestbook_idx_seq;

SELECT * FROM guestbook;
SELECT count(*) FROM guestbook;

insert into guestbook (idx, name, password, memo, ip) values (guestbook_idx_seq.nextval, '홍길동', '1111', '안녕하세요?', '192.168.0.127');
insert into guestbook (idx, name, password, memo, ip) values (guestbook_idx_seq.nextval, '임꺽정', '2222', '아뇨', '192.168.0.17');
insert into guestbook (idx, name, password, memo, ip) values (guestbook_idx_seq.nextval, '장길산', '3333', '그렇군요.', '192.168.0.1');
insert into guestbook (idx, name, password, memo, ip) values (guestbook_idx_seq.nextval, '일지매', '4444', '감사합니다.', '192.168.0.7');

-- 트랜잭션: 한 번에 모두 실행되어야 할 명령의 집합
-- COMMIT: 트랜잭션이 모두 정상적으로 처리되어서 결과를 데이터베이스에 반영한다.
-- ROLLBACK: 트랜잭션이 모두 정상적으로 처리되지 않았을 경우 최초 실행 상태 이전으로 되돌린다.
-- ORACLE DEVELOPER는 AUTO COMMIT이 지원되지 않아, DEVELOPER에서 진행한 작업이 jsp에 적용되게 하려면 COMMIT을 실행해야 한다.
COMMIT;

-- 트리거: 이벤트가 실행되면 저절로 발동하는 절차형 SQL