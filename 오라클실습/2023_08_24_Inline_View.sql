-- 2023. 08. 24(목)

-- ROWNUM 컬럼
--  1. 데이터의 검색순서를 갖고 있는 논리적인 컬럼
--  2. rownum값은 1번 부터 시작
--  3. rownum값은 order by절로 정렬하더라도 값이 바뀌지 않음
--  4. rownum값을 변경하기 위해 테이블을 변경해야 함

SELECT ROWNUM, ROWID, deptno, dname, loc
FROM dept;
SELECT ROWNUM, ename, sal FROM emp;
SELECT ROWNUM, ename, sal FROM emp WHERE ename = 'WARD';

-- ORDER BY절을 이용해 정렬
SELECT ROWNUM, ename, sal FROM emp ORDER BY sal DESC;

-- Q1. 사원 테이블에서 입사일이 빠른 사원을 5명 구하는 SQL문
-- 1) 입사일이 빠른 사원순으로 정렬(입사일을 기준으로 오름차순 정렬)
SELECT empno, ename, hiredate 
FROM emp 
ORDER BY hiredate ASC;

-- 2) 단일뷰 생성
CREATE OR REPLACE VIEW hire_view AS
SELECT empno, ename, hiredate 
FROM emp 
ORDER BY hiredate ASC;

-- 3) 입사일이 빠른 사원 5명 출력
SELECT ROWNUM, ename, hiredate
FROM hire_view
WHERE ROWNUM <= 5;

-- 4) 인라인 뷰(서브쿼리로 만들어진 뷰)를 사용해 입사일이 빠른 사원 5명 검색
SELECT ROWNUM, ename, hiredate
FROM (
    SELECT empno, ename, hiredate
    FROM emp
    ORDER BY hiredate ASC
)
WHERE ROWNUM <= 5;

-- Q2. 사원 테이블에서 사원번호(empno)가 빠른 사원 5명을 구하는 SQL문
--1) 사원 번호가 빠른 사원순으로 정렬(사원번호를 기준으로 오름차순 정렬)
SELECT empno, ename FROM emp ORDER BY empno ASC;

-- 2) 뷰 생성
CREATE OR REPLACE VIEW emp_view AS
SELECT empno, ename
FROM emp ORDER BY empno ASC;

-- 3) 사원번호가 빠른 사원 5명 출력
SELECT ROWNUM, empno, ename 
FROM emp_view
WHERE ROWNUM <= 5;

-- 4) 인라인 뷰(서브쿼리 형태의 인라인 뷰)
    -- 사원번호가 빠른 사원 5명 검색
SELECT ROWNUM, empno, ename
FROM (
    SELECT * 
    FROM emp
    ORDER BY empno ASC
)
WHERE ROWNUM <= 5;


--Q. 사원 테이블에서 급여를 많이받는 사원 5명을 검색
--1) 급여를 많이 받는 사원순으로 정렬(급여를 기준으로 내림차순 정렬)
SELECT ename, sal FROM emp ORDER BY sal DESC;

-- 2) 뷰 생성
CREATE OR REPLACE VIEW sal_view AS
SELECT ename, sal
FROM emp ORDER BY sal DESC;

-- 3) 급여를 많이 받는 사원 5명 출력
SELECT ROWNUM, ename, sal 
FROM sal_view
WHERE ROWNUM <= 5;

-- 4) 인라인 뷰
    -- 급여를 많이 받는 사원 5명 검색
SELECT ROWNUM, ename, sal
FROM (
    SELECT *
    FROM emp
    ORDER BY sal DESC
)
WHERE ROWNUM < 6;

-- Q. ROWNUM을 이용해서 급여를 3~5번째로 많이받는 사원을 검색
-- 급여를 많이받는 사원 중 3번째
SELECT ROWNUM, ename, sal
FROM (
    SELECT emp.*, ROWNUM as rnum
    FROM (
        SELECT *
        FROM emp
        ORDER BY sal DESC
    ) emp
)
WHERE rnum BETWEEN 3 AND 5;






