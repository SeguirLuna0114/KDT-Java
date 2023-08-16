-- 데이터베이스 목록 출력
show databases;
-- 테이블 목록 출력 (해당 데이터베이스 내의 테이블 목록 출력)
show tables;


-- 예1. 회원관리
-- SELECT * FROM 테이블명 문으로 테이블 전체 레코드 출력
select * from customer;


-- CREATE TABLE 테이블명 문으로 테이블 생성
	-- primary key(기본키): 반드시 중복되지 않는 값을 저장해야 한다는 의미(열(column)의 값이 각 행(row)마다 유일)
	-- auto_increment: 1부터 1씩 증가된 값을 자동으로 입력한다는 의미(주로 숫자형 컬럼에서 사용)
	--					데이터 삽입 시, 값을 지정하지 않아도 됨. 레코드 식별에 사용				
	-- timestamp 데이터타입: 날짜와 시간정보를 저장하는 데 사용
create table customer( 	no int(4) auto_increment  primary key, 
		       		   	name varchar(20),
		       		   	email varchar(20),
		       		   	tel varchar(20),
						address varchar(50),
						reg_date timestamp);
												
-- INSERT INTO 테이블명 VALUES 데이터 : 데이터 입력
	-- sysdate(): 데이터베이스 시스템의 현재 날짜와 시간을 가져오는 함수						
insert into customer (name, email, tel, address, reg_date)
	values('안화수', 'test@gmail.com', '333-3333', '서울시 강남구', sysdate());


	
-- 예2. 게시판
-- 데이터베이스 출력
show databases;
--- 테이블 목록 출력
show tables;

-- DESC(DESCRIBE) 테이블명 : 테이블 구조(스키마) 확인
describe board;
desc board;

-- DROP TABLE 테이블명 : 테이블 삭제
drop table board;

-- SELECT FROM 문으로 테이블 출력
select * from board;

-- CREATE TABLE 테이블명 문으로 테이블 생성
	-- 게시판은 번호값 저장하는 필드를 primary key로 설정
	-- 회원관리 프로그램은 회원번호를 primary key로 설정
	-- primary key(기본키): 반드시 중복되지 않는 값을 저장해야 한다는 의미(열(column)의 값이 각 행(row)마다 유일)
	-- not null : null 값을 허용하지 않는다. (즉, 반드시 입력해야 한다는 의미)
	
	-- auto_increment: 1부터 1씩 증가된 값을 자동으로 입력한다는 의미(주로 숫자형 컬럼에서 사용)
		--					데이터 삽입 시, 값을 지정하지 않아도 됨. 레코드 식별에 사용
	-- timestamp 데이터타입: 날짜와 시간정보를 저장하는 데 사용
create table board(
	no int auto_increment  primary key,
	writer varchar(20) not null,
    passwd varchar(20) not null,
	subject varchar(100) not null,
	content varchar(1000) not null,
	reg_date timestamp );	
	-- INT 데이터 타입은 이미 고정된 크기를 가지는 정수 타입이기 때문에 별도로 크기를 지정하지 않아도 됨

	
-- * 1) 데이터 입력
-- INSERT INTO 테이블명 VALUES 데이터 : 데이터 입력
	-- sysdate(): 데이터베이스 시스템의 현재 날짜와 시간을 가져오는 함수						
insert into board (writer, passwd, subject, content, reg_date)
	values('홍길동', '1234', '게시판 연습', '게시판 내용', now());
	-- now(): MySQL 함수로, 데이터베이스 시스템의 현재 날짜와 시간을 가져옴
			-- sysdate()와 유사한 기능을 수행

	
-- * 2) 총 데이터 갯수 구하기
select count(*) from board;

-- * 3) 전체 데이터 검색
select * from board;

-- * 4) 전체 데이터를 내림차순 정렬(최근글 순으로 정렬)
--		오름차순(ASC)			내림차순(DESC)
-----------------------------------------------------------
-- 숫자: 1, 2, 3, ...				10, 9, 8, ....
-- 문자: 사전순 정렬(a, b, c...)		사전역순 정렬(z, y, x,...)
select * from board order by no desc;


--	LIMIT 연산자 사용: LIMIT 추출할 인덱스 시작번호, 추출할 데이터(행) 갯수
-- * 5) 최근글 5개 검색
select * from board order by no desc LIMIT 0, 5;
-- 테이블의 가장 마지막 데이터 5개 추출
	-- order by [컬럼명] ASC/DESC 연산자로 정렬한 후 출력 가능
		-- desc로 정렬한 후 limit으로 범위를 지정하면 가장 마지막 데이터가 출력됨


-- * 6) 3~5번째 데이터 추출
select * from board order by no desc LIMIT 2, 3;














