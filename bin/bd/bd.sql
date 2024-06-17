drop table ATHLETE if exists;
drop table EPREUVE if exists;

create table ATHLETE(
    idAthlete int primary key,
    prenom varchar(20),
    nom varchar(20),
    sexe varchar(1),
    force_ decimal,
    agilite decimal,
    endurance decimal,
    pays varchar(20)
);

create table EPREUVE(
    idEpreuve int primary key,
    nom varchar(50)
);