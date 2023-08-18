-- 2023. 08. 18

-- Group By �� : Ư�� �÷��� �������� ���̺� �����ϴ� �����͸� 
--               �׷����� �����Ͽ� ó���ϴ� ���� ����
--    1. �Ϲ��÷��� �׷��Լ��� ���� ����� �� ������, 
--       ���������� Group By���� ���Ǵ� �÷��� �׷��Լ��� ���� ��� ����

-- Q. �� �μ�(10, 20, 30)�� �޿� ��, ��ձ޿�, �ִ�޿�, �ּұ޿��� ���ϴ� SQL��
SELECT SUM(sal), AVG(sal), MAX(sal), MIN(sal) from emp WHERE deptno = 10;
SELECT SUM(sal), AVG(sal), MAX(sal), MIN(sal) from emp WHERE deptno = 20;
SELECT SUM(sal), AVG(sal), MAX(sal), MIN(sal) from emp WHERE deptno = 30;

--  �Ϲ��÷��� �׷��Լ��� ���� ����� �� ������, 
--  ���������� Group By���� ���Ǵ� �÷��� �׷��Լ��� ���� ��� ����
SELECT deptno, SUM(sal), AVG(sal), MAX(sal), MIN(sal) FROM emp
    GROUP BY deptno ORDER BY deptno ASC;
    
-- Q1. job�÷��� �������� �޿��� ��, ��ձ޿�, �ִ�޿�, �ּұ޿��� ���ϴ� SQL��
SELECT job, SUM(sal), AVG(sal), MAX(sal), MIN(sal) FROM emp
    GROUP BY job;

SELECT SUM(sal), AVG(sal), MAX(sal), MIN(sal), job FROM emp
    GROUP BY job;   -- ���� �����Լ�(��) ������ �ٲ� ���X
    
-- Q2. �� �μ���(10, 20, 30) ������� Ŀ�̼��� �޴� ������� ���ϴ� SQL��
SELECT deptno, count(*) AS �����, COUNT(comm) AS Ŀ�̼� FROM emp
    GROUP BY deptno ORDER BY deptno ASC;

SELECT DECODE(deptno, 10, '�μ�1', 20, '�μ�2', 30, '�μ�3'),
        count(*) AS �����, COUNT(comm) AS Ŀ�̼�
FROM emp
GROUP BY deptno;
