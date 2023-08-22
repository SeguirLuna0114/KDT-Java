-- 2018. 08. 21(월)

SELECT * FROM emp;
SELECT * FROM dept;

-- Q1. 직급이 manager인 사원의 이름, 부서명을 출력하는 SQL문(JOIN)을 사용하여 처리
    -- Oracle 초창기 사용 방법
SELECT ename, dname
FROM emp , dept
WHERE dept.deptno = emp.deptno
and job = 'MANAGER';

    -- INNER JOIN을 사용한 방법
SELECT ename, dname
FROM emp 
INNER JOIN dept
ON dept.deptno = emp.deptno
WHERE job = 'MANAGER';

    -- INNER JOIN - USING() 사용
SELECT ename, dname
FROM emp 
INNER JOIN dept
USING(deptno)
WHERE job = 'MANAGER';

    -- NATURAL JOIN 사용(공통컬럼의 이름이 같을 경우 사용 가능)
SELECT ename, dname
FROM emp 
NATURAL JOIN dept
WHERE job = 'MANAGER';


-- Q2. 매니저가 KING인 사원의 이름과 직급을 출력하는 SQL문
    -- SELF JOIN 사용
SELECT employee.ename, employee.job
FROM emp employee, emp manager
WHERE employee.mgr = manager.empno
AND manager.ename = 'KING';

    -- 서브쿼리 사용
SELECT ename, job
FROM emp
WHERE mgr = (SELECT empno from emp where ename = 'KING');


-- Q3. SCOTT과 동일한 근무지에서 근무하는 사원의 이름을 출력하는 SQL문  
    -- 사원의 이름이 SCOTT
    select ename, deptno from emp where ename = 'SCOTT';

SELECT ename, deptno
FROM emp
WHERE deptno = (SELECT deptno FROM emp WHERE ename = 'SCOTT');
-- FORD	    20
-- ADAMS	20
-- SCOTT	20
-- JONES	20
-- SMITH	20




