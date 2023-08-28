-- 2023. 08. 25(��)

-- �����ͺ��̽� ������ ���� ����
-- 1. �ý��� ����
-- 2. ��ü ����

-- 2. ��ü ����(Object Permission)
--  ����Ŭ ��ü : ���̺�, ��, ������, �ε���, ���Ǿ�, ���ν���, Ʈ����

-- 1. ���� ������ user01�������� scott ���� ������ EMP ���̺� ��ü�� ����
--  select ��ü ������ �ο�
conn scott/tiger
GRANT SELECT ON emp TO user01;

-- 2. user01 �������� ���� �� EMP ���̺� ��ü�� ���ؼ� select�� ����
SQL> conn user01/tiger      -- Connected.
SQL> select * from emp;     -- ���� �߻�
    -- table or view does not exist
SQL> select * from scott.emp;   -- �˻� ����

-- 3. ��ü ���� ���
REVOKE SELECT ON emp FROM user01;

-- ��ü ������ ��ҵ� ��쿡�� ������ �߻���
SQL> select * from scott.emp;   -- ���� �߻�
    -- table or view does not exist
    
    
-- with grant option
-- : user02 �������� scott���� ������ emp���̺� ��ü�� ���ؼ� select ��ü ������
--   �ο��� ��, with grant option�� �ٿ��� ������ �ο��Ǹ�,
--   user02 ������ �ڱⰡ �ο����� ������ �� 3�� ����(user01)���� ��ο��� �� �ִ�.
--  "�ڱⰡ �ο����� ������ �� 3�� �������� ��ο� �� �� �ִ�"
-- 1. user02�������� scott���� ������ EMP���̺� ��ü�� ���� select ��ü������ �ο�
conn scott/tiger
grant select on emp to user02 with grant option;
    
-- 2. user02�������� ���� ��, user01 �������� �ڱⰡ �ο����� ��ü ������ ��ο�
conn user02/tiger
select * from scott.emp;        -- �˻� ������

grant select on scott.emp to user01;

-- 3. user01 �������� ���� �� �˻�
conn user01/tiger
select * from scott.emp;         -- �˻� ������



