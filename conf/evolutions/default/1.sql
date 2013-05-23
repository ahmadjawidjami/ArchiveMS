# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table category_storage (
  category_name             varchar(255) not null,
  constraint pk_category_storage primary key (category_name))
;




# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table category_storage;

SET FOREIGN_KEY_CHECKS=1;

