-- 게시판

-- 테이블 조회
select * from tab;
select * from board;

-- 총 데이터 개수 조회
select count(*) from board;

-- board 테이블 생성
-- 일반 게시판
create table board( 
	num number primary key,
    writer varchar2(20) not null,
	email varchar2(30),
    subject varchar2(50) not null,
    passwd varchar2(20) not null,
	reg_date timestamp not null,
	readcount number default 0,			
	content varchar2(2000) not null,
    ip varchar2(20) not null 	);
    
    
-- 데이터 입력
insert into board values(board_seq.nextval, '홍길동', 'test@naver.com',
	'게시판 제목', '1234', sysdate, 0, '게시판 내용', '222.183.0.1');


-- 시퀀스 조회
select * from seq;

-- 시퀀스 생성
create sequence board_seq
	start with 1
	increment by 1
	nocache;
	