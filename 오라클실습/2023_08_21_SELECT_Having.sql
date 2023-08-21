-- 2023. 08. 21

-- Having 조건절
--  : Group By 절이 사용되는 경우에, 데이터 제한을 가하기 위해서 where조건절 대신,
--    having 조건절을 사용해야 함

-- Q1. 부서별(10, 20, 30) 평균급여 금액이 2000이상인 부서만 출력하는 SQL문
-- 1) 각 부서별 평균급여 금액 출력
SELECT deptno, AVG(sal) FROM emp GROUP BY deptno;
-- 30	1566.666666666666666666666666666666666667
-- 20	2175
-- 10	2916.666666666666666666666666666666666667

-- 2) 평균 급여 금액이 2000이상인 부서만 출력
    -- 그룹함수는 WHERE절에 올수 없음 => 오류 발생
SELECT deptno, avg(sal) FROM emp GROUP BY deptno
        WHERE AVG(sal) >= 2000;         -- 오류 발생      
    -- group by절이 사용되는 경우에는 having 조건절을 사용하여 그룹함수를 조건절에 적용
SELECT deptno, avg(sal) FROM emp GROUP BY deptno
        HAVING AVG(sal) >= 2000;
        
-- Q2. 각 부서별(10, 20, 30) 최대급여 금액이 2900 이상인 부서만 출력하는 SQL문
-- 1) 각 부서별 최대금액을 출력
SELECT deptno, MAX(sal) FROM emp GROUP by deptno;
-- 30	2850
-- 20	3000
-- 10	5000

-- 2) 최대 급여 금액이 2900 이상인 부서만 출력
    -- 그룹함수는 WHERE절에 올수 없음 => 오류 발생
SELECT deptno, MAX(sal) FROM emp GROUP by deptno
        WHERE MAX(sal) >= 2900;     -- 오류 발생
    -- group by절이 사용되는 경우에는 having 조건절을 사용해야 함
SELECT deptno, MAX(sal) FROM emp GROUP by deptno
        HAVING MAX(sal) >= 2900;  




