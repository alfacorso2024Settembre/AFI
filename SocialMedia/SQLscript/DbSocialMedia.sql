use social_media

create table utenti(
	user varchar(255),
  email varchar(255) not null primary key,
  password varchar(255)
);

create table post(
	id int not null auto_increment primary key,
  emailUtente varchar(255) not null,
  text varchar(255),
  data date,
  condivisioni int,
  foreign key (emailUtente) references utenti(email)
);

create table amicizie(
	emailUtente1 varchar(255) not null,
  emailUtente2 varchar(255) not null,
  primary key(emailUtente1, emailUtente2),
  foreign key (emailUtente1) references utenti(email),
  foreign key (emailUtente2) references utenti(email)
);


INSERT INTO utenti (user, email, password) VALUES
('User1', 'user1@example.com', 'password1'),
('User2', 'user2@example.com', 'password2'),
('User3', 'user3@example.com', 'password3'),
('User4', 'user4@example.com', 'password4'),
('User5', 'user5@example.com', 'password5');

INSERT INTO post (emailUtente, text, data, condivisioni) VALUES
('user1@example.com', 'First post by User1', '2024-10-01', 10),
('user2@example.com', 'First post by User2', '2024-10-02', 20),
('user3@example.com', 'First post by User3', '2024-10-03', 30),
('user4@example.com', 'First post by User4', '2024-10-04', 40),
('user5@example.com', 'First post by User5', '2024-10-05', 50);

INSERT INTO amicizie (emailUtente1, emailUtente2) VALUES
('user1@example.com', 'user2@example.com'),
('user1@example.com', 'user3@example.com'),
('user2@example.com', 'user4@example.com'),
('user3@example.com', 'user5@example.com'),
('user4@example.com', 'user5@example.com');

#use social_media;
#select * from amicizie;
#select * from post;

