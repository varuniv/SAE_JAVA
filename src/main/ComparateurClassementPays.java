package main;
import java.util.Comparator;

/**
 * ComparateurClassementPays
 */
public class ComparateurClassementPays implements Comparator<Pays>{

    /**
     * @return un int indiquant si p1 est plus grand que p2.
     */
    @Override
    public int compare(Pays p1, Pays p2){
        int res = p1.nbMedailleOr() - p2.nbMedailleOr();

        if (res == 0){ res = p1.nbMedailleArgent() - p2.nbMedailleArgent(); }
        
        if (res == 0){ res = p1.nbMedailleBronze() - p2.nbMedailleBronze(); }
        

        return res; 
    } 
}