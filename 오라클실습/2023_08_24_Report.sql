-- 2023. 08. 24(목)

-- Q. ROWNUM을 이용해서 급여를 3~5번째로 많이받는 사원을 검색
-- 급여를 많이받는 사원 중 3번째
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