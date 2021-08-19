create schema cookbook;

use cookbook;

create user 'user'@'localhost' identified by 'pass123';

grant select, insert, delete, update on cookbook.* to user@'localhost';

create table rec_receita (
  rec_id bigint unsigned not null auto_increment,
  rec_nome varchar(20) not null,
  primary key (rec_id),
  unique key uni_receita_nome (rec_nome)
);

create table ing_ingrediente (
  ing_id bigint unsigned not null auto_increment,
  ing_nome varchar(20) not null,
  primary key (ing_id),
  unique key uni_ingrediente_nome (ing_nome)
);

create table rei_receita_ingrediente (
  rec_id bigint unsigned not null,
  ing_id bigint unsigned not null,
  primary key (rec_id, ing_id),
  foreign key receita_fk (rec_id) references rec_receita (rec_id) on delete restrict on update cascade,
  foreign key ingrediente_fk (ing_id) references ing_ingrediente (ing_id) on delete restrict on update cascade
);
