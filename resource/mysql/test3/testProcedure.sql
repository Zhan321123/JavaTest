-- 创建函数，类似于方法
create procedure testproc1(in name varchar(20))
 begin
	if name is null or name='' then
		select * from stus;
	else
		select * from stus where name like concat('%',name,'%');
	end if;
end

-- 使用函数
call testproc1('l')

-- 删除函数
drop procedure testproc1