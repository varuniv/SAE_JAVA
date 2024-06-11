
public class ExecutableOlympique {
    public static void main(String[] args) {
        JeuxOlympique JO = new JeuxOlympique("Paris");
        
        Pays France = new Pays("France");
        France.ajouteAthlete(new Athlete("Jean", "Clode", "F", 15, 14, 12, France));

        //Les sports
        VolleyBall volleyBall = new VolleyBall("VolleyBall", true, 12);
        Escrime escrime = new Escrime("Escrime", false, 2, "Épée");

        //Les épreuves
        //Epreuve epr1 = new Epreuve("Volley", volleyBall, "Masculin", true);
        //Epreuve epr2 = new Epreuve("Escrime", escrime, "Féminin", false);
        

        //Les athlètes
        Pays france = new Pays("France");
        Pays italie = new Pays("Italie");
        Pays us = new Pays("US");
        Pays angleterre = new Pays("Angleterre");
        
        //Les athlètes
        Athlete jean = new Athlete("Jean", "Dupond", "M", 2, 8, 6,france);
        Athlete toto = new Athlete("Toto", "Dupond", "M", 4, 2, 5,italie);
        Athlete anna = new Athlete("Anna", "Belle", "F", 3, 3, 3,us);
        Athlete john = new Athlete("John", "Paul", "M", 5, 3, 7, france);

        //Les équipes
        Equipe a = new Equipe("A", epr1, 2, true);
        Equipe b = new Equipe("B", epr2, 5, true);
        
    }
}
