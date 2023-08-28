-- 2023. 08. 25(금)

-- 데이터베이스 보안을 위한 권한
-- 1. 시스템 권한
-- 2. 객체 권한

-- 2. 객체 권한(Object Permission)
--  오라클 객체 : 테이블, 뷰, 시퀀스, 인덱스, 동의어, 프로시저, 트리거

-- 1. 새로 생성된 user01계정에게 scott 계정 소유의 EMP 테이블 객체에 대한
--  select 객체 권한을 부여
conn scott/tiger
GRANT SELECT ON emp TO user01;

-- 2. user01 계정으로 접속 후 EMP 테이블 객체에 대해서 select를 실행
SQL> conn user01/tiger      -- Connected.
SQL> select * from emp;     -- 오류 발생
    -- table or view does not exist
SQL> select * from scott.emp;   -- 검색 가능

-- 3. 객체 권한 취소
REVOKE SELECT ON emp FROM user01;

-- 객체 권한이 취소된 경우에는 오류가 발생함
SQL> select * from scott.emp;   -- 오류 발생
    -- table or view does not exist
    
    
-- with grant option
-- : user02 계정에게 scott계정 소유의 emp테이블 객체에 대해서 select 객체 권한을
--   부여할 때, with grant option을 붙여서 권한이 부여되면,
--   user02 계정은 자기가 부여받은 권한을 제 3의 계정(user01)에게 재부여할 수 있다.
--  "자기가 부여받은 권한을 제 3의 계정에게 재부여 할 수 있다"
-- 1. user02계정에게 scott계정 소유의 EMP테이블 객체에 대한 select 객체권한을 부여
conn scott/tiger
grant select on emp to user02 with grant option;
    
-- 2. user02계정으로 접속 후, user01 계정에게 자기가 부여받은 객체 권한을 재부여
conn user02/tiger
select * from scott.emp;        -- 검색 가능함

grant select on scott.emp to user01;

-- 3. user01 계정으로 접속 후 검색
conn user01/tiger
select * from scott.emp;         -- 검색 가능함



