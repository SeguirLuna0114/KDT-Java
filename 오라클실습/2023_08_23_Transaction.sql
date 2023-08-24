-- 2023. 08. 23(수)

-- Transaction(트랜잭션)
-- 1. 논리적인 작업단위
-- 2. 트랜잭션은 DML(insert, update, delete) SQL문으로 시작됨
-- 3. 데이터의 일관성을 유지하면서, 데이터를 안정적으로 복구하기 위해 사용됨
-- 4. 트랜잭션은 All-or-Nothing 방식으로 처리됨(중간단계x)

-- TCL(Transaction Control Langauage)
-- commit : 트랜잭션을 종료
-- rollback : 트랜잭션을 취소
-- savepoint : 복구할 시점(저장점)을 지정하는 역할

-- 기존에 존재하던 dept01테이블 drop
DROP TABLE dept01 PURGE;

-- 복사본 테이블 dept01 생성
CREATE TABLE dept01 AS
SELECT * FROM dept; 

-- 생성한 dept01테이블 확인
SELECT * FROM dept01;

-- 1. rollback: 트랜잭션을 취소
    -- 새로운 트랜잭션이 시작되고, 메모리상에서만 delete가 실행됨
DELETE FROM dept01;

-- 트랜잭션을 취소하기 때문에, 메모리상에서 delete된 데이터가 복구됨
ROLLBACK;

-- dept01테이블 확인 시, 삭제되었던 데이터가 복구되어 있음
SELECT * FROM dept01;


-- 자동 롤백 : 자동으로 롤백이 수행되는 것
-- : 비 정상적인 종료 - 강제로 창을 닫는 경우, 컴퓨터가 다운되는 경우



-- 2. commit : 트랜잭션을 종료
--  : 메모리 상에서 처리된 DML SQL문을 데이터베이스에 영구적으로 반영하게 됨
-- 메모리상에서 20번 데이터 삭제
DELETE FROM dept01 WHERE deptno = 20;

-- commit을 실행하여 트랜잭션 종료
--  (메모리 상에서 삭제된 데이터를 DB에 반영해서 삭제)
COMMIT;

-- rollback으로 데이터 복구를 시도했으나,
-- 트랜잭션이 종료되었기 때문에 삭제된 20번 데이터는 복구할 수 없음
ROLLBACK;       -- 삭제한 20번 데이터가 복구되지X


-- 자동 커밋 : 자동으로 커밋이 수행되는 것
-- 1) 정상적인 종료 : quit, exit, con.close()
-- 2) DDL(create, alter, rename, drop, truncate), DCL(grant, revoke) 명령이 수행될 때

-- 예1. DDL명령이 실행(create)
    -- select 명령으로 dept01테이블 내 데이터 확인
SELECT * FROM dept01;       -- 10, 30, 40 데이터 저장된 상태
    -- 새로운 거래 시작) delete from으로 데이터 삭제
DELETE FROM dept01 WHERE deptno = 40;       -- 40번 데이터 삭제

-- * 자동 커밋 수행됨(DDL명령어 create)
CREATE TABLE dept03 AS          -- create table문으로 테이블 복사
SELECT * FROM dept;

-- rollback 실행
ROLLBACK;           -- 삭제되었던 40번 데이터를 복구하지 X

-- 예2. DDL명령어 실행(truncate)
    -- delete(DML) : rollbback으로 데이터 복구가 가능
    -- truncate(DDL) : 자동커밋이 수행되어 rollback으로 데이터 복구 불가
SELECT * from dept01;       -- 10, 30

-- 새로운 거래 시작) delete from으로 데이터 삭제
DELETE FROM dept01 WHERE deptno = 30;       -- 30번 부서 삭제
ROLLBACK;                                   -- 삭제된 30번 데이터가 복구됨
SELECT * from dept01;       -- 10, 30

-- * 자동 커밋 수행됨(DDL명령어 truncate)
TRUNCATE TABLE dept01;      -- truncate문으로 데이터 삭제되며 DB에 반영됨 => 복구X
ROLLBACK;                   -- 삭제된 dept01데이터 복구X
SELECT * FROM dept01;


-- 3. savepoint: 임시 저장점을 지정해 사용되는 명령

-- 이전에 생성된 dept01테이블 drop
DROP TABLE dept01 PURGE;

-- 1. dept01테이블 생성
CREATE TABLE dept01 AS
SELECT * FROM dept;

-- 2. 40번 부서 삭제
DELETE FROM dept01 WHERE deptno = 40;

-- 3. commit 수행 : 트랜잭션 종료
COMMIT;

-- 4. 30번 부서 삭제
DELETE FROM dept01 WHERE deptno =30;

-- 5. c1 저장점 생성
SAVEPOINT c1;

-- 6. 20번 부서 삭제
DELETE FROM dept01 WHERE deptno = 20;

-- 7. c2저장점 생성
SAVEPOINT c2;

-- 8. 10번 부서 삭제
DELETE FROM dept01 WHERE deptno = 10;

-- 9. c2 저장점까지 복구
ROLLBACK to c2;         -- 10번 부서 복구
SELECT * FROM dept01;

-- 10. c1 저장점까지 복구
ROLLBACK to c1;         -- 10, 20번 부서 복구
SELECT * FROM dept01;

-- 11. 이전 트랜잭션 종료 이후를 복구
ROLLBACK;               -- 10, 20, 30번 부서 복구
SELECT * FROM dept01;



