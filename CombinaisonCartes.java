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

            
            if(checkQuinteFlush(mainJoueur)) {
                return "Quinte Flush";
            }

            if(checkCarre(mainJoueur)) {
                return "Carré";
            }  

            if(checkFull(mainJoueur)) {
                return "Full";
            }
            
            if(checkCouleur(mainJoueur)) {
                return "Couleur";
            }              

            if(checkSuite(mainJoueur)) {
                return "Suite";
            }
            
            if(checkBrelan(mainJoueur)) {
                return "Brelan";
            }
        }
        return "combinaison non reconnue";
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

    public static Boolean checkCarre(MainJoueur mainJoueur) {
        for (Carte carte : mainJoueur.getMain()) {
            int valeur = carte.getValeur();
            int compte = 0;
            for (Carte c : mainJoueur.getMain()) {
                if (c.getValeur() == valeur) {
                    compte++;
                }
            }
            if (compte == 4) {
                return true;
            }
        }

        return false;
    }

    public static Boolean checkFull(MainJoueur mainJoueur) {
        boolean brelan = checkBrelan(mainJoueur);
        boolean paire = false;

        for (Carte carte : mainJoueur.getMain()) {
            int valeur = carte.getValeur();
            int compte = 0;
            for (Carte c : mainJoueur.getMain()) {
                if (c.getValeur() == valeur) {
                    compte++;
                }
            }
            if (compte == 2) {
                paire = true;
                break;
            }
        }

        return brelan && paire;
    }

    public static Boolean checkCouleur(MainJoueur mainJoueur) {
        String couleur = mainJoueur.getMain().get(0).getCouleur();
        for (Carte carte : mainJoueur.getMain()) {
            if (!carte.getCouleur().equals(couleur)) {
                return false;
            }
        }
        return true;
    }

    public static Boolean checkSuite(MainJoueur mainJoueur) {
        ArrayList<Integer> valeurs = new ArrayList<>();
        for (Carte carte : mainJoueur.getMain()) {
            valeurs.add(carte.getValeur());
        }
        valeurs.sort(Integer::compareTo);
        for (int i = 0; i < valeurs.size() - 1; i++) {
            if (valeurs.get(i) + 1 != valeurs.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public static Boolean checkQuinteFlush(MainJoueur mainJoueur) {
        return checkSuite(mainJoueur) && checkCouleur(mainJoueur);
    }

}
