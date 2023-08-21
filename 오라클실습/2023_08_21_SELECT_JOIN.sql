-- 2018. 08. 21(��)

-- JOIN(����)
-- : 2�� �̻��� ���̺��� �����ؼ� ������ ���ؿ��� ��

-- JOIN �ʿ伺
--  1. JOIN���� �ʴ� ��� 2���� SQL���� �ۼ��ؾ� ��
    -- Q. SCOTT ����� �Ҽӵ� �μ����� ����ϴ� SQL��
    -- 1) ��� ���̺�(emp)���� SCOTT����� �μ���ȣ�� ����
    SELECT deptno FROM emp WHERE ename = 'SCOTT';       -- 20
    -- 2) �μ� ���̺�(DEPT)���� 20�� �μ��� �μ����� ����
    SELECT  dname FROM dept WHERE deptno = 20;          -- RESEARCH

-- # CROSS JOIN
SELECT * FROM dept, emp;            -- 4*14= 56���� ������ �˻�
SELECT * FROM emp, dept;            -- 14*4= 56���� ������ �˻�

    -- CROSS JOIN�� ����
    -- 1) �����(EquiJoin)
    -- 2) ������(Non-EquiJoin)
    -- 3) ��ü����(Self Join)
    -- 4) �ܺ�����(Outer Join)
    
-- 1. �����(EquiJoin)
--    : 2���� ���̺� ������ �÷��� �������� �����ϴ� ��.
    -- "dept" ���̺�� "emp" ���̺� ���� "deptno" ���� �������� EquiJoin�� ����
SELECT * FROM dept, emp WHERE dept.deptno = emp.deptno;     -- 14�� ������ �˻�

-- Q. SCOTT����� �Ҽӵ� �μ����� ����ϴ� SQL�� with JOIN ���
SELECT ename, dname FROM dept, emp
        WHERE dept.deptno = emp.deptno AND ename = 'SCOTT';
        -- JOIN�� ���� �÷��� deptno�÷��� ����ϸ� ���� �߻�(column ambiguously defined)
SELECT deptno, ename, dname FROM dept, emp
        WHERE dept.deptno = emp.deptno AND ename = 'SCOTT';     -- ���� �߻�
        -- �����÷��� "���̺��.�����÷���" �������� ����ؾ� ��
        -- �����÷��� �ƴ� �÷����� �տ� ���̺�� ���� ����
SELECT emp.deptno, ename, dname FROM dept, emp
        WHERE dept.deptno = emp.deptno AND ename = 'SCOTT';        
SELECT dept.deptno, ename, dname FROM dept, emp
        WHERE dept.deptno = emp.deptno AND ename = 'SCOTT'; 
        
SELECT dept.deptno, emp.ename, dept.dname FROM dept, emp
        WHERE dept.deptno = emp.deptno AND emp.ename = 'SCOTT';        
        
-- ���̺� ��Ī �ο��ϱ�
-- 1) ���̺� ���� ��Ī�� �ο��� ���� ���ʹ� ���̺���� ����� �� ����, ��Ī���� ����ؾ� ��
-- 2) ��Ī���� ��.�ҹ��ڸ� �������� ����
-- 3) �����÷��� ��Ī��.�����÷� �������� ����ؾ� ��
--    ex) d.deptno, e.deptno
-- 4) �����÷��� �ƴ� �÷����� �տ� ��Ī���� ������ �� ����

-- ���̺�� ��Ī �ο�
SELECT d.deptno, e.ename, d.dname FROM dept d, emp e
    WHERE d.deptno=e.deptno AND e.ename='SCOTT';
    -- ��Ī���� ��ҹ��� ����X
SELECT d.deptno, e.ename, d.dname FROM dept "D", emp "E"
    WHERE d.deptno=e.deptno AND e.ename='SCOTT';
    -- �Ϲ� �÷��� �÷��� �տ� ��Ī�� ���� ����
SELECT d.deptno, ename, dname FROM dept d, emp e
    WHERE d.deptno=e.deptno AND e.ename='SCOTT';

    -- JOIN�� ��������� ����� ���
    SELECT d.deptno, e.ename, d.dname
    FROM emp e
    JOIN dept d ON e.deptno = d.deptno
    WHERE e.ename = 'SCOTT';


-- 2. ������(Non-EquiJoin)
SELECT sal FROM emp;
SELECT * FROM salgrade;
--1	700	1200
--2	1201	1400
--3	1401	2000
--4	2001	3000
--5	3001	9999

-- Q. �� ������� �޿� ���
SELECT ename, sal, grade FROM emp, salgrade
    WHERE sal >= losal AND sal <= hisal;
    
    -- 'BETWEEN ������ AND ū��' ������ ���
    SELECT ename, sal, grade FROM emp, salgrade
    WHERE sal BETWEEN losal AND hisal;
    
    
-- 3. ��ü����(Self Join)
--    : �Ѱ��� ���̺� ������ �÷��� �÷������� ���踦 �̿��� ����
-- Q. ��ü����(Self Join)�� �̿��ؼ� ��� ���̺��� �� ������� ������ 
--    �Ŵ���(���ӻ��)�� ����ϴ� SQL��
--      EMP(empno)  -  EMP(mgr)
SELECT employee.ename || '�� ���� ' ||  manager.ename
FROM emp employee, emp manager
WHERE employee.mgr = manager.empno;
        
        
-- 4. �ܺ�����(Outer Join)
--    : ���� ������ �������� �ʴ� �����͸� ����ϴ� ����
--  1) ���̺��� ������ �� ��� ������ ���̺��� �����Ͱ� ����������, �ٸ� ���̺�
--     �����Ͱ� �������� ���� ��쿡, �� �����Ͱ� ��µ��� �ʴ� ������ �ذ��ϱ� ���� ���
--  2) ������ ������ ���� (+)�� �߰���

-- Q1. ���� ��ü����(Self Join)�� ���, KING����� ���ӻ�簡 ���� ������
--     ��µ��� �ʾҴµ�, KING����� �ܺ������� ����� ���
SELECT employee.ename || '�� ���� ' || manager.ename
FROM emp employee, emp manager
WHERE employee.mgr = manager.empno(+);

-- Q2. �μ����̺�(DEPT)�� ������̺�(EMP)�� ������ϸ� 40�� �μ��� ��Ÿ���� �ʱ⶧����,
--     �ܺ������� �̿��ؼ� 40�� �μ��� ��Ÿ������ ó��
    -- 1) DEPT - EMP ���̺� ����ν�, 40�� �μ��� ��µ��� ����
SELECT d.deptno, ename, dname FROM dept d, emp e
WHERE d.deptno = e.deptno ORDER BY deptno ASC; 
    -- 2) �ܺ�����: ��µ��� �ʴ� 40�� �μ��� ���
SELECT d.deptno, ename, dname
FROM dept d, emp e
WHERE d.deptno = e.deptno(+)        -- dept ���̺��� �������� LEFT OUTER JOIN
ORDER BY deptno ASC;
        -- "dept" ���̺�� "emp" ���̺� LEFT OUTER JOIN
        SELECT d.deptno, ename, dname
        FROM dept d
        LEFT OUTER JOIN emp e ON d.deptno = e.deptno
        ORDER BY deptno ASC;
        
                -- "dept" ���̺�� "emp" ���̺� RIGHT OUTER JOIN
        SELECT d.deptno, ename, dname
        FROM emp e
        RIGHT OUTER JOIN dept d ON d.deptno = e.deptno
        ORDER BY deptno ASC;


