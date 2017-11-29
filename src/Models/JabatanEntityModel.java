/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

//<editor-fold defaultstate="collapsed" desc="Import">
import Connection.ConnectionDB;
import Interface.EntitiesProcessInterface;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
//</editor-fold>

/**
 *
 * @author A F I F
 */
public class JabatanEntityModel implements EntitiesProcessInterface {

//<editor-fold defaultstate="collapsed" desc="Deklarasi Kelas, dan Entitas">
    private String idJabatan;
    private String namaJabatan;
    private String gajiPokok;
    private String deskripsi;
    private String[][] allValue;
    private ConnectionDB conn;
    
 
    
 
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Constructor">
    public JabatanEntityModel() {
        this.conn = new ConnectionDB();
   

    }

    public JabatanEntityModel(String idJabatan, String namaJabatan, String gajiPokok, String deskripsi) {
        this.conn = new ConnectionDB();

        this.idJabatan = idJabatan;
        this.namaJabatan = namaJabatan;
        this.gajiPokok = gajiPokok;
        this.deskripsi = deskripsi;
      

    }

//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Getter Setter">
    public String getIdJabatan() {
        return idJabatan;
    }

    public void setIdJabatan(String idJabatan) {
        this.idJabatan = idJabatan;
    }

    public String getNamaJabatan() {
        return namaJabatan;
    }

    public void setNamaJabatan(String namaJabatan) {
        this.namaJabatan = namaJabatan;
    }

    public String getGajiPokok() {
        return gajiPokok;
    }

    public void setGajiPokok(String gajiPokok) {
        this.gajiPokok = gajiPokok;
    }

    public String[][] getAllValue() {
        return allValue;
    }

    public void setAllValue(String[][] allValue) {
        this.allValue = allValue;
    }

    public ConnectionDB getConn() {
        return conn;
    }

    public void setConn(ConnectionDB conn) {
        this.conn = conn;
    }


    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }


//</editor-fold>
    
