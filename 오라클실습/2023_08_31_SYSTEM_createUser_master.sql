-- 2023. 08. 31 (��)

-- ������ �𵨸��� ���� ���� ����
-- userid : master, passwd : 1234

-- ���� ������ ���� ������ �������� ����
conn system/oracle
-- ���ο� ���� ����
CREATE USER master IDENTIFIED BY 1234;

-- ������ ������ ���� �ο�
GRANT CONNECT, RESOURCE TO master;
    -- ���� master�������� ���� ����
    
-- Oracle SQL���� master���� ����ص