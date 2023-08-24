-- 2023. 08. 24(목)

-- 제약조건의 활성화 / 비활성화

-- Q. 부모테이블(DEPT)의 데이터를 삭제
-- 1) 자식테이블(EMP)에서 부모키(deptno)를 참조하는 외래키가 있기 때문에
--    부모 테이블의 데이터를 삭제할 수 없음
DELETE FROM dept WHERE deptno = 40;         -- integrity constraint_child record found
-- 2) 부모 테이블의 데이터 삭제를 위해서는 참조하는 자식 테이블의 외래키를 비활성화 시켜서
--    부모 테이블의 데이터 삭제 가능    

-- 1. 부모 테이블 생성
DROP TABLE dept01 PURGE;
CREATE TABLE dept01 (   deptno NUMBER(2) PRIMARY KEY,
                        dname VARCHAR2(14),
                        loc VARCHAR2(13)    );
-- 테이블 확인
SELECT * FROM dept01;                       
-- 데이터 삽입
INSERT INTO dept01 VALUES (10, 'ACCOUNTING', 'NEW YORK');

-- 2. 자식 테이블 생성
DROP TABLE emp01 PURGE;
CREATE TABLE emp01( empno NUMBER(4) PRIMARY KEY,
                    ename VARCHAR2(10) NOT NULL,
                    job VARCHAR2(10) UNIQUE,
                    deptno NUMBER(2) REFERENCES dept01(deptno)  );
                    -- dept01테이블 내 deptno컬럼을 foreign key 설정
-- 테이블 확인
SELECT * FROM emp01; 
desc emp01;
-- 데이터 입력
    -- deptno컬럼에 데이터 입력시, foreign key 설정이 되어있기에
    -- dept01테이블에 입력된 deptno값만 입력 가능
INSERT INTO emp01 VALUES(1111, '홍길동', '개발자', 10);

-- 3. 부모 테이블(DEPT01)의 데이터 삭제
DELETE FROM dept01;     -- 자식테이블(emp01)에서 참조하고 있기에 삭제X
SELECT * FROM dept01;
SELECT * FROM emp01;

-- 4. 자식 테이블의 외래키 제약조건 비활성화
-- 부모 테이블(DEPT01)의 데이터 삭제를 위해 자식테이블(EMP01)의 외래키 제약조건을
-- 비활성화 시키면, 부모 테이블의 데이터를 삭제할 수 있음

-- 형식: ALTER TABLE 테이블명 DISABLE CONSTRAINT CONSTRAINT_NAME;
    -- CONSTRAINT_NAME(제약조건 이름)은 확인해봐야 함
    --  [테이블] 선택 -> [제약조건] -> [constraint_type]란에 foreign key라고 적힌 컬럼의 CONSTRAINT_NAME 확인   
ALTER TABLE emp01 DISABLE CONSTRAINT SYS_C007047;

-- cf. 자식테이블(EMP01)의 외래키 제약조건 활성화
-- 형식: ALTER TABLE 테이블명 ENABLE CONSTRAINT CONSTRAINT_NAME;
    -- 부모테이블의 데이터가 지워진 경우에는 , 자식테이블의 데이터도 지우고 활성화해야 함
DELETE FROM emp01;
ALTER TABLE emp01 ENABLE CONSTRAINT SYS_C007047;


-- 5. 부모테이블의 데이터가 삭제됨(자식테이블에서 참조하는 외래키가 없기 때문)
DELETE FROM dept01;
SELECT * FROM dept01;


-- CASCADE 옵션
-- 1. cascade옵션을 붙여서 부모테이블(dept01)의 제약조건을 비활성화 시키면
--    참조하고 있는 자식테이블(emp01)의 외래키 제약조건도 같이 비활성화됨
ALTER TABLE dept01 DISABLE CONSTRAINT SYS_C007043 CASCADE;

-- 2. cascade옵션을 붙여서 부모테이블(dept01)의 Primary Key제거하면
--    참조하는 자식테이블(emp01)와 Foreign Key 제약조건도 같이 제거해줌
ALTER TABLE dept01 DROP CONSTRAINT SYS_C007043 CASCADE;
ALTER TABLE dept01 DROP PRIMARY KEY CASCADE;


-- 1. 부모 테이블 생성
DROP TABLE dept01 PURGE;
CREATE TABLE dept01 (   deptno NUMBER(2) PRIMARY KEY,
                        dname VARCHAR2(14),
                        loc VARCHAR2(13)    );
-- 테이블 확인
SELECT * FROM dept01;                       
-- 데이터 삽입
INSERT INTO dept01 VALUES (10, 'ACCOUNTING', 'NEW YORK');

-- 2. 자식 테이블 생성
DROP TABLE emp01 PURGE;
-- ON DELETE CASCADE: 부모테이블 데이터가 삭제되면, 
--                     참조하는 자식테이블의 데이터도 같이 삭제해주는 옵션
CREATE TABLE emp01( empno NUMBER(4) PRIMARY KEY,
                    ename VARCHAR2(10) NOT NULL,
                    job VARCHAR2(10) UNIQUE,
                    deptno NUMBER(2) REFERENCES dept01(deptno) ON DELETE CASCADE );
                    -- dept01테이블 내 deptno컬럼을 foreign key 설정

-- 테이블 확인
SELECT * FROM emp01; 
desc emp01;
-- 데이터 입력
    -- deptno컬럼에 데이터 입력시, foreign key 설정이 되어있기에
    -- dept01테이블에 입력된 deptno값만 입력 가능
INSERT INTO emp01 VALUES(1111, '홍길동', '개발자', 10);

-- 3. 부모 테이블(DEPT01)의 데이터를 삭제
DELETE FROM dept01 WHERE deptno=10;
SELECT * FROM dept01;

-- cascade옵션에 의해 자식테이블 데이터도 삭제됨
SELECT * FROM emp01; 





