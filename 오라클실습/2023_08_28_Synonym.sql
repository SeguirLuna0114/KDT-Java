-- 2023. 08. 28(월)

-- 동의어(Synonym)
-- : 같은 의미를 가진 단어

-- 1. 비공개 동의어
--  : 객체에 대한 접근권한을 부여받은 사용자가 정의한 동의어로써 
--     동의어를 만든 사용자만 사용할 수 있음
    
-- 2. 공개 동의어(공용 동의어)
--  : DBA 권한을 가진 사용자만 생성할 수 있음
--    누구나 사용 가능
    --  1. DBA 계정으로 접속해서 공개 동의어 생성 가능
    --  2. 공개 동의어를 만들때는 public을 붙여서 생성
    -- 공개 동의어의 예
    -- sys.tab     --> tab      select * from tab;   
    -- sys.seq     --> seq      select * from seq;
    -- sys.dual    --> dual     select 10+20 from dual;
    
-------------------------------------------------------------

-- 비공개 동의어
-- 1. system 계정으로 접속 후 테이블 생성
conn system/oracle
CREATE TABLE systbl( ename VARCHAR2(20) );

-- 2. 생성된 테이블에 데이터 추가
conn system/oracle
INSERT INTO systbl VALUES('홍길동');
INSERT INTO systbl VALUES('안화수');
-- 테이블 데이터 확인
SELECT * FROM systbl;

-- 3. scott계정에게 systbl테이블에 대한 select 객체 권한 부여
-- 해당 객체 소유자 계정으로 접속
    -- 현재 systbl객체의 권한은 system계정에게 있음
conn system/oracle
GRANT SELECT ON systbl TO scott;

-- 4. 해당 객체권한을 부여받은 계정으로 접속하여 select 검색 시도
    -- 객체권한을 부여받은 계정을 scott계정
conn scott/tiger
SELECT * FROM systbl;           -- 오류 발생
SELECT * FROM system.systbl;    -- 정상적인 검색 가능

-- 5. scott계정에게 동의어를 생성할 수 있는 권한 부여
-- 관리자 계정으로 접속
conn system/oracle
GRANT CREATE SYNONYM TO scott;

-- 6. scott계정으로 접속한 후, 비공개 동의어 생성
    --(비공개 동의어 생성: system.systbl -> systbl)
conn scott/tiger
CREATE SYNONYM systbl FOR system.systbl;

-- 7. 동의어 목록 조회
conn scott/tiger
SELECT * FROM user_synonyms;

-- 8. 동의어를 이용해서 select 검색
conn scott/tiger
SELECT * FROM system.systbl;
SELECT * FROM systbl;           -- 비공개 동의어를 사용하여 객체 접근

-- 9. 비공개 동의어 삭제
-- 형식 : DROP SYNONYM synonym_name;
conn scott/tiger
DROP SYNONYM systbl;

-------------------------------------------------------------

-- 공개 동의어
--  1. DBA 계정으로 접속해서 공개 동의어 생성 가능
--  2. 공개 동의어를 만들때는 public을 붙여서 생성

-- 공개 동의어 생성
conn system/oracle
CREATE PUBLIC SYNONYM pubdept FOR scott.dept;

-- 공개 동의어 목록
SELECT * FROM dba_synonyms;

-- 공개 동의어 삭제
conn system/oracle
DROP PUBLIC SYNONYM pubdept;


