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
public class BazaWydatek implements BazaInterface {

    private Connection polaczenie;

    public BazaWydatek() {
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
        ArrayList<Wydatek> wydatki = new ArrayList<>();
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            polaczenie=
                    DriverManager.getConnection(
                    "jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=office_management",
                            "office_manager","password"
                    );
            PreparedStatement ps = polaczenie.prepareStatement
                ("{call dbo.pobierzDaneWydatkow}");
            ResultSet rezultat = ps.executeQuery();
            while(rezultat.next()){
                wydatki.add(new Wydatek(rezultat.getInt("nr_wydatku"),
                rezultat.getString("przedmiot"),
                rezultat.getString("data_kupna"),
                rezultat.getDouble("koszt"),
                rezultat.getInt("nr_pracownika")));
            }
            polaczenie.close();
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Błąd "+ex.getMessage(),"Błąd",
                    JOptionPane.ERROR_MESSAGE);
        }
        return wydatki;
    }

    @Override
    public void usun(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void zapis(String przedmiot, String dataKupna, String koszt, String nrPracownika){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            polaczenie=
                    DriverManager.getConnection(
                    "jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=office_management",
                            "office_manager","password"
                    );            
            CallableStatement procedura=
                    polaczenie.prepareCall("{call dbo.dodajWydatek(?,?,?,?)}");
            
            procedura.setString(1,przedmiot);
            procedura.setString(2, dataKupna);
            procedura.setDouble(3,Double.parseDouble(koszt));
            procedura.setLong(4,Long.parseLong(nrPracownika));
            procedura.execute();
            
            polaczenie.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Błąd "+ex.getMessage(),"Błąd",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void modyfikuj(String nrWydatku,String przedmiot, String dataKupna, String koszt, String nrPracownika){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            polaczenie=
                    DriverManager.getConnection(
                    "jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=office_management",
                            "office_manager","password"
                    );            
            CallableStatement procedura=
                    polaczenie.prepareCall("{call dbo.modyfikujWydatki(?,?,?,?,?)}");
            
            procedura.setInt(1, Integer.parseInt(nrWydatku));
            procedura.setString(2,przedmiot);
            procedura.setString(3, dataKupna);
            procedura.setDouble(4,Double.parseDouble(koszt));
            procedura.setLong(5,Long.parseLong(nrPracownika));
            procedura.execute();
            
            polaczenie.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Błąd "+ex.getMessage(),"Błąd",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void usun(String nrWydatku){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            polaczenie=
                    DriverManager.getConnection(
                    "jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=office_management",
                            "office_manager","password"
                    );            
            CallableStatement procedura=
                    polaczenie.prepareCall("{call dbo.usunWydatek(?)}");
            
            procedura.setInt(1, Integer.parseInt(nrWydatku));
            procedura.execute();
            
            polaczenie.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Błąd "+ex.getMessage(),"Błąd",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
