use vttp_2025;

drop table tv_shows;

create table tv_shows(
	prog_id int not null auto_increment,
    title char(64) not null,
    lang char(64) not null,
    official_site varchar(255),
    rating enum('G','PG', 'NC16','M18','R21') not null,
    user_rating float default '0.0',
    release_date date,
    image blob,
    constraint pk_prog_id primary key (prog_id),
    constraint chk_user_rating
		check(user_rating between 0.0 and 10.0)
);

insert into tv_shows (title, lang, rating, user_rating, release_date) values ('AI will win','Chinese','PG', 7.5,'2025-01-25');
insert into tv_shows (title, lang, rating, user_rating, release_date) values ('Trolls','English','NC16', 8.2,'2024-11-22');
insert into tv_shows (title, lang, rating, user_rating, release_date) values ('Hacksaw Ridge','Espanol','M18', 4.2,'2019-12-11');
insert into tv_shows (title, lang, rating, user_rating, release_date) values ('Angry Birds','English','NC16', 3.5,'2023-12-25');
insert into tv_shows (title, lang, rating, user_rating, release_date) values ('Shes Not That Into You','English','PG', 7.8,'2007-09-14');
insert into tv_shows (title, lang, rating, user_rating, release_date) values ('Lady Bird','English','NC16', 9.0,'2024-11-22');
insert into tv_shows (title, lang, rating, user_rating, release_date) values ('Transformers','Russian','PG', 6.8,'2008-08-28');
insert into tv_shows (title, lang, rating, user_rating, release_date) values ('Peacemaker','Russian','PG', 5.5,'2022-01-12');
insert into tv_shows (title, lang, rating, user_rating, release_date) values ('Inglorious Basterds','Spanish','R21', 7.5,'2021-04-29');
insert into tv_shows (title, lang, rating, user_rating, release_date) values ('','English','NC16', 8.2,'2024-11-22');
insert into tv_shows (title, lang, rating, user_rating, release_date) values ('Hacksaw Ridge','Espanol','M18', 4.2,'2019-12-11');
insert into tv_shows (title, lang, rating, user_rating, release_date) values ('Angry Birds','English','NC16', 3.5,'2023-12-25');
insert into tv_shows (title, lang, rating, user_rating, release_date) values ('Shes Not That Into You','English','PG', 7.8,'2007-09-14');
insert into tv_shows (title, lang, rating, user_rating, release_date) values ('Lady Bird','English','NC16', 9.0,'2024-11-22');
insert into tv_shows (title, lang, rating, user_rating, release_date) values ('Transformers','Russian','PG', 6.8,'2008-08-28');
insert into tv_shows (title, lang, rating, user_rating, release_date) values ('Peacemaker','Russian','PG', 5.5,'2022-01-12');
insert into tv_shows (title, lang, rating, user_rating, release_date) values ('Batman','Spanish','PG', 8.0,'2023-01-12');

select * from tv_shows;
select distinct lang from tv_shows;
select distinct lang, rating, title from tv_shows;

#Aggregation
select count(*) from tv_shows;
select count(*) from tv_shows where lang like 'English'; #count no. of shows where lang is English
select count(distinct title) from tv_shows where lang like 'English%'; #count no. of shows where lang is like English with no duplicate titles
select count(distinct title) from tv_shows where lang in ('English', 'Russian'); #count no. of shows where lang is English/Russian with no duplicate titles

select avg(user_rating) from tv_shows where lang in ('English', 'Russian');
select sum(user_rating) from tv_shows;
select sum(user_rating)/count(*) from tv_shows;

select count(rating) from tv_shows group by rating; # we need rating at the start as our row header
select rating, count(rating) from tv_shows group by rating;
select rating, count(rating) from tv_shows group by rating order by count(rating) asc;
select rating, count(rating) as cnt from tv_shows group by rating order by count(rating) asc;
select rating, count(rating) from tv_shows where lang in ('English') group by rating order by count(rating) asc ;
select rating, count(rating) from tv_shows where lang in (select distinct lang from tv_shows) group by rating order by count(rating) asc ; #language condition is basically every distinct language


