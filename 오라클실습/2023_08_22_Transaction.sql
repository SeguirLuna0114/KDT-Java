-- 2023. 08. 22(화)

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






