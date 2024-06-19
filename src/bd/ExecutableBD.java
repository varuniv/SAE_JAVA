
import classes.src.*;
public class ExecutableBD {
    public static void main(String[] args) {
        try {
            
            ConnexionMySQL connexion = new ConnexionMySQL();
            // Connexion à la BD
            connexion.connecter("servinfo-maria", "DBguihard", "guihard", "guihard");
            // Check la connexion
            if(connexion.isConnecte()){
                BD bd = new BD(connexion);
                bd.csvToSQL("bd/donnees.csv");
                System.out.println(bd.selectAthleteFromId(5));
                System.out.println(bd.selectPaysFromNom("France"));
                System.out.println(bd.selectEquipeFromId(201));
                System.out.println(bd.selectEpreuveFromId(107));

                Pays malaisie = new Pays("Malaisie");
                Pays maroc = new Pays("Maroc");
                Athlete athlete = new Athlete("Zee", "Zaiini", "M", 12.0, 14.0, 15.0, maroc, 3); //SANS EQUIPE
                bd.majAthlete(athlete);
                Handball handball = new Handball("Handball", 14);
                Epreuve ep = new Epreuve("Handball", handball, "M", 15, 13, 2, 103);
                bd.majEpreuve(ep);
            }
            else{
                System.err.println("Erreur: Connection not established.");
            }
            connexion.close();
        }
        catch (Exception e) {
            System.err.println("Erreur: " + e.getMessage());
            e.printStackTrace();
        }
    }
}