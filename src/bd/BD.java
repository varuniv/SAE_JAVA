import java.sql.*;
import java.util.ArrayList;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class BD {
	ConnexionMySQL laConnexion;
	Statement st;
	BD(ConnexionMySQL laConnexion){
		this.laConnexion=laConnexion;
	}

	
	void ajouterDonnees() throws  SQLException{
        Statement stm = this.laConnexion.createStatement();
        String csvFile = "..donnees.csv"; // Path to your CSV file
        int cpt = 0;
        try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {
            List<String[]> records = reader.readAll();
            for (String[] record : records) {
                String nom = record[0];
                String prenom = record[1];
                String sexe = record[2];
                String pays = record[3];
                String epreuve = record[4];
                int force = Integer.parseInt(record[5]);
                int endurance = Integer.parseInt(record[6]);
                int agilite = Integer.parseInt(record[7]);
                
		        stm.executeUpdate("insert into ATHLETE(idAthlete, prenom, nom, sexe, force_, agilite, endurance, pays) values("+cpt+", '"+prenom+"', '"+nom+"', '"+sexe+"', "+force+", "+agilite+", "+endurance+", '"+pays+"')");
                stm.executeUpdate("insert into EPREUVE(idEpreuve, nom) values("+cpt+", '"+epreuve+"')");

            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }

		
	}
}