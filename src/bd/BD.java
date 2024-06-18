package bd;
import main.java.com.cdal.Modèle.*;


import java.sql.*;
import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class BD {
    ConnexionMySQL laConnexion;
    Statement st;
    int idEpreuve;
    int idEquipe;
    int idAthlete;
    int idPays;

    BD(ConnexionMySQL laConnexion) {
        this.laConnexion = laConnexion;
    }

    public void insertPays(String nomPays) throws SQLException {
        ResultSet rs = this.st.executeQuery("select nomPays from PAYS");
        Set<String> nomsPays = new HashSet<>();
        while (rs.next()) {
            nomsPays.add(rs.getString(1));
        }
        if (!nomsPays.contains(nomPays)) {
            String paysQuery = "insert into PAYS(idPays, nomPays) values(" + this.idPays + ",'" + nomPays + "')";
            this.st.executeUpdate(paysQuery);
            this.idPays++;
        }
    }

    public void insertEpreuve(String sport, boolean enEquipe, int forceEpreuve, int agiliteEpreuve, int enduranceEpreuve, String attributSport) throws SQLException {
        ResultSet rs = this.st.executeQuery("SELECT nomEpreuve FROM EPREUVE");
        Set<String> nomsSports = new HashSet<>();
        while (rs.next()) {
            nomsSports.add(rs.getString(1));
        }
        String categorieH = "Hommes";
        String categorieF = "Femmes";
        if (!nomsSports.contains(sport)) {
            String epreuveQueryHommes = "insert into EPREUVE(idEpreuve, nomEpreuve, categorie, enEquipe, critereForce, critereAgilite, critereEndurance, attributSport) VALUES (" + this.idEpreuve + ", '" + sport + "','" + categorieH + "', " + enEquipe + ", " + forceEpreuve + ", " + agiliteEpreuve + ", " + enduranceEpreuve + ", '" + attributSport + "')";
            this.st.executeUpdate(epreuveQueryHommes);

            this.idEpreuve++;

            String epreuveQueryFemmes = "insert into EPREUVE(idEpreuve, nomEpreuve, categorie, enEquipe, critereForce, critereAgilite, critereEndurance, attributSport) VALUES (" + this.idEpreuve + ", '" + sport + "','" + categorieF + "', " + enEquipe + ", " + forceEpreuve + ", " + agiliteEpreuve + ", " + enduranceEpreuve + ", '" + attributSport + "')";
            this.st.executeUpdate(epreuveQueryFemmes);
            this.idEpreuve++;
        }
    }

    public void insertEquipe(String sport, String nomEquipe) throws SQLException {
        int epreuveId;
        try (ResultSet rs = this.st.executeQuery("select idEpreuve from EPREUVE where nomEpreuve='" + sport + "'")) {
            if (rs.next()) {
                epreuveId = rs.getInt(1);
            } else {
                throw new SQLException("Epreuve not found for sport: " + sport);
            }
        }

        try (ResultSet rs2 = this.st.executeQuery("select nomEquipe from EQUIPE")) {
            Set<String> nomsEquipes = new HashSet<>();
            while (rs2.next()) {
                nomsEquipes.add(rs2.getString(1));
            }
            if (!nomsEquipes.contains(nomEquipe)) {
                String nomEquipeQuery = "insert into EQUIPE(idEquipe, nomEquipe, idEpreuve) values(" + idEquipe + ", '" + nomEquipe + "', " + epreuveId + ")";
                this.st.executeUpdate(nomEquipeQuery);
                this.idEquipe++;
            }
        }
    }

    public void insertAthlete(String nom, String prenom, char sexe, int force, int endurance, int agilite, String nomPays, String nomEquipe) throws SQLException {
        int paysId;
        try (ResultSet rs = this.st.executeQuery("select idPays from PAYS where nomPays='" + nomPays + "'")) {
            if (rs.next()) {
                paysId = rs.getInt(1);
            } else {
                throw new SQLException("Pays not found: " + nomPays);
            }
        }

        int equipeId;
        try (ResultSet rs2 = this.st.executeQuery("select idEquipe from EQUIPE where nomEquipe='" + nomEquipe + "'")) {
            if (rs2.next()) {
                equipeId = rs2.getInt(1);
            } else {
                throw new SQLException("Equipe not found: " + nomEquipe);
            }
        }

        String athleteQuery = "insert into ATHLETE(idAthlete, prenom, nom, sexe, force_, agilite, endurance, idPays, idEquipe) VALUES (" +
                this.idAthlete + ", '" + prenom + "', '" + nom + "', '" + sexe + "', " + force + ", " + agilite + ", " + endurance + ", " + paysId + ", " + equipeId + ")";
        this.st.executeUpdate(athleteQuery);
        this.idAthlete++;
    }

    public void csvToSQL(String cheminCSV) throws SQLException {
        this.st = this.laConnexion.createStatement();
        BufferedReader reader = null;
        String line = "";

        try {
            reader = new BufferedReader(new FileReader(cheminCSV));
            this.idAthlete = 1;
            this.idEpreuve = 101;
            this.idPays = 201;
            this.idEquipe = 301;

            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                String nom = row[0];
                String prenom = row[1];
                char sexe = row[2].charAt(0);
                String nomPays = row[3];
                String sport = row[4];
                int force = Integer.parseInt(row[5]);
                int endurance = Integer.parseInt(row[6]);
                int agilite = Integer.parseInt(row[7]);
                String estEnEquipe = row[8];
                boolean enEquipe = estEnEquipe.equals("True");
                int forceEpreuve = Integer.parseInt(row[9]);
                int enduranceEpreuve = Integer.parseInt(row[10]);
                int agiliteEpreuve = Integer.parseInt(row[11]);
                String attributSport = row[12].equals("None") ? "NULL" : row[12];
                String nomEquipe = row[13];

                // Insert methods in the DB
                this.insertPays(nomPays);
                this.insertEpreuve(sport, enEquipe, forceEpreuve, agiliteEpreuve, enduranceEpreuve, attributSport);
                this.insertEquipe(sport, nomEquipe);
                this.insertAthlete(nom, prenom, sexe, force, endurance, agilite, nomPays, nomEquipe);
            }
            System.out.println("Inserts effectués avec succès\n");
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
        }
    }

    public String selectAthleteFromId(int id) throws SQLException{
        ResultSet rs = this.st.executeQuery("select * from ATHLETE where idAthlete="+id);
        rs.next();
        String athlete = "";
        int idA = rs.getInt(1);
        String prenomA = rs.getString(2);
        String nomA = rs.getString(3);
        String sexeA = rs.getString(4);
        int forceA = rs.getInt(5);
        int agiliteA = rs.getInt(6);
        int enduranceA = rs.getInt(7);
        ResultSet rs2 = this.st.executeQuery("select nomPays from PAYS where idPays="+rs.getInt(8));
        if (rs2.next()) {
            String nomPays = rs2.getString(1);
        }
        String nomPays = rs2.getString(1);
        ResultSet rs3 = this.st.executeQuery("select nomEquipe from EQUIPE where idEquipe="+rs.getInt(9));
        if (rs3.next()) {
            String nomEquipe = rs3.getString(1);
        }
        String nomEquipe = rs3.getString(1);
        athlete+="Id de l'athlete: "+idA+"\nPrénom: "+prenomA+"\nNom: "+nomA+"\nSexe: "+sexeA+"\nForce: "+forceA+"\nAgilité: "+agiliteA+"\nEndurance: "+enduranceA+"\nPays: "+nomPays+"\nEquipe: "+nomEquipe+"\n";
        return athlete;
    }

    public String selectPaysFromId(int id) throws SQLException{
        ResultSet rs = this.st.executeQuery("select * from PAYS where idPays="+id);
        rs.next();
        String pays = "";
        int idP = rs.getInt(1);
        String nomPays = rs.getString(2);
        pays+="Id du pays: "+idP+",\nNom du pays: "+nomPays+"\n";
        return pays;
    }

    public String selectEquipeFromId(int id) throws SQLException{
        ResultSet rs = this.st.executeQuery("select * from EQUIPE where idEquipe="+id);
        rs.next();
        String equipe = "";
        int idE = rs.getInt(1);
        String nomE = rs.getString(2);
        int idEp = rs.getInt(3);
        ResultSet rs2 = this.st.executeQuery("select nomEpreuve from EPREUVE where idEpreuve="+idEp);
        rs2.next();
        String nomEp = rs2.getString(1);
        equipe+="Id de l'équipe: "+idE+"\nNom de l'équipe: "+nomE+"\nId de leur épreuve: "+idEp+"\nNom de l'épreuve: "+nomEp+"\n";
        return equipe;
    }

    public String selectEpreuveFromId(int id) throws SQLException{
        ResultSet rs = this.st.executeQuery("select * from EPREUVE where idEpreuve="+id);
        rs.next();
        String epreuve = "";
        String estEnEquipe = "L'épreuve est en équipe";
        String infosDuSport = "Ce sport a comme attribut: ";
        
        int idE = rs.getInt(1);
        String nomEpreuve = rs.getString(2);
        String categorie = rs.getString(3);
        int enEquipe = rs.getInt(4);
        double critereForce = rs.getDouble(5);
        double critereAgilite = rs.getDouble(6);
        double critereEndurance = rs.getDouble(7);
        String attributSport = rs.getString(8);

        Set<String> sportsDistances = new HashSet<>();
        sportsDistances.add("Natation 100 brasse");
        sportsDistances.add("Natation relais libre");
        sportsDistances.add("Athlétisme 110 haies");
        sportsDistances.add("Athlétisme relais 400m");
        
        Set<String> typeEpeesEscrime = new HashSet<>();
        typeEpeesEscrime.add("Escrime fleuret");
        typeEpeesEscrime.add("Escrime épée");

        if (enEquipe == 0){
            estEnEquipe = "L'épreuve n'est pas en équipe";
        }
        if(attributSport.equals("NULL")){
            infosDuSport="Ce sport n'a pas d'attributs";
            epreuve+="Epreuve: "+idE+"\nNom de l'épreuve: "+nomEpreuve+"\nCatégorie: "+categorie+"\n"+estEnEquipe+"\nCritère Force: "+critereForce+"\nCritère Endurance: "+critereEndurance+"\nCritère Agilité: "+critereAgilite+"\n"+infosDuSport+"\n";
            return epreuve;
        }
        String attrSport="";
        if(sportsDistances.contains(nomEpreuve)){
            attrSport = attributSport+" mètres";
        }
        else{
            attrSport = attributSport+"";
        }
        epreuve+="Id de l'épreuve: "+idE+"\nNom de l'épreuve: "+nomEpreuve+"\nCatégorie: "+categorie+"\n"+estEnEquipe+"\nCritère Force: "+critereForce+"\nCritère Endurance: "+critereEndurance+"\nCritère Agilité: "+critereAgilite+"\n"+infosDuSport+""+attrSport+"\n";
        return epreuve;
    }

    public void majAthlete(Athlete athlete) throws SQLException {
    int idA = athlete.getId();
    String prenomA = athlete.getPrenom();
    String nomA = athlete.getNom();
    String sexeA = athlete.getSexe();
    double forceA = athlete.getForce();
    double agiliteA = athlete.getAgilite();
    double enduranceA = athlete.getEndurance();

    // Use try-with-resources to ensure resources are closed properly
    String selectQuery = "SELECT idPays, idEquipe FROM ATHLETE WHERE idAthlete = ?";
    String updateQuery = "UPDATE ATHLETE SET prenom = ?, nom = ?, sexe = ?, force_ = ?, agilite = ?, endurance = ?, idPays = ?, idEquipe = ? WHERE idAthlete = ?";

    try (PreparedStatement selectStmt = this.laConnexion.prepareStatement(selectQuery);
         PreparedStatement updateStmt = this.laConnexion.prepareStatement(updateQuery)) {

        selectStmt.setInt(1, idA);
        try (ResultSet rs = selectStmt.executeQuery()) {
            if (rs.next()) {
                int idP = rs.getInt("idPays");
                int idE = rs.getInt("idEquipe");

                updateStmt.setString(1, prenomA);
                updateStmt.setString(2, nomA);
                updateStmt.setString(3, sexeA);
                updateStmt.setDouble(4, forceA);
                updateStmt.setDouble(5, agiliteA);
                updateStmt.setDouble(6, enduranceA);
                updateStmt.setInt(7, idP);
                updateStmt.setInt(8, idE);
                updateStmt.setInt(9, idA);

                updateStmt.executeUpdate();
            System.out.println("Update réalisé avec succès");
            } else {
                throw new SQLException("Athlete with id " + idA + " not found.");
            }
        }
    }
}  
}
