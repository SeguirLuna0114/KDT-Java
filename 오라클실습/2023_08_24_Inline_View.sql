-- 2023. 08. 24(��)

-- ROWNUM �÷�
--  1. �������� �˻������� ���� �ִ� ������ �÷�
--  2. rownum���� 1�� ���� ����
--  3. rownum���� order by���� �����ϴ��� ���� �ٲ��� ����
--  4. rownum���� �����ϱ� ���� ���̺��� �����ؾ� ��

SELECT ROWNUM, ROWID, deptno, dname, loc
FROM dept;
SELECT ROWNUM, ename, sal FROM emp;
SELECT ROWNUM, ename, sal FROM emp WHERE ename = 'WARD';

-- ORDER BY���� �̿��� ����
SELECT ROWNUM, ename, sal FROM emp ORDER BY sal DESC;

-- Q1. ��� ���̺��� �Ի����� ���� ����� 5�� ���ϴ� SQL��
-- 1) �Ի����� ���� ��������� ����(�Ի����� �������� �������� ����)
SELECT empno, ename, hiredate 
FROM emp 
ORDER BY hiredate ASC;

-- 2) ���Ϻ� ����
CREATE OR REPLACE VIEW hire_view AS
SELECT empno, ename, hiredate 
FROM emp 
ORDER BY hiredate ASC;

-- 3) �Ի����� ���� ��� 5�� ���
SELECT ROWNUM, ename, hiredate
FROM hire_view
WHERE ROWNUM <= 5;

-- 4) �ζ��� ��(���������� ������� ��)�� ����� �Ի����� ���� ��� 5�� �˻�
SELECT ROWNUM, ename, hiredate
FROM (
    SELECT empno, ename, hiredate
    FROM emp
    ORDER BY hiredate ASC
)
WHERE ROWNUM <= 5;

-- Q2. ��� ���̺��� �����ȣ(empno)�� ���� ��� 5���� ���ϴ� SQL��
--1) ��� ��ȣ�� ���� ��������� ����(�����ȣ�� �������� �������� ����)
SELECT empno, ename FROM emp ORDER BY empno ASC;

-- 2) �� ����
CREATE OR REPLACE VIEW emp_view AS
SELECT empno, ename
FROM emp ORDER BY empno ASC;

-- 3) �����ȣ�� ���� ��� 5�� ���
SELECT ROWNUM, empno, ename 
FROM emp_view
WHERE ROWNUM <= 5;

-- 4) �ζ��� ��(�������� ������ �ζ��� ��)
    -- �����ȣ�� ���� ��� 5�� �˻�
SELECT ROWNUM, empno, ename
FROM (
    SELECT * 
    FROM emp
    ORDER BY empno ASC
)
WHERE ROWNUM <= 5;


--Q. ��� ���̺��� �޿��� ���̹޴� ��� 5���� �˻�
--1) �޿��� ���� �޴� ��������� ����(�޿��� �������� �������� ����)
SELECT ename, sal FROM emp ORDER BY sal DESC;

-- 2) �� ����
CREATE OR REPLACE VIEW sal_view AS
SELECT ename, sal
FROM emp ORDER BY sal DESC;

-- 3) �޿��� ���� �޴� ��� 5�� ���
SELECT ROWNUM, ename, sal 
FROM sal_view
WHERE ROWNUM <= 5;

-- 4) �ζ��� ��
    -- �޿��� ���� �޴� ��� 5�� �˻�
SELECT ROWNUM, ename, sal
FROM (
    SELECT *
    FROM emp
    ORDER BY sal DESC
)
WHERE ROWNUM < 6;

-- Q. ROWNUM�� �̿��ؼ� �޿��� 3~5��°�� ���̹޴� ����� �˻�
-- �޿��� ���̹޴� ��� �� 3��°
SELECT ROWNUM, ename, sal
FROM (
    SELECT emp.*, ROWNUM as rnum
    FROM (
        SELECT *
        FROM emp
        ORDER BY sal DESC
    ) emp
)
WHERE rnum BETWEEN 3 AND 5;






