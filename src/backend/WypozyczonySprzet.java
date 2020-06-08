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
public class WypozyczonySprzet {
    private long nrSeryjny;
    private String nazwaSprzetu;
    private String dataWydania;
    private long nrPracownika;

    public WypozyczonySprzet(long nrSeryjny, String nazwaSprzetu, String dataWydania, long nrPracownika) {
        this.nrSeryjny = nrSeryjny;
        this.nazwaSprzetu = nazwaSprzetu;
        this.dataWydania = dataWydania;
        this.nrPracownika = nrPracownika;
    }

    public long getNrSeryjny() {
        return nrSeryjny;
    }

    public void setNrSeryjny(long nrSeryjny) {
        this.nrSeryjny = nrSeryjny;
    }

    public String getNazwaSprzetu() {
        return nazwaSprzetu;
    }

    public void setNazwaSprzetu(String nazwaSprzetu) {
        this.nazwaSprzetu = nazwaSprzetu;
    }

    public String getDataWydania() {
        return dataWydania;
    }

    public void setDataWydania(String dataWydania) {
        this.dataWydania = dataWydania;
    }

    public long getNrPracownika() {
        return nrPracownika;
    }

    public void setNrPracownika(long nrPracownika) {
        this.nrPracownika = nrPracownika;
    }
    
    
}
