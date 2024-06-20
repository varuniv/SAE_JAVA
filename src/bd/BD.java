
import src.Modèle.*;

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
    Set<Integer> idsAthlete;
    int idUser=1;

    BD(ConnexionMySQL laConnexion) {
        this.laConnexion = laConnexion;
        this.idsAthlete = new HashSet<>();
    }

    public void initSt() throws SQLException{
        this.st = this.laConnexion.createStatement();
    }

    public void insertPays(String nomPays) throws SQLException {
        ResultSet rs = this.st.executeQuery("select nomPays from PAYS");
        Set<String> nomsPays = new HashSet<>();
        while (rs.next()) {
            nomsPays.add(rs.getString(1));
        }
        if (!nomsPays.contains(nomPays)) {
            String paysQuery = "insert into PAYS(nomPays) values('" + nomPays + "')";
            this.st.executeUpdate(paysQuery);
        }
    }

    public void insertEpreuve(String sport, boolean enEquipe, int forceEpreuve, int agiliteEpreuve, int enduranceEpreuve, String attributSport) throws SQLException {
        ResultSet rs = this.st.executeQuery("SELECT nomEpreuve FROM EPREUVE");
        Set<String> nomsSports = new HashSet<>();
        while (rs.next()) {
            nomsSports.add(rs.getString(1));
        }
        String categorieH = "M";
        String categorieF = "F";
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

    public void insertAthlete(String nom, String prenom, char sexe, double force, double endurance, double agilite, String nomPays, String nomEquipe) throws SQLException {
        String nomP = "";
        try(ResultSet rs = this.st.executeQuery("select nomPays from PAYS where nomPays='"+nomPays+"'")){
            if(rs.next()){
                nomP=nomPays;
            }
            else{
                throw new SQLException("Pays not found: "+nomPays);
            }
        }
        String equipeId=null;
        if(!nomEquipe.equals("None")){
            try (ResultSet rs2 = this.st.executeQuery("select idEquipe from EQUIPE where nomEquipe='" + nomEquipe + "'")) {
                if (rs2.next()) {
                    equipeId = rs2.getString(1);
                }
            }
        }
        this.idsAthlete.add(this.idAthlete);
        
        //Si l'athlète n'a pas d'équipe
        String idEquipeBD = equipeId;
        if (equipeId == null){
            idEquipeBD = "NULL";
        }
        String athleteQuery = "insert into ATHLETE(idAthlete, prenom, nom, sexe, force_, agilite, endurance, nomPays, idEquipe) VALUES (" +
                this.idAthlete + ", '" + prenom + "', '" + nom + "', '" + sexe + "', " + force + ", " + agilite + ", " + endurance + ", '" + nomPays + "', " + idEquipeBD + ")";
        this.st.executeUpdate(athleteQuery);
        this.idAthlete++;
    }

    public void csvToSQL(String cheminCSV) throws SQLException {
        this.initSt();
        BufferedReader reader = null;
        String line = "";

        try {
            reader = new BufferedReader(new FileReader(cheminCSV));
            this.idAthlete = 1;
            this.idEpreuve = 101;
            this.idEquipe = 201;

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
        this.initSt();
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
        String nomPays = rs.getString(8);
        String idE = rs.getString(9);
        String nomEquipe="Pas d'équipe";
        
        if(idE!=null){
            ResultSet rs3 = this.st.executeQuery("select nomEquipe from EQUIPE where idEquipe="+idE);
            if (rs3.next()) {
                nomEquipe = rs3.getString(1);
            }
        }
        athlete+="Id de l'athlete: "+idA+"\nPrénom: "+prenomA+"\nNom: "+nomA+"\nSexe: "+sexeA+"\nForce: "+forceA+"\nAgilité: "+agiliteA+"\nEndurance: "+enduranceA+"\nPays: "+nomPays+"\nEquipe: "+nomEquipe+"\n";
        return athlete;
    }

    public String selectPaysFromNom(String nomPays) throws SQLException{
        this.initSt();
        String pays = "";
        try{
            ResultSet rs = this.st.executeQuery("select * from PAYS where nomPays="+nomPays);
            rs.next();
            String nomP = rs.getString(1);
            pays+="Nom du pays: "+nomP+"\n";
        }
        catch (Exception e){
            System.out.println("Pays non présent dans la bd. A ajouter");
        }
        return pays;
    }

    public String selectEquipeFromId(int id) throws SQLException {
        this.initSt();
        String equipe = "";

        String selectEquipeQuery = "SELECT * FROM EQUIPE WHERE idEquipe = ?";
        String selectEpreuveQuery = "SELECT nomEpreuve FROM EPREUVE WHERE idEpreuve = ?";

        try (PreparedStatement selectEquipeStmt = this.laConnexion.prepareStatement(selectEquipeQuery)) {
            selectEquipeStmt.setInt(1, id);

            try (ResultSet rs = selectEquipeStmt.executeQuery()) {
                if (rs.next()) {
                    int idE = rs.getInt(1);
                    String nomE = rs.getString(2);
                    int idEp = rs.getInt(3);

                    try (PreparedStatement selectEpreuveStmt = this.laConnexion.prepareStatement(selectEpreuveQuery)) {
                        selectEpreuveStmt.setInt(1, idEp);

                        try (ResultSet rs2 = selectEpreuveStmt.executeQuery()) {
                            if (rs2.next()) {
                                String nomEp = rs2.getString(1);
                                equipe += "Id de l'équipe: " + idE + "\nNom de l'équipe: " + nomE + "\nId de leur épreuve: " + idEp + "\nNom de l'épreuve: " + nomEp + "\n";
                            } else {
                                throw new SQLException("Epreuve with id " + idEp + " not found.");
                            }
                        }
                    }
                }
                else {
                    throw new SQLException("Equipe with id " + id + " not found.");
                }
            }
        }
        return equipe;
    }


    public String selectEpreuveFromId(int id) throws SQLException{
        this.initSt();
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
        this.initSt();
        int idA = athlete.getId();
        String prenomA = athlete.getPrenom();
        String nomA = athlete.getNom();
        String sexeA = athlete.getSexe();
        double forceA = athlete.getForce();
        double agiliteA = athlete.getAgilite();
        double enduranceA = athlete.getEndurance();
        String nomP = athlete.getPays().getNom();
        String nomEquipe = "";
        ResultSet resID = this.st.executeQuery("select idAthlete from ATHLETE");
        ResultSet resEquipe = this.st.executeQuery("select nomEquipe from ATHLETE natural join EQUIPE where idAthlete=" +idA);
        if (resEquipe.next()){
            nomEquipe = resEquipe.getString(1);
        }
            String selectQuery = "SELECT idEquipe FROM ATHLETE WHERE idAthlete = ?";
            String updateQuery = "UPDATE ATHLETE SET prenom = ?, nom = ?, sexe = ?, force_ = ?, agilite = ?, endurance = ?, nomPays = ?, idEquipe = ? WHERE idAthlete = ?";
    
            try (PreparedStatement selectStmt = this.laConnexion.prepareStatement(selectQuery);
                 PreparedStatement updateStmt = this.laConnexion.prepareStatement(updateQuery)) {
            
                selectStmt.setInt(1, idA);
                try (ResultSet rs = selectStmt.executeQuery()) {
                    if (rs.next()) {
                        int idE = rs.getInt("idEquipe");
    
                        updateStmt.setString(1, prenomA);
                        updateStmt.setString(2, nomA);
                        updateStmt.setString(3, sexeA);
                        updateStmt.setDouble(4, forceA);
                        updateStmt.setDouble(5, agiliteA);
                        updateStmt.setDouble(6, enduranceA);
                        updateStmt.setString(7, nomP);
                        updateStmt.setInt(8, idE);
                        updateStmt.setInt(9, idA);
    
                        updateStmt.executeUpdate();
                    System.out.println("Update de l'athlète réalisé avec succès");
                    }
                    else {
                        this.insertAthlete(nomA, prenomA, sexeA.charAt(0), forceA, enduranceA, agiliteA, nomP, nomEquipe);
                }
            }
        }
    }  

    public void majEpreuve(Epreuve epreuve) throws SQLException {
        this.initSt();
        int idE = epreuve.getId();
        String nomEpreuve = epreuve.getNom();
        String categorie = epreuve.getCategorie();
        boolean enEquipe = epreuve.estEnEquipe();
        double forceE = epreuve.getForce();
        double agiliteE = epreuve.getAgilite();
        double enduranceE = epreuve.getEndurance();

        String updateQuery = "update EPREUVE set nomEpreuve = ?, categorie = ?, enEquipe = ?, critereForce = ?, critereAgilite = ?, critereEndurance = ? WHERE idEpreuve = ?";

        try (PreparedStatement updateStm = this.laConnexion.prepareStatement(updateQuery)) {
            updateStm.setString(1, nomEpreuve);
            updateStm.setString(2, categorie);
            updateStm.setBoolean(3, enEquipe);
            updateStm.setDouble(4, forceE);
            updateStm.setDouble(5, agiliteE);
            updateStm.setDouble(6, enduranceE);
            updateStm.setInt(7,idE);
            updateStm.executeUpdate();
            System.out.println("Update de l'épreuve réalisé avec succès");
        }
        catch (Exception e){
            System.out.println("Echec");
        }
    }
    
    public void insertUtilisateur(String nom, String prenom, String pseudo, String mdp) throws SQLException{
        this.initSt();
        this.st.executeUpdate("insert into UTILISATEUR(idUser, nomUser, prenomUser, pseudo, mdp, roleUser) values ("+idUser +",'"+ nom+"','"+ prenom+"','"+ pseudo+"','"+ mdp+"','journaliste')");
        this.st.executeUpdate("create user '"+idUser+ "' identified by '"+mdp+"'");
        this.st.executeUpdate("grant journaliste to '"+idUser+"'");
        idUser++;
    }

    public boolean userInBd(String nom, String password) throws SQLException{
        this.initSt();
        ResultSet rs = this.st.executeQuery("select * from UTILISATEUR where mdp='"+password+"' and prenomUser='"+nom+"'");
        return rs.next();
    }

    public Set<Athlete> selectAthletes(){
        this.initSt();
        Set<Athlete> athletes = new HashSet<>();
        ResultSet rs = this.st.executeQuery("select * from ATHLETE");
        while(rs.next()){
            int idA = rs.getInt(1);
            String prenomA = rs.getString(2);
            String nomA = rs.getString(3);
            String sexeA = rs.getString(4);
            double forceA = rs.getDouble(5);
            double agiliteA = rs.getDouble(6);
            double enduranceA = rs.getDouble(7);
            String nomPaysA = rs.getString(8);
            int idE = rs.getInt(9);
            Pays paysA = new Pays(nomPaysA);
            Athlete athlete = new Athlete(nomA, prenomA, sexeA, forceA, agiliteA, enduranceA, paysA, idA);
            athletes.add(athlete);
        }
        return athletes;
    }

    public Set<Athlete> selectEquipes(){
        this.initSt();
        Set<Equipe> equipes = new HashSet<>();
        // select Equipe
        ResultSet rs = this.st.executeQuery("select * from EQUIPE");
        // select Pays de l'équipe
        ResultSet rs2 = this.st.executeQuery("select nomPays,sexe from ATHLETE where idEquipe="+rs.getInt(1));
        if(rs2.next()){
            String nomPays = rs2.getString(1);
            String sexe = rs2.getString(2);
        }
        Pays pays = new Pays(nomPays);
        // select Epreuve de l'équipe
        ResultSet rs3 = this.st.executeQuery("select * from EPREUVE where idEpreuve="+rs.getInt(3));
        if(rs3.next()){
            int idEpr = rs3.getInt(1);
            String nomEpreuve = rs3.getString(2);
            String categorie = rs3.getString(3);
            int enEquipe = rs.getInt(4);
            boolean estEnEquipe = true;
            if(enEquipe==0){
                estEnEquipe = false;
            }
            double forceEpr = rs3.getDouble(5);
            double agiliteEpr = rs3.getDouble(6);
            double enduranceEpr = rs3.getDouble(7);
            int nbAthletes = rs.getInt(8);
            String attrSport = rs3.getString(9);
            Sport epr = null;
            if(!attrSport.equals("NULL")){
                if(nomEpreuve.equals("Natation 100 brasse") || nomEpreuve.equals("Natation relais libre")){
                    epr = new Natation(nomEpreuve, estEnEquipe, nbAthletes, attrSport);
                }
                else if(nomEpreuve.equals("Athlétisme 110 haies") || nomEpreuve.equals("Athlétisme relais 400m")){
                    epr = new Athletisme(nomEpreuve, estEnEquipe, nbAthletes, attrSport);
                }
                else{
                    epr = new Escrime(nomEpreuve, attrSport);
                }
            }
            else{
                switch(nomEpreuve){
                    case "Handball":
                        epr = new Handball(nomEpreuve, nbAthletes);
                        break;
                    case "Volley-Ball":
                        epr = new VolleyBall(nomEpreuve, nbAthletes);
                        break;
                }
            }
        }
        Epreuve epreuve = new Epreuve(nomEpreuve, epr, categorie, forceEpr, agiliteEpr, enduranceEpr, idEpr);
        while(rs.next()){
            int idE = rs.getInt(1);
            String nomEquipe = rs.getString(2);
            Equipe equipe = new Equipe(nomEquipe, epreuve, pays, sexe, idE);
            equipes.add(equipe);
        }
        return equipes;
    }
}
