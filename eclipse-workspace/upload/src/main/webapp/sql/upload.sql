-- 자료실(파일 업로드)

-- 테이블 확인
select * from tab;
select * from upload;

delete from UPLOAD;

-- 업로드 테이블 생성
create table upload( 
	num number,
    writer varchar2(20) not null,
	email varchar2(30),
    subject varchar2(50) not null,
    passwd varchar2(20) not null,
	reg_date timestamp not null,
	readcount number default 0,	    
	content varchar2(2000) not null,
	ip varchar2(20) not null,
	upload varchar2(30),
	constraint upload_pk primary key(num) );


	
-- sequence 목록 보기
select * from seq; 


-- 시퀀스 생성
create sequence upload_seq increment by 1 
				 		   start with 1
			    		   nocycle;
			    		   


-- sequence 삭제
drop sequence upload_seq;