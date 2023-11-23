-- 2023. 11. 22 (수)

-- 원격 aws 계정 생성
-- userid : music, passwd : music123

-- 계정 생성을 위해 원격 IP 관리자 계정으로 접속
conn system/system
-- 새로운 계정 생성
CREATE USER music IDENTIFIED BY music123;

-- 생성한 계정에 권한 부여
GRANT CONNECT, RESOURCE TO music;
    -- 이후 proj계정으로 접속 가능
    
-- Oracle SQL에도 master계정 등록해둠