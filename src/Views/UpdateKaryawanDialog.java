/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

//<editor-fold defaultstate="collapsed" desc="Import">
import Controllers.UpdateKaryawanDialogController;
import Interface.SettingViewInterface;
import Zazuli.ZazuliCalendarDateTime;
import Zazuli.ZazuliCalendarLocal;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Point;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JToolTip;
import javax.swing.table.DefaultTableModel;
//</editor-fold>

/**
 *
 * @author A F I F
 */
public class UpdateKaryawanDialog extends JDialog implements SettingViewInterface {

//<editor-fold defaultstate="collapsed" desc="Deklarasi Kelas, Objek, dan Variabel">
    //JPanel
    private JPanel UpdateKaryawanPanel;
    private JPanel movePanel;
    //JLabel
    private JLabel bgMainPanel;
    //JTable & ScrollPane
    private JTable tableKaryawan;
    private JScrollPane tableScroll;
    //JButton
    private JButton backBtn;
    private JButton saveBtn;
    private JButton deleteBtn;
    private JButton resetBtn;
    private JButton addBtn;
    private JButton getDateBtn;
    //JTextField
    private JTextField idKaryawanField;
    private JTextField nameField;
    
    private JComboBox CboJenisKelamin;
    private JComboBox CboJabatan;
    private JComboBox CboStatus;

    private JTextField tempatLahirField;
    private JTextField tanggalLahirField;
    private JTextField agamaField;

    private JTextField kontakField;
    private JTextPane alamatField;
    private JScrollPane alamatScroll;

    private ImageIcon image;
    private Point point;
    private boolean isBackBtn;
    
    private Font font;
    
