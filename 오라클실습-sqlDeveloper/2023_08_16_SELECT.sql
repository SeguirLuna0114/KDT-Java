-- 2023.08.16(��)

-- # ���̺� ��� ��� "SELECT * FROM tab"
SELECT * FROM tab;
    -- DEPT: �μ� ���̺�
    -- EMP: ��� ���̺�
    -- BONUS: �󿩱�(������ ���� ����)
    -- SALGRADE: ��� �޿����


-- # ���̺� ���� Ȯ�� "DESCRIBE ���̺��"
    -- DESCRIBE ���̺�� : ���̺��� ���� ���
    -- DESC ���̺��    (DESCRIBE�� ����)
-- DEPT ���̺� ����
DESCRIBE dept;
desc dept;

-- EMP ���̺� ����
DESCRIBE emp;


-- # ���̺� ������ �˻� "SELECT * FROM ���̺��"
    -- SELECT * FROM ���̺�� : ���̺��� ��� �� ������ �˻�
-- DEPT ���̺� ������ �˻�
SELECT * FROM dept;
SELECT * FROM DEPT;         -- SQL���� ��ҹ��� ����X

-- EMP ���̺� ������ �˻�
SELECT * FROM emp;


-- ����Ŭ�� ������ Ÿ��
--1.���� ������
-- number(n) 
-- ex) number(2) : ���� 2�ڸ����� ����
-- number(n1, n2) : n1 - ��ü �ڸ���
--                  n2 - �Ҽ����� �Ҵ�� �ڸ���
-- ex) number(7, 2) : ��ü �ڸ��� 7�ڸ�
--                    �Ҽ����� 2�ڸ�
--2.���� ������
-- char() : ���� ���� ������
--          �ִ� 2000 byte ���� ���� ������.
-- varchar2() : ���� ���� ������
--              �ִ� 4000 byte ���� ���� ������.
-- long : 2GB ���� ���� ������.
--        long ������ ������ �÷��� �˻� ����� �������� �ʴ´�.
--3.��¥ ������
-- date : ��/��/�� ���� ����
-- timestamp : ��/��/�� ��:��:�� ���� ����


-- # SELECT SQL��
    -- select * from ���̺��: �ش� ���̺��� ��� ������ ���
    -- select �÷��� from ���̺��: �ش� ���̺��� ������ �÷��� �����͸� ���
    --    => ���̺��� ������ ���Ƿ� ���� ����

SELECT * FROM dept;
SELECT loc, dname, deptno FROM dept;

SELECT * FROM emp;
SELECT empno, ename, sal  FROM emp;

-- **select������ ������� ����
    -- ���������: +, -, *, /
    -- null���� ��������� ����X => null�� ó����
SELECT sal + comm FROM emp;
SELECT sal + 100 FROM emp;
SELECT sal - 100 FROM emp;
SELECT sal * 100 FROM emp;
SELECT sal / 100 FROM emp;

-- NULL     1. �������� ���� ��
--          2. NULL���� ��������� �� �� ����
--          3. NULL���� ��
--              ex) EMP���̺� :  NGR�÷� - KING����� NGR�÷��� NULL
--                              COMM �÷� - job�� SALESMAN�� ����� ���� ����

-- Q. ��� ���̺�(emp)�� �Ҽӵ� ������� ������ ���
    -- ���� = �޿�(sal) * 12 + Ŀ�̼�(comm)
SELECT sal*12, comm  FROM emp;

-- sal * 12 + comm : null���� ��������� ���� �ʱ� ������,
--                   job�� SALESMAN�� ����� ���� ����� ��
SELECT ename, job, sal, comm, sal*12+comm FROM emp;

-- # NVL(�÷�, ��ȯ�� ��)�Լ� : NULL���� �ٸ���(0)���� ��ȯ���ִ� ����
-- ex) NVL(COMM, 0) : COMM�÷��� NULL���� 0���� ġȯ�϶�� �ǹ�
-- *�ùٸ� ������� SQL�� �ۼ�
SELECT ename, job, sal, comm, sal*12+comm, sal*12+NVL(comm, 0) FROM emp;

-- # ��Ī�ο�: AS "��Ī��"
SELECT ename, sal*12+nvl(comm, 0) AS "Annual" from emp;
    -- AS ���� ����
SELECT ename, sal*12+nvl(comm, 0) "Annual" from emp;
    -- �ֵ���ǥ("") ���� ����
SELECT ename, sal*12+nvl(comm, 0) AS Annual from emp;

-- �ѱ� ��Ī�� �ο�
SELECT ename, sal*12+nvl(comm, 0) AS "����" from emp;
    -- AS ���� ����
