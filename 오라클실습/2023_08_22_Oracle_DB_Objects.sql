-- 2018. 08. 22(화)

--* 오라클의 객체
--  테이블, 뷰, 시퀀스, 인덱스, 동의어, 프로시저, 트리거
--
--
--* 데이터 딕셔너리와 데이터 딕셔너리 뷰
--  데이터 딕셔너리를 통해서 접근가능함
--
--  - 데이터 딕셔너리 뷰 : user_xxxx
--     (가상 테이블)          all_xxxx
--		      dba_xxxx
--
--  - 데이터 딕셔너리(시스템 테이블) : 

  select * from tab;
  select table_name from user_tables; --(테이블)

  select * from user_views; --(뷰)

  select * from seq;
  select * from user_sequences; --(시퀀스)

  select * from user_indexes; --(인덱스)

  select * from user_synonyms; --(동의어)

  select * from user_source; --(프로시저)

  select * from user_triggers; --(트리거)

-- 자기 계정 소유 또는 권한을 부여받은 객체에 대한 정보 검색
  select table_name from all_tables;

-- 데이터베이스 관리자(DBA)민 접근할 수 있는 객체에 대한 정보 검색
    --계정을 system(관리자 계정)으로 변경하면, 실행 가능
  select table_name from dba_tables; --(DBA 계정만 사용가능)
 
-- 오라클 시스템의 모든 계정 정보 검색
    --계정을 system(관리자 계정)으로 변경하면, 실행 가능
  select username from dba_users; --(DBA 계정만 사용가능)

