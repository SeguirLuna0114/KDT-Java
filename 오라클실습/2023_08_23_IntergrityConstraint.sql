-- 2023. 08. 23(��)

-- ���Ἲ ��������(Intergrity Constraint)
-- : ���̺� �������� �����Ͱ� �ԷµǴ� ���� ���� ���� ���̺� ������
--   �� �÷��� ���� �����ϴ� ���� ��Ģ�� �ǹ�
--      ex) not null, unique, primary key(�⺻Ű), foreign key(�ܷ�Ű), check, default

-- 1. NOT NULL ��������
--    : Ư�� ���� ��(Null) ���� ���� �� ������ �����ϴ� ��Ģ
--      Null���� �ƹ��� ���� ������ ������ ��Ÿ���⿡, "�ݵ�� ���� �Է��ؾ� ��"

DROP TABLE emp02 PURGE;

-- emp02 ���̺� ����
CREATE TABLE emp02( empno NUMBER(4) NOT NULL,
                    ename VARCHAR2(12) NOT NULL,
                    job VARCHAR2(12),
                    detpno NUMBER(2)    );

-- ���̺� Ȯ��
SELECT * FROM tab;
SELECT * FROM emp02;

-- �������ǿ� ������� �ʴ� ������ �Է�
INSERT INTO emp02 VALUES(1111, 'ȫ�浿', 'MANAGER', 30);

-- ��������(NOT NULL)�� ����Ǳ� ������ ������ �Է��� ���� ����
    -- ��������� NULL���� �����Ϸ� �õ�
INSERT INTO emp02 VALUES(NULL, NULL, 'SALESMAN', 30);   -- cannot insert NULL into
    -- empno�� ename ���� �����ϰ� �����Ϸ� �õ�
INSERT INTO emp02(job, deptno) VALUES('SALESMAN', 30);  -- "DEPTNO": invalid identifier


-- 2. UNIQUE ��������
--    : Ư�� ��(�Ǵ� ����)���� ������ ���� �Է��� �� �ִ�.
--      �ߺ��� ���� �Է��� �� ����.
--      ��, �⺻Ű�� �޸� ��(Null)���� �����

DROP TABLE emp03 PURGE;
-- emp03 ���̺� ����
CREATE TABLE emp03( empno NUMBER(4) UNIQUE,
                    ename VARCHAR2(12) NOT NULL,
                    job VARCHAR2(12),
                    detpno NUMBER(2)    );
-- ���̺� Ȯ��
SELECT * FROM tab;
SELECT * FROM emp03;                    

-- �������ǿ� ������� �ʴ� ������ �Է�
INSERT INTO emp03 VALUES(1111, 'ȫ�浿', '������', 10);

-- UNIQUE �������ǿ� ����Ǳ� ������ ������ �Է��� ���� ����
INSERT INTO emp03 VALUES(1111, 'ȫ�浿', '������', 20);   -- unique constraint

-- UNIQUE ���������� NULL�� �Է��� ����
INSERT INTO emp03 VALUES(NULL, 'ȫ�浿', '������', 20);
INSERT INTO emp03 VALUES(NULL, '��ȭ��', '������', 30);


-- 3. PRIMARY KEY(�⺻Ű) ��������
--    Primary Key = Not Null + Unique
--    : �ݵ�� �ߺ����� �ʴ� ���� �����ؾ� ��
--    ex)   �μ� ���̺�(DEPT) - deptno(pk)
--          ��� ���̺�(EMP)  - empno(pk)
--          �Խ���(Board)    - ��ȣ(no)  : pk
--          ȸ������(member)  - ���̵�(id) : pk

-- �μ����̺�(DEPT) - deptno(pk)
SELECT * FROM dept;
    -- UNIQUE �������ǿ� ����
INSERT INTO dept VALUES(10, '���ߺ�', '����');       -- unique constraint
    -- NOT NULL �������ǿ� ����
INSERT INTO dept VALUES(NULL, '���ߺ�', '����');     -- cannot insert NULL into

-- ������̺�(EMP) - empno(pk)
SELECT * FROM emp;
    -- UNIQUE �������ǿ� ����
INSERT INTO emp(empno, ename) VALUES(7788, 'ȫ�浿');       -- unique constraint
    -- NOT NULL �������ǿ� ����
INSERT INTO emp(empno, ename) VALUES(NULL, 'ȫ�浿');    -- cannot insert NULL into


-- emp05���̺� ����
DROP TABLE emp05 PURGE;
CREATE TABLE emp05( empno NUMBER(4) PRIMARY KEY,    -- �ݵ�� �ߺ����� �ʴ� �� �Է�
                    ename VARCHAR2(12) NOT NULL,    -- �ݵ�� �� �Է�
                    job VARCHAR2(12),
                    detpno NUMBER(2)    );

-- ���̺� Ȯ��
SELECT * FROM tab;
SELECT * FROM emp05;                    

-- �������ǿ� ������� �ʴ� �������� ������ �Է�
INSERT INTO emp05 VALUES(1111, 'ȫ�浿', '������', 20);

-- �ߺ� �����ʹ� PRIMARY KEY �������ǿ� ����Ǳ� ������ ������ �Է��� ���� ����
INSERT INTO emp05 VALUES(1111, 'ȫ�浿', '������', 20);   -- unique constraint

