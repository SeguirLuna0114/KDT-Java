-- 2023. 11. 21 (화)

-- 원격 aws 계정 생성
-- userid : mypage, passwd : mypage123
-- 프로젝트용 user의 schema를 복사한 계정(코드 작성하기 위함)

-- 계정 생성을 위해 원격 IP 관리자 계정으로 접속
conn system/system
-- 새로운 계정 생성
CREATE USER mypage IDENTIFIED BY mypage123;

-- 생성한 계정에 권한 부여
GRANT CONNECT, RESOURCE TO mypage;
    -- 이후 proj계정으로 접속 가능
    
-- Oracle SQL에도 mypage계정 등록해둠

-- [도구] -> [데이터베이스 복사]를 통해 music의 데이터를 모두 mypage로 복사

