-- 2023.08.17(목)

--  10과 20을 더한 결과를 테이블에서 선택
    -- 테이블에 숫자 데이터가 없는 상태에서 위의 쿼리를 실행하면
    -- 테이블의 각 행에 대해 10과 20을 더한 값(30)이 그대로 출력됨
SELECT 10+20 FROM dept;         -- 4개 출력
SELECT 10+20 FROM emp;          -- 14개 출력

-- dual 테이블
-- 1. dual테이블은 sys계정 소유의 테이블이고, 공개 동의어로 설정되어 있음
-- 2. dual테이블은 공개가 되어 있기 때문에 누구나 사용할 수 있음
-- 3. dual테이블은 데이터가 1개 밖에 없기 때문에, 연산결과를 1번만 출력
DESCRIBE dual;          -- dummy라는 컬럼 1개뿐
desc dual;
--DUMMY    VARCHAR2(1) 

    -- DUAL" 테이블은 모든 사용자에게 공통으로 제공되는 테이블이므로, 
    -- "sys.dual"과 "dual"은 동일한 의미
SELECT 10+20 FROM dual;     -- 1개 출력
SELECT 10+20 FROM sys.dual;     -- "sys" 스키마에 속한 "DUAL" 테이블에서 10과 20을 더한 결과

SELECT * FROM dual;             -- X 데이터 1개 있음.

SELECT * FROM sys.tab;
SELECT * FROM tab;          -- tab: 공개 동의어

-- 1. 숫자 처리 함수-----------------------------------------------------
-- abs(): 절대값을 구해주는 함수
--        함수명은 대,소문자를 구분하지 않음
SELECT -10, abs(-10), ABS(-10) FROM dual;

-- floor(): 소수점 이하를 버리는 역할
SELECT 34.5678, floor(34.5678) FROM dual;

-- round(): 특정 자리에서 반올림을 해주는 함수
-- round(대상값, 자리수)
SELECT 34.5678, round(34.5678) FROM dual;       -- 35: 소수 첫째자리에서 반올림
SELECT 34.5678, round(34.5678, 2) FROM dual;    -- 34.57: 소수 셋째자리에서 반올림
SELECT 34.5678, round(34.5678, -1) FROM dual;   -- 30: 일의자리에서 반올림
SELECT 34.5678, round(35.5678, -1) FROM dual;   -- 40: 일의자리에서 반올림

-- trunc(): 특정 자리에서 잘라내는(버리는) 역할
-- trunc(대상값, 자리수)
SELECT trunc(34.5678), trunc(34.5678, 2), trunc(34.5678, -1) FROM dual;
        --  34              34.56               30

-- mod(): 나머지를 구해주는 함수
SELECT mod(27, 2), mod(27, 5), mod(27, 7) FROM dual;
        --  1           2           6

-- Q. 사원 테이블에서 사원번호가 홀수인 사원들을 출력하는 SQL문
SELECT ename, empno FROM emp where mod(empno, 2)=1;


-- 2. 문자 처리 함수 -----------------------------------------------------
-- upper(): 대문자로 변환해주는 함수
SELECT 'Welcome to Oracle', upper('Welcome to Oracle') FROM dual;

-- lower(): 소문자로 변환해주는 함수
SELECT 'Welcome to Oracle', lower('Welcome to Oracle') FROM dual;

-- initcap(): 각 단어의 첫글자만 대문자로 변환해주는 함수
SELECT 'Welcome to Oracle', initcap('welcome to oracle') FROM dual;

-- Q. 사원 테이블에서 job이 manager인 사원을 검색하는 SQL문 작성
SELECT * FROM emp WHERE job = upper('manager');
SELECT * FROM emp WHERE lower(job) = 'manager';

-- length(): 문자열의 길이를 구해주는 함수(글자수)
SELECT length('oracle'), length('오라클') FROM dual;
--              6                   3

