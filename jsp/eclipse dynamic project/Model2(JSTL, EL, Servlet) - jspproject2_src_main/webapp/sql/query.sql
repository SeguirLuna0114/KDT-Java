-- servlet(서블릿)

-- 테이블 확인
select * from tab;
select * from query;

select * from test;


-- QueryString.java파일 예제
-- query테이블 생성
	-- 제약조건 설정하지 X
create table query(
	id varchar2(20),
	pw varchar2(20),
	name varchar2(20),
	vclass varchar2(20),
	phone varchar2(30)	);
	

-- jstl_sql_ex.jsp파일 예제
-- connect totoro/totoro123
-- test 테이블 생성
	-- primary제약조건을 설정하면, 1번만 생성 가능함
create table test(
	num number,
	name varchar2(10)	);
	
	