-- 2023. 11. 06 (��)

-- spring������Ʈ �ǽ��� ���� ���� ����
-- userid : spring, passwd : spring123

-- ���� ������ ���� ������ �������� ����
conn system/oracle

-- ���ο� ���� ����
CREATE USER spring IDENTIFIED BY spring123;

-- ������ ������ ���� �ο�
GRANT CONNECT, RESOURCE TO spring;
    -- ���� spring�������� ���� ����
    
-- Oracle SQL���� spring���� ����ص