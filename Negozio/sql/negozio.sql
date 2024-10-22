create database negozio;

use negozio;

create table prodotti(
id_prodotto int primary key auto_increment,
nome varchar(255),
prezzo decimal
);

create table clienti(
id_cliente int primary key auto_increment,
nome varchar(255),
email varchar(255)
);


create table prodotti_clienti(
id_cliente int,
id_prodotto int,
quantita int,
primary key(id_cliente,id_prodotto),
foreign key(id_cliente) references clienti(id_cliente),
foreign key(id_prodotto) references prodotti(id_prodotto)
);

create table fornitori(
id_fornitore int primary key auto_increment,
nome varchar(255)
);

create table fornitori_prodotti(
id_fornitore int,
id_prodotto int,
quantita_stock int,
primary key(id_fornitore, id_prodotto),
foreign key(id_fornitore) references fornitori(id_fornitore),
foreign key(id_prodotto) references prodotti(id_prodotto)

);

-- Insert sample records
INSERT INTO prodotti (nome, prezzo) VALUES
('Prodotto A', 10.5),
('Prodotto B', 20.0),
('Prodotto C', 15.7),
('Prodotto D', 30.0),
('Prodotto E', 25.0);

INSERT INTO clienti (nome, email) VALUES
('Cliente 1', 'cliente1@example.com'),
('Cliente 2', 'cliente2@example.com'),
('Cliente 3', 'cliente3@example.com'),
('Cliente 4', 'cliente4@example.com'),
('Cliente 5', 'cliente5@example.com');

INSERT INTO prodotti_clienti (id_cliente, id_prodotto,quantita) VALUES
(1, 1,50),
(2, 2,30),
(3, 3,40),
(4, 4,50),
(5, 5,60);

INSERT INTO fornitori (nome) VALUES
('Fornitore A'),
('Fornitore B'),
('Fornitore C'),
('Fornitore D'),
('Fornitore E');

INSERT INTO fornitori_prodotti (id_fornitore, id_prodotto, quantita_stock) VALUES
(1, 1, 100),
(2, 2, 200),
(3, 3, 150),
(4, 4, 300),
(5, 5, 250);


select * from fornitori_prodotti