                      CREATE TABLE if not exists "status"
(
    id          serial primary key,
    name varchar(255)
);

alter table "orders"
    owner to postgres;

INSERT INTO status (name) values
('ordered'),
('shipmented'),
('delivered');
