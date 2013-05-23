# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table details_storage (
  id                        integer auto_increment not null,
  name                      varchar(255),
  category                  varchar(255),
  content                   varchar(255),
  path                      varchar(255),
  publish_date              datetime,
  record_date               datetime,
  archive_date              datetime,
  constraint pk_details_storage primary key (id))
;




# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table details_storage;

SET FOREIGN_KEY_CHECKS=1;

