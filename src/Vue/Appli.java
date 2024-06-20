import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.io.File;

public class Appli extends Application {

    private Scene mainScene;
    private static Stage primaryStage;
    private TextField tfNom;
    private TextField tfPrenom;
    private TextField tfPseudo;
    private TextField tfPays;
    private PasswordField tfPwd;
    private TextField tfConfirm;
    private Button bCo;
    private Button bSins;
    private Button bInscrire;
    private Button bRetour;
    private Button bdeco;
    private Button bcompet;
    private Button bback;
    private Button bcreercomp;
    private BD bd;
    private TextField tNomCo;
    private PasswordField tMdpCo;

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            //Instanciation de la classe BD
            ConnexionMySQL connexion = new ConnexionMySQL();
            // Connexion à la BD
            connexion.connecter("servinfo-maria", "DBguihard", "guihard", "guihard");
            this.bd = new BD(connexion);
            Appli.primaryStage = primaryStage;
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../Fenetres/PageDeConnexion.fxml"));
            Parent root = loader.load();
            primaryStage.setTitle("Page de connexion");
            this.mainScene = new Scene(root);
            primaryStage.setScene(this.mainScene);
            this.bSins = (Button)this.mainScene.lookup("#BtnSins");
            this.bCo = (Button) this.mainScene.lookup("#BtnCo"); 
            this.tNomCo = (TextField) this.mainScene.lookup("#IdCo"); 
            this.tMdpCo = (PasswordField) this.mainScene.lookup("#MDP"); 
            this.bSins.setOnAction(new ControllerPage(this));
            this.bCo.setOnAction(new ControllerPage(this));
            primaryStage.show();
        }
        catch (Exception e) {
            System.err.println("Erreur: " + e.getMessage());
            e.printStackTrace();
        }
        
    }


    public String getTNomCo() {
        return this.tNomCo.getText();
    }

    public String getTMdpCo() {
        return this.tMdpCo.getText();
    }


    public void setTNomCo(){
        this.tNomCo.setText("");
    }

    public void setTMdpCo(){
        this.tMdpCo.setText("");
    }



    public void pageDeConnexion() throws Exception{
        FXMLLoader loader = new FXMLLoader(new File("src/Vue/Fenetres/PageDeConexion.fxml").toURI().toURL());
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
        FXMLLoader loader = new FXMLLoader(new File("src/Vue/Fenetres/Fenetre_inscription.fxml").toURI().toURL());
        Parent root = loader.load();
        primaryStage.setTitle("Page d'inscription");
        this.mainScene = new Scene(root);
        primaryStage.setScene(this.mainScene);
        this.tfNom = (TextField)this.mainScene.lookup("#tfnom");
        this.tfPrenom = (TextField)this.mainScene.lookup("#tfprenom");
        this.tfPseudo = (TextField)this.mainScene.lookup("#tfpseudo");
        this.tfPays = (TextField)this.mainScene.lookup("#tfpays");
        this.tfPwd = (PasswordField)this.mainScene.lookup("#tfpassword");
        this.tfConfirm = (PasswordField)this.mainScene.lookup("#tfconfirm");
        this.bInscrire = (Button)this.mainScene.lookup("#inscrire");
        this.bRetour = (Button) this.mainScene.lookup("#annuler"); 
        this.bInscrire.setOnAction(new ControllerPage(this));
        this.bRetour.setOnAction(new ControllerPage(this));
        primaryStage.show();
    }
    
    public void pageConsultation() throws Exception{
        FXMLLoader loader = new FXMLLoader(new File("src/Vue/Fenetres/FenetreConsultationClassement.fxml").toURI().toURL());
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
        FXMLLoader loader = new FXMLLoader(new File("src/Vue/Fenetres/Fenetre_Creation_Competition.fxml").toURI().toURL());
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

    public BD getBD(){
        return this.bd;
    }
}
