-- 2023. 11. 21 (화)

-- 원격 aws 계정 생성
-- userid : master, passwd : 1234

-- 계정 생성을 위해 원격 IP 관리자 계정으로 접속
conn system/system
-- 새로운 계정 생성
CREATE USER master IDENTIFIED BY 1234;

-- 생성한 계정에 권한 부여
GRANT CONNECT, RESOURCE TO master;
    -- 이후 proj계정으로 접속 가능
    
-- Oracle SQL에도 master계정 등록해둠