-- 2018. 08. 21(��)

SELECT * FROM emp;
SELECT * FROM dept;

-- Q1. ������ manager�� ����� �̸�, �μ����� ����ϴ� SQL��(JOIN)�� ����Ͽ� ó��
SELECT ename, dname
FROM emp , dept
where dept.deptno = emp.deptno
and job = 'MANAGER';


-- Q2. �Ŵ����� KING�� ����� �̸��� ������ ����ϴ� SQL��
SELECT ename, job
FROM emp
WHERE mgr = (SELECT empno from emp where ename = 'KING');

-- Q3. SCOTT�� ������ �ٹ������� �ٹ��ϴ� ����� �̸��� ����ϴ� SQL��  
SELECT * FROM emp;
SELECT * FROM dept;
    -- ����� �̸��� SCOTT
    select ename, deptno from emp where ename = 'SCOTT';

SELECT ename
FROM emp
WHERE deptno IN (SELECT deptno FROM emp WHERE ename = 'SCOTT');





