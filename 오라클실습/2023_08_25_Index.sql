-- 2023. 08. 25(금)

-- 인덱스(Index)
--  : 빠르게 검색하기 위해 사용되는 객체

-- 인덱스 목록 확인
SELECT * FROM user_indexes;
-- 기본키(Primary Key)로 설정된 컬럼은 자동으로 고유 인덱스로 설정됨


-- Q. 인덱스 사용 유무에 따른 검색 속도 비교
-- 1. 테이블 생성
DROP TABLE emp01 PURGE;
-- 복사본 테이블 생성(단, 제약조건은 복사되지 않음)
CREATE TABLE emp01 AS
SELECT * FROM emp;
-- 테이블 확인
SELECT * FROM emp01;

-- 2.emp01 테이블에 데이터 입력
    -- 테이블 내에서 데이터를 복제
    -- "emp01" 테이블에서 데이터를 모든 행과 열을 선택하여 
    -- 동일한 "emp01" 테이블에 데이터를 삽입
INSERT INTO emp01 SELECT * FROM emp01;

-- 3. 검색용 데이터 입력
INSERT INTO emp01(empno, ename) VALUES(1111, 'ahn');

-- 4. 시간측정 타이머 온으로 설정
    -- SQL 문의 실행에 걸린 시간을 확인하여 
    -- 성능 향상 노력을 평가하거나 쿼리의 실행 시간을 비교
SET TIMING ON;      -- SQL 문의 실행 시간을 측정하고 출력할 수 있도록 설정

-- 5. 검색용 데이터로 검색시간을 측정: 인덱스 설정하지 않은 경우
SELECT * FROM emp01 WHERE ename = 'ahn';    -- 0.061초

-- 6. 인덱스 생성 : emp01테이블의 ename컬럼에 인덱스 적용됨
CREATE INDEX idx_emp01_ename ON emp01(ename);

-- 7. 인덱스 목록 확인
SELECT * FROM user_indexes;

-- 8. 검색용 데이터로 검색시간을 측정: 인덱스가 설정된 경우
SELECT * FROM emp01 WHERE ename = 'ahn';    -- 0.054초


-- 인덱스 삭제
-- 형식 : drop index index_name;
DROP INDEX idx_emp01_ename;


-- 인덱스 종류
--      1. 고유 인덱스 : 중복된 데이터가 없는 컬럼에 적용할 수 있는 인덱스
--      2. 비 고유 인덱스 : 중복된 데이터가 있는 컬럼에 적용할 수 있는 인덱스

-- 1. 테이블 생성
DROP TABLE dept01 PURGE;
-- 테이블 구조만 복사
CREATE TABLE dept01 AS
SELECT * FROM dept where 1=0;

-- 2. 데이터 입력
INSERT INTO dept01 VALUES(10, '인사과', '서울');
INSERT INTO dept01 VALUES(20, '총무과', '대전'); 
INSERT INTO dept01 VALUES(30, '교육팀', '대전');     -- loc컬럼에 중복데이터 입력
-- 테이블 확인
SELECT * FROM dept01;       -- 중복된 데이터가 있는 loc컬럼은 고유인덱스로 사용X

-- 3. 고유 인덱스 : dept01컬럼에 고유 인덱스를 적용
CREATE UNIQUE INDEX idx_dept01_deptno 
ON dept01(deptno);

-- 4. 인덱스 목록 확인
SELECT * FROM user_indexes;

-- Q. 고유 인덱스 설정된 deptno컬럼에 중복 데이터 입력 불가능
    -- deptno컬럼은 고유 인덱스가 설정된 이후에 중복 데이터를 입력할 수 없음
INSERT INTO dept01 VALUES(30, '교육팀', '대전');     -- unique constraint

-- 5. 비고유 인덱스
-- Q. loc컬럼에 고유, 비교유 인덱스를 적용
-- loc컬럼에 고유 인덱스 적용
    -- : loc컬럼은 중복된 데이터가 있기에 고유 인덱스를 만들 수 X
CREATE UNIQUE INDEX idx_dept01_loc 
ON dept01(loc);         -- 오류 발생(cannot CREATE UNIQUE INDEX)

-- loc컬럼에 비고유 인덱스 적용 
CREATE INDEX idx_dept01_loc 
ON dept01(loc);         -- 비교유 인덱스 생성됨

-- 인덱스 목록 확인
SELECT * FROM user_indexes;     -- 고유 인덱스는 Unique, 비고유인덱스는 nonUnique로 설정됨


-- 6. 결합 인덱스 : 2개 이상의 컬럼으로 만들어진 인덱스
CREATE INDEX idx_dept01_com 
ON dept01(deptno, dname);


-- 7. 함수 기반 인덱스 : 수식이 아닌 함수를 적용하여 만든 인덱스
CREATE INDEX idx_emp01_annsal 
ON emp(sal*12 +NVL(comm, 0));

