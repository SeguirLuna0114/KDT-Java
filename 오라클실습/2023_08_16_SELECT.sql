-- 2023.08.16(수)

-- # 테이블 목록 출력 "SELECT * FROM tab"
SELECT * FROM tab;
    -- DEPT: 부서 테이블
    -- EMP: 사원 테이블
    -- BONUS: 상여금(데이터 없는 상태)
    -- SALGRADE: 사원 급여등급


-- # 테이블 구조 확인 "DESCRIBE 테이블명"
    -- DESCRIBE 테이블명 : 테이블의 구조 출력
    -- DESC 테이블명    (DESCRIBE와 같음)
-- DEPT 테이블 구조
DESCRIBE dept;
desc dept;

-- EMP 테이블 구조
DESCRIBE emp;


-- # 테이블 데이터 검색 "SELECT * FROM 테이블명"
    -- SELECT * FROM 테이블명 : 테이블의 모든 행 데이터 검색
-- DEPT 테이블 데이터 검색
SELECT * FROM dept;
SELECT * FROM DEPT;         -- SQL문은 대소문자 구분X

-- EMP 테이블 데이터 검색
SELECT * FROM emp;


-- 오라클의 데이터 타입
--1.숫자 데이터
-- number(n) 
-- ex) number(2) : 정수 2자리까지 저장
-- number(n1, n2) : n1 - 전체 자리수
--                  n2 - 소숫점에 할당된 자리수
-- ex) number(7, 2) : 전체 자리수 7자리
--                    소숫점에 2자리
--2.문자 데이터
-- char() : 고정 길이 문자형
--          최대 2000 byte 까지 저장 가능함.
-- varchar2() : 가변 길이 문자형
--              최대 4000 byte 까지 저장 가능함.
-- long : 2GB 까지 저장 가능함.
--        long 형으로 설정된 컬럼은 검색 기능을 지원하지 않는다.
--3.날짜 데이터
-- date : 연/월/일 정보 저장
-- timestamp : 연/월/일 시:분:초 정보 저장


-- # SELECT SQL문
    -- select * from 테이블명: 해당 테이블의 모든 데이터 출력
    -- select 컬럼명 from 테이블명: 해당 테이블에서 선택한 컬럼의 데이터만 출력
    --    => 테이블의 순서를 임의로 변경 가능

SELECT * FROM dept;
SELECT loc, dname, deptno FROM dept;

SELECT * FROM emp;
SELECT empno, ename, sal  FROM emp;

-- **select문에서 산술연산 가능
    -- 산술연산자: +, -, *, /
    -- null값은 산술연산이 되지X => null로 처리됨
SELECT sal + comm FROM emp;
SELECT sal + 100 FROM emp;
SELECT sal - 100 FROM emp;
SELECT sal * 100 FROM emp;
SELECT sal / 100 FROM emp;

-- NULL     1. 정해지지 않은 값
--          2. NULL값은 산술연산을 할 수 없음
--          3. NULL값의 예
--              ex) EMP테이블 :  NGR컬럼 - KING사원은 NGR컬럼이 NULL
--                              COMM 컬럼 - job이 SALESMAN인 사원만 값을 가짐

-- Q. 사원 테이블(emp)에 소속된 사원들의 연봉을 출력
    -- 연봉 = 급여(sal) * 12 + 커미션(comm)
SELECT sal*12, comm  FROM emp;

-- sal * 12 + comm : null값은 산술연산이 되지 않기 때문에,
--                   job이 SALESMAN인 사원만 연봉 계산이 됨
SELECT ename, job, sal, comm, sal*12+comm FROM emp;

-- # NVL(컬럼, 변환할 값)함수 : NULL값을 다른값(0)으로 변환해주는 역할
-- ex) NVL(COMM, 0) : COMM컬럼의 NULL값을 0으로 치환하라는 의미
-- *올바른 연봉계산 SQL문 작성
SELECT ename, job, sal, comm, sal*12+comm, sal*12+NVL(comm, 0) FROM emp;

-- # 별칭부여: AS "별칭명"
SELECT ename, sal*12+nvl(comm, 0) AS "Annual" from emp;
    -- AS 생략 가능
SELECT ename, sal*12+nvl(comm, 0) "Annual" from emp;
    -- 쌍따옴표("") 생략 가능
SELECT ename, sal*12+nvl(comm, 0) AS Annual from emp;

-- 한글 별칭명 부여
SELECT ename, sal*12+nvl(comm, 0) AS "연봉" from emp;
    -- AS 생략 가능
