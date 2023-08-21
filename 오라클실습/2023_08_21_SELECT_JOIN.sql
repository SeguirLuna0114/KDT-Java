-- 2018. 08. 21(월)

-- JOIN(조인)
-- : 2개 이상의 테이블을 결합해서 정보를 구해오는 것

-- JOIN 필요성
--  1. JOIN하지 않는 경우 2개의 SQL문을 작성해야 함
    -- Q. SCOTT 사원이 소속된 부서명을 출력하는 SQL문
    -- 1) 사원 테이블(emp)에서 SCOTT사원의 부서번호를 구함
    SELECT deptno FROM emp WHERE ename = 'SCOTT';       -- 20
    -- 2) 부서 테이블(DEPT)에서 20번 부서의 부서명을 구함
    SELECT  dname FROM dept WHERE deptno = 20;          -- RESEARCH

-- # CROSS JOIN
SELECT * FROM dept, emp;            -- 4*14= 56개의 데이터 검색
SELECT * FROM emp, dept;            -- 14*4= 56개의 데이터 검색

    -- CROSS JOIN의 종류
    -- 1) 등가조인(EquiJoin)
    -- 2) 비등가조인(Non-EquiJoin)
    -- 3) 자체조인(Self Join)
    -- 4) 외부조인(Outer Join)
    
-- 1. 등가조인(EquiJoin)
--    : 2개의 테이블에 동일한 컬럼을 기준으로 조인하는 것.
    -- "dept" 테이블과 "emp" 테이블 간에 "deptno" 열을 기준으로 EquiJoin을 수행
SELECT * FROM dept, emp WHERE dept.deptno = emp.deptno;     -- 14개 데이터 검색

-- Q. SCOTT사원이 소속된 부서명을 출력하는 SQL문 with JOIN 사용
SELECT ename, dname FROM dept, emp
        WHERE dept.deptno = emp.deptno AND ename = 'SCOTT';
        -- JOIN한 공통 컬럼인 deptno컬럼을 출력하면 오류 발생(column ambiguously defined)
SELECT deptno, ename, dname FROM dept, emp
        WHERE dept.deptno = emp.deptno AND ename = 'SCOTT';     -- 오류 발생
        -- 공통컬럼은 "테이블명.공통컬럼명" 형식으로 출력해야 함
        -- 공통컬럼이 아닌 컬럼들은 앞에 테이블명 생략 가능
SELECT emp.deptno, ename, dname FROM dept, emp
        WHERE dept.deptno = emp.deptno AND ename = 'SCOTT';        
SELECT dept.deptno, ename, dname FROM dept, emp
        WHERE dept.deptno = emp.deptno AND ename = 'SCOTT'; 
        
SELECT dept.deptno, emp.ename, dept.dname FROM dept, emp
        WHERE dept.deptno = emp.deptno AND emp.ename = 'SCOTT';        
        
-- 테이블에 별칭 부여하기
-- 1) 테이블에 대한 별칭이 부여된 다음 부터는 테이블명을 사용할 수 없고, 별칭명을 사용해야 함
-- 2) 별칭명은 대.소문자를 구분하지 않음
-- 3) 공통컬럼은 별칭명.공통컬럼 형식으로 사용해야 함
--    ex) d.deptno, e.deptno
-- 4) 공통컬럼이 아닌 컬럼들은 앞에 별칭명을 생략할 수 있음

-- 테이블명에 별칭 부여
SELECT d.deptno, e.ename, d.dname FROM dept d, emp e
    WHERE d.deptno=e.deptno AND e.ename='SCOTT';
    -- 별칭명은 대소문자 구분X
SELECT d.deptno, e.ename, d.dname FROM dept "D", emp "E"
    WHERE d.deptno=e.deptno AND e.ename='SCOTT';
    -- 일반 컬럼은 컬럼명 앞에 별칭명 생략 가능
SELECT d.deptno, ename, dname FROM dept d, emp e
    WHERE d.deptno=e.deptno AND e.ename='SCOTT';

    -- JOIN을 명시적으로 사용한 방법
    SELECT d.deptno, e.ename, d.dname
    FROM emp e
    JOIN dept d ON e.deptno = d.deptno
    WHERE e.ename = 'SCOTT';


-- 2. 비등가조인(Non-EquiJoin)
SELECT sal FROM emp;
SELECT * FROM salgrade;
--1	700	1200
--2	1201	1400
--3	1401	2000
--4	2001	3000
--5	3001	9999

-- Q. 각 사원들의 급여 등급
SELECT ename, sal, grade FROM emp, salgrade
    WHERE sal >= losal AND sal <= hisal;
    
    -- 'BETWEEN 작은값 AND 큰값' 연산자 사용
    SELECT ename, sal, grade FROM emp, salgrade
    WHERE sal BETWEEN losal AND hisal;
    
    
-- 3. 자체조인(Self Join)
--    : 한개의 테이블 내에서 컬럼과 컬럼사이의 관계를 이용해 조인
-- Q. 자체조인(Self Join)을 이용해서 사원 테이블의 각 사원들의 사원명과 
--    매니저(직속상사)를 출력하는 SQL문
--      EMP(empno)  -  EMP(mgr)
SELECT employee.ename || '의 상사는 ' ||  manager.ename
FROM emp employee, emp manager
WHERE employee.mgr = manager.empno;
        
        
-- 4. 외부조인(Outer Join)
--    : 조인 조건을 만족하지 않는 데이터를 출력하는 조인
--  1) 테이블을 조인할 때 어느 한쪽의 테이블에는 데이터가 존재하지만, 다른 테이블에
--     데이터가 존재하지 않을 경우에, 그 데이터가 출력되지 않는 문제를 해결하기 위해 사용
--  2) 정보가 부족한 곳에 (+)를 추가함

-- Q1. 위의 자체조인(Self Join)의 결과, KING사원은 직속상사가 없기 때문에
--     출력되지 않았는데, KING사원도 외부조인을 사용해 출력
SELECT employee.ename || '의 상사는 ' || manager.ename
FROM emp employee, emp manager
WHERE employee.mgr = manager.empno(+);

-- Q2. 부서테이블(DEPT)과 사원테이블(EMP)을 등가조인하면 40번 부서가 나타나지 않기때문에,
--     외부조인을 이용해서 40번 부서도 나타나도록 처리
    -- 1) DEPT - EMP 테이블 등가조인시, 40번 부서가 출력되지 않음
SELECT d.deptno, ename, dname FROM dept d, emp e
WHERE d.deptno = e.deptno ORDER BY deptno ASC; 
    -- 2) 외부조인: 출력되지 않는 40번 부서를 출력
SELECT d.deptno, ename, dname
FROM dept d, emp e
WHERE d.deptno = e.deptno(+)        -- dept 테이블을 기준으로 LEFT OUTER JOIN
ORDER BY deptno ASC;
        -- "dept" 테이블과 "emp" 테이블 LEFT OUTER JOIN
        SELECT d.deptno, ename, dname
        FROM dept d
        LEFT OUTER JOIN emp e ON d.deptno = e.deptno
        ORDER BY deptno ASC;
        
                -- "dept" 테이블과 "emp" 테이블 RIGHT OUTER JOIN
        SELECT d.deptno, ename, dname
        FROM emp e
        RIGHT OUTER JOIN dept d ON d.deptno = e.deptno
        ORDER BY deptno ASC;


