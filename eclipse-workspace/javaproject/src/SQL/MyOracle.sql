-- SELECT FROM 문으로 테이블 목록 출력(이 경우에만 result탭이 보임)
--- tab으로 테이블 목록 출력
select * from tab;
select * from customer;

--- count(*) 함수를 이용해서 총 데이터 개수를 구할 수 있음
select count(*) from CUSTOMER;

--- seq으로 sequence 목록 출력
select * from seq;


-- 임시 테이블 삭제(리사이클 빈에 있는 모든 객체를 영구적으로 삭제)
--- 삭제된 객체(테이블, 뷰, 인덱스 등)를 
--- 임시로 보관하는 리사이클 빈(Recycle Bin)이라는 메커니즘을 제공
purge recyclebin;


-- CREATE TABLE 테이블명 문으로 테이블 생성
-- 예1. customer테이블
--- primary key(기본키): 반드시 중복되지 않는 값을 저장해야 한다는 의미(열(column)의 값이 각 행(row)마다 유일)
create table customer( no number(4)  primary key, 
		       		   name varchar2(20),
		       		   email varchar2(20),
		       		   tel varchar2(20));

		       		   
-- ALTER TABLE문 : 기존 테이블의 구조 수정
-- ALTER TABLE 테이블명 ADD (컬럼명 데이터타입); : 해당 테이블에 새로운 열을 추가
--- customer테이블에 address라는 새로운 열 추가. 데이터타입은 varchar2(50)
alter table customer add(address varchar2(50));

--- customer테이블에 reg_date"라는 새로운 열 추가. 데이터 타입은 "timestamp"로 지정
alter table customer add(reg_date timestamp);
		--- timestamp 데이터타입: 날짜와 시간정보를 저장하는 데 사용


-- CREATE SEQUENCE 시퀀스명 START WITH N INCREASE BY M
--	: N부터 시작하여 M씩 증가하는 시퀀스 생성
	-- 시퀀스(sequence): 번호를 자동적으로 증가하는 고유한 숫자를 생성할 때 사용되는 객체

-- 1부터 1씩 증가하는 customer_no_seq 시퀀스 생성
create sequence customer_no_seq
	start with 1
	increment by 1;		       		   

	

-- 예4. member테이블
-- SELECT FROM 문으로 테이블 출력
select * from MEMBER;
	
-- CREATE TABLE 테이블명 문으로 테이블 생성
create table member(name varchar2(20),
		    gender varchar2(10),
		    jumin1 varchar2(6),
            jumin2 varchar2(7),
		    address varchar2(100),
		    buseo  varchar2(20),
            sports varchar2(20),
            music varchar2(20),
            movie varchar2(20),
		    computer varchar2(20),
		    intro varchar2(1000)
		  );

		  
-- 예5. mem02 테이블
-- SELECT FROM 문으로 테이블 출력
select * from MEM02;
	
-- CREATE TABLE 테이블명 문으로 테이블 생성
create  table  mem02(id  varchar2(20)  primary key,
		  			 passwd  varchar2(20),
		  			 name  varchar2(20),
		  			 reg_date  date);

		  			 
-- 게시판
-- SELECT FROM 문으로 테이블 출력
select * from board;
--- seq으로 sequence 목록 출력
select * from seq;
--- tab으로 테이블 목록 출력
select * from tab;


-- CREATE TABLE 테이블명 문으로 테이블 생성
	-- 게시판은 번호값 저장하는 필드를 primary key로 설정
	-- 회원관리 프로그램은 회원번호를 primary key로 설정
--- primary key(기본키): 반드시 중복되지 않는 값을 저장해야 한다는 의미(열(column)의 값이 각 행(row)마다 유일)
--- not null : null 값을 허용하지 않는다. (즉, 반드시 입력해야 한다는 의미)
create table board(
	no number primary key,
	writer varchar2(20) not null,
    passwd varchar2(20) not null,
	subject varchar2(100) not null,
	content varchar2(1000) not null,
	reg_date timestamp );
		  			 
-- CREATE SEQUENCE 시퀀스명 START WITH N INCREASE BY M
--	: N부터 시작하여 M씩 증가하는 시퀀스 생성
	-- 시퀀스(sequence): 번호를 자동적으로 증가하는 고유한 숫자를 생성할 때 사용되는 객체
-- 1부터 1씩 증가하는 board_seq 시퀀스 생성	  			 
create sequence board_seq
		start with 1
		increment by 1;		  			 
		  			 
		  			 
		  			 
		  			 
		  			 
		  			 
		  			 
		  			 
		  			 
		  			 
		  			 
