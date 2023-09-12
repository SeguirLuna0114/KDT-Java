-- 2023.09.12

-- Q2. 1~10 ������ ���� �߿���  ¦���� ���� ���ϴ� PL/SQL ���α׷�
SET SERVEROUTPUT ON     -- SERVEROUTPUT ȯ�溯�� Ȱ��ȭ
DECLARE
    s NUMBER := 0;      -- �������� ���� ����
BEGIN
    -- Loop
    FOR n IN REVERSE 1..10 LOOP
        IF n MOD 2 = 0 then
            s := s +n;
        END IF;
    END LOOP;
    dbms_output.put_line('1~10���� ¦���� �� : ' || s);
END;
            
        
    



-- Q3. ��� ���̺�(EMP)���� �����ȣ(EMPNO)�� �Ű������� �޾Ƽ�,
-- ��� ������ �����ϴ� ���ν����� �����ϰ�, ���ν����� ����
-- 1) ���ν��� ����
CREATE OR REPLACE PROCEDURE del_empno(vempno IN emp.empno%TYPE)
IS
BEGIN
    DELETE FROM emp
    WHERE empno = vempno;
END;

-- ���ν��� ��� Ȯ��
SELECT * FROM user_source;

-- 2) ���� ���ν��� ����
EXECUTE del_empno(7369);

-- 3) ���ν��� ���� Ȯ��
SELECT * FROM emp;


-- Q4. ������̺�(EMP)����  SCOTT �����  ������� ���ν����� �Ű������� �����ؼ� 
-- SCOTT ����� �޿��� ����ϴ� ���ν����� �����ϰ�  ����
--  1. ���ν��� ����
CREATE OR REPLACE PROCEDURE  emp_sal(
    vename IN emp.ename%TYPE,       -- �����
    vsal OUT emp.sal%TYPE          -- �޿�
)
IS
BEGIN
    -- SQL����(������ ��ȸ, ����, ����, ����)
    SELECT sal INTO vsal
    FROM emp
    WHERE ename = vename;
END;

-- 2. ���ν��� ��� Ȯ��
SELECT * FROM user_source;

-- 3. ���ε� ���� ����
    -- ���ε� ���� : ���ν����� ������ ��, ����� �����޴� ����
VARIABLE var_sal VARCHAR2;

-- 4. ���ν��� ����
EXECUTE emp_sal('SCOTT', :var_sal);

-- 5. ���ε� ������ �������� �� ���
PRINT var_sal;


-- Q5. ��� ���̺�(EMP)���� �����ȣ�� ���ν����� �Ű������� ���� �޾Ƽ�, 
-- �� ����� �����, �޿�,  �μ���ȣ�� ���ϴ� ���ν��� �����ؼ� ����
--  1. ���ν��� ����
CREATE OR REPLACE PROCEDURE emp_info(
    vempno IN emp.empno%TYPE,       -- �����ȣ
    vename OUT emp.ename%TYPE,      -- �����
    vsal OUT emp.sal%TYPE,          -- �޿�
    vdeptno OUT emp.deptno%TYPE           -- �μ���ȣ
)
IS
BEGIN
    -- SQL����(������ ��ȸ, ����, ����, ����)
    SELECT ename, sal, deptno INTO vename, vsal, vdeptno 
    FROM emp
    WHERE empno = vempno;
END;

-- 2. ���ν��� ��� Ȯ��
SELECT * FROM user_source;

-- 3. ���ε� ���� ����
    -- ���ε� ���� : ���ν����� ������ ��, ����� �����޴� ����
VARIABLE var_ename VARCHAR2(12);
VARIABLE var_sal VARCHAR2;
VARIABLE var_deptno NUMBER;

-- 4. ���ν��� ����
EXECUTE emp_info(7788, :var_ename, :var_sal, :var_deptno);
EXECUTE emp_info(7839, :var_ename, :var_sal, :var_deptno);

-- 5. ���ε� ������ �������� �� ���
PRINT var_ename;
PRINT var_sal;
PRINT var_deptno;


