-- 2023. 08. 18
-- NVL()�Լ�, DECODE()�Լ�, CASE ����ǥ����

-- NVL() : NULL���� �ٸ� ������ ��ȯ���ִ� �Լ�
--  1. NULL���� �������� ���� ���� �ǹ�
--  2. NULL���� �������(+, -, *, /)�� ���� ����

-- Q. ��� ���̺��� �� ������� ������ ����ϴ� SQL��
    -- ���� = �޿�(SAL) * 12 + Ŀ�̼�(COMM)
    -- NVL(COMM, 0) : COMM�÷� ���� NULL�� �����͸� 0���� ġȯ
SELECT ename, sal*12 + NVL(comm, 0) AS "����" FROM emp;



-- DECODE() : switch - case���� ����
-- ���� : decode (�÷���, ��1, ���1,
--                      ��2, ���2,
--                      ��3, ���3,
--                      ��N, ���N)
-- Q. ��� ���̺��� �μ���ȣ(deptno)�� �μ������� �ٲ㼭 ����ϴ� SQL��
SELECT ename, deptno,
        DECODE(deptno, 10, 'ACCOUNTING',
                        20, 'RESEARCH',
                        30, 'SALES',
                        40, 'OPERATIONS') AS dname
FROM emp;



-- CASE �Լ� : if~else if������ ����
-- ���� : case when ����1 then ���1
--             when ����2 then ���2
--             else ���3
--        end

-- Q. ��� ���̺��� �μ���ȣ(deptno)�� �μ������� �ٲ㼭 ����ϴ� SQL��
    -- deptno�÷��� ���� ���� �����ϴ� ��� CASE �÷��� WHEN �÷������Ͱ� then '���氪'���ε� �ۼ� ����
SELECT ename, deptno,
        CASE deptno
                WHEN 10 then 'ACCOUNTING'
                WHEN 20 then 'RESEARCH'
                WHEN 30 then 'SALES'
                WHEN 40 then 'OPERATIONS'
        END AS dname
FROM emp;

        -- ���� �Ϲ����� ����
SELECT ename, deptno,
        CASE WHEN deptno=10 then 'ACCOUNTING'
             WHEN deptno=20 then 'RESEARCH'
             WHEN deptno=30 then 'SALES'
             WHEN deptno=40 then 'OPERATIONS'
        END AS dname
FROM emp;





