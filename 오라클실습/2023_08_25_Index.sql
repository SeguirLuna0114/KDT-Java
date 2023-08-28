-- 2023. 08. 25(��)

-- �ε���(Index)
--  : ������ �˻��ϱ� ���� ���Ǵ� ��ü

-- �ε��� ��� Ȯ��
SELECT * FROM user_indexes;
-- �⺻Ű(Primary Key)�� ������ �÷��� �ڵ����� ���� �ε����� ������


-- Q. �ε��� ��� ������ ���� �˻� �ӵ� ��
-- 1. ���̺� ����
DROP TABLE emp01 PURGE;
-- ���纻 ���̺� ����(��, ���������� ������� ����)
CREATE TABLE emp01 AS
SELECT * FROM emp;
-- ���̺� Ȯ��
SELECT * FROM emp01;

-- 2.emp01 ���̺� ������ �Է�
    -- ���̺� ������ �����͸� ����
    -- "emp01" ���̺��� �����͸� ��� ��� ���� �����Ͽ� 
    -- ������ "emp01" ���̺� �����͸� ����
INSERT INTO emp01 SELECT * FROM emp01;

-- 3. �˻��� ������ �Է�
INSERT INTO emp01(empno, ename) VALUES(1111, 'ahn');

-- 4. �ð����� Ÿ�̸� ������ ����
    -- SQL ���� ���࿡ �ɸ� �ð��� Ȯ���Ͽ� 
    -- ���� ��� ����� ���ϰų� ������ ���� �ð��� ��
SET TIMING ON;      -- SQL ���� ���� �ð��� �����ϰ� ����� �� �ֵ��� ����

-- 5. �˻��� �����ͷ� �˻��ð��� ����: �ε��� �������� ���� ���
SELECT * FROM emp01 WHERE ename = 'ahn';    -- 0.061��

-- 6. �ε��� ���� : emp01���̺��� ename�÷��� �ε��� �����
CREATE INDEX idx_emp01_ename ON emp01(ename);

-- 7. �ε��� ��� Ȯ��
SELECT * FROM user_indexes;

-- 8. �˻��� �����ͷ� �˻��ð��� ����: �ε����� ������ ���
SELECT * FROM emp01 WHERE ename = 'ahn';    -- 0.054��


-- �ε��� ����
-- ���� : drop index index_name;
DROP INDEX idx_emp01_ename;


-- �ε��� ����
--      1. ���� �ε��� : �ߺ��� �����Ͱ� ���� �÷��� ������ �� �ִ� �ε���
--      2. �� ���� �ε��� : �ߺ��� �����Ͱ� �ִ� �÷��� ������ �� �ִ� �ε���

-- 1. ���̺� ����
DROP TABLE dept01 PURGE;
-- ���̺� ������ ����
CREATE TABLE dept01 AS
SELECT * FROM dept where 1=0;

-- 2. ������ �Է�
INSERT INTO dept01 VALUES(10, '�λ��', '����');
INSERT INTO dept01 VALUES(20, '�ѹ���', '����'); 
INSERT INTO dept01 VALUES(30, '������', '����');     -- loc�÷��� �ߺ������� �Է�
-- ���̺� Ȯ��
SELECT * FROM dept01;       -- �ߺ��� �����Ͱ� �ִ� loc�÷��� �����ε����� ���X

-- 3. ���� �ε��� : dept01�÷��� ���� �ε����� ����
CREATE UNIQUE INDEX idx_dept01_deptno 
ON dept01(deptno);

-- 4. �ε��� ��� Ȯ��
SELECT * FROM user_indexes;

-- Q. ���� �ε��� ������ deptno�÷��� �ߺ� ������ �Է� �Ұ���
    -- deptno�÷��� ���� �ε����� ������ ���Ŀ� �ߺ� �����͸� �Է��� �� ����
INSERT INTO dept01 VALUES(30, '������', '����');     -- unique constraint

-- 5. ����� �ε���
-- Q. loc�÷��� ����, ���� �ε����� ����
-- loc�÷��� ���� �ε��� ����
    -- : loc�÷��� �ߺ��� �����Ͱ� �ֱ⿡ ���� �ε����� ���� �� X
CREATE UNIQUE INDEX idx_dept01_loc 
ON dept01(loc);         -- ���� �߻�(cannot CREATE UNIQUE INDEX)

-- loc�÷��� ����� �ε��� ���� 
CREATE INDEX idx_dept01_loc 
ON dept01(loc);         -- ���� �ε��� ������

-- �ε��� ��� Ȯ��
SELECT * FROM user_indexes;     -- ���� �ε����� Unique, ������ε����� nonUnique�� ������


-- 6. ���� �ε��� : 2�� �̻��� �÷����� ������� �ε���
CREATE INDEX idx_dept01_com 
ON dept01(deptno, dname);


-- 7. �Լ� ��� �ε��� : ������ �ƴ� �Լ��� �����Ͽ� ���� �ε���
CREATE INDEX idx_emp01_annsal 
ON emp(sal*12 +NVL(comm, 0));

