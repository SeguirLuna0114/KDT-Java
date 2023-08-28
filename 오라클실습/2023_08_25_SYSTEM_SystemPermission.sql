-- 2023. 08. 25(��)

-- �����ͺ��̽� ������ ���� ����
-- 1. �ý��� ����
-- 2. ��ü ����

-- 1. �ý��� ���� : �����ͺ��̽� ������(DBA)�� ���� �ִ� ����
--  ex) create user, drop user...

-- �ý��� �����ڰ� �Ϲ� ����ڿ��� �ο��ؾ� �ϴ� ����
--  CREATE SESSION: �����ͺ��̽� ���� ����
--  CREATE TABLE : ���̺��� ������ �� �ִ� ����
--  CREATE VIEW : �並 ������ �� �ִ� ����
--  CREATE SEQUENCE : �������� ������ �� �ִ� ����
--  CREATE PROCEDURE : ���ν����� ������ �� �ִ� ����

-- ���ο� ���� ����    : user01 / tiger
CREATE USER user01 IDENTIFIED BY tiger;

-- ������ ���� ��� Ȯ��
SELECT * FROM dba_users;

-- user01 �������� �����ͺ��̽� ���� ������ �ο� : create session
GRANT CREATE SESSION TO user01;

-- ���̺� ���� ���� �ο� : CREATE TABLE
GRANT CREATE SESSION, CREATE TABLE TO user01;


-- with admin option
--  : grant������� ������ �ο����� ��, with admin option�� �ٿ���
--    ������ �ο��Ǹ�, ������ �ο����� ������ �ڱⰡ �ο����� ������
--    �� 3�� �������� �� �ο��� �� ����

-- 1. ���ο� ���� ����    : user02 / tiger
CREATE USER user02 IDENTIFIED BY tiger;

-- 2. user02 �������� �����ͺ��̽� ���� ������ �ο� : create session
GRANT CREATE SESSION TO user02 WITH ADMIN OPTION;

-- 3. ��3�� ���� ����     : user03/tiger
CREATE USER user03 IDENTIFIED BY tiger;

-- 4. user01�������� ���� �� user03 �������� create session ���� �ο�
SQL> conn user01/tiger
SQL> grant create session to user03;    -- ���� �߻�
    -- ORA-01031: insufficient privileges
    
-- 5. user02�������� ���� �� user03 �������� create session ���� �ο�
SQL> conn user02/tiger
SQL> grant create session to user03;     -- create session ���� �ο�O  

-- 6. user03������ user02�������κ��� create session������ �ο��޾ұ⿡
--    �����ͺ��̽� ������ ������
SQL> conn user03/tiger
SQL> show user 
SQL> USER is "USER03"

