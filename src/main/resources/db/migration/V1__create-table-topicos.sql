CREATE TABLE topicos (
  id bigint not null auto_increment,
  titulo VARCHAR(100) not null unique,
  mensaje VARCHAR(200) not null unique,
  fecha datetime not null,
  status VARCHAR(100) not null,
  autor VARCHAR(100) not null,
  curso VARCHAR(100) not null,
  primary key(id)
);