use northwind;

#created samuel user, to use northwind database
create user 'samuel'@'%'
	identified by 'password';
grant all privileges on northwind.*
	to 'samuel'@'%';
flush privileges;

#additional syntax to grant access to other tables
grant all privileges on vttp_2025.*
	to 'samuel'@'%';
flush privileges;


select * from customers where id = 123;
select * from orders where customer_id = 122;
