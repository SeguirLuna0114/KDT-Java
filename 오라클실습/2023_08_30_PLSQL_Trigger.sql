-- 2023. 08. 30 (��)

-- Ʈ����(Trigger)
--  1. Ʈ������ ������ �ǹ̴� '��Ƽ�'
--  2. Ʈ���Ŵ� �̺�Ʈ�� �߻����Ѽ� ���������� �ٸ� �۾��� '�ڵ�'���� ó��/������ �� ���
--  3. �̺�Ʈ�� DML_SQL���� �̿��ؼ� �̺�Ʈ�� �߻���Ű��,
--     �̶� ���������� �����(begin ~ end)���� ������ �ڵ����� ����

-- �ӽ� ���̺� ����
PURGE RECYCLEBIN;

-- Q1. ��� ���̺� ����� ��ϵǸ�, "���� ����� �Ի��߽��ϴ�."��� �޽����� ����ϴ� Ʈ����
-- 1. emp01���̺� ����
DROP TABLE emp01 PURGE;
CREATE TABLE emp01(
    empno NUMBER(4) PRIMARY KEY, -- �⺻Ű ��������
    ename VARCHAR2(20),
    job VARCHAR2(20) );

-- emp01���̺� ���� Ȯ��
SELECT * FROM tab;
SELECT * FROM emp01;

-- 2. Ʈ���� ����
CREATE OR REPLACE TRIGGER trg_01
    AFTER INSERT ON emp01       -- �̺�Ʈ �߻�
BEGIN
    dbms_output.put_line('���Ի���� �Ի� �߽��ϴ�.');
END;

-- 3. Ʈ���� ��� Ȯ��
SELECT * FROM user_triggers;

-- 4. �̺�Ʈ �߻� : emp01���̺� ȸ������(������ �Է�)
    -- �����͸� �Է��� �� ���� '���Ի���� �Ի� �߽��ϴ�.'�޽��� ��µ�
SET SERVEROUTPUT ON
INSERT INTO emp01 VALUES(1111, 'ȫ�浿', '������');
INSERT INTO emp01 VALUES(1112, 'ȫ�浿', '������');
INSERT INTO emp01 VALUES(1113, 'ȫ�浿', '������');
INSERT INTO emp01 VALUES(1115, 'ȫ�浿', '������');

-- emp01���̺� ������ Ȯ��
SELECT * FROM emp01;


-- Q2. ��� ���̺� (EMP01)�� ���� ����� ��ϵǸ�, �޿� ���̺�(SAL01)�� 
--     �޿� ������ �ڵ����� �߰����ִ� Ʈ���Ÿ� ����
-- 1. emp01 ���̺� ������ ����
DELETE FROM emp01;
COMMIT;

-- 2. �޿� ���̺� ���� : SAL01
CREATE TABLE sal01(
    salno NUMBER(4) PRIMARY KEY,    -- �⺻Ű(Primary Key) ����
    sal NUMBER(7, 2),
    empno NUMBER(4) REFERENCES emp01(empno) );  -- �ܷ�Ű(Foreign Key) ����
    -- emp01���̺��� empno�÷��� primary key�� �����Ǿ��⿡, �θ�Ű O
-- ���̺� ���� Ȯ��
SELECT * FROM tab;

-- 3. ������ ����
CREATE SEQUENCE sal01_salno_seq;    -- 1���� 1�� �����Ǵ� ������ ����
-- ������ ���� Ȯ��
SELECT * FROM seq;

-- 4. Ʈ���� ����
    -- :NEW.�÷��� : insert, update���� �̿��ؼ� �̺�Ʈ�� �߻��� ���
    -- :OLD.�÷��� : delete���� �̿��ؼ� �̺�Ʈ�� �߻��� ���
CREATE OR REPLACE TRIGGER trg_02
    AFTER INSERT ON emp01       -- emp01���̺� insert�� �� triggeró��
    FOR EACH ROW    -- Ʈ���Ű� �� �࿡ ���� ���������� �����
BEGIN
    -- Trigger logic �ۼ�
    INSERT INTO sal01 
    VALUES(sal01_salno_seq.nextval, 300, :new.empno);
END;

-- 5. Ʈ���� ��� Ȯ��
SELECT * FROM user_triggers;

-- 6. �̺�Ʈ �߻� : EMP01���̺� ��� ���
INSERT INTO emp01 VALUES(1111, 'ȫ�浿', '������');
INSERT INTO emp01 VALUES(1112, 'ȫ�浿', '������');
INSERT INTO emp01 VALUES(1113, 'ȫ�浿', '������');

-- 7. ���̺� ������ Ȯ��
SELECT * FROM emp01;
SELECT * FROM sal01;        -- Ʈ���ſ� ���ؼ� �ڵ����� ��ϵ�


-- Q3. ������̺�(emp01)���� ��������� �����Ǹ�, �޿������� �ڵ����� �����ϴ� Ʈ���� ����
-- �����ϴ� �ܷ�Ű�� �ֱ� ������, �θ� ���̺��� �����͸� ������ �� ����
    -- �ܷ�Ű �������ǿ� CASCADE(���ӻ���)�� �߰�����
DELETE FROM emp01 WHERE empno = 1111;   -- ����(child record found)

-- 1. Ʈ���� ����
CREATE OR REPLACE TRIGGER trg_03
    AFTER DELETE ON emp01       -- �̺�Ʈ�߻�(emp01���̺��� ������ ������ ��)
    FOR EACH ROW        -- �� ������ Ʈ���� �߻�
BEGIN
    DELETE FROM sal01
    WHERE empno = :OLD.empno;
END;

-- 2. Ʈ���� ��� Ȯ��
SELECT * FROM user_triggers;

-- 3. �̺�Ʈ �߻�
--  : ��� ���̺�(EMP01)�� �����ȣ111�� ����� �����ϸ�,
--    ���������� �޿� ���̺�(SAL01)�� �޿������� ������
DELETE FROM emp01 WHERE empno = 1111;

-- 4. ��� Ȯ��
SELECT * FROM emp01;
SELECT * FROM sal01;        -- Ʈ���ſ� ���ؼ� �ڵ����� ������

