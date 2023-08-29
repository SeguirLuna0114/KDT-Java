-- 2023. 08. 29 (ȭ)

-- PL/SQL (Oracle's Procedural Language extention to SQL)

-- LOOP �ݺ���
-- 1. Basic Loop��
--      LOOP
--          �ݺ� ����� ����;
--          ���ǽ� EXIT;
--      END LOOP;

-- Q1. Basic Loop������ 1~5���� ���
SET SERVEROUTPUT ON
DECLARE
    --n������ �ʱⰪ�� 1�� ����
    n NUMBER := 1;
BEGIN
    -- Loop��
    LOOP
        dbms_output.put_line(n);
        n := n+1;
        EXIT WHEN n > 5;    -- EXIT���� ����ؼ� LOOP�� ��������
        
        -- IF���� ����ؼ� EXIT�� �ۼ� ����
--        IF n > 5 THEN
--            EXIT;
--        END IF;       
    END LOOP;
END;


-- Q2. Basic Loop������ 1~10������ �� ���
SET SERVEROUTPUT ON
DECLARE
    --n������ �ʱⰪ�� 1�� ����
    n NUMBER := 1;      -- ������ ���� ����
    s NUMBER := 0;      -- �������� ���� ����
    
BEGIN
    -- Loop��
    LOOP
        s := s + n;     -- ������ ���� ����
        n := n + 1;       -- ���� ���� ������ 1 ����
        
        -- EXIT WHEN ������ ���
        EXIT WHEN n > 10;    -- EXIT���� ����ؼ� LOOP�� ��������
        
        -- IF���� ����ؼ� EXIT�� �ۼ� ����
--        IF n > 10 THEN
--            EXIT;
--        END IF;       
    END LOOP;
    dbms_output.put_line('1~10������ �� : ' || s);
END;


-- 2. For Loop��
--      FOR  ����  IN [REVERSE] ������.. ���� LOOP
--          �ݺ� ����� ����;
--      END LOOP;

-- Q1. FOR LOOP������ 1���� 5���� ���
SET SERVEROUTPUT ON
BEGIN
    FOR n IN 1..5 LOOP
        dbms_output.put_line('n�� ��: ' || n);
    END LOOP;
END;

-- Q2. FOR LOOP������ 5���� 1���� ���
SET SERVEROUTPUT ON
BEGIN
    FOR n IN REVERSE 1..5 LOOP
        dbms_output.put_line('n�� ��: ' || n);
    END LOOP;
END;

-- Q3. For Loop���� �̿��ؼ� �μ� ���̺�(DEPT)�� ��� ������ ����ϴ� PL/SQL��
SET SERVEROUTPUT ON
DECLARE
    vdept dept%rowtype;     -- dept���̺��� ��� �÷��� �ڷ����� ����
    vdept_cnt NUMBER;       -- dept���̺��� ��� ��ȸ�ϴ� ����
BEGIN
    -- dept���̺��� ����� ��ȸ�ϰ�, �� ���� For Loop�� �������� ����
    SELECT count(*) INTO vdept_cnt FROM dept;

    dbms_output.put_line('�μ���ȣ  /   �μ���   /   ������'); 
    FOR cnt IN 1..vdept_cnt LOOP
        SELECT * INTO vdept 
        FROM dept WHERE deptno = 10 * cnt;
        
        dbms_output.put_line(vdept.deptno || '  /   ' || vdept.dname || '   /   ' || vdept.loc);
    END LOOP;
END;


-- 3. while loop��
--      while ���ǽ� loop
--          ����� ����;
--      end loop;

-- Q1. While Loop������ 1���� 5���� ���
SET SERVEROUTPUT ON
DECLARE
    n NUMBER := 1;      -- n������ �ʱⰪ�� 1�� ����
BEGIN
    WHILE n <= 5 LOOP
        dbms_output.put_line('n�� ��: ' || n);
        n := n + 1;
    END LOOP;
END;

-- Q2. While Loop������ ��(*)�� �ﰢ�� ������� ���
SET SERVEROUTPUT ON
DECLARE
    c NUMBER := 1;
    star VARCHAR2(100) := '';       -- star VARCHAR2(100); �� ��ġ
    -- star������ �� ���ڿ��� �ʱ�ȭ
BEGIN
    WHILE c <= 10 LOOP
        star := star || '*';        -- star ������ '*' ���ڸ� ����
        dbms_output.put_line(star); -- ������� ������ '*' ���ڸ� ���
        c := c + 1;                 --c ���� 1 ������Ŵ
    END LOOP;
END;

-- ��� ���ĵ� �ﰢ�� ����� ��(*)���� ���
    -- LPAD(string, length, pad_string): ���ڿ��� �������� �е�
            -- string: �е��� ��� ���ڿ�
            -- length: ���� ���ڿ��� ����
            -- pad_string: �е��� ����� ���ڿ� (�ɼ�)
    -- RPAD(string, length, pad_string): ���ڿ��� ���������� �е�
            -- string: �е��� ��� ���ڿ�
            -- length: ���� ���ڿ��� ����
            -- pad_string: �е��� ����� ���ڿ� (�ɼ�)
SET SERVEROUTPUT ON
DECLARE
    c NUMBER := 1;
    star VARCHAR2(100) := '*';   -- star������ �� ���ڿ��� �ʱ�ȭ
    total_space NUMBER := 10;
    space VARCHAR2(100);    --�� ������ ��½�ų ����
    
BEGIN
    WHILE c <= 10 LOOP
        space := LPAD(' ', total_space - c, ' ') ;
        star := RPAD(star, 2*c - 1, '*');
        
        dbms_output.put_line(space || star);
        c := c+1;
    END LOOP;
END;

