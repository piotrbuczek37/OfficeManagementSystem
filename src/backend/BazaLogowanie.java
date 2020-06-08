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
import javax.swing.JOptionPane;

/**
 *
 * @author Piotr Buczek
 */
public class BazaLogowanie {
    private Connection polaczenie;

    public BazaLogowanie() {
    }
    
    public User zaloguj(String username){
        User user = null;
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            polaczenie=
                    DriverManager.getConnection(
                    "jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=office_management",
                            "office_manager","password"
                    );
            PreparedStatement ps = polaczenie.prepareStatement
                ("{call dbo.logowanie(?)}");
            ps.setString(1, username);
            ResultSet rezultat = ps.executeQuery();
            while(rezultat.next()){
                user = new User(rezultat.getString("username"),rezultat.getString("password"));
            }
            polaczenie.close();
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Podano złe dane" +ex.getMessage(),"Błąd logowania",
                    JOptionPane.ERROR_MESSAGE);
        }
        return user;
    }
}
