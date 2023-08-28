-- 2023. 08. 25 TEST

-- Q1.
-- book ���̺��� ����
CREATE TABLE book(
					no NUMBER(2) PRIMARY KEY,
					title  varchar2(25) NOT NULL, 
					author varchar2(20),
                    publisher varchar2(20),
                    price NUMBER(6),
					pub_day  DATE DEFAULT SYSDATE );

SELECT * FROM book;


-- Q2. Oracle �����ͺ��̽��� ���� ���� ��¥�� �⺻����(23/01/01)�� 
-- ����� ����(2023-01-01)���� ���ʷ� ����ϴ� SQL���� �ۼ�
-- 1) �⺻���� ���
SELECT SYSDATE FROM dual;
-- 2) ����� ���� ���
SELECT TO_CHAR(SYSDATE, 'YYYY-MM-DD') FROM dual;

SELECT sysdate, TO_CHAR(SYSDATE, 'YYYY-MM-DD') FROM dual;


-- Q3. ������̺�(EMP)���� �ִ� �޿��� �޴� ������,
--      �ִ�޿� �ݾ��� ����ϴ� SQL���� �ۼ�
SELECT ename, sal
FROM emp
WHERE sal = (SELECT MAX(sal) FROM emp);


-- Q4. MySQL�� Oracle�� DB Migration�� �ϰ��� �Ѵ�. 
-- ���̱׷��̼� �� ����� ���������� �Ʒ� ������ �ϼ��Ͻÿ�
-- 1) Oracle Sequence ����
CREATE SEQUENCE member_no_seq
    START with 1
    INCREMENT by 1;

-- seq ��� ���
SELECT * FROM seq;

-- 2) insert�� �ۼ�
INSERT INTO member VALUES(member_no_seq.nextval, 'hong');


-- Q5. name, phone �÷��� �⺻Ű. composite key(����Ű) �̸�(Constraint)�� member_compo_pk
CREATE TABLE member(
    name VARCHAR2(10),
    address varchar2(30),
    phone varchar2(16),
    CONSTRAINT member_compo_pk PRIMARY KEY (name, phone)
    );

-- ���̺� Ȯ��
desc member001;











                    
                    
                    
            