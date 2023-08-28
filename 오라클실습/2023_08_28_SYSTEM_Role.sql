-- 2023. 08. 28(월)

-- Role(롤) : 여러가지 권한을 묶어놓은 것

-- Oracle 데이터베이스에서 제공하는 주요 시스템 롤
-- EX) Connect롤(8가지 권한), resource롤(20여개의 권한), DBA롤(130여개의 권한)

-- 1. 새로운 계정 생성 : user04/tiger
CREATE USER user04
IDENTIFIED BY tiger;

-- 2. 생성된 계정 목록 확인
SELECT * FROM dba_users;

-- 3. user04 계정에게 role 부여 : connect, resource 2개의 롤 부여
GRANT CONNECT, RESOURCE TO user04;

-- 4. user04 계정으로 접속 후, 테이블 생성
SQL> conn user04/tiger
    -- SQL> sqlplus user04/tiger
SQL> CREATE TABLE member(ID VARCHAR2(20), PASSWD VARCHAR2(20) );
    -- Table created.    
SQL> desc member;
-- Name                                      Null?    Type
-- ----------------------------------------- -------- ----------------------------
-- ID                                                 VARCHAR2(20)
-- PASSWD                                             VARCHAR2(20)   
    
----------------------------------------------------------------------------------

-- 사용자 정의 롤 생성 : 롤에 "시스템 권한"을 부여
-- 1. 롤 생성
CREATE ROLE mrole;

-- 2. 생성된 롤에 시스템 권한을 추가
GRANT CREATE SESSION, CREATE TABLE, CREATE VIEW to mrole;

-- 3. mrole를 적용하기 위한 계정 생성: user05/tiger
CREATE USER user05
IDENTIFIED BY tiger;
-- 생성된 계정 목록 확인
SELECT * FROM dba_users;

-- 4. user05 계정에게 mrole을 부여
GRANT mrole TO user05;

-- 5. user05 계정으로 접속
SQL> conn user05/tiger
    -- SQL> sqlplus user05/tiger
  
---------------------------------------------------------------------------------------

-- 사용자 정의 롤 생성 : 롤에 "객체 권한"을 부여
-- 시스템 계정으로 접속
conn system/oracle
-- 1. 롤 생성
CREATE ROLE mrole02;

-- 2. 생성된 롤에 "객체 권한"을 부여
-- 객체 소유자 계정으로 접속해서 수행
conn scott/tiger
GRANT SELECT ON emp to mrole02;

-- 3. user05 계정에게  mrole02를 부여
conn system/oracle
GRANT mrole02 TO user05;

-- 4. user05 계정으로 접속 후 SELECT 검색 시도
SQL> conn user05/tiger
    -- Connected.
SQL> SELECT * FROM scott.emp;
    -- 검색 가능

---------------------------------------------------------------------------

-- 롤 회수 : 특정 계정에게 부여된 롤을 취소하는 것
-- 형식 : REVOKE 롤이름 from 사용자명;

-- Q. user05계정에게 부여된 mrole과 mrole02를 회수(취소)
-- 시스템 계정으로 접속
conn system/oracle
-- 롤 회수
REVOKE mrole from user05;
REVOKE mrole02 from user05;


-- 롤 삭제
-- 형식: DROP ROLE 롤이름;

-- Q. mrole과 mrole02를 삭제
conn system/oracle
-- 롤 삭제
DROP ROLE mrole;
DROP ROLE mrole02;
  
-------------------------------------------------------------------------------------

-- 디폴트 롤을 생성해서 여러 사용자에게 롤 부여하기
-- 디폴트 롤 : 시스템 권한 + 객체 권한

-- 1. 디폴트 롤 생성
-- 시스템 계정으로 접속
conn system/oracle
-- 롤 생성
CREATE ROLE def_role;

-- 2. 생성된 롤(def_role)에 시스템 권한을 추가
-- 시스템 계정으로 접속
conn system/oracle
-- 시스템 권한을 추가
GRANT CREATE SESSION, CREATE TABLE to def_role;

-- 3. 생성된 롤(def_role)에 객체 권한을 추가
-- 객체 소유자 계정으로 접속해서 수행
conn scott/tiger
-- 객체 권한을 추가
GRANT SELECT ON emp to def_role;
GRANT UPDATE ON emp to def_role;
GRANT DELETE ON emp to def_role;

-- 4. 롤을 적용하기 위한 일반 계정 생성
-- 시스템 계정으로 접속
conn system/oracle
-- 새로운 일반 계정 생성
CREATE USER usera1 IDENTIFIED BY tiger;
CREATE USER usera2 IDENTIFIED BY tiger;
CREATE USER usera3 IDENTIFIED BY tiger;

-- 5. def_role을 생성된 계정에게 부여
-- 시스템 계정으로 접속
conn system/oracle
-- 생성한 롤을 계정에게 할당
GRANT def_role TO usera1;
GRANT def_role TO usera2;
GRANT def_role TO usera3;

-- 6. usera1/usera2/usera3 계정으로 접속 후 검색
SQL> conn useral/tiger
SQL> conn usera2/tiger
SQL> conn usera3/tiger
    -- Connected.
-- SELECT문 실행
SQL> SELECT * FROM scott.emp;
    -- 검색 가능






    
    
