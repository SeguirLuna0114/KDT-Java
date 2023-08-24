-- 2023. 08. 23(수)

-- 무결성 제약조건(Intergrity Constraint)
-- : 테이블에 부적절한 데이터가 입력되는 것을 막기 위해 테이블 생성시
--   각 컬럼에 대해 정의하는 여러 규칙을 의미
--      ex) not null, unique, primary key(기본키), foreign key(외래키), check, default

-- 1. NOT NULL 제약조건
--    : 특정 열이 널(Null) 값을 가질 수 없도록 지정하는 규칙
--      Null값은 아무런 값도 가지지 않음을 나타내기에, "반드시 값을 입력해야 함"

DROP TABLE emp02 PURGE;

-- emp02 테이블 생성
CREATE TABLE emp02( empno NUMBER(4) NOT NULL,
                    ename VARCHAR2(12) NOT NULL,
                    job VARCHAR2(12),
                    detpno NUMBER(2)    );

-- 테이블 확인
SELECT * FROM tab;
SELECT * FROM emp02;

-- 제약조건에 위배되지 않는 데이터 입력
INSERT INTO emp02 VALUES(1111, '홍길동', 'MANAGER', 30);

-- 제약조건(NOT NULL)에 위배되기 때문에 데이터 입력이 되지 않음
    -- 명시적으로 NULL값을 삽입하려 시도
INSERT INTO emp02 VALUES(NULL, NULL, 'SALESMAN', 30);   -- cannot insert NULL into
    -- empno와 ename 열을 생략하고 삽입하려 시도
INSERT INTO emp02(job, deptno) VALUES('SALESMAN', 30);  -- "DEPTNO": invalid identifier


-- 2. UNIQUE 제약조건
--    : 특정 열(또는 열들)에는 유일한 값만 입력할 수 있다.
--      중복된 값을 입력할 수 없음.
--      단, 기본키와 달리 널(Null)값을 허용함

DROP TABLE emp03 PURGE;
-- emp03 테이블 생성
CREATE TABLE emp03( empno NUMBER(4) UNIQUE,
                    ename VARCHAR2(12) NOT NULL,
                    job VARCHAR2(12),
                    detpno NUMBER(2)    );
-- 테이블 확인
SELECT * FROM tab;
SELECT * FROM emp03;                    

-- 제약조건에 위배되지 않는 데이터 입력
INSERT INTO emp03 VALUES(1111, '홍길동', '개발자', 10);

-- UNIQUE 제약조건에 위배되기 때문에 데이터 입력이 되지 않음
INSERT INTO emp03 VALUES(1111, '홍길동', '개발자', 20);   -- unique constraint

-- UNIQUE 제약조건은 NULL값 입력이 가능
INSERT INTO emp03 VALUES(NULL, '홍길동', '개발자', 20);
INSERT INTO emp03 VALUES(NULL, '안화수', '개발자', 30);


-- 3. PRIMARY KEY(기본키) 제약조건
--    Primary Key = Not Null + Unique
--    : 반드시 중복되지 않는 값을 저장해야 함
--    ex)   부서 테이블(DEPT) - deptno(pk)
--          사원 테이블(EMP)  - empno(pk)
--          게시판(Board)    - 번호(no)  : pk
--          회원관리(member)  - 아이디(id) : pk

-- 부서테이블(DEPT) - deptno(pk)
SELECT * FROM dept;
    -- UNIQUE 제약조건에 위배
INSERT INTO dept VALUES(10, '개발부', '서울');       -- unique constraint
    -- NOT NULL 제약조건에 위배
INSERT INTO dept VALUES(NULL, '개발부', '서울');     -- cannot insert NULL into

-- 사원테이블(EMP) - empno(pk)
SELECT * FROM emp;
    -- UNIQUE 제약조건에 위배
INSERT INTO emp(empno, ename) VALUES(7788, '홍길동');       -- unique constraint
    -- NOT NULL 제약조건에 위배
INSERT INTO emp(empno, ename) VALUES(NULL, '홍길동');    -- cannot insert NULL into


-- emp05테이블 생성
DROP TABLE emp05 PURGE;
CREATE TABLE emp05( empno NUMBER(4) PRIMARY KEY,    -- 반드시 중복되지 않는 값 입력
                    ename VARCHAR2(12) NOT NULL,    -- 반드시 값 입력
                    job VARCHAR2(12),
                    detpno NUMBER(2)    );

-- 테이블 확인
SELECT * FROM tab;
SELECT * FROM emp05;                    

-- 제약조건에 위배되지 않는 정상적인 데이터 입력
INSERT INTO emp05 VALUES(1111, '홍길동', '개발자', 20);

-- 중복 데이터는 PRIMARY KEY 제약조건에 위배되기 때문에 데이터 입력이 되지 않음
INSERT INTO emp05 VALUES(1111, '홍길동', '개발자', 20);   -- unique constraint

