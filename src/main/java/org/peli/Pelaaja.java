package org.peli;

/**
 *
 * @author Sanna Lohkovuori
 */

import java.util.HashMap;
import java.util.Map;

/**
 * Pelaajan toimintaan tarvittava logiikka
 */
public class Pelaaja {
    private int voitot;

    /**
     * Metodi tuottaa satunnaiseksi tulokseksi joko kivi, paperi tai sakset
     * @return Pelaajan valitsema käsimerkki (kivi, paperi tai sakset)
     */
    public String valitseMerkki() {
        Map<Integer, String> valinnat = new HashMap<>();
        valinnat.put(0, "kivi");
        valinnat.put(1, "paperi");
        valinnat.put(2, "sakset");

        int satunnainenArvo = (int) (Math.random() * 3);
        return valinnat.get(satunnainenArvo);
    }

    /**
     * Lisää voittoja yhdellä
     */
    public void lisaaVoitto() {
        voitot++;
    }

    /**
     * Palauttaa valitun pelaajan voittojen määrän
     * @return Voittojen lukumäärä
     */
    public int getVoitot() {
        return voitot;
    }

    /**
     * Tarkistaa, voittaako pelaaja vastustajan annettujen merkkien perusteella
     *
     * @param pelaajanMerkki Pelaajan valitsema merkki (kivi, paperi tai sakset)
     * @param vastustajanMerkki Vastustajan valitsema merkki (kivi, paperi tai sakset)
     * @return merkkien perusteella true jos pelaaja voitti, muuten false
     */
    public boolean tarkistaVoittaja(String pelaajanMerkki, String vastustajanMerkki) {
        return (pelaajanMerkki.equals("kivi") && vastustajanMerkki.equals("sakset")) ||
                (pelaajanMerkki.equals("paperi") && vastustajanMerkki.equals("kivi")) ||
                (pelaajanMerkki.equals("sakset") && vastustajanMerkki.equals("paperi"));
    }
}