# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table details_storage (
  id                        integer auto_increment not null,
  category                  varchar(255),
  name                      varchar(255),
  tag                       varchar(255),
  publish_date              varchar(255),
  record_date               varchar(255),
  archive_date              varchar(255),
  path                      varchar(255),
  constraint pk_details_storage primary key (id))
;




# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table details_storage;

SET FOREIGN_KEY_CHECKS=1;

