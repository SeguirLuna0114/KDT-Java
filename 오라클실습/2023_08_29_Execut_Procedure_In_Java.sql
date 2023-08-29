-- 2023. 08. 29 (ȭ)

-- ���� ���ν���(Stored Procedure)

-- �ڹ� ���α׷����� ���ν��� ����

-- ��1. �Ű������� ���� ���ν���
-- 1. ���ν��� ����
CREATE OR REPLACE PROCEDURE del_all
IS
BEGIN
    DELETE FROM emp01;
END;

-- 2. emp01���̺� ����
DROP TABLE emp01 PURGE;
CREATE TABLE emp01 AS
SELECT * FROM emp;

-- 3. ��Ŭ�������� del_all���ν����� ȣ�� => emp01���̺� ������ ����
SELECT * FROM emp01;

-- �ڹ� ���α׷����� ���������� ����(con.close())�Ǿ��⿡, 
-- ������ �����ʹ� ��������X
ROLLBACK;   


-- ��2. �Ű������� �ִ� ���ν��� ����
-- ���������� emp01���̺� ������ �Է�
INSERT INTO emp01 SELECT * FROM emp;
SELECT * FROM emp01;

-- 1. ���ν��� ����
CREATE OR REPLACE PROCEDURE del_ename(vename IN emp01.ename%TYPE)
IS
BEGIN
    DELETE FROM emp01
    WHERE ename = vename;
END;

-- 2. �ڹ� ���α׷����� del_ename ���ν��� ����

-- 3. ���ν��� ������ Ȯ��
SELECT * FROM emp01;


-- ��3. �Ű������� MODE�� in, out���� �Ǿ��ִ� ���� ���ν���
-- customer���̺� ����

-- 1. ���� ���ν��� ����
CREATE OR REPLACE PROCEDURE sel_customer(
    vname IN customer.name%TYPE,           -- ����
    vemail OUT customer.email%TYPE,         -- �̸���
    vtel OUT customer.tel%TYPE              -- ��ȭ��ȣ
)
IS
BEGIN
    -- SQL����(������ ��ȸ, ����, ����, ����)
    SELECT email, tel INTO vemail, vtel 
    FROM customer
    WHERE name = vname;
END;

-- 2. ���ν��� ��� Ȯ��
SELECT * FROM user_source;

-- customer���̺� ������ Ȯ��
SELECT * FROM customer;

-- 3. ���ε� ���� ����
    -- ���ε� ���� : ���ν����� ������ ��, ����� �����޴� ����
VARIABLE var_email VARCHAR2(20);
VARIABLE var_tel VARCHAR2(20);

-- 4. ���ν��� ����
EXECUTE sel_customer('ȫ�浿', :var_email, :var_tel);
EXECUTE sel_customer('��ȭ��', :var_email, :var_tel);

-- 5. ���ε� ������ ���� ��� ���
PRINT var_email;
PRINT var_tel;
PRINT var_email var_tel;

-- 6. �ڹ����α׷����� sel_customer ���ν����� ����

