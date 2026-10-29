public class Carte {

    private String couleur;
    private int valeur;

    public Carte(String couleur, int valeur) {
        assert valeur > 1 && valeur < 15 : "La valeur doit être comprise entre 2 et 14";
        assert couleur.equals("Coeur") || couleur.equals("Carreau") || couleur.equals("Trèfle") || couleur.equals("Pique") : "La couleur doit être Coeur, Carreau, Trèfle ou Pique";

        this.couleur = couleur;
        this.valeur = valeur;
    }

    public String getCouleur() {
        return couleur;
    }

    public int getValeur() {
        return valeur;
    }
}
