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

public class KaryawanEntityModel implements EntitiesProcessInterface {

//<editor-fold defaultstate="collapsed" desc="Deklarasi Kelas, dan Entitas">
    private String idKaryawan;
    private String namaKaryawan;
    private String jenisKelamin;
    private String tempatLahir;
    private String tanggalLahir;
    private String agama;
    private String status;
    private String kontak;
    private String alamat;
    private JabatanEntityModel jabatan;

    private String[][] allValue;
    private ConnectionDB conn;

//</editor-fold>
    
//<editor-fold defaultstate="collapsed" desc="Contructor">
    public KaryawanEntityModel() {
        this.conn = new ConnectionDB();
        jabatan = new JabatanEntityModel();
    }

    public KaryawanEntityModel(String idKaryawan, String namaKaryawan,
            String jenisKelamin, String tempatLahir,
            String tanggalLahir, String agama,
            String idJabatan, String status,
            String kontak, String deskripsi) {

        this.conn = new ConnectionDB();
        jabatan = new JabatanEntityModel();

        this.idKaryawan = idKaryawan;
        this.namaKaryawan = namaKaryawan;
        this.jenisKelamin = jenisKelamin;
        this.tempatLahir = tempatLahir;
        this.tanggalLahir = tanggalLahir;
        this.agama = agama;
        this.status = status;
        this.kontak = kontak;
        this.alamat = deskripsi;
        this.jabatan.setIdJabatan(idJabatan);
    }

//</editor-fold>
    
//<editor-fold defaultstate="collapsed" desc="Getter Setter">
    public JabatanEntityModel getJabatan() {
        return jabatan;
    }

    public void setJabatan(JabatanEntityModel jabatan) {
        this.jabatan = jabatan;
    }

    public String getIdKaryawan() {
        return idKaryawan;
    }

    public void setIdKaryawan(String idKaryawan) {
        this.idKaryawan = idKaryawan;
    }

    public String getNamaKaryawan() {
        return namaKaryawan;
    }

