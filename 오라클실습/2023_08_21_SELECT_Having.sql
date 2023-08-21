-- 2023. 08. 21

-- Having ������
--  : Group By ���� ���Ǵ� ��쿡, ������ ������ ���ϱ� ���ؼ� where������ ���,
--    having �������� ����ؾ� ��

-- Q1. �μ���(10, 20, 30) ��ձ޿� �ݾ��� 2000�̻��� �μ��� ����ϴ� SQL��
-- 1) �� �μ��� ��ձ޿� �ݾ� ���
SELECT deptno, AVG(sal) FROM emp GROUP BY deptno;
-- 30	1566.666666666666666666666666666666666667
-- 20	2175
-- 10	2916.666666666666666666666666666666666667

-- 2) ��� �޿� �ݾ��� 2000�̻��� �μ��� ���
    -- �׷��Լ��� WHERE���� �ü� ���� => ���� �߻�
SELECT deptno, avg(sal) FROM emp GROUP BY deptno
        WHERE AVG(sal) >= 2000;         -- ���� �߻�      
    -- group by���� ���Ǵ� ��쿡�� having �������� ����Ͽ� �׷��Լ��� �������� ����
SELECT deptno, avg(sal) FROM emp GROUP BY deptno
        HAVING AVG(sal) >= 2000;
        
-- Q2. �� �μ���(10, 20, 30) �ִ�޿� �ݾ��� 2900 �̻��� �μ��� ����ϴ� SQL��
-- 1) �� �μ��� �ִ�ݾ��� ���
SELECT deptno, MAX(sal) FROM emp GROUP by deptno;
-- 30	2850
-- 20	3000
-- 10	5000

-- 2) �ִ� �޿� �ݾ��� 2900 �̻��� �μ��� ���
    -- �׷��Լ��� WHERE���� �ü� ���� => ���� �߻�
SELECT deptno, MAX(sal) FROM emp GROUP by deptno
        WHERE MAX(sal) >= 2900;     -- ���� �߻�
    -- group by���� ���Ǵ� ��쿡�� having �������� ����ؾ� ��
SELECT deptno, MAX(sal) FROM emp GROUP by deptno
        HAVING MAX(sal) >= 2900;  




