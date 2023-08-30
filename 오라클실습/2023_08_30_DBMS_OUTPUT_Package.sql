-- 2023. 08. 30 (수)

-- DBMS_OUTPUT 패키지
    -- 패키지들은 목적에따라 관련된 프로시저와 함수들을 관리
    -- DBMS_"로 시작하는 객체 이름을 가진 패키지들의 이름을 선택
SELECT object_name FROM dba_objects
WHERE object_type = 'PACKAGE'
AND object_name LIKE 'DBMS_%'
ORDER BY object_name;
    -- dba_objects 시스템 뷰 : 데이터베이스 내의 모든 객체에 대한 정보를 포함하고 있는 뷰
--                  - 데이터베이스 내의 다양한 객체(테이블, 뷰, 인덱스, 프로시저 등)에 대한 메타데이터를 확인