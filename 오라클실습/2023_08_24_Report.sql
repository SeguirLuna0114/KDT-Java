-- 2023. 08. 24(��)

-- Q. ROWNUM�� �̿��ؼ� �޿��� 3~5��°�� ���̹޴� ����� �˻�
-- ROWNUM�÷��� ��Ī �ο�
SELECT ROWNUM, ename, sal
FROM (
    SELECT ROWNUM as num, ename, sal
    FROM (
        SELECT *
        FROM emp
        ORDER BY sal DESC
    )
)
WHERE num BETWEEN 3 AND 5;

-- �÷����� �����ϰ� ó��
SELECT rnum, ename, sal, hiredate
FROM (
    SELECT ROWNUM as rnum, board.*
    FROM (
        SELECT *
        FROM emp
        ORDER BY sal DESC
    ) board     -- ���������� ��Ī �ο�
)
WHERE rnum BETWEEN 3 AND 5;

SELECT ROWNUM, ename, sal
FROM (
    SELECT emp_view.*, ROWNUM as num
    FROM (
        SELECT *
        FROM emp
        ORDER BY sal DESC
    ) emp_view
)
WHERE num BETWEEN 3 AND 5;