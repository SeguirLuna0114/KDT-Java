-- 2023. 08. 25(금)

-- commit [F11]
-- rollback [F12]

-- 시퀀스(sequence)
-- : 테이블에 숫자를 자동으로 증가 시켜주는 역할을 한다.

-- 시퀀스 생성
CREATE SEQUENCE dept_deptno_seq
START WITH 10           -- 시작할 번호값
INCREMENT BY 10;        -- 증가치

-- 시퀀스 목록 
SELECT * FROM seq;
SELECT * FROM user_sequences;

-- currval : 시퀀스 현재값을 반환
-- nextval : 시퀀스 다음값을 반환

SELECT dept_deptno_seq.nextval from dual;
SELECT dept_deptno_seq.currval from dual;

-- 예1. 시퀀스를 테이블의 기본키에 적용
DROP TABLE emp01 PURGE;
CREATE TABLE emp01 ( 
    empno NUMBER(4) PRIMARY KEY,
    ename VARCHAR2(10),
    hiredate DATE );
-- 테이블 목록 확인
SELECT * FROM tab;      -- 테이블 목록

-- 1부터 1씩 증가되는 시퀀스 생성
CREATE SEQUENCE emp01_empno_seq;
-- 시퀀스 목록 확인
SELECT * FROM seq;      -- 시퀀스 목록

-- 데이터 입력
INSERT INTO emp01 VALUES(emp01_empno_seq.nextval, '홍길동', sysdate);
-- 테이블 데이터 확인
SELECT * FROM emp01;


-- 예2. 
-- 테이블 생성
CREATE TABLE dept_example ( 
    deptno NUMBER(2) PRIMARY KEY,
    edame VARCHAR2(15),
    loc VARCHAR2(15) );
-- 테이블 목록 확인
SELECT * FROM tab;      -- 테이블 목록

-- 시퀀스 생성
CREATE SEQUENCE dept_example_seq
START WITH 10           -- 시작할 번호값
INCREMENT BY 10;        -- 증가치
-- 시퀀스 목록 확인
SELECT * FROM seq;      -- 시퀀스 목록

-- 데이터 입력
INSERT INTO dept_example VALUES(dept_example_seq.nextval, '인사과', '서울');
INSERT INTO dept_example VALUES(dept_example_seq.nextval, '경리과', '서울');
INSERT INTO dept_example VALUES(dept_example_seq.nextval, '총무과', '서울');
INSERT INTO dept_example VALUES(dept_example_seq.nextval, '기술팀', '서울');
-- 테이블 데이터 확인
SELECT * FROM dept_example;

-- 시퀀스 삭제
DROP SEQUENCE dept_example_seq; 
-- 시퀀스 목록 확인
SELECT * FROM seq;      -- 시퀀스 목록에서 삭제됨을 확인

-- 시퀀스의 최대값을 수정
-- 기존 시퀀스 삭제
DROP SEQUENCE dept_deptno_seq;
-- 시퀀스 생성
CREATE SEQUENCE dept_deptno_seq
START WITH 10       -- 시작값
INCREMENT BY 10     -- 증가치
MAXVALUE 30;        -- 최대값
-- 시퀀스 목록 확인
SELECT * FROM seq; 

-- 시퀀스 다음값 구해오기
SELECT dept_deptno_seq.nextval FROM dual;   -- 10
SELECT dept_deptno_seq.nextval FROM dual;   -- 20
SELECT dept_deptno_seq.nextval FROM dual;   -- 30
SELECT dept_deptno_seq.nextval FROM dual;   -- 오류발생

-- 시퀀스의 MAXVALUE를 수정
ALTER SEQUENCE dept_deptno_seq MAXVALUE 100000;

-- 시퀀스의 다음 값 구해오기
SELECT dept_deptno_seq.nextval FROM dual;   -- 40

