-- 2023. 08. 23(��)

-- ���� ���� ���� ���
--1. �÷����� ������� �������� ����
--2. ���̺��� ������� �������� ����
    -- ���� ������ �����Ҷ� ���̺� ���� ��ĸ� ������ ���
    --1. �⺻Ű�� ����Ű�� ����ϴ� ���(�⺻Ű ���������� 2�� �̻� �����ϴ� ��)
    --2. alter table ������� ���������� �߰��� ���

--1. �÷����� ������� �������� ����
DROP TABLE emp01 PURGE;

CREATE TABLE emp01( empno NUMBER(4) PRIMARY KEY,
                    ename VARCHAR2(15) NOT NULL,
                    job VARCHAR2(10) UNIQUE,
                    deptno NUMBER(4) REFERENCES dept(deptno) );

--2. ���̺��� ������� �������� ����
DROP TABLE emp02 PURGE;

CREATE TABLE emp02( empno NUMBER(4),
                    ename VARCHAR2(15) NOT NULL,--not null���������� �÷����� ��ĸ� ������
                    job VARCHAR2(10),
                    deptno NUMBER(4),
                    PRIMARY KEY(empno),
                    UNIQUE(job),
                    FOREIGN KEY(deptno) REFERENCES dept(deptno) );
    
    
-- ���� ������ �����Ҷ� ���̺� ���� ��ĸ� ������ ���
--1. �⺻Ű�� ����Ű�� ����ϴ� ���(�⺻Ű ���������� 2�� �̻� �����ϴ� ��)
--2. alter table ������� ���������� �߰��� ���

--1. 2�� �̻��� �÷��� �⺻Ű�� ����
DROP TABLE member01 PURGE;

--1) �÷����� ������� 2���� �÷��� primary key�� ����
CREATE TABLE member01(  id VARCHAR2(20) PRIMARY KEY,
                        passwd VARCHAR2(20) PRIMARY KEY );  -- �����߻�
                        -- ORA-02260: table can have only one primary key

--2) ���̺��� ������� 2���� �÷��� primary key�� ����
CREATE TABLE member01(  id VARCHAR2(20),
                        passwd VARCHAR2(20),
                        PRIMARY KEY(id, passwd) );
    
--2. alter table ������� ���������� �߰��ϴ� ���
DROP TABLE emp01 PURGE;

-- ���������� ���� ���̺� ����
CREATE TABLE emp01( empno NUMBER(4),        -- primary key
                    ename VARCHAR2(15),     -- not null
                    job VARCHAR2(10),       -- unique
                    deptno NUMBER(2));      -- foreign key
    
-- primary key �������� �߰� : empno
ALTER TABLE emp01 ADD PRIMARY KEY(empno);

-- not null �������� �߰� : ename
ALTER TABLE emp01 MODIFY ename NOT NULL;

-- unique �������� �߰� : job
ALTER TABLE emp01 ADD UNIQUE(job);

-- foreign key �������� �߰� : deptno
ALTER TABLE emp01 ADD FOREIGN KEY(deptno) REFERENCES dept(deptno);


-- �������� ����
-- ���� : alter table ���̺�� drop constraint constraint_name;

-- primary key �������� ����
ALTER TABLE emp01 DROP  CONSTRAINT SYS_C007054;     
ALTER TABLE emp01 DROP PRIMARY KEY;                 

-- not null �������� ����
ALTER TABLE emp01 DROP  CONSTRAINT SYS_C007053;

-- unique �������� ����
ALTER TABLE emp01 DROP  CONSTRAINT SYS_C007055;
ALTER TABLE emp01 DROP UNIQUE(job);

-- foreign key �������� ����
ALTER TABLE emp01 DROP CONSTRAINT SYS_C007056;

