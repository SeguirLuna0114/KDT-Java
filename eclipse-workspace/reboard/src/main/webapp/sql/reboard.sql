-- 댓글 게시판

-- 테이블 조회
select * from tab;
select * from board;

-- board 테이블 생성
-- 댓글 게시판 테이블
create table board( 
	num number,
    writer varchar2(20) not null,
	email varchar2(30),
    subject varchar2(50) not null,
    passwd varchar2(20) not null,
	reg_date timestamp not null,
	readcount number default 0,
	ref number not null,
	re_step number not null,
	re_level number not null,
	content varchar2(2000) not null,
	ip varchar2(20) not null,
	constraint board_pk primary key(num) );


-- 시퀀스 목록 보기
select * from seq; 

-- 시퀀스 삭제
drop sequence board_seq;

-- 시퀀스 생성
create sequence board_seq 
	start with 1
	increment by 1
	nocache;
