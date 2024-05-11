-- 查询时sleep（），now函数与sysdate函数的变化
select now(),sysdate(),sleep(2),now(),sysdate()
-- 查询if语句的使用
select name,sallary,if(sallary>5000,'high','low') as sallary_level from stus
-- ifnull语句的使用，可以实现int+null=int
select name,sallary,bonus,sallary+ifnull(bonus,0) from stus

-- case语句的使用，常用于分类
select name,sallary,
	case
		when sallary>5000 then 'A'
		when sallary>3000 then 'B'
		when sallary>500 then 'C'
		else 'D'
	end
from stus

-- 其他的常用函数，databse数据库，version版本，inet_aton和inet_ntoa网址
select database(),version(),user(),inet_aton('10.194.183.33'),inet_ntoa(180533025)