-- 2023. 08. 18

-- �׷��Լ� : �ϳ� �̻��� �����͸� �׷����� ��� ������ �����ϰ�,
--           �ϳ��� ����� ó�����ִ� �Լ�
--    1. �׷��Լ��� �Ϲ��÷��� ���� ����� �� ����
--      (�׷��Լ��� ����� ��� �ϳ��� ���(��)�� ó���ϱ� ����)
--    2. �Ϲ��÷��� �׷��Լ��� ���� ����� �� ������, 
--       ���������� Group By���� ���Ǵ� �÷��� �׷��Լ��� ���� ��� ����

-- # sum() : ���� �����ִ� �Լ�
SELECT SUM(sal) FROM emp;       -- �޿��� ����
SELECT SUM(comm) FROM emp;      -- comm�� ��(��, NULL���� ����)
SELECT SUM(NVL(comm, 0)) AS COMM FROM emp;

-- ���ڷ� �̷���� ���� �ƴѰ��, ������ �߻�
SELECT SUM(ename) FROM emp;     -- ���� �߻�

-- �׷��Լ��鳢���� ���� ����� �� ����(�׷��Լ��� ����� ��� �ϳ��� ���(��)�� ó���ϱ� ����)
SELECT SUM(sal), SUM(comm) FROM emp;
-- �׷��Լ��� �Ϲ��÷��� ���� ����� �� ����
SELECT sal, SUM(sal), SUM(comm) FROM emp;       -- ���� �߻�

-- �� �μ��� �޿� ������ ���ϴ� SQL��
SELECT SUM(sal) FROM emp WHERE deptno=10;       -- 8750
SELECT SUM(sal) FROM emp WHERE deptno=20;       -- 10875
SELECT SUM(sal) FROM emp WHERE deptno=30;       -- 9400
    -- 40�� �μ��� ���� ����� ���⿡, NULL(���̾���)�� ��µ�
SELECT SUM(sal) FROM emp WHERE deptno=40;       -- NULL


-- # AVG() : ��հ��� �����ִ� �Լ�
SELECT AVG(sal) FROM emp;
SELECT AVG(sal), AVG(comm) FROM emp;
SELECT AVG(sal), AVG(comm) FROM emp where deptno = 10;
SELECT AVG(sal), AVG(comm) FROM emp where deptno = 20;
SELECT AVG(sal), AVG(comm) FROM emp where deptno = 30;
SELECT AVG(sal), AVG(comm) FROM emp where deptno = 40;


-- # Max() : �ִ밪�� �����ִ� �Լ�
-- Q1. ��� ���̺��� �ִ� �޿� �ݾ��� ���ϴ� SQL
SELECT MAX(sal) FROM emp;           -- 5000

SELECT MAX(sal) FROM emp WHERE deptno = 10;     -- 5000
SELECT MAX(sal) FROM emp WHERE deptno = 20;     -- 3000
SELECT MAX(sal) FROM emp WHERE deptno = 30;     -- 2850
SELECT MAX(sal) FROM emp WHERE deptno = 40;     -- NULL

-- Q2. ��� ���̺��� �ִ� �޿��� �ִ�޿��� �޴� ������� ����ϴ� SQL��
    -- �׷��Լ��� �Ϲ��÷��� ���� ����� �� ����
SELECT ename, MAX(sal) FROM emp;        -- ���� �߻�

    -- JOIN���� ���
SELECT e.ename, e.sal from emp e
    JOIN (SELECT MAX(sal) AS max_sal FROM emp) max_salary_emp
    ON e.sal = max_salary_emp.max_sal;
     
    -- �������� ���
    --  �������� (SELECT MAX(sal) FROM emp)�� emp ���̺��� �ִ� �޿� ���� ã��, 
    --  �ٱ��� ���������� �� �ִ� �޿��� �޴� ������ �̸�(ename)�� �޿�(sal)�� ����
