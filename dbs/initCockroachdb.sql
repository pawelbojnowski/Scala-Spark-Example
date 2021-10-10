create schema if not exists spark_scala_cockroachdb;


create table spark_scala_cockroachdb.billing
(
    id       int    not null,
    "from"   string not null,
    "to"     string not null,
    duration bigint
);

create unique index billing_id_uindex
    on spark_scala_cockroachdb.billing (id);

alter table spark_scala_cockroachdb.billing
    add constraint billing_pk
        primary key (id);



INSERT INTO spark_scala_cockroachdb.billing (id, "from", "to", duration)
VALUES (1, '300300300', '10020000', 23123123);
INSERT INTO spark_scala_cockroachdb.billing (id, "from", "to", duration)
VALUES (2, '200200200', '30030000', 3000000);
INSERT INTO spark_scala_cockroachdb.billing (id, "from", "to", duration)
VALUES (3, '100100100', '200200200', 10000000);