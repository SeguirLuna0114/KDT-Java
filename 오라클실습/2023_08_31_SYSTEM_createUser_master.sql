-- 2023. 08. 31 (목)

-- 데이터 모델링을 위한 계정 생성
-- userid : master, passwd : 1234

-- 계정 생성을 위해 관리자 계정으로 접속
conn system/oracle
-- 새로운 계정 생성
CREATE USER master IDENTIFIED BY 1234;

-- 생성한 계정에 권한 부여
GRANT CONNECT, RESOURCE TO master;
    -- 이후 master계정으로 접속 가능
    
-- Oracle SQL에도 master계정 등록해둠