-- 2023. 08. 24(��)

-- ��(view) : �⺻ ���̺��� �̿��ؼ� ������� ���� ���̺�

-- �ǽ��� ���� �⺻ ���̺� ���� : dept_copy, emp_copy
-- 2���� �⺻ ���̺� ����
CREATE TABLE dept_copy AS
SELECT * FROM dept;

CREATE TABLE emp_copy AS
SELECT * FROM emp;

-- ������ ���̺� Ȯ��
SELECT * FROM tab;
SELECT * FROM dept_copy;
SELECT * FROM emp_copy;

-- �� ����
    -- scott������ �並 ������ �� �ִ� ������ ����
    -- ����, system�������� �����ؼ� GRANT��ɾ�� Ư�� ����ڿ��� ������ �ο������ ��
    -- GRANT CREATE VIEW TO SCOTT;      -- SCOTT�������� view������ �� �ִ� ���� �ο�
CREATE VIEW emp_view30 AS
SELECT empno, ename, deptno FROM emp_copy WHERE deptno=30;

-- �� ��� Ȯ��
SELECT * FROM tab;
SELECT * FROM user_views;

--�� �˻�
SELECT * FROM emp_view30;
desc emp_view30;

-- Q. ��(emp_view30)�� insert�� �����͸� �Է����� ���,
--    �⺻���̺�(emp_copy)�� �����Ͱ� �ԷµǴ���
-- view�� ������ �Է�
INSERT INTO emp_view30 VALUES(1111, 'ȫ�浿', 30);
SELECT * FROM emp_view30;

-- view�� �����Ͱ� �ԷµǸ�, �⺻ ���̺��� �����Ͱ� �Էµ�
SELECT * FROM emp_copy;


-- ���� ����
--  1. �ܼ���: �ϳ��� �⺻ ���̺�� ������ ��
--  2. ���պ�: �������� �⺻ ���̺�� ������ ��

-- 1. �ܼ���
-- Q. �⺻ ���̺��� emp_copy�� �̿��ؼ� 20�� �μ��� �Ҽӵ� ������� ����� �̸�, �μ���ȣ, 
--    ���ӻ���� ����� ����ϱ� ���� ��(emp_view20)�� ����
CREATE VIEW emp_view20 AS
SELECT empno, ename, deptno, mgr FROM emp_copy WHERE deptno=20;

-- �� ��� Ȯ��
SELECT * FROM tab;
SELECT * FROM user_views;

--�� �˻�
SELECT * FROM emp_view20;
desc emp_view20;

-- 2. ���պ�
-- Q. �� �μ���(�μ���) �ִ�޿��� �ּұ޿��� ����ϴ� �並 sal_view��� �̸����� �ۼ�
CREATE VIEW sal_view AS
SELECT dname, max(sal) MAX, min(sal) MIN 
FROM dept, emp
WHERE dept.deptno = emp.deptno
group BY dname;

-- �� ��� Ȯ��
SELECT * FROM tab;
SELECT * FROM user_views;

--�� ������ Ȯ��
SELECT * FROM sal_view;
desc sal_view;

-- �� ����
-- ���� : DROP WIEW ���̸�;
DROP VIEW sal_view;

-- �並 ������ �� ���Ǵ� �ɼ�
-- 1. or replace�ɼ�
--  ������ �䰡 �������� ������ �並 �����ϰ�, ���� ������ �̸��� ���� �䰡
--  �����ϸ� ���� ������ �����ϵ��� ������ִ� �ɼ�

-- 1) or replace �ɼ� ���� ������ ��(emp_view30)�� ����
--      �Ȱ��� �̸��� ���� �䰡 �����ϱ⿡, ���� �߻�(name is already used)
CREATE VIEW emp_view30 AS
SELECT empno, ename, deptno, sal, comm FROM emp_copy WHERE deptno=30;

-- 2) or replace �ɼ��� �ٿ��� ������ ��(emp_view30)�� ����
--      �Ȱ��� �̸��� ���� �䰡 �����Ѵٸ�, ���� ������ ������
CREATE OR REPLACE VIEW emp_view30 AS
SELECT empno, ename, deptno, sal, comm FROM emp_copy WHERE deptno=30;

-- 3) �� Ȯ��
SELECT * FROM emp_view30;


-- 2. with check option
--    : where �������� ���� ���� �������� ���ϵ��� ������ִ� �ɼ�
-- 1) with check option�� ������� ���� ���
CREATE OR REPLACE VIEW emp_view30 AS
SELECT empno, ename, deptno, sal, comm FROM emp_copy WHERE deptno=30;

-- Q. emp_view30�信�� �޿��� 1200 �̻��� ������� �μ���ȣ�� 30������ 20������ ����
    -- with check option�� ������� ���� ���, ���� ������
UPDATE emp_view30 set deptno=20 where sal >=1200;
SELECT * from emp_view30;

-- 2) with check option�� ����� ���
--  �信 insert, update, delete�� ����Ǹ�, �⺻ ���̺��� ������ ������ �����
select * from emp_copy;     -- �⺻ ���̺� ������ ����Ǿ� ����
DROP TABLE emp_copy PURGE;

CREATE TABLE emp_copy AS    -- �⺻ ���̺� ����
SELECT * FROM emp;

-- with check option�� ����ؼ� �� ����
CREATE OR REPLACE VIEW emp_view30 AS
SELECT empno, ename, deptno, sal, comm 
FROM emp_copy 
WHERE deptno=30 WITH CHECK OPTION;

-- Q. emp_view30�信�� �޿��� 1200 �̻��� ������� �μ���ȣ�� 30������ 20������ ����
    -- with check option�� ����� ��� ���� �߻�
UPDATE emp_view30 set deptno=20 where sal >=1200;   -- view WITH CHECK OPTION


-- 3. with read only �ɼ�
--  : �б� ������ �並 ������ִ� �ɼ�
--    �並 ���ؼ� �⺻ ���̺��� ������ �������� ���ϵ��� ������ִ� ����
CREATE OR REPLACE VIEW view_read30 AS
SELECT empno, ename, deptno, sal, comm 
FROM emp_copy 
WHERE deptno=30 WITH READ ONLY;     -- �б� ������ view ����

-- �� ��� Ȯ��
SELECT * FROM user_views;
-- ������ �� ������ Ȯ��
SELECT * FROM view_read30;

-- Q. ������ ��(view_read30)�� ����
    -- �����߻�: �б� ������ ��� with read only �ɼǶ����� ����X
UPDATE view_read30 SET sal = 3000;


