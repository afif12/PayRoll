/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

// <editor-fold defaultstate="collapsed" desc="Import Kelas dan Objeck yg diperlukan">
import Connection.ConnectionDB;
import Views.LoginMenu;
import Views.OKDialog;
import Views.YesNoDialog;
import static java.awt.Frame.ICONIFIED;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
//</editor-fold>

/**
 *
 * @author A F I F
 */

public class LoginMenuController {

// <editor-fold defaultstate="collapsed" desc="Deklarasi Kelas, Objek, dan Variabel">
    private LoginMenu loginMenuView;
    private ConnectionDB conn;
    private Point point;
    boolean masuk;
    String QuerySandi;
    String QueryStatus;
    Statement Stat;
    ResultSet Rs;
    String status;
    private ImageIcon image;
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Constructor">
    public LoginMenuController(LoginMenu loginMenuView) {
        this.loginMenuView = loginMenuView;
        this.conn = new ConnectionDB();
        image = new ImageIcon();
    }
//</editor-fold>
    
//<editor-fold defaultstate="collapsed" desc="Getter Setter">
    public LoginMenu getLoginMenuView() {
        return loginMenuView;
    }

    public void setLoginMenuView(LoginMenu loginMenuView) {
        this.loginMenuView = loginMenuView;
    }
    
    public ConnectionDB getConn() {
        return conn;
    }

