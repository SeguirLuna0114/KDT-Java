-- 2023. 08. 22(ȭ)

SELECT * FROM emp;

-- Q1.SMITH�� ������ ������ ���� ����� �̸��� ������ ����ϴ� SQL��
SELECT ename, job
FROM emp
WHERE job = (SELECT job FROM emp WHERE ename = 'SMITH');


-- Q2. ������ 'SALESMAN'�� ����� �޴� �޿����� �ִ� �޿����� ���� �޴� 
--      ������� �̸��� �޿��� ����ϵ�, �μ���ȣ�� 20���� ����� ����(ALL ������ �̿�)
SELECT ename, sal
FROM emp
WHERE sal > ALL (SELECT sal FROM emp WHERE job = 'SALESMAN')
AND deptno != 20;


-- Q3. ������ 'SALESMAN'�� ����� �޴� �޿����� �ּ� �޿����� ���̹޴� �������
--      �̸��� �޿��� ����ϵ�, �μ���ȣ�� 20���� ����� ����(ANY������ �̿�)
SELECT ename, sal, deptno
FROM emp
WHERE sal > ANY (SELECT sal FROM emp WHERE job = 'SALESMAN')
AND deptno != 20;

