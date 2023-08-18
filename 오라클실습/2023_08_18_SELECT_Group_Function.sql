-- 2023. 08. 18

-- 그룹함수 : 하나 이상의 데이터를 그룹으로 묶어서 연산을 수행하고,
--           하나의 결과로 처리해주는 함수
--    1. 그룹함수와 일반컬럼은 같이 사용할 수 없음
--      (그룹함수는 결과를 묶어서 하나의 결과(행)로 처리하기 때문)
--    2. 일반컬럼과 그룹함수는 같이 사용할 수 없으나, 
--       예외적으로 Group By절에 사용되는 컬럼은 그룹함수와 같이 사용 가능

-- # sum() : 합을 구해주는 함수
SELECT SUM(sal) FROM emp;       -- 급여의 총합
SELECT SUM(comm) FROM emp;      -- comm의 합(단, NULL값은 제외)
SELECT SUM(NVL(comm, 0)) AS COMM FROM emp;

-- 숫자로 이루어진 열이 아닌경우, 오류가 발생
SELECT SUM(ename) FROM emp;     -- 오류 발생

-- 그룹함수들끼리는 같이 사용할 수 있음(그룹함수는 결과를 묶어서 하나의 결과(행)로 처리하기 때문)
SELECT SUM(sal), SUM(comm) FROM emp;
-- 그룹함수와 일반컬럼은 같이 사용할 수 없음
SELECT sal, SUM(sal), SUM(comm) FROM emp;       -- 오류 발생

-- 각 부서의 급여 총합을 구하는 SQL문
SELECT SUM(sal) FROM emp WHERE deptno=10;       -- 8750
SELECT SUM(sal) FROM emp WHERE deptno=20;       -- 10875
SELECT SUM(sal) FROM emp WHERE deptno=30;       -- 9400
    -- 40번 부서에 속한 사원이 없기에, NULL(값이없음)로 출력됨
SELECT SUM(sal) FROM emp WHERE deptno=40;       -- NULL


-- # AVG() : 평균값을 구해주는 함수
SELECT AVG(sal) FROM emp;
SELECT AVG(sal), AVG(comm) FROM emp;
SELECT AVG(sal), AVG(comm) FROM emp where deptno = 10;
SELECT AVG(sal), AVG(comm) FROM emp where deptno = 20;
SELECT AVG(sal), AVG(comm) FROM emp where deptno = 30;
SELECT AVG(sal), AVG(comm) FROM emp where deptno = 40;


-- # Max() : 최대값을 구해주는 함수
-- Q1. 사원 테이블에서 최대 급여 금액을 구하는 SQL
SELECT MAX(sal) FROM emp;           -- 5000

SELECT MAX(sal) FROM emp WHERE deptno = 10;     -- 5000
SELECT MAX(sal) FROM emp WHERE deptno = 20;     -- 3000
SELECT MAX(sal) FROM emp WHERE deptno = 30;     -- 2850
SELECT MAX(sal) FROM emp WHERE deptno = 40;     -- NULL

-- Q2. 사원 테이블에서 최대 급여와 최대급여를 받는 사원명을 출력하는 SQL문
    -- 그룹함수와 일반컬럼은 같이 사용할 수 없음
SELECT ename, MAX(sal) FROM emp;        -- 오류 발생

    -- JOIN절을 사용
SELECT e.ename, e.sal from emp e
    JOIN (SELECT MAX(sal) AS max_sal FROM emp) max_salary_emp
    ON e.sal = max_salary_emp.max_sal;
     
    -- 서브쿼리 사용
    --  서브쿼리 (SELECT MAX(sal) FROM emp)는 emp 테이블에서 최대 급여 값을 찾고, 
    --  바깥쪽 쿼리에서는 그 최대 급여를 받는 직원의 이름(ename)과 급여(sal)를 선택
SELECT ename, sal FROM emp WHERE sal = (SELECT MAX(sal) FROM emp);

