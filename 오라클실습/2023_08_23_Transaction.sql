-- 2023. 08. 23(��)

-- Transaction(Ʈ�����)
-- 1. ������ �۾�����
-- 2. Ʈ������� DML(insert, update, delete) SQL������ ���۵�
-- 3. �������� �ϰ����� �����ϸ鼭, �����͸� ���������� �����ϱ� ���� ����
-- 4. Ʈ������� All-or-Nothing ������� ó����(�߰��ܰ�x)

-- TCL(Transaction Control Langauage)
-- commit : Ʈ������� ����
-- rollback : Ʈ������� ���
-- savepoint : ������ ����(������)�� �����ϴ� ����

-- ������ �����ϴ� dept01���̺� drop
DROP TABLE dept01 PURGE;

-- ���纻 ���̺� dept01 ����
CREATE TABLE dept01 AS
SELECT * FROM dept; 

-- ������ dept01���̺� Ȯ��
SELECT * FROM dept01;

-- 1. rollback: Ʈ������� ���
    -- ���ο� Ʈ������� ���۵ǰ�, �޸𸮻󿡼��� delete�� �����
DELETE FROM dept01;

-- Ʈ������� ����ϱ� ������, �޸𸮻󿡼� delete�� �����Ͱ� ������
ROLLBACK;

-- dept01���̺� Ȯ�� ��, �����Ǿ��� �����Ͱ� �����Ǿ� ����
SELECT * FROM dept01;


-- �ڵ� �ѹ� : �ڵ����� �ѹ��� ����Ǵ� ��
-- : �� �������� ���� - ������ â�� �ݴ� ���, ��ǻ�Ͱ� �ٿ�Ǵ� ���



-- 2. commit : Ʈ������� ����
--  : �޸� �󿡼� ó���� DML SQL���� �����ͺ��̽��� ���������� �ݿ��ϰ� ��
-- �޸𸮻󿡼� 20�� ������ ����
DELETE FROM dept01 WHERE deptno = 20;

-- commit�� �����Ͽ� Ʈ����� ����
--  (�޸� �󿡼� ������ �����͸� DB�� �ݿ��ؼ� ����)
COMMIT;

-- rollback���� ������ ������ �õ�������,
-- Ʈ������� ����Ǿ��� ������ ������ 20�� �����ʹ� ������ �� ����
ROLLBACK;       -- ������ 20�� �����Ͱ� ��������X


-- �ڵ� Ŀ�� : �ڵ����� Ŀ���� ����Ǵ� ��
-- 1) �������� ���� : quit, exit, con.close()
-- 2) DDL(create, alter, rename, drop, truncate), DCL(grant, revoke) ����� ����� ��

-- ��1. DDL����� ����(create)
    -- select ������� dept01���̺� �� ������ Ȯ��
SELECT * FROM dept01;       -- 10, 30, 40 ������ ����� ����
    -- ���ο� �ŷ� ����) delete from���� ������ ����
DELETE FROM dept01 WHERE deptno = 40;       -- 40�� ������ ����

-- * �ڵ� Ŀ�� �����(DDL��ɾ� create)
CREATE TABLE dept03 AS          -- create table������ ���̺� ����
SELECT * FROM dept;

-- rollback ����
ROLLBACK;           -- �����Ǿ��� 40�� �����͸� �������� X

-- ��2. DDL��ɾ� ����(truncate)
    -- delete(DML) : rollbback���� ������ ������ ����
    -- truncate(DDL) : �ڵ�Ŀ���� ����Ǿ� rollback���� ������ ���� �Ұ�
SELECT * from dept01;       -- 10, 30

-- ���ο� �ŷ� ����) delete from���� ������ ����
DELETE FROM dept01 WHERE deptno = 30;       -- 30�� �μ� ����
ROLLBACK;                                   -- ������ 30�� �����Ͱ� ������
SELECT * from dept01;       -- 10, 30

-- * �ڵ� Ŀ�� �����(DDL��ɾ� truncate)
TRUNCATE TABLE dept01;      -- truncate������ ������ �����Ǹ� DB�� �ݿ��� => ����X
ROLLBACK;                   -- ������ dept01������ ����X
SELECT * FROM dept01;


-- 3. savepoint: �ӽ� �������� ������ ���Ǵ� ���

-- ������ ������ dept01���̺� drop
DROP TABLE dept01 PURGE;

-- 1. dept01���̺� ����
CREATE TABLE dept01 AS
SELECT * FROM dept;

-- 2. 40�� �μ� ����
DELETE FROM dept01 WHERE deptno = 40;

-- 3. commit ���� : Ʈ����� ����
COMMIT;

-- 4. 30�� �μ� ����
DELETE FROM dept01 WHERE deptno =30;

-- 5. c1 ������ ����
SAVEPOINT c1;

-- 6. 20�� �μ� ����
DELETE FROM dept01 WHERE deptno = 20;

-- 7. c2������ ����
SAVEPOINT c2;

-- 8. 10�� �μ� ����
DELETE FROM dept01 WHERE deptno = 10;

-- 9. c2 ���������� ����
ROLLBACK to c2;         -- 10�� �μ� ����
SELECT * FROM dept01;

-- 10. c1 ���������� ����
ROLLBACK to c1;         -- 10, 20�� �μ� ����
SELECT * FROM dept01;

-- 11. ���� Ʈ����� ���� ���ĸ� ����
ROLLBACK;               -- 10, 20, 30�� �μ� ����
SELECT * FROM dept01;



