-- 2023. 08. 29 (ȭ)

-- ���� ���ν���(Stored Procedure)

-- emp01���̺� ����
DROP TABLE emp01 PURGE;
-- emp���̺��� ���纻 emp01���̺� ����
CREATE TABLE emp01 AS
SELECT * FROM emp;
-- emp01���̺� ������ Ȯ��
SELECT * FROM emp01;

-- �Ű������� ���� ���� ���ν���
-- 1. �Ű������� ���� ���� ���ν��� ����
CREATE OR REPLACE PROCEDURE del_all
IS
BEGIN
    DELETE FROM emp01;
END;

-- 2. ���ν��� ��� Ȯ��
SELECT * FROM user_source;

-- 3. ���ν��� ����
exec del_all;
EXECUTE del_all;

-- 4. ���ν��� ���� Ȯ��
SELECT * FROM emp01;        -- ���ν����� ���� �����Ͱ� ��� ������

-- ������ ������ ����
ROLLBACK;   
-- �ѹ��� ���� �ʴ� ���, emp �����͸� �Է�
INSERT INTO emp01 SELECT * FROM emp;

-------------------------------------------------------------------

-- �Ű������� ���� ���� ���ν���

-- �Ű������� MODE�� IN���� �Ǿ��ִ� ���ν���
-- IN : �Ű������� ���� �޴� ����
-- 1. �Ű������� �ִ� ���� ���ν��� ����
CREATE OR REPLACE PROCEDURE del_ename(vename IN emp01.ename%TYPE)
IS
BEGIN
    DELETE FROM emp01 WHERE ename = vename;
END;

-- 2. ���ν��� ��� Ȯ��
SELECT * FROM user_source;

-- 3. ���ν��� ����
EXECUTE del_ename('SCOTT');
EXECUTE del_ename('SMITH');
EXECUTE del_ename('KING');

-- 4. ���ν��� ���� Ȯ��
SELECT * FROM emp01; 
SELECT * FROM emp01 WHERE ename = 'SCOTT';  -- Ȯ�ε��� ����(���� ����)
SELECT * FROM emp01 WHERE ename = 'SMITH';
SELECT * FROM emp01 WHERE ename = 'KING';


-- �Ű������� MODE�� out���� �Ǿ��ִ� ���ν���
-- IN : �Ű������� ���� �޴� ����
-- out : �Ű������� ���� �����ִ� ����

-- Q. ���ν����� �Ű������� �����ȣ�� �����ؼ�, �� ����� �����, �޿�, ��å�� ���ϴ�
-- ���ν����� �����ϰ� ����
--  1. ���ν��� ����
CREATE OR REPLACE PROCEDURE sal_empno(
    vempno IN emp.empno%TYPE,       -- �����ȣ
    vename OUT emp.ename%TYPE,      -- �����
    vsal OUT emp.sal%TYPE,          -- �޿�
    vjob OUT emp.job%TYPE           -- ��å
)
IS
BEGIN
    -- SQL����(������ ��ȸ, ����, ����, ����)
    SELECT ename, sal, job INTO vename, vsal, vjob 
    FROM emp
    WHERE empno = vempno;
END;

-- 2. ���ν��� ��� Ȯ��
SELECT * FROM user_source;

-- 3. ���ε� ���� ����
    -- ���ε� ���� : ���ν����� ������ ��, ����� �����޴� ����
VARIABLE var_ename VARCHAR2(12);
VARIABLE var_sal VARCHAR2;
VARIABLE var_job VARCHAR2(10);

-- 4. ���ν��� ����
EXECUTE sal_empno(7788, :var_ename, :var_sal, :var_job);
EXECUTE sal_empno(7839, :var_ename, :var_sal, :var_job);

-- 5. ���ε� ������ �������� �� ���
PRINT var_ename;
PRINT var_sal;
PRINT var_job;
PRINT var_ename var_sal var_job;

