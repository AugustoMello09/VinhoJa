create table tb_user (id uuid not null, email varchar(255), nome varchar(255), primary key (id));
alter table if exists tb_user add constraint UK_4vih17mube9j7cqyjlfbcrk4m unique (email);
