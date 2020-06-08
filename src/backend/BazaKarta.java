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
public class BazaKarta implements BazaInterface {
    private Connection polaczenie;

    public BazaKarta() {
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
        ArrayList<KartaDostepowa> karty = new ArrayList<>();
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            polaczenie=
                    DriverManager.getConnection(
                    "jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=office_management",
                            "office_manager","password"
                    );
            PreparedStatement ps = polaczenie.prepareStatement
                ("{call dbo.pobierzDaneKart}");
            ResultSet rezultat = ps.executeQuery();
            while(rezultat.next()){
                karty.add(new KartaDostepowa(rezultat.getInt("nr_karty"), 
                        RodzajKarty.valueOf(rezultat.getString("rodzaj_karty")), 
                        rezultat.getString("data_wykupienia"), 
                        rezultat.getString("data_zakonczenia"), 
                        rezultat.getLong("nr_pracownika")));
            }
            polaczenie.close();
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Błąd "+ex.getMessage(),"Błąd",
                    JOptionPane.ERROR_MESSAGE);
        }
        return karty;
    }

    @Override
    public void usun(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void zapis(String nrKarty, RodzajKarty rodzajKarty, String dataWykupienia, String dataZakonczenia, String nrPracownika){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            polaczenie=
                    DriverManager.getConnection(
                    "jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=office_management",
                            "office_manager","password"
                    );            
            CallableStatement procedura=
                    polaczenie.prepareCall("{call dbo.dodajKarteDostepowa(?,?,?,?,?)}");
            
            procedura.setLong(1,(int)Integer.parseInt(nrKarty));
            procedura.setString(2, rodzajKarty.toString());
            procedura.setString(3, dataWykupienia);
            procedura.setString(4, dataZakonczenia);
            procedura.setLong(5,Long.parseLong(nrPracownika));
            procedura.execute();
            
            polaczenie.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Błąd "+ex.getMessage(),"Błąd",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void modyfikuj(String nrKarty, RodzajKarty rodzajKarty, String dataWykupienia, String dataZakonczenia, String nrPracownika){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            polaczenie=
                    DriverManager.getConnection(
                    "jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=office_management",
                            "office_manager","password"
                    );            
            CallableStatement procedura=
                    polaczenie.prepareCall("{call dbo.modyfikujKarteDostepowa(?,?,?,?,?)}");
            
            procedura.setLong(1,(int)Integer.parseInt(nrKarty));
            procedura.setString(2, rodzajKarty.toString());
            procedura.setString(3, dataWykupienia);
            procedura.setString(4, dataZakonczenia);
            procedura.setLong(5,Long.parseLong(nrPracownika));
            procedura.execute();
            
            polaczenie.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Błąd "+ex.getMessage(),"Błąd",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void usun(String nrKarty){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            polaczenie=
                    DriverManager.getConnection(
                    "jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=office_management",
                            "office_manager","password"
                    ); 
            CallableStatement procedura=
                    polaczenie.prepareCall("{call dbo.usunKarteDostepowa(?)}");
            
            procedura.setLong(1, Integer.parseInt(nrKarty));
            procedura.execute();
            
            polaczenie.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Błąd "+ex.getMessage(),"Błąd",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
