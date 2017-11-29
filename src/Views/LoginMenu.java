/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

// <editor-fold defaultstate="collapsed" desc="Import Kelas dan Objeck yg diperlukan">
import Controllers.LoginMenuController;
import Interface.SettingViewInterface;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JToolTip;
// </editor-fold>

/**
 *
 * @author A F I F
 */

public class LoginMenu extends JFrame implements SettingViewInterface {

// <editor-fold defaultstate="collapsed" desc="Deklarasi Kelas, Objek, dan Variabel">
    private Dimension Dim;
    private JPanel mainPanel;
    private JPanel movePanel;
    private JTextField userIDField;
    private JPasswordField passwordField;
    private JButton loginBtn;
    private JButton exitBtn;
    private JButton minimizeBtn;
    private JLabel bgMainPanel;
    private JLabel bgloginBtnWhite;
    private JLabel bgloginBtnBlue;
    private JLabel bgexitBtnWhite;
    private JLabel bgexitBtnBlue;
    private ImageIcon image;
    private Font font;
    private static Point point;

    private boolean Admin;
    private boolean User;
    private String UserID;
    private String Pass;
    
    private MainMenu mainMenuAdmin;
    private MainMenu mainMenuUser;

    // </editor-fold>

// <editor-fold defaultstate="collapsed" desc="Contructor">
    public LoginMenu() {
        
        //<editor-fold defaultstate="collapsed" desc="Insatansiasi">
        mainPanel = new JPanel();
        movePanel = new JPanel();
        userIDField = new JTextField() {
            @Override
            public JToolTip createToolTip() {
                JToolTip tip = super.createToolTip();
                tip.setBackground(new Color(144, 223, 228));
                tip.setBorder(null);
                return tip;
            }
        };
        passwordField = new JPasswordField() {
            @Override
            public JToolTip createToolTip() {
                JToolTip tip = super.createToolTip();
                tip.setBackground(new Color(144, 223, 228));
                tip.setBorder(null);
                return tip;
            }
        };
        loginBtn = new JButton();
        exitBtn = new JButton();
        minimizeBtn = new JButton();
        bgMainPanel = new JLabel();
        bgloginBtnWhite = new JLabel();
        bgloginBtnBlue = new JLabel();
        bgexitBtnWhite = new JLabel();
        bgexitBtnBlue = new JLabel();
        font = new Font("Calibri", Font.PLAIN, 25);
        point = new Point();

//</editor-fold>

        initComponents();
        
        Dim = Toolkit.getDefaultToolkit().getScreenSize();   //opsi kedua
        setLocation((Dim.width / 2) - (getSize().width / 2), //opsi kedua
                (Dim.height / 2) - (getSize().height / 2));  //opsi kedua

    }// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="Getter Setter">
    public String getPass() {
        return Pass;
    }

    public void setPass(String Pass) {
        this.Pass = Pass;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String UserID) {
        this.UserID = UserID;
    }

    public JTextField getUserIDField() {
        return userIDField;
    }

    public void setUserIDField(JTextField userIDField) {
        this.userIDField = userIDField;
    }


    public Dimension getDim() {
        return Dim;
    }

    public void setDim(Dimension Dim) {
        this.Dim = Dim;
    }

    public JLabel getBgMainPanel() {
        return bgMainPanel;
    }

    public void setBgMainPanel(JLabel bgMainPanel) {
        this.bgMainPanel = bgMainPanel;
    }

    public JLabel getBgexitBtnBlue() {
        return bgexitBtnBlue;
    }

    public void setBgexitBtnBlue(JLabel bgexitBtnBlue) {
        this.bgexitBtnBlue = bgexitBtnBlue;
    }

    public JLabel getBgexitBtnWhite() {
        return bgexitBtnWhite;
    }

    public void setBgexitBtnWhite(JLabel bgexitBtnWhite) {
        this.bgexitBtnWhite = bgexitBtnWhite;
    }

    public JLabel getBgloginBtnBlue() {
        return bgloginBtnBlue;
    }