-- PRIMARY KEY 제약조건은 NULL값 입력이 불가능
INSERT INTO emp05 VALUES(NULL, '홍길동', '개발자', 20);   -- cannot insert NULL into


-- 4. 제약조건 이름(constraint name)을 설정해서 테이블 생성
DROP TABLE emp04 PURGE;
-- emp04테이블 생성
CREATE TABLE emp04( empno NUMBER(4) CONSTRAINT emp04_empno_uk UNIQUE,
                    ename VARCHAR2(10) CONSTRAINT emp04_ename_nn NOT NULL,
                    job VARCHAR2(10),
                    detpno NUMBER(2)    );

-- 테이블 확인
SELECT * FROM tab;
SELECT * FROM emp04; 
desc emp04;


--4. foreign key (외래키) 제약조건
--  DEPT(부모테이블) - deptno(pk) : 부모키 : 10, 20, 30, 40
--  EMP(자식테이블)  - deptno(fk) : 외래키 : 10, 20, 30

--1) 사원테이블(EMP)의 deptno 컬럼이 foreign key 제약조건이 설정되어 있다.
--2) foreign key 제약조건이 가지고 있는 의미는 부모테이블(DEPT)의 
--   부모키(deptno)의 값만 참조할 수 있다.
--3) 부모키가 되기 위한 조건은 primary key나 unique 제약조건으로 설정되어
--   있어야 한다.
 
--Q. 사원테이블(EMP)에 새로운 신입사원을 등록 해보자?
-- 외래키(deptno)는 부모키(DEPT-deptno)안에 있는값(10,20,30,40)만 참조할수 있다.
INSERT INTO emp(empno, deptno) VALUES(1111,50); --foreign key제약조건 위배(parent key not found)

-- emp06테이블 생성
DROP TABLE emp06 PURGE;
CREATE TABLE emp06( empno NUMBER(4) PRIMARY KEY,
                    ename VARCHAR2(10) NOT NULL,
                    job VARCHAR2(10),
                    detpno NUMBER(2) REFERENCES dept(deptno) );
                    
-- 테이블 확인
SELECT * FROM tab;
SELECT * FROM emp06; 
desc emp06;

-- 제약조건에 위배되지 않는 정상적인 데이터 입력
INSERT INTO emp06 VALUES(1111,'홍길동','개발자',10);
INSERT INTO emp06 VALUES(1112,'홍길동','개발자',20);
INSERT INTO emp06 VALUES(1113,'홍길동','개발자',30);
INSERT INTO emp06 VALUES(1114,'홍길동','개발자',40);    

-- FOREIGN KEY 제약조건에 위배되기 때문에 데이터 입력이 되지 않음
-- 50번 부서는 부모키에서 참조할 수 없는 값이기 때문에, 외래키 제약조건에 위배
-- 되어서 사용할 수 없다.
INSERT INTO emp06 VALUES(1115,'홍길동','개발자',50);  --foreign key제약조건 위배(parent key not found)


-- 5. CHECK 제약조건
-- : 데이터가 입력될때 특정 조건을 만족하는 데이터만 입력되도록 만들어 주는
--   제약조건 이다.

-- 급여(SAL) : 500 ~ 5000
-- 성별(gender) : M or F
-- emp07테이블 생성
DROP TABLE emp07 PURGE;
CREATE TABLE emp07( empno NUMBER(4) PRIMARY KEY,
                    ename VARCHAR2(10) NOT NULL,
                    sal NUMBER(7, 2) CHECK(sal BETWEEN 500 AND 5000),
                    gender VARCHAR2(1) CHECK(gender IN('M','F')) );

-- 테이블 확인
SELECT * FROM tab;
SELECT * FROM emp07; 
desc emp07;

-- 제약조건에 위배되지 않는 정상적인 데이터 입력
INSERT INTO emp07 VALUES(1111,'홍길동',3000,'M');
-- CHECK 제약조건에 위배되기 때문에 데이터 입력이 되지 않음
INSERT INTO emp07 VALUES(1112,'홍길동',8000,'M');      --check constraint
INSERT INTO emp07 VALUES(1113,'홍길동',5000,'m');      --check constraint


--6. DEFAULT 제약조건
-- : default 제약조건이 설정된 컬럼에 값이 입력되지 않으면, default로 설정된
--    값이 자동으로 입력된다.
-- dept01테이블 생성
DROP TABLE dept01 PURGE;
CREATE TABLE dept01(    deptno NUMBER(2) PRIMARY KEY,
                        dname VARCHAR2(14),
                        loc VARCHAR2(13) DEFAULT 'SEOUL' );

-- 테이블 확인
SELECT * FROM tab;
SELECT * FROM dept01; 
desc dept01;

-- 제약조건에 위배되지 않는 정상적인 데이터 입력
INSERT INTO dept01 VALUES(10,'ACCOUNTING','NEW YORK');
INSERT INTO dept01(deptno, dname) VALUES(20,'RESEARCH');