# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table recipe (
  id                            bigint auto_increment not null,
  name                          varchar(255),
  category                      varchar(255),
  calories                      integer,
  rating                        integer,
  constraint pk_recipe primary key (id)
);


# --- !Downs

drop table if exists recipe;

