import java.util.ArrayList;

public class MainJoueur {

    private ArrayList<Carte> main;

    final int NOMBRE_DE_CARTES = 5;

    public MainJoueur(ArrayList<Carte> main) {
        assert main.size() == NOMBRE_DE_CARTES : "La main doit contenir exactement " + NOMBRE_DE_CARTES + " cartes.";
        this.main = main;
    }

    public ArrayList<Carte> getMain() {
        return main;
    }

}