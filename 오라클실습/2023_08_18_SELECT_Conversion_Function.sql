-- 2023. 08. 18

-- * 형 변환 함수(Conversion Function)
--  : to_char(), to_date(), to_number()

-- 1. to_char() : 날짜형, 숫자형 데이터를 문자형으로 변환해주는 함수
--  1) 날짜형 데이터를 문자형으로 변환
--      형식: to_char(날짜 데이터, '출력형식')
-- Q1. 현재 시스템의 날짜를 연, 월, 일, 시, 분, 초, 요일로 출력
SELECT sysdate FROM dual;       -- 현재시간(23/08/18)

SELECT to_char(sysdate, 'YYYY-MM-DD HH:MI:SS DAY') FROM dual;
SELECT to_char(sysdate, 'YYYY-MM-DD HH:MI:SS DY') FROM dual;
SELECT to_char(sysdate, 'yyyy-mm-dd hh:mi:ss day') FROM dual;   -- 대소문자 구분X

-- Q2. 사원 테이블에서 각 사원들의 입사일을 연, 월, 일, 시, 분, 초, 요일로 출력하는 SQL문
SELECT ename, to_char(hiredate, 'YYYY-MM-DD HH24:MI:SS DAY') FROM emp;
SELECT ename, to_char(hiredate, 'YYYY-MM-DD HH24:MI:SS DAY') FROM emp;
SELECT ename, to_char(hiredate, 'YYYY"년 "MM"월 "DD"일 "HH24"시 "MI"분" SS"초" DAY') FROM emp;

--  2) 숫자형 데이터를 문자형으로 변환
-- 형식: to_char(숫자 데이터, '구분기호')
-- Q1. 숫자 1230000을 3자리씩 컴마로 구분해서 출력
SELECT to_char(1230000, '0,999,999') FROM dual;
    -- 0으로 자리수를 지정하면, 데이터의 길이가 9자리가 되지 않으면 0으로 채움
SELECT 1230000, to_char(1230000, '000,000,000') FROM dual;      --  001,230,000
    -- 9로 자리수를 지정하면, 데이터의 길이가 9자리가 되지 않아도 채우지 않음
SELECT 1230000, to_char(1230000, '999,999,999') FROM dual;      --    1,230,000

-- Q2. 사원 테이블에서 각 사원들의 급여를 3자리씩 컴마(,)로 구분해서 출력하는 SQL문
SELECT ename, sal, to_char(sal, '9,999') FROM emp;
    -- 'L'을 사용해서 각 지역별 통화기호를 나타냄(앞/뒤 가능)
SELECT ename, sal, to_char(sal, 'L9,999') FROM emp;
SELECT ename, sal, to_char(sal, '9,999L') FROM emp;


-- 2. to_date() : 문자형 데이터를 날짜형으로 변환해주는 함수
-- 형식: to_date('문자데이터', '날짜 format')
-- Q1. 2023년 1월 1일부터 현재까지 경과된 일수를 구하는 SQL문
    -- 오류발생(날짜데이터와 문자데이터 연산은 불가)
SELECT sysdate - '2023/01/01' FROM dual;    
    -- to_date함수로 문자데이터 -> 날짜데이터 변환하여 연산 수행
SELECT sysdate - to_date('2023/01/01', 'yyyy/mm/dd') FROM dual;
    -- ROUND 함수는 숫자를 반올림하여 지정한 소수 자릿수까지 표현
SELECT round(sysdate - to_date('2023/01/01', 'yyyy/mm/dd')) FROM dual;
    -- TRUNC 함수는 소수점 아래를 버리는 함수
SELECT trunc(sysdate - to_date('2023/01/01', 'yyyy/mm/dd')) FROM dual;

-- Q2. 2023년 12월 25일 크리스마스까지 남은 일수를 구하는 SQL문 작성
SELECT to_date('2023/12/25', 'yyyy/mm/dd') - sysdate FROM dual;
    -- ROUND 함수는 숫자를 반올림하여 지정한 소수 자릿수까지 표현
SELECT round(to_date('2023/12/25', 'yyyy/mm/dd') - sysdate) FROM dual;
    -- TRUNC 함수는 소수점 아래를 버리는 함수
SELECT trunc(to_date('2023/12/25', 'yyyy/mm/dd') - sysdate) FROM dual;

-- Q3. 우리 과정 교육기간(2023.07.11 ~ 2024.01.19)의 일수를 구하는 SQL문
SELECT to_date('2024.01.19', 'yyyy/mm/dd') - to_date('2023.07.11', 'yyyy/mm/dd') FROM dual;
SELECT (to_date('2024.01.19', 'yyyy/mm/dd') - to_date('2023.07.11', 'yyyy/mm/dd')) || '일' FROM dual;

    -- 문자열 -> 날짜데이터 변환 -> 'J'를 이용해 날짜데이터를 숫자형식의 문자열로 변환 => concat|| 수행
SELECT TO_CHAR(TO_DATE('2024.01.19', 'YYYY/MM/DD'), 'J')-TO_CHAR(TO_DATE('2023.07.11', 'YYYY/MM/DD'), 'J') || '일' FROM DUAL;


-- 3. to_number(): 문자형 데이터를 숫자형 데이터로 변환해주는 함수
--    형식 : to_number('문자데이터', '구분기호')
    -- 오류 발생: 문자열 사이의 산술 연산을 수행X
SELECT '20,000' - '10,000' FROM dual;
    -- 문자열을 숫자로 변환한 후, 산술연산 수행
SELECT to_number('20,000', '99,999') - to_number('10,000', '99,999') FROM dual;



