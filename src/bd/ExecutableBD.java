
public class ExecutableBD {
    public static void main(String[] args) {
        try {
            // Create a new instance of ConnexionMySQL
            ConnexionMySQL connexion = new ConnexionMySQL();
            // Connect to the database with appropriate parameters
            connexion.connecter("servinfo-maria", "DBguihard", "guihard", "guihard");
            // Check if connection is successful before proceeding
            if (connexion.isConnecte()) {
                // If connected, create an instance of BD and execute csvToSQL method
                BD bd = new BD(connexion);
                bd.csvToSQL("../donnees.csv");
            } else {
                System.err.println("Erreur: Connection not established.");
            }
        } catch (Exception e) {
            System.err.println("Erreur: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
//Compiler et exécuter :
//javac --source-path ./src -d ./bin --module-path /usr/share/openjfx/lib/ --add-modules javafx.controls src/*.java
//java -cp ./bin:/usr/share/java/mariadb-java-client.jar --module-path /usr/share/openjfx/lib/ --add-modules javafx.controls ExecutableBD
