import org.junit.jupiter.api.*;
import org.peli.Pelaaja;
import org.peli.Peli;

import static org.junit.jupiter.api.Assertions.*;

public class PeliTest {

    private Peli peli;
    private Pelaaja pelaaja1;
    private Pelaaja pelaaja2;

    @BeforeEach
    public void setUp() {
        pelaaja1 = new Pelaaja();
        pelaaja2 = new Pelaaja();
        peli = new Peli(pelaaja1, pelaaja2);
    }

    @Test
    public void valitseMerkkiTest() {
        // Pelaaja 1:n valinta
        String merkkiP1 = pelaaja1.valitseMerkki();
        assertTrue(merkkiP1.equals("kivi") || merkkiP1.equals("paperi") || merkkiP1.equals("sakset"));

        // Pelaaja 2:n valinta
        String merkkiP2 = pelaaja2.valitseMerkki();
        assertTrue(merkkiP2.equals("kivi") || merkkiP2.equals("paperi") || merkkiP2.equals("sakset"));
    }

    @Test
    public void lisaaVoittoTest() {
        pelaaja1.lisaaVoitto();
        assertEquals(1, pelaaja1.getVoitot(), "Voittojen määrä ei ole 1");

        pelaaja2.lisaaVoitto();
        assertEquals(1, pelaaja2.getVoitot(), "Voittojen määrä ei ole 1");
    }

    @Test
    public void getVoitotTest() {
        assertEquals(0, pelaaja1.getVoitot(), "Voittojen määrä ei ole 0");
        assertEquals(0, pelaaja2.getVoitot(), "Voittojen määrä ei ole 0");
    }

    @Test
    public void tarkistaVoittajaTest() {
        // Pelaaja 1 voittaa
        assertTrue(pelaaja1.tarkistaVoittaja("kivi", "sakset"));
        assertTrue(pelaaja1.tarkistaVoittaja("paperi", "kivi"));
        assertTrue(pelaaja1.tarkistaVoittaja("sakset", "paperi"));

        // Pelaaja 2 voittaa
        assertTrue(pelaaja2.tarkistaVoittaja("kivi", "sakset"));
        assertTrue(pelaaja2.tarkistaVoittaja("paperi", "kivi"));
        assertTrue(pelaaja2.tarkistaVoittaja("sakset", "paperi"));

        // Tasapeli
        assertFalse(pelaaja1.tarkistaVoittaja("kivi", "kivi"));
        assertFalse(pelaaja2.tarkistaVoittaja("paperi", "paperi"));
        assertFalse(pelaaja1.tarkistaVoittaja("sakset", "sakset"));
    }

    @Test
    public void tulostaVoittajaTest() {
        // Peliä ei ole pelattu
        peli.tulostaVoittaja(); // Ei tulostetta

        // Pelaaja 1 voittaa
        pelaaja1.lisaaVoitto();
        pelaaja1.lisaaVoitto();
        pelaaja1.lisaaVoitto();
        peli.tulostaVoittaja(); // Tulostaa "Pelaaja 1 voitti pelin!"

        // Pelaaja 2 voittaa
        pelaaja2.lisaaVoitto();
        pelaaja2.lisaaVoitto();
        pelaaja2.lisaaVoitto();
        peli.tulostaVoittaja(); // Tulostaa "Pelaaja 2 voitti pelin!"
    }

    @Test
    public void viiveTest() {
        // Viiveen tarkka testaaminen on vaikeaa JUnit-testeissä
        // Voit testata viiveen olemassaoloa tarkistamalla kuluneen ajan
        long startTime = System.currentTimeMillis();
        peli.viive();
        long endTime = System.currentTimeMillis();
        assertTrue(endTime - startTime >= 2000, "Viive ei ole 2 sekuntia");
    }
}
