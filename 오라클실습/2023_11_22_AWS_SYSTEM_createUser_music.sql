-- 2023. 11. 22 (��)

-- ���� aws ���� ����
-- userid : music, passwd : music123

-- ���� ������ ���� ���� IP ������ �������� ����
conn system/system
-- ���ο� ���� ����
CREATE USER music IDENTIFIED BY music123;

-- ������ ������ ���� �ο�
GRANT CONNECT, RESOURCE TO music;
    -- ���� proj�������� ���� ����
    
-- Oracle SQL���� master���� ����ص