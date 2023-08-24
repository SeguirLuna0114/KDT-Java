-- 2023. 08. 24(목)

-- 뷰(view) : 기본 테이블을 이용해서 만들어진 가상 테이블

-- 실습을 위한 기본 테이블 생성 : dept_copy, emp_copy
-- 2개의 기본 테이블 생성
CREATE TABLE dept_copy AS
SELECT * FROM dept;

CREATE TABLE emp_copy AS
SELECT * FROM emp;

-- 생성한 테이블 확인
SELECT * FROM tab;
SELECT * FROM dept_copy;
SELECT * FROM emp_copy;

-- 뷰 생성
    -- scott계정은 뷰를 생성할 수 있는 권한은 없음
    -- 따라서, system계정으로 접속해서 GRANT명령어로 특정 사용자에게 권한을 부여해줘야 함
    -- GRANT CREATE VIEW TO SCOTT;      -- SCOTT계정에게 view생성할 수 있는 권한 부여
CREATE VIEW emp_view30 AS
SELECT empno, ename, deptno FROM emp_copy WHERE deptno=30;

-- 뷰 목록 확인
SELECT * FROM tab;
SELECT * FROM user_views;

--뷰 검색
SELECT * FROM emp_view30;
desc emp_view30;

-- Q. 뷰(emp_view30)에 insert로 데이터를 입력했을 경우,
--    기본테이블(emp_copy)에 데이터가 입력되는지
-- view에 데이터 입력
INSERT INTO emp_view30 VALUES(1111, '홍길동', 30);
SELECT * FROM emp_view30;

-- view에 데이터가 입력되면, 기본 테이블에도 데이터가 입력됨
SELECT * FROM emp_copy;


-- 뷰의 종류
--  1. 단순뷰: 하나의 기본 테이블로 생성된 뷰
--  2. 복합뷰: 여러개의 기본 테이블로 생성된 뷰

-- 1. 단순뷰
-- Q. 기본 테이블인 emp_copy를 이용해서 20번 부서에 소속된 사원들의 사번과 이름, 부서번호, 
--    직속상사의 사번을 출력하기 위한 뷰(emp_view20)을 생성
CREATE VIEW emp_view20 AS
SELECT empno, ename, deptno, mgr FROM emp_copy WHERE deptno=20;

-- 뷰 목록 확인
SELECT * FROM tab;
SELECT * FROM user_views;

--뷰 검색
SELECT * FROM emp_view20;
desc emp_view20;

-- 2. 복합뷰
-- Q. 각 부서별(부서명) 최대급여와 최소급여를 출력하는 뷰를 sal_view라는 이름으로 작성
CREATE VIEW sal_view AS
SELECT dname, max(sal) MAX, min(sal) MIN 
FROM dept, emp
WHERE dept.deptno = emp.deptno
group BY dname;

-- 뷰 목록 확인
SELECT * FROM tab;
SELECT * FROM user_views;

--뷰 데이터 확인
SELECT * FROM sal_view;
desc sal_view;

-- 뷰 삭제
-- 형식 : DROP WIEW 뷰이름;
DROP VIEW sal_view;

-- 뷰를 생성할 때 사용되는 옵션
-- 1. or replace옵션
--  기존에 뷰가 존재하지 않으면 뷰를 생성하고, 만일 동일한 이름을 가진 뷰가
--  존재하면 뷰의 내용을 수정하도록 만들어주는 옵션

-- 1) or replace 옵션 없이 동일한 뷰(emp_view30)을 생성
--      똑같은 이름을 가진 뷰가 존재하기에, 오류 발생(name is already used)
CREATE VIEW emp_view30 AS
SELECT empno, ename, deptno, sal, comm FROM emp_copy WHERE deptno=30;

-- 2) or replace 옵션을 붙여서 동일한 뷰(emp_view30)를 생성
--      똑같은 이름을 가진 뷰가 존재한다면, 뷰의 내용이 수정됨
CREATE OR REPLACE VIEW emp_view30 AS
SELECT empno, ename, deptno, sal, comm FROM emp_copy WHERE deptno=30;

-- 3) 뷰 확인
SELECT * FROM emp_view30;


-- 2. with check option
--    : where 조건절에 사용된 값을 수정하지 못하도록 만들어주는 옵션
-- 1) with check option을 사용하지 않은 경우
CREATE OR REPLACE VIEW emp_view30 AS
SELECT empno, ename, deptno, sal, comm FROM emp_copy WHERE deptno=30;

-- Q. emp_view30뷰에서 급여가 1200 이상인 사원들의 부서번호를 30번에서 20번으로 수정
    -- with check option을 사용하지 않은 경우, 수정 가능함
UPDATE emp_view30 set deptno=20 where sal >=1200;
SELECT * from emp_view30;

-- 2) with check option을 사용한 경우
--  뷰에 insert, update, delete가 실행되면, 기본 테이블에도 동일한 내용이 적용됨
select * from emp_copy;     -- 기본 테이블 내용이 변경되어 있음
DROP TABLE emp_copy PURGE;

CREATE TABLE emp_copy AS    -- 기본 테이블 생성
SELECT * FROM emp;

-- with check option을 사용해서 뷰 생성
CREATE OR REPLACE VIEW emp_view30 AS
SELECT empno, ename, deptno, sal, comm 
FROM emp_copy 
WHERE deptno=30 WITH CHECK OPTION;

-- Q. emp_view30뷰에서 급여가 1200 이상인 사원들의 부서번호를 30번에서 20번으로 수정
    -- with check option을 사용한 경우 오류 발생
UPDATE emp_view30 set deptno=20 where sal >=1200;   -- view WITH CHECK OPTION


-- 3. with read only 옵션
--  : 읽기 전용의 뷰를 만들어주는 옵션
--    뷰를 통해서 기본 테이블의 내용을 수정하지 못하도록 만들어주는 역할
CREATE OR REPLACE VIEW view_read30 AS
SELECT empno, ename, deptno, sal, comm 
FROM emp_copy 
WHERE deptno=30 WITH READ ONLY;     -- 읽기 전용의 view 생성

-- 뷰 목록 확인
SELECT * FROM user_views;
-- 생성한 뷰 데이터 확인
SELECT * FROM view_read30;

-- Q. 생성된 뷰(view_read30)를 수정
    -- 오류발생: 읽기 전용의 뷰는 with read only 옵션때문에 수정X
UPDATE view_read30 SET sal = 3000;


