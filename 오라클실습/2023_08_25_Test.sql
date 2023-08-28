-- 2023. 08. 25 TEST

-- Q1.
-- book 테이블을 생성
CREATE TABLE book(
					no NUMBER(2) PRIMARY KEY,
					title  varchar2(25) NOT NULL, 
					author varchar2(20),
                    publisher varchar2(20),
                    price NUMBER(6),
					pub_day  DATE DEFAULT SYSDATE );

SELECT * FROM book;


-- Q2. Oracle 데이터베이스를 통한 현재 날짜를 기본형식(23/01/01)과 
-- 사용자 형식(2023-01-01)으로 차례로 출력하는 SQL문을 작성
-- 1) 기본형식 출력
SELECT SYSDATE FROM dual;
-- 2) 사용자 형식 출력
SELECT TO_CHAR(SYSDATE, 'YYYY-MM-DD') FROM dual;

SELECT sysdate, TO_CHAR(SYSDATE, 'YYYY-MM-DD') FROM dual;


-- Q3. 사원테이블(EMP)에서 최대 급여를 받는 사원명과,
--      최대급여 금액을 출력하는 SQL문을 작성
SELECT ename, sal
FROM emp
WHERE sal = (SELECT MAX(sal) FROM emp);


-- Q4. MySQL을 Oracle로 DB Migration을 하고자 한다. 
-- 마이그레이션 한 결과가 같아지도록 아래 내용을 완성하시오
-- 1) Oracle Sequence 생성
CREATE SEQUENCE member_no_seq
    START with 1
    INCREMENT by 1;

-- seq 목록 출력
SELECT * FROM seq;

-- 2) insert문 작성
INSERT INTO member VALUES(member_no_seq.nextval, 'hong');


-- Q5. name, phone 컬럼을 기본키. composite key(복합키) 이름(Constraint)은 member_compo_pk
CREATE TABLE member(
    name VARCHAR2(10),
    address varchar2(30),
    phone varchar2(16),
    CONSTRAINT member_compo_pk PRIMARY KEY (name, phone)
    );

-- 테이블 확인
desc member001;











                    
                    
                    
            