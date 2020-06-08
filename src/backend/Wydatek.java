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
public class Wydatek {
    private int nrWydatku;
    private String przedmiot;
    private String dataKupna;
    private double koszt;
    private long nrPracownika;

    public Wydatek(int nrWydatku, String przedmiot, String dataKupna, double koszt, long nrPracownika) {
        this.nrWydatku = nrWydatku;
        this.przedmiot = przedmiot;
        this.dataKupna = dataKupna;
        this.koszt = koszt;
        this.nrPracownika = nrPracownika;
    }

    public int getNrWydatku() {
        return nrWydatku;
    }

    public void setNrWydatku(int nrWydatku) {
        this.nrWydatku = nrWydatku;
    }

    public String getPrzedmiot() {
        return przedmiot;
    }

    public void setPrzedmiot(String przedmiot) {
        this.przedmiot = przedmiot;
    }

    public String getDataKupna() {
        return dataKupna;
    }

    public void setDataKupna(String dataKupna) {
        this.dataKupna = dataKupna;
    }

    public double getKoszt() {
        return koszt;
    }

    public void setKoszt(double koszt) {
        this.koszt = koszt;
    }

    public long getNrPracownika() {
        return nrPracownika;
    }

    public void setNrPracownika(long nrPracownika) {
        this.nrPracownika = nrPracownika;
    }
    
    
}
