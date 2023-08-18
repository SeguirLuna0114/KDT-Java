-- 2023.08.18

-- 3. 날짜 처리 함수(Date Function)
-- sysdate : 현재 시스템 날짜와 시간을 반환하는 함수
SELECT sysdate FROM dual;           -- 23/08/18

SELECT sysdate-1 어제, sysdate 오늘, sysdate 내일 FROM dual;
--          23/08/17	23/08/18	23/08/18

-- Q. 사원 테이블에서 각 사원들의 현재까지 근무한 근무일수를 구하는 SQL문
SELECT ename, sysdate - hiredate from emp;
    -- round()함수를 사용해 소수점 첫째자리에서 반올림 => 정수 반환
SELECT ename, round(sysdate - hiredate) FROM emp;       
    -- trunc()함수를 사용해 소수점 아래를 버림
SELECT ename, trunc(sysdate - hiredate) FROM emp;

-- months_between(): 두 날짜 사이의 경과된 개월수를 구해주는 함수
-- 형식 :  months_between(date1, date2)
-- Q. 사원 테이블에서 각 사원들의 근무한 개월수를 구하는 SQL문
SELECT months_between(sysdate, hiredate) FROM emp;  -- 양수 개월수 출력
SELECT months_between(hiredate, sysdate) FROM emp;  -- 음수 개월수 출력
SELECT MONTHS_BETWEEN('2023-08-01', '2023-04-01') AS months_diff FROM dual;

    -- round()함수를 사용해 소수점 첫째자리에서 반올림 => 정수 반환
SELECT round(months_between(sysdate, hiredate)) FROM emp;
    -- trunc()함수를 사용해 소수점 아래를 버림
SELECT trunc(months_between(sysdate, hiredate)) FROM emp;


-- add_months() : 특정 날짜에 경과된 날짜를 구해주는 함수
-- 형식: add_months(date, 개월수)
-- Q1. 사원 테이블에서 각 사원들의 입사한 날짜에 6개월이 경과된 일자를 구하는 SQL문
SELECT ename, hiredate, add_months(hiredate, 6) FROM emp;

-- Q2. 우리과정 입과후에 6개월이 경과된 일자를 구하는 SQL문
SELECT add_months('23/07/11', 6) FROM dual;         -- 24/01/11


-- next_day() : 해당 요일의 가장 가까운 날짜를 구해주는 함수
-- 형식 : next_date(date, 요일)
-- Q1. 오늘을 기준으로 가장 가까운 토요일이 언제인지 구하는 SQL문
SELECT sysdate, next_day(sysdate, '토요일') FROM dual;     -- 23/08/19
SELECT sysdate, next_day(sysdate, '토') FROM dual;

-- Q2. 오늘을 기준으로 가장 가까운 월요일이 언제인지 구하는 SQL문
SELECT sysdate, next_day(sysdate, '월요일') FROM dual;     -- 23/08/21
SELECT sysdate, next_day(sysdate, '월') FROM dual;


-- last_day() : 해당 달의 마지막 날짜를 구해주는 함수
-- Q1. 각 사원들이 입사한 달의 마지막 날짜를 구해주는 SQL문
SELECT hiredate, last_day(hiredate) FROM emp;

-- Q2. 이번 달의 가장 마지막 날짜를 구하는 SQL문
SELECT sysdate, last_day(sysdate) FROM dual;

-- Q3. 2023년 및 2020년 2월달의 마지막 날짜를 구하는 SQL문
SELECT last_day('23/02/01') from dual;          -- 23/02/28
SELECT last_day('20/02/01') from dual;          -- 20/02/28

