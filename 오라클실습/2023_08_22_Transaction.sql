-- 2023. 08. 22(ȭ)

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






