-- 2023. 08. 30 (수)

-- 패키지(Package) = 저장 프로시저와 저장 함수를 묶어놓은 것
-- 패키지 구성요소 = 패키지 헤드 + 패키지 바디

-- 패키지 생성
--  1. 패키지 헤드 생성
CREATE OR REPLACE PACKAGE exam_pack
IS
    -- 패키지 헤드를 구성하는 저장함수
    FUNCTION cal_bonus(
        vempno IN emp.empno%TYPE)
    RETURN NUMBER;
    
    -- 패키지 헤드를 구성하는 저장 프로시저
    PROCEDURE cursor_sample02;
END;


-- 2. 패키지 바디 생성
CREATE OR REPLACE PACKAGE BODY exam_pack
IS
    -- 저장 함수 : cal_bonus
    FUNCTION cal_bonus(vempno IN emp.empno%TYPE)
    RETURN NUMBER   -- 돌려줄 값의 자료형
    IS
        -- 로컬 변수 선언
        vsal NUMBER(7, 2);
    BEGIN
        -- SQL문 작성
        SELECT sal INTO vsal
        FROM emp WHERE empno = vempno;
    
        RETURN vsal * 2;    -- 급여를 200% 인상한 결과 리턴
    END;
    
    -- 저장 프로시저 : cursor_sample02
    PROCEDURE cursor_sample02
    IS
        vdept dept%ROWTYPE;     -- 로컬변수
    
        -- 커서 선언
        CURSOR c1 IS
            SELECT * FROM dept; 
    BEGIN
        dbms_output.put_line('부서번호  /   부서명     / 지역명');
        dbms_output.put_line('------------------------------------');
    
        -- FOR...IN LOOP문을 사용
        FOR vdept IN c1 LOOP
            EXIT WHEN c1%notfound;  -- 커서가 가져올 데이터가 없는 경우 true 리턴
            dbms_output.put_line(vdept.deptno || '  /   ' || vdept.dname || '   /   ' || vdept.loc);
        END LOOP;
    END;
END;

-- 3. 저장 프로시저 실행 :cursor_sample02
EXECUTE exam_pack.cursor_sample02;

-- 4. 저장 함수 실행 : cal_bonus()
-- 바인드 변수 생성
VARIABLE var_res NUMBER;

-- 저장 함수 실행
EXECUTE :var_res := exam_pack.cal_bonus(7788);
EXECUTE :var_res := exam_pack.cal_bonus(7900);

-- 바인드 변수로 받은 값을 출력
PRINT var_res;

-- SELECT문으로 저장함수 실행
SELECT ename, exam_pack.cal_bonus(7788)
FROM emp WHERE empno = 7788;
    -- SCOTT	6000

SELECT ename, exam_pack.cal_bonus(7900)
FROM emp WHERE empno = 7900;
    -- JAMES	1900


