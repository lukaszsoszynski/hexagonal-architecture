create sequence hexagonal_architecture.seq_post start 1000 increment 1;
create sequence hexagonal_architecture.seq_thread start 1000 increment 1;


CREATE TABLE hexagonal_architecture.forum (
    name character varying(25) PRIMARY KEY,
    title character varying(150) NOT NULL
);

insert into hexagonal_architecture.forum(name, title) values('java', 'Java programing language');
insert into hexagonal_architecture.forum(name, title) values('scala', 'Scala programing language');
insert into hexagonal_architecture.forum(name, title) values('groovy', 'Groovy programing language');
insert into hexagonal_architecture.forum(name, title) values('kotlin', 'Kotlin programing language');
insert into hexagonal_architecture.forum(name, title) values('javascript', 'Ecmascript');
insert into hexagonal_architecture.forum(name, title) values('ruby', 'Programing language with a name of precious stone');

CREATE TABLE hexagonal_architecture.thread (
  id bigint NOT NULL,
  forum_name character varying(25) constraint fk_post_forum_name_forum_name references hexagonal_architecture.forum(name) not null,
  thread_name character varying(250) not null,
  CONSTRAINT thread_pkey PRIMARY KEY (id)
);

CREATE TABLE hexagonal_architecture.post (
  id bigint NOT NULL,
  thread_id bigint NOT NULL constraint fk_post_thread_id_thread_id references hexagonal_architecture.thread(id) not null,
  content character varying(255),
  title character varying(255),
  CONSTRAINT post_pkey PRIMARY KEY (id)
);
