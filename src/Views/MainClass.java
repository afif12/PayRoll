/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

//<editor-fold defaultstate="collapsed" desc="Import">
import Connection.ConnectionDB;
import javax.swing.ImageIcon;
//</editor-fold>

/**
 *
 * @author A F I F
 */

public class MainClass {
    
//<editor-fold defaultstate="collapsed" desc="Deklarasi Kelas, Objek, Variabel"">
    private  int statusKoneksi;
    private  LoginMenu loginMenu;
    private  MainMenu mainMenuAdmin;
    private  MainMenu mainMenuUser;
    private  ConnectionDB Conn;
    private  OKDialog okDialog;
    private ImageIcon image;
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Getter Setter">
    public int getStatusKoneksi() {
        return statusKoneksi;
    }

    public void setStatusKoneksi(int statusKoneksi) {
        this.statusKoneksi = statusKoneksi;
    }

    public LoginMenu getLoginMenu() {
        return loginMenu;
    }

    public void setLoginMenu(LoginMenu loginMenu) {
        this.loginMenu = loginMenu;
    }

    public MainMenu getMainMenuAdmin() {
        return mainMenuAdmin;
    }

    public void setMainMenuAdmin(MainMenu mainMenuAdmin) {
        this.mainMenuAdmin = mainMenuAdmin;
    }

    public MainMenu getMainMenuUser() {
        return mainMenuUser;
    }

    public void setMainMenuUser(MainMenu mainMenuUser) {
        this.mainMenuUser = mainMenuUser;
    }

    public ConnectionDB getConn() {
        return Conn;
    }

    public void setConn(ConnectionDB Conn) {
        this.Conn = Conn;
    }

    public OKDialog getOkDialog() {
        return okDialog;
    }

    public void setOkDialog(OKDialog okDialog) {
        this.okDialog = okDialog;
    }

    public ImageIcon getImage() {
        return image;
    }

    public void setImage(ImageIcon image) {
        this.image = image;
    }

//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Contructor">
    public MainClass() {
        
        okDialog = new OKDialog();
        loginMenu = new LoginMenu();
        mainMenuAdmin = new MainMenu();
        mainMenuUser = new MainMenu("Aplikasi Penggajian Karyawan");
        Conn = new ConnectionDB();
        
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Method Code">
    public void runApp() {
        
        getLoginMenu().setMainMenuAdmin(getMainMenuAdmin());
        getLoginMenu().setMainMenuUser(getMainMenuUser());
        getMainMenuAdmin().setLoginMenu(getLoginMenu());
        getMainMenuUser().setLoginMenu(getLoginMenu());
        
        if (getConn().Connection(getStatusKoneksi()) == 1) {
            
            getLoginMenu().setVisible(true);
            
        } else if (getConn().Connection(getStatusKoneksi()) == 2) {
            
            setImage(new ImageIcon(getClass().getResource("/Pic/bgErrorDatabaseDialog.png")));
            getOkDialog().getBgOKDialog().setIcon(getImage());
            getOkDialog().setVisible(true);
            
            System.exit(0);
            
        } else if (getConn().Connection(getStatusKoneksi()) == 3) {
            
            setImage(new ImageIcon(getClass().getResource("/Pic/bgErrorDriverDialog.png")));
            getOkDialog().getBgOKDialog().setIcon(getImage());
            getOkDialog().setVisible(true);
            
            System.exit(0);
        }
    }
    
//</editor-fold>


}
