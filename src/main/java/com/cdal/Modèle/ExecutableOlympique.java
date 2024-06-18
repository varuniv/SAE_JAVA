package main.java.com.cdal.Modèle;
import main.java.com.cdal.Modèle.*;

public class ExecutableOlympique {
    public static void main(String[] args) throws PasUnSexeException, PaysDejaDansJOException {
        JeuxOlympique JO =  new JeuxOlympique("Paris 2024");

        Pays france = new Pays("France");
        Pays mongolie = new Pays("Mngolie");
        Pays pologne = new Pays("Pologne");
        Pays groenland = new Pays("Groenland");
        Pays chine = new Pays("Chine");
        Pays russie = new Pays("Russie");
        Pays japon = new Pays("Japon");
        
        JO.ajoutePays(france);
        JO.ajoutePays(mongolie);
        JO.ajoutePays(pologne);
        JO.ajoutePays(groenland);
        JO.ajoutePays(chine);
        JO.ajoutePays(russie);
        JO.ajoutePays(japon);
        
        
        System.out.println(JO);

        System.out.println(france);

        //Natation : 100m brasse : hommes / femmes Force: 4.1; Agilité 1.9; Endurance 1.5
        Natation brasseNatation = new Natation("Natation brasse", false, 1, 100);

        Epreuve brasseM = new Epreuve("100m brasse hommes", brasseNatation, "M", 4.1, 1.9, 1.5, 101);
        Epreuve brasseF = new Epreuve("100m brasse femmes", brasseNatation, "F",  4.1, 1.9, 1.5, 102);

        //Natation : 4x100m nage libre : relais femmes et relais hommes Force: 2.2; Agilité 2.2; Endurance 3.1 
        Natation nageLibreNatation = new Natation("Relais nage libre", true, 4, 400);

        Epreuve relaisF = new Epreuve("4x100m nage libre relais femmes", nageLibreNatation, "F", 2.2, 2.2, 3.1,103); 
        Epreuve relaisM = new Epreuve("4x100m nage libre relais hommes", nageLibreNatation, "M", 2.2, 2.2, 3.1,104);
        
        //Handball : femmes / hommes Force: 3; Agilité 2.5; Endurance 2
        Handball handball  = new Handball("Handball", 7);
        
        Epreuve handballF = new Epreuve("Handball feminin", handball, "F", 3, 2.5, 2,105) ;
        Epreuve handballM = new Epreuve("Handball masculin", handball, "M", 3, 2.5, 2, 106) ;
    
        //Volley-ball : femmes / hommes Force: 3.5; Agilité 1.5; Endurance 2.5
        VolleyBall volleyball = new VolleyBall("Volley Ball", 6);

        Epreuve volleyballM = new Epreuve("Volley-ball masculin", volleyball, "M", 3.5, 1.5, 2.5, 107);
        Epreuve volleyballF = new Epreuve("Volley-ball feminin", volleyball, "F", 3.5, 1.5, 2.5, 108);

        //Escrime : fleuret femmes / hommes Force: 1.5; Agilité 3.5; Endurance 2.5
        Escrime escrimeF = new Escrime("Escrime fleuret", "Fleuret"); 

        Epreuve escrimeFM = new Epreuve("Escrime fleuret masculin", escrimeF, "M", 1.5, 3.5, 2.5, 109);
        Epreuve escrimeFF = new Epreuve("Escrime fleuret féminin", escrimeF, "F", 1.5, 3.5, 2.5, 110);

        //Escrime : épée femmes / hommes Force: 1.6; Agilité 3.4; Endurance 2.5
        Escrime escrimeE = new Escrime("Escrime Epee", "Epée");

        Epreuve escrimeEM = new Epreuve("Escrime epée masculin", escrimeE, "M", 1.6, 3.4, 2.5, 111);
        Epreuve escrimeEF = new Epreuve("Escrime epée féminin", escrimeE, "F", 1.6, 3.4, 2.5, 112);

        //Athlétisme : 110m haies femmes / hommes Force: 2; Agilité 3.5; Endurance 2
        Athletisme athletisme110m = new Athletisme("Athletisme 110m", false, 1, 110);

        Epreuve athletisme110mM = new Epreuve("Athletisme 110m haies masculin" , athletisme110m, "M", 2, 3.5, 2, 113);
        Epreuve athletisme110mF = new Epreuve("Athletisme 110m haies féminin" , athletisme110m, "F", 2, 3.5, 2, 114);

        //Athlétisme : 4x100m relais femmes / hommes. Force: 1.5; Agilité 4; Endurance 2
        Athletisme athletismeRelais = new Athletisme("Athletisme relais 400m", true, 4, 400);

        Epreuve athletismeRelaisM = new Epreuve("Athletisme relais 400m masculin", athletismeRelais, "M", 1.5, 4, 2, 115);
        Epreuve athletismeRelaisF = new Epreuve("Athletisme relais 400m féminin", athletismeRelais, "F", 1.5, 4, 2, 116);


        
    }
}
