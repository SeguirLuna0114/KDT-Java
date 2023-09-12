-- 2023.09.12

-- Q2. 1~10 사이의 정수 중에서  짝수의 합을 구하는 PL/SQL 프로그램
SET SERVEROUTPUT ON     -- SERVEROUTPUT 환경변수 활성화
DECLARE
    s NUMBER := 0;      -- 누적합을 구할 변수
BEGIN
    -- Loop
    FOR n IN REVERSE 1..10 LOOP
        IF n MOD 2 = 0 then
            s := s +n;
        END IF;
    END LOOP;
    dbms_output.put_line('1~10까지 짝수의 합 : ' || s);
END;
            
        
    



-- Q3. 사원 테이블(EMP)에서 사원번호(EMPNO)를 매개변수로 받아서,
-- 사원 정보를 삭제하는 프로시저를 생성하고, 프로시저를 실행
-- 1) 프로시저 생성
CREATE OR REPLACE PROCEDURE del_empno(vempno IN emp.empno%TYPE)
IS
BEGIN
    DELETE FROM emp
    WHERE empno = vempno;
END;

-- 프로시저 목록 확인
SELECT * FROM user_source;

-- 2) 저장 프로시저 실행
EXECUTE del_empno(7369);

-- 3) 프로시저 실행 확인
SELECT * FROM emp;


-- Q4. 사원테이블(EMP)에서  SCOTT 사원의  사원명을 프로시저의 매개변수로 전달해서 
-- SCOTT 사원의 급여를 출력하는 프로시저를 생성하고  실행
--  1. 프로시저 생성
CREATE OR REPLACE PROCEDURE  emp_sal(
    vename IN emp.ename%TYPE,       -- 사원명
    vsal OUT emp.sal%TYPE          -- 급여
)
IS
BEGIN
    -- SQL문장(데이터 조회, 조작, 변경, 삭제)
    SELECT sal INTO vsal
    FROM emp
    WHERE ename = vename;
END;

-- 2. 프로시저 목록 확인
SELECT * FROM user_source;

-- 3. 바인드 변수 선언
    -- 바인드 변수 : 프로시저를 실행할 때, 결과를 돌려받는 변수
VARIABLE var_sal VARCHAR2;

-- 4. 프로시저 실행
EXECUTE emp_sal('SCOTT', :var_sal);

-- 5. 바인드 변수로 돌려받은 값 출력
PRINT var_sal;


-- Q5. 사원 테이블(EMP)에서 사원번호를 프로시저의 매개변수로 전달 받아서, 
-- 그 사원의 사원명, 급여,  부서번호를 구하는 프로시저 생성해서 실행
--  1. 프로시저 생성
CREATE OR REPLACE PROCEDURE emp_info(
    vempno IN emp.empno%TYPE,       -- 사원번호
    vename OUT emp.ename%TYPE,      -- 사원명
    vsal OUT emp.sal%TYPE,          -- 급여
    vdeptno OUT emp.deptno%TYPE           -- 부서번호
)
IS
BEGIN
    -- SQL문장(데이터 조회, 조작, 변경, 삭제)
    SELECT ename, sal, deptno INTO vename, vsal, vdeptno 
    FROM emp
    WHERE empno = vempno;
END;

-- 2. 프로시저 목록 확인
SELECT * FROM user_source;

-- 3. 바인드 변수 선언
    -- 바인드 변수 : 프로시저를 실행할 때, 결과를 돌려받는 변수
VARIABLE var_ename VARCHAR2(12);
VARIABLE var_sal VARCHAR2;
VARIABLE var_deptno NUMBER;

-- 4. 프로시저 실행
EXECUTE emp_info(7788, :var_ename, :var_sal, :var_deptno);
EXECUTE emp_info(7839, :var_ename, :var_sal, :var_deptno);

-- 5. 바인드 변수로 돌려받은 값 출력
PRINT var_ename;
PRINT var_sal;
PRINT var_deptno;


