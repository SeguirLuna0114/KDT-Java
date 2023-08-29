-- 2023. 08. 29 (화)

-- 저장 프로시저(Stored Procedure)

-- 자바 프로그램으로 프로시저 실행

-- 예1. 매개변수가 없는 프로시저
-- 1. 프로시저 생성
CREATE OR REPLACE PROCEDURE del_all
IS
BEGIN
    DELETE FROM emp01;
END;

-- 2. emp01테이블 생성
DROP TABLE emp01 PURGE;
CREATE TABLE emp01 AS
SELECT * FROM emp;

-- 3. 이클립스에서 del_all프로시저를 호출 => emp01테이블 데이터 삭제
SELECT * FROM emp01;

-- 자바 프로그램에서 정상적으로 종료(con.close())되었기에, 
-- 삭제된 데이터는 복구되지X
ROLLBACK;   


-- 예2. 매개변수가 있는 프로시저 생성
-- 서브쿼리로 emp01테이블에 데이터 입력
INSERT INTO emp01 SELECT * FROM emp;
SELECT * FROM emp01;

-- 1. 프로시저 생성
CREATE OR REPLACE PROCEDURE del_ename(vename IN emp01.ename%TYPE)
IS
BEGIN
    DELETE FROM emp01
    WHERE ename = vename;
END;

-- 2. 자바 프로그램으로 del_ename 프로시저 실행

-- 3. 프로시저 실행결과 확인
SELECT * FROM emp01;


-- 예3. 매개변수의 MODE가 in, out으로 되어있는 저장 프로시저
-- customer테이블 생성

-- 1. 저장 프로시저 생성
CREATE OR REPLACE PROCEDURE sel_customer(
    vname IN customer.name%TYPE,           -- 고객명
    vemail OUT customer.email%TYPE,         -- 이메일
    vtel OUT customer.tel%TYPE              -- 전화번호
)
IS
BEGIN
    -- SQL문장(데이터 조회, 조작, 변경, 삭제)
    SELECT email, tel INTO vemail, vtel 
    FROM customer
    WHERE name = vname;
END;

-- 2. 프로시저 목록 확인
SELECT * FROM user_source;

-- customer테이블 데이터 확인
SELECT * FROM customer;

-- 3. 바인드 변수 생성
    -- 바인드 변수 : 프로시저를 실행할 때, 결과를 돌려받는 변수
VARIABLE var_email VARCHAR2(20);
VARIABLE var_tel VARCHAR2(20);

-- 4. 프로시저 실행
EXECUTE sel_customer('홍길동', :var_email, :var_tel);
EXECUTE sel_customer('안화수', :var_email, :var_tel);

-- 5. 바인드 변수로 받은 결과 출력
PRINT var_email;
PRINT var_tel;
PRINT var_email var_tel;

-- 6. 자바프로그램으로 sel_customer 프로시저를 실행

