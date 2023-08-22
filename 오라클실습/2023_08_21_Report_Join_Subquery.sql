-- 2018. 08. 21(��)

SELECT * FROM emp;
SELECT * FROM dept;

-- Q1. ������ manager�� ����� �̸�, �μ����� ����ϴ� SQL��(JOIN)�� ����Ͽ� ó��
    -- Oracle ��â�� ��� ���
SELECT ename, dname
FROM emp , dept
WHERE dept.deptno = emp.deptno
and job = 'MANAGER';

    -- INNER JOIN�� ����� ���
SELECT ename, dname
FROM emp 
INNER JOIN dept
ON dept.deptno = emp.deptno
WHERE job = 'MANAGER';

    -- INNER JOIN - USING() ���
SELECT ename, dname
FROM emp 
INNER JOIN dept
USING(deptno)
WHERE job = 'MANAGER';

    -- NATURAL JOIN ���(�����÷��� �̸��� ���� ��� ��� ����)
SELECT ename, dname
FROM emp 
NATURAL JOIN dept
WHERE job = 'MANAGER';


-- Q2. �Ŵ����� KING�� ����� �̸��� ������ ����ϴ� SQL��
    -- SELF JOIN ���
SELECT employee.ename, employee.job
FROM emp employee, emp manager
WHERE employee.mgr = manager.empno
AND manager.ename = 'KING';

    -- �������� ���
SELECT ename, job
FROM emp
WHERE mgr = (SELECT empno from emp where ename = 'KING');


-- Q3. SCOTT�� ������ �ٹ������� �ٹ��ϴ� ����� �̸��� ����ϴ� SQL��  
    -- ����� �̸��� SCOTT
    select ename, deptno from emp where ename = 'SCOTT';

SELECT ename, deptno
FROM emp
WHERE deptno = (SELECT deptno FROM emp WHERE ename = 'SCOTT');
-- FORD	    20
-- ADAMS	20
-- SCOTT	20
-- JONES	20
-- SMITH	20




