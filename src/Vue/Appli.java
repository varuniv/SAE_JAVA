import src.bd.*;
import src.Modèle.*;
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
import javafx.scene.control.RadioButton;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

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
    private ListView listeComp;
    private TextField nomCompetition; //
    private ComboBox comboboxEpreuves;
    private RadioButton rdAthlete;
    private RadioButton rdEquipe;

    private Image imageJO1;
    private Image imageJO2;
    private Image eiffel; 



    
    private BD bd;
    @Override
    public void init(){
    // Initialisation des Images
    //this.imageJO1 = new Image("");
    this.imageJO2 = new Image("file:logoJOParis2024.png");
    //this.eiffel = new Image("");
    }
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
            ImageView imageCo = (ImageView) this.mainScene.lookup("#ImageCo");
            ImageView imageEiffel = (ImageView) this.mainScene.lookup("#Eiffel");
            imageCo.setImage(this.imageJO1);
            imageCo.setImage(this.eiffel);
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

// Getters et Setters de Competition
    public String getTfNomCompetition(){
        return this.nomCompetition.getText();
    }

    public ComboBox getComboBoxEpreuves(){
        return this.comboboxEpreuves;
    }

    public RadioButton getRadioButtonAthlete(){
        return this.rdAthlete;
    }

    public RadioButton getRadioButtonEquipe(){
        return this.rdEquipe;
    }

    public ListView getListComp(){
        return this.listeComp;
    }

    public void setTfNomCompetition(){
        this.nomCompetition.setText("");
    }
    
    public void setComboBoxEpreuves(){
        this.comboboxEpreuves = new ComboBox<>();
    }

    public void setRadioButtonAthlete(){
        this.rdAthlete.setSelected(false);
    }

    public void setRadioButtonEquipe(){
        this.rdEquipe.setSelected(false);
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
        ImageView imageCo = (ImageView) this.mainScene.lookup("#ImageCo");
        ImageView imageEiffel = (ImageView) this.mainScene.lookup("#Eiffel");
        imageCo.setImage(this.imageJO1);
        imageCo.setImage(this.eiffel);
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
        ImageView imageIns = (ImageView) this.mainScene.lookup("#ImageInscrire");
        imageIns.setImage(this.imageJO2);
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
        ImageView imageConsul = (ImageView) this.mainScene.lookup("#ImageConsul");
        imageConsul.setImage(this.imageJO2);
        primaryStage.show();
    }

    public void majConsultation() throws Exception{
        JeuxOlympique JeuxOlympique2024 = this.bd.getJeuxOlympiques();
        List<Pays> classementJO = JeuxOlympique2024.classementPays();
        List<List<String>> listeMedailleStr = new ArrayList<>();
        for(Pays paysJO : classementJO){
            String nom = paysJO.getNom();
            String placement = (classementJO.indexOf(paysJO)+1)+"";
            String or = paysJO.nbMedailleOr()+"";
            String argent =  paysJO.nbMedailleArgent()+"";
            String bronze =  paysJO.nbMedailleBronze()+"";
            String total = paysJO.nbMedaillesTotales()+"";
            List<String> listePays = Arrays.asList(nom, placement, or, argent, bronze, total);
            System.out.println(listePays);
            listeMedailleStr.add(listePays);
        }
        
        //ObservableList<List<String>> listeMedaille = FXCollections.observableArrayList(listeMedailleStr);
        //this.tableClassement.setItems(listeMedaille);
    }

    public void pageCompetition() throws Exception{
        FXMLLoader loader = new FXMLLoader(new File("src/Vue/Fenetres/FenetreCreationCompetition.fxml").toURI().toURL());
        Parent root = loader.load();
        primaryStage.setTitle("Création de Compétition");
        this.mainScene = new Scene(root);
        primaryStage.setScene(this.mainScene);
        this.bcreercomp = (Button) this.mainScene.lookup("#createComp");
        this.bback = (Button) this.mainScene.lookup("#retour");
        this.listeComp = (ListView) this.mainScene.lookup("#liste");
        this.nomCompetition = (TextField) this.mainScene.lookup("#nomcompet");
        this.comboboxEpreuves = (ComboBox) this.mainScene.lookup("#epreuves");
        this.rdAthlete = (RadioButton) this.mainScene.lookup("#solo");
        this.rdEquipe = (RadioButton) this.mainScene.lookup("#equipe");
        this.bcreercomp.setOnAction(new ControllerPage(this));
        this.bback.setOnAction(new ControllerPage(this));
    }

    public static void main(String[] args) {
        launch(args);
    }

    public BD getBD(){
        return this.bd;
    }

    public String getCurrentPage(){
        return primaryStage.getTitle();   
         }
}