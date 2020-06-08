/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

/**
 *
 * @author Piotr Buczek
 */
public class KartaDostepowa {
    private int nrKarty;
    private RodzajKarty rodzajKarty;
    private String dataWykupienia;
    private String dataZakonczenia;
    private long nrPracownika;

    public KartaDostepowa(int nrKarty, RodzajKarty rodzajKarty, String dataWykupienia, String dataZakonczenia, long nrPracownika) {
        this.nrKarty = nrKarty;
        this.rodzajKarty = rodzajKarty;
        this.dataWykupienia = dataWykupienia;
        this.dataZakonczenia = dataZakonczenia;
        this.nrPracownika = nrPracownika;
    }

    public int getNrKarty() {
        return nrKarty;
    }

    public void setNrKarty(int nrKarty) {
        this.nrKarty = nrKarty;
    }

    public RodzajKarty getRodzajKarty() {
        return rodzajKarty;
    }

    public void setRodzajKarty(RodzajKarty rodzajKarty) {
        this.rodzajKarty = rodzajKarty;
    }

    public String getDataWykupienia() {
        return dataWykupienia;
    }

    public void setDataWykupienia(String dataWykupienia) {
        this.dataWykupienia = dataWykupienia;
    }

    public String getDataZakonczenia() {
        return dataZakonczenia;
    }

    public void setDataZakonczenia(String dataZakonczenia) {
        this.dataZakonczenia = dataZakonczenia;
    }

    public long getNrPracownika() {
        return nrPracownika;
    }

    public void setNrPracownika(long nrPracownika) {
        this.nrPracownika = nrPracownika;
    }
    
    
}
