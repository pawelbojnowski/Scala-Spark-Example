create schema spark_scala_mysql;
use spark_scala_mysql;

create table billing
(
    id       int auto_increment primary key,
    form     varchar(9) not null,
    `to`     varchar(9) not null,
    duration bigint     not null,
    constraint billing_id_uindex unique (id)
);


INSERT INTO billing (id, form, `to`, duration)
VALUES (1, '300300300', '100200100', 23123123);
INSERT INTO billing (id, form, `to`, duration)
VALUES (2, '200200200', '300300300', 3000000);
INSERT INTO billing (id, form, `to`, duration)
VALUES (3, '100100100', '200200200', 10000000);