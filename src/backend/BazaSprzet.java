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
public class BazaSprzet implements BazaInterface {

    private Connection polaczenie;

    public BazaSprzet() {
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
        ArrayList<WypozyczonySprzet> sprzety = new ArrayList<>();
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            polaczenie=
                    DriverManager.getConnection(
                    "jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=office_management",
                            "office_manager","password"
                    );
            PreparedStatement ps = polaczenie.prepareStatement
                ("{call dbo.pobierzDaneSprzetu}");
            ResultSet rezultat = ps.executeQuery();
            while(rezultat.next()){
                sprzety.add(new WypozyczonySprzet(rezultat.getLong("nr_seryjny"), 
                        rezultat.getString("nazwa_sprzetu"), 
                        rezultat.getString("data_wydania"), 
                        rezultat.getLong("nr_pracownika")));
            }
            polaczenie.close();
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Błąd "+ex.getMessage(),"Błąd",
                    JOptionPane.ERROR_MESSAGE);
        }
        return sprzety;
    }

    @Override
    public void usun(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void modyfikuj(String nrSeryjny, String nazwaSprzetu, String dataWydania, String nrPracownika){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            polaczenie=
                    DriverManager.getConnection(
                    "jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=office_management",
                            "office_manager","password"
                    );            
            CallableStatement procedura=
                    polaczenie.prepareCall("{call dbo.modyfikujWypozyczonySprzet(?,?,?,?)}");
            
            procedura.setLong(1, Long.parseLong(nrSeryjny));
            procedura.setString(2,nazwaSprzetu);
            procedura.setString(3, dataWydania);
            procedura.setLong(4,Long.parseLong(nrPracownika));
            procedura.execute();
            
            polaczenie.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Błąd "+ex.getMessage(),"Błąd",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void zapis(String nrSeryjny, String nazwaSprzetu, String dataWydania, String nrPracownika){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            polaczenie=
                    DriverManager.getConnection(
                    "jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=office_management",
                            "office_manager","password"
                    );            
            CallableStatement procedura=
                    polaczenie.prepareCall("{call dbo.dodajWypozyczonySprzet(?,?,?,?)}");
            
            procedura.setLong(1, Long.parseLong(nrSeryjny));
            procedura.setString(2,nazwaSprzetu);
            procedura.setString(3, dataWydania);
            procedura.setLong(4,Long.parseLong(nrPracownika));
            procedura.execute();
            
            polaczenie.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Błąd "+ex.getMessage(),"Błąd",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void usun(String nrSeryjny){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            polaczenie=
                    DriverManager.getConnection(
                    "jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=office_management",
                            "office_manager","password"
                    );            
            CallableStatement procedura=
                    polaczenie.prepareCall("{call dbo.usunWypozyczonySprzet(?)}");
            
            procedura.setLong(1, Long.parseLong(nrSeryjny));
            procedura.execute();
            
            polaczenie.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Błąd "+ex.getMessage(),"Błąd",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
