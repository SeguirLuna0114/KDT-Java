-- DB연동 예제

-- 생성하려는 member1테이블이 존재하는 지 확인
select * from tab;
select * from member1;

-- member1테이블 생성
create  table  member1( 
		id varchar2(20) primary key,
	    passwd varchar2(20) not null,
		name varchar2(20) not null,	
		reg_date timestamp not null );