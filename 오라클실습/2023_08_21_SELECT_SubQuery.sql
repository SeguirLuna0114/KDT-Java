-- 2018. 08. 21(��)

-- ��������

-- Q. SCOTT����� �Ҽӵ� �μ����� ����ϴ� SQL
-- �ΰ��� SQL���� ���
    -- 1) ������̺�(EMP)���� SCOTT����� �μ���ȣ�� ����
    SELECT deptno FROM emp WHERE ename = 'SCOTT';       -- 20
    -- 2) �μ����̺�(DEPT)���� 20�� �μ��� �μ����� ����
    SELECT dname FROM dept WHERE deptno=20;     -- RESEARCH

-- �������� �̿��ϴ� ���
SELECT dname FROM dept                                          -- ���� ����
WHERE deptno = (SELECT deptno FROM emp WHERE ename='SCOTT');    -- ���� ����

-- JOIN���� ���ϱ�
-- 1) CROSS JOIN�� WHERE ���� ����
SELECT dname FROM dept, emp 
WHERE dept.deptno = emp.deptno AND ename = 'SCOTT';
-- 2) INNER JOIN - ON��
SELECT dname FROM dept
INNER JOIN emp ON dept.deptno = emp.deptno
WHERE ename = 'SCOTT';
-- 3) INNER JOIN - USING��
SELECT dname FROM dept
INNER JOIN emp USING(deptno)
WHERE ename = 'SCOTT';
-- 4) NATURAL JOIN
SELECT dname FROM dept
NATURAL JOIN emp
WHERE ename = 'SCOTT';


-- 1. ���� �� �������� (Single-row Subquery)
--  1) ���������� �˻������ 1���� ��ȯ�Ǵ� ����
--  2) ���������� where ���������� �񱳿����ڸ� ��� ����

-- Q1. ��� ���̺��� ���� �ֱٿ� �Ի��� ������� ����ϴ� SQL��
SELECT ename, hiredate
FROM emp
WHERE hiredate = (SELECT MAX(hiredate) FROM emp);
-- SCOTT	87/07/13
-- ADAMS	87/07/13

-- Q2. ��� ���̺��� �ִ�޿��� �޴� ������ �ִ�޿� �ݾ��� ����ϴ� SQL��
    -- ���� �߻�: �׷��Լ��� �Ϲ��÷��� ���� ����� �� X
SELECT ename, MAX(sal) FROM emp;        -- ���� �߻�

SELECT ename, sal
FROM emp
WHERE sal = (SELECT MAX(sal) FROM emp);
-- KING	5000

-- Q3. ���ӻ�簡 KING�� ����� ������ �޿��� ����ϴ� SQL��
    -- ��������: emp ���̺��� �̸��� 'KING'�� ������ ���� ��ȣ(empno)�� �˻�
    -- ��������: ���������� KING ������ ���� ��ȣ(empno)�� �̿��Ͽ� 
    --          ���(mgr)�� KING�� ���� ��ȣ�� ������ �������� �̸�(ename), ����(sal), ���(mgr) ������ ������
    --          (���� ������ mgr �÷� ���� ���������� ����� empno ���� ��)
SELECT ename, sal, mgr
FROM emp
WHERE mgr = (SELECT empno FROM emp WHERE ename = 'KING');   -- "mgr" ��(����� ���� ��ȣ)�� KING ������ ���� ��ȣ�� ��ġ�ϴ� ���ڵ带 ���͸�
-- KING	5000	

    -- �̶�, 'KING' ����� ���õ� ������ ���������� ���̱⿡,
    -- empno ��� �ٸ� �ʿ��� �÷� ��� ����
    -- ��, KING ����� �Ŵ���(mgr) ������ NULL �� �̱⿡ ��°��� ����
SELECT ename, sal, mgr
FROM emp
WHERE mgr = (SELECT mgr FROM emp WHERE ename = 'KING'); 


-- 2. ������ ��������
--  1) ������������ ��ȯ�Ǵ� �˻� ����� 2�� �̻��� ��������
--  2) ���� ������ where ���������� ������ ������(in, all, any,...)�� ����ؾ� ��

-- <IN ������>
-- : ���������� �˻���� �߿��� �ϳ��� ��ġ�ϸ� ���� ��
-- Q. �޿��� 3000�̻� �޴� ����� �Ҽӵ� �μ��� ������ �μ����� �ٹ��ϴ� ������� ���� ��� SQL��
    -- �� �μ��� �ִ�޿� ���ϱ�
    SELECT deptno, max(sal) FROM emp GROUP BY deptno;
    -- 30	2850
    -- 20	3000
    -- 10	5000
SELECT ename, sal, deptno 
FROM emp 
WHERE deptno IN (SELECT DISTINCT deptno FROM emp WHERE sal >= 3000);

-- <all ������>
-- : ���������� �������� ���������� �˻������ ��� ���� ��ġ�Ǹ� ��
-- Q. 30���μ��� �Ҽӵ� ��� �߿��� �޿��� ���� ���� �޴� ������� �� ���� �޿��� �޴� ����� �̸��� �޿� ���
    -- 30�� �μ��� �ִ�޿� �ݾ� ���ϱ�
    SELECT MAX(sal) FROM emp WHERE deptno=30;       --2850
--1) ���� �� ���������� ���ϱ�
SELECT ename, sal 
FROM emp
WHERE sal > (SELECT max(sal) FROM emp WHERE deptno = 30);

-- 2) ������ ���������� ���ϱ�
    -- ������ ���������� ��쿡��, �񱳿����ڸ��� ����ϴ°��� ����
    SELECT ename, sal 
    FROM emp
    WHERE sal > (SELECT sal FROM emp WHERE deptno = 30);    -- ���� �߻�
    -- ������ ��������
SELECT ename, sal 
FROM emp
WHERE sal > ALL (SELECT sal FROM emp WHERE deptno = 30);

-- <ANY ������>
-- : ���������� �������� ���������� �˻������ �ϳ� �̻� ��ġ�Ǹ� ��
-- Q. �μ���ȣ�� 30���� ������� �޿� �� ���� ���� �޿����� �� ���� �޿��� �޴� ������ �޿� ���
    -- 30�� �μ��� �ּұ޿�
    SELECT min(sal) FROM emp WHERE deptno = 30;
--1) ���� �� ���������� ���ϱ�
SELECT ename, sal, deptno
FROM emp
WHERE sal > (SELECT min(sal) FROM emp WHERE deptno = 30);

-- 2) ������ ���������� ���ϱ�
SELECT ename, sal, deptno
FROM emp
WHERE sal > ANY (SELECT sal FROM emp WHERE deptno = 30);


