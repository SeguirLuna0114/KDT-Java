-- 2018. 08. 22(ȭ)

--* ����Ŭ�� ��ü
--  ���̺�, ��, ������, �ε���, ���Ǿ�, ���ν���, Ʈ����
--
--
--* ������ ��ųʸ��� ������ ��ųʸ� ��
--  ������ ��ųʸ��� ���ؼ� ���ٰ�����
--
--  - ������ ��ųʸ� �� : user_xxxx
--     (���� ���̺�)          all_xxxx
--		      dba_xxxx
--
--  - ������ ��ųʸ�(�ý��� ���̺�) : 

  select * from tab;
  select table_name from user_tables; --(���̺�)

  select * from user_views; --(��)

  select * from seq;
  select * from user_sequences; --(������)

  select * from user_indexes; --(�ε���)

  select * from user_synonyms; --(���Ǿ�)

  select * from user_source; --(���ν���)

  select * from user_triggers; --(Ʈ����)

-- �ڱ� ���� ���� �Ǵ� ������ �ο����� ��ü�� ���� ���� �˻�
  select table_name from all_tables;

-- �����ͺ��̽� ������(DBA)�� ������ �� �ִ� ��ü�� ���� ���� �˻�
    --������ system(������ ����)���� �����ϸ�, ���� ����
  select table_name from dba_tables; --(DBA ������ ��밡��)
 
-- ����Ŭ �ý����� ��� ���� ���� �˻�
    --������ system(������ ����)���� �����ϸ�, ���� ����
  select username from dba_users; --(DBA ������ ��밡��)

