--join_member.sql
select * from tab;
select * from seq;

create table join_member(
  	join_code number(38) unique not null 
  , join_id varchar2(20) primary key 
  , join_pwd varchar2(20) not null
  , join_name varchar2(50) not null 
  , join_zip varchar2(5) not null 
  , join_addr1 varchar2(100) not null 
  , join_addr2 varchar2(100) not null 
  , join_tel varchar2(20) not null 
  , join_phone varchar2(20) not null 
  , join_email varchar2(100) not null 
  , join_profile varchar2(100) 
  , join_regdate date 
  , join_state number(10) 
  , join_delcont varchar2(4000)
  , join_deldate date 
);

create sequence join_member_joincode_seq 
increment by 1 start with 1 nocache;

insert into join_member (join_code,join_id,join_pwd,join_name,join_zip,
		join_addr1,join_addr2,join_tel,join_phone,join_email,join_regdate,join_state)
	values(join_member_joincode_seq.nextval,'aaaaa',
		'77777','홍길동','74585','서울시 마포구 대흥동','주소2',
		'02-7777-7777','010-9999-9999','hong@naver.com',sysdate,1);

select * from join_member;


