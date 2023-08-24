-- 2023. 08. 24(��)

-- Q. ROWNUM�� �̿��ؼ� �޿��� 3~5��°�� ���̹޴� ����� �˻�
-- �޿��� ���̹޴� ��� �� 3��°
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