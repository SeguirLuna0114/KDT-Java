-- 2023. 08. 28(월)

-- PL/SQL (Oracle's Procedural Language extention to SQL)

-- Q. PL/SQL로 Hello World~!! 출력
SET SERVEROUTPUT ON     -- SERVEROUTPUT 환경변수 활성화
BEGIN                   -- 실행부 시작
    dbms_output.put_line('Hello World~!!');
    -- dbms_output 패키지의 put_line 프로시저를 호출하여
    -- 메시지를 출력
END;                    -- 실행부 끝


-- Q. 변수 사용하기 : 스칼라 변수 사용
    -- SERVEROUTPUT 환경변수 활성화
SET SERVEROUTPUT ON     
DECLARE                 -- 선언부 시작
    vempno NUMBER(4);   -- 변수 선언 : 스칼라 변수
    vename VARCHAR2(10);
BEGIN                   -- 실행부 시작
    vempno := 7788;     -- 변수명은 대소문자를 구분하지X
    vename := 'SCOTT';
    dbms_output.put_line('사번    /   이름');
    dbms_output.put_line('---------------');
    dbms_output.put_line(vempno || '    /   ' || vename);
END;                    -- 실행부 끝


-- Q. 사번과 이름 검색하기 : 레퍼런스 변수 사용
SET SERVEROUTPUT ON  
DECLARE
    vempno emp.empno%TYPE;      -- 변수 선언 : 레퍼런스 변수
    vename emp.ename%TYPE;      -- 변수 선언 : 레퍼런스 변수
BEGIN
     SELECT empno, ename INTO vempno, vename 
     FROM emp
     WHERE ename = 'SCOTT';
     
    dbms_output.put_line('사번    /   이름');
    dbms_output.put_line('------------------');
    dbms_output.put_line(vempno || '    /   ' || vename);    
END;

-----------------------------------------------------------------
--- 조건문(=선택문)

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
    IF vdeptno = 10 THEN
        vdname := 'ACCOUNTING';
    END IF;
    IF vdeptno = 20 THEN
        vdname := 'RESEARCH';
    END IF;
    IF vdeptno = 30 THEN
        vdname := 'SALES';
    END IF;
    IF vdeptno = 40 THEN
        vdname := 'OPERATIONS';
    END IF;

    dbms_output.put_line('사번    /   이름  / 부서명');
    dbms_output.put_line('-------------------------------------');
    dbms_output.put_line(vempno || '    /   ' || vename || '    /   '   || vdname);    
END;

