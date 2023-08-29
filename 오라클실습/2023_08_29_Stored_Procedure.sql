-- 2023. 08. 29 (화)

-- 저장 프로시저(Stored Procedure)

-- emp01테이블 생성
DROP TABLE emp01 PURGE;
-- emp테이블의 복사본 emp01테이블 생성
CREATE TABLE emp01 AS
SELECT * FROM emp;
-- emp01테이블 데이터 확인
SELECT * FROM emp01;

-- 매개변수가 없는 저장 프로시저
-- 1. 매개변수가 없는 저장 프로시저 생성
CREATE OR REPLACE PROCEDURE del_all
IS
BEGIN
    DELETE FROM emp01;
END;

-- 2. 프로시저 목록 확인
SELECT * FROM user_source;

-- 3. 프로시저 실행
exec del_all;
EXECUTE del_all;

-- 4. 프로시저 실행 확인
SELECT * FROM emp01;        -- 프로시저에 의해 데이터가 모두 삭제됨

-- 삭제한 데이터 복구
ROLLBACK;   
-- 롤백이 되지 않는 경우, emp 데이터를 입력
INSERT INTO emp01 SELECT * FROM emp;

-------------------------------------------------------------------

-- 매개변수를 갖는 저장 프로시저

-- 매개변수의 MODE가 IN으로 되어있는 프로시저
-- IN : 매개변수로 값을 받는 역할
-- 1. 매개변수가 있는 저장 프로시저 생성
CREATE OR REPLACE PROCEDURE del_ename(vename IN emp01.ename%TYPE)
IS
BEGIN
    DELETE FROM emp01 WHERE ename = vename;
END;

-- 2. 프로시저 목록 확인
SELECT * FROM user_source;

-- 3. 프로시저 실행
EXECUTE del_ename('SCOTT');
EXECUTE del_ename('SMITH');
EXECUTE del_ename('KING');

-- 4. 프로시저 실행 확인
SELECT * FROM emp01; 
SELECT * FROM emp01 WHERE ename = 'SCOTT';  -- 확인되지 않음(실행 성공)
SELECT * FROM emp01 WHERE ename = 'SMITH';
SELECT * FROM emp01 WHERE ename = 'KING';


-- 매개변수의 MODE가 out으로 되어있는 프로시저
-- IN : 매개변수로 값을 받는 역할
-- out : 매개변수로 값을 돌려주는 역할

-- Q. 프로시저의 매개변수에 사원번호를 전달해서, 그 사원의 사원명, 급여, 직책을 구하는
-- 프로시저를 생성하고 실행
--  1. 프로시저 생성
CREATE OR REPLACE PROCEDURE sal_empno(
    vempno IN emp.empno%TYPE,       -- 사원번호
    vename OUT emp.ename%TYPE,      -- 사원명
    vsal OUT emp.sal%TYPE,          -- 급여
    vjob OUT emp.job%TYPE           -- 직책
)
IS
BEGIN
    -- SQL문장(데이터 조회, 조작, 변경, 삭제)
    SELECT ename, sal, job INTO vename, vsal, vjob 
    FROM emp
    WHERE empno = vempno;
END;

-- 2. 프로시저 목록 확인
SELECT * FROM user_source;

-- 3. 바인드 변수 선언
    -- 바인드 변수 : 프로시저를 실행할 때, 결과를 돌려받는 변수
VARIABLE var_ename VARCHAR2(12);
VARIABLE var_sal VARCHAR2;
VARIABLE var_job VARCHAR2(10);

-- 4. 프로시저 실행
EXECUTE sal_empno(7788, :var_ename, :var_sal, :var_job);
EXECUTE sal_empno(7839, :var_ename, :var_sal, :var_job);

-- 5. 바인드 변수로 돌려받은 값 출력
PRINT var_ename;
PRINT var_sal;
PRINT var_job;
PRINT var_ename var_sal var_job;

