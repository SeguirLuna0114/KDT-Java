-- 2023. 08. 30 (��)

-- ��Ű��(Package) = ���� ���ν����� ���� �Լ��� ������� ��
-- ��Ű�� ������� = ��Ű�� ��� + ��Ű�� �ٵ�

-- ��Ű�� ����
--  1. ��Ű�� ��� ����
CREATE OR REPLACE PACKAGE exam_pack
IS
    -- ��Ű�� ��带 �����ϴ� �����Լ�
    FUNCTION cal_bonus(
        vempno IN emp.empno%TYPE)
    RETURN NUMBER;
    
    -- ��Ű�� ��带 �����ϴ� ���� ���ν���
    PROCEDURE cursor_sample02;
END;


-- 2. ��Ű�� �ٵ� ����
CREATE OR REPLACE PACKAGE BODY exam_pack
IS
    -- ���� �Լ� : cal_bonus
    FUNCTION cal_bonus(vempno IN emp.empno%TYPE)
    RETURN NUMBER   -- ������ ���� �ڷ���
    IS
        -- ���� ���� ����
        vsal NUMBER(7, 2);
    BEGIN
        -- SQL�� �ۼ�
        SELECT sal INTO vsal
        FROM emp WHERE empno = vempno;
    
        RETURN vsal * 2;    -- �޿��� 200% �λ��� ��� ����
    END;
    
    -- ���� ���ν��� : cursor_sample02
    PROCEDURE cursor_sample02
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
END;

-- 3. ���� ���ν��� ���� :cursor_sample02
EXECUTE exam_pack.cursor_sample02;

-- 4. ���� �Լ� ���� : cal_bonus()
-- ���ε� ���� ����
VARIABLE var_res NUMBER;

-- ���� �Լ� ����
EXECUTE :var_res := exam_pack.cal_bonus(7788);
EXECUTE :var_res := exam_pack.cal_bonus(7900);

-- ���ε� ������ ���� ���� ���
PRINT var_res;

-- SELECT������ �����Լ� ����
SELECT ename, exam_pack.cal_bonus(7788)
FROM emp WHERE empno = 7788;
    -- SCOTT	6000

SELECT ename, exam_pack.cal_bonus(7900)
FROM emp WHERE empno = 7900;
    -- JAMES	1900


