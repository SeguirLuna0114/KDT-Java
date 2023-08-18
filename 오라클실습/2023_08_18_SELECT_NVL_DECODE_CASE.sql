-- 2023. 08. 18
-- NVL()함수, DECODE()함수, CASE 조건표현식

-- NVL() : NULL값을 다른 값으로 변환해주는 함수
--  1. NULL값은 정해지지 않은 값을 의미
--  2. NULL값은 산술연산(+, -, *, /)이 되지 않음

-- Q. 사원 테이블에서 각 사원들의 연봉을 계산하는 SQL문
    -- 연봉 = 급여(SAL) * 12 + 커미션(COMM)
    -- NVL(COMM, 0) : COMM컬럼 값이 NULL인 데이터를 0으로 치환
SELECT ename, sal*12 + NVL(comm, 0) AS "연봉" FROM emp;



-- DECODE() : switch - case문과 유사
-- 형식 : decode (컬럼명, 값1, 결과1,
--                      값2, 결과2,
--                      값3, 결과3,
--                      값N, 결과N)
-- Q. 사원 테이블에서 부서번호(deptno)를 부서명으로 바꿔서 출력하는 SQL문
SELECT ename, deptno,
        DECODE(deptno, 10, 'ACCOUNTING',
                        20, 'RESEARCH',
                        30, 'SALES',
                        40, 'OPERATIONS') AS dname
FROM emp;



-- CASE 함수 : if~else if구문과 유사
-- 형식 : case when 조건1 then 결과1
--             when 조건2 then 결과2
--             else 결과3
--        end

-- Q. 사원 테이블에서 부서번호(deptno)를 부서명으로 바꿔서 출력하는 SQL문
    -- deptno컬럼에 대한 값만 생각하는 경우 CASE 컬럼명 WHEN 컬럼데이터값 then '변경값'으로도 작성 가능
SELECT ename, deptno,
        CASE deptno
                WHEN 10 then 'ACCOUNTING'
                WHEN 20 then 'RESEARCH'
                WHEN 30 then 'SALES'
                WHEN 40 then 'OPERATIONS'
        END AS dname
FROM emp;

        -- 좀더 일반적인 형식
SELECT ename, deptno,
        CASE WHEN deptno=10 then 'ACCOUNTING'
             WHEN deptno=20 then 'RESEARCH'
             WHEN deptno=30 then 'SALES'
             WHEN deptno=40 then 'OPERATIONS'
        END AS dname
FROM emp;





