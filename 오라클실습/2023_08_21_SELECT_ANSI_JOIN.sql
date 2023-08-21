-- 2018. 08. 21(월)

-- ANSI JOIN
-- ANSI(미국 표준협회) 표준안에 따라서 만들어진 join방법

-- ANSI CROSS JOIN
SELECT * FROM dept CROSS JOIN emp;  -- 4 * 14 = 56개 데이터 검색
SELECT * FROM emp CROSS JOIN dept;  -- 14 * 4 = 56개 데이터 검색

-- ANSI INNER JOIN: 등가 조인과 같은 의미를 가진 조인방법
-- Q. SCOTT 사원이 소속된 부서명을 출력하는 SQL문을 ANSI INNER JOIN으로 작성]
SELECT ename, dname FROM dept 
INNER JOIN emp ON dept.deptno = emp.deptno
WHERE ename = 'SCOTT';

-- using절을 이용해서 조인
SELECT ename, dname FROM dept 
INNER JOIN emp USING(deptno)
WHERE ename = 'SCOTT';

-- ANSI NATURAL JOIN
-- DEPT와 EMP 테이블 사이의 공통 컬럼이 같다는 의미
SELECT ename, dname FROM dept 
NATURAL JOIN emp
WHERE ename = 'SCOTT';

-- ANSI OUTER JOIN
-- 형식: select * from table [left/right/full] outer join table2;

-- 1. dept01 테이블 생성
CREATE TABLE dept01 ( deptno NUMBER(2), dname VARCHAR2(14) );

INSERT INTO dept01 VALUES(10, 'ACCOUNTING');
INSERT INTO dept01 VALUES(20, 'RESEARCH');

SELECT * FROM dept01;

-- 2. dept02테이블 생성
CREATE TABLE dept02 ( deptno NUMBER(2), dname VARCHAR2(14) );

INSERT INTO dept02 VALUES(10, 'ACCOUNTING');
INSERT INTO dept02 VALUES(30, 'SALES');

SELECT * FROM dept02;

-- 3. LEFT OUTER JOIN
    -- ON 조건절 사용
SELECT * 
FROM dept01
LEFT OUTER JOIN dept02 ON dept01.deptno = dept02.deptno;
    -- Using절 사용
SELECT * 
FROM dept01
LEFT OUTER JOIN dept02 USING(deptno);

-- 4. RIGHT OUTER JOIN
    -- ON 조건절 사용
SELECT * 
FROM dept01
RIGHT OUTER JOIN dept02 ON dept01.deptno = dept02.deptno;
    -- Using절 사용
SELECT * 
FROM dept01
RIGHT OUTER JOIN dept02 USING(deptno);

-- 5. FULL OUTER JOIN
    -- ON 조건절 사용
SELECT *
FROM dept01 d1
FULL OUTER JOIN dept02 d2 ON d1.deptno = d2.deptno;
    -- Using절 사용
SELECT * 
FROM dept01
FULL OUTER JOIN dept02 USING(deptno);





