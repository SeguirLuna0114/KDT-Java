-- 2023.08.17 과제
SELECT * FROM emp;
-- empno , ename, job, mgr, hiredate, sal, comm, deptno

-- Q1. 사원테이블(emp)에서 입사일을 4자리 연도로 출력되도록 SQL문을 작성
    -- '19' 문자열과 "hiredate" 컬럼의 날짜 값을 연결하여 하나의 문자열로 생성
SELECT '19' || to_char(hiredate) FROM emp;
    -- "hiredate" 컬럼의 날짜 값을 'YYYY/MM/DD' 형식으로 변환
SELECT to_char(hiredate, 'YYYY/MM/DD') FROM emp;

-- Q2. 사원테이블(emp)에서 MGR컬럼의 값이 null인 데이터의 MGR의 값을 CEO로 출력하는 SWL문
SELECT * FROM emp WHERE mgr IS NULL;

    -- NVL함수와 to_char함수를 조합하여 mgr컬럼을 문자열로 변환 -> 값이 NULL인 경우 CEO로 대체
SELECT ename, NVL(to_char(mgr), 'CEO') AS "mgr" FROM emp;
    -- NVL 함수와 to_char 함수를 조합하여 "mgr" 컬럼을 숫자를 4자리 문자열로 변환 -> NULL일 경우에는 'CEO'로 대체
SELECT ename, NVL(to_char(mgr, '9999'), 'CEO') AS MANAGER FROM emp WHERE mgr IS NULL;

    -- mgr은 숫자가 저장된 NUMBER타입이나, 'CEO'는 문자열이기에, NVL변환이 불가
SELECT nvl(mgr, 'CEO') FROM emp;        -- 오류

