create or replace procedure del_ename(vename in emp01.ename%TYPE)
is
begin
     delete from emp01 where ename=vename;
end;
/