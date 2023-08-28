-- 2023. 08. 24(목)

-- Q. ROWNUM을 이용해서 급여를 3~5번째로 많이받는 사원을 검색
-- ROWNUM컬럼에 별칭 부여
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

-- 컬럼명을 간결하게 처리
SELECT rnum, ename, sal, hiredate
FROM (
    SELECT ROWNUM as rnum, board.*
    FROM (
        SELECT *
        FROM emp
        ORDER BY sal DESC
    ) board     -- 서브쿼리에 별칭 부여
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