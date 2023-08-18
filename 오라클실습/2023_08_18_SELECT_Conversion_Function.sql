-- 2023. 08. 18

-- * �� ��ȯ �Լ�(Conversion Function)
--  : to_char(), to_date(), to_number()

-- 1. to_char() : ��¥��, ������ �����͸� ���������� ��ȯ���ִ� �Լ�
--  1) ��¥�� �����͸� ���������� ��ȯ
--      ����: to_char(��¥ ������, '�������')
-- Q1. ���� �ý����� ��¥�� ��, ��, ��, ��, ��, ��, ���Ϸ� ���
SELECT sysdate FROM dual;       -- ����ð�(23/08/18)

SELECT to_char(sysdate, 'YYYY-MM-DD HH:MI:SS DAY') FROM dual;
SELECT to_char(sysdate, 'YYYY-MM-DD HH:MI:SS DY') FROM dual;
SELECT to_char(sysdate, 'yyyy-mm-dd hh:mi:ss day') FROM dual;   -- ��ҹ��� ����X

-- Q2. ��� ���̺��� �� ������� �Ի����� ��, ��, ��, ��, ��, ��, ���Ϸ� ����ϴ� SQL��
SELECT ename, to_char(hiredate, 'YYYY-MM-DD HH24:MI:SS DAY') FROM emp;
SELECT ename, to_char(hiredate, 'YYYY-MM-DD HH24:MI:SS DAY') FROM emp;
SELECT ename, to_char(hiredate, 'YYYY"�� "MM"�� "DD"�� "HH24"�� "MI"��" SS"��" DAY') FROM emp;

--  2) ������ �����͸� ���������� ��ȯ
-- ����: to_char(���� ������, '���б�ȣ')
-- Q1. ���� 1230000�� 3�ڸ��� �ĸ��� �����ؼ� ���
SELECT to_char(1230000, '0,999,999') FROM dual;
    -- 0���� �ڸ����� �����ϸ�, �������� ���̰� 9�ڸ��� ���� ������ 0���� ä��
SELECT 1230000, to_char(1230000, '000,000,000') FROM dual;      --  001,230,000
    -- 9�� �ڸ����� �����ϸ�, �������� ���̰� 9�ڸ��� ���� �ʾƵ� ä���� ����
SELECT 1230000, to_char(1230000, '999,999,999') FROM dual;      --    1,230,000

-- Q2. ��� ���̺��� �� ������� �޿��� 3�ڸ��� �ĸ�(,)�� �����ؼ� ����ϴ� SQL��
SELECT ename, sal, to_char(sal, '9,999') FROM emp;
    -- 'L'�� ����ؼ� �� ������ ��ȭ��ȣ�� ��Ÿ��(��/�� ����)
SELECT ename, sal, to_char(sal, 'L9,999') FROM emp;
SELECT ename, sal, to_char(sal, '9,999L') FROM emp;


-- 2. to_date() : ������ �����͸� ��¥������ ��ȯ���ִ� �Լ�
-- ����: to_date('���ڵ�����', '��¥ format')
-- Q1. 2023�� 1�� 1�Ϻ��� ������� ����� �ϼ��� ���ϴ� SQL��
    -- �����߻�(��¥�����Ϳ� ���ڵ����� ������ �Ұ�)
SELECT sysdate - '2023/01/01' FROM dual;    
    -- to_date�Լ��� ���ڵ����� -> ��¥������ ��ȯ�Ͽ� ���� ����
SELECT sysdate - to_date('2023/01/01', 'yyyy/mm/dd') FROM dual;
    -- ROUND �Լ��� ���ڸ� �ݿø��Ͽ� ������ �Ҽ� �ڸ������� ǥ��
SELECT round(sysdate - to_date('2023/01/01', 'yyyy/mm/dd')) FROM dual;
    -- TRUNC �Լ��� �Ҽ��� �Ʒ��� ������ �Լ�
SELECT trunc(sysdate - to_date('2023/01/01', 'yyyy/mm/dd')) FROM dual;

-- Q2. 2023�� 12�� 25�� ũ������������ ���� �ϼ��� ���ϴ� SQL�� �ۼ�
SELECT to_date('2023/12/25', 'yyyy/mm/dd') - sysdate FROM dual;
    -- ROUND �Լ��� ���ڸ� �ݿø��Ͽ� ������ �Ҽ� �ڸ������� ǥ��
SELECT round(to_date('2023/12/25', 'yyyy/mm/dd') - sysdate) FROM dual;
    -- TRUNC �Լ��� �Ҽ��� �Ʒ��� ������ �Լ�
SELECT trunc(to_date('2023/12/25', 'yyyy/mm/dd') - sysdate) FROM dual;

-- Q3. �츮 ���� �����Ⱓ(2023.07.11 ~ 2024.01.19)�� �ϼ��� ���ϴ� SQL��
SELECT to_date('2024.01.19', 'yyyy/mm/dd') - to_date('2023.07.11', 'yyyy/mm/dd') FROM dual;
SELECT (to_date('2024.01.19', 'yyyy/mm/dd') - to_date('2023.07.11', 'yyyy/mm/dd')) || '��' FROM dual;

    -- ���ڿ� -> ��¥������ ��ȯ -> 'J'�� �̿��� ��¥�����͸� ���������� ���ڿ��� ��ȯ => concat|| ����
SELECT TO_CHAR(TO_DATE('2024.01.19', 'YYYY/MM/DD'), 'J')-TO_CHAR(TO_DATE('2023.07.11', 'YYYY/MM/DD'), 'J') || '��' FROM DUAL;


-- 3. to_number(): ������ �����͸� ������ �����ͷ� ��ȯ���ִ� �Լ�
--    ���� : to_number('���ڵ�����', '���б�ȣ')
    -- ���� �߻�: ���ڿ� ������ ��� ������ ����X
SELECT '20,000' - '10,000' FROM dual;
    -- ���ڿ��� ���ڷ� ��ȯ�� ��, ������� ����
SELECT to_number('20,000', '99,999') - to_number('10,000', '99,999') FROM dual;



