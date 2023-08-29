-- 2023. 08. 29 (ȭ)

-- PL/SQL (Oracle's Procedural Language extention to SQL)

--- ���ǹ�(=���ù�)

-- %TYPE: ������ ������ Ÿ���� �ٸ� ������ �÷��� Ÿ�԰� ����

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
--    IF vdeptno = 10 THEN
--        vdname := 'ACCOUNTING';
--    END IF;
--    IF vdeptno = 20 THEN
--        vdname := 'RESEARCH';
--    END IF;
--    IF vdeptno = 30 THEN
--        vdname := 'SALES';
--    END IF;
--    IF vdeptno = 40 THEN
--        vdname := 'OPERATIONS';
--    END IF;
    
    -- IF - ELSEIF - ELSE - ENDIF���� ����ؼ� �ۼ� ����
    IF vdeptno = 10 THEN
        vdname := 'ACCOUNTING';
    ELSIF vdeptno = 20 THEN
        vdname := 'RESEARCH';
    ELSIF vdeptno = 30 THEN
        vdname := 'SALES';
    ELSIF vdeptno = 40 THEN
        vdname := 'OPERATIONS';
    ELSE
        vdname := 'UNKNOWN';
    END IF;    

    dbms_output.put_line('���    /   �̸�  / �μ���');
    dbms_output.put_line('-------------------------------------');
    dbms_output.put_line(vempno || '    /   ' || vename || '    /   '   || vdname);    
END;


-- %ROWTYPE: ���̺��� ��� �÷��� �ڷ����� ��� �����Ѵٴ� �ǹ�

-- NULL ���� ���ԵǾ� �ִ� ��� ������ ����� NULL�� �򰡵�
    --> NULL���� ó���ϱ� ���� NVL�Լ��� ����� �ٸ� ������ ��ü ����  

-- Q2. ��� ���̺��� SCOTT����� ������ ���ϴ� PL/SQL�� �ۼ�
-- 1) NVL�Լ��� ����� NULL���� ġȯ�ϴ� ���
SET SERVEROUTPUT ON     -- ������ ����� Ȱ��ȭ�ϴ� ���
    -- PL/SQL ��� ������ DBMS_OUTPUT.PUT_LINE�� ����Ͽ� �޽����� ���O
DECLARE    
    -- ���� ����
    vemp emp%ROWTYPE;       -- ���۷��� ����
        -- emp ���̺��� ����� ������ �ڷ����� ���� ���ڵ� ���� vemp�� ����
        -- %ROWTYPE : emp���̺��� ���(8��) �÷��� �ڷ����� ��� �����Ѵٴ� �ǹ�
    annual NUMBER(7, 2);    -- ��Į�� ����
BEGIN
    -- SELECT SQL��
    SELECT * INTO vemp
    FROM emp WHERE ename = 'SCOTT';
    
    -- ���� ���� ���� - ������ ����Ͽ� annual������ �Ҵ�
    -- NVL()�Լ��� �����, comm ���� NULL�� ��� 0���� ��ü�Ͽ� ���
    annual := vemp.sal * 12 + NVL(vemp.comm, 0);
    
    dbms_output.put_line('���     /   �̸�      /   ����');
    dbms_output.put_line(vemp.empno || '    /   ' || vemp.ename || '    /   ' || annual);   
END;

-- 2) IF���� ����ؼ� NULL���� ġȯ�ϴ� ���
SET SERVEROUTPUT ON     -- ������ ����� Ȱ��ȭ�ϴ� ���
    -- PL/SQL ��� ������ DBMS_OUTPUT.PUT_LINE�� ����Ͽ� �޽����� ���O
DECLARE    
    -- ���� ����
    vemp emp%ROWTYPE;       -- ���۷��� ����
        -- emp ���̺��� ����� ������ �ڷ����� ���� ���ڵ� ���� vemp�� ����
        -- %ROWTYPE : emp���̺��� ���(8��) �÷��� �ڷ����� ��� �����Ѵٴ� �ǹ�
    annual NUMBER(7, 2);    -- ��Į�� ����
BEGIN
    -- SELECT SQL��
    SELECT * INTO vemp
    FROM emp WHERE ename = 'SCOTT';
    
    -- vemp.comm�÷��� ���� NULL�� ���, 0���� ġȯ�Ͽ� ���
    IF vemp.comm IS NULL THEN
        vemp.comm := 0;
    END IF; 
    -- ���� ���� ���� - ������ ����Ͽ� annual������ �Ҵ�
    annual := vemp.sal * 12 + vemp.comm;
    
    dbms_output.put_line('���     /   �̸�      /   ����');
    dbms_output.put_line(vemp.empno || '    /   ' || vemp.ename || '    /   ' || annual);   
END;


-- 2. if  ~ then  ~ elsif ~ end if
-- Q. ��� ���̺��� SCOTT����� ������ ���ϴ� PL/SQL�� �ۼ�
SET SERVEROUTPUT ON
DECLARE
    vemp emp%rowtype;       -- ���ڵ� ����(���۷��� ����)
    annual NUMBER(7, 2);    -- ��Į�� ���� ����
BEGIN
    SELECT * INTO vemp
    FROM emp WHERE ename = 'SCOTT';
    
    -- IF�� �ۼ�
    -- ���� ���� ���� - ������ ����Ͽ� annual������ �Ҵ�
    IF vemp.comm IS NULL THEN
        annual := vemp.sal * 12;
    ELSIF vemp.comm >= 0 then
        annual := vemp.sal * 12 + vemp.comm;
    ELSE
        -- ������ ���, comm ���� �����ϰ� ���� ���
        annual := vemp.sal * 12;
    END IF;     
    
    dbms_output.put_line('���     /   �̸�      /   ����');
    dbms_output.put_line(vemp.empno || '    /   ' || vemp.ename || '    /   ' || annual);   
END;


-- 3. if  ~ then  ~ elsif ~ else ~ end if
-- Q. ������̺�(EMP)���� SCOTT ����� �μ���ȣ�� �˻��ؼ�, �μ����� ����ϴ� PL/SQL��
SET SERVEROUTPUT ON
DECLARE
    vemp emp%rowtype;       -- ���ڵ� ����(���۷��� ���� ����)
    vdname VARCHAR2(14);    -- ��Į�� ����
BEGIN
    -- SELECT SQL��
    SELECT * INTO vemp
    FROM emp WHERE ename = 'SCOTT';
    
    -- IF�� �ۼ�
    IF vemp.deptno = 10 THEN
        vdname :=  'ACCOUNTING';
    ELSIF vemp.deptno = 20 THEN
        vdname := 'RESEARCH';
    ELSIF vemp.deptno = 30 THEN
        vdname := 'SALES';
    ELSIF vemp.deptno = 40 THEN
        vdname := 'OPERATION';
    END IF;
    
    -- ���
    dbms_output.put_line('���    /    �̸�     /   �μ���');
    dbms_output.put_line(vemp.empno || '    /   ' || vemp.ename || '    /   ' || vdname);
END;

