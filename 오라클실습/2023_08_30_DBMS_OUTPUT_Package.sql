-- 2023. 08. 30 (��)

-- DBMS_OUTPUT ��Ű��
    -- ��Ű������ ���������� ���õ� ���ν����� �Լ����� ����
    -- DBMS_"�� �����ϴ� ��ü �̸��� ���� ��Ű������ �̸��� ����
SELECT object_name FROM dba_objects
WHERE object_type = 'PACKAGE'
AND object_name LIKE 'DBMS_%'
ORDER BY object_name;
    -- dba_objects �ý��� �� : �����ͺ��̽� ���� ��� ��ü�� ���� ������ �����ϰ� �ִ� ��
--                  - �����ͺ��̽� ���� �پ��� ��ü(���̺�, ��, �ε���, ���ν��� ��)�� ���� ��Ÿ�����͸� Ȯ��