-- 2023. 08. 22(화)

--* 테이블 구조가 동일한 두 테이블의 MERGE 연습
--
--  MERGE : 구조가 같은 2개의 테이블을 하나의 테이블로 합치는 기능.
--  MERGE명령을 수행할때 기존에 존재하는 행(ROW)이 있으면 새로운     
--  값으로 UPDATE되고, 존재하지 않으면 새로운 행(ROW)으로 추가된다.

    -- 기존에 존재하던 emp01, emp02 테이블 drop
DROP TABLE emp01 PURGE;
DROP TABLE emp02 PURGE;

-- emp01, emp02 테이블 확인
SELECT * from emp01;        -- 14개 데이터
SELECT * from emp02;        -- 3개 데이터

1. create table emp01 as select * from emp;

2. create table emp02 as select * from emp where job='MANAGER';

3. update emp02 set job='Test';

4. insert into emp02 values(8000, 'ahn', 'top', 7566, '2023/02/09',1200, 10, 20);

5. select * from emp02; (확인)

--**"emp01" 테이블과 "emp02" 테이블을 병합
--	- 일치하는 경우 "emp01" 테이블을 업데이트하고, 
--	  일치하지 않는 경우 "emp01" 테이블에 새로운 레코드를 삽입
6. merge into emp01
	using emp02
	on(emp01.empno = emp02.empno)
	when matched then
	     update set emp01.ename = emp02.ename,
			emp01.job = emp02.job,
			emp01.mgr = emp02.mgr,
			emp01.hiredate = emp02.hiredate,
			emp01.sal = emp02.sal,
			emp01.comm = emp02.comm,
			emp01.deptno = emp02.deptno
	when not matched then
	     insert values(emp02.empno, emp02.ename, emp02.job, 		         	         
		          emp02.mgr,emp02.hiredate, 
		         emp02.sal, emp02.comm,emp02.deptno);

-- 병합 결과인 "emp01" 테이블의 내용을 확인
7. select * from emp01; (합병된 결과 확인)

