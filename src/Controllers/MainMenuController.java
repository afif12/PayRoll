/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

//<editor-fold defaultstate="collapsed" desc="Import">

import Connection.ConnectionDB;
import Models.JabatanEntityModel;
import Models.KaryawanEntityModel;
import Views.MainMenu;
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
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Locale;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
//</editor-fold>

/**
 *
 * @author A F I F
 */
public class MainMenuController {

// <editor-fold defaultstate="collapsed" desc="Deklarasi Kelas, Objek, dan Variabel">
    private MainMenu mainMenuView;
    private Point point;
    private ImageIcon image;

    private ConnectionDB conn;
    private String katasandiDB;
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Constructor">
    public MainMenuController(MainMenu mainMenuView) {
        this.mainMenuView = mainMenuView;
        image = new ImageIcon();
        this.conn = new ConnectionDB();

    }

//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Getter Setter">
  
  public MainMenu getMainMenuView() {
      return mainMenuView;
  }
  
  public void setMainMenuView(MainMenu mainMenuView) {
      this.mainMenuView = mainMenuView;
  }
  
  public Point getPoint() {
      return point;
  }
  
  public void setPoint(Point point) {
      this.point = point;
  }

    public ImageIcon getImage() {
        return image;
    }

    public void setImage(ImageIcon image) {
        this.image = image;
    }


    public ConnectionDB getConn() {
        return conn;
    }

    public void setConn(ConnectionDB conn) {
        this.conn = conn;
    }

    public String getKatasandiDB() {
        return katasandiDB;
    }

    public void setKatasandiDB(String katasandiDB) {
        this.katasandiDB = katasandiDB;
    }
  
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Method Code">
  
      // <editor-fold defaultstate="collapsed" desc="Method Untuk Menggeser Panel Utama">
  public void formMousePressed(MouseEvent Evt) {
      
      getMainMenuView().getPoint().x = Evt.getX();
      getMainMenuView().getPoint().y = Evt.getY();
  }
  
  public void formMouseDragged(MouseEvent Evt) {
      
      Point p = getMainMenuView().getLocation();
      getMainMenuView().setLocation(p.x + Evt.getX() - getMainMenuView().getPoint().x, p.y + Evt.getY() - getMainMenuView().getPoint().y);
  }
  
// </editor-fold>
  
