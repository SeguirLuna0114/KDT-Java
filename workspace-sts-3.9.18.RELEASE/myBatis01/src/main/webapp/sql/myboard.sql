-- 테이블 생성
select * from tab;
select * from boardtest;
drop table boardtest purge;

create table boardtest(
	no number primary key,
	name varchar2(20),
	subject varchar2(50),
	content varchar2(1000),
	register date
);


-- 시퀀스
select * from seq;

create sequence boardtest_seq;
