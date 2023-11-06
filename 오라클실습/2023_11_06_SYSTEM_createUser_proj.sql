-- 2023. 11. 06 (월)

-- 프로젝트를 위한 계정 생성
-- userid : proj, passwd : 1234

-- 계정 생성을 위해 관리자 계정으로 접속
conn system/oracle
-- 새로운 계정 생성
CREATE USER proj IDENTIFIED BY 1234;

-- 생성한 계정에 권한 부여
GRANT CONNECT, RESOURCE TO proj;
    -- 이후 proj계정으로 접속 가능
    
-- Oracle SQL에도 proj계정 등록해둠