    private String selectedValue;
    private String loginAs;
    private ZazuliCalendarDateTime calendar;
    

//</editor-fold>
    
//<editor-fold defaultstate="collapsed" desc="Construktor">
    public UpdateKaryawanDialog(){
        super((Frame)null, "Perbarui Data Karyawan", true);
        
        //<editor-fold defaultstate="collapsed" desc="Instansiasi">
        
        UpdateKaryawanPanel = new JPanel();
        movePanel = new JPanel();
        bgMainPanel = new JLabel(){
            public boolean isCellEditable(int rowIndex, int vColIndex) {
                return false;
            }
        };
        
        backBtn = new JButton(){
            @Override
            public JToolTip createToolTip() {
                JToolTip tip = super.createToolTip();
                tip.setBackground(new Color(144, 223, 228));
                tip.setBorder(null);
                return tip;
            }
        };
        saveBtn = new JButton(){
            @Override
            public JToolTip createToolTip() {
                JToolTip tip = super.createToolTip();
                tip.setBackground(new Color(144, 223, 228));
                tip.setBorder(null);
                return tip;
            }
        };
        addBtn = new JButton(){
            @Override
            public JToolTip createToolTip() {
                JToolTip tip = super.createToolTip();
                tip.setBackground(new Color(144, 223, 228));
                tip.setBorder(null);
                return tip;
            }
        };
        deleteBtn = new JButton(){
            @Override
            public JToolTip createToolTip() {
                JToolTip tip = super.createToolTip();
                tip.setBackground(new Color(144, 223, 228));
                tip.setBorder(null);
                return tip;
            }
        };
        resetBtn = new JButton(){
            @Override
            public JToolTip createToolTip() {
                JToolTip tip = super.createToolTip();
                tip.setBackground(new Color(144, 223, 228));
                tip.setBorder(null);
                return tip;
            }
        };
        getDateBtn = new JButton(){
            @Override
            public JToolTip createToolTip() {
                JToolTip tip = super.createToolTip();
                tip.setBackground(new Color(144, 223, 228));
                tip.setBorder(null);
                return tip;
            }
        };
        
        image = new ImageIcon();
        point = new Point();
        font = new Font("Calibri", Font.PLAIN, 16);
        
        tableKaryawan = new JTable(){
            public boolean isCellEditable(int rowIndex, int vColIndex) {
                return false;
            }
        };
        tableScroll = new JScrollPane();
        
        idKaryawanField = new JTextField(){
            @Override
            public JToolTip createToolTip() {
                JToolTip tip = super.createToolTip();
                tip.setBackground(new Color(144, 223, 228));
                tip.setBorder(null);
                return tip;
            }
        };
        nameField = new JTextField(){
            @Override
            public JToolTip createToolTip() {
                JToolTip tip = super.createToolTip();
                tip.setBackground(new Color(144, 223, 228));
                tip.setBorder(null);
                return tip;
            }
        };
        agamaField = new JTextField(){
            @Override
            public JToolTip createToolTip() {
                JToolTip tip = super.createToolTip();
                tip.setBackground(new Color(144, 223, 228));
                tip.setBorder(null);
                return tip;
            }
        };
        kontakField = new JTextField(){
            @Override
            public JToolTip createToolTip() {
                JToolTip tip = super.createToolTip();
                tip.setBackground(new Color(144, 223, 228));
                tip.setBorder(null);
                return tip;
            }
        };
        tempatLahirField = new JTextField(){
            @Override
            public JToolTip createToolTip() {
                JToolTip tip = super.createToolTip();
                tip.setBackground(new Color(144, 223, 228));
                tip.setBorder(null);
                return tip;
            }
        };
        tanggalLahirField = new JTextField(){
            @Override
            public JToolTip createToolTip() {
                JToolTip tip = super.createToolTip();
                tip.setBackground(new Color(144, 223, 228));
                tip.setBorder(null);
                return tip;
            }
        };
        String jkString[] = {"Laki-Laki", "Perempuan"};
        CboJenisKelamin = new JComboBox(jkString){
            @Override
            public JToolTip createToolTip() {
                JToolTip tip = super.createToolTip();
                tip.setBackground(new Color(144, 223, 228));
                tip.setBorder(null);
                return tip;
            }
        };
        CboJabatan = new JComboBox(){
            @Override
            public JToolTip createToolTip() {
                JToolTip tip = super.createToolTip();
                tip.setBackground(new Color(144, 223, 228));
                tip.setBorder(null);
                return tip;
            }
        };
        String statusString[] = {"Admin","User"};
        CboStatus = new JComboBox(statusString){
            @Override
            public JToolTip createToolTip() {
                JToolTip tip = super.createToolTip();
                tip.setBackground(new Color(144, 223, 228));
                tip.setBorder(null);
                return tip;
            }
        };
        
        
        alamatField = new JTextPane(){
            @Override
            public JToolTip createToolTip() {
                JToolTip tip = super.createToolTip();
                tip.setBackground(new Color(144, 223, 228));
                tip.setBorder(null);
                return tip;
            }
        };
        alamatScroll = new JScrollPane();
        
        calendar = new ZazuliCalendarDateTime(ZazuliCalendarLocal.LOCAL_ID);
        
//</editor-fold>

        setLocationRelativeTo(null);
        
        initComponents();
        
    }

//</editor-fold>
    
//<editor-fold defaultstate="collapsed" desc="Getter Setter">

    public JButton getGetDateBtn() {
        return getDateBtn;
    }

    public void setGetDateBtn(JButton getDateBtn) {
        this.getDateBtn = getDateBtn;
    }

    public JComboBox getCboJenisKelamin() {
        return CboJenisKelamin;
    }

    public void setCboJenisKelamin(JComboBox CboJenisKelamin) {
        this.CboJenisKelamin = CboJenisKelamin;
    }

    public JComboBox getCboJabatan() {
        return CboJabatan;
    }

    public void setCboJabatan(JComboBox CboJabatan) {
        this.CboJabatan = CboJabatan;
    }

    public JComboBox getCboStatus() {
        return CboStatus;
    }

    public void setCboStatus(JComboBox CboStatus) {
        this.CboStatus = CboStatus;
    }
  
    public JTextField getIdKaryawanField() {
        return idKaryawanField;
    }

    public void setIdKaryawanField(JTextField idKaryawanField) {
        this.idKaryawanField = idKaryawanField;
    }

    public JTextField getNameField() {
        return nameField;
    }

