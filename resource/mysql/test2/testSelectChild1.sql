select sallary from stus where name='liu'
select * from stus where sallary<=(select sallary from stus where name='wei')
select * from stus where sallary=(select sallary from stus where name='zhan')

select * from stus where sallary<any(select sallary from stus where hiredate='2023-10-4')
select * from stus where sallary<all(select sallary from stus where hiredate='2023/10/4')
select * from stus where sallary<(select min(sallary) from stus where hiredate='2023/10/4')

select * from stus where sallary in (select sallary from stus where hiredate='2023-10-4')