    public void setNamaKaryawan(String namaKaryawan) {
        this.namaKaryawan = namaKaryawan;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getAgama() {
        return agama;
    }

    public void setAgama(String agama) {
        this.agama = agama;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getKontak() {
        return kontak;
    }

    public void setKontak(String kontak) {
        this.kontak = kontak;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
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

    public String getTempatLahir() {
        return tempatLahir;
    }

    public void setTempatLahir(String tempatLahir) {
        this.tempatLahir = tempatLahir;
    }

    public String getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(String tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

//</editor-fold>
    
//<editor-fold defaultstate="collapsed" desc="Method Code">
    public KaryawanEntityModel detailDataSet() {
        KaryawanEntityModel model = new KaryawanEntityModel();
        String[][] TempRecord = null;
        String Query = null;
        String Parse = null;
        int i = 0;

        getConn().Connection();
        try {
            if (!getIdKaryawan().isEmpty()) {
                Parse = "WHERE id_user = '" + getIdKaryawan() + "'";
            } else if (!getNamaKaryawan().isEmpty()) {
                Parse = "WHERE nama = '" + getNamaKaryawan() + "'";
            } else if (!getJenisKelamin().isEmpty()) {
                Parse = "WHERE jenis_kelamin = '" + getJenisKelamin() + "'";
            } else if (!getTempatLahir().isEmpty()) {
                Parse = "WHERE tempat_lahir = '" + getTempatLahir() + "'";
            } else if (!getTanggalLahir().isEmpty()) {
                Parse = "WHERE tanggal_lahir = '" + getTanggalLahir() + "'";
            } else if (!getAgama().isEmpty()) {
                Parse = "WHERE agama = '" + getAgama() + "'";
            } else if (!getStatus().isEmpty()) {
                Parse = "WHERE status = '" + getStatus() + "'";
            } else if (!getKontak().isEmpty()) {
                Parse = "WHERE kontak = '" + getKontak() + "'";
            } else if (!getAlamat().isEmpty()) {
                Parse = "WHERE alamat = '" + getAlamat() + "'";
            } else if (!getJabatan().getIdJabatan().isEmpty()) {
                Parse = "WHERE id_jabatan = '" + getJabatan().getIdJabatan() + "'";
            } else {
                Parse = "";
            }
            Query = "SELECT * FROM karyawan " + Parse;
            System.out.println("Query : " + Query);
            Statement Stat = getConn().getConnector().createStatement();
            ResultSet List = Stat.executeQuery(Query);
            if (Parse.isEmpty()) {
                List.last();

                TempRecord = new String[List.getRow()][5];
                List.beforeFirst();
            }
            i = 0;
            while (List.next()) {
                JabatanEntityModel jabatanModel = new JabatanEntityModel(List.getString(7), "", "", "").detailDataSet();
                model.setIdKaryawan(List.getString(1));
                setIdKaryawan(model.getIdKaryawan());
                model.setNamaKaryawan(List.getString(2));
                setNamaKaryawan(model.getNamaKaryawan());
                model.setJenisKelamin(List.getString(3));
                setJenisKelamin(model.getJenisKelamin());
                model.setTempatLahir(List.getString(4));
                setTempatLahir(model.getTempatLahir());
                model.setTanggalLahir(List.getString(5));
                setTanggalLahir(model.getTanggalLahir());
                model.setAgama(List.getString(6));
                setAgama(model.getAgama());
                model.setStatus(List.getString(8));
                setStatus(model.getStatus());
                model.setKontak(List.getString(9));
                setKontak(model.getKontak());
                model.setAlamat(List.getString(10));
                setAlamat(model.getAgama());
                model.getJabatan().setNamaJabatan(jabatanModel.getNamaJabatan());
                getJabatan().setNamaJabatan(model.getJabatan().getNamaJabatan());
                if (Parse.isEmpty()) {
                    TempRecord[i][0] = getIdKaryawan();
                    TempRecord[i][1] = getNamaKaryawan();
                    TempRecord[i][2] = getJenisKelamin();
                    TempRecord[i][3] = getTempatLahir() + ", " + getTanggalLahir();
                    TempRecord[i][4] = jabatanModel.getNamaJabatan();

                }
                i++;

            }
            model.setAllValue(TempRecord);
            setAllValue(model.getAllValue());
            List.close();
            Stat.close();
            return model;
        } catch (Exception Ex) {
            System.out.println("ERROR : KaryawanEntityModel.detailDataSet() " + Ex.getMessage().toString());
            return null;
        }

    }

    @Override
    public boolean addDataValue() {
        String Query1 = null;
        String Query2 = null;
        getConn().Connection();
        if (getIdKaryawan().equals("")) {
            try {
                Query1 = "INSERT INTO karyawan VALUES (NULL, '" + getNamaKaryawan() + "', '"
                        + getJenisKelamin() + "', '" + getTempatLahir() + "', '"
                        + getTanggalLahir() + "', '" + getAgama() + "', '"
                        + getJabatan().getIdJabatan() + "', '" + getStatus() + "', '"
                        + getKontak() + "', '" + getAlamat() + "');";

                Query2 = "INSERT INTO pengguna (id_user) VALUES (NULL);";

                System.out.println(Query1);
                System.out.println(Query2);
                Statement Stat = getConn().getConnector().createStatement();
                Stat.addBatch(Query1);
                Stat.addBatch(Query2);
                Stat.executeBatch();
                Stat.close();
                return true;
            } catch (SQLException Ex) {
                System.out.println("ERROR : KaryawanEntityModel.addDataValue() " + Ex.getMessage().toString());
                return false;
            }
        } else {
            try {
                Query1 = "INSERT INTO karyawan VALUES ('" + getIdKaryawan() + "', '" + getNamaKaryawan() + "', '"
                        + getJenisKelamin() + "', '" + getTempatLahir() + "', '"
                        + getTanggalLahir() + "', '" + getAgama() + "', '"
                        + getJabatan().getIdJabatan() + "', '" + getStatus() + "', '"
                        + getKontak() + "', '" + getAlamat() + "');";

                Query2 = "INSERT INTO pengguna (id_user) VALUES ('" + getIdKaryawan() + "');";

                System.out.println(Query1);
                System.out.println(Query2);
                Statement Stat = getConn().getConnector().createStatement();
                Stat.addBatch(Query1);
                Stat.addBatch(Query2);
                Stat.executeBatch();
                return true;
            } catch (SQLException Ex) {
                System.out.println("ERROR : KaryawanEntityModel.addDataValue() " + Ex.getMessage().toString());
                return false;
            }
        }
    }

    //<editor-fold defaultstate="collapsed" desc="Backup addDataValue">
    /*
     @Override
     public boolean addDataValue(){
     String Query = null;
     getConn().Connection();
     if (getIdKaryawan().equals("")) {
     try {
     Query = "INSERT INTO karyawan VALUES (NULL, '" + getNamaKaryawan()+"', '"
     + getJenisKelamin() + "', '" + getTempatLahir() + "', '"
     + getTanggalLahir() + "', '" + getAgama() + "', '"
     + getJabatan().getIdJabatan() + "', '" + getStatus() + "', '"
     + getKontak() + "', '" + getAlamat() + "');";
     //+ getKontak() + "', '" + getAlamat() + "'); INSERT INTO pengguna (id_user) VALUES (NULL);";
     System.out.println(Query);
     Statement Stat = getConn().getConnector().createStatement();
     Stat.executeUpdate(Query);
     Stat.close();
     return true;
     } catch (SQLException Ex) {
     System.out.println("ERROR : KaryawanEntityModel.addDataValue() " + Ex.getMessage().toString());
     return false;
     }
     } else {
     try {
     Query = "INSERT INTO karyawan VALUES ('"+ getIdKaryawan() + "', '" + getNamaKaryawan()+"', '"
     + getJenisKelamin() + "', '" + getTempatLahir() + "', '"
     + getTanggalLahir() + "', '" + getAgama() + "', '"
     + getJabatan().getIdJabatan() + "', '" + getStatus() + "', '"
     + getKontak() + "', '" + getAlamat() + "');";
     //+ getKontak() + "', '" + getAlamat() + "'); INSERT INTO pengguna (id_user) VALUES ('" + getIdKaryawan() + "');";
     System.out.println(Query);
     Statement Stat = getConn().getConnector().createStatement();
     Stat.executeUpdate(Query);
     Stat.close();
     return true;
     } catch (SQLException Ex) {
     System.out.println("ERROR : KaryawanEntityModel.addDataValue() " + Ex.getMessage().toString());
     return false;
     }
     }
     } */
//</editor-fold>
    
    @Override
    public boolean editDataValue() {
        String Query = null;

        getConn().Connection();
        try {
            Query = "UPDATE karyawan SET nama = '"
                    + getNamaKaryawan() + "', jenis_kelamin = '" + getJenisKelamin() + "', tempat_lahir = '"
                    + getTempatLahir() + "', tanggal_lahir = '" + getTanggalLahir() + "', agama = '"
                    + getAgama() + "', id_jabatan = '" + getJabatan().getIdJabatan() + "', status = '"
                    + getStatus() + "', kontak = '" + getKontak() + "', alamat= '" + getAlamat() + "' "
                    + "WHERE id_user = '" + getIdKaryawan() + "'";
            System.out.println(Query);
            Statement Stat = getConn().getConnector().createStatement();
            Stat.executeUpdate(Query);
            Stat.close();
            return true;
        } catch (SQLException Ex) {
            System.out.println("ERROR : KaryawanEntityModell.editDataValue() " + Ex.getMessage().toString());
            return false;
        }
    }

    @Override
    public boolean subDataValue() {
        String Query = null;
        getConn().Connection();
        try {
            Query = "DELETE FROM karyawan WHERE id_user = '" + getIdKaryawan() + "'";
            System.out.println(Query);
            Statement Stat = getConn().getConnector().createStatement();
            Stat.executeUpdate(Query);
            Stat.close();
            return true;
        } catch (SQLException Ex) {
            System.out.println("ERROR : KaryawanEntityModell.subDataValue() " + Ex.getMessage().toString());
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
            Query = "SELECT id_user FROM karyawan ORDER BY id_user DESC LIMIT 1";
            Statement Stat = getConn().getConnector().createStatement();
            ResultSet List = Stat.executeQuery(Query);
            while (List.next()) {
                Result = List.getString(1).trim();
            }
            List.close();
            Stat.close();
            if (!Result.equals("")) {
                hasil = Integer.parseInt(Result) + 1;
                Result = String.valueOf(hasil);
                if (Result.length() == 1) {
                    Result = "3300" + Result;
                } else if (Result.length() == 2) {
                    Result = "330" + Result;
                } else if (Result.length() == 3) {
                    Result = "33" + Result;
                }
            } else {
                Result = "33001";
            }
            return Result;
        } catch (Throwable Ex) {
            System.out.println("ERROR : KaryawanEntityModell.genIdDataValue() " + Ex.getMessage());
            return "33001";
        }
    }

    public void fillCboStatus(JComboBox Cbo) {
        String Query = null;

        getConn().Connection();
        String Val = null;
        try {
            Query = "SELECT DISTINCT status from karyawan";
            Statement Stat = getConn().getConnector().createStatement();
            ResultSet List = Stat.executeQuery(Query);

            Cbo.removeAllItems();
            Cbo.addItem("Pilih Status");
            Cbo.addItem("Admin");
            Cbo.addItem("User");
            while (List.next()) {
                if(!List.getString(1).equals("Admin") && !List.getString(1).equals("User")){
                    
                Val = List.getString(1);
                Cbo.addItem(Val);
                
                }
            }
            List.close();
            Stat.close();
        } catch (Exception Ex) {
            System.out.println("ERROR : KaryawanEntityModell.fillCboStatus() " + Ex.getMessage());
        }
    }

    public void fillCboJenisKelamin(JComboBox Cbo) {
        String Query = null;

        getConn().Connection();
        String Val = null;
        try {
            Query = "SELECT DISTINCT jenis_kelamin from karyawan";
            Statement Stat = getConn().getConnector().createStatement();
            ResultSet List = Stat.executeQuery(Query);

            Cbo.removeAllItems();
            Cbo.addItem("Pilih Jenis Kelamin");
            Cbo.addItem("Laki-Laki");
            Cbo.addItem("Perempuan");
            while (List.next()) {
                if(!List.getString(1).equals("Laki-Laki") && !List.getString(1).equals("Perempuan")){
                    
                Val = List.getString(1);
                Cbo.addItem(Val);
                
                }
            }
            List.close();
            Stat.close();
        } catch (Exception Ex) {
            System.out.println("ERROR : KaryawanEntityModell.fillCboJenisKelamin() " + Ex.getMessage());
        }
    }

//</editor-fold>
}