-- lengthb(): 문자열의 길이를 바이트로 구해주는 함수
-- 영문 1글자 : 1byte, 한글 1글자: 3byte
SELECT lengthb('oracle'), lengthb('오라클') FROM dual;
--              6                   9(한글 3글자)

-- substr(): 문자열의 일부를 추출할 때 사용되는 함수
-- 형식: substr(대상 문자열, 시작위치, 추출할 문자개수)
--      추출할 시작번호는 왼쪽부터 1번부터 시작
SELECT substr('Welcome to Oracle', 4, 3) FROM dual;     -- com 출력
SELECT substr('Welcome to Oracle', -4, 3) FROM dual;    -- acl 출력
SELECT substr('Welcome to Oracle', -6, 3) FROM dual;    -- Ora 출력

-- Q1. 사원 테이블에서 입사일(hiredate)을 년, 월, 일을 추출하는 SQL문
SELECT substr(hiredate, 1, 2) as "년",
       substr(hiredate, 4, 2) as "월",
       substr(hiredate, 7, 2) as "일" FROM emp;

-- Q2. 사원 테이블에서 87년도에 입사한 사원을 검색하는 SQL문
SELECT * FROM emp WHERE substr(hiredate, 1, 2) = '87';

-- Q3. 사원 테이블에서 사원명이 E로 끝나는 사원을 검색하는 SQL문
    -- Like 비교연산자 사용
SELECT * FROM emp WHERE ename LIKE '%E';
    -- substr()함수 사용
SELECT * FROM emp WHERE substr(ename, -1, 1) = 'E';


-- instr() : 특정 문자의 위치를 구해주는 함수
-- instr(대상, 찾을 문자): 가장 먼저 나오는 문자의 위치를 찾아줌
-- instr(대상, 찾을 문자, 시작위치, 몇번째 발견)

-- Q1. 가장 먼저 나오는 'O'의 위치를 찾아줌
SELECT instr('Welcome to oracle', 'o') from dual;       -- 5

-- Q2. 6번 이후에 2번째 발견된 'o'의 위치를 찾아줌
SELECT instr('Welcome to oracle', 'o', 6, 2) from dual;     -- 12

-- Q3. 사원 테이블에서 사원명의 3번째 자리가 R로 되어있는 사원을 검색하는 SQL문
    -- 3가지 방법) LIKE연산자, SUBSTR()함수, INSTR()함수
-- 1) LIKE연산자 사용
SELECT * FROM emp WHERE ename LIKE '__R%';
-- 2) SUBSTR()함수 사용
SELECT * FROM emp WHERE substr(ename, 3, 1) = 'R';
-- 3) INSTR()함수 사용
SELECT * FROM emp WHERE instr(ename, 'R') = 3;
SELECT * FROM emp WHERE instr(ename, 'R', 3, 1) = 3;


-- lpad() / rpad(): 특정 기호를 채워주는 역할
SELECT lpad('Oracle', 20, '#') FROM dual;       -- ##############Oracle
SELECT rpad('Oracle', 20, '#') FROM dual;       -- Oracle##############


-- ltrim(): 왼쪽 공백을 삭제해주는 함수
-- rtrim(): 오른쪽 공백을 삭제해주는 함수
SELECT '  Oracle  ', ltrim('  Oracle  ') FROM dual;
SELECT '  Oracle  ', rtrim('  Oracle  ') FROM dual;
SELECT ltrim('12345', '1') FROM dual;
SELECT ltrim('12345#####', '#') FROM dual;

-- trim() : 문자열 좌, 우측의 공백을 삭제해주는 함수
--          특정 문자를 잘라내는 함수
SELECT '  Oracle  ', trim('   Oracle   ') from dual;
SELECT trim('a' from 'aaaaaOracleaaaaa') from dual; 		-- Oracle
SELECT trim(leading 'a' from 'aaaaaOracleaaaaa') from dual; -- Oracleaaaaa
SELECT trim(trailing 'a' from 'aaaaaOracleaaaaa') from dual;   -- aaaaaOracle

