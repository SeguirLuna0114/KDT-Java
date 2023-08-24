-- 2023. 08. 24(��)

-- ���������� Ȱ��ȭ / ��Ȱ��ȭ

-- Q. �θ����̺�(DEPT)�� �����͸� ����
-- 1) �ڽ����̺�(EMP)���� �θ�Ű(deptno)�� �����ϴ� �ܷ�Ű�� �ֱ� ������
--    �θ� ���̺��� �����͸� ������ �� ����
DELETE FROM dept WHERE deptno = 40;         -- integrity constraint_child record found
-- 2) �θ� ���̺��� ������ ������ ���ؼ��� �����ϴ� �ڽ� ���̺��� �ܷ�Ű�� ��Ȱ��ȭ ���Ѽ�
--    �θ� ���̺��� ������ ���� ����    

-- 1. �θ� ���̺� ����
DROP TABLE dept01 PURGE;
CREATE TABLE dept01 (   deptno NUMBER(2) PRIMARY KEY,
                        dname VARCHAR2(14),
                        loc VARCHAR2(13)    );
-- ���̺� Ȯ��
SELECT * FROM dept01;                       
-- ������ ����
INSERT INTO dept01 VALUES (10, 'ACCOUNTING', 'NEW YORK');

-- 2. �ڽ� ���̺� ����
DROP TABLE emp01 PURGE;
CREATE TABLE emp01( empno NUMBER(4) PRIMARY KEY,
                    ename VARCHAR2(10) NOT NULL,
                    job VARCHAR2(10) UNIQUE,
                    deptno NUMBER(2) REFERENCES dept01(deptno)  );
                    -- dept01���̺� �� deptno�÷��� foreign key ����
-- ���̺� Ȯ��
SELECT * FROM emp01; 
desc emp01;
-- ������ �Է�
    -- deptno�÷��� ������ �Է½�, foreign key ������ �Ǿ��ֱ⿡
    -- dept01���̺� �Էµ� deptno���� �Է� ����
INSERT INTO emp01 VALUES(1111, 'ȫ�浿', '������', 10);

-- 3. �θ� ���̺�(DEPT01)�� ������ ����
DELETE FROM dept01;     -- �ڽ����̺�(emp01)���� �����ϰ� �ֱ⿡ ����X
SELECT * FROM dept01;
SELECT * FROM emp01;

-- 4. �ڽ� ���̺��� �ܷ�Ű �������� ��Ȱ��ȭ
-- �θ� ���̺�(DEPT01)�� ������ ������ ���� �ڽ����̺�(EMP01)�� �ܷ�Ű ����������
-- ��Ȱ��ȭ ��Ű��, �θ� ���̺��� �����͸� ������ �� ����

-- ����: ALTER TABLE ���̺�� DISABLE CONSTRAINT CONSTRAINT_NAME;
    -- CONSTRAINT_NAME(�������� �̸�)�� Ȯ���غ��� ��
    --  [���̺�] ���� -> [��������] -> [constraint_type]���� foreign key��� ���� �÷��� CONSTRAINT_NAME Ȯ��   
ALTER TABLE emp01 DISABLE CONSTRAINT SYS_C007047;

-- cf. �ڽ����̺�(EMP01)�� �ܷ�Ű �������� Ȱ��ȭ
-- ����: ALTER TABLE ���̺�� ENABLE CONSTRAINT CONSTRAINT_NAME;
    -- �θ����̺��� �����Ͱ� ������ ��쿡�� , �ڽ����̺��� �����͵� ����� Ȱ��ȭ�ؾ� ��
DELETE FROM emp01;
ALTER TABLE emp01 ENABLE CONSTRAINT SYS_C007047;


-- 5. �θ����̺��� �����Ͱ� ������(�ڽ����̺��� �����ϴ� �ܷ�Ű�� ���� ����)
DELETE FROM dept01;
SELECT * FROM dept01;


-- CASCADE �ɼ�
-- 1. cascade�ɼ��� �ٿ��� �θ����̺�(dept01)�� ���������� ��Ȱ��ȭ ��Ű��
--    �����ϰ� �ִ� �ڽ����̺�(emp01)�� �ܷ�Ű �������ǵ� ���� ��Ȱ��ȭ��
ALTER TABLE dept01 DISABLE CONSTRAINT SYS_C007043 CASCADE;

-- 2. cascade�ɼ��� �ٿ��� �θ����̺�(dept01)�� Primary Key�����ϸ�
--    �����ϴ� �ڽ����̺�(emp01)�� Foreign Key �������ǵ� ���� ��������
ALTER TABLE dept01 DROP CONSTRAINT SYS_C007043 CASCADE;
ALTER TABLE dept01 DROP PRIMARY KEY CASCADE;


-- 1. �θ� ���̺� ����
DROP TABLE dept01 PURGE;
CREATE TABLE dept01 (   deptno NUMBER(2) PRIMARY KEY,
                        dname VARCHAR2(14),
                        loc VARCHAR2(13)    );
-- ���̺� Ȯ��
SELECT * FROM dept01;                       
-- ������ ����
INSERT INTO dept01 VALUES (10, 'ACCOUNTING', 'NEW YORK');

-- 2. �ڽ� ���̺� ����
DROP TABLE emp01 PURGE;
-- ON DELETE CASCADE: �θ����̺� �����Ͱ� �����Ǹ�, 
--                     �����ϴ� �ڽ����̺��� �����͵� ���� �������ִ� �ɼ�
CREATE TABLE emp01( empno NUMBER(4) PRIMARY KEY,
                    ename VARCHAR2(10) NOT NULL,
                    job VARCHAR2(10) UNIQUE,
                    deptno NUMBER(2) REFERENCES dept01(deptno) ON DELETE CASCADE );
                    -- dept01���̺� �� deptno�÷��� foreign key ����

-- ���̺� Ȯ��
SELECT * FROM emp01; 
desc emp01;
-- ������ �Է�
    -- deptno�÷��� ������ �Է½�, foreign key ������ �Ǿ��ֱ⿡
    -- dept01���̺� �Էµ� deptno���� �Է� ����
INSERT INTO emp01 VALUES(1111, 'ȫ�浿', '������', 10);

-- 3. �θ� ���̺�(DEPT01)�� �����͸� ����
DELETE FROM dept01 WHERE deptno=10;
SELECT * FROM dept01;

-- cascade�ɼǿ� ���� �ڽ����̺� �����͵� ������
SELECT * FROM emp01; 





