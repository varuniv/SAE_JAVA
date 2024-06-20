package main.java.com.cdal.Vue;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class ControllerPage implements EventHandler<ActionEvent>{
    private Appli appli;


    public ControllerPage(Appli appli) {
        this.appli = appli;
        
    }

    @FXML
    private Button annuler;

    @FXML
    private Button inscrire;

    @FXML
    private PasswordField tfconfirm;

    @FXML
    private TextField tfnom;

    @FXML
    private PasswordField tfpassword;

    @FXML
    private TextField tfpays;

    @FXML
    private TextField tfprenom;

    @FXML
    private TextField tfpseudo;

    @FXML
    private TextField tfnomcompet;

    @FXML
    private ComboBox<Text> epreuves;

    @FXML
    private ListView<RadioButton> rd;

    @FXML
    private RadioButton rdAthlete;

    @FXML
    private RadioButton rdEquipe;



    @Override
    public void handle(ActionEvent event){
        try{
        Button btn = (Button) (event.getSource());
            if (btn.getText().equals("S'inscrire")) {
                appli.pageInscription();
            }
            else if (btn.getText().equals("M'inscrire")){
                try{
                    String nom = appli.getTNomCo();
                    String mdp = appli.getTMdpCo();
                    if (!(tfconfirm.getText().equals("") && tfnom.getText().equals("") && tfpassword.getText().equals("") && tfpays.getText().equals("") && tfprenom.getText().equals("") && tfpseudo.getText().equals(""))){ // Si tous les textfields sont complétés
                        if (this.tfconfirm.getText().equals(this.tfpassword)){
                            if (!this.appli.getBD().userInBd(nom, mdp)){
                                String nom = this.tfnom.getText();
                                String prenom = this.tfprenom.getText();
                                String pseudo = this.tfpseudo.getText();
                                String mdp = this.tfpassword.getText();
                                this.appli.getBD().insertUtilisateur(nom, prenom, pseudo, mdp);
                                appli.pageDeConnexion();
                            }
                        }
                    }
                }
                catch (Exception e){
                    System.error.println("Les textfields ne sont pas complétés ")
                }
                
            }
            else if (btn.getText().equals("Annuler")) {
                appli.pageDeConnexion();  
            }
            else if (btn.getText().equals("Se Connecter")){
                String nom = appli.getTNomCo();
                String mdp = appli.getTMdpCo();
                if (nom.equals("admin") && mdp.equals("admin")){
                    appli.pageConsultation();
                }
                
                else if(!appli.getBD().userInBd(nom,password)){
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Erreur");
                    alert.setHeaderText("Erreur de connexion");
                    alert.setContentText("Nom d'utilisateur ou mot de passe incorrect");
                    alert.showAndWait();
                }
                else{
                    appli.pageConsultation();
                }

                appli.setTNomCo();
                appli.setTMdpCo();
                
            }
            else if (btn.getText().equals("Déconnexion")){ 
                Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Confirmation");
                alert.setHeaderText("Déconnexion");
                alert.setContentText("Êtes-vous sûr de vouloir vous déconnecter ?");
                
                Optional<ButtonType> result = alert.showAndWait();
                if (result.isPresent() && result.get() == ButtonType.OK) {
                    appli.pageDeConnexion();
                }
            }
            else if (btn.getText().equals("Créer compétition")){
                
                appli.pageCompetition();

            }
            else if (btn.getText().equals("Créer la Compétition")){
                appli.pageConsultation();
            }
            else if (btn.getText().equals("Retour")){
                appli.pageConsultation();
            }


        }
        catch (Exception e) {
            System.err.println("Erreur lors du changement de page");
        }

}

}
