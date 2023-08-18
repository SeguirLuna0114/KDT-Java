-- 2023.08.17 ����
SELECT * FROM emp;
-- empno , ename, job, mgr, hiredate, sal, comm, deptno

-- Q1. ������̺�(emp)���� �Ի����� 4�ڸ� ������ ��µǵ��� SQL���� �ۼ�
    -- '19' ���ڿ��� "hiredate" �÷��� ��¥ ���� �����Ͽ� �ϳ��� ���ڿ��� ����
SELECT '19' || to_char(hiredate) FROM emp;
    -- "hiredate" �÷��� ��¥ ���� 'YYYY/MM/DD' �������� ��ȯ
SELECT to_char(hiredate, 'YYYY/MM/DD') FROM emp;

-- Q2. ������̺�(emp)���� MGR�÷��� ���� null�� �������� MGR�� ���� CEO�� ����ϴ� SWL��
SELECT * FROM emp WHERE mgr IS NULL;

    -- NVL�Լ��� to_char�Լ��� �����Ͽ� mgr�÷��� ���ڿ��� ��ȯ -> ���� NULL�� ��� CEO�� ��ü
SELECT ename, NVL(to_char(mgr), 'CEO') AS "mgr" FROM emp;
    -- NVL �Լ��� to_char �Լ��� �����Ͽ� "mgr" �÷��� ���ڸ� 4�ڸ� ���ڿ��� ��ȯ -> NULL�� ��쿡�� 'CEO'�� ��ü
SELECT ename, NVL(to_char(mgr, '9999'), 'CEO') AS MANAGER FROM emp WHERE mgr IS NULL;

    -- mgr�� ���ڰ� ����� NUMBERŸ���̳�, 'CEO'�� ���ڿ��̱⿡, NVL��ȯ�� �Ұ�
SELECT nvl(mgr, 'CEO') FROM emp;        -- ����

