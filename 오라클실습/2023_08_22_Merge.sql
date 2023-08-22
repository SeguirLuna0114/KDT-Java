-- 2023. 08. 22(ȭ)

--* ���̺� ������ ������ �� ���̺��� MERGE ����
--
--  MERGE : ������ ���� 2���� ���̺��� �ϳ��� ���̺�� ��ġ�� ���.
--  MERGE����� �����Ҷ� ������ �����ϴ� ��(ROW)�� ������ ���ο�     
--  ������ UPDATE�ǰ�, �������� ������ ���ο� ��(ROW)���� �߰��ȴ�.

    -- ������ �����ϴ� emp01, emp02 ���̺� drop
DROP TABLE emp01 PURGE;
DROP TABLE emp02 PURGE;

-- emp01, emp02 ���̺� Ȯ��
SELECT * from emp01;        -- 14�� ������
SELECT * from emp02;        -- 3�� ������

1. create table emp01 as select * from emp;

2. create table emp02 as select * from emp where job='MANAGER';

3. update emp02 set job='Test';

4. insert into emp02 values(8000, 'ahn', 'top', 7566, '2023/02/09',1200, 10, 20);

5. select * from emp02; (Ȯ��)

--**"emp01" ���̺�� "emp02" ���̺��� ����
--	- ��ġ�ϴ� ��� "emp01" ���̺��� ������Ʈ�ϰ�, 
--	  ��ġ���� �ʴ� ��� "emp01" ���̺� ���ο� ���ڵ带 ����
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

-- ���� ����� "emp01" ���̺��� ������ Ȯ��
7. select * from emp01; (�պ��� ��� Ȯ��)

