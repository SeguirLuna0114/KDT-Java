-- 2023. 08. 28(월)

-- Q1. 사원 테이블(EMP)에서  SCOTT의 급여보다 적게 받는 사원의 이름, 급여를 출력하는 SQL문을 작성
SELECT ename, sal
FROM emp
WHERE sal < (SELECT sal FROM emp WHERE ename = 'SCOTT');


-- Q2. 사원 테이블(EMP)에서 각 부서별 평균 급여를 구하는 SQL문
SELECT deptno, AVG(sal)
FROM emp
GROUP BY deptno;


-- Q3. 사원테이블(EMP)에서  사원명에 A가 포함된 사원을 검색하는 SQL문
SELECT ename
FROM emp
WHERE ename LIKE '%A%';


-- Q4. 사원테이블(EMP)에서 급여를 많이 받는 사원  5명을 구하는 SQL문을 인라인뷰로 작성
SELECT ROWNUM, emp_inline.*
FROM (
        SELECT ename, sal
        FROM emp
        ORDER BY sal DESC
) emp_inline
WHERE ROWNUM < 6;

-- 사원명만 출력
SELECT ROWNUM, emp_inline.ename
FROM (
        SELECT ename, sal
        FROM emp
        ORDER BY sal DESC
) emp_inline
WHERE ROWNUM < 6;


-- Q5. 사원테이블(EMP)에서 82년도에 입사한 모든 사원의 정보를 출력하는 SQL문
SELECT *
FROM emp
WHERE hiredate BETWEEN '82/01/01' AND '82/12/31';


-- Q6. 사원테이블(EMP)에서 사번, 이름, 급여, 연봉을 조회하는 SQL문장
SELECT empno, ename, sal, sal*12 + NVL(comm, 0) AS annual 
FROM emp;


-- Q7. SQL문을 각각 작성
-- 1) 아래의 정보로 전산실에 입사한 신입사원에게 새로운 계정을 생성
    -- (계정명 : myuser ,  비밀번호 : tiger)
conn system/oracle  -- 시스템 계정으로 접속
CREATE USER myuser IDENTIFIED BY tiger;

-- 2) 생성한 계정에게 데이터 접속 및 테이블, 뷰를 생성할 수 있는 권한을 
    -- 직접 롤(role)을 생성해서 권한을 부여
-- 시스템 계정으로 접속
conn system/oracle
-- 사용자 정의 롤 생성
CREATE ROLE my_role;

-- 생성한 롤에 시스템 권한을 부여
GRANT CREATE SESSION, CREATE TABLE, CREATE VIEW TO my_role;

-- 생성한 계정(myuser)에게 생성한 롤 할당
GRANT my_role TO myuser;

-- myuser 계정으로 접속하여 권한 사용
conn myuser


-- Q8. 제약조건을 만족하는 테이블을 각각 작성
-- book 테이블
CREATE TABLE book (
    bookid NUMBER(2) PRIMARY KEY,
    bookname VARCHAR2(40),
    publisher VARCHAR2(40),
    price NUMBER(8) );
    
-- customer 테이블
CREATE TABLE customer (
    custid NUMBER(2) PRIMARY KEY,
    name VARCHAR2(40),
    address VARCHAR2(50),
    phone VARCHAR2(20) );
    
-- Orders 테이블
CREATE TABLE orders (
    orderid NUMBER(2) PRIMARY KEY,
    custid NUMBER(2) REFERENCES customer(custid),
    bookid NUMBER(2) REFERENCES book(bookid),
    saleprice NUMBER(8),
    orderdate DATE  );
