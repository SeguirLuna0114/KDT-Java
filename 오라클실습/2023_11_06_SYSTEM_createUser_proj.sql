-- 2023. 11. 06 (��)

-- ������Ʈ�� ���� ���� ����
-- userid : proj, passwd : 1234

-- ���� ������ ���� ������ �������� ����
conn system/oracle
-- ���ο� ���� ����
CREATE USER proj IDENTIFIED BY 1234;

-- ������ ������ ���� �ο�
GRANT CONNECT, RESOURCE TO proj;
    -- ���� proj�������� ���� ����
    
-- Oracle SQL���� proj���� ����ص