SELECT ename, sal*12+nvl(comm, 0) "연봉" from emp;
SELECT ename, sal*12+nvl(comm, 0) "연 봉" from emp;
    -- 쌍따옴표("") 생략 가능(단, 띄어쓰기 없는 경우에만)
SELECT ename, sal*12+nvl(comm, 0) AS 연봉 from emp;
    -- 별칭명에 띄어쓰기 한 경우에는 별칭명 좌우에 쌍따옴표 붙여야 함
-- SELECT ename, sal*12+nvl(comm, 0) AS 연 봉 from emp;  -- 오류발생


-- Concatenation 연산자 (||) : 컬럼과 문자열을 연결할 때 사용
SELECT ename, ' is a ', job FROM emp;
SELECT ename || ' is a ' || job FROM emp;

-- distinct : 중복행을 제거하고 1번만 출력하게 하는 역할
    -- 14개의 데이터 출력
SELECT deptno FROM emp;
    -- 3개의 부서번호만 출력: 10, 20, 30
SELECT DISTINCT deptno from emp;


-- Q1. EMP테이블에서 각 사원들의 job을 1번만 출력하는 SQL문 작성
    -- job컬럼의 데이터 14개 전부 출력
SELECT job FROM emp;
    -- 중복행을 제거한 후, 5개의 job만 출력
SELECT DISTINCT job FROM emp;

-- Q2. EMP테이블에서 중복을 제거한 job의 개수를 출력
    -- count(컬럼명) : 컬럼의 데이터 개수를 구하는 함수
SELECT count(*) FROM dept;
SELECT count(*) FROM emp;               -- 14
    -- count(DISTINCT 컬럼명) : 중복을 제거한 특정컬럼의 값의 개수 계산
SELECT count(DISTINCT job) FROM emp;    -- 5


-- # Where 조건절 : 비교연산자(=, >, >=, <, <=, !=, ^=, <>)

-- 1. 숫자 데이터 검색
-- Q. 사원 테이블에서 급여를 3000이상 받는 사원을 검색하는 SQL문 작성
SELECT * FROM emp WHERE sal >= 3000;

-- Q. 급여가 3000인 사원을 검색하는 SQL문
SELECT * FROM emp WHERE sal = 3000;

-- Q3. 급여가 3000이 아닌 사원을 검색하는 SQL문 작성
SELECT * FROM emp WHERE sal != 3000;
SELECT * FROM emp WHERE sal ^= 3000;
SELECT * FROM emp WHERE sal <> 3000;

-- Q4. 급여가 1500 이하인 사원의 사원번호, 사원명, 급여를 출력하는 SQL문
SELECT empno, ename, sal FROM emp WHERE sal <= 1500;


-- 2. 문자 데이터 검색
    -- 1) 문자 데이터를 검색할 때에는 문자열 좌우에 외따옴표('문자열')를 붙여야 함
    -- 2) 문자 데이터는 대소문자를 구분

-- Q1. 사원테이블에서 사원명이 FORD인 사원의 정보를 검색하는 SQL문
SELECT * FROM emp WHERE ename = 'ford';     -- 대소문자 구분
-- SELECT * FROM emp WHERE ename = FORD;    -- 오류(문자열 좌우 외따옴표)
--SELECT * FROM emp WHERE ename = "FORD";   -- 오류(쌍따옴표는 별칭명 부여시에만 사용)
SELECT * FROM emp WHERE ename = 'FORD';

-- Q2. SCOTT사원의 사원번호, 사원명, 급여를 출력하는 SQL문 작성
SELECT empno, ename, sal FROM emp WHERE ename = 'SCOTT';


-- 3. 날짜 데이터 검색
    -- 1) 날짜데이터 좌우에 외따옴표(')를 붙여서 사용
    -- 2) 날짜데이터 비교할 경우에는 비교연산자 사용

-- Q1. 1982년 1월 1일 이후에 입사한 사원을 검색하는 SQL문
--SELECT * FROM emp WHERE hiredate >= 82/01/01;       --오류발생
SELECT * FROM emp WHERE hiredate >= '82/01/01';         -- 외따옴표 필요
SELECT * FROM emp WHERE hiredate >= '1982/01/01';

-- Q2. 1982년 1월 1일 이후에 입사한 사원을 검색하고, 입사일 기준으로 오름차순 정렬
SELECT * FROM emp WHERE hiredate >= '1982/01/01' ORDER BY hiredate ASC;
