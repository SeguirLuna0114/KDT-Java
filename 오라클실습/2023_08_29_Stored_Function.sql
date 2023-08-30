-- 2023. 08. 29 (ȭ)

-- ���� �Լ�(Stored Function)
-- : ���� �Լ��� ���� ���ν����� ������ ����� ����������,
--   ���� ����� �����ִ� ������ ����

-- Q1. ��� ���̺��� Ư�� ����� �޿��� 200% �λ��� ����� �����ִ� �����Լ� ����
-- 1. �����Լ�
CREATE OR REPLACE FUNCTION cal_bonus(vempno IN emp.empno%TYPE)
    RETURN NUMBER   -- ������ ���� �ڷ���
IS
    -- ���� ���� ����
    vsal NUMBER(7, 2);
BEGIN
    -- SQL�� �ۼ�
    SELECT sal INTO vsal
    FROM emp WHERE empno = vempno;
    
    RETURN vsal * 2;    -- �޿��� 200% �λ��� ��� ����
END;

-- 2. �����Լ� ��� Ȯ��
SELECT * FROM user_source;

-- 3. ���ε� ���� ����
VARIABLE var_res NUMBER;

-- 4. ���� �Լ� ����
EXECUTE :var_res := cal_bonus(7788);
EXECUTE :var_res := cal_bonus(7900);

-- 5. ���ε� ������ �������� �� ���
PRINT var_res;

-- ���� �Լ��� SQL������ ���Խ��Ѽ� ����
SELECT ename, sal, cal_bonus(7788)
FROM emp WHERE empno = 7788;
    -- SCOTT	3000	6000    
SELECT ename, sal, cal_bonus(7900)
FROM emp WHERE empno = 7900;   
    -- JAMES	950	1900
    
   
-- Q2. ��� ���̺��� ������� �����Լ��� �Ű������� �����Ͽ�
-- �ش� ����� ����(job)�� ���ؿ��� ���� �Լ��� �����ϰ� ����
-- 1. �����Լ� ����
CREATE OR REPLACE FUNCTION job_emp(
    vename IN emp.ename%TYPE
)
RETURN VARCHAR2
IS
    vjob emp.job%TYPE;  --���ú���(��������� �˻��� ����� job �˻�)
BEGIN
    SELECT job INTO vjob
    FROM emp WHERE ename = vename;
    
    RETURN vjob;
END;

-- 2. ���� �Լ� ��� Ȯ��
SELECT * FROM user_source;

-- 3. ���ε� ����
VARIABLE var_job VARCHAR2(10);

-- 4. �����Լ� ����
EXECUTE :var_job := job_emp('SCOTT');
EXECUTE :var_job := job_emp('KING');

-- 5. ���ε� ������ ����� ��� ���
PRINT var_job;
    
-- ���� �Լ��� SQL������ ���Խ��Ѽ� ����   
SELECT job_emp('SCOTT')
FROM emp WHERE ename = 'SCOTT';
    -- ANALYST
SELECT job_emp('KING')
FROM emp WHERE ename = 'KING';
    -- PRESIDENT
    
    
