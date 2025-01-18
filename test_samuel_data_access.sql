use vttp_2025;
create table test_table(
	id int not null,
    constraint pk_id primary key (id)
);

drop table test_table;