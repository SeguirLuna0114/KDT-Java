-- 2023. 08. 28(��)

-- Role(��) : �������� ������ ������� ��

-- Oracle �����ͺ��̽����� �����ϴ� �ֿ� �ý��� ��
-- EX) Connect��(8���� ����), resource��(20������ ����), DBA��(130������ ����)

-- 1. ���ο� ���� ���� : user04/tiger
CREATE USER user04
IDENTIFIED BY tiger;

-- 2. ������ ���� ��� Ȯ��
SELECT * FROM dba_users;

-- 3. user04 �������� role �ο� : connect, resource 2���� �� �ο�
GRANT CONNECT, RESOURCE TO user04;

-- 4. user04 �������� ���� ��, ���̺� ����
SQL> conn user04/tiger
    -- SQL> sqlplus user04/tiger
SQL> CREATE TABLE member(ID VARCHAR2(20), PASSWD VARCHAR2(20) );
    -- Table created.    
SQL> desc member;
-- Name                                      Null?    Type
-- ----------------------------------------- -------- ----------------------------
-- ID                                                 VARCHAR2(20)
-- PASSWD                                             VARCHAR2(20)   
    
----------------------------------------------------------------------------------

-- ����� ���� �� ���� : �ѿ� "�ý��� ����"�� �ο�
-- 1. �� ����
CREATE ROLE mrole;

-- 2. ������ �ѿ� �ý��� ������ �߰�
GRANT CREATE SESSION, CREATE TABLE, CREATE VIEW to mrole;

-- 3. mrole�� �����ϱ� ���� ���� ����: user05/tiger
CREATE USER user05
IDENTIFIED BY tiger;
-- ������ ���� ��� Ȯ��
SELECT * FROM dba_users;

-- 4. user05 �������� mrole�� �ο�
GRANT mrole TO user05;

-- 5. user05 �������� ����
SQL> conn user05/tiger
    -- SQL> sqlplus user05/tiger
  
---------------------------------------------------------------------------------------

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
    -- �˻� ����

---------------------------------------------------------------------------

-- �� ȸ�� : Ư�� �������� �ο��� ���� ����ϴ� ��
-- ���� : REVOKE ���̸� from ����ڸ�;

-- Q. user05�������� �ο��� mrole�� mrole02�� ȸ��(���)
-- �ý��� �������� ����
conn system/oracle
-- �� ȸ��
REVOKE mrole from user05;
REVOKE mrole02 from user05;


-- �� ����
-- ����: DROP ROLE ���̸�;

-- Q. mrole�� mrole02�� ����
conn system/oracle
-- �� ����
DROP ROLE mrole;
DROP ROLE mrole02;
  
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






    
    
