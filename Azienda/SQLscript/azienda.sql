create database azienda;
use azienda;

create table reparti(
	nome_reparto varchar(255) not null primary key
);

create table dipendenti(
	email varchar(255) not null primary key,
  nome_dipendente varchar(255),
  ruolo varchar(255),
  nome_reparto varchar(255),
  foreign key (nome_reparto) references reparti(nome_reparto)
);

create table progetti(
	id_progetto int not null auto_increment primary key,
  data_inizio date,
  data_fine date,
  descrizione varchar(255)
);

create table reparti_progetti(
	nome_reparto varchar(255) not null,
  id_progetto int not null,
  primary key(nome_reparto, id_progetto)
);

insert into azienda.reparti (nome_reparto) values 
('IT'), 
('HR'), 
('Finance');

insert into azienda.dipendenti (email, nome_dipendente, ruolo, nome_reparto) values 
('mario.rossi@example.com', 'Mario Rossi', 'Manager', 'IT'), 
('luisa.bianchi@example.com', 'Luisa Bianchi', 'HR Specialist', 'HR'), 
('franco.verdi@example.com', 'Franco Verdi', 'Analyst', 'Finance');

insert into azienda.progetti (data_inizio, data_fine, descrizione) values 
('2023-01-01', '2023-06-01', 'Upgrade IT infrastructure'), 
('2023-07-01', '2023-12-31', 'Employee Satisfaction Survey'), 
('2024-01-15', '2024-05-15', 'Financial Forecast 2024');

insert into azienda.reparti_progetti (nome_reparto, id_progetto) values 
('IT', 1), 
('HR', 2), 
('Finance', 3);






