public class Escrime extends Sport{
    private String typeEpee;

    public Escrime (String nom, boolean collectif, int nbJoueur, String typeEpee) {
        super(nom, collectif, nbJoueur);
        this.typeEpee = typeEpee;
    }

    public String getEpee() {
        return this.typeEpee;
    }
}
