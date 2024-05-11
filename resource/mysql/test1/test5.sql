create table student4(
	cno int primary key auto_increment,
	cname varchar(55)
)

create table student5(
	sno int primary key auto_increment,
	sname varchar(55),
	sex char(1),
	classname int,
	
	constraint fk_student5_classname foreign key(classname) references student4(cno)
)

select * from student4
select * from student5