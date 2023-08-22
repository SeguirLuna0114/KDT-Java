-- 2018. 08. 22(화)

-- DDL(Data Definition Language) : 데이터 정의어
    -- create : 테이블 생성
    -- alter : 테이블 구조 변경
    -- rename : 테이블 이름 변경
    -- drop: 테이블 삭제
    -- truncate : 데이터 삭제
    
-- 테이블 목록
SELECT * FROM tab;
SELECT * FROM user_tables;

-- 1. CREATE
--  : 데이터베이스 생성, 테이블 생성

-- 형식 : create table 테이블명 ( 컬럼명1   데이터타입1,
--                              컬럼명2   데이터타입2,
--                              컬럼명N   데이터타입N);

--* 테이블명,컬럼명 명명 규칙
--1. 반드시 문자로 시작 해야함.
--2. 1~30자 까지 가능함.
--3. A~Z까지의 대소문자와 0~9까지의 숫자, 
--   특수기호는 (_, $, #)만 포함할 수 있음.
--4. 오라클에서 사용되는 예약어나 다른 객체명과 중복불가
--5. 공백허용 안됨.

-- 오라클의 데이터 타입
-- 1) 숫자 데이터
--      number(n): 정수 n자리까지 저장
--      number(n1, n2): n1: 전체자리수, n2: 소수점 이하에 할당된 자리수

-- 2) 문자 데이터
--      char(): 고정 길이 문자형
--              최대 2000byte까지 저장 가능
--      varchar2(): 가변 길이 문자형
--                  최대 4000byte까지 저장 가능
--       long: 2GB까지 저장 가능
--              long형으로 설정된 컬럼은 검색 기능을 지원하지 않음

-- 3) 날짜 데이터
--      date : 연/월/일 정보저장
--      timestamp : 연/월/일 시:분:초 정보 저장

-- 테이블 생성
-- 1) 직접 테이블 생성 with CREATE TABLE 명령
CREATE TABLE emp01 ( empno NUMBER(4),
                     ename varchar2(20),
                     sal NUMBER(7, 2));

-- 생성한 테이블 목록 확인
SELECT * FROM emp01;
DESCRIBE emp01;


-- 2) 서브쿼리로 테이블 생성
--      복사본 테이블이 생성됨
--      제약조건은 복사가 되지 않음

-- 복사본 테이블 생성
CREATE TABLE emp02 AS SELECT * FROM emp;

-- 테이블 목록 확인
SELECT * FROM emp02;
desc emp02;

-- 원하는 컬럼으로 구성된 복사본 테이블 생성
CREATE TABLE emp03 AS SELECT empno, ename FROM emp;

-- 테이블 목록 확인
SELECT * FROM emp03;
desc emp03;

-- 원하는 행(row, 데이터)으로 구성된 복사본 테이블 생성
CREATE TABLE emp04 AS SELECT * FROM emp WHERE deptno=10;

-- 테이블 목록 확인
SELECT * FROM emp04;
desc emp04;

-- 테이블 구조만 복사
CREATE TABLE emp05 AS SELECT * FROM emp WHERE 1=0;
-- 테이블 목록 확인
SELECT * FROM emp05;
desc emp05;


-- 2. ALTER
--   : 테이블 구조 변경(컬럼 추가, 컬럼 수정, 컬럼 삭제)

--  1) 컬럼 추가: emp01 테이블에 job컬럼 추가
ALTER TABLE emp01 ADD(job VARCHAR2(10));
desc emp01;
SELECT * FROM emp01;

-- 2) 컬럼 수정
--      i) 수정할 컬럼에 데이터가 없는 경우
--         컬럼의 데이터 타입을 변경할 수 있음
--         컬럼의 크기를 변경할 수 있음
--      ii) 수정할 컬럼에 데이터가 있는 경우
--          컬럼의 데이터 타입을 변경할 수 없음
--          컬럼의 크기는 늘릴 수 있으나, 현재 저장된 크기보다 작은 크기값으로 변경X

-- emp01테이블의 job컬럼의 크기를 10에서 30으로 수정
ALTER TABLE emp01 modify(job varchar2(30));
desc emp01;

-- 3) 컬럼 삭제
ALTER TABLE emp01 DROP COLUMN job;
ALTER TABLE emp01 DROP(job);

desc emp01;
SELECT * FROM emp01;


-- 3. rename
--    : 테이블 이름 변경
-- 형식 : rename old_name to new_name;

-- Q. EMP01테이블을 TEST테이블명으로 이름 변경
RENAME emp01 TO test;
SELECT * FROM tab;


-- 4. TRUNCATE
--   : 테이블 모든 데이터를 삭제
-- 형식 : truncate table table_name;      --(where조건절이 없어서 모든 데이터 삭제)
TRUNCATE TABLE emp02;
SELECT * FROM emp02;


-- 5. DROP
--    : 테이블 삭제(테이블이 삭제되면, 테이블 내 모든 데이터도 삭제됨)
-- 형식 : drop table table_name;      (Oracle 10q부터는 임시 테이블로 교체됨)
--       drop table table_name purge;       (완전하게 삭제됨)

-- Q. test테이블 삭제
DROP TABLE test;
SELECT * FROM tab;          -- test테이블이 임시테이블(BIN$l2SQ0GloQhmW2TIuhyADFA==$0)로 교체됨

-- 임시 테이블 삭제
PURGE RECYCLEBIN;
SELECT * FROM tab;

