import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class test {

    @Test
    public void testClasseCarte() {
        Carte carte = new Carte("Coeur", 10);
        assertEquals("Coeur", carte.getCouleur());
        assertEquals(10, carte.getValeur());
    }

    @Test
    public void testClasseMainJoueur() {
        ArrayList<Carte> main = new ArrayList<>();
        main.add(new Carte("Coeur", 10));
        main.add(new Carte("Carreau", 5));
        main.add(new Carte("Trèfle", 7));
        main.add(new Carte("Pique", 2));
        main.add(new Carte("Coeur", 14));

        MainJoueur mainJoueur = new MainJoueur(main);
        assertEquals(main, mainJoueur.getMain());
    }

    @Test 
    public void testCombinaisonCartes() {
        // Test pour la classe CombinaisonCartes
        ArrayList<Carte> main = new ArrayList<>();
        main.add(new Carte("Coeur", 10));
        main.add(new Carte("Carreau", 10));
        main.add(new Carte("Trèfle", 10));
        main.add(new Carte("Pique", 2));
        main.add(new Carte("Coeur", 14));

        MainJoueur mainJoueur = new MainJoueur(main);
        assertTrue(CombinaisonCartes.checkBrelan(mainJoueur));
        assertEquals("Brelan", CombinaisonCartes.determinerCombinaison(mainJoueur));
    }

    @Test
    public void testCombinaisonCartesCarre() {
        // Test pour la classe CombinaisonCartes
        ArrayList<Carte> main = new ArrayList<>();
        main.add(new Carte("Coeur", 10));
        main.add(new Carte("Carreau", 10));
        main.add(new Carte("Trèfle", 10));
        main.add(new Carte("Pique", 10));
        main.add(new Carte("Coeur", 14));

        MainJoueur mainJoueur = new MainJoueur(main);
        assertTrue(CombinaisonCartes.checkCarre(mainJoueur));
        assertEquals("Carré", CombinaisonCartes.determinerCombinaison(mainJoueur));
    }



}