    public void setBgloginBtnBlue(JLabel bgloginBtnBlue) {
        this.bgloginBtnBlue = bgloginBtnBlue;
    }

    public JLabel getBgloginBtnWhite() {
        return bgloginBtnWhite;
    }

    public void setBgloginBtnWhite(JLabel bgloginBtnWhite) {
        this.bgloginBtnWhite = bgloginBtnWhite;
    }

    public JButton getExitBtn() {
        return exitBtn;
    }

    public void setExitBtn(JButton exitBtn) {
        this.exitBtn = exitBtn;
    }

    public ImageIcon getImage() {
        return image;
    }

    public void setImage(ImageIcon image) {
        this.image = image;
    }

    public JButton getLoginBtn() {
        return loginBtn;
    }

    public void setLoginBtn(JButton loginBtn) {
        this.loginBtn = loginBtn;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public JPanel getMovePanel() {
        return movePanel;
    }

    public void setMovePanel(JPanel movePanel) {
        this.movePanel = movePanel;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public void setPasswordField(JPasswordField passwordField) {
        this.passwordField = passwordField;
    }

    public static Point getPoint() {
        return point;
    }

    public static void setPoint(Point point) {
        LoginMenu.point = point;
    }

    public JTextField getUsername() {
        return userIDField;
    }

    public void setUsername(JTextField userIDField) {
        this.userIDField = userIDField;
    }

    public JButton getMinimizeBtn() {
        return minimizeBtn;
    }

    public void setMinimizeBtn(JButton minimizeBtn) {
        this.minimizeBtn = minimizeBtn;
    }

    public MainMenu getMainMenuAdmin() {
        return mainMenuAdmin;
    }

    public void setMainMenuAdmin(MainMenu mainMenuAdmin) {
        this.mainMenuAdmin = mainMenuAdmin;
    }

    public boolean isAdmin() {
        return Admin;
    }

    public void setAdmin(boolean Admin) {
        this.Admin = Admin;
    }

    public boolean IsUser() {
        return User;
    }

    public void setUser(boolean User) {
        this.User = User;
    }

    public MainMenu getMainMenuUser() {
        return mainMenuUser;
    }

    public void setMainMenuUser(MainMenu mainMenuUser) {
        this.mainMenuUser = mainMenuUser;
    }

    // </editor-fold>

// <editor-fold defaultstate="collapsed" desc="initComponets() Method">
    private void initComponents() {

        this.setTitle("Aplikasi Penggajian Karyawan");
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.setAlwaysOnTop(true);
        this.setUndecorated(true);
        this.setSize(822, 585);
        this.setIconImage(new ImageIcon(getClass().getResource("/Pic/icon.png")).getImage());
        this.add(getMainPanel());

        //Jpanel
        //Panel Utama
        getMainPanel().setLayout(null);
        getMainPanel().setOpaque(false);
        getMainPanel().setBackground(Color.blue);
        getMainPanel().setBounds(0, 0, 822, 585);

        //Panel Geser
        //digunakan untuk menggeser Frame
        getMovePanel().setLayout(null);
        getMovePanel().setOpaque(false);
        getMovePanel().setBackground(Color.pink);
        getMovePanel().setBounds(0, 0, 823, 68);
        getMainPanel().add(getMovePanel());

        //Jtextfield
        //kolom userIDField
        getUserIDField().setVisible(true);
        getUserIDField().setOpaque(false);
     
        getUserIDField().setBounds(318, 258, 230, 34);
        getUserIDField().setFont(font);
        getUserIDField().setBorder(null);
        getUserIDField().setBackground(new Color(240, 240, 240));
        getUserIDField().setSelectionColor(new Color(144, 223, 228));
        getUserIDField().setToolTipText("Masukkan ID Anda Disini");
        getMainPanel().add(getUserIDField());
        //kolom passwordField
        getPasswordField().setVisible(true);
        getPasswordField().setOpaque(false);
        getPasswordField().setBounds(318, 307, 230, 34);
        getPasswordField().setFont(font);
        getPasswordField().setBorder(null);
        getPasswordField().setBackground(new Color(240, 240, 240));
        getPasswordField().setSelectionColor(new Color(144, 223, 228));
        getPasswordField().setToolTipText("Masukkan Katasandi Anda Disini");
        getMainPanel().add(getPasswordField());

        //JButton
        //tombol login
        getLoginBtn().setOpaque(true);
        getLoginBtn().setRequestFocusEnabled(true);
        getLoginBtn().setBounds(449, 358, 102, 32);
        getLoginBtn().setBorder(null);
        getLoginBtn().setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getMainPanel().add(getLoginBtn());
        //tombol minimize
        getMinimizeBtn().setOpaque(true);
        getMinimizeBtn().setBounds(755, 11, 26, 17);
        getMinimizeBtn().setBorder(null);
        getMovePanel().add(getMinimizeBtn());
        //tombol exit
        getExitBtn().setOpaque(false);
        getExitBtn().setBounds(783, 9, 30, 22);
        getExitBtn().setBorder(null);
        getMovePanel().add(getExitBtn());

        //JLabel
        //gambar menu utama
        getBgMainPanel().setOpaque(true);
        getBgMainPanel().setBounds(-3, -3, 830, 590);
        getMainPanel().add(getBgMainPanel());

        imageControl();
        eventControl();

    }// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="Main() Method">
 /* public static void main(String[] args) {
     LoginMenu m = new LoginMenu();
     m.setVisible(true);
     } */
    // </editor-fold>

// <editor-fold defaultstate="collapsed" desc="eventControl()& imageControl() Method">
    public void eventControl() {
        LoginMenuController ControlPanel = new LoginMenuController(this);      
        
        getMovePanel().addMouseListener(ControlPanel.panelPressed);
        getMovePanel().addMouseMotionListener(ControlPanel.panelDragged);
        
        getMinimizeBtn().addActionListener(ControlPanel.buttonActionListener);
        getExitBtn().addActionListener(ControlPanel.buttonActionListener);
        getLoginBtn().addActionListener(ControlPanel.buttonActionListener);
        this.addComponentListener(ControlPanel.componentListener);
        getUserIDField().addKeyListener(ControlPanel.textFieldKeyPressed);
        getPasswordField().addKeyListener(ControlPanel.textFieldKeyPressed);
        
        this.addWindowListener(ControlPanel.windowCloseListener);
    }

    public void imageControl() {
        setImage(new ImageIcon(getClass().getResource("/Pic/bgLoginMenu.png")));
        getBgMainPanel().setIcon(getImage());
        setImage(new ImageIcon(getClass().getResource("/Pic/btnLogin.png")));
        getLoginBtn().setIcon(getImage());
        setImage(new ImageIcon(getClass().getResource("/Pic/btnLogin1.png")));
        getLoginBtn().setRolloverIcon(getImage());
        setImage(new ImageIcon(getClass().getResource("/Pic/btnLogin2.png")));
        getLoginBtn().setPressedIcon(getImage());
        setImage(new ImageIcon(getClass().getResource("/Pic/BtnCloseLogin.png")));
        getExitBtn().setIcon(getImage());
        setImage(new ImageIcon(getClass().getResource("/Pic/BtnCloseLogin1.png")));
        getExitBtn().setRolloverIcon(getImage());
        setImage(new ImageIcon(getClass().getResource("/Pic/BtnCloseLogin2.png")));
        getExitBtn().setPressedIcon(getImage());
        setImage(new ImageIcon(getClass().getResource("/Pic/BtnMinimizeLogin.png")));
        getMinimizeBtn().setIcon(getImage());
        setImage(new ImageIcon(getClass().getResource("/Pic/BtnMinimizeLogin1.png")));
        getMinimizeBtn().setRolloverIcon(getImage());
        setImage(new ImageIcon(getClass().getResource("/Pic/BtnMinimizeLogin2.png")));
        getMinimizeBtn().setPressedIcon(getImage());
    }// </editor-fold>

}
