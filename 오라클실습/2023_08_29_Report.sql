-- 2023. 08. 29 (ȭ)

-- Q1. ����ǿ� ���� �Ի��� ������� ���ο� ������ ������ �ַ��� �մϴ�. 
--�Ʒ��� �䱸 ������ �����ϴ� SQL���� ���� �ۼ�
--   [�䱸1] USER�� : woman, �н����� : tiger 
--   [�䱸2] CREATE SESSION �̶�� �ý��� ������ �ο��� �ݴϴ�. 
--	(��, �� �ٸ� �������Ե� ������ �� �� �ֵ��� 
--	      WITH ADMIN OPTION�� �ο��մϴ�). 
--   [�䱸3] woman�������� connect, resource, dba ������ �ο��մϴ�.
-- ������ �������� ����
conn system/oracle
-- 1) USER�� : woman, �н����� : tiger ���� ����
CREATE USER woman IDENTIFIED BY tiger;
-- 2) CREATE SESSION, WITH ADMIN OPTION �ý��� ���� �ο�
GRANT CREATE SESSION TO woman WITH ADMIN OPTION;
-- 3)woman�������� connect, resource, dba ������ �ο�
GRANT CONNECT, RESOURCE, DBA TO woman;


-- Q2. user01 ������ ���� �ϼ���? (��й�ȣ: tiger)
-- ������ �������� ����
conn system/oracle
-- user01 ���� ����
CREATE USER user01 IDENTIFIED BY tiger;


-- Q3. user01 �������� ����Ŭ ������ ���̽��� �����ؼ�, ���̺��� ������ �� �ִ� ������ �ο��Ͻÿ�.
-- ������ �������� ����
conn system/oracle
-- �����ͺ��̽� ���� ���� & ���̺��� ������ �� �ִ� ������ �ο�
GRANT CREATE SESSION, CREATE TABLE TO user01;



-- Q. ��� ���̺��� ������� �˻��Ͽ� ����� ������ ���ؿ��� ���� ���ν����� ���� ����
-- 1. ���� ���ν��� ����
CREATE OR REPLACE PROCEDURE sel_ename(
    vename IN emp.ename%TYPE,   -- �����
    vjob OUT emp.job%TYPE
)
IS
BEGIN
    SELECT job INTO vjob
    FROM emp WHERE ename = vename;
END;
    
-- 2. ���ν��� ��� Ȯ��
SELECT * FROM user_source;

-- 3. ���ε� ���� ����
    -- ���ε� ���� : ���ν����� ������ ��, ����� �����޴� ����
VARIABLE var_job VARCHAR2(12);

-- 4. ���ν��� ����
EXECUTE sel_ename('SCOTT', :var_job);

-- 5. ���ε� ������ �������� �� ���
PRINT var_job;

