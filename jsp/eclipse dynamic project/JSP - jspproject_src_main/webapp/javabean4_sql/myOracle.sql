-- javaBean예제_DAO와 Oracle DB연동

-- 생성하려는 member2테이블이 존재하는 지 확인
select * from tab;
select * from member2;

-- member2 테이블 생성
create  table  member2( 
            id varchar2(12) primary key,
            passwd varchar2(12) not null,
            name varchar2(10) not null,
            jumin1 varchar2(6) not null,
            jumin2 varchar2(7) not null,
            email varchar2(30),
            blog varchar2(50),
            reg_date date not null);