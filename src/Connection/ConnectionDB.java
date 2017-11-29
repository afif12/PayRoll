/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

//<editor-fold defaultstate="collapsed" desc="Import">
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
//</editor-fold>

/**
 *
 * @author A F I F
 */

public class ConnectionDB {

//<editor-fold defaultstate="collapsed" desc="Deklarasi Kelas">
    private Connection Connector;
    
//</editor-fold>
    
//<editor-fold defaultstate="collapsed" desc="Construktor">
    public ConnectionDB() {
        //empty
        String Url;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try {
                Url = "jdbc:mysql://localhost:3306/penggajiandb";
                Connector = DriverManager.getConnection(Url, "root", "");
                
            } catch (SQLException Ex) {
                System.out.println("ERROR : Connection() " + Ex.getMessage().toString());
            }
            
        } catch (ClassNotFoundException Ex) {
            System.out.println("ERROR : Connection() " + Ex.getMessage().toString());
        }
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Getter Setter">
    public Connection getConnector() {
        return Connector;
    }

    public void setConnector(Connection Connector) {
        this.Connector = Connector;
    }

  

//</editor-fold>
    
//<editor-fold defaultstate="collapsed" desc="Method Code">
    public int Connection(int b) {
        String Url;

        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Url = "jdbc:mysql://localhost:3306/penggajiandb";
                Connector = DriverManager.getConnection(Url, "root", "");
                return 1;
            } catch (SQLException Ex) {
                return 2;
            }
        } catch (ClassNotFoundException Ex) {
            return 3;

        }
    }
    
    public void Connection() {
        String Url;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try {
                Url = "jdbc:mysql://localhost:3306/penggajiandb";
                Connector = DriverManager.getConnection(Url, "root", "");
                
            } catch (SQLException Ex) {
               // System.out.println("ERROR : Connection() " + Ex.getMessage().toString());
            }
            
        } catch (ClassNotFoundException Ex) {
           // System.out.println("ERROR : Connection() " + Ex.getMessage().toString());
        }
        
    }
    
    public ResultSet getData(String Query){
        ResultSet Rs = null;
        try{
            Statement Stat = Connector.createStatement();
            Rs = Stat.executeQuery(Query);
        }catch(SQLException x){
            JOptionPane.showMessageDialog(null,"Gagal Mengambil Data"+ x.getMessage());
       
        }
        return Rs;
    }
//</editor-fold>
    
}
