-- 2023. 08. 28(��)

-- ���Ǿ�(Synonym)
-- : ���� �ǹ̸� ���� �ܾ�

-- 1. ����� ���Ǿ�
--  : ��ü�� ���� ���ٱ����� �ο����� ����ڰ� ������ ���Ǿ�ν� 
--     ���Ǿ ���� ����ڸ� ����� �� ����
    
-- 2. ���� ���Ǿ�(���� ���Ǿ�)
--  : DBA ������ ���� ����ڸ� ������ �� ����
--    ������ ��� ����
    --  1. DBA �������� �����ؼ� ���� ���Ǿ� ���� ����
    --  2. ���� ���Ǿ ���鶧�� public�� �ٿ��� ����
    -- ���� ���Ǿ��� ��
    -- sys.tab     --> tab      select * from tab;   
    -- sys.seq     --> seq      select * from seq;
    -- sys.dual    --> dual     select 10+20 from dual;
    
-------------------------------------------------------------

-- ����� ���Ǿ�
-- 1. system �������� ���� �� ���̺� ����
conn system/oracle
CREATE TABLE systbl( ename VARCHAR2(20) );

-- 2. ������ ���̺� ������ �߰�
conn system/oracle
INSERT INTO systbl VALUES('ȫ�浿');
INSERT INTO systbl VALUES('��ȭ��');
-- ���̺� ������ Ȯ��
SELECT * FROM systbl;

-- 3. scott�������� systbl���̺� ���� select ��ü ���� �ο�
-- �ش� ��ü ������ �������� ����
    -- ���� systbl��ü�� ������ system�������� ����
conn system/oracle
GRANT SELECT ON systbl TO scott;

-- 4. �ش� ��ü������ �ο����� �������� �����Ͽ� select �˻� �õ�
    -- ��ü������ �ο����� ������ scott����
conn scott/tiger
SELECT * FROM systbl;           -- ���� �߻�
SELECT * FROM system.systbl;    -- �������� �˻� ����

-- 5. scott�������� ���Ǿ ������ �� �ִ� ���� �ο�
-- ������ �������� ����
conn system/oracle
GRANT CREATE SYNONYM TO scott;

-- 6. scott�������� ������ ��, ����� ���Ǿ� ����
    --(����� ���Ǿ� ����: system.systbl -> systbl)
conn scott/tiger
CREATE SYNONYM systbl FOR system.systbl;

-- 7. ���Ǿ� ��� ��ȸ
conn scott/tiger
SELECT * FROM user_synonyms;

-- 8. ���Ǿ �̿��ؼ� select �˻�
conn scott/tiger
SELECT * FROM system.systbl;
SELECT * FROM systbl;           -- ����� ���Ǿ ����Ͽ� ��ü ����

-- 9. ����� ���Ǿ� ����
-- ���� : DROP SYNONYM synonym_name;
conn scott/tiger
DROP SYNONYM systbl;

-------------------------------------------------------------

-- ���� ���Ǿ�
--  1. DBA �������� �����ؼ� ���� ���Ǿ� ���� ����
--  2. ���� ���Ǿ ���鶧�� public�� �ٿ��� ����

-- ���� ���Ǿ� ����
conn system/oracle
CREATE PUBLIC SYNONYM pubdept FOR scott.dept;

-- ���� ���Ǿ� ���
SELECT * FROM dba_synonyms;

-- ���� ���Ǿ� ����
conn system/oracle
DROP PUBLIC SYNONYM pubdept;


