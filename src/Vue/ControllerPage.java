import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import java.util.Optional;
import javafx.scene.control.ButtonType;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;

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
                    String nomco = appli.getTNomCo();
                    String mdpco = appli.getTMdpCo();
                    if (!(tfconfirm.getText().equals("") && tfnom.getText().equals("") && tfpassword.getText().equals("") && tfpays.getText().equals("") && tfprenom.getText().equals("") && tfpseudo.getText().equals(""))){ // Si tous les textfields sont complétés
                        if (this.tfconfirm.getText().equals(this.tfpassword.getText())){
                            if (!this.appli.getBD().userInBd(nomco, mdpco)){
                                String nomins = this.tfnom.getText();
                                String prenom = this.tfprenom.getText();
                                String pseudo = this.tfpseudo.getText();
                                String mdpins = this.tfpassword.getText();
                                this.appli.getBD().insertUtilisateur(nomins, prenom, pseudo, mdpins);
                                appli.pageDeConnexion();
                            }
                        }
                    }
                }
                catch (Exception e){
                    System.err.println("Les textfields ne sont pas complétés ");
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
                
                else if(!appli.getBD().userInBd(nom,mdp)){
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
                try {
                    // String nomcompet = this.tfnomcompet.getText();
                    // int nbElemCombo = this.epreuves.getItems().size(); // Nombres d'items du ComboBox

                    // // Liste des athlètes
                    // Set<Athlete> lesAthletes = this.appli.getBD().selectAthletes();
                    // List<Participant> athletesList = new ArrayList<>();
                    // for (Athlete athlete : lesAthletes) {
                    //     athletesList.add(athlete);
                    // }

                    // // Liste des équipes
                    // Set<Equipe> lesEquipes = this.appli.getBD().selectEquipes();
                    // List<Participant> equipesList = new ArrayList<>();
                    // for (Equipe equipe : lesEquipes) {
                    //     equipesList.add(equipe);
                    // }

                    // // Copie de la liste pour avoir uniquement les informations correspondants au radiobutton sélectionné
                    // List<Participant> listeSelectionne = new ArrayList<>();
                    // if (rdAthlete.isSelected()) {
                    //     listeSelectionne.addAll(athletesList);
                    // } else if (rdEquipe.isSelected()) {
                    //     listeSelectionne.addAll(equipesList);
                    // }

                    // // Set the combined list to the ListView
                    // //this.liste.setItems(listeSelectionne);  //MARCHE PAS LISTE N'EST PAS UN ATTRIBUT

                    // // Check if competition name is not empty and ComboBox has items
                    // if (!nomcompet.isEmpty() && nbElemCombo != 0) {
                    //     // Create a new Competition object
                    //     //Competition compet = new Competition(nomcompet, listeSelectionne, this.epreuves.getSelectionModel().getSelectedItem());//marche pas
                    //     //compet.
                    // }

                    // Navigate to the consultation page
                    appli.pageConsultation();
                } 
                catch (Exception e) {
                    e.printStackTrace();
                    // Handle the exception (show alert, log error, etc.)
                }
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
