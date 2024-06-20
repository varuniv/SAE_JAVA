DROP TABLE IF EXISTS ATHLETE;
DROP TABLE IF EXISTS PAYS;
DROP TABLE IF EXISTS EQUIPE;
DROP TABLE IF EXISTS EPREUVE;
DROP table IF EXISTS COMPETITION;
DROP TABLE IF EXISTS UTILISATEUR;

create table COMPETITION(
    nomCompet varchar(50) PRIMARY KEY
);

CREATE TABLE EPREUVE(
    idEpreuve INT PRIMARY KEY,
    nomEpreuve VARCHAR(50),
    categorie VARCHAR(20),
    enEquipe BOOLEAN,
    critereForce DECIMAL,
    critereAgilite DECIMAL,
    critereEndurance DECIMAL,
    nbAthlete INT,
    attributSport VARCHAR(20), -- Si le sport n'a pas d'attributs on initialise à NULL
    nomCompet varchar(50),
    FOREIGN KEY (nomCompet) REFERENCES COMPETITION(nomCompet)
);

CREATE TABLE EQUIPE(
    idEquipe INT PRIMARY KEY,
    nomEquipe VARCHAR(30),
    idEpreuve INT,
    FOREIGN KEY (idEpreuve) REFERENCES EPREUVE(idEpreuve)
);

CREATE TABLE PAYS(
    nomPays VARCHAR(15) PRIMARY KEY,
    nbMedaillesOrP INT,
    nbMedaillesArgentP INT,
    nbMedaillesBronzeP INT
);

CREATE TABLE ATHLETE(
    idAthlete INT PRIMARY KEY,
    prenom VARCHAR(20),
    nom VARCHAR(20),
    sexe VARCHAR(1),
    force_ DECIMAL,
    agilite DECIMAL,
    endurance DECIMAL,
    nomPays VARCHAR(15),
    idEquipe INT,
    nbMedaillesOr INT,
    nbMedaillesArgent INT,
    nbMedaillesBronze INT,
    FOREIGN KEY (idEquipe) REFERENCES EQUIPE(idEquipe),
    FOREIGN KEY (nomPays) REFERENCES PAYS(nomPays)
);

create table UTILISATEUR(
    idUser INT PRIMARY KEY,
    nomUser VARCHAR(50),
    prenomUser VARCHAR(50),
    pseudo VARCHAR(50),
    mdp VARCHAR(50),
    roleUser VARCHAR(50)
);
