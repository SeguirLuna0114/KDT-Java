-- 2023. 11. 21 (ȭ)

-- ���� aws ���� ����
-- userid : master, passwd : 1234

-- ���� ������ ���� ���� IP ������ �������� ����
conn system/system
-- ���ο� ���� ����
CREATE USER master IDENTIFIED BY 1234;

-- ������ ������ ���� �ο�
GRANT CONNECT, RESOURCE TO master;
    -- ���� proj�������� ���� ����
    
-- Oracle SQL���� master���� ����ص