//<editor-fold defaultstate="collapsed" desc="Method Code">
    
    public JabatanEntityModel detailDataSet() {
        JabatanEntityModel model = new JabatanEntityModel();
        String[][] TempRecord = null;
        String Query = null;
        String Parse = null;
        int i = 0;
        
        getConn().Connection();
        try {
            if (!getIdJabatan().isEmpty()) {
                Parse = "WHERE id_jabatan = '" + getIdJabatan() + "'";
            } else if (!getNamaJabatan().isEmpty()) {
                Parse = "WHERE nama_jabatan = '" + getNamaJabatan() + "'";
            } else if (!getGajiPokok().isEmpty()) {
                Parse = "WHERE gaji_pokok = '" + getGajiPokok() + "'";
            } else if (!getDeskripsi().isEmpty()) {
                Parse = "WHERE deskripsi = '" + getDeskripsi() + "'";
            } else {
                Parse = "";
            }
            Query = "SELECT * FROM jabatan " + Parse;
            System.out.println("Query : " + Query);
            Statement Stat = getConn().getConnector().createStatement();
            ResultSet List = Stat.executeQuery(Query);
            
            if (Parse.isEmpty()) {
                ResultSetMetaData ListMeta = List.getMetaData();
                List.last();
                TempRecord = new String[List.getRow()][ListMeta.getColumnCount()];
                List.beforeFirst();
            }
            
            i = 0;
            while(List.next()){
                model.setIdJabatan(List.getString(1));
                setIdJabatan(model.getIdJabatan());
                model.setNamaJabatan(List.getString(2));
                setNamaJabatan(model.getNamaJabatan());
                model.setGajiPokok(List.getString(3));
                setGajiPokok(model.getGajiPokok());
                model.setDeskripsi(List.getString(4));
                setDeskripsi(model.getDeskripsi());
                if(Parse.isEmpty()){
                    TempRecord[i][0] = getIdJabatan();
                    TempRecord[i][1] = getNamaJabatan();
                    TempRecord[i][2] = getGajiPokok();
                    TempRecord[i][3] = getDeskripsi();
                }
                i++;
            }
            model.setAllValue(TempRecord);
            setAllValue(model.getAllValue());
            List.close();
            Stat.close();
            return model;
        } catch (Exception Ex) {
            System.out.println("ERROR : JabatanEntityModel.detailDataSet() " + Ex.getMessage().toString());
            return null;
        }
        
    }
    
    @Override
    public boolean addDataValue() {
        String Query = null;
        getConn().Connection();
        if (getIdJabatan().equals("")) {
            try {
                Query = "INSERT INTO jabatan VALUES(NULL, '" + getNamaJabatan() + "','"
                        + getGajiPokok() + "','" + getDeskripsi() + "')";
                System.out.print(Query);
                Statement Stat = getConn().getConnector().createStatement();
                Stat.executeUpdate(Query);
                Stat.close();
                return true;
            } catch (SQLException Ex) {
                System.out.println("ERROR : JabatanEntityModel.addDataValue() " + Ex.getMessage().toString());
                return false;
            }
        } else {
            try {
                Query = "INSERT INTO jabatan VALUES('" + getIdJabatan() + "','" + getNamaJabatan() + "','"
                        + getGajiPokok() + "','" + getDeskripsi() + "')";
                System.out.print(Query);
                Statement Stat = getConn().getConnector().createStatement();
                Stat.executeUpdate(Query);
                Stat.close();
                return true;
            } catch (SQLException Ex) {
                System.out.println("ERROR : JabatanEntityModel.addDataValue() " + Ex.getMessage().toString());
                return false;
            }
        }
        
    }
    
    @Override
    public boolean editDataValue() {
        String Query = null;
        
        getConn().Connection();
        try {
            Query = "UPDATE jabatan SET nama_jabatan = '" + getNamaJabatan() + "', "
                    + "gaji_pokok = '" + getGajiPokok() +"', "
                    + "deskripsi = '" + getDeskripsi()
                    + "' WHERE id_jabatan = '" + getIdJabatan() + "'";
            System.out.print(Query);
            Statement Stat = getConn().getConnector().createStatement();
            Stat.executeUpdate(Query);
            Stat.close();
            return true;
        } catch (SQLException Ex) {
            System.out.println("ERROR : JabatanEntityModel.editDataValue() " + Ex.getMessage().toString());
            return false;
        }
    }
    
    @Override
    public boolean subDataValue() {
        String Query = null;
        
        getConn().Connection();
        try {
            Query = "DELETE FROM jabatan WHERE id_jabatan = '" + getIdJabatan() + "'";
            System.out.println(Query);
            Statement Stat = getConn().getConnector().createStatement();
            Stat.executeUpdate(Query);
            Stat.close();
            return true;
        } catch (SQLException Ex) {
            System.out.println("ERROR : JabatanEntityModel.subDataValue() " + Ex.getMessage().toString());
            return false;
        }
        
    }
    
    @Override
    public String genIdDataValue() {
        String Query = null;
        String Result = null;
        int hasil = 0;
        
        getConn().Connection();
        try {
            Query = "SELECT id_jabatan FROM jabatan ORDER BY id_jabatan DESC LIMIT 1";
            Statement Stat = getConn().getConnector().createStatement();
            ResultSet List = Stat.executeQuery(Query);
            while (List.next()) {
                Result = List.getString(1).trim();
            }
            List.close();
            Stat.close();
            if (!Result.equals("")) {
                hasil = Integer.parseInt(Result) + 1;
                // System.out.print(hasil);
                Result = String.valueOf(hasil);
                if (Result.length() == 1) {
                    Result = "96300" + Result;
                } else if (Result.length() == 2) {
                    Result = "9630" + Result;
                } else if (Result.length() == 3) {
                    Result = "963" + Result;
                }
            } else {
                Result = "963001";
            }
            return Result;
        } catch (Throwable Ex) {
            System.out.println("ERROR : JabatanEntityModel.genIdDataValue() " + Ex.getMessage());
            return "963001";
        }
    }
    
    public void fillCboJabatan(JComboBox Cbo){
        String Query = null;
        
        getConn().Connection();
        String Val = null;
        try {
            Query = "SELECT DISTINCT nama_jabatan FROM jabatan";
            Statement Stat = getConn().getConnector().createStatement();
            ResultSet List = Stat.executeQuery(Query);
            
            Cbo.removeAllItems();
            Cbo.addItem("Pilih Jabatan");
            while(List.next()) {
                Val = List.getString(1);
                Cbo.addItem(Val);
            }
            
            List.close();
            Stat.close();
        } catch (Exception Ex) {
            System.out.println("ERROR : JabatanEntityModel.fillCboCategory() " + Ex.getMessage().toString());
        }
    }
//</editor-fold>
    
}
