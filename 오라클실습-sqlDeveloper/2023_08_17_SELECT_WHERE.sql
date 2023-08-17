-- 2023.08.17(��)

-- # �� ������: and, or, not
-- 1. AND ������: �� ���ǽ��� ��� �����ϴ� �����͸� �˻�
-- Q1. ��� ���̺��� �μ���ȣ�� 10���̰�, job�� MANAGER�� ����� �˻��ϴ� SQL��
SELECT * FROM emp WHERE deptno = 10 AND job = 'MANAGER';

-- Q2. �޿��� 2000���� 3000 ������ �޿��� �޴� ����� �˻��ϴ� SQL��
SELECT * FROM emp WHERE sal >= 2000 AND sal <= 3000;


-- 2. OR ������: �� ���ǽ� �߿��� �Ѱ����� �����ص� �˻�
-- Q1. ��� ���̺��� �μ���ȣ�� 10�̰ų�, job�� MANAGER�� ����� �˻��ϴ� SQL��
SELECT * FROM emp WHERE deptno=10 OR job = 'MANAGER';

-- Q2. Ŀ�̼��� 300�̰ų� 500 �̰ų� 1400�� ����� �˻��ϴ� SQL��
SELECT * FROM emp WHERE comm =300 OR comm=500 OR comm=1400;

-- Q3. �����ȣ�� 7521�̰ų� 7654�̰ų� 7844�� ����� �˻��ϴ� SQL��
SELECT * FROM emp WHERE empno=7521 OR empno=7654 OR empno=7844;


-- 3. NOT ������: ������ �ݴ�� �ٲ��ִ� ����
-- Q. �μ���ȣ�� 10�� �ƴ� ����� �˻��ϴ� SQL��
SELECT * FROM emp WHERE NOT deptno = 10;        -- ��������

SELECT * FROM emp WHERE deptno != 10;           -- �񱳿�����
SELECT * FROM emp WHERE deptno ^= 10;           -- �񱳿�����
SELECT * FROM emp WHERE deptno <> 10;           -- �񱳿�����



-- �� ������2: BETWEEN A AND B, IN(list), LIKE, IS NULL
-- 1. BETWEEN A AND B ������: ������ ���� ������ �ִ� ��쿡 ���
    -- ����) WHERE �÷��� BETWEEN ������ AND ū��
-- Q1. �޿��� 2000���� 3000 ������ �޿��� �޴� ����� �˻��ϴ� SQL��
SELECT * FROM emp WHERE sal BETWEEN 2000 AND 3000;
--SELECT * FROM emp WHERE sal BETWEEN 3000 AND 2000;      -- �˻���� ����

SELECT * FROM emp WHERE sal >= 2000 AND sal <= 3000;    -- �������� AND

-- Q2. �޿��� 2000�̸��̰ų� 3000 �ʰ��� ����� �˻��ϴ� SQL��
SELECT * FROM emp WHERE sal NOT BETWEEN 2000 AND 3000;

SELECT * FROM emp WHERE sal < 2000 OR sal >3000;        -- �������� OR

-- Q3. 1987�⵵�� �Ի��� ����� �˻��ϴ� SQL��
SELECT * FROM emp WHERE hiredate BETWEEN '87/01/01' AND '87/12/31';

SELECT * FROM emp WHERE hiredate >= '87/01/01' AND hiredate <= '87/12/31';  -- �������� AND


-- 2. IN ������: OR�����ڸ� ����ؼ� ǥ���� �� ����
    -- ����) WHERE �÷��� IN (������1, ������2, ...)
-- Q1. Ŀ�̼��� 300�̰ų� 500 �̰ų� 1400�� ����� �˻��ϴ� SQL��
SELECT * FROM emp WHERE comm IN (300, 500, 1400);

SELECT * FROM emp WHERE comm =300 OR comm=500 OR comm=1400;     -- �������� OR

-- Q2. Ŀ�̼��� 300, 500, 1400�� �ƴ� ����� �˻��ϴ� SQL��
SELECT * FROM emp WHERE comm NOT IN (300, 500, 1400);

SELECT * FROM emp WHERE comm !=300 AND comm!=500 AND comm!=1400;     -- �������� AND

-- Q3. �����ȣ�� 7521�̰ų� 7654�̰ų� 7844�� ����� �˻��ϴ� SQL��
SELECT * FROM emp WHERE empno IN (7521, 7654, 7844);

SELECT * FROM emp WHERE empno=7521 OR empno=7654 OR empno=7844;        -- �������� OR


-- 3. Like������ & ���ϵ�ī��(%, _)
    -- ����) WHERE �÷��� LIKE pattern(���ϵ�ī�� ���� ���)
    -- ���ϵ�ī��
    --  1) %: ���ڰ� �ϳ��� ���ų�, �ϳ� �̻��� ���ڿ� � ���� �͵� ��� ����
    --  2) _: �ϳ��� ���ڿ� � ���� �͵� ��� ����   
--- % ���ϵ�ī�� ���
-- Q1. ��� ���̺��� ������� F�� �����ϴ� ����� �˻��ϴ� SQL��
SELECT * FROM emp WHERE ename LIKE 'F%';    -- F�� �����ϴ� ��� �˻�
SELECT * FROM emp WHERE ename = 'FORD';     -- FORD����� �˻���

-- Q2. ��� ���̺��� ������� N���� ������ ����� �˻��ϴ� SQL��
SELECT * FROM emp WHERE ename LIKE '%N';

-- Q3. ��� ���̺��� ������� A�� �����ϴ� ����� �˻��ϴ� SQL��
SELECT * FROM emp WHERE ename LIKE '%A%';

--- _(�����) ���ϵ�ī�� ���
-- Q1. ��� �̸��� �ι�° ��¥�� A�� ����� �˻��ϴ� SQL��
SELECT * FROM emp WHERE ename LIKE '_A%';   -- �ι�° ���ڰ� A�� ����

-- Q2. ��� �̸��� ����° ���ڰ� A�� ����� �˻��ϴ� SQL��
SELECT * FROM emp WHERE ename LIKE '__A%';

-- Q3. ����� A�� ���ԵǾ� ���� ���� ����� �˻��ϴ� SQL�� 
SELECT * FROM emp WHERE ename NOT LIKE '%A%';


-- 4. IS NULL ������: Ư�� �÷� ���� NULL�� ���� �˻��ϴ� �� ���
    -- NULL��: ���� �������� ������ ��Ÿ���� ����   
-- Q1. MGR�÷��� NULL���� �����͸� �˻�
SELECT * FROM emp where mgr IS NULL;

    -- = �� != ���� �Ϲ����� �� �����ڴ� NULL ���� ����� �۵�X
    -- =''(�� ���ڿ�)�� Null���� �������� ����(�� ���ڿ��� ��������, NULL�� ���� ������ ��Ÿ��)
SELECT * FROM emp where mgr = NULL;     -- �˻��ȵ�
SELECT * FROM emp where mgr = '';       -- �˻��ȵ�

-- Q2. MGR�÷��� NULL���� �ƴ� �����͸� �˻�
SELECT * FROM emp where mgr IS NOT NULL;

-- Q3. COMM �÷��� NULL���� �����͸� �˻�
SELECT * FROM emp where comm IS NULL;
SELECT COUNT(*) FROM emp WHERE comm IS NULL;

-- Q4. COMM �÷��� NULL���� �ƴ� �����͸� �˻�
SELECT * FROM emp where comm IS NOT NULL;


