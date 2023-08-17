-- 2023.08.17 과제

-- Q1. 사원테이블(emp)에서 입사일을 4자리 연도로 출력되도록 SQL문을 작성
SELECT '19' || to_char(hiredate) FROM emp;

-- Q2. 사원테이블(emp)에서 MGR컬럼의 값이 null인 데이터의 MGR의 값을 CEO로 출력하는 SWL문
SELECT ename,job, sal, NVL(to_char(mgr), 'CEO') AS "mgr" FROM emp;


