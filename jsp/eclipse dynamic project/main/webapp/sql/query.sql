-- servlet(서블릿)

-- 테이블 확인
select * from tab;
select * from query;


-- QueryString.java파일 예제
-- query테이블 생성
	-- 제약조건 설정하지 X
create table query(
	id varchar2(20),
	pw varchar2(20),
	name varchar2(20),
	vclass varchar2(20),
	phone varchar2(30)	);