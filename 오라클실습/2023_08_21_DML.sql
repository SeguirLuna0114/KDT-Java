-- 2018. 08. 21(월)

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
--

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