-- PRIMARY KEY ���������� NULL�� �Է��� �Ұ���
INSERT INTO emp05 VALUES(NULL, 'ȫ�浿', '������', 20);   -- cannot insert NULL into


-- 4. �������� �̸�(constraint name)�� �����ؼ� ���̺� ����
DROP TABLE emp04 PURGE;
-- emp04���̺� ����
CREATE TABLE emp04( empno NUMBER(4) CONSTRAINT emp04_empno_uk UNIQUE,
                    ename VARCHAR2(10) CONSTRAINT emp04_ename_nn NOT NULL,
                    job VARCHAR2(10),
                    detpno NUMBER(2)    );

-- ���̺� Ȯ��
SELECT * FROM tab;
SELECT * FROM emp04; 
desc emp04;


--4. foreign key (�ܷ�Ű) ��������
--  DEPT(�θ����̺�) - deptno(pk) : �θ�Ű : 10, 20, 30, 40
--  EMP(�ڽ����̺�)  - deptno(fk) : �ܷ�Ű : 10, 20, 30

--1) ������̺�(EMP)�� deptno �÷��� foreign key ���������� �����Ǿ� �ִ�.
--2) foreign key ���������� ������ �ִ� �ǹ̴� �θ����̺�(DEPT)�� 
--   �θ�Ű(deptno)�� ���� ������ �� �ִ�.
--3) �θ�Ű�� �Ǳ� ���� ������ primary key�� unique ������������ �����Ǿ�
--   �־�� �Ѵ�.
 
--Q. ������̺�(EMP)�� ���ο� ���Ի���� ��� �غ���?
-- �ܷ�Ű(deptno)�� �θ�Ű(DEPT-deptno)�ȿ� �ִ°�(10,20,30,40)�� �����Ҽ� �ִ�.
INSERT INTO emp(empno, deptno) VALUES(1111,50); --foreign key�������� ����(parent key not found)

-- emp06���̺� ����
DROP TABLE emp06 PURGE;
CREATE TABLE emp06( empno NUMBER(4) PRIMARY KEY,
                    ename VARCHAR2(10) NOT NULL,
                    job VARCHAR2(10),
                    detpno NUMBER(2) REFERENCES dept(deptno) );
                    
-- ���̺� Ȯ��
SELECT * FROM tab;
SELECT * FROM emp06; 
desc emp06;

-- �������ǿ� ������� �ʴ� �������� ������ �Է�
INSERT INTO emp06 VALUES(1111,'ȫ�浿','������',10);
INSERT INTO emp06 VALUES(1112,'ȫ�浿','������',20);
INSERT INTO emp06 VALUES(1113,'ȫ�浿','������',30);
INSERT INTO emp06 VALUES(1114,'ȫ�浿','������',40);    

-- FOREIGN KEY �������ǿ� ����Ǳ� ������ ������ �Է��� ���� ����
-- 50�� �μ��� �θ�Ű���� ������ �� ���� ���̱� ������, �ܷ�Ű �������ǿ� ����
-- �Ǿ ����� �� ����.
INSERT INTO emp06 VALUES(1115,'ȫ�浿','������',50);  --foreign key�������� ����(parent key not found)


-- 5. CHECK ��������
-- : �����Ͱ� �Էµɶ� Ư�� ������ �����ϴ� �����͸� �Էµǵ��� ����� �ִ�
--   �������� �̴�.

-- �޿�(SAL) : 500 ~ 5000
-- ����(gender) : M or F
-- emp07���̺� ����
DROP TABLE emp07 PURGE;
CREATE TABLE emp07( empno NUMBER(4) PRIMARY KEY,
                    ename VARCHAR2(10) NOT NULL,
                    sal NUMBER(7, 2) CHECK(sal BETWEEN 500 AND 5000),
                    gender VARCHAR2(1) CHECK(gender IN('M','F')) );

-- ���̺� Ȯ��
SELECT * FROM tab;
SELECT * FROM emp07; 
desc emp07;

-- �������ǿ� ������� �ʴ� �������� ������ �Է�
INSERT INTO emp07 VALUES(1111,'ȫ�浿',3000,'M');
-- CHECK �������ǿ� ����Ǳ� ������ ������ �Է��� ���� ����
INSERT INTO emp07 VALUES(1112,'ȫ�浿',8000,'M');      --check constraint
INSERT INTO emp07 VALUES(1113,'ȫ�浿',5000,'m');      --check constraint


--6. DEFAULT ��������
-- : default ���������� ������ �÷��� ���� �Էµ��� ������, default�� ������
--    ���� �ڵ����� �Էµȴ�.
-- dept01���̺� ����
DROP TABLE dept01 PURGE;
CREATE TABLE dept01(    deptno NUMBER(2) PRIMARY KEY,
                        dname VARCHAR2(14),
                        loc VARCHAR2(13) DEFAULT 'SEOUL' );

-- ���̺� Ȯ��
SELECT * FROM tab;
SELECT * FROM dept01; 
desc dept01;

-- �������ǿ� ������� �ʴ� �������� ������ �Է�
INSERT INTO dept01 VALUES(10,'ACCOUNTING','NEW YORK');
INSERT INTO dept01(deptno, dname) VALUES(20,'RESEARCH');