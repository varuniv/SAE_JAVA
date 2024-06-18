
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
                bd.csvToSQL("../donnees.csv");
                System.out.println(bd.selectAthleteFromId(2));
                System.out.println(bd.selectPaysFromId(203));
                System.out.println(bd.selectEquipeFromId(301));
                System.out.println(bd.selectEpreuveFromId(107));

                Pays malaisie = new Pays("Malaisie");
                Athlete athlete = new Athlete("Zee", "Zaiini", "M", 12.0, 14.0, 15.0, malaisie, 3);
                bd.majAthlete(athlete);
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