SELECT ename, sal FROM emp WHERE sal = (SELECT MAX(sal) FROM emp);

-- Q3. ��� ���̺��� ���� �ֱٿ� �Ի��� �Ի����� ����ϴ� SQL��
SELECT MAX(hiredate) FROM emp;          -- 87/07/13
SELECT hiredate FROM emp ORDER BY hiredate DESC;    -- �������� ����(�ֱٳ�¥��)

-- Q4. ��� ���̺��� ������� ���ĺ����� ���� ���߿� ������ ������� ���ϴ� SQL��
SELECT MAX(ename) FROM emp;             -- WARD
SELECT ename FROM emp ORDER BY ename DESC;    -- �������� ����(��������)


-- # MIN() : �ּҰ��� �����ִ� �Լ�
-- Q1. ��� ���̺��� �ּ� �޿� �ݾ��� ���ϴ� SQL
SELECT MIN(sal) FROM emp;           -- 800

SELECT MIN(sal) FROM emp WHERE deptno = 10;     -- 1300
SELECT MIN(sal) FROM emp WHERE deptno = 20;     -- 800
SELECT MIN(sal) FROM emp WHERE deptno = 30;     -- 950
SELECT MIN(sal) FROM emp WHERE deptno = 40;     -- NULL

-- Q2. ��� ���̺��� ���� ���� �Ի��� �Ի����� ���ϴ� SQL��
SELECT MIN(hiredate) FROM emp;          -- 80/12/17
SELECT hiredate FROM emp ORDER BY hiredate ASC;    -- �������� ����(���� �̸���¥��)

-- Q3. ��� ���̺��� ������� ���ĺ����� ���� ���� ������ ������� ���ϴ� SQL��
SELECT MIN(ename) FROM emp;             -- ADAMS
SELECT ename FROM emp ORDER BY ename ASC;    -- �������� ����(������)

-- �׷� �Լ����� ���� ����� �� ����
SELECT SUM(sal), AVG(sal), MAX(sal), MIN(sal) from emp;
SELECT SUM(sal), AVG(sal), MAX(sal), MIN(sal) from emp WHERE deptno = 10;
SELECT SUM(sal), AVG(sal), MAX(sal), MIN(sal) from emp WHERE deptno = 20;
SELECT SUM(sal), AVG(sal), MAX(sal), MIN(sal) from emp WHERE deptno = 30;


-- # count() : �� ������ ������ �����ִ� �Լ�
-- ���� : count(�÷���)
SELECT COUNT(sal) FROM emp;         -- 14
SELECT COUNT(mgr) FROM emp;         -- 13(NULL���� counting���� X)
SELECT COUNT(*) FROM emp WHERE mgr IS NULL; -- 1(NULL���� 1��)
SELECT COUNT(NVL(mgr, 0)) FROM emp;     -- 14

SELECT COUNT(comm) FROM emp;        -- 4(NULL���� counting���� X)
SELECT COUNT(*) FROM emp WHERE comm IS NULL;    -- 10(NULL���� 10��)
SELECT count(NVL(comm, 0)) FROM emp;    -- 14

SELECT COUNT(empno) FROM emp;       -- 14: empno�÷��� �⺻Ű ���������� ������

    -- count(*): ��� ������ ������ ������
    -- count(*)�� ������ ��� Group Function�� Null�� �����ϰ� �����
SELECT COUNT(*) FROM emp;           -- 14(NULL���� �����ϰ� ����)

-- Q1. ��� ���̺��� �ߺ����� ������ JOB�� ������ ���ϴ� SQL��
-- 1) JOB�� ���� ���ϱ�
SELECT count(job) FROM emp;         -- 14(�ߺ� �����͵� counting)

SELECT job FROM emp;
SELECT DISTINCT job from emp;       -- �ߺ����� ������ job���(5����)

-- 2) �ߺ� ���� ������ job�� ����
SELECT count(DISTINCT job) FROM emp;    -- 5
