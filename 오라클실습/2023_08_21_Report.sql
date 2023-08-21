-- 2018. 08. 21(월)

SELECT * FROM emp;
SELECT * FROM dept;

-- Q1. 직급이 manager인 사원의 이름, 부서명을 출력하는 SQL문(JOIN)을 사용하여 처리
SELECT ename, dname
FROM emp , dept
where dept.deptno = emp.deptno
and job = 'MANAGER';


-- Q2. 매니저가 KING인 사원의 이름과 직급을 출력하는 SQL문
SELECT ename, job
FROM emp
WHERE mgr = (SELECT empno from emp where ename = 'KING');

-- Q3. SCOTT과 동일한 근무지에서 근무하는 사원의 이름을 출력하는 SQL문  
SELECT * FROM emp;
SELECT * FROM dept;
    -- 사원의 이름이 SCOTT
    select ename, deptno from emp where ename = 'SCOTT';

SELECT ename
FROM emp
WHERE deptno IN (SELECT deptno FROM emp WHERE ename = 'SCOTT');





