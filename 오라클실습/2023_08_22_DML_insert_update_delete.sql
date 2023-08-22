-- 2023. 08. 22(ȭ)

-- DML(Data Manulpation Language, ������ ���۾�)
--  insert, update, delete

-- 1. insert : ������ �Է�
--  1) ����
--      case1) �÷����� ��� �Է��ϴ� ���
--          insert into ���̺��(�÷�1, �÷�2,..) values(������1, ������2,...);
--      case2) ���� �Է��ϴ� ���
--          insert into ���̺�� values(������1, ������2,...);

-- dept01���̺��� ����
-- dept01���̺��� �����Ǿ� �ִ� ��쿡 ����Ͽ�, drop�ؼ� ����
DROP TABLE dept01 PURGE;

-- ����ִ� dept01 ���纻 ���̺� ����(��, ���̺� ������ ����)
CREATE TABLE dept01 AS 
SELECT * FROM dept
WHERE 1=0;              -- 1=0�� �׻� false�̱⿡, ��� ���ڵ嵵 ���õ��� ����

-- �����Ǿ����� Ȯ��
SELECT * FROM dept01;

-- ������ �Է�(INSERT INTO ���� ����Ͽ� �����͸� Ư�� ���̺� �߰�)
    --  case1) �÷����� ��� �Է��ϴ� ���
    --       insert into ���̺��(�÷�1, �÷�2,..) values(������1, ������2,...);
INSERT INTO dept01 (deptno, dname, loc)
VALUES (10, 'ACCOUNTING', 'NEW YORK');

    --  case2) ���� �Է��ϴ� ���
    --       insert into ���̺�� values(������1, ������2,...);
INSERT INTO dept01
VALUES (20, 'RESEARCH', 'DALLAS');    
    
INSERT INTO dept01
VALUES (30, '������', '����');    

-- NULL�� �Է�
INSERT INTO dept01 (deptno, dname) 
VALUES (40, '���ߺ�');                 -- loc�÷� null
    -- ��������� NULL���� �Է� ����
INSERT INTO dept01 
VALUES (50, '��ȹ��', NULL);           -- loc�÷� null


-- 2) ���������� ������ �Է�
-- dept01���̺��� �����Ǿ� �ִ� ��쿡 ����Ͽ�, drop�ؼ� ����
DROP TABLE dept02 purge;

-- dept02 ���̺� ���� : 'WHERE 1=0'�� �̿��� ���̺� ������ ����
CREATE TABLE dept02 AS
SELECT * FROM dept 
WHERE 1=0;

-- dept02���̺� Ȯ��
SELECT * FROM dept02;

-- ���������� ������ �Է�
INSERT INTO dept02 SELECT * FROM dept;
INSERT INTO dept02 SELECT * FROM dept02;

SELECT count(*) FROM dept02;


-- 3) INSERT ALL ��ɹ����� ���� ���̺� ������ �Է�
-- 2���� ���̺� ����
CREATE TABLE emp_hir AS
SELECT empno, ename, hiredate FROM emp
WHERE 1=0;

CREATE TABLE emp_mgr AS
SELECT empno, ename, mgr FROM emp
WHERE 1=0;

-- insert all ��ɹ����� ���� ���̺� ������ �Է�
INSERT ALL
        INTO emp_hir 
            VALUES (empno, ename, hiredate)
        INTO emp_mgr
            VALUES (empno, ename, mgr)
SELECT empno, ename, hiredate, mgr FROM emp WHERE deptno=20;            
           
SELECT * FROM emp_hir;
SELECT * FROM emp_mgr;


-- 2. update :���� ������ ����
-- ����: update   ���̺�     set   �÷�1 = ������ �� 1,
--                               �÷�2 = ������ �� 2
--      where ������;

-- dept01���̺��� �����Ǿ� �ִ� ��쿡 ����Ͽ�, drop�ؼ� ����
DROP TABLE emp01 purge;

