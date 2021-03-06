package com.mycompany.Tiralabra_maven.logiikka.paikkaKeko;

import com.mycompany.Tiralabra_maven.logiikka.Paikka;
import java.util.PriorityQueue;

/**
 * Minimikeko toteutettuna Javan valmiilla tietorakenteella PriorityQueue. Keon
 * alkiot tyyppiä Paikka.
 */
public class PriorityQueueKekoAlkionaPaikka extends MinKekoAlkionaPaikka {

    private PriorityQueue<Paikka> q;

    public PriorityQueueKekoAlkionaPaikka() {
        this.q = new PriorityQueue<Paikka>();
    }

    /**
     * Kekoon lisätään kekoalkio.
     *
     * @param kekoAlkio lisättävä kekoalkio
     */
    @Override
    public void heapInsert(Paikka kekoAlkio) {
        this.q.add(kekoAlkio);
    }

    /**
     * Keosta poistetaan huipulla oleva pienimmän avaimen sisältävä kekoalkio.
     *
     * @return keosta poistettu pienimmän avaimen sisältänyt kekoalkio
     */
    @Override
    public Paikka heapDelMin() {
        return this.q.poll();
    }

    /**
     * Asettaa kekoalkion oikealle paikalle keossa, jos kekoalkion avain on
     * muuttunut.
     *
     * @param kekoAlkio oikealle paikalle asetettava kekoalkio
     */
    @Override
    public void heapDecreaseKey(Paikka kekoAlkio) {
        this.q.remove(kekoAlkio);
        this.q.add(kekoAlkio);
    }

    /**
     * Tarkastaa onko keko tyhjä.
     *
     * @return palautetaan true, jos keko on tyhjä
     */
    @Override
    public boolean heapIsEmpty() {
        return this.q.isEmpty();
    }

    /**
     * Testausta varten.
     */
    public int getHeapSize() {
        return this.q.size();
    }

    /**
     * Testausta varten.
     */
    public void tulosta() {
        Paikka poistettavaPaikka;
        while (!this.heapIsEmpty()) {
            poistettavaPaikka = this.heapDelMin();
            System.out.println(poistettavaPaikka.etaisyysAlkuun + ", " + poistettavaPaikka.etaisyysLoppuun);
        }
    }
}
