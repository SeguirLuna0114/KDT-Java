-- 2023. 08. 18

-- Group By 절 : 특정 컬럼을 기준으로 테이블에 존재하는 데이터를 
--               그룹으로 구분하여 처리하는 역할 수행
--    1. 일반컬럼과 그룹함수는 같이 사용할 수 없으나, 
--       예외적으로 Group By절에 사용되는 컬럼은 그룹함수와 같이 사용 가능

-- Q. 각 부서(10, 20, 30)의 급여 합, 평균급여, 최대급여, 최소급여를 구하는 SQL문
SELECT SUM(sal), AVG(sal), MAX(sal), MIN(sal) from emp WHERE deptno = 10;
SELECT SUM(sal), AVG(sal), MAX(sal), MIN(sal) from emp WHERE deptno = 20;
SELECT SUM(sal), AVG(sal), MAX(sal), MIN(sal) from emp WHERE deptno = 30;

--  일반컬럼과 그룹함수는 같이 사용할 수 없으나, 
--  예외적으로 Group By절에 사용되는 컬럼은 그룹함수와 같이 사용 가능
SELECT deptno, SUM(sal), AVG(sal), MAX(sal), MIN(sal) FROM emp
    GROUP BY deptno ORDER BY deptno ASC;
    
-- Q1. job컬럼을 기준으로 급여의 합, 평균급여, 최대급여, 최소급여를 구하는 SQL문
SELECT job, SUM(sal), AVG(sal), MAX(sal), MIN(sal) FROM emp
    GROUP BY job;

SELECT SUM(sal), AVG(sal), MAX(sal), MIN(sal), job FROM emp
    GROUP BY job;   -- 열과 집계함수(열) 순서는 바뀌어도 상관X
    
-- Q2. 각 부서별(10, 20, 30) 사원수와 커미션을 받는 사원수를 구하는 SQL문
SELECT deptno, count(*) AS 사원수, COUNT(comm) AS 커미션 FROM emp
    GROUP BY deptno ORDER BY deptno ASC;

SELECT DECODE(deptno, 10, '부서1', 20, '부서2', 30, '부서3'),
        count(*) AS 사원수, COUNT(comm) AS 커미션
FROM emp
GROUP BY deptno;
