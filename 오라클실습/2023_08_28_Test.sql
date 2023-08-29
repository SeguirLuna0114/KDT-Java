-- 2023. 08. 28(��)

-- Q1. ��� ���̺�(EMP)����  SCOTT�� �޿����� ���� �޴� ����� �̸�, �޿��� ����ϴ� SQL���� �ۼ�
SELECT ename, sal
FROM emp
WHERE sal < (SELECT sal FROM emp WHERE ename = 'SCOTT');


-- Q2. ��� ���̺�(EMP)���� �� �μ��� ��� �޿��� ���ϴ� SQL��
SELECT deptno, AVG(sal)
FROM emp
GROUP BY deptno;


-- Q3. ������̺�(EMP)����  ����� A�� ���Ե� ����� �˻��ϴ� SQL��
SELECT ename
FROM emp
WHERE ename LIKE '%A%';


-- Q4. ������̺�(EMP)���� �޿��� ���� �޴� ���  5���� ���ϴ� SQL���� �ζ��κ�� �ۼ�
SELECT ROWNUM, emp_inline.*
FROM (
        SELECT ename, sal
        FROM emp
        ORDER BY sal DESC
) emp_inline
WHERE ROWNUM < 6;

-- ����� ���
SELECT ROWNUM, emp_inline.ename
FROM (
        SELECT ename, sal
        FROM emp
        ORDER BY sal DESC
) emp_inline
WHERE ROWNUM < 6;


-- Q5. ������̺�(EMP)���� 82�⵵�� �Ի��� ��� ����� ������ ����ϴ� SQL��
SELECT *
FROM emp
WHERE hiredate BETWEEN '82/01/01' AND '82/12/31';


-- Q6. ������̺�(EMP)���� ���, �̸�, �޿�, ������ ��ȸ�ϴ� SQL����
SELECT empno, ename, sal, sal*12 + NVL(comm, 0) AS annual 
FROM emp;


-- Q7. SQL���� ���� �ۼ�
-- 1) �Ʒ��� ������ ����ǿ� �Ի��� ���Ի������ ���ο� ������ ����
    -- (������ : myuser ,  ��й�ȣ : tiger)
conn system/oracle  -- �ý��� �������� ����
CREATE USER myuser IDENTIFIED BY tiger;

-- 2) ������ �������� ������ ���� �� ���̺�, �並 ������ �� �ִ� ������ 
    -- ���� ��(role)�� �����ؼ� ������ �ο�
-- �ý��� �������� ����
conn system/oracle
-- ����� ���� �� ����
CREATE ROLE my_role;

-- ������ �ѿ� �ý��� ������ �ο�
GRANT CREATE SESSION, CREATE TABLE, CREATE VIEW TO my_role;

-- ������ ����(myuser)���� ������ �� �Ҵ�
GRANT my_role TO myuser;

-- myuser �������� �����Ͽ� ���� ���
conn myuser


-- Q8. ���������� �����ϴ� ���̺��� ���� �ۼ�
-- book ���̺�
CREATE TABLE book (
    bookid NUMBER(2) PRIMARY KEY,
    bookname VARCHAR2(40),
    publisher VARCHAR2(40),
    price NUMBER(8) );
    
-- customer ���̺�
CREATE TABLE customer (
    custid NUMBER(2) PRIMARY KEY,
    name VARCHAR2(40),
    address VARCHAR2(50),
    phone VARCHAR2(20) );
    
-- Orders ���̺�
CREATE TABLE orders (
    orderid NUMBER(2) PRIMARY KEY,
    custid NUMBER(2) REFERENCES customer(custid),
    bookid NUMBER(2) REFERENCES book(bookid),
    saleprice NUMBER(8),
    orderdate DATE  );
