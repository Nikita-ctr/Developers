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





create table developers (
                            id  bigserial not null,
                            date_of_birth timestamp,
                            first_name varchar(30),
                            last_name varchar(90),
                            project_hours int4,
                            primary key (id)
);


create table developers_projects (
                                     developer_id int8 not null,
                                     projects_id int8 not null,
                                     primary key (developer_id, projects_id)
);


create table project (
                         id  bigserial not null,
                         name varchar(255),
                         developers_id int8,
                         primary key (id)
);


alter table developers_projects
    add constraint developers_projects_k unique (projects_id);


alter table developers_projects
    add constraint dev_prod_k
        foreign key (projects_id)
            references project;


alter table developers_projects
    add constraint developers_projects_id_k
        foreign key (developer_id)
            references developers;


alter table project
    add constraint project_k
        foreign key (developers_id)
            references developers