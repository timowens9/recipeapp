# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table recipe (
  id                            integer auto_increment not null,
  name                          varchar(255),
  category                      varchar(255),
  calories                      integer,
  rating                        varchar(255),
  constraint pk_recipe primary key (id)
);

create table recipe_data (
  last_id                       integer not null
);


# --- !Downs

drop table if exists recipe;

drop table if exists recipe_data;

