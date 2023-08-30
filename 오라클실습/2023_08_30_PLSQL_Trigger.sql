-- 2023. 08. 30 (수)

-- 트리거(Trigger)
--  1. 트리거의 사전적 의미는 '방아쇠'
--  2. 트리거는 이벤트를 발생시켜서 연쇄적으로 다른 작업을 '자동'으로 처리/수행할 때 사용
--  3. 이벤트는 DML_SQL문을 이용해서 이벤트를 발생시키고,
--     이때 연쇄적으로 실행부(begin ~ end)안의 내용을 자동으로 실행

-- 임시 테이블 삭제
PURGE RECYCLEBIN;

-- Q1. 사원 테이블에 사원이 등록되면, "신입 사원이 입사했습니다."라는 메시지를 출력하는 트리거
-- 1. emp01테이블 생성
DROP TABLE emp01 PURGE;
CREATE TABLE emp01(
    empno NUMBER(4) PRIMARY KEY, -- 기본키 제약조건
    ename VARCHAR2(20),
    job VARCHAR2(20) );

-- emp01테이블 생성 확인
SELECT * FROM tab;
SELECT * FROM emp01;

-- 2. 트리거 생성
CREATE OR REPLACE TRIGGER trg_01
    AFTER INSERT ON emp01       -- 이벤트 발생
BEGIN
    dbms_output.put_line('신입사원이 입사 했습니다.');
END;

-- 3. 트리거 목록 확인
SELECT * FROM user_triggers;

-- 4. 이벤트 발생 : emp01테이블에 회원가입(데이터 입력)
    -- 데이터를 입력할 때 마다 '신입사원이 입사 했습니다.'메시지 출력됨
SET SERVEROUTPUT ON
INSERT INTO emp01 VALUES(1111, '홍길동', '개발자');
INSERT INTO emp01 VALUES(1112, '홍길동', '개발자');
INSERT INTO emp01 VALUES(1113, '홍길동', '개발자');
INSERT INTO emp01 VALUES(1115, '홍길동', '개발자');

-- emp01테이블 데이터 확인
SELECT * FROM emp01;


-- Q2. 사원 테이블 (EMP01)에 신입 사원이 등록되면, 급여 테이블(SAL01)에 
--     급여 정보를 자동으로 추가해주는 트리거를 생성
-- 1. emp01 테이블 데이터 삭제
DELETE FROM emp01;
COMMIT;

-- 2. 급여 테이블 생성 : SAL01
CREATE TABLE sal01(
    salno NUMBER(4) PRIMARY KEY,    -- 기본키(Primary Key) 설정
    sal NUMBER(7, 2),
    empno NUMBER(4) REFERENCES emp01(empno) );  -- 외래키(Foreign Key) 생성
    -- emp01테이블의 empno컬럼은 primary key로 설정되었기에, 부모키 O
-- 테이블 생성 확인
SELECT * FROM tab;

-- 3. 시퀀스 생성
CREATE SEQUENCE sal01_salno_seq;    -- 1부터 1씩 증가되는 시퀀스 생성
-- 시퀀스 생성 확인
SELECT * FROM seq;

-- 4. 트리거 생성
    -- :NEW.컬럼명 : insert, update문을 이용해서 이벤트가 발생한 경우
    -- :OLD.컬럼명 : delete문을 이용해서 이벤트가 발생한 경우
CREATE OR REPLACE TRIGGER trg_02
    AFTER INSERT ON emp01       -- emp01테이블에 insert된 후 trigger처리
    FOR EACH ROW    -- 트리거가 각 행에 대해 개별적으로 실행됨
BEGIN
    -- Trigger logic 작성
    INSERT INTO sal01 
    VALUES(sal01_salno_seq.nextval, 300, :new.empno);
END;

-- 5. 트리거 목록 확인
SELECT * FROM user_triggers;

-- 6. 이벤트 발생 : EMP01테이블에 사원 등록
INSERT INTO emp01 VALUES(1111, '홍길동', '개발자');
INSERT INTO emp01 VALUES(1112, '홍길동', '개발자');
INSERT INTO emp01 VALUES(1113, '홍길동', '개발자');

-- 7. 테이블 데이터 확인
SELECT * FROM emp01;
SELECT * FROM sal01;        -- 트리거에 의해서 자동으로 등록됨


-- Q3. 사원테이블(emp01)에서 사원정보가 삭제되면, 급여정보를 자동으로 삭제하는 트리거 생성
-- 참조하는 외래키가 있기 때문에, 부모 테이블의 데이터를 삭제할 수 없음
    -- 외래키 제약조건에 CASCADE(종속삭제)를 추가해줌
DELETE FROM emp01 WHERE empno = 1111;   -- 오류(child record found)

-- 1. 트리거 생성
CREATE OR REPLACE TRIGGER trg_03
    AFTER DELETE ON emp01       -- 이벤트발생(emp01테이블의 데이터 삭제한 후)
    FOR EACH ROW        -- 행 단위로 트리거 발생
BEGIN
    DELETE FROM sal01
    WHERE empno = :OLD.empno;
END;

-- 2. 트리거 목록 확인
SELECT * FROM user_triggers;

-- 3. 이벤트 발생
--  : 사원 테이블(EMP01)의 사원번호111번 사원을 삭제하면,
--    연쇄적으로 급여 테이블(SAL01)의 급여정보도 삭제됨
DELETE FROM emp01 WHERE empno = 1111;

-- 4. 결과 확인
SELECT * FROM emp01;
SELECT * FROM sal01;        -- 트리거에 의해서 자동으로 삭제됨

