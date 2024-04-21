import org.junit.jupiter.api.Test;
import org.peli.Pelaaja;

import static org.junit.jupiter.api.Assertions.*;

public class PelaajaTest {

    @org.junit.Test
    public void testValitseMerkki() {
        Pelaaja pelaaja = new Pelaaja();
        String merkki = pelaaja.valitseMerkki();
        assertNotNull(merkki);
        assertTrue(merkki.equals("kivi") || merkki.equals("paperi") || merkki.equals("sakset"));
    }

    @Test
    public void testLisaaVoitto() {
        Pelaaja pelaaja = new Pelaaja();
        assertEquals(0, pelaaja.getVoitot());
        pelaaja.lisaaVoitto();
        assertEquals(1, pelaaja.getVoitot());
        pelaaja.lisaaVoitto();
        assertEquals(2, pelaaja.getVoitot());
    }

    @Test
    public void testTarkistaVoittaja() {
        Pelaaja pelaaja = new Pelaaja();

        // Testataan pelaajan voittoa
        assertTrue(pelaaja.tarkistaVoittaja("kivi", "sakset"));
        assertTrue(pelaaja.tarkistaVoittaja("paperi", "kivi"));
        assertTrue(pelaaja.tarkistaVoittaja("sakset", "paperi"));

        // Testataan tasan pelaajan ja vastustajan merkkien voitot
        assertFalse(pelaaja.tarkistaVoittaja("kivi", "kivi"));
        assertFalse(pelaaja.tarkistaVoittaja("paperi", "paperi"));
        assertFalse(pelaaja.tarkistaVoittaja("sakset", "sakset"));

        // Testataan vastustajan voittoa
        assertFalse(pelaaja.tarkistaVoittaja("sakset", "kivi"));
        assertFalse(pelaaja.tarkistaVoittaja("kivi", "paperi"));
        assertFalse(pelaaja.tarkistaVoittaja("paperi", "sakset"));
    }
}
