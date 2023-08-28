-- 2023. 08. 28(��)

-- PL/SQL (Oracle's Procedural Language extention to SQL)

-- Q. PL/SQL�� Hello World~!! ���
SET SERVEROUTPUT ON     -- SERVEROUTPUT ȯ�溯�� Ȱ��ȭ
BEGIN                   -- ����� ����
    dbms_output.put_line('Hello World~!!');
    -- dbms_output ��Ű���� put_line ���ν����� ȣ���Ͽ�
    -- �޽����� ���
END;                    -- ����� ��


-- Q. ���� ����ϱ� : ��Į�� ���� ���
    -- SERVEROUTPUT ȯ�溯�� Ȱ��ȭ
SET SERVEROUTPUT ON     
DECLARE                 -- ����� ����
    vempno NUMBER(4);   -- ���� ���� : ��Į�� ����
    vename VARCHAR2(10);
BEGIN                   -- ����� ����
    vempno := 7788;     -- �������� ��ҹ��ڸ� ��������X
    vename := 'SCOTT';
    dbms_output.put_line('���    /   �̸�');
    dbms_output.put_line('---------------');
    dbms_output.put_line(vempno || '    /   ' || vename);
END;                    -- ����� ��


-- Q. ����� �̸� �˻��ϱ� : ���۷��� ���� ���
SET SERVEROUTPUT ON  
DECLARE
    vempno emp.empno%TYPE;      -- ���� ���� : ���۷��� ����
    vename emp.ename%TYPE;      -- ���� ���� : ���۷��� ����
BEGIN
     SELECT empno, ename INTO vempno, vename 
     FROM emp
     WHERE ename = 'SCOTT';
     
    dbms_output.put_line('���    /   �̸�');
    dbms_output.put_line('------------------');
    dbms_output.put_line(vempno || '    /   ' || vename);    
END;

-----------------------------------------------------------------
--- ���ǹ�(=���ù�)

-- 1. if  ~ then  ~ end if
-- Q1. ������̺�(EMP)���� SCOTT ����� �μ���ȣ�� �˻��ؼ�, �μ����� ����ϴ� PL/SQL��
SET SERVEROUTPUT ON  
DECLARE
    vempno NUMBER(4);           -- ��Į�� ���� ����
    vename VARCHAR2(20);
    vdeptno dept.deptno%TYPE;   -- ���۷��� ���� ����
    vdname VARCHAR2(20) := NULL;
BEGIN
    SELECT empno, ename, deptno 
    INTO vempno, vename, vdeptno
    FROM emp
    WHERE ename = 'SCOTT';
    
    -- IF��
    IF vdeptno = 10 THEN
        vdname := 'ACCOUNTING';
    END IF;
    IF vdeptno = 20 THEN
        vdname := 'RESEARCH';
    END IF;
    IF vdeptno = 30 THEN
        vdname := 'SALES';
    END IF;
    IF vdeptno = 40 THEN
        vdname := 'OPERATIONS';
    END IF;

    dbms_output.put_line('���    /   �̸�  / �μ���');
    dbms_output.put_line('-------------------------------------');
    dbms_output.put_line(vempno || '    /   ' || vename || '    /   '   || vdname);    
END;

