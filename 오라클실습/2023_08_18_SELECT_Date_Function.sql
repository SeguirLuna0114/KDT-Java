-- 2023.08.18

-- 3. ��¥ ó�� �Լ�(Date Function)
-- sysdate : ���� �ý��� ��¥�� �ð��� ��ȯ�ϴ� �Լ�
SELECT sysdate FROM dual;           -- 23/08/18

SELECT sysdate-1 ����, sysdate ����, sysdate ���� FROM dual;
--          23/08/17	23/08/18	23/08/18

-- Q. ��� ���̺��� �� ������� ������� �ٹ��� �ٹ��ϼ��� ���ϴ� SQL��
SELECT ename, sysdate - hiredate from emp;
    -- round()�Լ��� ����� �Ҽ��� ù°�ڸ����� �ݿø� => ���� ��ȯ
SELECT ename, round(sysdate - hiredate) FROM emp;       
    -- trunc()�Լ��� ����� �Ҽ��� �Ʒ��� ����
SELECT ename, trunc(sysdate - hiredate) FROM emp;

-- months_between(): �� ��¥ ������ ����� �������� �����ִ� �Լ�
-- ���� :  months_between(date1, date2)
-- Q. ��� ���̺��� �� ������� �ٹ��� �������� ���ϴ� SQL��
SELECT months_between(sysdate, hiredate) FROM emp;  -- ��� ������ ���
SELECT months_between(hiredate, sysdate) FROM emp;  -- ���� ������ ���
SELECT MONTHS_BETWEEN('2023-08-01', '2023-04-01') AS months_diff FROM dual;

    -- round()�Լ��� ����� �Ҽ��� ù°�ڸ����� �ݿø� => ���� ��ȯ
SELECT round(months_between(sysdate, hiredate)) FROM emp;
    -- trunc()�Լ��� ����� �Ҽ��� �Ʒ��� ����
SELECT trunc(months_between(sysdate, hiredate)) FROM emp;


-- add_months() : Ư�� ��¥�� ����� ��¥�� �����ִ� �Լ�
-- ����: add_months(date, ������)
-- Q1. ��� ���̺��� �� ������� �Ի��� ��¥�� 6������ ����� ���ڸ� ���ϴ� SQL��
SELECT ename, hiredate, add_months(hiredate, 6) FROM emp;

-- Q2. �츮���� �԰��Ŀ� 6������ ����� ���ڸ� ���ϴ� SQL��
SELECT add_months('23/07/11', 6) FROM dual;         -- 24/01/11


-- next_day() : �ش� ������ ���� ����� ��¥�� �����ִ� �Լ�
-- ���� : next_date(date, ����)
-- Q1. ������ �������� ���� ����� ������� �������� ���ϴ� SQL��
SELECT sysdate, next_day(sysdate, '�����') FROM dual;     -- 23/08/19
SELECT sysdate, next_day(sysdate, '��') FROM dual;

-- Q2. ������ �������� ���� ����� �������� �������� ���ϴ� SQL��
SELECT sysdate, next_day(sysdate, '������') FROM dual;     -- 23/08/21
SELECT sysdate, next_day(sysdate, '��') FROM dual;


-- last_day() : �ش� ���� ������ ��¥�� �����ִ� �Լ�
-- Q1. �� ������� �Ի��� ���� ������ ��¥�� �����ִ� SQL��
SELECT hiredate, last_day(hiredate) FROM emp;

-- Q2. �̹� ���� ���� ������ ��¥�� ���ϴ� SQL��
SELECT sysdate, last_day(sysdate) FROM dual;

-- Q3. 2023�� �� 2020�� 2������ ������ ��¥�� ���ϴ� SQL��
SELECT last_day('23/02/01') from dual;          -- 23/02/28
SELECT last_day('20/02/01') from dual;          -- 20/02/28

