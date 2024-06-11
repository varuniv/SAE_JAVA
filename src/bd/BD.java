package bd;
import java.sql.*;
import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class BD {
    ConnexionMySQL laConnexion;
    Statement st;

    BD(ConnexionMySQL laConnexion) {
        this.laConnexion = laConnexion;
    }

    public void csvToSQL(String cheminCSV) throws SQLException {
        Statement stm = this.laConnexion.createStatement();
        BufferedReader reader = null;
        String line = "";

        try {
            reader = new BufferedReader(new FileReader(cheminCSV));
            int idAthlete = 1;
            int idEpreuve = 101;
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                String nom = row[0];
                String prenom = row[1];
                char sexe = row[2].charAt(0);
                String pays = row[3];
                String sport = row[4];
                int force = Integer.parseInt(row[5]);
                int endurance = Integer.parseInt(row[6]);
                int agilite = Integer.parseInt(row[7]);

                // Insert into ATHLETE
                String athleteQuery = "INSERT INTO ATHLETE(idAthlete, prenom, nom, sexe, force_, agilite, endurance, pays) VALUES (" +
                        idAthlete + ", '" + prenom + "', '" + nom + "', '" + sexe + "', " + force + ", " + agilite + ", " + endurance + ", '" + pays + "')";
                stm.executeUpdate(athleteQuery);

                // Check if the sport exists in EPREUVE
                ResultSet rs = stm.executeQuery("SELECT nom FROM EPREUVE");
                Set<String> noms = new HashSet<>();
                while (rs.next()) {
                    noms.add(rs.getString("nom"));
                }

                if (!noms.contains(sport)) {
                    String epreuveQuery = "INSERT INTO EPREUVE(idEpreuve, nom) VALUES (" + idEpreuve + ", '" + sport + "')";
                    stm.executeUpdate(epreuveQuery);
                    idEpreuve++;
                }

                idAthlete++;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error processing CSV file.");
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            this.laConnexion.close();
        }
    }
}
