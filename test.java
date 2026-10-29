import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class test {

    @Test
    public void testClasseCarte() {
        Carte carte = new Carte("Coeur", 10);
        assertEquals("Coeur", carte.getCouleur());
        assertEquals(10, carte.getValeur());
    }


}
