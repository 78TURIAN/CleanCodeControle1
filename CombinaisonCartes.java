import java.util.ArrayList;

public class CombinaisonCartes {

    private final int BRELAN = 30;
    private final int SUITE = 40;
    private final int COULEUR = 45;
    private final int FULL = 50;
    private final int CARRE = 60;
    private final int QUINTE_FLUSH = 80;

    public static String determinerCombinaison(MainJoueur mainJoueur) {
        ArrayList<Carte> main = mainJoueur.getMain();

        
        
        for (Carte carte : main) {
            if (carte.getValeur() < 2 || carte.getValeur() > 14) {
                throw new IllegalArgumentException("La valeur de la carte doit être comprise entre 2 et 14.");
            }
            if (!carte.getCouleur().equals("Coeur") && !carte.getCouleur().equals("Carreau") &&
                !carte.getCouleur().equals("Trèfle") && !carte.getCouleur().equals("Pique")) {
                throw new IllegalArgumentException("La couleur de la carte doit être Coeur, Carreau, Trèfle ou Pique.");
            }
            
            if(checkBrelan(mainJoueur)) {
                return "Brelan";
            }

        }


        return "Combinaison à implémenter";
    }

    public static Boolean checkBrelan(MainJoueur mainJoueur) {
        
        for (Carte carte : mainJoueur.getMain()) {
            int valeur = carte.getValeur();
            int compte = 0;
            for (Carte c : mainJoueur.getMain()) {
                if (c.getValeur() == valeur) {
                    compte++;
                }
            }
            if (compte == 3) {
                return true;
            }
        }

        return false;
    }

}
