-- 2023. 08. 22(화)

SELECT * FROM emp;

-- Q1.SMITH와 동일한 직급을 가진 사원의 이름과 직급을 출력하는 SQL문
SELECT ename, job
FROM emp
WHERE job = (SELECT job FROM emp WHERE ename = 'SMITH');


-- Q2. 직급이 'SALESMAN'인 사원이 받는 급여들의 최대 급여보다 많이 받는 
--      사원들의 이름과 급여를 출력하되, 부서번호가 20번인 사원은 제외(ALL 연산자 이용)
SELECT ename, sal
FROM emp
WHERE sal > ALL (SELECT sal FROM emp WHERE job = 'SALESMAN')
AND deptno != 20;


-- Q3. 직급이 'SALESMAN'인 사원이 받는 급여들의 최소 급여보다 많이받는 사원들의
--      이름과 급여를 출력하되, 부서번호가 20번인 사원은 제외(ANY연산자 이용)
SELECT ename, sal, deptno
FROM emp
WHERE sal > ANY (SELECT sal FROM emp WHERE job = 'SALESMAN')
AND deptno != 20;

