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


CREATE TABLE if not exists "orders"
(
    id          serial primary key,
    customer_id bigint,
    total_price float,
    address varchar (255),
    order_date bigint,
    shipment_date bigint,
    delivery_date bigint,
    status varchar (32),
    token varchar(255)
);

alter table "orders"
    owner to postgres;

CREATE TABLE if not exists orderItem
(
    id serial primary key,
    product_id bigint,
    order_id bigint,
    quantity bigint,
    weight float,
    price float,
    status varchar (32)
);
alter table orderItem
    owner to postgres;

ALTER TABLE "orders"
    ADD CONSTRAINT fk9
        FOREIGN KEY (customer_id) REFERENCES customer (id);

ALTER TABLE orderItem
    ADD CONSTRAINT fk10
        FOREIGN KEY (product_id) REFERENCES product (id);

ALTER TABLE orderItem
    ADD CONSTRAINT fk11
        FOREIGN KEY (order_id) REFERENCES orders (id);