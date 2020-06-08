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
public class Pracownik {
    private long nrPracownika;
    private String imie;
    private String nazwisko;
    private int numerTelefonu;
    private String miejscowosc;
    private String kodPocztowy;
    private String ulica;
    private String stanowisko;
    private String dataRozpoczeniaPracy;
    private String dataZakonczeniaPracy;

    public Pracownik(long nrPracownika, String imie, String nazwisko, int numerTelefonu, String miejscowosc, String kodPocztowy, String ulica, String stanowisko, String dataRozpoczeniaPracy, String dataZakonczeniaPracy) {
        this.nrPracownika = nrPracownika;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.numerTelefonu = numerTelefonu;
        this.miejscowosc = miejscowosc;
        this.kodPocztowy = kodPocztowy;
        this.ulica = ulica;
        this.stanowisko = stanowisko;
        this.dataRozpoczeniaPracy = dataRozpoczeniaPracy;
        this.dataZakonczeniaPracy = dataZakonczeniaPracy;
    }

    public long getNrPracownika() {
        return nrPracownika;
    }

    public void setNrPracownika(long nrPracownika) {
        this.nrPracownika = nrPracownika;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public int getNumerTelefonu() {
        return numerTelefonu;
    }

    public void setNumerTelefonu(int numerTelefonu) {
        this.numerTelefonu = numerTelefonu;
    }

    public String getMiejscowosc() {
        return miejscowosc;
    }

    public void setMiejscowosc(String miejscowosc) {
        this.miejscowosc = miejscowosc;
    }

    public String getKodPocztowy() {
        return kodPocztowy;
    }

    public void setKodPocztowy(String kodPocztowy) {
        this.kodPocztowy = kodPocztowy;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getStanowisko() {
        return stanowisko;
    }

    public void setStanowisko(String stanowisko) {
        this.stanowisko = stanowisko;
    }

    public String getDataRozpoczeniaPracy() {
        return dataRozpoczeniaPracy;
    }

    public void setDataRozpoczeniaPracy(String dataRozpoczeniaPracy) {
        this.dataRozpoczeniaPracy = dataRozpoczeniaPracy;
    }

    public String getDataZakonczeniaPracy() {
        return dataZakonczeniaPracy;
    }

    public void setDataZakonczeniaPracy(String dataZakonczeniaPracy) {
        this.dataZakonczeniaPracy = dataZakonczeniaPracy;
    }
    
    
}
