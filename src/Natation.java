public class Natation extends Sport {
    private int distance;

    public Natation(String nom, boolean collectif, int nbJoueur, int distance) {
        super(nom, collectif, nbJoueur);
        this.distance = distance;
    }

    public int getDistance() {
        return this.distance;
    }
}
