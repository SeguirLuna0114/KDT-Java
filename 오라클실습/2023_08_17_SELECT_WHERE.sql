-- 2023.08.17(목)

-- # 논리 연산자: and, or, not
-- 1. AND 연산자: 두 조건식을 모두 만족하는 데이터를 검색
-- Q1. 사원 테이블에서 부서번호가 10번이고, job이 MANAGER인 사원을 검색하는 SQL문
SELECT * FROM emp WHERE deptno = 10 AND job = 'MANAGER';

-- Q2. 급여를 2000에서 3000 사이의 급여를 받는 사원을 검색하는 SQL문
SELECT * FROM emp WHERE sal >= 2000 AND sal <= 3000;


-- 2. OR 연산자: 두 조건식 중에서 한가지만 만족해도 검색
-- Q1. 사원 테이블에서 부서번호가 10이거나, job이 MANAGER인 사원을 검색하는 SQL문
SELECT * FROM emp WHERE deptno=10 OR job = 'MANAGER';

-- Q2. 커미션이 300이거나 500 이거나 1400인 사원을 검색하는 SQL문
SELECT * FROM emp WHERE comm =300 OR comm=500 OR comm=1400;

-- Q3. 사원번호가 7521이거나 7654이거나 7844인 사원을 검색하는 SQL문
SELECT * FROM emp WHERE empno=7521 OR empno=7654 OR empno=7844;


-- 3. NOT 연산자: 논리값을 반대로 바꿔주는 역할
-- Q. 부서번호가 10이 아닌 사원을 검색하는 SQL문
SELECT * FROM emp WHERE NOT deptno = 10;        -- 논리연산자

SELECT * FROM emp WHERE deptno != 10;           -- 비교연산자
SELECT * FROM emp WHERE deptno ^= 10;           -- 비교연산자
SELECT * FROM emp WHERE deptno <> 10;           -- 비교연산자



-- 비교 연산자2: BETWEEN A AND B, IN(list), LIKE, IS NULL
-- 1. BETWEEN A AND B 연산자: 일정한 값의 범위가 있는 경우에 사용
    -- 형식) WHERE 컬럼명 BETWEEN 작은값 AND 큰값
-- Q1. 급여를 2000에서 3000 사이의 급여를 받는 사원을 검색하는 SQL문
SELECT * FROM emp WHERE sal BETWEEN 2000 AND 3000;
--SELECT * FROM emp WHERE sal BETWEEN 3000 AND 2000;      -- 검색결과 없음

SELECT * FROM emp WHERE sal >= 2000 AND sal <= 3000;    -- 논리연산자 AND

-- Q2. 급여가 2000미만이거나 3000 초과인 사원을 검색하는 SQL문
SELECT * FROM emp WHERE sal NOT BETWEEN 2000 AND 3000;

SELECT * FROM emp WHERE sal < 2000 OR sal >3000;        -- 논리연산자 OR

-- Q3. 1987년도에 입사한 사원을 검색하는 SQL문
SELECT * FROM emp WHERE hiredate BETWEEN '87/01/01' AND '87/12/31';

SELECT * FROM emp WHERE hiredate >= '87/01/01' AND hiredate <= '87/12/31';  -- 논리연산자 AND


-- 2. IN 연산자: OR연산자를 대신해서 표현할 때 사용됨
    -- 형식) WHERE 컬럼명 IN (데이터1, 데이터2, ...)
-- Q1. 커미션이 300이거나 500 이거나 1400인 사원을 검색하는 SQL문
SELECT * FROM emp WHERE comm IN (300, 500, 1400);

SELECT * FROM emp WHERE comm =300 OR comm=500 OR comm=1400;     -- 논리연산자 OR

-- Q2. 커미션이 300, 500, 1400이 아닌 사원을 검색하는 SQL문
SELECT * FROM emp WHERE comm NOT IN (300, 500, 1400);

SELECT * FROM emp WHERE comm !=300 AND comm!=500 AND comm!=1400;     -- 논리연산자 AND

-- Q3. 사원번호가 7521이거나 7654이거나 7844인 사원을 검색하는 SQL문
SELECT * FROM emp WHERE empno IN (7521, 7654, 7844);

SELECT * FROM emp WHERE empno=7521 OR empno=7654 OR empno=7844;        -- 논리연산자 OR


-- 3. Like연산자 & 와일드카드(%, _)
    -- 형식) WHERE 컬럼명 LIKE pattern(와일드카드 문자 사용)
    -- 와일드카드
    --  1) %: 문자가 하나도 없거나, 하나 이상의 문자에 어떤 값이 와도 상관 없음
    --  2) _: 하나의 문자에 어떤 값이 와도 상관 없음   
--- % 와일드카드 사용
-- Q1. 사원 테이블에서 사원명이 F로 시작하는 사원을 검색하는 SQL문
SELECT * FROM emp WHERE ename LIKE 'F%';    -- F로 시작하는 사원 검색
SELECT * FROM emp WHERE ename = 'FORD';     -- FORD사원만 검색됨

-- Q2. 사원 테이블에서 사원명이 N으로 끝나는 사원을 검색하는 SQL문
SELECT * FROM emp WHERE ename LIKE '%N';

-- Q3. 사원 테이블에서 사원명이 A를 포함하는 사원을 검색하는 SQL문
SELECT * FROM emp WHERE ename LIKE '%A%';

--- _(언더바) 와일드카드 사용
-- Q1. 사원 이름의 두번째 글짜가 A인 사원을 검색하는 SQL문
SELECT * FROM emp WHERE ename LIKE '_A%';   -- 두번째 글자가 A로 시작

-- Q2. 사원 이름의 세번째 글자가 A인 사원을 검색하는 SQL문
SELECT * FROM emp WHERE ename LIKE '__A%';

-- Q3. 사원명에 A가 포함되어 있지 않은 사원을 검색하는 SQL문 
SELECT * FROM emp WHERE ename NOT LIKE '%A%';


-- 4. IS NULL 연산자: 특정 컬럼 값이 NULL인 행을 검색하는 데 사용
    -- NULL값: 값이 존재하지 않음을 나타내는 상태   
-- Q1. MGR컬럼에 NULL값인 데이터를 검색
SELECT * FROM emp where mgr IS NULL;

    -- = 나 != 같은 일반적인 비교 연산자는 NULL 값과 제대로 작동X
    -- =''(빈 문자열)은 Null값과 동일하지 않음(빈 문자열은 값이지만, NULL은 값이 없음을 나타냄)
SELECT * FROM emp where mgr = NULL;     -- 검색안됨
SELECT * FROM emp where mgr = '';       -- 검색안됨

-- Q2. MGR컬럼에 NULL값이 아닌 데이터를 검색
SELECT * FROM emp where mgr IS NOT NULL;

-- Q3. COMM 컬럼에 NULL값인 데이터를 검색
SELECT * FROM emp where comm IS NULL;
SELECT COUNT(*) FROM emp WHERE comm IS NULL;

-- Q4. COMM 컬럼에 NULL값이 아닌 데이터를 검색
SELECT * FROM emp where comm IS NOT NULL;


