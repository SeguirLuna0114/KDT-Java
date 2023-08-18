-- 2023. 08. 18
SELECT * FROM emp;
-- Q1.��� ���̺�(emp)���� ���� �ֱٿ� �Ի��� ������� ����ϴ� SQL��
    -- �������� (SELECT MAX(hiredate) FROM emp)�� emp ���̺��� ���� �ֱٿ� �Ի��� ���� ã��,
    -- �ٱ��� ���������� ���� �ֱٿ� �Ի��� �����(ename)�� �Ի����� ����
SELECT ename, hiredate FROM emp WHERE hiredate = (SELECT MAX(hiredate) FROM emp);

    -- �����Ͽ� ��°��� �´��� Ȯ��
SELECT ename, hiredate FROM emp order by hiredate DESC;


-- Q2. ��� ���̺�(emp)���� �ִ� �޿��� �޴� ������, �ִ� �޿� �ݾ��� ����ϴ� SQL��
    --  �������� (SELECT MAX(sal) FROM emp)�� emp ���̺��� �ִ� �޿� ���� ã��, 
    --  �ٱ��� ���������� �� �ִ� �޿��� �޴� ������ �̸�(ename)�� �޿�(sal)�� ����
SELECT ename, sal FROM emp WHERE sal = (SELECT MAX(sal) FROM emp);

    -- �����Ͽ� ��°��� �´��� Ȯ��
SELECT ename, sal FROM emp order by sal DESC;




