
public class ExecutableOlympique {
    public static void main(String[] args) {
        JeuxOlympique JO = new JeuxOlympique("Paris");
        
       

        //Les sports
        VolleyBall volleyBall = new VolleyBall("VolleyBall", true, 12);
        Escrime escrime = new Escrime("Escrime", false, 2, "Épée");

        //Les épreuves
        Epreuve epr1 = new Epreuve("Volley", volleyBall, "Masculin", true,3.5,1.5,2.5);
        Epreuve epr2 = new Epreuve("Escrime", escrime, "Féminin", false,1.6,3.4,2.5);
        

        //Les pays
        Pays france = new Pays("France");
        Pays italie = new Pays("Italie");
        Pays us = new Pays("US");
        
        //Les athlètes
        Athlete jean = new Athlete("Jean", "Dupond", "M", 2, 8, 6,france, 1);
        Athlete toto = new Athlete("Toto", "Dupond", "M", 4, 2, 5,italie, 2);
        Athlete anna = new Athlete("Anna", "Belle", "F", 3, 3, 3,us, 3);
        Athlete john = new Athlete("John", "Paul", "M", 5, 3, 7, france, 4);

        //Les équipes
        Equipe a = new Equipe("A", epr1, 2, true);
        Equipe b = new Equipe("B", epr2, 5, true);
        a.ajouteMembre(jean);
        a.ajouteMembre(toto);
        b.ajouteMembre(anna);
        b.ajouteMembre(john);

        Competition cp = new Competition(epr1);
        cp.ajoute(a);
        cp.ajoute(b);
        System.out.println(cp.ExecutionPooleEquipe());
        
        //ystem.out.println(escrime.methodeCalculeVainqueur(jean,toto,epr2));
    }
}
