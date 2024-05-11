-- 常用查询
-- 大写与小写
select name,lower(name),upper(name) from stus
-- 找最大或最小
select max(sallary),min(sallary) from stus
-- 替换显示，实际不会替换表中内容
select name,bonus,replace(bonus,100,1000) from stus
-- substring（string，a，b）提取stirng从a开始共b个字符，从1开始
select name,substring(name,1,2) from stus
-- 常用函数，绝对值abs，向上取整ceil，向下取整floor，四舍五入round，取余mod，Πpi，幂函数pow，开根号sqrt
select -abs(id),ceil(3.3),floor(3.3),round(3,3),mod(123,10),pi(),pow(2,6),sqrt(25) from stus
-- 虚表dual，不写也是虚表
select round(3.4),round(3.5),round(3.6) from dual
select round(3.4),round(3.5),round(3.6)
-- 几种常用时间函数
select curdate(),current_date(),curtime(),now(),sysdate()
-- sleep（n）休息n秒，两个时间相同
select now(),sleep(2),now()