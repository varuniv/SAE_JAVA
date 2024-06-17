DROP TABLE IF EXISTS ATHLETE;
DROP TABLE IF EXISTS PAYS;
DROP TABLE IF EXISTS EQUIPE;
DROP TABLE IF EXISTS EPREUVE;

CREATE TABLE EPREUVE(
    idEpreuve INT PRIMARY KEY,
    nomEpreuve VARCHAR(50),
    categorie VARCHAR(20),
    enEquipe BOOLEAN,
    critereForce DECIMAL,
    critereAgilite DECIMAL,
    critereEndurance DECIMAL,
    attributSport VARCHAR(20) -- Si le sport n'a pas d'attributs on initialise à NULL
);

CREATE TABLE EQUIPE(
    idEquipe INT PRIMARY KEY,
    nomEquipe VARCHAR(30),
    idEpreuve INT,
    FOREIGN KEY (idEpreuve) REFERENCES EPREUVE(idEpreuve)
);

CREATE TABLE PAYS(
    idPays INT PRIMARY KEY,
    nomPays VARCHAR(15)
);

CREATE TABLE ATHLETE(
    idAthlete INT PRIMARY KEY,
    prenom VARCHAR(20),
    nom VARCHAR(20),
    sexe VARCHAR(1),
    force_ DECIMAL,
    agilite DECIMAL,
    endurance DECIMAL,
    idPays INT,
    idEquipe INT,
    FOREIGN KEY (idEquipe) REFERENCES EQUIPE(idEquipe),
    FOREIGN KEY (idPays) REFERENCES PAYS(idPays)
);
