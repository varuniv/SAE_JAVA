import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import java.util.Optional;

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


    @Override
    public void handle(ActionEvent event){
        try{
        Button btn = (Button) (event.getSource());
            if (btn.getText().equals("S'inscrire")) {
                appli.pageInscription();
            }
            else if (btn.getText().equals("M'inscrire")){
                appli.pageDeConnexion();
            }
            else if (btn.getText().equals("Annuler")) {
                appli.pageDeConnexion();  
            }
            else if (btn.getText().equals("Se Connecter")){
                appli.pageConsultation();
            }
            else if (btn.getText().equals("Déconnexion")){
                // Show confirmation popup
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