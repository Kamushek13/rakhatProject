CREATE TABLE if not exists "customer"
(
    id       serial primary key,
    fullname varchar(128),
    phone    varchar(32),
    email    varchar(32),
    address  varchar(32),
    company  varchar(32),
    auth_id  bigint
);
alter table "customer"
    owner to postgres;

CREATE TABLE if not exists "category"
(
    id          serial primary key,
    name        varchar(32),
    description varchar(255)
);
alter table "category"
    owner to postgres;

CREATE TABLE if not exists "product"
(
    id          serial primary key,
    name        varchar(32),
    description varchar(255),
    weight      float,
    unit        varchar(128),
    composition varchar(255),
    category_id bigint,
    price       float,
    stock       float
);
alter table "product"
    owner to postgres;

CREATE TABLE if not exists "auth"
(
    id          serial primary key,
    username    varchar(32),
    password    varchar(32),
    customer_id bigint
);
alter table auth
    owner to postgres;


ALTER TABLE "customer"
    ADD CONSTRAINT fk2
        FOREIGN KEY (auth_id) REFERENCES auth (id);


ALTER TABLE "product"
    ADD CONSTRAINT fk7
        FOREIGN KEY (category_id) REFERENCES "category" (id);