#'where' clause is evaluated before aggregation happens. To filter aggregated results, we need to filter using 'having' instead of 'where'.
#'where' happens before 'groupby', 'having' happens after 'groupby'
select rating, count(rating)
	from tv_shows
    group by rating
    having count(rating) > 1;

select rating, count(rating)
	from tv_shows
    where lang like 'English'
    group by rating
    having count(rating) > 0
    order by rating desc;


select title, user_rating, lang
	, max(user_rating) over (partition by lang) as max_rating
    from tv_shows;


# over partition by, divides data into different groups
# order by, organises the data within each partition, optional clause within partition by ()
# both are usually used with window functions to perform operations at the start (SUM/AVG etc.)

create table car(
	id int not null auto_increment,
    make varchar(50),
    model varchar(50),
    cartype varchar(50),
    price float default '10000.0',
    constraint pk_car_id primary key (id)
);

insert into car (make, model, cartype, price) values ('Hyundai', 'Avante', 'Sedan', 80000.0);
insert into car (make, model, cartype, price) values ('Toyota', 'Altis', 'Sedan', 90000.0);
insert into car (make, model, cartype, price) values ('Mercedes', 'Atlas', 'Sedan', 70000.0);
insert into car (make, model, cartype, price) values ('Proton', 'Msian', 'Lorry', 75000.0);
insert into car (make, model, cartype, price) values ('BYD', 'Super', 'EV', 90000.0);
insert into car (make, model, cartype, price) values ('Tesla', 'Supreme', 'EV', 80000.0);
insert into car (make, model, cartype, price) values ('Proton', 'Msian', 'Sedan', 76000.0);
insert into car (make, model, cartype, price) values ('BYD', 'Supar', 'Sedan', 90000.0);
insert into car (make, model, cartype, price) values ('Tesla', 'Supreme', 'Lorry', 80000.0);

select * from car;
select make, model, cartype, price from car; # no primary key
select make, model, cartype, price,
	max(price) over (partition by cartype) as max_cartype #shows max price for each cartype
    from car;

select make, model, cartype, price,
	sum(price) over (partition by cartype) as sum_cartype #shows sum price for each cartype
    from car;

select make, model, cartype, price,
	sum(price) over (partition by model) as sum_model #shows sum price for each model
    from car;

select make, model, cartype, price
	,avg(price) over (partition by model) as avg_model #shows avg price for each model
	,avg(price) over (partition by cartype) as avg_cartype #shows avg price for each cartype
    from car;



#PM exercise
drop table dependant;
drop table employee;

create table employee(
	id int not null auto_increment,
    first_name varchar(50) not null,
    last_name varchar(50) not null,
    email varchar(255),
    job_title varchar(100),
    department varchar(100),
    employment_date date,
    salary float,
    active bool,
    constraint pk_employee_id primary key (id)
);


create table dependant(
	id int not null auto_increment,
    first_name varchar(50) not null,
    last_name varchar(50) not null,
    birth_date date,
    relationship varchar(30),
    employee_id int,
	constraint pk_department_id primary key (id),
    constraint fk_employee_id foreign key(employee_id) references employee(id)
);


insert into employee (first_name, last_name, email, job_title, department, employment_date, salary, active)
	values ('Samuel', 'Phuar', 'sphuar@visa.com.sg', 'intern', 'development', '2024-10-01', 3500, true);
    
select * from employee;

#instead of delete entry, use below for DeleteMapping
update employee set active = false where id = 1;

# for UpdateMapping
update employee set
	first_name = 'Alibaba',
    last_name = 'alibaba@alibaba.com.sg',
    job_title = 'CEO',
    department = 'master of no one',
    employment_date = '2025-01-01',
    salary = '25000',
    active = true
    where id = 1;


