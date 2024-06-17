package main.java.com.cdal;
import java.util.ArrayList;
import java.util.List;

public class JeuxOlympique  {
    /**
     * @param listpays liste des pays qui participe
     * @param nom nom de JO 
     */
    private List<Pays> listpays;
    private String nom;
    
    /**
     * Constructeur de la classe JeuxOlympique
     * @param nom nom de JO
     */
    public JeuxOlympique(String nom) {
        this.nom = nom;
        this.listpays = new ArrayList<>();
    }

    /**
     * geteur de listpays
     * @return la liste des pays participents
     */
    public List<Pays> getPays() {
        return listpays;
    } 

    /**
     * geteur de nom
     * @return nom de JO
     */
    public String getNom() {
        return this.nom;
    }
    /**
     * ajoute un pays à le list des pays
     * @param Pays pays à ajouter
     */
    public void ajoutePays(Pays Pays){
        getPays().add(Pays);
    }
    
    /**
     * Affichage de JO
     */
    @Override
    public String toString() {
        return this.nom;
    }

    /**
     *@return la liste des pays triée par médaille  
     */
    public List<Pays> ClassementPays(){
        List<Pays> tmp = new ArrayList<>(); tmp.addAll(this.getPays());
        tmp.sort(new ComparateurClassementPays());
        return tmp;
    }
}
