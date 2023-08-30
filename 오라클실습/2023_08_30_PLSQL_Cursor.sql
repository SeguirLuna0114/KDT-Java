-- 2023. 08. 30 (수)

-- 커서(Cursor)
-- : 2개 이상의 데이터를 처리할 때 커서를 사용

-- LOOP 문을 사용하여 커서를 순회하는 경우

-- Q1. 부서 테이블의 모든 데이터를 출력하기 위한 PL/SQL문
-- 1. 저장 프로시저 생성
SET SERVEROUTPUT ON
CREATE OR REPLACE PROCEDURE cursor_sample01
IS
    -- 변수 선언
    vdept dept%ROWTYPE;     -- 로컬변수

    -- 커서 선언
    CURSOR c1
    IS
    SELECT * FROM dept;
BEGIN
    dbms_output.put_line('부서번호  /  부서명  /   지역명');
    dbms_output.put_line('----------------------------------------');
    
    -- 커서 열기(첫번째 데이터를 가져옴)
    OPEN c1;
        LOOP
            FETCH c1 INTO vdept.deptno, vdept.dname, vdept.loc;  -- 인출할 컬럼
                EXIT WHEN c1%notfound;  -- 커서가 가져올 데이터가 없을 때 true
            dbms_output.put_line(vdept.deptno || '  /  ' || vdept.dname || '    /   ' || vdept.loc);
        END LOOP;
    -- 커서 닫기
    CLOSE c1;
END;
    
-- 2. 저장 프로시저 목록 확인
SELECT * FROM user_source;

-- 3. 프로시저 실행
EXECUTE cursor_sample01;


-- For...IN LOOP문으로 처리
--  1) open~ fetch ~ close 없이 처리할 수 있다
--  2) for loop문을 사용하게 되면 각 반복문마다 cursor를 열고,
--      각 행을 인출(fetch)하고, cursor를 닫는 작업을 자동적으로 처리해줌

-- Q2. 부서 테이블의 모든 데이터를 출력하는 PL/SQL문
SET SERVEROUTPUT ON
CREATE OR REPLACE PROCEDURE cursor_sample02
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

-- 2. 저장 프로시저 목록 확인
SELECT * FROM user_source
WHERE type = 'PROCEDURE' AND name = 'CURSOR_SAMPLE02';

-- 3. 프로시저 실행
EXECUTE cursor_sample02;


-- Q3. 사원테이블에서 부서번호를 전달하여 해당 부서에 소속된 사원의 정보를
--      출력하는 프로시저를 커서를 이용해서 작성
-- 1. 저장 프로시저 생성
SET SERVEROUTPUT ON
CREATE OR REPLACE PROCEDURE info_emp(
    vdeptno IN emp.deptno%TYPE
)
IS
    -- FOR...IN LOOP문에서 사용하는 레코드변수는 선언 없이 바로 사용 가능
--    vemp emp%ROWTYPE;     -- 로컬변수
    
    -- 커서 선언
    CURSOR c1 IS
        SELECT * FROM emp
        WHERE deptno = vdeptno;
BEGIN
    dbms_output.put_line('부서번호  /  사원번호  /  사원명  /  직급  /  급여');
    dbms_output.put_line('----------------------------------------------------');
    
    -- FOR...IN LOOP문을 사용
    FOR vemp IN c1 LOOP
        dbms_output.put_line(vemp.deptno || '  /  ' || vemp.empno || '  /  ' || vemp.ename || '  /  ' || vemp.job || '  /  ' || vemp.sal);
    END LOOP;
END;

-- 2. 저장 프로시저 목록 확인
SELECT * FROM user_source
WHERE type = 'PROCEDURE' AND name = 'INFO_EMP';

-- 3. 프로시저 실행
EXECUTE info_emp(10);
EXECUTE info_emp(20);
EXECUTE info_emp(30);
EXECUTE info_emp(40);

