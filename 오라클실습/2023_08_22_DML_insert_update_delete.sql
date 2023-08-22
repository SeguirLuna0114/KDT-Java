-- 2023. 08. 22(화)

-- DML(Data Manulpation Language, 데이터 조작어)
--  insert, update, delete

-- 1. insert : 데이터 입력
--  1) 형식
--      case1) 컬럼값을 모두 입력하는 경우
--          insert into 테이블명(컬럼1, 컬럼2,..) values(데이터1, 데이터2,...);
--      case2) 값만 입력하는 경우
--          insert into 테이블명 values(데이터1, 데이터2,...);

-- dept01테이블을 생성
-- dept01테이블이 생성되어 있는 경우에 대비하여, drop해서 삭제
DROP TABLE dept01 PURGE;

-- 비어있는 dept01 복사본 테이블 생성(단, 테이블 구조만 복사)
CREATE TABLE dept01 AS 
SELECT * FROM dept
WHERE 1=0;              -- 1=0은 항상 false이기에, 어떠한 레코드도 선택되지 않음

-- 생성되었는지 확인
SELECT * FROM dept01;

-- 데이터 입력(INSERT INTO 문을 사용하여 데이터를 특정 테이블에 추가)
    --  case1) 컬럼값을 모두 입력하는 경우
    --       insert into 테이블명(컬럼1, 컬럼2,..) values(데이터1, 데이터2,...);
INSERT INTO dept01 (deptno, dname, loc)
VALUES (10, 'ACCOUNTING', 'NEW YORK');

    --  case2) 값만 입력하는 경우
    --       insert into 테이블명 values(데이터1, 데이터2,...);
INSERT INTO dept01
VALUES (20, 'RESEARCH', 'DALLAS');    
    
INSERT INTO dept01
VALUES (30, '영업부', '서울');    

-- NULL값 입력
INSERT INTO dept01 (deptno, dname) 
VALUES (40, '개발부');                 -- loc컬럼 null
    -- 명시적으로 NULL값을 입력 가능
INSERT INTO dept01 
VALUES (50, '기획부', NULL);           -- loc컬럼 null


-- 2) 서브쿼리로 데이터 입력
-- dept01테이블이 생성되어 있는 경우에 대비하여, drop해서 삭제
DROP TABLE dept02 purge;

-- dept02 테이블 생성 : 'WHERE 1=0'을 이용해 테이블 구조만 복사
CREATE TABLE dept02 AS
SELECT * FROM dept 
WHERE 1=0;

-- dept02테이블 확인
SELECT * FROM dept02;

-- 서브쿼리로 데이터 입력
INSERT INTO dept02 SELECT * FROM dept;
INSERT INTO dept02 SELECT * FROM dept02;

SELECT count(*) FROM dept02;


-- 3) INSERT ALL 명령문으로 다중 테이블에 데이터 입력
-- 2개의 테이블 생성
CREATE TABLE emp_hir AS
SELECT empno, ename, hiredate FROM emp
WHERE 1=0;

CREATE TABLE emp_mgr AS
SELECT empno, ename, mgr FROM emp
WHERE 1=0;

-- insert all 명령문으로 다중 테이블에 데이터 입력
INSERT ALL
        INTO emp_hir 
            VALUES (empno, ename, hiredate)
        INTO emp_mgr
            VALUES (empno, ename, mgr)
SELECT empno, ename, hiredate, mgr FROM emp WHERE deptno=20;            
           
SELECT * FROM emp_hir;
SELECT * FROM emp_mgr;


-- 2. update :기존 데이터 수정
-- 형식: update   테이블     set   컬럼1 = 수정할 값 1,
--                               컬럼2 = 수정할 값 2
--      where 조건절;

-- dept01테이블이 생성되어 있는 경우에 대비하여, drop해서 삭제
DROP TABLE emp01 purge;

