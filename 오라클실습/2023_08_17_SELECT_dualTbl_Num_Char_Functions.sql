-- 2023.08.17(��)

--  10�� 20�� ���� ����� ���̺��� ����
    -- ���̺� ���� �����Ͱ� ���� ���¿��� ���� ������ �����ϸ�
    -- ���̺��� �� �࿡ ���� 10�� 20�� ���� ��(30)�� �״�� ��µ�
SELECT 10+20 FROM dept;         -- 4�� ���
SELECT 10+20 FROM emp;          -- 14�� ���

-- dual ���̺�
-- 1. dual���̺��� sys���� ������ ���̺��̰�, ���� ���Ǿ�� �����Ǿ� ����
-- 2. dual���̺��� ������ �Ǿ� �ֱ� ������ ������ ����� �� ����
-- 3. dual���̺��� �����Ͱ� 1�� �ۿ� ���� ������, �������� 1���� ���
DESCRIBE dual;          -- dummy��� �÷� 1����
desc dual;
--DUMMY    VARCHAR2(1) 

    -- DUAL" ���̺��� ��� ����ڿ��� �������� �����Ǵ� ���̺��̹Ƿ�, 
    -- "sys.dual"�� "dual"�� ������ �ǹ�
SELECT 10+20 FROM dual;     -- 1�� ���
SELECT 10+20 FROM sys.dual;     -- "sys" ��Ű���� ���� "DUAL" ���̺��� 10�� 20�� ���� ���

SELECT * FROM dual;             -- X ������ 1�� ����.

SELECT * FROM sys.tab;
SELECT * FROM tab;          -- tab: ���� ���Ǿ�

-- 1. ���� ó�� �Լ�-----------------------------------------------------
-- abs(): ���밪�� �����ִ� �Լ�
--        �Լ����� ��,�ҹ��ڸ� �������� ����
SELECT -10, abs(-10), ABS(-10) FROM dual;

-- floor(): �Ҽ��� ���ϸ� ������ ����
SELECT 34.5678, floor(34.5678) FROM dual;

-- round(): Ư�� �ڸ����� �ݿø��� ���ִ� �Լ�
-- round(���, �ڸ���)
SELECT 34.5678, round(34.5678) FROM dual;       -- 35: �Ҽ� ù°�ڸ����� �ݿø�
SELECT 34.5678, round(34.5678, 2) FROM dual;    -- 34.57: �Ҽ� ��°�ڸ����� �ݿø�
SELECT 34.5678, round(34.5678, -1) FROM dual;   -- 30: �����ڸ����� �ݿø�
SELECT 34.5678, round(35.5678, -1) FROM dual;   -- 40: �����ڸ����� �ݿø�

-- trunc(): Ư�� �ڸ����� �߶󳻴�(������) ����
-- trunc(���, �ڸ���)
SELECT trunc(34.5678), trunc(34.5678, 2), trunc(34.5678, -1) FROM dual;
        --  34              34.56               30

-- mod(): �������� �����ִ� �Լ�
SELECT mod(27, 2), mod(27, 5), mod(27, 7) FROM dual;
        --  1           2           6

-- Q. ��� ���̺��� �����ȣ�� Ȧ���� ������� ����ϴ� SQL��
SELECT ename, empno FROM emp where mod(empno, 2)=1;


-- 2. ���� ó�� �Լ� -----------------------------------------------------
-- upper(): �빮�ڷ� ��ȯ���ִ� �Լ�
SELECT 'Welcome to Oracle', upper('Welcome to Oracle') FROM dual;

-- lower(): �ҹ��ڷ� ��ȯ���ִ� �Լ�
SELECT 'Welcome to Oracle', lower('Welcome to Oracle') FROM dual;

-- initcap(): �� �ܾ��� ù���ڸ� �빮�ڷ� ��ȯ���ִ� �Լ�
SELECT 'Welcome to Oracle', initcap('welcome to oracle') FROM dual;

-- Q. ��� ���̺��� job�� manager�� ����� �˻��ϴ� SQL�� �ۼ�
SELECT * FROM emp WHERE job = upper('manager');
SELECT * FROM emp WHERE lower(job) = 'manager';

-- length(): ���ڿ��� ���̸� �����ִ� �Լ�(���ڼ�)
SELECT length('oracle'), length('����Ŭ') FROM dual;
--              6                   3