      // <editor-fold defaultstate="collapsed" desc="Method Minimize, Close, dan Logout">
  private void exitWindow(ActionEvent Evt) {
      YesNoDialog ExitDialog = new YesNoDialog();
      ExitDialog.setVisible(true);
      
      if (ExitDialog.getYes()) {
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
  
  
  private void minimizeWindow(ActionEvent Evt) {
      getMainMenuView().setState(ICONIFIED);
  }
  
  private void logoutSession(ActionEvent Evt) {
      YesNoDialog ConfirmationDialog = new YesNoDialog();
      ConfirmationDialog.setImage(new ImageIcon(getClass().getResource("/Pic/bgLogoutDialog.png")));
      ConfirmationDialog.getBgYesNoDialog().setIcon(ConfirmationDialog.getImage());
      ConfirmationDialog.setVisible(true);
      
      if (ConfirmationDialog.getYes()) {
          getMainMenuView().dispose();
          homeBtnPressed();
          getMainMenuView().getHomePanel().getHomePanel().setVisible(true);
          getMainMenuView().getHomePanel().getDaftarKaryawan().setVisible(false);
          getMainMenuView().getHomePanel().getDataKaryawan().setVisible(false);
          getMainMenuView().getJabatanPanel().setVisible(false);
          getMainMenuView().getJabatanPanel().getDaftarJabatan().setVisible(false);
          getMainMenuView().getSettingPanel().setVisible(false);
          getMainMenuView().getGajiPanel().setVisible(false);
          getMainMenuView().getLoginMenu().getUserIDField().setText("");
          getMainMenuView().getLoginMenu().getPasswordField().setText("");

          try {
              getMainMenuView().getLoginMenu().setVisible(true);
          } catch (NullPointerException NPE) {
              JOptionPane.showMessageDialog(null, "Anda Tadi Tidak Login\n"+NPE, "Error", JOptionPane.ERROR_MESSAGE);
              System.exit(0);
          }
      }
  }
  // </editor-fold>
  
      //<editor-fold defaultstate="collapsed" desc="Show Data Karyawan For User">
  private void tampilDataKaryawan(){
      
      KaryawanEntityModel modelTemp = new KaryawanEntityModel();
      modelTemp.fillCboJenisKelamin(getMainMenuView().getHomePanel().getCboJenisKelamin());
      
      if (!getMainMenuView().getLoginMenu().getUserID().isEmpty()) {
          String key = getMainMenuView().getLoginMenu().getUserID();
          KaryawanEntityModel model = new KaryawanEntityModel(key, "", "", "", "", "", "", "", "", "").detailDataSet();
          
          getMainMenuView().getHomePanel().getIdKaryawanField().setText(model.getIdKaryawan());
          getMainMenuView().getHomePanel().getNameField().setText(model.getNamaKaryawan());
          getMainMenuView().getHomePanel().getCboJenisKelamin().setSelectedItem(model.getJenisKelamin());
          getMainMenuView().getHomePanel().getTempatLahirField().setText(model.getTempatLahir());
          getMainMenuView().getHomePanel().getTanggalLahirField().setText(model.getTanggalLahir());
          getMainMenuView().getHomePanel().getAgamaField().setText(model.getAgama());
          getMainMenuView().getHomePanel().getJabatanField().setText(model.getJabatan().getNamaJabatan());
          getMainMenuView().getHomePanel().getKontakField().setText(model.getKontak());
          getMainMenuView().getHomePanel().getStatusField().setText(model.getStatus());
          getMainMenuView().getHomePanel().getAlamatField().setText(model.getAlamat());
      }
  }
  
//</editor-fold>
  
      // <editor-fold defaultstate="collapsed" desc="Method Show Menu Panel">
    public void homePanelShow(ActionEvent Evt) {

        getMainMenuView().getGajiPanel().setVisible(false);
        getMainMenuView().getHomePanel().setVisible(true);
        getMainMenuView().getHomePanel().getDaftarKaryawan().setVisible(false);
        getMainMenuView().getHomePanel().getDataKaryawan().setVisible(false);
        getMainMenuView().getHomePanel().getHomePanel().setVisible(true);
        getMainMenuView().getJabatanPanel().setVisible(false);
        getMainMenuView().getJabatanPanel().getJabatanPanel().setVisible(false);
        getMainMenuView().getJabatanPanel().getDaftarJabatan().setVisible(false);
        getMainMenuView().getSettingPanel().setVisible(false);

    }

    private void jabatanPanelShow(ActionEvent Evt) {
        getMainMenuView().getGajiPanel().setVisible(false);
        getMainMenuView().getJabatanPanel().setVisible(true);
        getMainMenuView().getJabatanPanel().getJabatanPanel().setVisible(true);
        getMainMenuView().getJabatanPanel().getDaftarJabatan().setVisible(false);
        getMainMenuView().getHomePanel().getDataKaryawan().setVisible(false);
        getMainMenuView().getHomePanel().getDaftarKaryawan().setVisible(false);
        getMainMenuView().getHomePanel().setVisible(false);
        getMainMenuView().getHomePanel().getHomePanel().setVisible(false);
        getMainMenuView().getJabatanPanel().getDaftarJabatan().setVisible(false);
        getMainMenuView().getSettingPanel().setVisible(false);
    }

    private void gajiPanelShow(ActionEvent Evt) {

        getMainMenuView().getGajiPanel().setVisible(true);
        getMainMenuView().getJabatanPanel().setVisible(false);
        getMainMenuView().getJabatanPanel().getJabatanPanel().setVisible(false);
        getMainMenuView().getJabatanPanel().getDaftarJabatan().setVisible(false);
        getMainMenuView().getHomePanel().getDataKaryawan().setVisible(false);
        getMainMenuView().getHomePanel().getDaftarKaryawan().setVisible(false);
        getMainMenuView().getHomePanel().setVisible(false);
        getMainMenuView().getHomePanel().getHomePanel().setVisible(false);
        getMainMenuView().getSettingPanel().setVisible(false);

    }

    private void settingPanelShow(ActionEvent Evt) {

        getMainMenuView().getSettingPanel().setVisible(true);
        getMainMenuView().getJabatanPanel().setVisible(false);
        getMainMenuView().getJabatanPanel().getJabatanPanel().setVisible(false);
        getMainMenuView().getJabatanPanel().getDaftarJabatan().setVisible(false);
        getMainMenuView().getHomePanel().getDataKaryawan().setVisible(false);
        getMainMenuView().getHomePanel().getDaftarKaryawan().setVisible(false);
        getMainMenuView().getHomePanel().setVisible(false);
        getMainMenuView().getHomePanel().getHomePanel().setVisible(false);
        getMainMenuView().getGajiPanel().setVisible(false);
    }
    // </editor-fold>
    
      //<editor-fold defaultstate="collapsed" desc="Method Ganti password">
    private void getKatasandi() {
        getConn().Connection();
        try {
            String Query = "SELECT * FROM `pengguna` WHERE id_user = " + getMainMenuView().getLoginMenu().getUserID();
            Statement Stat = getConn().getConnector().createStatement();
            ResultSet Rs = Stat.executeQuery(Query);
            if (Rs.next()) {
                setKatasandiDB(Rs.getString("kata_Sandi"));
            }
        } catch (SQLException z) {
            System.err.println(z.getMessage());
        }

    }
    
    private void gantiPasswordEnterPressed(){
        getKatasandi();
            getConn().Connection();

            try {
                String Query = "UPDATE pengguna SET kata_sandi = '"
                        + getMainMenuView().getPasswordUlangiField().getText()
                        + "' WHERE id_user = '" + getMainMenuView().getLoginMenu().getUserID() + "';";
                System.out.println(Query);
                Statement Stat = getConn().getConnector().createStatement();
                Stat.executeUpdate(Query);
                Stat.close();

                if (getMainMenuView().getPasswordBaruField().getText().equals(getKatasandiDB())) {
                    setImage(new ImageIcon(getClass().getResource("/Pic/bgKatasandiTidakDiubah.png")));
                    OKDialog OK = new OKDialog();
                    OK.getBgOKDialog().setIcon(getImage());
                    OK.setVisible(true);
                    resetPasswordField();
                } else {
                    setImage(new ImageIcon(getClass().getResource("/Pic/bgBerhasilKatasandiDialog.png")));
                    OKDialog OK = new OKDialog();
                    OK.getBgOKDialog().setIcon(getImage());
                    OK.setVisible(true);
                    resetPasswordField();
                }
            } catch (SQLException Ex) {
                System.out.println("ERROR : MainMenuController.gantiPassword() " + Ex.getMessage().toString());
                setImage(new ImageIcon(getClass().getResource("/Pic/bgErrorGagalKatasandiDialog.png")));
                OKDialog OK = new OKDialog();
                OK.getBgOKDialog().setIcon(getImage());
                OK.setVisible(true);
                resetPasswordField();
            }
    }

    private void gantiPassword() {
        if (isValidate()) {
            getKatasandi();
            getConn().Connection();

            try {
                String Query = "UPDATE pengguna SET kata_sandi = '"
                        + getMainMenuView().getPasswordUlangiField().getText()
                        + "' WHERE id_user = '" + getMainMenuView().getLoginMenu().getUserID() + "';";
                System.out.println(Query);
                Statement Stat = getConn().getConnector().createStatement();
                Stat.executeUpdate(Query);
                Stat.close();

                if (getMainMenuView().getPasswordBaruField().getText().equals(getKatasandiDB())) {
                    setImage(new ImageIcon(getClass().getResource("/Pic/bgKatasandiTidakDiubah.png")));
                    OKDialog OK = new OKDialog();
                    OK.getBgOKDialog().setIcon(getImage());
                    OK.setVisible(true);
                    resetPasswordField();
                } else {
                    setImage(new ImageIcon(getClass().getResource("/Pic/bgBerhasilKatasandiDialog.png")));
                    OKDialog OK = new OKDialog();
                    OK.getBgOKDialog().setIcon(getImage());
                    OK.setVisible(true);
                    resetPasswordField();
                }
            } catch (SQLException Ex) {
                System.out.println("ERROR : MainMenuController.gantiPassword() " + Ex.getMessage().toString());
                setImage(new ImageIcon(getClass().getResource("/Pic/bgErrorGagalKatasandiDialog.png")));
                OKDialog OK = new OKDialog();
                OK.getBgOKDialog().setIcon(getImage());
                OK.setVisible(true);
                resetPasswordField();
            }
        }
    }

    private void resetPasswordField() {
        getMainMenuView().getPasswordBaruField().setText("");
        getMainMenuView().getPasswordField().setText("");
        getMainMenuView().getPasswordField().requestFocus();
        getMainMenuView().getPasswordUlangiField().setText("");
    }

    private boolean isValidate() {
        boolean flag;
        getKatasandi();
        if (getMainMenuView().getPasswordField().getText().matches("")) {
            setImage(new ImageIcon(getClass().getResource("/Pic/bgMasukkanKatasandiDialog.png")));
            OKDialog OK = new OKDialog();
            OK.getBgOKDialog().setIcon(getImage());
            OK.setVisible(true);
            getMainMenuView().getPasswordField().requestFocus();
            flag = false;
        } else if (!getMainMenuView().getPasswordField().getText().equals(getKatasandiDB())) {
            setImage(new ImageIcon(getClass().getResource("/Pic/bgKatasandiSalah.png")));
            OKDialog OK = new OKDialog();
            OK.getBgOKDialog().setIcon(getImage());
            OK.setVisible(true);
            getMainMenuView().getPasswordField().requestFocus();
            flag = false;
        } else if (getMainMenuView().getPasswordBaruField().getText().matches("")) {
            setImage(new ImageIcon(getClass().getResource("/Pic/bgMasukkanKatasandiBaru.png")));
            OKDialog OK = new OKDialog();
            OK.getBgOKDialog().setIcon(getImage());
            OK.setVisible(true);
            getMainMenuView().getPasswordBaruField().requestFocus();
            flag = false;
        } else if (getMainMenuView().getPasswordUlangiField().getText().matches("")) {
            setImage(new ImageIcon(getClass().getResource("/Pic/bgUlangiKatasandi.png")));
            OKDialog OK = new OKDialog();
            OK.getBgOKDialog().setIcon(getImage());
            OK.setVisible(true);
            getMainMenuView().getPasswordUlangiField().requestFocus();
            flag = false;
        } else if (!getMainMenuView().getPasswordUlangiField().getText().equals(getMainMenuView().getPasswordBaruField().getText())) {
            setImage(new ImageIcon(getClass().getResource("/Pic/bgKatasandiBaruTdkCocok.png")));
            OKDialog OK = new OKDialog();
            OK.getBgOKDialog().setIcon(getImage());
            OK.setVisible(true);
            getMainMenuView().getPasswordUlangiField().requestFocus();
            flag = false;
        } else {
            flag = true;
        }
        return flag;
    }

    //<editor-fold defaultstate="collapsed" desc="PassValidate">
    private void passValidate() {
        getKatasandi();
        if (getMainMenuView().getPasswordField().getText().matches("")) {
            setImage(new ImageIcon(getClass().getResource("/Pic/bgMasukkanKatasandiDialog.png")));
            OKDialog OK = new OKDialog();
            OK.getBgOKDialog().setIcon(getImage());
            OK.setVisible(true);

            getMainMenuView().getPasswordField().requestFocus();

        } else if (!getMainMenuView().getPasswordField().getText().equals(getKatasandiDB())) {
            setImage(new ImageIcon(getClass().getResource("/Pic/bgKatasandiSalah.png")));
            OKDialog OK = new OKDialog();
            OK.getBgOKDialog().setIcon(getImage());
            OK.setVisible(true);

            getMainMenuView().getPasswordField().requestFocus();

        } else {
            getMainMenuView().getPasswordBaruField().requestFocus();
        }
    }

    private void passBaruValidate() {
        getKatasandi();
        if (getMainMenuView().getPasswordField().getText().matches("")) {
            setImage(new ImageIcon(getClass().getResource("/Pic/bgMasukkanKatasandiDialog.png")));
            OKDialog OK = new OKDialog();
            OK.getBgOKDialog().setIcon(getImage());
            OK.setVisible(true);

            getMainMenuView().getPasswordField().requestFocus();

        } else if (!getMainMenuView().getPasswordField().getText().equals(getKatasandiDB())) {
            setImage(new ImageIcon(getClass().getResource("/Pic/bgKatasandiSalah.png")));
            OKDialog OK = new OKDialog();
            OK.getBgOKDialog().setIcon(getImage());
            OK.setVisible(true);

            getMainMenuView().getPasswordField().requestFocus();

        } else if (getMainMenuView().getPasswordBaruField().getText().matches("")) {
            setImage(new ImageIcon(getClass().getResource("/Pic/bgMasukkanKatasandiBaru.png")));
            OKDialog OK = new OKDialog();
            OK.getBgOKDialog().setIcon(getImage());
            OK.setVisible(true);
            getMainMenuView().getPasswordBaruField().requestFocus();
        } else {
            getMainMenuView().getPasswordUlangiField().requestFocus();
        }
    }

    private void passUlangiValidate() {
        getKatasandi();
        if (getMainMenuView().getPasswordField().getText().matches("")) {
            setImage(new ImageIcon(getClass().getResource("/Pic/bgMasukkanKatasandiDialog.png")));
            OKDialog OK = new OKDialog();
            OK.getBgOKDialog().setIcon(getImage());
            OK.setVisible(true);

            getMainMenuView().getPasswordField().requestFocus();

        } else if (!getMainMenuView().getPasswordField().getText().equals(getKatasandiDB())) {
            setImage(new ImageIcon(getClass().getResource("/Pic/bgKatasandiSalah.png")));
            OKDialog OK = new OKDialog();
            OK.getBgOKDialog().setIcon(getImage());
            OK.setVisible(true);

            getMainMenuView().getPasswordField().requestFocus();

        } else if (getMainMenuView().getPasswordBaruField().getText().matches("")) {
            setImage(new ImageIcon(getClass().getResource("/Pic/bgMasukkanKatasandiBaru.png")));
            OKDialog OK = new OKDialog();
            OK.getBgOKDialog().setIcon(getImage());
            OK.setVisible(true);
            getMainMenuView().getPasswordBaruField().requestFocus();
            
        }  else if (getMainMenuView().getPasswordUlangiField().getText().matches("")) {
            setImage(new ImageIcon(getClass().getResource("/Pic/bgUlangiKatasandi.png")));
            OKDialog OK = new OKDialog();
            OK.getBgOKDialog().setIcon(getImage());
            OK.setVisible(true);
            getMainMenuView().getPasswordUlangiField().requestFocus();
        } else if (!getMainMenuView().getPasswordUlangiField().getText().equals(getMainMenuView().getPasswordBaruField().getText())) {
            setImage(new ImageIcon(getClass().getResource("/Pic/bgKatasandiBaruTdkCocok.png")));
            OKDialog OK = new OKDialog();
            OK.getBgOKDialog().setIcon(getImage());
            OK.setVisible(true);
            getMainMenuView().getPasswordUlangiField().requestFocus();
        } else {
            gantiPasswordEnterPressed();
        }
    }
//</editor-fold>

//</editor-fold>

      //<editor-fold defaultstate="collapsed" desc="Method ShowGaji">
    private void showGaji(){
        KaryawanEntityModel model = new KaryawanEntityModel(getMainMenuView().getLoginMenu().getUserID(), "", "", "", "", "", "", "", "", "").detailDataSet();
        JabatanEntityModel model1 = new JabatanEntityModel("", model.getJabatan().getNamaJabatan(), "", "").detailDataSet();
        
        NumberFormat fmt = NumberFormat.getCurrencyInstance(new Locale("in"));
        String Gaji = String.valueOf(fmt.format(Double.valueOf(model1.getGajiPokok())));
        
        getMainMenuView().getUserIdField().setText(model.getIdKaryawan());
        getMainMenuView().getJabatanField().setText(model.getJabatan().getNamaJabatan());
        getMainMenuView().getGajiTotalField().setText("Rp. " + Gaji.substring(1));
    }
//</editor-fold>
  
      // <editor-fold defaultstate="collapsed" desc="Methode Effect When Menu Button Pressed">
  private void homeBtnPressed() {
      getMainMenuView().setImage(new ImageIcon(getClass().getResource("/Pic/BtnHome1.png")));
      getMainMenuView().getHomeBtn().setIcon(getMainMenuView().getImage());
      getMainMenuView().setImage(new ImageIcon(getClass().getResource("/Pic/BtnJabatan.png")));
      getMainMenuView().getJabatanBtn().setIcon(getMainMenuView().getImage());
      getMainMenuView().setImage(new ImageIcon(getClass().getResource("/Pic/BtnGaji.png")));
      getMainMenuView().getGajiBtn().setIcon(getMainMenuView().getImage());
      getMainMenuView().setImage(new ImageIcon(getClass().getResource("/Pic/BtnSetting.png")));
      getMainMenuView().getSettingBtn().setIcon(getMainMenuView().getImage());
  }
  
  private void jabatanBtnPressed() {
      getMainMenuView().setImage(new ImageIcon(getClass().getResource("/Pic/BtnHome.png")));
      getMainMenuView().getHomeBtn().setIcon(getMainMenuView().getImage());
      getMainMenuView().setImage(new ImageIcon(getClass().getResource("/Pic/BtnJabatan1.png")));
      getMainMenuView().getJabatanBtn().setIcon(getMainMenuView().getImage());
      getMainMenuView().setImage(new ImageIcon(getClass().getResource("/Pic/BtnGaji.png")));
      getMainMenuView().getGajiBtn().setIcon(getMainMenuView().getImage());
      getMainMenuView().setImage(new ImageIcon(getClass().getResource("/Pic/BtnSetting.png")));
      getMainMenuView().getSettingBtn().setIcon(getMainMenuView().getImage());
  }
  
  private void gajiBtnPressed() {
      getMainMenuView().setImage(new ImageIcon(getClass().getResource("/Pic/BtnHome.png")));
      getMainMenuView().getHomeBtn().setIcon(getMainMenuView().getImage());
      getMainMenuView().setImage(new ImageIcon(getClass().getResource("/Pic/BtnJabatan.png")));
      getMainMenuView().getJabatanBtn().setIcon(getMainMenuView().getImage());
      getMainMenuView().setImage(new ImageIcon(getClass().getResource("/Pic/BtnGaji1.png")));
      getMainMenuView().getGajiBtn().setIcon(getMainMenuView().getImage());
      getMainMenuView().setImage(new ImageIcon(getClass().getResource("/Pic/BtnSetting.png")));
      getMainMenuView().getSettingBtn().setIcon(getMainMenuView().getImage());
  }
  
  private void settingBtnPressed() {
      getMainMenuView().setImage(new ImageIcon(getClass().getResource("/Pic/BtnHome.png")));
      getMainMenuView().getHomeBtn().setIcon(getMainMenuView().getImage());
      getMainMenuView().setImage(new ImageIcon(getClass().getResource("/Pic/BtnJabatan.png")));
      getMainMenuView().getJabatanBtn().setIcon(getMainMenuView().getImage());
      getMainMenuView().setImage(new ImageIcon(getClass().getResource("/Pic/BtnGaji.png")));
      getMainMenuView().getGajiBtn().setIcon(getMainMenuView().getImage());
      getMainMenuView().setImage(new ImageIcon(getClass().getResource("/Pic/BtnSetting1.png")));
      getMainMenuView().getSettingBtn().setIcon(getMainMenuView().getImage());
  }
  // </editor-fold>

//</editor-fold>
 
//<editor-fold defaultstate="collapsed" desc="Annonymous Code">
    public ComponentListener componentListener = new ComponentAdapter() {

        @Override
        public void componentShown(ComponentEvent Evt) {

            if (Evt.getComponent().equals(getMainMenuView().getHomePanel().getDataKaryawan())) {
                tampilDataKaryawan();
            } else if (Evt.getComponent().equals(getMainMenuView())) {
                KaryawanEntityModel model = new KaryawanEntityModel(getMainMenuView().getLoginMenu().getUserID(), "", "", "", "", "", "", "", "", "").detailDataSet();
                JabatanEntityModel model1 = new JabatanEntityModel("", model.getJabatan().getNamaJabatan(), "", "").detailDataSet();

                getMainMenuView().getHomePanel().getUpdateKaryawanDialog().setLoginAs(
                        getMainMenuView().getLoginMenu().getUserID());
                getMainMenuView().getJabatanPanel().getUpdateJabatanDialog().setLoginJabatanAs(model1.getIdJabatan());
                getMainMenuView().getHomePanel().setVisible(true);
            }
        }

        public void componentHidden(ComponentEvent Evt) {
            if (Evt.getComponent().equals(getMainMenuView().getGajiPanel())) {
                getMainMenuView().getGajiTotalField().setText("");
                getMainMenuView().getJabatanField().setText("");
                getMainMenuView().getUserIdField().setText("");
            }

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
            if (Evt.getSource().equals(getMainMenuView().getMinimizeBtn())) {
                minimizeWindow(Evt);
            } else if (Evt.getSource().equals(getMainMenuView().getCloseBtn())) {
                exitWindow(Evt);
            } else if (Evt.getSource().equals(getMainMenuView().getLogoutBtn())) {
                logoutSession(Evt);
            }else if (Evt.getSource().equals(getMainMenuView().getHomeBtn())) {
                homePanelShow(Evt);
                homeBtnPressed();
            }else if (Evt.getSource().equals(getMainMenuView().getJabatanBtn())) {
                jabatanPanelShow(Evt);
                jabatanBtnPressed();
            }else if (Evt.getSource().equals(getMainMenuView().getGajiBtn())) {
                gajiPanelShow(Evt);
                gajiBtnPressed();
            }else if (Evt.getSource().equals(getMainMenuView().getSettingBtn())) {
                settingPanelShow(Evt);
                settingBtnPressed();
                resetPasswordField();
            }else if (Evt.getSource().equals(getMainMenuView().getGantiPasswordBtn())) {
                gantiPassword();
            }else if (Evt.getSource().equals(getMainMenuView().getHitungGajiBtn())) {
                showGaji();
            }
        }
    };
    
    public WindowAdapter windowCloseListener = new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent Evt){
            exitWindow(Evt);
        }
    };

    public KeyListener passListener = new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent Evt) {
            if (Evt.getSource().equals(getMainMenuView().getPasswordField())) {
                if (Evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    passValidate();
                }
            } else if (Evt.getSource().equals(getMainMenuView().getPasswordBaruField())) {
                if (Evt.getKeyCode() == KeyEvent.VK_ENTER) {
                   // passValidate();
                    passBaruValidate();
                }
            } else if (Evt.getSource().equals(getMainMenuView().getPasswordUlangiField())) {
                if (Evt.getKeyCode() == KeyEvent.VK_ENTER) {
                   // passValidate();
                   // passBaruValidate();
                    passUlangiValidate();
                }
            }

        }
    };
    
//</editor-fold>

}
