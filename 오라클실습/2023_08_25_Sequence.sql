-- 2023. 08. 25(��)

-- commit [F11]
-- rollback [F12]

-- ������(sequence)
-- : ���̺� ���ڸ� �ڵ����� ���� �����ִ� ������ �Ѵ�.

-- ������ ����
CREATE SEQUENCE dept_deptno_seq
START WITH 10           -- ������ ��ȣ��
INCREMENT BY 10;        -- ����ġ

-- ������ ��� 
SELECT * FROM seq;
SELECT * FROM user_sequences;

-- currval : ������ ���簪�� ��ȯ
-- nextval : ������ �������� ��ȯ

SELECT dept_deptno_seq.nextval from dual;
SELECT dept_deptno_seq.currval from dual;

-- ��1. �������� ���̺��� �⺻Ű�� ����
DROP TABLE emp01 PURGE;
CREATE TABLE emp01 ( 
    empno NUMBER(4) PRIMARY KEY,
    ename VARCHAR2(10),
    hiredate DATE );
-- ���̺� ��� Ȯ��
SELECT * FROM tab;      -- ���̺� ���

-- 1���� 1�� �����Ǵ� ������ ����
CREATE SEQUENCE emp01_empno_seq;
-- ������ ��� Ȯ��
SELECT * FROM seq;      -- ������ ���

-- ������ �Է�
INSERT INTO emp01 VALUES(emp01_empno_seq.nextval, 'ȫ�浿', sysdate);
-- ���̺� ������ Ȯ��
SELECT * FROM emp01;


-- ��2. 
-- ���̺� ����
CREATE TABLE dept_example ( 
    deptno NUMBER(2) PRIMARY KEY,
    edame VARCHAR2(15),
    loc VARCHAR2(15) );
-- ���̺� ��� Ȯ��
SELECT * FROM tab;      -- ���̺� ���

-- ������ ����
CREATE SEQUENCE dept_example_seq
START WITH 10           -- ������ ��ȣ��
INCREMENT BY 10;        -- ����ġ
-- ������ ��� Ȯ��
SELECT * FROM seq;      -- ������ ���

-- ������ �Է�
INSERT INTO dept_example VALUES(dept_example_seq.nextval, '�λ��', '����');
INSERT INTO dept_example VALUES(dept_example_seq.nextval, '�渮��', '����');
INSERT INTO dept_example VALUES(dept_example_seq.nextval, '�ѹ���', '����');
INSERT INTO dept_example VALUES(dept_example_seq.nextval, '�����', '����');
-- ���̺� ������ Ȯ��
SELECT * FROM dept_example;

-- ������ ����
DROP SEQUENCE dept_example_seq; 
-- ������ ��� Ȯ��
SELECT * FROM seq;      -- ������ ��Ͽ��� �������� Ȯ��

-- �������� �ִ밪�� ����
-- ���� ������ ����
DROP SEQUENCE dept_deptno_seq;
-- ������ ����
CREATE SEQUENCE dept_deptno_seq
START WITH 10       -- ���۰�
INCREMENT BY 10     -- ����ġ
MAXVALUE 30;        -- �ִ밪
-- ������ ��� Ȯ��
SELECT * FROM seq; 

-- ������ ������ ���ؿ���
SELECT dept_deptno_seq.nextval FROM dual;   -- 10
SELECT dept_deptno_seq.nextval FROM dual;   -- 20
SELECT dept_deptno_seq.nextval FROM dual;   -- 30
SELECT dept_deptno_seq.nextval FROM dual;   -- �����߻�

-- �������� MAXVALUE�� ����
ALTER SEQUENCE dept_deptno_seq MAXVALUE 100000;

-- �������� ���� �� ���ؿ���
SELECT dept_deptno_seq.nextval FROM dual;   -- 40

