-- 2023. 08. 30 (��)

-- Ŀ��(Cursor)
-- : 2�� �̻��� �����͸� ó���� �� Ŀ���� ���

-- LOOP ���� ����Ͽ� Ŀ���� ��ȸ�ϴ� ���

-- Q1. �μ� ���̺��� ��� �����͸� ����ϱ� ���� PL/SQL��
-- 1. ���� ���ν��� ����
SET SERVEROUTPUT ON
CREATE OR REPLACE PROCEDURE cursor_sample01
IS
    -- ���� ����
    vdept dept%ROWTYPE;     -- ���ú���

    -- Ŀ�� ����
    CURSOR c1
    IS
    SELECT * FROM dept;
BEGIN
    dbms_output.put_line('�μ���ȣ  /  �μ���  /   ������');
    dbms_output.put_line('----------------------------------------');
    
    -- Ŀ�� ����(ù��° �����͸� ������)
    OPEN c1;
        LOOP
            FETCH c1 INTO vdept.deptno, vdept.dname, vdept.loc;  -- ������ �÷�
                EXIT WHEN c1%notfound;  -- Ŀ���� ������ �����Ͱ� ���� �� true
            dbms_output.put_line(vdept.deptno || '  /  ' || vdept.dname || '    /   ' || vdept.loc);
        END LOOP;
    -- Ŀ�� �ݱ�
    CLOSE c1;
END;
    
-- 2. ���� ���ν��� ��� Ȯ��
SELECT * FROM user_source;

-- 3. ���ν��� ����
EXECUTE cursor_sample01;


-- For...IN LOOP������ ó��
--  1) open~ fetch ~ close ���� ó���� �� �ִ�
--  2) for loop���� ����ϰ� �Ǹ� �� �ݺ������� cursor�� ����,
--      �� ���� ����(fetch)�ϰ�, cursor�� �ݴ� �۾��� �ڵ������� ó������

-- Q2. �μ� ���̺��� ��� �����͸� ����ϴ� PL/SQL��
SET SERVEROUTPUT ON
CREATE OR REPLACE PROCEDURE cursor_sample02
IS
    vdept dept%ROWTYPE;     -- ���ú���
    
    -- Ŀ�� ����
    CURSOR c1 IS
        SELECT * FROM dept;
BEGIN
    dbms_output.put_line('�μ���ȣ  /   �μ���     / ������');
    dbms_output.put_line('------------------------------------');
    
    -- FOR...IN LOOP���� ���
    FOR vdept IN c1 LOOP
        EXIT WHEN c1%notfound;  -- Ŀ���� ������ �����Ͱ� ���� ��� true ����
        dbms_output.put_line(vdept.deptno || '  /   ' || vdept.dname || '   /   ' || vdept.loc);
    END LOOP;
END;

-- 2. ���� ���ν��� ��� Ȯ��
SELECT * FROM user_source
WHERE type = 'PROCEDURE' AND name = 'CURSOR_SAMPLE02';

-- 3. ���ν��� ����
EXECUTE cursor_sample02;


-- Q3. ������̺��� �μ���ȣ�� �����Ͽ� �ش� �μ��� �Ҽӵ� ����� ������
--      ����ϴ� ���ν����� Ŀ���� �̿��ؼ� �ۼ�
-- 1. ���� ���ν��� ����
SET SERVEROUTPUT ON
CREATE OR REPLACE PROCEDURE info_emp(
    vdeptno IN emp.deptno%TYPE
)
IS
    -- FOR...IN LOOP������ ����ϴ� ���ڵ庯���� ���� ���� �ٷ� ��� ����
--    vemp emp%ROWTYPE;     -- ���ú���
    
    -- Ŀ�� ����
    CURSOR c1 IS
        SELECT * FROM emp
        WHERE deptno = vdeptno;
BEGIN
    dbms_output.put_line('�μ���ȣ  /  �����ȣ  /  �����  /  ����  /  �޿�');
    dbms_output.put_line('----------------------------------------------------');
    
    -- FOR...IN LOOP���� ���
    FOR vemp IN c1 LOOP
        dbms_output.put_line(vemp.deptno || '  /  ' || vemp.empno || '  /  ' || vemp.ename || '  /  ' || vemp.job || '  /  ' || vemp.sal);
    END LOOP;
END;

-- 2. ���� ���ν��� ��� Ȯ��
SELECT * FROM user_source
WHERE type = 'PROCEDURE' AND name = 'INFO_EMP';

-- 3. ���ν��� ����
EXECUTE info_emp(10);
EXECUTE info_emp(20);
EXECUTE info_emp(30);
EXECUTE info_emp(40);