-- emp01 ���̺� ����
CREATE TABLE emp01 AS
SELECT * FROM emp;

-- ������ ���̺� Ȯ��
SELECT * FROM emp01;

-- 1) ��� ������ ���� : where �������� ������� ���� => ��� ���ڵ�(��)�� ����
-- Q1. ��� ������� �μ���ȣ�� 30�� ����
UPDATE emp01 SET deptno = 30;

-- Q2. ��� ������� �޿��� 10% �λ�
UPDATE emp01 SET sal = sal * 1.1;

-- Q3. ��� ������� �Ի����� ���� ��¥�� ����
UPDATE emp01 SET hiredate = sysdate;


-- 2) Ư�� ������ ���� : where �������� ���
DROP TABLE emp02 purge;

-- ���纻 ���̺� ����
CREATE TABLE emp02 AS
SELECT * FROM emp;
    -- ������ ���̺� Ȯ��
    SELECT * FROM emp02;
    
-- Q1. �޿��� 3000�̻��� ����� �޿��� 10%�λ�
UPDATE emp02 SET sal = sal * 1.1 where sal >= 3000;

-- Q2. 1987�⵵�� �Ի��� ����� �Ի����� ���� ��¥�� ����?
    -- substr()����ϴ� ���
UPDATE emp02 SET hiredate = sysdate WHERE substr(hiredate, 1, 2) = '87';
    -- to_char()�Լ� ����ϴ� ���
UPDATE emp02 SET hiredate = sysdate WHERE To_char(hiredate, 'yyyy') = '1987';
    -- �񱳿����� ����ϴ� ���
UPDATE emp02 SET hiredate = sysdate 
            WHERE hiredate >= '87/01/01' AND hiredate <= '87/12/31';
    -- BETWEEN ������ ���
UPDATE emp02 SET hiredate = sysdate 
            WHERE hiredate BETWEEN '87/01/01' AND '87/12/31';

-- Q3. SCOTT����� �Ի����� ���� ��¥�� �����ϰ�, �޿��� 50, Ŀ�̼��� 4000���� ����
UPDATE emp02 SET hiredate = sysdate, sal=50, comm=4000
            WHERE ename = 'SCOTT';

-- 3) ���������� �̿��� ������ ����
-- Q. 20�� �μ��� ������(DALLAS)�� 40�� �μ��� ������(BOSTON)���� ����
-- ������ �����Ǿ��ִ� ���̺� drop
DROP TABLE dept01 purge;

-- ���纻 ���̺� ����
create table dept01 AS
SELECT * FROM dept;

-- ������ dept01���̺� Ȯ��
select * from dept01;

-- ���������� �̿��� update�� �ۼ�
UPDATE dept01
SET loc = (SELECT loc FROM dept01 WHERE deptno = 40)
WHERE deptno = 20;


-- 3. delete : ������ ����
-- ���� : delete from ���̺� where ������;

-- 1) ��� ������ ���� : where �������� ������� ����
SELECT * FROM dept01;
DELETE FROM dept01;

ROLLBACK;           -- Ʈ����� ���

-- 2) �������� �����ϴ� ������ ���� : where �������� ���
-- Q. dept01 ���̺��� 30�� �μ��� ����
DELETE FROM dept01 WHERE deptno = 30;
SELECT * FROM dept01;

-- 3) ���������� �̿��� ������ ����
-- Q. ������̺�(emp02)���� �μ����� SALES �μ��� ����� ����
-- ������ �����ϴ� emp02���̺� ����
DROP TABLE emp02 PURGE;

-- ���纻 emp02���̺� ����
CREATE TABLE emp02 AS
SELECT * from emp;

-- ������ ���̺� Ȯ��
SELECT * FROM emp02;

-- ���������� ����ؼ�, SALES�μ� ��� ����
DELETE FROM emp02
WHERE deptno = (SELECT deptno FROM dept WHERE dept.dname = 'SALES');

  
    
    