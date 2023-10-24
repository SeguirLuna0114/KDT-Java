-- 모델2로 구현한 게시판

-- 테이블 확인
select * from tab;
select * from model2board;

-- 데이터 갯수 확인
select count(*) from MODEL2BOARD;

-- 강제 insert
insert into model2board values(model2board_seq.nextval, '홍길동',
	'1234', '게시판 연습', '내용', '', model2board_seq.nextval, 0, 0, 0, sysdate);

-- model2board 테이블 생성
create table model2board (
	board_num number,
	board_name varchar2(20),
	board_pass varchar2(15),
	board_subject varchar2(50),
	board_content varchar2(2000),
	board_file varchar2(50),
	board_re_ref number,
	board_re_lev number,
	board_re_seq number,
	board_readcount number,
	board_date timestamp,
	primary key(board_num)
);


-- 시퀀스 확인
select * from seq;

-- 시퀀스 생성
create sequence model2board_seq
	start with 1
	increment by 1
	nocache;
	
	
	