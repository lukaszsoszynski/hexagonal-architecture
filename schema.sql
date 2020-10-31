create sequence hexagonal_architecture.seq_post start 1000 increment 10;
create sequence hexagonal_architecture.seq_thread start 1000 increment 10;

CREATE TABLE hexagonal_architecture.user (
    email character varying(255) NOT NULL,
    first_name character  varying(255),
    last_name character varying(255),
    password character varying(255) NOT NULL,
    registered_date timestamp NOT NULL,
    date_of_birth timestamp,
    CONSTRAINT user_pkey PRIMARY KEY (email)
);


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
  creator character varying(255) constraint fk_thread_creator_user_email references hexagonal_architecture.user(email) NOT NULL,
  CONSTRAINT thread_pkey PRIMARY KEY (id)
);

CREATE TABLE hexagonal_architecture.post (
  id bigint NOT NULL,
  thread_id bigint NOT NULL constraint fk_post_thread_id_thread_id references hexagonal_architecture.thread(id) not null,
  content character varying(255),
  title character varying(255),
  author character varying(255) constraint fk_post_author_user_email references hexagonal_architecture.user(email) NOT NULL,
  CONSTRAINT post_pkey PRIMARY KEY (id)
);
