package org.peli;
/**
 *
 * @author Sanna Lohkovuori
 */

/**
 * Kivi, paperi, sakset pelin toimintalogiikka
 */
public class Peli {
    private Pelaaja pelaaja1;
    private Pelaaja pelaaja2;
    private int tasapelit;
    private int kierrokset = 0;

    /**
     * Luodaan uusi peli valitut kaksi pelaajaa parametreina
     *
     * @param pelaaja1 Ensimmäinen pelaaja
     * @param pelaaja2 Toinen pelaaja
     */
    public Peli(Pelaaja pelaaja1, Pelaaja pelaaja2) {
        this.pelaaja1 = pelaaja1;
        this.pelaaja2 = pelaaja2;
        this.tasapelit = 0;
    }

    /**
     * Aloittaa pelin ja jatkaa kunnes toinen pelaaja voittaa kolme kierrosta
     * Tulostaa jokaisen kierroksen tulokset konsoliin
     */
    public void pelaa() {
        while (pelaaja1.getVoitot() < 3 && pelaaja2.getVoitot() < 3) {
            kierrokset++;
            String merkkiP1 = pelaaja1.valitseMerkki();
            String merkkiP2 = pelaaja2.valitseMerkki();

            System.out.println("Pelaajan 1 merkki: " + merkkiP1);
            System.out.println("Pelaajan 2 merkki: " + merkkiP2);

            if (merkkiP1.equals(merkkiP2)) {
                tasapelit++;
                System.out.println("Tasapeli!");
            } else if (pelaaja1.tarkistaVoittaja(merkkiP1, merkkiP2)) {
                pelaaja1.lisaaVoitto();
                System.out.println("Pelaaja 1 voitti kierroksen!");
            } else {
                pelaaja2.lisaaVoitto();
                System.out.println("Pelaaja 2 voitti kierroksen!");
            }

            // Tarkista, onko joku pelaaja voittanut kolme kierrosta
            if (pelaaja1.getVoitot() >= 3 || pelaaja2.getVoitot() >= 3) {
                tulostaVoittaja();
                break;
            }

            System.out.println("Voitot yhteensä:");
            System.out.println("Tasapelejä: " + tasapelit);
            System.out.println("Pelaaja 1: " + pelaaja1.getVoitot());
            System.out.println("Pelaaja 2: " + pelaaja2.getVoitot() + "\n");

            viive();
        }

        // Tarkista, pelattiinko peliä ollenkaan
        if (kierrokset == 0) {
            System.out.println("Peliä ei pelattu.");
        }
    }

    /**
     * Tulostaa pelin voittajan.
     */
    public void tulostaVoittaja() {
        if (pelaaja1.getVoitot() >= 3) {
            System.out.println("\nPelaaja 1 voitti pelin!");
        } else {
            System.out.println("\nPelaaja 2 voitti pelin!");
        }
    }


    /**
     * Lisää 3 sekunnin viiveen pelikierrosten väliin.
     */
    public void viive() {
        try {
            Thread.sleep(2000); // Viivettä millisekunteina (tässä 2 sekuntia)
        } catch (InterruptedException e) {
            System.err.println("Virhe viiveessä: " + e.getMessage());
        }
    }

}