    public void setConn(ConnectionDB conn) {
        this.conn = conn;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ImageIcon getImage() {
        return image;
    }

    public void setImage(ImageIcon image) {
        this.image = image;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }


//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Method Code">
// <editor-fold defaultstate="collapsed" desc="Method Untuk Menggeser Panel Login">
    public void formMousePressed(MouseEvent Evt) {

        getLoginMenuView().getPoint().x = Evt.getX();
        getLoginMenuView().getPoint().y = Evt.getY();
    }

    public void formMouseDragged(MouseEvent Evt) {

        Point p = getLoginMenuView().getLocation();
        getLoginMenuView().setLocation(p.x + Evt.getX() - getLoginMenuView().getPoint().x, p.y + Evt.getY() - getLoginMenuView().getPoint().y);
    }

// </editor-fold>
    
// <editor-fold defaultstate="collapsed" desc="Method Minimize, dan Close">
    private void minimizeWindow(ActionEvent Evt) {
        getLoginMenuView().setState(ICONIFIED);
    }

    private void exitWindow(ActionEvent Evt) {

        YesNoDialog ex = new YesNoDialog();
        ex.setVisible(true);

        if (ex.getYes()) {
            System.exit(0);
        }

    }

    private void exitWindow(WindowEvent Evt) {
       
        YesNoDialog ex = new YesNoDialog();
        ex.setVisible(true);

        if (ex.getYes()) {
            System.exit(0);
        }

  }

    // </editor-fold>
    
//<editor-fold defaultstate="collapsed" desc="Method UserID & Password Field When Enter Is Pressed">
    private void userIDFieldPressed(KeyEvent Evt) {
        if (Evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (getLoginMenuView().getUserIDField().getText().matches("")) {
                setImage(new ImageIcon(getClass().getResource("/Pic/bgMasukkanIDDialog.png")));
                OKDialog OK = new OKDialog();
                OK.getBgOKDialog().setIcon(getImage());
                OK.setVisible(true);

                getLoginMenuView().getUserIDField().requestFocus();
            } else {
                getLoginMenuView().getPasswordField().requestFocus();
            }
        }

    }

    private void passwordFieldPressed(KeyEvent Evt) {
        if (Evt.getKeyCode() == 10) {
            loginSession(Evt);
        }
    }
//</editor-fold>

// <editor-fold defaultstate="collapsed" desc="Method Login">
    private void loginSession(ActionEvent Evt) {
        login();
    }

    private void loginSession(KeyEvent Evt) {
        login();

    }

    private void login() {
        if (isValidate()) {

            getLoginMenuView().setUserID(getLoginMenuView().getUserIDField().getText());
            getLoginMenuView().setPass(getLoginMenuView().getPasswordField().getText());

            getConn().Connection();
            try {
                QuerySandi = "SELECT * FROM  `pengguna` WHERE id_user ='"
                        + getLoginMenuView().getUserID() + "' AND kata_sandi ='"
                        + getLoginMenuView().getPass() + "'";

                Stat = getConn().getConnector().createStatement();
                Rs = Stat.executeQuery(QuerySandi);
                masuk = Rs.last();

                if (masuk) {

                    if (cekStatus().equals("Admin")) {
                        try {
                            getLoginMenuView().dispose();
                            getLoginMenuView().getMainMenuAdmin().setVisible(true);
                            
                        } catch (NullPointerException NPE) {
                            JOptionPane.showMessageDialog(getLoginMenuView(), "Buka Aplikasi dari kelas main\n" + NPE, "Error", JOptionPane.ERROR_MESSAGE);
                            System.exit(0);
                        }
                    } else if (cekStatus().equals("User")) {
                        try {
                            getLoginMenuView().dispose();
                            getLoginMenuView().getMainMenuUser().setVisible(true);
                           
                        } catch (NullPointerException NPE) {
                            JOptionPane.showMessageDialog(getLoginMenuView(), "Buka Aplikasi dari kelas main\n" + NPE, "Error", JOptionPane.ERROR_MESSAGE);
                            System.exit(0);
                        }
                    }
                } else {
                    setImage(new ImageIcon(getClass().getResource("/Pic/bgErrorKatasandi.png")));
                    OKDialog OK = new OKDialog();
                    OK.getBgOKDialog().setIcon(getImage());
                    OK.setVisible(true);
                    kosongkanField();
                }

            } catch (SQLException x) {
                System.err.println("Error");
                setImage(new ImageIcon(getClass().getResource("/Pic/bgErrorDialog.png")));
                OKDialog OK = new OKDialog();
                OK.getBgOKDialog().setIcon(getImage());
                OK.setVisible(true);
                kosongkanField();
            } catch (NullPointerException z) {
                setImage(new ImageIcon(getClass().getResource("/Pic/bgErrorKatasandi.png")));
                OKDialog OK = new OKDialog();
                OK.getBgOKDialog().setIcon(getImage());
                OK.setVisible(true);
                kosongkanField();
            }
        }
    }

    private String cekStatus() {

        getConn().Connection();
        try {
            QueryStatus = "SELECT * FROM `karyawan` WHERE id_user = " + getLoginMenuView().getUserIDField().getText();
            Stat = getConn().getConnector().createStatement();
            Rs = Stat.executeQuery(QueryStatus);
            if (Rs.next()) {
                setStatus(Rs.getString("status"));
            }
           // System.out.println(getStatus());
            //getConn().getConnector().close();

            return getStatus();

        } catch (SQLException z) {
            System.err.println(z.getMessage());
            return null;
        }
    }
    
    private boolean isValidate(){
        
        boolean flag;
        if (getLoginMenuView().getUserIDField().getText().matches("")) {
            setImage(new ImageIcon(getClass().getResource("/Pic/bgMasukkanIDDialog.png")));
            OKDialog OK =new OKDialog();
            OK.getBgOKDialog().setIcon(getImage());
            OK.setVisible(true); 

            getLoginMenuView().getUserIDField().requestFocus();
            flag = false;
        } else if (getLoginMenuView().getPasswordField().getText().matches("")) {
            setImage(new ImageIcon(getClass().getResource("/Pic/bgMasukkanKatasandiDialog.png")));
            OKDialog OK =new OKDialog();
            OK.getBgOKDialog().setIcon(getImage());
            OK.setVisible(true); 

            getLoginMenuView().getPasswordField().requestFocus();
            flag = false;
        } else {
            flag = true;
        }

        return flag;
    }
    
    private void kosongkanField(){
        getLoginMenuView().getUserIDField().setText("");
        getLoginMenuView().getUserIDField().requestFocus();
        getLoginMenuView().getPasswordField().setText("");
    }
// </editor-fold>
//</editor-fold>
    
//<editor-fold defaultstate="collapsed" desc="Annonymous Code">

     public WindowAdapter windowCloseListener = new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent Evt){
            exitWindow(Evt);
        }
    };
    
    public MouseAdapter panelPressed = new MouseAdapter() {

        @Override
        public void mousePressed(MouseEvent Evt) {
            formMousePressed(Evt);

        }

    };

    public MouseMotionAdapter panelDragged = new MouseMotionAdapter() {
        @Override
        public void mouseDragged(MouseEvent Evt) {
            formMouseDragged(Evt);

        }

    };

    public ActionListener buttonActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent Evt) {
            if (Evt.getSource().equals(getLoginMenuView().getMinimizeBtn())) {
                minimizeWindow(Evt);
            } else if (Evt.getSource().equals(getLoginMenuView().getExitBtn())) {
                //getLoginMenuView().setAlwaysOnTop(false);
                exitWindow(Evt);
            } else if (Evt.getSource().equals(getLoginMenuView().getLoginBtn())) {
                loginSession(Evt);
            }

        }
    };

    public KeyListener textFieldKeyPressed = new KeyAdapter() {
       
        @Override
        public void keyPressed(KeyEvent Evt) {
            if (Evt.getSource().equals(getLoginMenuView().getUserIDField())) {
                userIDFieldPressed(Evt);
            } else if (Evt.getSource().equals(getLoginMenuView().getPasswordField())) {
                passwordFieldPressed(Evt);
            }
        }

    };

    public ComponentListener componentListener = new ComponentAdapter() {
        @Override
        public void componentShown(ComponentEvent Evt) {
            getLoginMenuView().getUserIDField().requestFocus();
        }
    };
//</editor-fold>

}
