/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Piotr Buczek
 */
public class BazaPracownik implements BazaInterface {
    private Connection polaczenie;
    
    public BazaPracownik() {        
        
    }

    @Override
    public void zapis(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modyfikuj(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList odczyt() {
        ArrayList<Pracownik> pracownicy = new ArrayList<>();
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            polaczenie=
                    DriverManager.getConnection(
                    "jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=office_management",
                            "office_manager","password"
                    );
            PreparedStatement ps = polaczenie.prepareStatement
                ("{call dbo.pobierzDanePracownika}");
            ResultSet rezultat = ps.executeQuery();
            while(rezultat.next()){
                pracownicy.add(new Pracownik(rezultat.getLong("nr_pracownika"), 
                        rezultat.getString("imie"), 
                        rezultat.getString("nazwisko"), 
                        rezultat.getInt("numer_telefonu"), 
                        rezultat.getString("miejscowosc"), 
                        rezultat.getString("kodpocztowy"), 
                        rezultat.getString("ulica"), 
                        rezultat.getString("stanowisko"), 
                        rezultat.getString("data_rozpoczenia_pracy"), 
                        rezultat.getString("data_zakonczenia_pracy")));
            }
            polaczenie.close();
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Błąd "+ex.getMessage(),"Błąd",
                    JOptionPane.ERROR_MESSAGE);
        }
        return pracownicy;
    }

    @Override
    public void usun(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void zapis(String nrPracownika, String imie, String nazwisko, String numerTelefonu, String miejscowosc, String kodPocztowy, String ulica, String stanowisko, String dataRozpoczeniaPracy, String dataZakonczeniaPracy){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            polaczenie=
                    DriverManager.getConnection(
                    "jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=office_management",
                            "office_manager","password"
                    );            
            CallableStatement procedura=
                    polaczenie.prepareCall("{call dbo.dodajPracownika(?,?,?,?,?,?,?,?,?,?)}");
            
            procedura.setLong(1,(long)Long.parseLong(nrPracownika));
            procedura.setString(2, imie);
            procedura.setString(3, nazwisko);
            procedura.setInt(4, (int)Integer.parseInt(numerTelefonu));
            procedura.setString(5, miejscowosc);
            procedura.setString(6, kodPocztowy);
            procedura.setString(7, ulica);
            procedura.setString(8, stanowisko);
            procedura.setString(9, dataRozpoczeniaPracy);            
            procedura.setString(10, dataZakonczeniaPracy);
            procedura.execute();
            
            polaczenie.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Błąd "+ex.getMessage(),"Błąd",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void modyfikuj(String nrPracownika, String imie, String nazwisko, String numerTelefonu, String miejscowosc, String kodPocztowy, String ulica, String stanowisko, String dataRozpoczeniaPracy, String dataZakonczeniaPracy){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            polaczenie=
                    DriverManager.getConnection(
                    "jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=office_management",
                            "office_manager","password"
                    );            
            CallableStatement procedura=
                    polaczenie.prepareCall("{call dbo.modyfikujPracownika(?,?,?,?,?,?,?,?,?,?)}");
            
            procedura.setLong(1,(long)Long.parseLong(nrPracownika));
            procedura.setString(2, imie);
            procedura.setString(3, nazwisko);
            procedura.setInt(4, (int)Integer.parseInt(numerTelefonu));
            procedura.setString(5, miejscowosc);
            procedura.setString(6, kodPocztowy);
            procedura.setString(7, ulica);
            procedura.setString(8, stanowisko);
            procedura.setString(9, dataRozpoczeniaPracy);            
            procedura.setString(10, dataZakonczeniaPracy);
            procedura.execute();
            
            polaczenie.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Błąd "+ex.getMessage(),"Błąd",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void usun(String nrPracownika){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            polaczenie=
                    DriverManager.getConnection(
                    "jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=office_management",
                            "office_manager","password"
                    ); 
            CallableStatement procedura=
                    polaczenie.prepareCall("{call dbo.usunPracownika(?)}");
            
            procedura.setLong(1, Long.parseLong(nrPracownika));
            procedura.execute();
            
            polaczenie.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Błąd "+ex.getMessage(),"Błąd",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
