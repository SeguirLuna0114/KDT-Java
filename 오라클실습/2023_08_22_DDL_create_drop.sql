-- 2018. 08. 22(ȭ)

-- DDL(Data Definition Language) : ������ ���Ǿ�
    -- create : ���̺� ����
    -- alter : ���̺� ���� ����
    -- rename : ���̺� �̸� ����
    -- drop: ���̺� ����
    -- truncate : ������ ����
    
-- ���̺� ���
SELECT * FROM tab;
SELECT * FROM user_tables;

-- 1. CREATE
--  : �����ͺ��̽� ����, ���̺� ����

-- ���� : create table ���̺�� ( �÷���1   ������Ÿ��1,
--                              �÷���2   ������Ÿ��2,
--                              �÷���N   ������Ÿ��N);

--* ���̺��,�÷��� ��� ��Ģ
--1. �ݵ�� ���ڷ� ���� �ؾ���.
--2. 1~30�� ���� ������.
--3. A~Z������ ��ҹ��ڿ� 0~9������ ����, 
--   Ư����ȣ�� (_, $, #)�� ������ �� ����.
--4. ����Ŭ���� ���Ǵ� ���� �ٸ� ��ü��� �ߺ��Ұ�
--5. ������� �ȵ�.

-- ����Ŭ�� ������ Ÿ��
-- 1) ���� ������
--      number(n): ���� n�ڸ����� ����
--      number(n1, n2): n1: ��ü�ڸ���, n2: �Ҽ��� ���Ͽ� �Ҵ�� �ڸ���

-- 2) ���� ������
--      char(): ���� ���� ������
--              �ִ� 2000byte���� ���� ����
--      varchar2(): ���� ���� ������
--                  �ִ� 4000byte���� ���� ����
--       long: 2GB���� ���� ����
--              long������ ������ �÷��� �˻� ����� �������� ����

-- 3) ��¥ ������
--      date : ��/��/�� ��������
--      timestamp : ��/��/�� ��:��:�� ���� ����

-- ���̺� ����
-- 1) ���� ���̺� ���� with CREATE TABLE ���
CREATE TABLE emp01 ( empno NUMBER(4),
                     ename varchar2(20),
                     sal NUMBER(7, 2));

-- ������ ���̺� ��� Ȯ��
SELECT * FROM emp01;
DESCRIBE emp01;


-- 2) ���������� ���̺� ����
--      ���纻 ���̺��� ������
--      ���������� ���簡 ���� ����

-- ���纻 ���̺� ����
CREATE TABLE emp02 AS SELECT * FROM emp;

-- ���̺� ��� Ȯ��
SELECT * FROM emp02;
desc emp02;

-- ���ϴ� �÷����� ������ ���纻 ���̺� ����
CREATE TABLE emp03 AS SELECT empno, ename FROM emp;

-- ���̺� ��� Ȯ��
SELECT * FROM emp03;
desc emp03;

-- ���ϴ� ��(row, ������)���� ������ ���纻 ���̺� ����
CREATE TABLE emp04 AS SELECT * FROM emp WHERE deptno=10;

-- ���̺� ��� Ȯ��
SELECT * FROM emp04;
desc emp04;

-- ���̺� ������ ����
CREATE TABLE emp05 AS SELECT * FROM emp WHERE 1=0;
-- ���̺� ��� Ȯ��
SELECT * FROM emp05;
desc emp05;


-- 2. ALTER
--   : ���̺� ���� ����(�÷� �߰�, �÷� ����, �÷� ����)

--  1) �÷� �߰�: emp01 ���̺� job�÷� �߰�
ALTER TABLE emp01 ADD(job VARCHAR2(10));
desc emp01;
SELECT * FROM emp01;

-- 2) �÷� ����
--      i) ������ �÷��� �����Ͱ� ���� ���
--         �÷��� ������ Ÿ���� ������ �� ����
--         �÷��� ũ�⸦ ������ �� ����
--      ii) ������ �÷��� �����Ͱ� �ִ� ���
--          �÷��� ������ Ÿ���� ������ �� ����
--          �÷��� ũ��� �ø� �� ������, ���� ����� ũ�⺸�� ���� ũ�Ⱚ���� ����X

-- emp01���̺��� job�÷��� ũ�⸦ 10���� 30���� ����
ALTER TABLE emp01 modify(job varchar2(30));
desc emp01;

-- 3) �÷� ����
ALTER TABLE emp01 DROP COLUMN job;
ALTER TABLE emp01 DROP(job);

desc emp01;
SELECT * FROM emp01;


-- 3. rename
--    : ���̺� �̸� ����
-- ���� : rename old_name to new_name;

-- Q. EMP01���̺��� TEST���̺������ �̸� ����
RENAME emp01 TO test;
SELECT * FROM tab;


-- 4. TRUNCATE
--   : ���̺� ��� �����͸� ����
-- ���� : truncate table table_name;      --(where�������� ��� ��� ������ ����)
TRUNCATE TABLE emp02;
SELECT * FROM emp02;


-- 5. DROP
--    : ���̺� ����(���̺��� �����Ǹ�, ���̺� �� ��� �����͵� ������)
-- ���� : drop table table_name;      (Oracle 10q���ʹ� �ӽ� ���̺�� ��ü��)
--       drop table table_name purge;       (�����ϰ� ������)

-- Q. test���̺� ����
DROP TABLE test;
SELECT * FROM tab;          -- test���̺��� �ӽ����̺�(BIN$l2SQ0GloQhmW2TIuhyADFA==$0)�� ��ü��

-- �ӽ� ���̺� ����
PURGE RECYCLEBIN;
SELECT * FROM tab;

