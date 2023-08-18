-- 2023. 08. 18
SELECT * FROM emp;
-- Q1.사원 테이블(emp)에서 가장 최근에 입사한 사원명을 출력하는 SQL문
    -- 서브쿼리 (SELECT MAX(hiredate) FROM emp)는 emp 테이블에서 가장 최근에 입사한 날을 찾고,
    -- 바깥쪽 쿼리에서는 가장 최근에 입사한 사원명(ename)과 입사일을 선택
SELECT ename, hiredate FROM emp WHERE hiredate = (SELECT MAX(hiredate) FROM emp);

    -- 정렬하여 출력값이 맞는지 확인
SELECT ename, hiredate FROM emp order by hiredate DESC;


-- Q2. 사원 테이블(emp)에서 최대 급여를 받는 사원명과, 최대 급여 금액을 출력하는 SQL문
    --  서브쿼리 (SELECT MAX(sal) FROM emp)는 emp 테이블에서 최대 급여 값을 찾고, 
    --  바깥쪽 쿼리에서는 그 최대 급여를 받는 직원의 이름(ename)과 급여(sal)를 선택
SELECT ename, sal FROM emp WHERE sal = (SELECT MAX(sal) FROM emp);

    -- 정렬하여 출력값이 맞는지 확인
SELECT ename, sal FROM emp order by sal DESC;




