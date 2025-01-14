use vttp_2025;
drop table reservation;

create table Customer(
	id int not null auto_increment,
    fullname varchar(255) not null,
    email varchar(255) not null,
    constraint pk_customer_id primary key(id)
);

#select * from room;

create table Room(
	id int not null auto_increment,
    roomtype varchar(150) not null,
    price float default '150.0',
    constraint pk_room_id primary key(id)
);

create table Reservation (
	id int not null auto_increment,
	customer_id int,
    room_id int,    
	start_date date,
    end_date date,
    cost float,
	constraint pk_reservation_id primary key(id),
	constraint fk_customer_id foreign key(customer_id) references customer(id),
	constraint fk_room_id foreign key(room_id) references room(id)
);

insert into room (roomtype, price) values ('standard', 150.0);
insert into room (roomtype, price) values ('deluxe', 200.0);
insert into room (roomtype, price) values ('super deluxe', 250.0);
insert into room (roomtype, price) values ('president', 300.0);
insert into room (roomtype, price) values ('suite', 350.0);
insert into customer (fullname, email) values ('Emily Quek', 'emilyquek@visa.com.sg');
insert into customer (fullname, email) values ('Samuel Phuar', 'samuelphuar@visa.com.sg');
insert into customer (fullname, email) values ('Aloysius Kang', 'aloysiuskang@visa.com.sg');
insert into customer (fullname, email) values ('Donovan Mitchell', 'donovanmitchell@visa.com.sg');
insert into customer (fullname, email) values ('test', 'tester@visa.com.sg');


select * from customer;
