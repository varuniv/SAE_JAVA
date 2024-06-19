--création de 3 rôles
create role journaliste,organisateur,administrateur;

--journaliste

grant select on DBguihard.PAYS to journaliste;
grant select on DBguihard.EQUIPE to journaliste;
grant select on DBguihard.EPREUVE to journaliste;
grant select on DBguihard.ATHLETE to journaliste;


--organisateur
grant insert,select on DBguihard.PAYS to organisateur;
grant insert,select on DBguihard.EQUIPE to organisateur;
grant insert,select on DBguihard.EPREUVE to organisateur;
grant insert,select on DBguihard.ATHLETE to organisateur;

--administrateur

grant all on DBguihard.* to administrateur with grant option;