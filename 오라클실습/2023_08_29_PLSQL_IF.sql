-- 2023. 08. 29 (화)

-- PL/SQL (Oracle's Procedural Language extention to SQL)

--- 조건문(=선택문)

-- %TYPE: 변수의 데이터 타입을 다른 변수나 컬럼의 타입과 연동

-- 1. if  ~ then  ~ end if
-- Q1. 사원테이블(EMP)에서 SCOTT 사원의 부서번호를 검색해서, 부서명을 출력하는 PL/SQL문
SET SERVEROUTPUT ON  
DECLARE
    vempno NUMBER(4);           -- 스칼라 변수 선언
    vename VARCHAR2(20);
    vdeptno dept.deptno%TYPE;   -- 레퍼런스 변수 선언
    vdname VARCHAR2(20) := NULL;
BEGIN
    SELECT empno, ename, deptno 
    INTO vempno, vename, vdeptno
    FROM emp
    WHERE ename = 'SCOTT';
    
    -- IF문
--    IF vdeptno = 10 THEN
--        vdname := 'ACCOUNTING';
--    END IF;
--    IF vdeptno = 20 THEN
--        vdname := 'RESEARCH';
--    END IF;
--    IF vdeptno = 30 THEN
--        vdname := 'SALES';
--    END IF;
--    IF vdeptno = 40 THEN
--        vdname := 'OPERATIONS';
--    END IF;
    
    -- IF - ELSEIF - ELSE - ENDIF구문 사용해서 작성 가능
    IF vdeptno = 10 THEN
        vdname := 'ACCOUNTING';
    ELSIF vdeptno = 20 THEN
        vdname := 'RESEARCH';
    ELSIF vdeptno = 30 THEN
        vdname := 'SALES';
    ELSIF vdeptno = 40 THEN
        vdname := 'OPERATIONS';
    ELSE
        vdname := 'UNKNOWN';
    END IF;    

    dbms_output.put_line('사번    /   이름  / 부서명');
    dbms_output.put_line('-------------------------------------');
    dbms_output.put_line(vempno || '    /   ' || vename || '    /   '   || vdname);    
END;


-- %ROWTYPE: 테이블의 모든 컬럼의 자료형을 모두 참조한다는 의미

-- NULL 값이 포함되어 있는 산술 연산은 결과가 NULL로 평가됨
    --> NULL값을 처리하기 위해 NVL함수를 사용해 다른 값으로 대체 가능  

-- Q2. 사원 테이블에서 SCOTT사원의 연봉을 구하는 PL/SQL문 작성
-- 1) NVL함수를 사용해 NULL값을 치환하는 방법
SET SERVEROUTPUT ON     -- 서버의 출력을 활성화하는 명령
    -- PL/SQL 블록 내에서 DBMS_OUTPUT.PUT_LINE을 사용하여 메시지를 출력O
DECLARE    
    -- 변수 선언
    vemp emp%ROWTYPE;       -- 레퍼런스 변수
        -- emp 테이블의 열들과 동일한 자료형을 갖는 레코드 변수 vemp를 선언
        -- %ROWTYPE : emp테이블의 모든(8개) 컬럼의 자료형을 모두 참조한다는 의미
    annual NUMBER(7, 2);    -- 스칼라 변수
BEGIN
    -- SELECT SQL문
    SELECT * INTO vemp
    FROM emp WHERE ename = 'SCOTT';
    
    -- 연봉 변수 선언 - 연봉을 계산하여 annual변수에 할당
    -- NVL()함수를 사용해, comm 값이 NULL인 경우 0으로 대체하여 계산
    annual := vemp.sal * 12 + NVL(vemp.comm, 0);
    
    dbms_output.put_line('사번     /   이름      /   연봉');
    dbms_output.put_line(vemp.empno || '    /   ' || vemp.ename || '    /   ' || annual);   
END;

-- 2) IF문을 사용해서 NULL값을 치환하는 방법
SET SERVEROUTPUT ON     -- 서버의 출력을 활성화하는 명령
    -- PL/SQL 블록 내에서 DBMS_OUTPUT.PUT_LINE을 사용하여 메시지를 출력O
DECLARE    
    -- 변수 선언
    vemp emp%ROWTYPE;       -- 레퍼런스 변수
        -- emp 테이블의 열들과 동일한 자료형을 갖는 레코드 변수 vemp를 선언
        -- %ROWTYPE : emp테이블의 모든(8개) 컬럼의 자료형을 모두 참조한다는 의미
    annual NUMBER(7, 2);    -- 스칼라 변수
BEGIN
    -- SELECT SQL문
    SELECT * INTO vemp
    FROM emp WHERE ename = 'SCOTT';
    
    -- vemp.comm컬럼의 갑시 NULL일 경우, 0으로 치환하여 계산
    IF vemp.comm IS NULL THEN
        vemp.comm := 0;
    END IF; 
    -- 연봉 변수 선언 - 연봉을 계산하여 annual변수에 할당
    annual := vemp.sal * 12 + vemp.comm;
    
    dbms_output.put_line('사번     /   이름      /   연봉');
    dbms_output.put_line(vemp.empno || '    /   ' || vemp.ename || '    /   ' || annual);   
END;


-- 2. if  ~ then  ~ elsif ~ end if
-- Q. 사원 테이블에서 SCOTT사원의 연봉을 구하는 PL/SQL문 작성
SET SERVEROUTPUT ON
DECLARE
    vemp emp%rowtype;       -- 레코드 변수(레퍼런스 변수)
    annual NUMBER(7, 2);    -- 스칼라 변수 선언
BEGIN
    SELECT * INTO vemp
    FROM emp WHERE ename = 'SCOTT';
    
    -- IF문 작성
    -- 연봉 변수 선언 - 연봉을 계산하여 annual변수에 할당
    IF vemp.comm IS NULL THEN
        annual := vemp.sal * 12;
    ELSIF vemp.comm >= 0 then
        annual := vemp.sal * 12 + vemp.comm;
    ELSE
        -- 음수인 경우, comm 값을 무시하고 연봉 계산
        annual := vemp.sal * 12;
    END IF;     
    
    dbms_output.put_line('사번     /   이름      /   연봉');
    dbms_output.put_line(vemp.empno || '    /   ' || vemp.ename || '    /   ' || annual);   
END;


-- 3. if  ~ then  ~ elsif ~ else ~ end if
-- Q. 사원테이블(EMP)에서 SCOTT 사원의 부서번호를 검색해서, 부서명을 출력하는 PL/SQL문
SET SERVEROUTPUT ON
DECLARE
    vemp emp%rowtype;       -- 레코드 변수(레퍼런스 변수 선언)
    vdname VARCHAR2(14);    -- 스칼라 변수
BEGIN
    -- SELECT SQL문
    SELECT * INTO vemp
    FROM emp WHERE ename = 'SCOTT';
    
    -- IF문 작성
    IF vemp.deptno = 10 THEN
        vdname :=  'ACCOUNTING';
    ELSIF vemp.deptno = 20 THEN
        vdname := 'RESEARCH';
    ELSIF vemp.deptno = 30 THEN
        vdname := 'SALES';
    ELSIF vemp.deptno = 40 THEN
        vdname := 'OPERATION';
    END IF;
    
    -- 출력
    dbms_output.put_line('사번    /    이름     /   부서명');
    dbms_output.put_line(vemp.empno || '    /   ' || vemp.ename || '    /   ' || vdname);
END;