SELECT ename, sal*12+nvl(comm, 0) "����" from emp;
SELECT ename, sal*12+nvl(comm, 0) "�� ��" from emp;
    -- �ֵ���ǥ("") ���� ����(��, ���� ���� ��쿡��)
SELECT ename, sal*12+nvl(comm, 0) AS ���� from emp;
    -- ��Ī�� ���� �� ��쿡�� ��Ī�� �¿쿡 �ֵ���ǥ �ٿ��� ��
-- SELECT ename, sal*12+nvl(comm, 0) AS �� �� from emp;  -- �����߻�


-- Concatenation ������ (||) : �÷��� ���ڿ��� ������ �� ���
SELECT ename, ' is a ', job FROM emp;
SELECT ename || ' is a ' || job FROM emp;

-- distinct : �ߺ����� �����ϰ� 1���� ����ϰ� �ϴ� ����
    -- 14���� ������ ���
SELECT deptno FROM emp;
    -- 3���� �μ���ȣ�� ���: 10, 20, 30
SELECT DISTINCT deptno from emp;


-- Q1. EMP���̺��� �� ������� job�� 1���� ����ϴ� SQL�� �ۼ�
    -- job�÷��� ������ 14�� ���� ���
SELECT job FROM emp;
    -- �ߺ����� ������ ��, 5���� job�� ���
SELECT DISTINCT job FROM emp;

-- Q2. EMP���̺��� �ߺ��� ������ job�� ������ ���
    -- count(�÷���) : �÷��� ������ ������ ���ϴ� �Լ�
SELECT count(*) FROM dept;
SELECT count(*) FROM emp;               -- 14
    -- count(DISTINCT �÷���) : �ߺ��� ������ Ư���÷��� ���� ���� ���
SELECT count(DISTINCT job) FROM emp;    -- 5


-- # Where ������ : �񱳿�����(=, >, >=, <, <=, !=, ^=, <>)

-- 1. ���� ������ �˻�
-- Q. ��� ���̺��� �޿��� 3000�̻� �޴� ����� �˻��ϴ� SQL�� �ۼ�
SELECT * FROM emp WHERE sal >= 3000;

-- Q. �޿��� 3000�� ����� �˻��ϴ� SQL��
SELECT * FROM emp WHERE sal = 3000;

-- Q3. �޿��� 3000�� �ƴ� ����� �˻��ϴ� SQL�� �ۼ�
SELECT * FROM emp WHERE sal != 3000;
SELECT * FROM emp WHERE sal ^= 3000;
SELECT * FROM emp WHERE sal <> 3000;

-- Q4. �޿��� 1500 ������ ����� �����ȣ, �����, �޿��� ����ϴ� SQL��
SELECT empno, ename, sal FROM emp WHERE sal <= 1500;


-- 2. ���� ������ �˻�
    -- 1) ���� �����͸� �˻��� ������ ���ڿ� �¿쿡 �ܵ���ǥ('���ڿ�')�� �ٿ��� ��
    -- 2) ���� �����ʹ� ��ҹ��ڸ� ����

-- Q1. ������̺��� ������� FORD�� ����� ������ �˻��ϴ� SQL��
SELECT * FROM emp WHERE ename = 'ford';     -- ��ҹ��� ����
-- SELECT * FROM emp WHERE ename = FORD;    -- ����(���ڿ� �¿� �ܵ���ǥ)
--SELECT * FROM emp WHERE ename = "FORD";   -- ����(�ֵ���ǥ�� ��Ī�� �ο��ÿ��� ���)
SELECT * FROM emp WHERE ename = 'FORD';

-- Q2. SCOTT����� �����ȣ, �����, �޿��� ����ϴ� SQL�� �ۼ�
SELECT empno, ename, sal FROM emp WHERE ename = 'SCOTT';


-- 3. ��¥ ������ �˻�
    -- 1) ��¥������ �¿쿡 �ܵ���ǥ(')�� �ٿ��� ���
    -- 2) ��¥������ ���� ��쿡�� �񱳿����� ���

-- Q1. 1982�� 1�� 1�� ���Ŀ� �Ի��� ����� �˻��ϴ� SQL��
--SELECT * FROM emp WHERE hiredate >= 82/01/01;       --�����߻�
SELECT * FROM emp WHERE hiredate >= '82/01/01';         -- �ܵ���ǥ �ʿ�
SELECT * FROM emp WHERE hiredate >= '1982/01/01';

-- Q2. 1982�� 1�� 1�� ���Ŀ� �Ի��� ����� �˻��ϰ�, �Ի��� �������� �������� ����
SELECT * FROM emp WHERE hiredate >= '1982/01/01' ORDER BY hiredate ASC;
