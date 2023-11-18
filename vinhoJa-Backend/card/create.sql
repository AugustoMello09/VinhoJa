create table tb_cartao (id uuid not null, cod varchar(255), data_exp varchar(255), nome_cartao varchar(255), numero_cartao varchar(255), primary key (id));
alter table if exists tb_cartao add constraint UK_lmtfahdxyjvotbpciossji5va unique (numero_cartao);
