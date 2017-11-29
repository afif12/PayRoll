/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

// <editor-fold defaultstate="collapsed" desc="Import Kelas dan Objek yg diperlukan">

import Controllers.MainMenuController;
import Interface.SettingViewInterface;
import Zazuli.ZazuliCalendar;
import Zazuli.ZazuliCalendarLocal;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
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

public class MainMenu extends JFrame implements SettingViewInterface {

// <editor-fold defaultstate="collapsed" desc="Deklarasi Kelas, Objek, Variabel">
    private Dimension Dim;
    //Jpanel
    private JPanel mainPanel;
    private JPanel CalendarPanel;
    private JPanel movePanel;
    private JPanel leftPanel;
    private JPanel gajiPanel;
    private JPanel settingPanel;
    private HomePanel homePanel; 
    private JabatanPanel jabatanPanel;

    //JTextField
    private JTextField userIdField;
    private JTextField jabatanField;
    private JTextField gajiTotalField;
    private JPasswordField passwordField;
    private JPasswordField passwordBaruField;
    private JPasswordField passwordUlangiField;
    //Jbutton
    private JButton closeBtn;
    private JButton minimizeBtn;
    private JButton logoutBtn;
    private JButton homeBtn;
    private JButton jabatanBtn;
    private JButton settingBtn;
    private JButton gajiBtn;
    private JButton hitungGajiBtn;
    private JButton gantiPasswordBtn;
    //JLabel
    private JLabel bgMainPanel;
    private JLabel bgGajiPanel;
    private JLabel bgSettingPanel;
    private JLabel bgDaftarKaryawan;
    private JLabel bgDaftarJabatan;

