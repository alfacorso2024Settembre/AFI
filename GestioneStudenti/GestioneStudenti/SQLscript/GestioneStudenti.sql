create database GestioneStudenti;

use GestioneStudenti;

create table corsi(
	id_corso int not null auto_increment primary key,
	nome varchar(255) not null,
	crediti int
);

create table insegnanti(
	id_insegnante int not null auto_increment primary key,
	nome varchar(255) not null,
	email varchar(255) not null
);

create table studenti(
	matricola bigint not null auto_increment primary key,
	email varchar(255) not null
);

create table esami(
	id_esame int not null auto_increment primary key,
	id_corso int not null,
	durata int,
	data date,
	ora_inizio time,
	foreign key (id_corso) references corsi(id_corso)
);

insert into corsi (nome, crediti) values 
('Matematica', 6), 
('Fisica', 9), 
('Informatica', 12);

insert into insegnanti (nome, email) values 
('Mario Rossi', 'm.rossi@universita.it'), 
('Giovanni Bianchi', 'g.bianchi@universita.it'), 
('Luisa Verdi', 'l.verdi@universita.it');

insert into studenti (email) values 
('studente1@universita.it'), 
('studente2@universita.it'), 
('studente3@universita.it');

insert into esami (id_corso, durata, data, ora_inizio) values 
(1, 120, '2024-10-20', '09:00:00'), 
(2, 180, '2024-11-15', '14:00:00'), 
(3, 240, '2024-12-10', '08:30:00');
