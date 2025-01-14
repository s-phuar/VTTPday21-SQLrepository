create database RSVP;
use RSVP;

create table rsvp(
	name varchar(50),
    email varchar(50) not null,
    phone char(20),
    confirmation_date date,
    comments varchar(255),
    constraint pk_email primary key (email)
);

insert into rsvp (name, email, phone, confirmation_date, comments) values ('samuel', 'samuel@gmail.com', '91529241', '2025-01-01', 'no comment');
insert into rsvp (name, email, phone, confirmation_date, comments) values ('samantha', 'samantha@gmail.com', '93572950', '2025-01-02', 'some comment');
insert into rsvp (name, email, phone, confirmation_date, comments) values ('samsung', 'samsung@gmail.com', '96730175', '2025-01-02', 'all comment');
insert into rsvp (name, email, phone, confirmation_date, comments) values ('fred', 'fred@gmail.com', '92419152', '2024-01-01', 'some comment');
insert into rsvp (name, email, phone, confirmation_date, comments) values ('frederick', 'frederick@gmail.com', '92937552', '2024-01-02', 'all comment');
insert into rsvp (name, email, phone, confirmation_date, comments) values ('freddie', 'freddie@gmail.com', '92424962', '2024-01-03', 'no comment');
insert into rsvp (name, email, phone, confirmation_date, comments) values ('jack', 'jack@gmail.com', '96693399', '2023-01-01', 'all comment');
insert into rsvp (name, email, phone, confirmation_date, comments) values ('jackiechan', 'jackiechan@gmail.com', '96888899', '2023-01-02', 'no comment');
insert into rsvp (name, email, phone, confirmation_date, comments) values ('jackfruit', 'jackfruit@gmail.com', '96777799', '2023-01-03', 'some comment');


select * from rsvp;




