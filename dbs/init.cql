create keyspace spark_scala_cassandra with replication = {'class': 'SimpleStrategy', 'replication_factor': 1};

use spark_scala_cassandra;

create table client
(
    id           int primary key,
    firstname    text,
    lastname     text,
    phone_number int
);

INSERT INTO  client (id, firstname, lastname, phone_number)
VALUES (1, 'Jan', 'Nowak', 100100100);
INSERT INTO client (id, firstname, lastname, phone_number)
VALUES (2, 'Tomasz', 'Kowalski', 200200200);
INSERT INTO client (id, firstname, lastname, phone_number)
VALUES (3, 'Tomasz', 'Nowak', 300300300);
