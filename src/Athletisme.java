public class Athletisme extends Sport{
    private int distance;

    /**
     * @param nom
     * @param collectif
     * @param nbJoueur
     * @param distance
     */
    public Athletisme(String nom, boolean collectif, int nbJoueur, int distance) {
        super(nom, collectif, nbJoueur);
        this.distance = distance;
    }

    public int getDistance() {
        return this.distance;
    }
}
