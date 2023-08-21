-- 2018. 08. 21(월)

-- 서브쿼리

-- Q. SCOTT사원이 소속된 부서명을 출력하는 SQL
-- 두개의 SQL문을 사용
    -- 1) 사원테이블(EMP)에서 SCOTT사원의 부서번호를 구함
    SELECT deptno FROM emp WHERE ename = 'SCOTT';       -- 20
    -- 2) 부서테이블(DEPT)에서 20번 부서의 부서명을 구함
    SELECT dname FROM dept WHERE deptno=20;     -- RESEARCH

-- 서브쿼리 이용하는 방법
SELECT dname FROM dept                                          -- 메인 쿼리
WHERE deptno = (SELECT deptno FROM emp WHERE ename='SCOTT');    -- 서브 쿼리

-- JOIN으로 구하기
-- 1) CROSS JOIN과 WHERE 절의 조합
SELECT dname FROM dept, emp 
WHERE dept.deptno = emp.deptno AND ename = 'SCOTT';
-- 2) INNER JOIN - ON절
SELECT dname FROM dept
INNER JOIN emp ON dept.deptno = emp.deptno
WHERE ename = 'SCOTT';
-- 3) INNER JOIN - USING절
SELECT dname FROM dept
INNER JOIN emp USING(deptno)
WHERE ename = 'SCOTT';
-- 4) NATURAL JOIN
SELECT dname FROM dept
NATURAL JOIN emp
WHERE ename = 'SCOTT';


-- 1. 단일 행 서브쿼리 (Single-row Subquery)
--  1) 서브쿼리의 검색결과가 1개만 반환되는 쿼리
--  2) 메인쿼리의 where 조건절에서 비교연산자만 사용 가능

-- Q1. 사원 테이블에서 가장 최근에 입사한 사원명을 출력하는 SQL문
SELECT ename, hiredate
FROM emp
WHERE hiredate = (SELECT MAX(hiredate) FROM emp);
-- SCOTT	87/07/13
-- ADAMS	87/07/13

-- Q2. 사원 테이블에서 최대급여를 받는 사원명과 최대급여 금액을 출력하는 SQL문
    -- 오류 발생: 그룹함수와 일반컬럼은 같이 사용할 수 X
SELECT ename, MAX(sal) FROM emp;        -- 오류 발생

SELECT ename, sal
FROM emp
WHERE sal = (SELECT MAX(sal) FROM emp);
-- KING	5000

-- Q3. 직속상사가 KING인 사원의 사원명과 급여를 출력하는 SQL문
    -- 서브쿼리: emp 테이블에서 이름이 'KING'인 직원의 직원 번호(empno)를 검색
    -- 메인쿼리: 서브쿼리의 KING 직원의 직원 번호(empno)를 이용하여 
    --          상사(mgr)가 KING의 직원 번호와 동일한 직원들의 이름(ename), 월급(sal), 상사(mgr) 정보를 가져옴
    --          (메인 쿼리의 mgr 컬럼 값과 서브쿼리의 결과인 empno 값을 비교)
SELECT ename, sal, mgr
FROM emp
WHERE mgr = (SELECT empno FROM emp WHERE ename = 'KING');   -- "mgr" 열(상사의 직원 번호)이 KING 직원의 직원 번호와 일치하는 레코드를 필터링
-- KING	5000	

    -- 이때, 'KING' 사원과 관련된 정보를 가져오려는 것이기에,
    -- empno 대신 다른 필요한 컬럼 사용 가능
    -- 단, KING 사원의 매니저(mgr) 정보가 NULL 값 이기에 출력값이 없음
SELECT ename, sal, mgr
FROM emp
WHERE mgr = (SELECT mgr FROM emp WHERE ename = 'KING'); 


-- 2. 다중행 서브쿼리
--  1) 서브쿼리에서 반환되는 검색 결과가 2개 이상인 서브쿼리
--  2) 메인 쿼리의 where 조건절에서 다중행 연산자(in, all, any,...)를 사용해야 함

-- <IN 연산자>
-- : 서브쿼리의 검색결과 중에서 하나라도 일치하면 참이 됨
-- Q. 급여를 3000이상 받는 사원이 소속된 부서와 동일한 부서에서 근무하는 사원들의 정보 출력 SQL문
    -- 각 부서별 최대급여 구하기
    SELECT deptno, max(sal) FROM emp GROUP BY deptno;
    -- 30	2850
    -- 20	3000
    -- 10	5000
SELECT ename, sal, deptno 
FROM emp 
WHERE deptno IN (SELECT DISTINCT deptno FROM emp WHERE sal >= 3000);

-- <all 연산자>
-- : 메인쿼리의 비교조건이 서브쿼리의 검색결과와 모든 값이 일치되면 참
-- Q. 30번부서에 소속된 사원 중에서 급여를 가장 많이 받는 사원보다 더 많은 급여를 받는 사원의 이름과 급여 출력
    -- 30번 부서의 최대급여 금액 구하기
    SELECT MAX(sal) FROM emp WHERE deptno=30;       --2850
--1) 단일 행 서브쿼리로 구하기
SELECT ename, sal 
FROM emp
WHERE sal > (SELECT max(sal) FROM emp WHERE deptno = 30);

-- 2) 다중행 서브쿼리로 구하기
    -- 단일행 서브쿼리인 경우에만, 비교연산자만을 사용하는것이 가능
    SELECT ename, sal 
    FROM emp
    WHERE sal > (SELECT sal FROM emp WHERE deptno = 30);    -- 오류 발생
    -- 다중행 서브쿼리
SELECT ename, sal 
FROM emp
WHERE sal > ALL (SELECT sal FROM emp WHERE deptno = 30);

-- <ANY 연산자>
-- : 메인쿼리의 비교조건이 서브쿼리의 검색결과와 하나 이상 일치되면 참
-- Q. 부서번호가 30번인 사원들의 급여 중 가장 낮은 급여보다 더 높은 급여를 받는 사원명과 급여 출력
    -- 30번 부서의 최소급여
    SELECT min(sal) FROM emp WHERE deptno = 30;
--1) 단일 행 서브쿼리로 구하기
SELECT ename, sal, deptno
FROM emp
WHERE sal > (SELECT min(sal) FROM emp WHERE deptno = 30);

-- 2) 다중행 서브쿼리로 구하기
SELECT ename, sal, deptno
FROM emp
WHERE sal > ANY (SELECT sal FROM emp WHERE deptno = 30);