    public void setNameField(JTextField nameField) {
        this.nameField = nameField;
    }

    public JTextField getAgamaField() {
        return agamaField;
    }

    public void setAgamaField(JTextField agamaField) {
        this.agamaField = agamaField;
    }

    public JTextField getKontakField() {
        return kontakField;
    }

    public void setKontakField(JTextField kontakField) {
        this.kontakField = kontakField;
    }

    public JTextPane getAlamatField() {
        return alamatField;
    }

    public void setAlamatField(JTextPane alamatField) {
        this.alamatField = alamatField;
    }

    public JScrollPane getTableScroll() {
        return tableScroll;
    }

    public void setTableScroll(JScrollPane tableScroll) {
        this.tableScroll = tableScroll;
    }

    
  public boolean getIsBackBtn() {
        return isBackBtn;
    }

    public void setIsBackBtn(boolean isBackBtn) {
        this.isBackBtn = isBackBtn;
    }

    public JTable getTableKaryawan() {
        return tableKaryawan;
    }

    public void setTable(JTable tableKaryawan) {
        this.tableKaryawan = tableKaryawan;
    }

    public JPanel getUpdateKaryawanPanel() {
        return UpdateKaryawanPanel;
    }
    
    public void setUpdateKaryawanPanel(JPanel UpdateKaryawanPanel) {
        this.UpdateKaryawanPanel = UpdateKaryawanPanel;
    }
    
    public JPanel getMovePanel() {
        return movePanel;
    }
    
    public void setMovePanel(JPanel movePanel) {
        this.movePanel = movePanel;
    }
    
    public JLabel getBgMainPanel() {
        return bgMainPanel;
    }
    
    public void setBgMainPanel(JLabel bgMainPanel) {
        this.bgMainPanel = bgMainPanel;
    }
    
    public JButton getBackBtn() {
        return backBtn;
    }
    
    public void setBackBtn(JButton backBtn) {
        this.backBtn = backBtn;
    }
    
    public JButton getSaveBtn() {
        return saveBtn;
    }
    
    public void setSaveBtn(JButton saveBtn) {
        this.saveBtn = saveBtn;
    }
    
    public JButton getAddBtn() {
        return addBtn;
    }
    
