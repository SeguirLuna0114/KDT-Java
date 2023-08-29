-- 2023. 08. 29 (화)

-- PL/SQL (Oracle's Procedural Language extention to SQL)

-- LOOP 반복문
-- 1. Basic Loop문
--      LOOP
--          반복 실행될 문장;
--          조건식 EXIT;
--      END LOOP;

-- Q1. Basic Loop문으로 1~5까지 출력
SET SERVEROUTPUT ON
DECLARE
    --n변수의 초기값을 1로 설정
    n NUMBER := 1;
BEGIN
    -- Loop문
    LOOP
        dbms_output.put_line(n);
        n := n+1;
        EXIT WHEN n > 5;    -- EXIT문을 사용해서 LOOP문 빠져나옴
        
        -- IF문을 사용해서 EXIT문 작성 가능
--        IF n > 5 THEN
--            EXIT;
--        END IF;       
    END LOOP;
END;


-- Q2. Basic Loop문으로 1~10까지의 합 출력
SET SERVEROUTPUT ON
DECLARE
    --n변수의 초기값을 1로 설정
    n NUMBER := 1;      -- 루프를 돌릴 변수
    s NUMBER := 0;      -- 누적합을 구할 변수
    
BEGIN
    -- Loop문
    LOOP
        s := s + n;     -- 변수의 합을 구함
        n := n + 1;       -- 루프 돌릴 변수를 1 증가
        
        -- EXIT WHEN 구문을 사용
        EXIT WHEN n > 10;    -- EXIT문을 사용해서 LOOP문 빠져나옴
        
        -- IF문을 사용해서 EXIT문 작성 가능
--        IF n > 10 THEN
--            EXIT;
--        END IF;       
    END LOOP;
    dbms_output.put_line('1~10까지의 합 : ' || s);
END;


-- 2. For Loop문
--      FOR  변수  IN [REVERSE] 작은값.. 끝값 LOOP
--          반복 실행될 문장;
--      END LOOP;

-- Q1. FOR LOOP문으로 1부터 5까지 출력
SET SERVEROUTPUT ON
BEGIN
    FOR n IN 1..5 LOOP
        dbms_output.put_line('n의 값: ' || n);
    END LOOP;
END;

-- Q2. FOR LOOP문으로 5부터 1까지 출력
SET SERVEROUTPUT ON
BEGIN
    FOR n IN REVERSE 1..5 LOOP
        dbms_output.put_line('n의 값: ' || n);
    END LOOP;
END;

-- Q3. For Loop문을 이용해서 부서 테이블(DEPT)의 모든 정보를 출력하는 PL/SQL문
SET SERVEROUTPUT ON
DECLARE
    vdept dept%rowtype;     -- dept테이블의 모든 컬럼의 자료형을 참조
    vdept_cnt NUMBER;       -- dept테이블의 행수 조회하는 변수
BEGIN
    -- dept테이블의 행수를 조회하고, 그 값을 For Loop의 끝값으로 설정
    SELECT count(*) INTO vdept_cnt FROM dept;

    dbms_output.put_line('부서번호  /   부서명   /   지역명'); 
    FOR cnt IN 1..vdept_cnt LOOP
        SELECT * INTO vdept 
        FROM dept WHERE deptno = 10 * cnt;
        
        dbms_output.put_line(vdept.deptno || '  /   ' || vdept.dname || '   /   ' || vdept.loc);
    END LOOP;
END;


-- 3. while loop문
--      while 조건식 loop
--          실행될 문장;
--      end loop;

-- Q1. While Loop문으로 1부터 5까지 출력
SET SERVEROUTPUT ON
DECLARE
    n NUMBER := 1;      -- n변수의 초기값을 1로 설정
BEGIN
    WHILE n <= 5 LOOP
        dbms_output.put_line('n의 값: ' || n);
        n := n + 1;
    END LOOP;
END;

-- Q2. While Loop문으로 별(*)을 삼각형 모양으로 출력
SET SERVEROUTPUT ON
DECLARE
    c NUMBER := 1;
    star VARCHAR2(100) := '';       -- star VARCHAR2(100); 와 동치
    -- star변수를 빈 문자열로 초기화
BEGIN
    WHILE c <= 10 LOOP
        star := star || '*';        -- star 변수에 '*' 문자를 누적
        dbms_output.put_line(star); -- 현재까지 누적된 '*' 문자를 출력
        c := c + 1;                 --c 값을 1 증가시킴
    END LOOP;
END;

-- 가운데 정렬된 삼각형 모양의 별(*)문자 출력
    -- LPAD(string, length, pad_string): 문자열을 왼쪽으로 패딩
            -- string: 패딩할 대상 문자열
            -- length: 최종 문자열의 길이
            -- pad_string: 패딩에 사용할 문자열 (옵션)
    -- RPAD(string, length, pad_string): 문자열을 오른쪽으로 패딩
            -- string: 패딩할 대상 문자열
            -- length: 최종 문자열의 길이
            -- pad_string: 패딩에 사용할 문자열 (옵션)
SET SERVEROUTPUT ON
DECLARE
    c NUMBER := 1;
    star VARCHAR2(100) := '*';   -- star변수를 빈 문자열로 초기화
    total_space NUMBER := 10;
    space VARCHAR2(100);    --빈 공간을 출력시킬 변수
    
BEGIN
    WHILE c <= 10 LOOP
        space := LPAD(' ', total_space - c, ' ') ;
        star := RPAD(star, 2*c - 1, '*');
        
        dbms_output.put_line(space || star);
        c := c+1;
    END LOOP;
END;

