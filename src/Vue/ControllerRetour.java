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

public class ControllerRetour implements EventHandler<ActionEvent>{
    private Appli appli;


    public ControllerRetour(Appli appli) {
        this.appli = appli; 
    }

    @Override
    public void handle(ActionEvent event){
        try {
        Button btn = (Button) (event.getSource());
            if (btn.getText().equals("Annuler")) {
                appli.pageDeConnexion();  
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


            else if (btn.getText().equals("Retour")){
                appli.pageConsultation();
            }

        }
      
         
        catch (Exception e) {
            System.err.println("Erreur lors du changement de page");
        }
    }
}

    
