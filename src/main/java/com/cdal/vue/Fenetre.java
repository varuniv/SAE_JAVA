package main.java.com.cdal.vue;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Platform;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;



public class Fenetre  extends Application {
    
    private Label resultat;
    private TextField tf1;
    private TextField tf2;
    
    @Override
    public void init(){
        // cette méthode est utilisée pour initialiser les éléments 
        // non graphiques et événetuellement graphiques autres que la Scène et le Stage
        this.tf1 = new TextField();
        this.tf2 = new TextField();
        this.resultat = new Label("");        
    }

  

    
   
    
    @Override
    public void start(Stage stage){              
        Pane pane =new Pane();
        Scene scene = new Scene(pane);
        stage.setTitle("");
        stage.setScene(scene);
        stage.show();
    }
  
    /**
     * Cette méthode efface les deux textfields et le label résultat
     * en y mettant une chaine de caractère vide
     */
    public void efface(){
        this.tf1.setText("");
        this.tf2.setText(""); 
        this.resultat.setText("");
    }

    public void quitte(){
        Platform.exit();
    }
    public static void main(String[] args){
        // Permet d'instancier et de lancer l'application 
        launch(args);
    }
}
    
