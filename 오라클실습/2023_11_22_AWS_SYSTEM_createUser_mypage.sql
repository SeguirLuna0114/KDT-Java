-- 2023. 11. 21 (ȭ)

-- ���� aws ���� ����
-- userid : mypage, passwd : mypage123
-- ������Ʈ�� user�� schema�� ������ ����(�ڵ� �ۼ��ϱ� ����)

-- ���� ������ ���� ���� IP ������ �������� ����
conn system/system
-- ���ο� ���� ����
CREATE USER mypage IDENTIFIED BY mypage123;

-- ������ ������ ���� �ο�
GRANT CONNECT, RESOURCE TO mypage;
    -- ���� proj�������� ���� ����
    
-- Oracle SQL���� mypage���� ����ص�

-- [����] -> [�����ͺ��̽� ����]�� ���� music�� �����͸� ��� mypage�� ����

