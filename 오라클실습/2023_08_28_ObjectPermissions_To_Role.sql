-- 2023. 08. 28(��)

-- ����� ���� �� ���� : �ѿ� "��ü ����"�� �ο�
-- �ý��� �������� ����
conn system/oracle
-- 1. �� ����
CREATE ROLE mrole02;

-- 2. ������ �ѿ� "��ü ����"�� �ο�
-- ��ü ������ �������� �����ؼ� ����
conn scott/tiger
GRANT SELECT ON emp to mrole02;

-- 3. user05 ��������  mrole02�� �ο�
conn system/oracle
GRANT mrole02 TO user05;

-- 4. user05 �������� ���� �� SELECT �˻� �õ�
SQL> conn user05/tiger
    -- Connected.
SQL> SELECT * FROM scott.emp;
--     EMPNO ENAME                JOB                       MGR HIREDATE
------------ -------------------- ------------------ ---------- --------
--       SAL       COMM     DEPTNO
------------ ---------- ----------
--      7369 SMITH                CLERK                    7902 80/12/17


-------------------------------------------------------------------------------------

-- ����Ʈ ���� �����ؼ� ���� ����ڿ��� �� �ο��ϱ�
-- ����Ʈ �� : �ý��� ���� + ��ü ����

-- 1. ����Ʈ �� ����
-- �ý��� �������� ����
conn system/oracle
-- �� ����
CREATE ROLE def_role;

-- 2. ������ ��(def_role)�� �ý��� ������ �߰�
-- �ý��� �������� ����
conn system/oracle
-- �ý��� ������ �߰�
GRANT CREATE SESSION, CREATE TABLE to def_role;

-- 3. ������ ��(def_role)�� ��ü ������ �߰�
-- ��ü ������ �������� �����ؼ� ����
conn scott/tiger
-- ��ü ������ �߰�
GRANT SELECT ON emp to def_role;
GRANT UPDATE ON emp to def_role;
GRANT DELETE ON emp to def_role;

-- 4. ���� �����ϱ� ���� �Ϲ� ���� ����
-- �ý��� �������� ����
conn system/oracle
-- ���ο� �Ϲ� ���� ����
CREATE USER usera1 IDENTIFIED BY tiger;
CREATE USER usera2 IDENTIFIED BY tiger;
CREATE USER usera3 IDENTIFIED BY tiger;

-- 5. def_role�� ������ �������� �ο�
-- �ý��� �������� ����
conn system/oracle
-- ������ ���� �������� �Ҵ�
GRANT def_role TO usera1;
GRANT def_role TO usera2;
GRANT def_role TO usera3;

-- 6. usera1/usera2/usera3 �������� ���� �� �˻�
SQL> conn useral/tiger
SQL> conn usera2/tiger
SQL> conn usera3/tiger
    -- Connected.
-- SELECT�� ����
SQL> SELECT * FROM scott.emp;
    -- �˻� ����
    
