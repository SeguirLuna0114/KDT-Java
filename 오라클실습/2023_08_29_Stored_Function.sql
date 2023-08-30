-- 2023. 08. 29 (화)

-- 저장 함수(Stored Function)
-- : 저장 함수는 저장 프로시저와 유사한 기능을 수행하지만,
--   실행 결과를 돌려주는 역할을 수행

-- Q1. 사원 테이블에서 특정 사원의 급여를 200% 인상한 결과를 돌려주는 저장함수 생성
-- 1. 저장함수
CREATE OR REPLACE FUNCTION cal_bonus(vempno IN emp.empno%TYPE)
    RETURN NUMBER   -- 돌려줄 값의 자료형
IS
    -- 로컬 변수 선언
    vsal NUMBER(7, 2);
BEGIN
    -- SQL문 작성
    SELECT sal INTO vsal
    FROM emp WHERE empno = vempno;
    
    RETURN vsal * 2;    -- 급여를 200% 인상한 결과 리턴
END;

-- 2. 저장함수 목록 확인
SELECT * FROM user_source;

-- 3. 바인드 변수 생성
VARIABLE var_res NUMBER;

-- 4. 저장 함수 실행
EXECUTE :var_res := cal_bonus(7788);
EXECUTE :var_res := cal_bonus(7900);

-- 5. 바인드 변수로 돌려받은 값 출력
PRINT var_res;

-- 저장 함수를 SQL문에서 포함시켜서 실행
SELECT ename, sal, cal_bonus(7788)
FROM emp WHERE empno = 7788;
    -- SCOTT	3000	6000    
SELECT ename, sal, cal_bonus(7900)
FROM emp WHERE empno = 7900;   
    -- JAMES	950	1900
    
   
-- Q2. 사원 테이블에서 사원명을 저장함수의 매개변수로 전달하여
-- 해당 사원의 직급(job)을 구해오는 저장 함수를 생성하고 실행
-- 1. 저장함수 생성
CREATE OR REPLACE FUNCTION job_emp(
    vename IN emp.ename%TYPE
)
RETURN VARCHAR2
IS
    vjob emp.job%TYPE;  --로컬변수(사원명으로 검색한 사원의 job 검색)
BEGIN
    SELECT job INTO vjob
    FROM emp WHERE ename = vename;
    
    RETURN vjob;
END;

-- 2. 저장 함수 목록 확인
SELECT * FROM user_source;

-- 3. 바인드 변수
VARIABLE var_job VARCHAR2(10);

-- 4. 저장함수 실행
EXECUTE :var_job := job_emp('SCOTT');
EXECUTE :var_job := job_emp('KING');

-- 5. 바인드 변수에 저장된 결과 출력
PRINT var_job;
    
-- 저장 함수를 SQL문에서 포함시켜서 실행   
SELECT job_emp('SCOTT')
FROM emp WHERE ename = 'SCOTT';
    -- ANALYST
SELECT job_emp('KING')
FROM emp WHERE ename = 'KING';
    -- PRESIDENT
    
    
