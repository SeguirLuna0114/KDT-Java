-- 2023. 08. 25(금)

-- 데이터베이스 보안을 위한 권한
-- 1. 시스템 권한
-- 2. 객체 권한

-- 1. 시스템 권한 : 데이터베이스 관리자(DBA)가 갖고 있는 권한
--  ex) create user, drop user...

-- 시스템 관리자가 일반 사용자에게 부여해야 하는 권한
--  CREATE SESSION: 데이터베이스 접속 권한
--  CREATE TABLE : 테이블을 생성할 수 있는 권한
--  CREATE VIEW : 뷰를 생성할 수 있는 권한
--  CREATE SEQUENCE : 시퀀스를 생성할 수 있는 권한
--  CREATE PROCEDURE : 프로시저를 생성할 수 있는 권한

-- 새로운 계정 생성    : user01 / tiger
CREATE USER user01 IDENTIFIED BY tiger;

-- 생성된 계정 목록 확인
SELECT * FROM dba_users;

-- user01 계정에게 데이터베이스 접속 권한을 부여 : create session
GRANT CREATE SESSION TO user01;

-- 테이블 생성 권한 부여 : CREATE TABLE
GRANT CREATE SESSION, CREATE TABLE TO user01;


-- with admin option
--  : grant명령으로 권한을 부여받을 때, with admin option을 붙여서
--    권한이 부여되면, 권한을 부여받은 계정은 자기가 부여받은 권한을
--    제 3의 계정에게 재 부여할 수 있음

-- 1. 새로운 계정 생성    : user02 / tiger
CREATE USER user02 IDENTIFIED BY tiger;

-- 2. user02 계정에게 데이터베이스 접속 권한을 부여 : create session
GRANT CREATE SESSION TO user02 WITH ADMIN OPTION;

-- 3. 제3의 계정 생성     : user03/tiger
CREATE USER user03 IDENTIFIED BY tiger;

-- 4. user01계정으로 접속 후 user03 계정에게 create session 권한 부여
SQL> conn user01/tiger
SQL> grant create session to user03;    -- 오류 발생
    -- ORA-01031: insufficient privileges
    
-- 5. user02계정으로 접속 후 user03 계정에게 create session 권한 부여
SQL> conn user02/tiger
SQL> grant create session to user03;     -- create session 권한 부여O  

-- 6. user03계정은 user02계정으로부터 create session권한을 부여받았기에
--    데이터베이스 접속이 가능함
SQL> conn user03/tiger
SQL> show user 
SQL> USER is "USER03"

