use northwind;

create user 'samuel'@'%'
	identified by 'password';
grant all privileges on northwind.*
	to 'samuel'@'%';
flush privileges;

select * from customers;