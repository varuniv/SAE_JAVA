

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.control.Button;


public class Appli extends Application {

    private Scene mainScene;
    private static Stage primaryStage;
    private Button bCo;
    private Button bSins;
    private Button bInscrire;
    private Button bRetour;
    private Button bdeco;
    private Button bcompet;
    private Button bback;
    private Button bcreercomp;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Appli.primaryStage = primaryStage;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("PageDeConnexion.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("Page de connexion");
        this.mainScene = new Scene(root);
        primaryStage.setScene(this.mainScene);
        this.bSins = (Button)this.mainScene.lookup("#BtnSins");
        this.bCo = (Button) this.mainScene.lookup("#BtnCo"); 
        this.bSins.setOnAction(new ControllerPage(this));
        this.bCo.setOnAction(new ControllerPage(this));
        primaryStage.show();
    }


    public void pageDeConnexion() throws Exception{
        Appli.primaryStage = primaryStage;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("PageDeConnexion.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("Page de connexion");
        this.mainScene = new Scene(root);
        primaryStage.setScene(this.mainScene);
        this.bSins = (Button)this.mainScene.lookup("#BtnSins");
        this.bCo = (Button) this.mainScene.lookup("#BtnCo"); 
        this.bSins.setOnAction(new ControllerPage(this));
        this.bCo.setOnAction(new ControllerPage(this));
        primaryStage.show();
    }

    

    public void pageInscription() throws Exception{
        Appli.primaryStage = primaryStage;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Fenetre_inscription.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("Page d'inscription");
        this.mainScene = new Scene(root);
        primaryStage.setScene(this.mainScene);
        this.bInscrire = (Button)this.mainScene.lookup("#inscrire");
        this.bRetour = (Button) this.mainScene.lookup("#annuler"); 
        this.bInscrire.setOnAction(new ControllerPage(this));
        this.bRetour.setOnAction(new ControllerPage(this));
        primaryStage.show();
    }
    
    public void pageConsultation() throws Exception{
        Appli.primaryStage = primaryStage;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FenetreConsultationClassement.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("Page de Consultation");
        this.mainScene = new Scene(root);
        primaryStage.setScene(this.mainScene);
        this.bdeco = (Button)this.mainScene.lookup("#deconnexion");
        this.bcompet = (Button)this.mainScene.lookup("#creerCompet");
        this.bdeco.setOnAction(new ControllerPage(this));
        this.bcompet.setOnAction(new ControllerPage(this));
        primaryStage.show();
    }

    public void pageCompetition() throws Exception{
        Appli.primaryStage = primaryStage;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Fenetre_Creation_Competition.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("Création de Compétition");
        this.mainScene = new Scene(root);
        primaryStage.setScene(this.mainScene);
        this.bcreercomp = (Button) this.mainScene.lookup("#createComp");
        this.bback = (Button) this.mainScene.lookup("#retour");
        this.bcreercomp.setOnAction(new ControllerPage(this));
        this.bback.setOnAction(new ControllerPage(this));
    }

        public static void main(String[] args) {
        launch(args);
    }
}
