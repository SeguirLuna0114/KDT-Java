-- 2018. 08. 21(��)

-- ANSI JOIN
-- ANSI(�̱� ǥ����ȸ) ǥ�ؾȿ� ���� ������� join���

-- ANSI CROSS JOIN
SELECT * FROM dept CROSS JOIN emp;  -- 4 * 14 = 56�� ������ �˻�
SELECT * FROM emp CROSS JOIN dept;  -- 14 * 4 = 56�� ������ �˻�

-- ANSI INNER JOIN: � ���ΰ� ���� �ǹ̸� ���� ���ι��
-- Q. SCOTT ����� �Ҽӵ� �μ����� ����ϴ� SQL���� ANSI INNER JOIN���� �ۼ�]
SELECT ename, dname FROM dept 
INNER JOIN emp ON dept.deptno = emp.deptno
WHERE ename = 'SCOTT';

-- using���� �̿��ؼ� ����
SELECT ename, dname FROM dept 
INNER JOIN emp USING(deptno)
WHERE ename = 'SCOTT';

-- ANSI NATURAL JOIN
-- DEPT�� EMP ���̺� ������ ���� �÷��� ���ٴ� �ǹ�
SELECT ename, dname FROM dept 
NATURAL JOIN emp
WHERE ename = 'SCOTT';

-- ANSI OUTER JOIN
-- ����: select * from table [left/right/full] outer join table2;

-- 1. dept01 ���̺� ����
CREATE TABLE dept01 ( deptno NUMBER(2), dname VARCHAR2(14) );

INSERT INTO dept01 VALUES(10, 'ACCOUNTING');
INSERT INTO dept01 VALUES(20, 'RESEARCH');

SELECT * FROM dept01;

-- 2. dept02���̺� ����
CREATE TABLE dept02 ( deptno NUMBER(2), dname VARCHAR2(14) );

INSERT INTO dept02 VALUES(10, 'ACCOUNTING');
INSERT INTO dept02 VALUES(30, 'SALES');

SELECT * FROM dept02;

-- 3. LEFT OUTER JOIN
    -- ON ������ ���
SELECT * 
FROM dept01
LEFT OUTER JOIN dept02 ON dept01.deptno = dept02.deptno;
    -- Using�� ���
SELECT * 
FROM dept01
LEFT OUTER JOIN dept02 USING(deptno);

-- 4. RIGHT OUTER JOIN
    -- ON ������ ���
SELECT * 
FROM dept01
RIGHT OUTER JOIN dept02 ON dept01.deptno = dept02.deptno;
    -- Using�� ���
SELECT * 
FROM dept01
RIGHT OUTER JOIN dept02 USING(deptno);

-- 5. FULL OUTER JOIN
    -- ON ������ ���
SELECT *
FROM dept01 d1
FULL OUTER JOIN dept02 d2 ON d1.deptno = d2.deptno;
    -- Using�� ���
SELECT * 
FROM dept01
FULL OUTER JOIN dept02 USING(deptno);





