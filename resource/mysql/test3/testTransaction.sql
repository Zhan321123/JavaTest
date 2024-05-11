-- 事物的开始、提交、打回
-- 用于转账时出现故障

create table account(
	id int,
	name varchar(55),
	balance int
)
select * from account
-- 开始转账事务
start transaction;
update account set balance=balance-300 where name='liu';
update account set balance=balance+300 where name='wei';
select * from account;
-- 提交，没提交之前不会修改数据库的数据，但是查询的是更改的数据
commit;
-- 打回
rollback