-- lengthb(): ���ڿ��� ���̸� ����Ʈ�� �����ִ� �Լ�
-- ���� 1���� : 1byte, �ѱ� 1����: 3byte
SELECT lengthb('oracle'), lengthb('����Ŭ') FROM dual;
--              6                   9(�ѱ� 3����)

-- substr(): ���ڿ��� �Ϻθ� ������ �� ���Ǵ� �Լ�
-- ����: substr(��� ���ڿ�, ������ġ, ������ ���ڰ���)
--      ������ ���۹�ȣ�� ���ʺ��� 1������ ����
SELECT substr('Welcome to Oracle', 4, 3) FROM dual;     -- com ���
SELECT substr('Welcome to Oracle', -4, 3) FROM dual;    -- acl ���
SELECT substr('Welcome to Oracle', -6, 3) FROM dual;    -- Ora ���

-- Q1. ��� ���̺��� �Ի���(hiredate)�� ��, ��, ���� �����ϴ� SQL��
SELECT substr(hiredate, 1, 2) as "��",
       substr(hiredate, 4, 2) as "��",
       substr(hiredate, 7, 2) as "��" FROM emp;

-- Q2. ��� ���̺��� 87�⵵�� �Ի��� ����� �˻��ϴ� SQL��
SELECT * FROM emp WHERE substr(hiredate, 1, 2) = '87';

-- Q3. ��� ���̺��� ������� E�� ������ ����� �˻��ϴ� SQL��
    -- Like �񱳿����� ���
SELECT * FROM emp WHERE ename LIKE '%E';
    -- substr()�Լ� ���
SELECT * FROM emp WHERE substr(ename, -1, 1) = 'E';


-- instr() : Ư�� ������ ��ġ�� �����ִ� �Լ�
-- instr(���, ã�� ����): ���� ���� ������ ������ ��ġ�� ã����
-- instr(���, ã�� ����, ������ġ, ���° �߰�)

-- Q1. ���� ���� ������ 'O'�� ��ġ�� ã����
SELECT instr('Welcome to oracle', 'o') from dual;       -- 5

-- Q2. 6�� ���Ŀ� 2��° �߰ߵ� 'o'�� ��ġ�� ã����
SELECT instr('Welcome to oracle', 'o', 6, 2) from dual;     -- 12

-- Q3. ��� ���̺��� ������� 3��° �ڸ��� R�� �Ǿ��ִ� ����� �˻��ϴ� SQL��
    -- 3���� ���) LIKE������, SUBSTR()�Լ�, INSTR()�Լ�
-- 1) LIKE������ ���
SELECT * FROM emp WHERE ename LIKE '__R%';
-- 2) SUBSTR()�Լ� ���
SELECT * FROM emp WHERE substr(ename, 3, 1) = 'R';
-- 3) INSTR()�Լ� ���
SELECT * FROM emp WHERE instr(ename, 'R') = 3;
SELECT * FROM emp WHERE instr(ename, 'R', 3, 1) = 3;


-- lpad() / rpad(): Ư�� ��ȣ�� ä���ִ� ����
SELECT lpad('Oracle', 20, '#') FROM dual;       -- ##############Oracle
SELECT rpad('Oracle', 20, '#') FROM dual;       -- Oracle##############


-- ltrim(): ���� ������ �������ִ� �Լ�
-- rtrim(): ������ ������ �������ִ� �Լ�
SELECT '  Oracle  ', ltrim('  Oracle  ') FROM dual;
SELECT '  Oracle  ', rtrim('  Oracle  ') FROM dual;
SELECT ltrim('12345', '1') FROM dual;
SELECT ltrim('12345#####', '#') FROM dual;

-- trim() : ���ڿ� ��, ������ ������ �������ִ� �Լ�
--          Ư�� ���ڸ� �߶󳻴� �Լ�
SELECT '  Oracle  ', trim('   Oracle   ') from dual;
SELECT trim('a' from 'aaaaaOracleaaaaa') from dual; 		-- Oracle
SELECT trim(leading 'a' from 'aaaaaOracleaaaaa') from dual; -- Oracleaaaaa
SELECT trim(trailing 'a' from 'aaaaaOracleaaaaa') from dual;   -- aaaaaOracle

