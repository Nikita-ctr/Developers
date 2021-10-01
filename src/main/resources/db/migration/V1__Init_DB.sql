create sequence confirmation_token_sequence start 2 increment 1;
create sequence student_sequence start 2 increment 1;


create table app_user (
                          id int8 not null,
                          app_user_role varchar(255),
                          email varchar(255),
                          enabled boolean,
                          first_name varchar(255),
                          last_name varchar(255),
                          locked boolean,
                          password varchar(255),
                          primary key (id)
);


create table confirmation_token (
                                    id int8 not null,
                                    confirmed_at timestamp,
                                    created_at timestamp not null,
                                    expires_at timestamp not null,
                                    token varchar(255) not null,
                                    app_user_id int8 not null,
                                    primary key (id)
);


alter table confirmation_token
    add constraint confirmation_token_fk
        foreign key (app_user_id)
            references app_user;





create table books (
                       id  bigserial not null,
                       date_of_issue timestamp with time zone,
                       price int4,
                       title varchar(90),
                       primary key (id)
);


create table books_genres (
                              book_id int8 not null,
                              genres_id int8 not null,
                              primary key (book_id, genres_id)
);


create table genres (
                        id  bigserial not null,
                        genre varchar(255),
                        book_id int8,
                        primary key (id)
);


alter table books_genres
    add constraint books_genres_id_k unique (genres_id);


alter table books_genres
    add constraint genres_id_k
        foreign key (genres_id)
            references genres;


alter table books_genres
    add constraint books_genres_k
        foreign key (book_id)
            references books;


alter table genres
    add constraint genre_k
        foreign key (book_id)
            references books