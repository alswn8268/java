-- ������ �ʱ�ȭ ���
-- ��� �����͸� �����ϰ� �������� ����� �ٽ� �����.
DELETE FROM guestbook;
DROP sequence guestbook_idx_seq;

-- �ڵ����� 1�� ������Ű�� ���� �������� �����.
CREATE SEQUENCE guestbook_idx_seq;

SELECT * FROM guestbook;
insert into guestbook (idx, name, password, memo, ip) values (guestbook_idx_seq.nextval, 'ȫ�浿', '1111', '�ȳ��ϼ���?', '192.168.0.127');
insert into guestbook (idx, name, password, memo, ip) values (guestbook_idx_seq.nextval, '�Ӳ���', '2222', '�ƴ�', '192.168.0.17');
insert into guestbook (idx, name, password, memo, ip) values (guestbook_idx_seq.nextval, '����', '3333', '�׷�����.', '192.168.0.1');
insert into guestbook (idx, name, password, memo, ip) values (guestbook_idx_seq.nextval, '������', '4444', '�����մϴ�.', '192.168.0.7');