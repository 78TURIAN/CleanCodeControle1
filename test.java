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

    @Test void testCombinaisonCartesFull(){
        ArrayList<Carte> main = new ArrayList<>();
        ArrayList<Carte> main2 = new ArrayList<>();
        main.add(new Carte("Coeur", 10));
        main.add(new Carte("Carreau", 10));
        main.add(new Carte("Trèfle", 10));
        main.add(new Carte("Pique", 2));
        main.add(new Carte("Coeur", 2));

        main2.add(new Carte("Coeur", 2));
        main2.add(new Carte("Carreau", 5));
        main2.add(new Carte("Trèfle", 7));
        main2.add(new Carte("Pique", 9));
        main2.add(new Carte("Coeur", 6));

        MainJoueur mainJoueur = new MainJoueur(main);
        assertEquals("Full", CombinaisonCartes.determinerCombinaison(mainJoueur));

        MainJoueur mainJoueur2 = new MainJoueur(main2);
        assertEquals("combinaison non reconnue", CombinaisonCartes.determinerCombinaison(mainJoueur2));
    }

    @Test 
    public void testCombinaisonCouleur(){
        ArrayList<Carte> main = new ArrayList<>();
        main.add(new Carte("Coeur", 10));
        main.add(new Carte("Coeur", 5));
        main.add(new Carte("Coeur", 7));
        main.add(new Carte("Coeur", 2));
        main.add(new Carte("Coeur", 14));

        ArrayList<Carte> main2 = new ArrayList<>();
        main2.add(new Carte("Carreau", 10));
        main2.add(new Carte("Coeur", 5));
        main2.add(new Carte("Coeur", 7));
        main2.add(new Carte("Coeur", 2));
        main2.add(new Carte("Coeur", 14));

        MainJoueur mainJoueur = new MainJoueur(main);
        assertEquals("Couleur", CombinaisonCartes.determinerCombinaison(mainJoueur));

        MainJoueur mainJoueur2 = new MainJoueur(main2);
        assertEquals("combinaison non reconnue", CombinaisonCartes.determinerCombinaison(mainJoueur2));
    }

    @Test 
    public void testCombinaisonSuite(){
        ArrayList<Carte> main = new ArrayList<>();
        main.add(new Carte("Coeur", 10));
        main.add(new Carte("Carreau", 11));
        main.add(new Carte("Trèfle", 12));
        main.add(new Carte("Pique", 13));
        main.add(new Carte("Coeur", 14));

        MainJoueur mainJoueur = new MainJoueur(main);
        assertEquals("combinaison non reconnue", CombinaisonCartes.determinerCombinaison(mainJoueur));
    }



}
