-- 2023. 08. 23(수)

-- 제약 조건 설정 방식
--1. 컬럼레벨 방식으로 제약조건 설정
--2. 테이블레벨 방식으로 제약조건 설정
    -- 제약 조건을 설정할때 테이블 레벨 방식만 가능한 경우
    --1. 기본키를 복합키로 사용하는 경우(기본키 제약조건을 2개 이상 생성하는 것)
    --2. alter table 명령으로 제약조건을 추가할 경우

--1. 컬럼레벨 방식으로 제약조건 설정
DROP TABLE emp01 PURGE;

CREATE TABLE emp01( empno NUMBER(4) PRIMARY KEY,
                    ename VARCHAR2(15) NOT NULL,
                    job VARCHAR2(10) UNIQUE,
                    deptno NUMBER(4) REFERENCES dept(deptno) );

--2. 테이블레벨 방식으로 제약조건 설정
DROP TABLE emp02 PURGE;

CREATE TABLE emp02( empno NUMBER(4),
                    ename VARCHAR2(15) NOT NULL,--not null제약조건은 컬럼레벨 방식만 가능함
                    job VARCHAR2(10),
                    deptno NUMBER(4),
                    PRIMARY KEY(empno),
                    UNIQUE(job),
                    FOREIGN KEY(deptno) REFERENCES dept(deptno) );
    
    
-- 제약 조건을 설정할때 테이블 레벨 방식만 가능한 경우
--1. 기본키를 복합키로 사용하는 경우(기본키 제약조건을 2개 이상 생성하는 것)
--2. alter table 명령으로 제약조건을 추가할 경우

--1. 2개 이상의 컬럼을 기본키로 설정
DROP TABLE member01 PURGE;

--1) 컬럼레벨 방식으로 2개의 컬럼을 primary key로 설정
CREATE TABLE member01(  id VARCHAR2(20) PRIMARY KEY,
                        passwd VARCHAR2(20) PRIMARY KEY );  -- 오류발생
                        -- ORA-02260: table can have only one primary key

--2) 테이블레벨 방식으로 2개의 컬럼을 primary key로 설정
CREATE TABLE member01(  id VARCHAR2(20),
                        passwd VARCHAR2(20),
                        PRIMARY KEY(id, passwd) );
    
--2. alter table 명령으로 제약조건을 추가하는 경우
DROP TABLE emp01 PURGE;

-- 제약조건이 없는 테이블 생성
CREATE TABLE emp01( empno NUMBER(4),        -- primary key
                    ename VARCHAR2(15),     -- not null
                    job VARCHAR2(10),       -- unique
                    deptno NUMBER(2));      -- foreign key
    
-- primary key 제약조건 추가 : empno
ALTER TABLE emp01 ADD PRIMARY KEY(empno);

-- not null 제약조건 추가 : ename
ALTER TABLE emp01 MODIFY ename NOT NULL;

-- unique 제약조건 추가 : job
ALTER TABLE emp01 ADD UNIQUE(job);

-- foreign key 제약조건 추가 : deptno
ALTER TABLE emp01 ADD FOREIGN KEY(deptno) REFERENCES dept(deptno);


-- 제약조건 제거
-- 형식 : alter table 테이블명 drop constraint constraint_name;

-- primary key 제약조건 제거
ALTER TABLE emp01 DROP  CONSTRAINT SYS_C007054;     
ALTER TABLE emp01 DROP PRIMARY KEY;                 

-- not null 제약조건 제거
ALTER TABLE emp01 DROP  CONSTRAINT SYS_C007053;

-- unique 제약조건 제거
ALTER TABLE emp01 DROP  CONSTRAINT SYS_C007055;
ALTER TABLE emp01 DROP UNIQUE(job);

-- foreign key 제약조건 제거
ALTER TABLE emp01 DROP CONSTRAINT SYS_C007056;