    public void setAddBtn(JButton addBtn) {
        this.addBtn = addBtn;
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

    public JButton getDeleteBtn() {
        return deleteBtn;
    }

    public void setDeleteBtn(JButton deleteBtn) {
        this.deleteBtn = deleteBtn;
    }

    public JButton getResetBtn() {
        return resetBtn;
    }

    public void setResetBtn(JButton resetBtn) {
        this.resetBtn = resetBtn;
    }

    public JTextField getTempatLahirField() {
        return tempatLahirField;
    }

    public void setTempatLahirField(JTextField tempatLahirField) {
        this.tempatLahirField = tempatLahirField;
    }

    public JTextField getTanggalLahirField() {
        return tanggalLahirField;
    }

    public void setTanggalLahirField(JTextField tanggalLahirField) {
        this.tanggalLahirField = tanggalLahirField;
    }

    public JScrollPane getAlamatScroll() {
        return alamatScroll;
    }

    public void setAlamatScroll(JScrollPane alamatScroll) {
        this.alamatScroll = alamatScroll;
    }

    public String getSelectedValue() {
        return selectedValue;
    }

    public void setSelectedValue(String selectedValue) {
        this.selectedValue = selectedValue;
    }

    public ZazuliCalendarDateTime getCalendar() {
        return calendar;
    }

    public void setCalendar(ZazuliCalendarDateTime calendar) {
        this.calendar = calendar;
    }

    public String getLoginAs() {
        return loginAs;
    }

    public void setLoginAs(String loginAs) {
        this.loginAs = loginAs;
    }
    
    
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="initComponents() Method">
    private void initComponents(){
        this.setSize(800,511);
        this.setLocationRelativeTo(null);
        this.setUndecorated(true);
        this.add(getUpdateKaryawanPanel());
        
        //JPanel
        //mainPanel
        getUpdateKaryawanPanel().setLayout(null);
        getUpdateKaryawanPanel().setOpaque(false);
        getUpdateKaryawanPanel().setBounds(0,0,800,511);
        
        //movepanel
        getMovePanel().setLayout(null);
        getMovePanel().setOpaque(false);
        getMovePanel().setBounds(0,0, 800, 45);
        getUpdateKaryawanPanel().add(getMovePanel());
        
        //JTable
        //tabel karyawan
        
        getTableKaryawan().setModel(new DefaultTableModel(
                new Object [][]{
                
                },
                new String[]{
                    "Id Karyawan", "Nama", "Jenis Kelamin", "Tempat Tanggal Lahir", "Jabatan"
                }
        ));
        getTableKaryawan().setBorder(null);
        getTableKaryawan().setShowGrid(false);
        getTableKaryawan().setSelectionForeground(Color.black);
        getTableKaryawan().setSelectionBackground(new Color(162, 250, 255));
        getTableKaryawan().getTableHeader().setReorderingAllowed(false);
        //scroll table
        getTableScroll().setViewportView(getTableKaryawan());
        getTableScroll().setBounds(5,200,791,225);
        getUpdateKaryawanPanel().add(getTableScroll());
        
        //JTextField
        //id
        getIdKaryawanField().setVisible(true);
        getIdKaryawanField().setBorder(null);
        getIdKaryawanField().setEditable(false);
        getIdKaryawanField().setOpaque(false);
        getIdKaryawanField().setBounds(123,55,201,21);
        getIdKaryawanField().setFont(font);
        getIdKaryawanField().setSelectionColor(new Color(144, 223, 228));
        getIdKaryawanField().setToolTipText("ID Karyawan");
        getUpdateKaryawanPanel().add(getIdKaryawanField());
        //name
        getNameField().setVisible(true);
        getNameField().setBorder(null);
        getNameField().setOpaque(false);
        getNameField().setBounds(123,79,201,21);
        getNameField().setFont(font);
        getNameField().setSelectionColor(new Color(144, 223, 228));
        getNameField().setToolTipText("Masukkan Nama");
        getUpdateKaryawanPanel().add(getNameField());
        //Combobox JK
        getCboJenisKelamin().setVisible(true);
        getCboJenisKelamin().setOpaque(true);
        getCboJenisKelamin().setBorder(null);
        getCboJenisKelamin().setFont(font);
        getCboJenisKelamin().setBounds(121, 102, 205, 21);
        getCboJenisKelamin().setToolTipText("Pilih Jenis Kelamin");
        getUpdateKaryawanPanel().add(getCboJenisKelamin());

        //Tempat lahir
        getTempatLahirField().setVisible(true);
        getTempatLahirField().setBorder(null);
        getTempatLahirField().setOpaque(false);
        getTempatLahirField().setBounds(123,127,201,21);
        getTempatLahirField().setFont(font);
        getTempatLahirField().setSelectionColor(new Color(144, 223, 228));
        getTempatLahirField().setToolTipText("Masukkan Kota Lahir");
        getUpdateKaryawanPanel().add(getTempatLahirField());
        //Tanggal Lahir
        getTanggalLahirField().setVisible(true);
        getTanggalLahirField().setBorder(null);
        getTanggalLahirField().setOpaque(false);
        getTanggalLahirField().setBounds(123,151,127,21);
        getTanggalLahirField().setFont(font);
        getTanggalLahirField().setSelectionColor(new Color(144, 223, 228));
        getTanggalLahirField().setToolTipText("Masukkan Tanggal Lahir");
        getUpdateKaryawanPanel().add(getTanggalLahirField());
        //getDate
        getCalendar().setBorder(null);
        getCalendar().setVisible(true);getCalendar().setBounds(121,174,130,22);
        getCalendar().setFormat("dd-mm-yyyy");
        getCalendar().setEditable(true);
        getCalendar().setFontDate(font);
        getUpdateKaryawanPanel().add(getCalendar());
        //agama
        getAgamaField().setVisible(true);
        getAgamaField().setBorder(null);
        getAgamaField().setOpaque(false);
        getAgamaField().setBounds(579,55, 214, 21);
        getAgamaField().setFont(font);
        getAgamaField().setSelectionColor(new Color(144, 223, 228));
        getAgamaField().setToolTipText("Masukkan Agama");
        getUpdateKaryawanPanel().add(getAgamaField());
        //Jabatan
        //combobox
        getCboJabatan().setVisible(true);
        getCboJabatan().setBorder(null);
        getCboJabatan().setOpaque(false);
        getCboJabatan().setFont(font);
        getCboJabatan().setBounds(578, 78, 217, 21);
        getCboJabatan().setToolTipText("Pilih Jabatan");
        getUpdateKaryawanPanel().add(getCboJabatan());
        
        //ComboBox Status
        getCboStatus().setVisible(true);
        getCboStatus().setBorder(null);
        getCboStatus().setOpaque(false);
        getCboStatus().setFont(font);
        getCboStatus().setBounds(578, 102, 217, 21);
        getCboStatus().setToolTipText("Pilih Status Karyawan");
        getUpdateKaryawanPanel().add(getCboStatus());
        
        //kontak
        getKontakField().setVisible(true);
        getKontakField().setBorder(null);
        getKontakField().setOpaque(false);
        getKontakField().setBounds(579, 126, 214, 21);
        getKontakField().setFont(font);
        getKontakField().setSelectionColor(new Color(144, 223, 228));
        getKontakField().setToolTipText("Masukkan Kontak");
        getUpdateKaryawanPanel().add(getKontakField());
        
        //alamatPane & Scroll
        getAlamatField().setVisible(true);
        getAlamatField().setBorder(null);
        getAlamatField().setOpaque(false);
        getAlamatField().setSelectionColor(new Color(144, 223, 228));
        getAlamatField().setFont(font);
        getAlamatField().setToolTipText("Masukkan Alamat");
        //Scrollpane
        getAlamatScroll().setBorder(null);
        getAlamatScroll().setSize(215, 45);
        getAlamatScroll().setHorizontalScrollBarPolicy(31);
        getAlamatScroll().setWheelScrollingEnabled(true);
        getAlamatScroll().setViewportView(getAlamatField());
        getAlamatScroll().setBounds(579, 150, 216, 45);
        getUpdateKaryawanPanel().add(getAlamatScroll());
        
        //JButton
        //tombol getDateBtn
        getGetDateBtn().setOpaque(true);
        getGetDateBtn().setBorder(null);
        getGetDateBtn().setVisible(true);
        getGetDateBtn().setToolTipText("Ambil Tanggal");
        getGetDateBtn().setBounds(267,150,60,21);
        getUpdateKaryawanPanel().add(getGetDateBtn());
        //tombol back        
        getBackBtn().setOpaque(true);
        getBackBtn().setBorder(null);
        getBackBtn().setVisible(true);
        getBackBtn().setToolTipText("Kembali ke Menu Sebelumnya");
        getBackBtn().setBounds(3, 431, 194, 73);
        getUpdateKaryawanPanel().add(getBackBtn());
        //tombol update
        getSaveBtn().setOpaque(true);
        getSaveBtn().setBorder(null);
        getSaveBtn().setVisible(true);
        getSaveBtn().setEnabled(false);
        getSaveBtn().setToolTipText("Simpan Data");
        getSaveBtn().setBounds(403, 431, 194, 73);
        getUpdateKaryawanPanel().add(getSaveBtn());
        //tombol delete
        getDeleteBtn().setOpaque(true);
        getDeleteBtn().setBorder(null);
        getDeleteBtn().setVisible(true);
        getDeleteBtn().setEnabled(false);
        getDeleteBtn().setToolTipText("Hapus Data");
        getDeleteBtn().setBounds(203, 431, 194, 73);
        getUpdateKaryawanPanel().add(getDeleteBtn());
        //tombol tambah
        getAddBtn().setOpaque(true);
        getAddBtn().setBorder(null);
        getAddBtn().setVisible(true);
        getAddBtn().setToolTipText("Tambah data");
        getAddBtn().setBounds(603, 431, 194, 73);
        getUpdateKaryawanPanel().add(getAddBtn());
        //reset Btn 
        getResetBtn().setOpaque(true);
        getResetBtn().setBorder(null);
        getResetBtn().setVisible(false);
        getResetBtn().setToolTipText("Kosongkan Field");
        getResetBtn().setBounds(603, 431, 194, 73);
        getUpdateKaryawanPanel().add(getResetBtn());
        
        //Jlabel
        //Gambar Background untuk main panel
        getBgMainPanel().setOpaque(true);
        getBgMainPanel().setBounds(0,0,800,511);
        getUpdateKaryawanPanel().add(getBgMainPanel());
        
        eventControl();
        imageControl();
    }
    
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="eventControl() & imageControl() Method ">
    public void eventControl() {
        UpdateKaryawanDialogController ControlPanel = new UpdateKaryawanDialogController(this);
        
        this.addComponentListener(ControlPanel.componentListener);
        getTableKaryawan().addMouseListener(ControlPanel.tableMouseAdapter);
        
        getMovePanel().addMouseListener(ControlPanel.panelPressed);
        getMovePanel().addMouseMotionListener(ControlPanel.panelDragged);
        
        getBackBtn().addActionListener(ControlPanel.buttonActionListener);
        getAddBtn().addActionListener(ControlPanel.buttonActionListener);
        getResetBtn().addActionListener(ControlPanel.buttonActionListener);
        getSaveBtn().addActionListener(ControlPanel.buttonActionListener);
        getDeleteBtn().addActionListener(ControlPanel.buttonActionListener);
        getGetDateBtn().addActionListener(ControlPanel.buttonActionListener);
    }

    public void imageControl() {
        setImage(new ImageIcon(getClass().getResource("/Pic/perbaruiKaryawan.png")));
        getBgMainPanel().setIcon(getImage());
        
        setImage(new ImageIcon(getClass().getResource("/Pic/backBtn.png")));
        getBackBtn().setIcon(getImage());
        setImage(new ImageIcon(getClass().getResource("/Pic/backBtn1.png")));
        getBackBtn().setRolloverIcon(getImage());
        setImage(new ImageIcon(getClass().getResource("/Pic/backBtn2.png")));
        getBackBtn().setPressedIcon(getImage());
        
        setImage(new ImageIcon(getClass().getResource("/Pic/tambahDataBtn.png")));
        getAddBtn().setIcon(getImage());
        getResetBtn().setIcon(getImage());
        setImage(new ImageIcon(getClass().getResource("/Pic/tambahDataBtn1.png")));
        getAddBtn().setRolloverIcon(getImage());
        getResetBtn().setRolloverIcon(getImage());
        setImage(new ImageIcon(getClass().getResource("/Pic/tambahDataBtn2.png")));
        getAddBtn().setPressedIcon(getImage());
        getResetBtn().setPressedIcon(getImage());
        
        setImage(new ImageIcon(getClass().getResource("/Pic/saveBtn.png")));
        getSaveBtn().setIcon(getImage());
        setImage(new ImageIcon(getClass().getResource("/Pic/saveBtn1.png")));
        getSaveBtn().setRolloverIcon(getImage());
        setImage(new ImageIcon(getClass().getResource("/Pic/saveBtn2.png")));
        getSaveBtn().setPressedIcon(getImage());
        
        setImage(new ImageIcon(getClass().getResource("/Pic/deleteBtn.png")));
        getDeleteBtn().setIcon(getImage());
        setImage(new ImageIcon(getClass().getResource("/Pic/deleteBtn1.png")));
        getDeleteBtn().setRolloverIcon(getImage());
        setImage(new ImageIcon(getClass().getResource("/Pic/deleteBtn2.png")));
        getDeleteBtn().setPressedIcon(getImage());
        
        setImage(new ImageIcon(getClass().getResource("/Pic/getDateUser.png")));
        getGetDateBtn().setIcon(getImage());
        setImage(new ImageIcon(getClass().getResource("/Pic/getDateUser1.png")));
        getGetDateBtn().setPressedIcon(getImage());
        
        
    }
//</editor-fold>

}
