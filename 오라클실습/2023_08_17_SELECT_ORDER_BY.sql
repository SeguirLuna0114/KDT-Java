-- 2023.08.17(목)

-- 정렬
-- 형식) ORDER BY 컬럼명 정렬방식[ASC/DESC]
-- 정렬방식: 오름차순(Ascending), 내림차순(Descending)
        -- 정렬방식(ASC/DESC)이 생략이되면, 기본 정렬방식은 오름차순으로 정렬

--              오름차순(ASC)                       내림차순(DESC)
-----------------------------------------------------------------------------
-- 숫자   :   작은 숫자부터 큰 숫자 순으로 정렬         큰 숫자부터 작은 숫자 순으로 정렬
--                (1, 2, 3,....)                        (99, 98,....1)
-- 문자   :   사전 순 정렬(a, b, c...)               사전 역순 정렬(z, y, x,...)
-- 날짜   :   빠른 날짜순으로 정렬                     늦은 날짜순으로 정렬
-- NULL  :   NULL값이 가장 마지막에 출력              NULL값이 가장 먼저 출력

-- 1. 숫자 데이터 정렬
-- Q1. 사원 테이블에서 급여를 기준으로 오름차순 정렬
SELECT * FROM emp ORDER BY sal ASC;
SELECT * FROM emp ORDER BY sal;             -- 기본정렬방식 ASC(생략가능)

-- Q2. 사원 테이블에서 급여를 기준으로 내림차순 정렬
SELECT * FROM emp ORDER BY sal DESC;


-- 2. 문자 데이터 정렬
-- Q1. 사원 테이블에서 사원명을 기준으로 오름차순 정렬(사전순 정렬)
SELECT * FROM emp ORDER BY ename ASC;
SELECT * FROM emp ORDER BY ename;       -- ASC정렬방식은 생략 가능

-- Q2. 사원 테이블에서 사원명을 기준으로 내림차순 정렬(사전역순 정렬)
SELECT * FROM emp ORDER BY ename DESC;


-- 3. 날짜 데이터 정렬
-- Q1. 사원 테이블에서 입사일을 기준으로 오름차순(과거 -> 미래) 정렬
SELECT * FROM emp ORDER BY hiredate ASC;
SELECT * FROM emp ORDER BY hiredate;       -- ASC정렬방식은 생략 가능

-- Q2. 사원 테이블에서 입사일을 기준으로 내림차순(미래 -> 과거) 정렬
SELECT * FROM emp ORDER BY hiredate DESC;


-- 4. NULL값 정렬
--     1) 오름차순 정렬 : NULL값이 가장 마지막에 출력
--     2) 내림차순 정렬 : NULL값이 가장 먼저 출력
-- Q1. MGR 컬럼을 기준으로 오름차순 정렬: NULL값이 가장 마지막에 출력
SELECT * FROM emp ORDER BY mgr ASC;

-- Q2. MGR 컬럼을 기준으로 내림차순 정렬: NULL값이 가장 먼저 출력
SELECT * FROM emp ORDER BY mgr DESC;

-- Q3. COMM 컬럼을 기준으로 오름차순 정렬: NULL값이 가장 마지막에 출력
SELECT * FROM emp ORDER BY comm ASC;

-- Q4. COMM 컬럼을 기준으로 내림차순 정렬: NULL값이 가장 먼저 출력
SELECT * FROM emp ORDER BY comm DESC;


-- 여러번 정렬하기
-- 1. 한번 정렬했을 때 동일한 결과의 데이터가 있을 경우에는 한번 더 정렬해야 함
-- 2. 두번째 정렬 조건은 한번 정렬 했을 때 동일한 결과가 나온 데이터만
--    두번째 정렬조건의 적용을 받음
-- 3. 댓글 게시판을 만드는 경우에 주로 사용

-- * 2번 정렬하는 문제
-- Q1. 사원 테이블에서 입사일을 기준으로 오름차순 정렬하되, 만약 동일한 입사일에 
--     입사한 경우에는 사원명을 기준으로 내림차순 정렬해서 출력하는 SQL문
SELECT * FROM emp ORDER BY hiredate ASC, ename DESC;

-- Q2. 사원 테이블에서 급여를 기준으로 내림차순으로 정렬하되, 동일한 급여를 받는
--     사원들은 사원명을 기준으로 오름차순 정렬해서 출력하는 SQL문
SELECT * FROM emp ORDER BY sal DESC, ename ASC;

-- Q3. 사원 테이블에서 부서번호(deptno)를 기준으로 오름차순 정렬하고, 이때 동일한
--     부서에 소속된 경우에는 입사일(hiredate)을 기준으로 내림차순으로 정렬해서 출력하는 SQL문
SELECT * FROM emp ORDER BY deptno ASC, hiredate DESC;