-- emp01 테이블 생성
CREATE TABLE emp01 AS
SELECT * FROM emp;

-- 생성된 테이블 확인
SELECT * FROM emp01;

-- 1) 모든 데이터 수정 : where 조건절을 사용하지 않음 => 모든 레코드(행)에 영향
-- Q1. 모든 사원들의 부서번호를 30번 수정
UPDATE emp01 SET deptno = 30;

-- Q2. 모든 사원들의 급여를 10% 인상
UPDATE emp01 SET sal = sal * 1.1;

-- Q3. 모든 사원들의 입사일을 오늘 날짜로 수정
UPDATE emp01 SET hiredate = sysdate;


-- 2) 특정 데이터 수정 : where 조건절을 사용
DROP TABLE emp02 purge;

-- 복사본 테이블 생성
CREATE TABLE emp02 AS
SELECT * FROM emp;
    -- 생성한 테이블 확인
    SELECT * FROM emp02;
    
-- Q1. 급여가 3000이상인 사원만 급여를 10%인상
UPDATE emp02 SET sal = sal * 1.1 where sal >= 3000;

-- Q2. 1987년도에 입사한 사원만 입사일을 오늘 날짜로 수정?
    -- substr()사용하는 방법
UPDATE emp02 SET hiredate = sysdate WHERE substr(hiredate, 1, 2) = '87';
    -- to_char()함수 사용하는 방법
UPDATE emp02 SET hiredate = sysdate WHERE To_char(hiredate, 'yyyy') = '1987';
    -- 비교연산자 사용하는 방법
UPDATE emp02 SET hiredate = sysdate 
            WHERE hiredate >= '87/01/01' AND hiredate <= '87/12/31';
    -- BETWEEN 연산자 사용
UPDATE emp02 SET hiredate = sysdate 
            WHERE hiredate BETWEEN '87/01/01' AND '87/12/31';

-- Q3. SCOTT사원의 입사일을 오늘 날짜로 수정하고, 급여를 50, 커미션을 4000으로 수정
UPDATE emp02 SET hiredate = sysdate, sal=50, comm=4000
            WHERE ename = 'SCOTT';

-- 3) 서브쿼리를 이용한 데이터 수정
-- Q. 20번 부서의 지역명(DALLAS)를 40번 부서의 지역명(BOSTON)으로 수정
-- 기존에 생성되어있던 테이블 drop
DROP TABLE dept01 purge;

-- 복사본 테이블 생성
create table dept01 AS
SELECT * FROM dept;

-- 생성한 dept01테이블 확인
select * from dept01;

-- 서브쿼리를 이용한 update문 작성
UPDATE dept01
SET loc = (SELECT loc FROM dept01 WHERE deptno = 40)
WHERE deptno = 20;


-- 3. delete : 데이터 삭제
-- 형식 : delete from 테이블 where 조건절;

-- 1) 모든 데이터 삭제 : where 조건절을 사용하지 않음
SELECT * FROM dept01;
DELETE FROM dept01;

ROLLBACK;           -- 트랜잭션 취소

-- 2) 조건절을 만족하는 데이터 삭제 : where 조건절을 사용
-- Q. dept01 테이블의 30번 부서만 삭제
DELETE FROM dept01 WHERE deptno = 30;
SELECT * FROM dept01;

-- 3) 서브쿼리를 이용한 데이터 삭제
-- Q. 사원테이블(emp02)에서 부서명이 SALES 부서의 사원을 삭제
-- 기존에 존재하는 emp02테이블 삭제
DROP TABLE emp02 PURGE;

-- 복사본 emp02테이블 생성
CREATE TABLE emp02 AS
SELECT * from emp;

-- 생성한 테이블 확인
SELECT * FROM emp02;

-- 서브쿼리를 사용해서, SALES부서 사원 삭제
DELETE FROM emp02
WHERE deptno = (SELECT deptno FROM dept WHERE dept.dname = 'SALES');

  
    
    