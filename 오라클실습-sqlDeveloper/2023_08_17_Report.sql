-- 2023.08.17 ����

-- Q1. ������̺�(emp)���� �Ի����� 4�ڸ� ������ ��µǵ��� SQL���� �ۼ�
SELECT '19' || to_char(hiredate) FROM emp;

-- Q2. ������̺�(emp)���� MGR�÷��� ���� null�� �������� MGR�� ���� CEO�� ����ϴ� SWL��
SELECT ename,job, sal, NVL(to_char(mgr), 'CEO') AS "mgr" FROM emp;


