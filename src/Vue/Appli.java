import src.bd.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.io.File;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Appli extends Application {

    private Scene mainScene;
    private static Stage primaryStage;

    //Page de Connexion
    private Button bCo;
    private Button bSins;
    private TextField tNomCo;
    private PasswordField tMdpCo;

    //Inscription
    private Button bInscrire;
    private Button bRetour;
    private TextField tfNom;
    private TextField tfPrenom;
    private TextField tfPseudo;
    private TextField tfPays;
    private PasswordField tfPwd;
    private PasswordField tfConfirm;

    //Consultation
    private Button bcompet;
    private Button bdeco;
    private TableView tableClassement;

    //Competition
    private Button bback;
    private Button bcreercomp;

    
    private BD bd;
   

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            //Instanciation de la classe BD
            ConnexionMySQL connexion = new ConnexionMySQL();
            // Connexion à la BD
            connexion.connecter("servinfo-maria", "DBguihard", "guihard", "guihard");
            this.bd = new BD(connexion);
            Appli.primaryStage = primaryStage;
            FXMLLoader loader = new FXMLLoader(new File("src/Vue/Fenetres/PageDeConnexion.fxml").toURI().toURL());
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

// Getters et Setters de connexion
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

// Getters et Setters d'inscription
    public String getTfNom(){
        return this.tfNom.getText();
    }
    public String getTfPrenom(){
        return this.tfPrenom.getText();
    }
    public String getTfPseudo(){
        return this.tfPseudo.getText();
    }
    public String getTfPays(){
        return this.tfPays.getText();
    }
    public String getTfPwd(){
        return this.tfPwd.getText();
    }
    public String getTfConfirm(){
        return this.tfConfirm.getText();
    }

    public void setTfNom(){
        this.tfNom.setText("");
    }
    public void setTfPrenom(){
        this.tfPrenom.setText("");
    }
    public void setTfPseudo(){
        this.tfPseudo.setText("");
    }
    public void setTfPays(){
        this.tfPays.setText("");
    }
    public void setTfPwd(){
        this.tfPwd.setText("");
    }
    public void setTfConfirm(){
        this.tfConfirm.setText("");
    }

// Getters et Setters de Consultation
    public TableView getTableClassement(){
        return this.tableClassement;
    }


    public void pageDeConnexion() throws Exception{
        FXMLLoader loader = new FXMLLoader(new File("src/Vue/Fenetres/PageDeConnexion.fxml").toURI().toURL());
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


    public void pageInscription() throws Exception{
        FXMLLoader loader = new FXMLLoader(new File("src/Vue/Fenetres/FenetreInscription.fxml").toURI().toURL());
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
        this.tableClassement = (TableView)this.mainScene.lookup("Classement");
        this.bdeco = (Button)this.mainScene.lookup("#deconnexion");
        this.bcompet = (Button)this.mainScene.lookup("#creerCompet");
        this.bdeco.setOnAction(new ControllerPage(this));
        this.bcompet.setOnAction(new ControllerPage(this));
        primaryStage.show();
    }

    public void majConsultation() throws Exception{
        
        //this.tabl.setItems(listeMedaille);
    }

    public void pageCompetition() throws Exception{
        FXMLLoader loader = new FXMLLoader(new File("src/Vue/Fenetres/FenetreCreationCompetition.fxml").toURI().toURL());
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