-- Q3. 사원 테이블에서 가장 최근에 입사한 입사일을 출력하는 SQL문
SELECT MAX(hiredate) FROM emp;          -- 87/07/13
SELECT hiredate FROM emp ORDER BY hiredate DESC;    -- 내림차순 정렬(최근날짜순)

-- Q4. 사원 테이블에서 사원명이 알파벳으로 가장 나중에 나오는 사원명을 구하는 SQL문
SELECT MAX(ename) FROM emp;             -- WARD
SELECT ename FROM emp ORDER BY ename DESC;    -- 내림차순 정렬(사전역순)


-- # MIN() : 최소값을 구해주는 함수
-- Q1. 사원 테이블에서 최소 급여 금액을 구하는 SQL
SELECT MIN(sal) FROM emp;           -- 800

SELECT MIN(sal) FROM emp WHERE deptno = 10;     -- 1300
SELECT MIN(sal) FROM emp WHERE deptno = 20;     -- 800
SELECT MIN(sal) FROM emp WHERE deptno = 30;     -- 950
SELECT MIN(sal) FROM emp WHERE deptno = 40;     -- NULL

-- Q2. 사원 테이블에서 가장 먼저 입사한 입사일을 구하는 SQL문
SELECT MIN(hiredate) FROM emp;          -- 80/12/17
SELECT hiredate FROM emp ORDER BY hiredate ASC;    -- 오름차순 정렬(가장 이른날짜순)

-- Q3. 사원 테이블에서 사원명이 알파벳으로 가장 먼저 나오는 사원명을 구하는 SQL문
SELECT MIN(ename) FROM emp;             -- ADAMS
SELECT ename FROM emp ORDER BY ename ASC;    -- 오름차순 정렬(사전순)

-- 그룹 함수들은 같이 사용할 수 있음
SELECT SUM(sal), AVG(sal), MAX(sal), MIN(sal) from emp;
SELECT SUM(sal), AVG(sal), MAX(sal), MIN(sal) from emp WHERE deptno = 10;
SELECT SUM(sal), AVG(sal), MAX(sal), MIN(sal) from emp WHERE deptno = 20;
SELECT SUM(sal), AVG(sal), MAX(sal), MIN(sal) from emp WHERE deptno = 30;


-- # count() : 총 데이터 갯수를 구해주는 함수
-- 형식 : count(컬럼명)
SELECT COUNT(sal) FROM emp;         -- 14
SELECT COUNT(mgr) FROM emp;         -- 13(NULL값은 counting하지 X)
SELECT COUNT(*) FROM emp WHERE mgr IS NULL; -- 1(NULL값은 1개)
SELECT COUNT(NVL(mgr, 0)) FROM emp;     -- 14

SELECT COUNT(comm) FROM emp;        -- 4(NULL값은 counting하지 X)
SELECT COUNT(*) FROM emp WHERE comm IS NULL;    -- 10(NULL값은 10개)
SELECT count(NVL(comm, 0)) FROM emp;    -- 14

SELECT COUNT(empno) FROM emp;       -- 14: empno컬럼은 기본키 제약조건이 설정됨

    -- count(*): 모든 데이터 갯수를 구해줌
    -- count(*)를 제외한 모든 Group Function은 Null을 배제하고 수행됨
SELECT COUNT(*) FROM emp;           -- 14(NULL값을 포함하고 수행)

-- Q1. 사원 테이블에서 중복행을 제거한 JOB의 갯수를 구하는 SQL문
-- 1) JOB의 갯수 구하기
SELECT count(job) FROM emp;         -- 14(중복 데이터도 counting)

SELECT job FROM emp;
SELECT DISTINCT job from emp;       -- 중복행을 제거한 job출력(5가지)

-- 2) 중복 행을 제거한 job의 갯수
SELECT count(DISTINCT job) FROM emp;    -- 5
