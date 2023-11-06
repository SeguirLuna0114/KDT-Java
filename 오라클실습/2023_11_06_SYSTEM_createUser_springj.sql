-- 2023. 11. 06 (월)

-- spring프로젝트 실습을 위한 계정 생성
-- userid : spring, passwd : spring123

-- 계정 생성을 위해 관리자 계정으로 접속
conn system/oracle

-- 새로운 계정 생성
CREATE USER spring IDENTIFIED BY spring123;

-- 생성한 계정에 권한 부여
GRANT CONNECT, RESOURCE TO spring;
    -- 이후 spring계정으로 접속 가능
    
-- Oracle SQL에도 spring계정 등록해둠