    //Another class
    private SimpleDigitalClock DigitalClock;
    private ZazuliCalendar Calendar;
    private ImageIcon image;
    private Font font;
    private static Point point;
    //Variabel
    private LoginMenu loginMenu;

// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="MainMenu Construktor">
    public MainMenu() {

        //<editor-fold defaultstate="collapsed" desc="Instansiasi">
              
        mainPanel = new JPanel();
        CalendarPanel = new JPanel();
        movePanel = new JPanel();
        leftPanel = new JPanel();
        settingPanel = new JPanel();
        gajiPanel = new JPanel();
        jabatanPanel = new JabatanPanel();
        homePanel = new HomePanel();
        
        userIdField = new JTextField() {
            @Override
            public JToolTip createToolTip() {
                JToolTip tip = super.createToolTip();
                tip.setBackground(new Color(144, 223, 228));
                tip.setBorder(null);
                return tip;
            }
        };
        gajiTotalField = new JTextField() {
            @Override
            public JToolTip createToolTip() {
                JToolTip tip = super.createToolTip();
                tip.setBackground(new Color(144, 223, 228));
                tip.setBorder(null);
                return tip;
            }
        };
        jabatanField = new JTextField() {
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
        passwordBaruField = new JPasswordField() {
            @Override
            public JToolTip createToolTip() {
                JToolTip tip = super.createToolTip();
                tip.setBackground(new Color(144, 223, 228));
                tip.setBorder(null);
                return tip;
            }
        };
        passwordUlangiField = new JPasswordField() {
            @Override
            public JToolTip createToolTip() {
                JToolTip tip = super.createToolTip();
                tip.setBackground(new Color(144, 223, 228));
                tip.setBorder(null);
                return tip;
            }
        };
        
        closeBtn = new JButton(){
            @Override
            public JToolTip createToolTip() {
                JToolTip tip = super.createToolTip();
                tip.setBackground(new Color(144, 223, 228));
                tip.setBorder(null);
                return tip;
            }
        };
        minimizeBtn = new JButton(){
            @Override
            public JToolTip createToolTip() {
                JToolTip tip = super.createToolTip();
                tip.setBackground(new Color(144, 223, 228));
                tip.setBorder(null);
                return tip;
            }
        };
        logoutBtn = new JButton(){
            @Override
            public JToolTip createToolTip() {
                JToolTip tip = super.createToolTip();
                tip.setBackground(new Color(144, 223, 228));
                tip.setBorder(null);
                return tip;
            }
        };
        homeBtn = new JButton();
        jabatanBtn = new JButton();
        settingBtn = new JButton();
        gajiBtn = new JButton();
        hitungGajiBtn = new JButton();
        gantiPasswordBtn = new JButton();
        
        bgMainPanel = new JLabel();
        
        bgGajiPanel = new JLabel();
        bgSettingPanel = new JLabel();

        
        
        font = new Font("Calibri", Font.PLAIN, 25);
        point = new Point();
        DigitalClock = new SimpleDigitalClock();
        Calendar = new ZazuliCalendar(ZazuliCalendarLocal.LOCAL_ID);
//</editor-fold>
        
        initComponents();

        setLocationRelativeTo(null); 
 }

    
    public MainMenu(String Judul){
        
        String judul = Judul;
        
        //<editor-fold defaultstate="collapsed" desc="Instansiasi">
        
        mainPanel = new JPanel();
        CalendarPanel = new JPanel();
        movePanel = new JPanel();
        leftPanel = new JPanel();
        settingPanel = new JPanel();
        gajiPanel = new JPanel();
        jabatanPanel = new JabatanPanel();
        homePanel = new HomePanel("HomePanel");
        
        userIdField = new JTextField() {
            @Override
            public JToolTip createToolTip() {
                JToolTip tip = super.createToolTip();
                tip.setBackground(new Color(144, 223, 228));
                tip.setBorder(null);
                return tip;
            }
        };
        gajiTotalField = new JTextField() {
            @Override
            public JToolTip createToolTip() {
                JToolTip tip = super.createToolTip();
                tip.setBackground(new Color(144, 223, 228));
                tip.setBorder(null);
                return tip;
            }
        };
        jabatanField = new JTextField() {
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
        passwordBaruField = new JPasswordField() {
            @Override
            public JToolTip createToolTip() {
                JToolTip tip = super.createToolTip();
                tip.setBackground(new Color(144, 223, 228));
                tip.setBorder(null);
                return tip;
            }
        };
        passwordUlangiField = new JPasswordField() {
            @Override
            public JToolTip createToolTip() {
                JToolTip tip = super.createToolTip();
                tip.setBackground(new Color(144, 223, 228));
                tip.setBorder(null);
                return tip;
            }
        };
        
        closeBtn = new JButton(){
            @Override
            public JToolTip createToolTip() {
                JToolTip tip = super.createToolTip();
                tip.setBackground(new Color(144, 223, 228));
                tip.setBorder(null);
                return tip;
            }
        };
        minimizeBtn = new JButton(){
            @Override
            public JToolTip createToolTip() {
                JToolTip tip = super.createToolTip();
                tip.setBackground(new Color(144, 223, 228));
                tip.setBorder(null);
                return tip;
            }
        };
        logoutBtn = new JButton(){
            @Override
            public JToolTip createToolTip() {
                JToolTip tip = super.createToolTip();
                tip.setBackground(new Color(144, 223, 228));
                tip.setBorder(null);
                return tip;
            }
        };
        homeBtn = new JButton();
        jabatanBtn = new JButton();
        settingBtn = new JButton();
        gajiBtn = new JButton();
        hitungGajiBtn = new JButton();
        gantiPasswordBtn = new JButton();
        
        bgMainPanel = new JLabel();
        
        bgGajiPanel = new JLabel();
        bgSettingPanel = new JLabel();
        
        
        font = new Font("Calibri", Font.PLAIN, 25);
        point = new Point();
        DigitalClock = new SimpleDigitalClock();
        Calendar = new ZazuliCalendar(ZazuliCalendarLocal.LOCAL_ID);
        
        
//</editor-fold>
        
        userInitComponents(judul);
        setLocationRelativeTo(null); 
    }
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="Getter Setter">
//yuli

    public JLabel getBgDaftarKaryawan() {
        return bgDaftarKaryawan;
    }

    public void setBgDaftarKaryawan(JLabel bgDaftarKaryawan) {
        this.bgDaftarKaryawan = bgDaftarKaryawan;
    }

    public JLabel getBgDaftarJabatan() {
        return bgDaftarJabatan;
    }

    public void setBgDaftarJabatan(JLabel bgDaftarJabatan) {
        this.bgDaftarJabatan = bgDaftarJabatan;
    }

    public ZazuliCalendar getCalendar() {
        return Calendar;
    }

    public void setCalendar(ZazuliCalendar Calendar) {
        this.Calendar = Calendar;
    }

    public SimpleDigitalClock getDigitalClock() {
        return DigitalClock;
    }

    public void setDigitalClock(SimpleDigitalClock DigitalClock) {
        this.DigitalClock = DigitalClock;
    }

    public Dimension getDim() {
        return Dim;
    }

    public void setDim(Dimension Dim) {
        this.Dim = Dim;
    }

    public JLabel getBgGajiPanel() {
        return bgGajiPanel;
    }

    public void setBgGajiPanel(JLabel bgGajiPanel) {
        this.bgGajiPanel = bgGajiPanel;
    }


    public JLabel getBgMainPanel() {
        return bgMainPanel;
    }

    public void setBgMainPanel(JLabel bgMainPanel) {
        this.bgMainPanel = bgMainPanel;
    }

    public JLabel getBgSettingPanel() {
        return bgSettingPanel;
    }

    public void setBgSettingPanel(JLabel bgSettingPanel) {
        this.bgSettingPanel = bgSettingPanel;
    }

    public JButton getCloseBtn() {
        return closeBtn;
    }

    public void setCloseBtn(JButton closeBtn) {
        this.closeBtn = closeBtn;
    }

    public JButton getGajiBtn() {
        return gajiBtn;
    }

    public void setGajiBtn(JButton gajiBtn) {
        this.gajiBtn = gajiBtn;
    }

    public JPanel getGajiPanel() {
        return gajiPanel;
    }

    public void setGajiPanel(JPanel gajiPanel) {
        this.gajiPanel = gajiPanel;
    }

    public JTextField getGajiTotalField() {
        return gajiTotalField;
    }

    public void setGajiTotalField(JTextField gajiTotalField) {
        this.gajiTotalField = gajiTotalField;
    }

    public JButton getGantiPasswordBtn() {
        return gantiPasswordBtn;
    }

    public void setGantiPasswordBtn(JButton gantiPasswordBtn) {
        this.gantiPasswordBtn = gantiPasswordBtn;
    }

    public JButton getHitungGajiBtn() {
        return hitungGajiBtn;
    }

    public void setHitungGajiBtn(JButton hitungGajiBtn) {
        this.hitungGajiBtn = hitungGajiBtn;
    }

    public JButton getHomeBtn() {
        return homeBtn;
    }

    public void setHomeBtn(JButton homeBtn) {
        this.homeBtn = homeBtn;
    }

    public HomePanel getHomePanel() {
        return homePanel;
    }

    public void setHomePanel(HomePanel homePanel) {
        this.homePanel = homePanel;
    }

    public ImageIcon getImage() {
        return image;
    }

    public void setImage(ImageIcon image) {
        this.image = image;
    }

    public JButton getJabatanBtn() {
        return jabatanBtn;
    }

    public void setJabatanBtn(JButton jabatanBtn) {
        this.jabatanBtn = jabatanBtn;
    }

    public JTextField getJabatanField() {
        return jabatanField;
    }

    public void setJabatanField(JTextField jabatanField) {
        this.jabatanField = jabatanField;
    }

    public JabatanPanel getJabatanPanel() {
        return jabatanPanel;
    }

    public void setJabatanPanel(JabatanPanel jabatanPanel) {
        this.jabatanPanel = jabatanPanel;
    }

    public JPanel getLeftPanel() {
        return leftPanel;
    }

    public void setLeftPanel(JPanel leftPanel) {
        this.leftPanel = leftPanel;
    }


    public JButton getLogoutBtn() {
        return logoutBtn;
    }

    public void setLogoutBtn(JButton logoutBtn) {
        this.logoutBtn = logoutBtn;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public JButton getMinimizeBtn() {
        return minimizeBtn;
    }

    public void setMinimizeBtn(JButton minimizeBtn) {
        this.minimizeBtn = minimizeBtn;
    }

    public JPanel getMovePanel() {
        return movePanel;
    }

    public void setMovePanel(JPanel movePanel) {
        this.movePanel = movePanel;
    }

    public JPasswordField getPasswordBaruField() {
        return passwordBaruField;
    }

    public void setPasswordBaruField(JPasswordField passwordBaruField) {
        this.passwordBaruField = passwordBaruField;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public void setPasswordField(JPasswordField passwordField) {
        this.passwordField = passwordField;
    }

    public JPasswordField getPasswordUlangiField() {
        return passwordUlangiField;
    }

    public void setPasswordUlangiField(JPasswordField passwordUlangiField) {
        this.passwordUlangiField = passwordUlangiField;
    }


    public static Point getPoint() {
        return point;
    }

    public static void setPoint(Point point) {
        MainMenu.point = point;
    }

    public JButton getSettingBtn() {
        return settingBtn;
    }

    public void setSettingBtn(JButton settingBtn) {
        this.settingBtn = settingBtn;
    }

    public JPanel getSettingPanel() {
        return settingPanel;
    }

    public void setSettingPanel(JPanel settingPanel) {
        this.settingPanel = settingPanel;
    }
    public JTextField getUserIdField() {
        return userIdField;
    }

    public void setUserIdField(JTextField userIdField) {
        this.userIdField = userIdField;
    }

    public LoginMenu getLoginMenu() {
        return loginMenu;
    }

    public void setLoginMenu(LoginMenu loginMenu) {
        this.loginMenu = loginMenu;
    }

    public JPanel getCalendarPanel() {
        return CalendarPanel;
    }



// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="initComponents() Method">
    private void initComponents() {

        this.setTitle("Aplikasi Penggajian Karyawan");
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.setUndecorated(true);
        this.setSize(822, 585);
        this.setResizable(false);
        this.setIconImage(new ImageIcon(getClass().getResource("/Pic/icon.png")).getImage());

        //Jpanel
        //Panel Utama
        getMainPanel().setLayout(null);
        getMainPanel().setOpaque(true);
        getMainPanel().setBackground(Color.gray);
        getMainPanel().setBounds(0, 0, 822, 585);
        this.add(getMainPanel());
        //Panel Geser
        //digunakan untuk menggeser Frame
        getMovePanel().setLayout(null);
        getMovePanel().setOpaque(false);
        getMovePanel().setBackground(Color.white);
        getMovePanel().setBounds(195, 0, 631, 75);
        getMainPanel().add(getMovePanel());
        //Panel sebelah kiri
        getLeftPanel().setLayout(null);
        getLeftPanel().setOpaque(true);
        getLeftPanel().setBackground(new Color(61, 61, 61));
        getLeftPanel().setBounds(0, 0, 193, 585);
        getMainPanel().add(getLeftPanel());
        //Panel untuk getDigitalClock()
        getDigitalClock().setOpaque(true);
        getDigitalClock().setBounds(0, 370, 193, 63);
        getLeftPanel().add(getDigitalClock());
         //Panel untuk Calendar
        getCalendarPanel().setLayout(null);
        getCalendarPanel().setOpaque(true);
        getCalendarPanel().setBackground(new Color(61, 61, 61, 61));
        getCalendarPanel().setBounds(0, 435, 193, 153);
        getLeftPanel().add(getCalendarPanel());
        //Calendar
        getCalendar().setOpaque(true);
        getCalendar().setBounds(0, 0, 193, 153);
        getCalendarPanel().add(getCalendar());
        //Panel untuk tampilan menu utama home
        getHomePanel().setLayout(null);
        getHomePanel().setVisible(true);
        getHomePanel().setOpaque(true);
        getHomePanel().setLocation(193, 75);
        getMainPanel().add(getHomePanel());
        //panel untuk tampilan menu utama jabatan
        getJabatanPanel().setLayout(null);
        getJabatanPanel().setVisible(false);
        getJabatanPanel().setOpaque(true);
        getJabatanPanel().setLocation(193, 75);
        getMainPanel().add(getJabatanPanel());
        //panel untuk tampilan menu utama gaji
        getGajiPanel().setLayout(null);
        getGajiPanel().setVisible(false);
        getGajiPanel().setOpaque(true);
        getGajiPanel().setBackground(new Color(42, 42, 42));
        getGajiPanel().setBounds(193, 75, 630, 458);
        getMainPanel().add(getGajiPanel());
        //panel setting
        getSettingPanel().setLayout(null);
        getSettingPanel().setVisible(false);
        getSettingPanel().setOpaque(true);
        getSettingPanel().setBackground(new Color(42, 42, 42));
        getSettingPanel().setBounds(193, 75, 630, 458);
        getMainPanel().add(getSettingPanel());
        
        //JButton
        //tombol close
        getCloseBtn().setOpaque(true);
        getCloseBtn().setBorder(null);
        getCloseBtn().setBounds(590, 9, 30, 22);
        getCloseBtn().setToolTipText("Keluar");
        getMovePanel().add(getCloseBtn());
        //tombol minimize
        getMinimizeBtn().setOpaque(true);
        getMinimizeBtn().setBorder(null);
        getMinimizeBtn().setToolTipText("Minimize");
        getMinimizeBtn().setBounds(562, 11, 26, 17);
        getMovePanel().add(getMinimizeBtn());
        //tombol logout
        getLogoutBtn().setOpaque(true);
        getLogoutBtn().setBorder(null);
        getLogoutBtn().setToolTipText("Logout");
        getLogoutBtn().setBounds(738, 554, 79, 29); 
        getMainPanel().add(getLogoutBtn());
        //kelompok tombol menu sebelah kiri
        //tombol home menu
        getHomeBtn().setOpaque(true);
        getHomeBtn().setBorder(null);
        getHomeBtn().setBounds(0, 0, 193, 75);
        getLeftPanel().add(getHomeBtn());
        //tombol jabatan menu
        getJabatanBtn().setOpaque(true);
        getJabatanBtn().setBorder(null);
        getJabatanBtn().setBounds(0, 75, 193, 60);
        getLeftPanel().add(getJabatanBtn());
        //tombol gaji
        getGajiBtn().setOpaque(true);
        getGajiBtn().setBorder(null);
        getGajiBtn().setBounds(0, 135, 193, 60);
        getLeftPanel().add(getGajiBtn());
        //tombol setting
        getSettingBtn().setOpaque(true);
        getSettingBtn().setBorder(null);
        getSettingBtn().setBounds(0, 195, 193, 60);
        getLeftPanel().add(getSettingBtn());
        //kelompok tombol isi menu
        //tombol hitung gaji
        getHitungGajiBtn().setOpaque(true);
        getHitungGajiBtn().setBorder(null);
        getHitungGajiBtn().setBounds(417, 191, 197, 141);
        getGajiPanel().add(getHitungGajiBtn());
        //tombol ganti password
        getGantiPasswordBtn().setOpaque(true);
        getGantiPasswordBtn().setBorder(null);
        getGantiPasswordBtn().setBounds(176, 357, 153, 32);
        getSettingPanel().add(getGantiPasswordBtn());

        //Jtextfield
        // textfield getUserIdField()
        getUserIdField().setVisible(true);
        getUserIdField().setOpaque(false);
        getUserIdField().setBorder(null);
        getUserIdField().setBounds(122, 165, 265, 27);
        getUserIdField().setFont(font);
        getUserIdField().setEditable(false);
        getUserIdField().setSelectionColor(new Color(144, 223, 228));
        getUserIdField().setToolTipText("Id Anda");
        getGajiPanel().add(getUserIdField());
        //textfield jabatan
        getJabatanField().setVisible(true);
        getJabatanField().setOpaque(false);
        getJabatanField().setBorder(null);
        getJabatanField().setBounds(122, 232, 265, 27);
        getJabatanField().setFont(font);
        getJabatanField().setEditable(false);
        getJabatanField().setSelectionColor(new Color(144, 223, 228));
        getJabatanField().setToolTipText("Jabatan Anda Saat Ini");
        getGajiPanel().add(getJabatanField());
        //textfield gaji total
        getGajiTotalField().setVisible(true);
        getGajiTotalField().setOpaque(false);
        getGajiTotalField().setBorder(null);
        getGajiTotalField().setBounds(122, 305, 265, 27);
        getGajiTotalField().setFont(font);
        getGajiTotalField().setEditable(false);
        getGajiTotalField().setSelectionColor(new Color(144, 223, 228));
        getGajiTotalField().setToolTipText("Total Gaji Anda");
        getGajiPanel().add(getGajiTotalField());
        //textfield passwordfield
        getPasswordField().setVisible(true);
        getPasswordField().setOpaque(false);
        getPasswordField().setBorder(null);
        getPasswordField().setBounds(181, 142, 264, 27);
        getPasswordField().setFont(font);
        getPasswordField().setSelectionColor(new Color(144, 223, 228));
        getPasswordField().setToolTipText("Masukkan Katasandi Lama Anda");
        getSettingPanel().add(getPasswordField());
        //textfield passwordfield baru
        getPasswordBaruField().setVisible(true);
        getPasswordBaruField().setOpaque(false);
        getPasswordBaruField().setBorder(null);
        getPasswordBaruField().setBounds(181, 222, 264, 27);
        getPasswordBaruField().setFont(font);
        getPasswordBaruField().setSelectionColor(new Color(144, 223, 228));
        getPasswordBaruField().setToolTipText("Masukkan Katasandi Baru Anda");
        getSettingPanel().add(getPasswordBaruField());
        //ulangi passwordfield baru
        getPasswordUlangiField().setVisible(true);
        getPasswordUlangiField().setOpaque(false);
        getPasswordUlangiField().setBorder(null);
        getPasswordUlangiField().setBounds(181, 299, 264, 27);
        getPasswordUlangiField().setFont(font);
        getPasswordUlangiField().setSelectionColor(new Color(144, 223, 228));
        getPasswordUlangiField().setToolTipText("Ulangi Katasandi Baru Anda");
        getSettingPanel().add(getPasswordUlangiField());

        //JLabel
        //bg menu utama
        getBgMainPanel().setOpaque(true);
        getBgMainPanel().setBounds(-3, -3, 830, 590);
        getMainPanel().add(getBgMainPanel());
        //bg menu gaji
        getBgGajiPanel().setOpaque(true);
        getBgGajiPanel().setBounds(0, 0, 630, 458);
        getGajiPanel().add(getBgGajiPanel());
        //bg menu setting
        getBgSettingPanel().setOpaque(true);
        getBgSettingPanel().setBounds(0, 0, 630, 458);
        getSettingPanel().add(getBgSettingPanel());
        //JLabel
        //bg menu utama
        getBgMainPanel().setOpaque(true);
        getBgMainPanel().setBounds(-3, -3, 830, 590);
        getMainPanel().add(getBgMainPanel());
        //bg menu gaji
        getBgGajiPanel().setOpaque(true);
        getBgGajiPanel().setBounds(0, 0, 630, 458);
        getGajiPanel().add(getBgGajiPanel());
        //bg menu setting
        getBgSettingPanel().setOpaque(true);
        getBgSettingPanel().setBounds(0, 0, 630, 458);
        getSettingPanel().add(getBgSettingPanel());        

        imageControl();
        eventControl();

    } // </editor-fold>
    
//<editor-fold defaultstate="collapsed" desc="userInitComponents() Method">
    
    private void userInitComponents(String judul){
        
        this.setTitle(judul);
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.setUndecorated(true);
        this.setSize(822, 585);
        this.setResizable(false);
        this.setIconImage(new ImageIcon(getClass().getResource("/Pic/icon.png")).getImage());

        //Jpanel
        //Panel Utama
        getMainPanel().setLayout(null);
        getMainPanel().setOpaque(true);
        getMainPanel().setBackground(Color.gray);
        getMainPanel().setBounds(0, 0, 822, 585);
        this.add(getMainPanel());
        //Panel Geser
        //digunakan untuk menggeser Frame
        getMovePanel().setLayout(null);
        getMovePanel().setOpaque(false);
        getMovePanel().setBackground(Color.white);
        getMovePanel().setBounds(195, 0, 631, 75);
        getMainPanel().add(getMovePanel());
        //Panel sebelah kiri
        getLeftPanel().setLayout(null);
        getLeftPanel().setOpaque(true);
        getLeftPanel().setBackground(new Color(61, 61, 61));
        getLeftPanel().setBounds(0, 0, 193, 585);
        getMainPanel().add(getLeftPanel());
        //Panel untuk getDigitalClock()
        getDigitalClock().setOpaque(true);
        getDigitalClock().setBounds(0, 370, 193, 63);
        getLeftPanel().add(getDigitalClock());
        //Panel untuk kalender
        getCalendarPanel().setLayout(null);
        getCalendarPanel().setOpaque(true);
        getCalendarPanel().setBackground(new Color(61, 61, 61, 61));
        getCalendarPanel().setBounds(0, 435, 193, 153);
        getLeftPanel().add(getCalendarPanel());
        //Calendar
        getCalendar().setOpaque(true);
        getCalendar().setBounds(0, 0, 193, 153);
        getCalendarPanel().add(getCalendar());
        //Panel untuk tampilan menu utama home
        getHomePanel().setLayout(null);
        getHomePanel().setVisible(true);
        getHomePanel().setOpaque(true);
        getHomePanel().setLocation(193, 75);
        getMainPanel().add(getHomePanel());
        //panel untuk tampilan menu utama jabatan
        getJabatanPanel().setLayout(null);
        getJabatanPanel().setVisible(false);
        getJabatanPanel().setOpaque(true);
        getJabatanPanel().setLocation(193, 75);
        getMainPanel().add(getJabatanPanel());
        //panel untuk tampilan menu utama gaji
        getGajiPanel().setLayout(null);
        getGajiPanel().setVisible(false);
        getGajiPanel().setOpaque(true);
        getGajiPanel().setBackground(new Color(42, 42, 42));
        getGajiPanel().setBounds(193, 75, 630, 458);
        getMainPanel().add(getGajiPanel());
        //panel setting
        getSettingPanel().setLayout(null);
        getSettingPanel().setVisible(false);
        getSettingPanel().setOpaque(true);
        getSettingPanel().setBackground(new Color(42, 42, 42));
        getSettingPanel().setBounds(193, 75, 630, 458);
        getMainPanel().add(getSettingPanel());
        

        //JButton
        //tombol close
        getCloseBtn().setOpaque(true);
        getCloseBtn().setToolTipText("Keluar");
        getCloseBtn().setBorder(null);
        getCloseBtn().setBounds(590, 9, 30, 22);
        getMovePanel().add(getCloseBtn());
        //tombol minimize
        getMinimizeBtn().setOpaque(true);
        getMinimizeBtn().setToolTipText("Minimize");
        getMinimizeBtn().setBorder(null);
        getMinimizeBtn().setBounds(562, 11, 26, 17);
        getMovePanel().add(getMinimizeBtn());
        //tombol logout
        getLogoutBtn().setOpaque(true);
        getLogoutBtn().setToolTipText("Logout");
        getLogoutBtn().setBorder(null);
        getLogoutBtn().setBounds(738, 554, 79, 29); //getLogoutBtn().setBounds(740, 559, 79, 29);
        getMainPanel().add(getLogoutBtn());
        
        //kelompok tombol menu sebelah kiri
        //tombol home menu
        getHomeBtn().setOpaque(true);
        getHomeBtn().setBorder(null);
        getHomeBtn().setBounds(0, 0, 193, 75);
        getLeftPanel().add(getHomeBtn());
        //tombol gaji
        getGajiBtn().setOpaque(true);
        getGajiBtn().setBorder(null);
        getGajiBtn().setBounds(0, 75, 193, 60);
        getLeftPanel().add(getGajiBtn());
        //tombol setting
        getSettingBtn().setOpaque(true);
        getSettingBtn().setBorder(null);
        getSettingBtn().setBounds(0, 135, 193, 60);
        getLeftPanel().add(getSettingBtn());
        //kelompok tombol isi menu
        //tombol hitung gaji
        getHitungGajiBtn().setOpaque(true);
        getHitungGajiBtn().setBorder(null);
        getHitungGajiBtn().setBounds(417, 191, 197, 141);
        getGajiPanel().add(getHitungGajiBtn());
        //tombol ganti password
        getGantiPasswordBtn().setOpaque(true);
        getGantiPasswordBtn().setBorder(null);
        getGantiPasswordBtn().setBounds(176, 357, 153, 32);
        getSettingPanel().add(getGantiPasswordBtn());

        //Jtextfield
        // textfield getUserIdField()
        getUserIdField().setVisible(true);
        getUserIdField().setOpaque(false);
        getUserIdField().setBorder(null);
        getUserIdField().setBounds(122, 165, 265, 27);
        getUserIdField().setFont(font);
        getUserIdField().setEditable(false);
        getUserIdField().setSelectionColor(new Color(144, 223, 228));
        getUserIdField().setToolTipText("Id Anda");
        getGajiPanel().add(getUserIdField());
        //textfield jabatan
        getJabatanField().setVisible(true);
        getJabatanField().setOpaque(false);
        getJabatanField().setBorder(null);
        getJabatanField().setBounds(122, 232, 265, 27);
        getJabatanField().setFont(font);
        getJabatanField().setEditable(false);
        getJabatanField().setSelectionColor(new Color(144, 223, 228));
        getJabatanField().setToolTipText("Jabatan Anda Saat Ini");
        getGajiPanel().add(getJabatanField());
        //textfield gaji total
        getGajiTotalField().setVisible(true);
        getGajiTotalField().setOpaque(false);
        getGajiTotalField().setBorder(null);
        getGajiTotalField().setBounds(122, 305, 265, 27);
        getGajiTotalField().setFont(font);
        getGajiTotalField().setEditable(false);
        getGajiTotalField().setSelectionColor(new Color(144, 223, 228));
        getGajiTotalField().setToolTipText("Total Gaji Anda");
        getGajiPanel().add(getGajiTotalField());
        //textfield passwordfield
        getPasswordField().setVisible(true);
        getPasswordField().setOpaque(false);
        getPasswordField().setBorder(null);
        getPasswordField().setBounds(181, 142, 264, 27);
        getPasswordField().setFont(font);
        getPasswordField().setSelectionColor(new Color(144, 223, 228));
        getPasswordField().setToolTipText("Masukkan Katasandi Lama Anda");
        getSettingPanel().add(getPasswordField());
        //textfield passwordfield baru
        getPasswordBaruField().setVisible(true);
        getPasswordBaruField().setOpaque(false);
        getPasswordBaruField().setBorder(null);
        getPasswordBaruField().setBounds(181, 222, 264, 27);
        getPasswordBaruField().setFont(font);
        getPasswordBaruField().setSelectionColor(new Color(144, 223, 228));
        getPasswordBaruField().setToolTipText("Masukkan Katasandi Baru Anda");
        getSettingPanel().add(getPasswordBaruField());
        //ulangi passwordfield baru
        getPasswordUlangiField().setVisible(true);
        getPasswordUlangiField().setOpaque(false);
        getPasswordUlangiField().setBorder(null);
        getPasswordUlangiField().setBounds(181, 299, 264, 27);
        getPasswordUlangiField().setFont(font);
        getPasswordUlangiField().setSelectionColor(new Color(144, 223, 228));
        getPasswordUlangiField().setToolTipText("Ulangi Katasandi Baru Anda");
        getSettingPanel().add(getPasswordUlangiField());

        //JLabel
        //bg menu utama
        getBgMainPanel().setOpaque(true);
        getBgMainPanel().setBounds(-3, -3, 830, 590);
        getMainPanel().add(getBgMainPanel());
        //bg menu gaji
        getBgGajiPanel().setOpaque(true);
        getBgGajiPanel().setBounds(0, 0, 630, 458);
        getGajiPanel().add(getBgGajiPanel());
        //bg menu setting
        getBgSettingPanel().setOpaque(true);
        getBgSettingPanel().setBounds(0, 0, 630, 458);
        getSettingPanel().add(getBgSettingPanel());

        imageControl();
        eventControl();

    }
//</editor-fold>

// <editor-fold defaultstate="collapsed" desc="Main() Method">
  /*  public static void main(String[] args) {
        MainMenu m = new MainMenu("Aplikasi Pennggajian");
        //MainMenu m = new MainMenu();
        m.setVisible(true);

    } */
    // </editor-fold>

// <editor-fold defaultstate="collapsed" desc="eventControl()& imageControl() Method">
    public void eventControl() {
        MainMenuController ControlPanel = new MainMenuController(this);
        
        getHomePanel().getDataKaryawan().addComponentListener(ControlPanel.componentListener);
        getGajiPanel().addComponentListener(ControlPanel.componentListener);
        this.addComponentListener(ControlPanel.componentListener);
        
        getMovePanel().addMouseListener(ControlPanel.panelPressed);        
        getMovePanel().addMouseMotionListener(ControlPanel.panelDragged);

        getCloseBtn().addActionListener(ControlPanel.buttonActionListener);
        getMinimizeBtn().addActionListener(ControlPanel.buttonActionListener);
        getLogoutBtn().addActionListener(ControlPanel.buttonActionListener);
        getHomeBtn().addActionListener(ControlPanel.buttonActionListener);
        getJabatanBtn().addActionListener(ControlPanel.buttonActionListener);
        getGajiBtn().addActionListener(ControlPanel.buttonActionListener);
        getSettingBtn().addActionListener(ControlPanel.buttonActionListener);
        getGantiPasswordBtn().addActionListener(ControlPanel.buttonActionListener);
        getHitungGajiBtn().addActionListener(ControlPanel.buttonActionListener);
        
        this.addWindowListener(ControlPanel.windowCloseListener);
        
        getPasswordField().addKeyListener(ControlPanel.passListener);
        getPasswordUlangiField().addKeyListener(ControlPanel.passListener);
        getPasswordBaruField().addKeyListener(ControlPanel.passListener);
    }

    public void imageControl() {
        //panel pic
        setImage(new ImageIcon(getClass().getResource("/Pic/Bg.png")));
        getBgMainPanel().setIcon(getImage());
        setImage(new ImageIcon(getClass().getResource("/Pic/WadahGaji.png")));
        getBgGajiPanel().setIcon(getImage());
        setImage(new ImageIcon(getClass().getResource("/Pic/WadahSetting.png")));
        getBgSettingPanel().setIcon(getImage());
        //button pic
        setImage(new ImageIcon(getClass().getResource("/Pic/BtnClose.png")));
        getCloseBtn().setIcon(getImage());
        setImage(new ImageIcon(getClass().getResource("/Pic/BtnClose1.png")));
        getCloseBtn().setRolloverIcon(getImage());
        setImage(new ImageIcon(getClass().getResource("/Pic/BtnClose2.png")));
        getCloseBtn().setPressedIcon(getImage());
        setImage(new ImageIcon(getClass().getResource("/Pic/BtnMinimize.png")));
        getMinimizeBtn().setIcon(getImage());
        setImage(new ImageIcon(getClass().getResource("/Pic/BtnMinimize1.png")));
        getMinimizeBtn().setRolloverIcon(getImage());
        setImage(new ImageIcon(getClass().getResource("/Pic/BtnMinimize2.png")));
        getMinimizeBtn().setPressedIcon(getImage());
        setImage(new ImageIcon(getClass().getResource("/Pic/BtnLogout.png")));
        getLogoutBtn().setIcon(getImage());
        setImage(new ImageIcon(getClass().getResource("/Pic/BtnLogout1.png")));
        getLogoutBtn().setRolloverIcon(getImage());
        setImage(new ImageIcon(getClass().getResource("/Pic/BtnLogout2.png")));
        getLogoutBtn().setPressedIcon(getImage());
        setImage(new ImageIcon(getClass().getResource("/Pic/BtnHome1.png")));
        getHomeBtn().setIcon(getImage());
        setImage(new ImageIcon(getClass().getResource("/Pic/BtnHome1.png")));
        getHomeBtn().setRolloverIcon(getImage());
        setImage(new ImageIcon(getClass().getResource("/Pic/BtnHome1.png")));
        getHomeBtn().setPressedIcon(getImage());
        setImage(new ImageIcon(getClass().getResource("/Pic/BtnJabatan.png")));
        getJabatanBtn().setIcon(getImage());
        setImage(new ImageIcon(getClass().getResource("/Pic/BtnJabatan1.png")));
        getJabatanBtn().setRolloverIcon(getImage());
        setImage(new ImageIcon(getClass().getResource("/Pic/BtnJabatan1.png")));
        getJabatanBtn().setPressedIcon(getImage());
        setImage(new ImageIcon(getClass().getResource("/Pic/BtnGaji.png")));
        getGajiBtn().setIcon(getImage());
        setImage(new ImageIcon(getClass().getResource("/Pic/BtnGaji1.png")));
        getGajiBtn().setRolloverIcon(getImage());
        setImage(new ImageIcon(getClass().getResource("/Pic/BtnGaji1.png")));
        getGajiBtn().setPressedIcon(getImage());
        setImage(new ImageIcon(getClass().getResource("/Pic/BtnSetting.png")));
        getSettingBtn().setIcon(getImage());
        setImage(new ImageIcon(getClass().getResource("/Pic/BtnSetting1.png")));
        getSettingBtn().setRolloverIcon(getImage());
        setImage(new ImageIcon(getClass().getResource("/Pic/BtnSetting1.png")));
        getSettingBtn().setPressedIcon(getImage());
        setImage(new ImageIcon(getClass().getResource("/Pic/BtnHitungGajiHome.png")));
        getHitungGajiBtn().setIcon(getImage());
        setImage(new ImageIcon(getClass().getResource("/Pic/BtnHitungGajiHome1.png")));
        getHitungGajiBtn().setRolloverIcon(getImage());
        setImage(new ImageIcon(getClass().getResource("/Pic/BtnHitungGajiHome2.png")));
        getHitungGajiBtn().setPressedIcon(getImage());
        setImage(new ImageIcon(getClass().getResource("/Pic/BtnGantiKatasandi.png")));
        getGantiPasswordBtn().setIcon(getImage());
        setImage(new ImageIcon(getClass().getResource("/Pic/BtnGantiKatasandi1.png")));
        getGantiPasswordBtn().setRolloverIcon(getImage());
        setImage(new ImageIcon(getClass().getResource("/Pic/BtnGantiKatasandi2.png")));
        getGantiPasswordBtn().setPressedIcon(getImage());

    }
 // </editor-fold>
   
    
}
