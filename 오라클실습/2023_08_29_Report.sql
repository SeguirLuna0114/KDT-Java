-- 2023. 08. 29 (화)

-- Q1. 전산실에 새로 입사한 사원에게 새로운 계정을 생성해 주려고 합니다. 
--아래의 요구 사항을 만족하는 SQL문을 각각 작성
--   [요구1] USER명 : woman, 패스워드 : tiger 
--   [요구2] CREATE SESSION 이라는 시스템 권한을 부여해 줍니다. 
--	(단, 또 다른 유저에게도 권한을 줄 수 있도록 
--	      WITH ADMIN OPTION을 부여합니다). 
--   [요구3] woman유저에게 connect, resource, dba 권한을 부여합니다.
-- 관리자 계정으로 접속
conn system/oracle
-- 1) USER명 : woman, 패스워드 : tiger 계정 생성
CREATE USER woman IDENTIFIED BY tiger;
-- 2) CREATE SESSION, WITH ADMIN OPTION 시스템 권한 부여
GRANT CREATE SESSION TO woman WITH ADMIN OPTION;
-- 3)woman유저에게 connect, resource, dba 권한을 부여
GRANT CONNECT, RESOURCE, DBA TO woman;


-- Q2. user01 계정을 생성 하세요? (비밀번호: tiger)
-- 관리자 계정으로 접속
conn system/oracle
-- user01 계정 생성
CREATE USER user01 IDENTIFIED BY tiger;


-- Q3. user01 계정에게 오라클 데이터 베이스에 접속해서, 테이블을 생성할 수 있는 권한을 부여하시오.
-- 관리자 계정으로 접속
conn system/oracle
-- 데이터베이스 접속 권한 & 테이블을 생성할 수 있는 권한을 부여
GRANT CREATE SESSION, CREATE TABLE TO user01;



-- Q. 사원 테이블에서 사원명을 검색하여 사원의 직급을 구해오는 저장 프로시저를 만들어서 실행
-- 1. 저장 프로시저 생성
CREATE OR REPLACE PROCEDURE sel_ename(
    vename IN emp.ename%TYPE,   -- 사원명
    vjob OUT emp.job%TYPE
)
IS
BEGIN
    SELECT job INTO vjob
    FROM emp WHERE ename = vename;
END;
    
-- 2. 프로시저 목록 확인
SELECT * FROM user_source;

-- 3. 바인드 변수 선언
    -- 바인드 변수 : 프로시저를 실행할 때, 결과를 돌려받는 변수
VARIABLE var_job VARCHAR2(12);

-- 4. 프로시저 실행
EXECUTE sel_ename('SCOTT', :var_job);

-- 5. 바인드 변수로 돌려받은 값 출력
PRINT var_job;

