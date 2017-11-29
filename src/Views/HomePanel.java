/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

//<editor-fold defaultstate="collapsed" desc="Import">

import Controllers.HomePanelController;
import Interface.SettingViewInterface;
import Zazuli.ZazuliCalendarDateTime;
import Zazuli.ZazuliCalendarLocal;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
public class HomePanel extends JPanel implements SettingViewInterface {

//<editor-fold defaultstate="collapsed" desc="Deklarasi Kelas, Objek, dan Variabel">
    
    private JPanel homePanel;
    private JPanel daftarKaryawan;
    private JPanel dataKaryawan;
    //JTable
    private JTable tableKaryawan;
    private JScrollPane tableScroll;
    //JButton
    private JButton lihatDaftarKaryawanBtn;
    private JButton lihatDataKaryawanBtn;
    private JButton perbaruiDataKaryawanBtn;
    private JButton editDataBtn;
    private JButton backBtn;
    private JButton saveBtn;
    private JButton tambahDataKaryawanBtn;
    private JButton getDateBtn;
    //Jlabel
    private JLabel bgHomePanel;
    private JLabel bgDaftarKaryawan;
    private JLabel bgDataKaryawan;
    private UpdateKaryawanDialog updateKaryawanDialog;
    private ImageIcon image;
    //JTextField & Combobox
    
    private JTextField idKaryawanField;
    private JTextField nameField;
    
    private JComboBox CboJenisKelamin;

    private JTextField tempatLahirField;
    private JTextField tanggalLahirField;
    private JTextField agamaField;
    private JTextField jabatanField;
    private JTextField statusField;

    private JTextField kontakField;
    private JTextPane alamatField;
    private JScrollPane alamatScroll;

    private String selectedValue;
    
    private ZazuliCalendarDateTime calendar;
    private Font font;

//</editor-fold>
 
//<editor-fold defaultstate="collapsed" desc="Construktor">
    
    public HomePanel() {
        
        //<editor-fold defaultstate="collapsed" desc="Instansiasi">
        
        daftarKaryawan = new JPanel();
        dataKaryawan = new JPanel();
        homePanel = new JPanel();
      
        tableKaryawan = new JTable() {
            public boolean isCellEditable(int rowIndex, int vColIndex) {
                return false;
            }
        };
        tableScroll = new JScrollPane();

        lihatDaftarKaryawanBtn = new JButton();
        lihatDataKaryawanBtn = new JButton();
        perbaruiDataKaryawanBtn = new JButton();
        backBtn = new JButton(){
            @Override
            public JToolTip createToolTip() {
                JToolTip tip = super.createToolTip();
                tip.setBackground(new Color(144, 223, 228));
                tip.setBorder(null);
                return tip;
            }
        };
        editDataBtn = new JButton(){
            @Override
            public JToolTip createToolTip() {
                JToolTip tip = super.createToolTip();
                tip.setBackground(new Color(144, 223, 228));
                tip.setBorder(null);
                return tip;
            }
        };
        tambahDataKaryawanBtn = new JButton(){
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
        getDateBtn = new JButton(){
            @Override
            public JToolTip createToolTip() {
                JToolTip tip = super.createToolTip();
                tip.setBackground(new Color(144, 223, 228));
                tip.setBorder(null);
                return tip;
            }
        };
        
        bgHomePanel = new JLabel();
        bgDaftarKaryawan = new JLabel();
        bgDataKaryawan = new JLabel();
        image = new ImageIcon();
        
        updateKaryawanDialog = new UpdateKaryawanDialog();
        
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
        
        
        alamatField = new JTextPane(){
            @Override
            public JToolTip createToolTip() {
                JToolTip tip = super.createToolTip();
                tip.setBackground(new Color(144, 223, 228));
                tip.setBorder(null);
                return tip;
            }
        };
        
        statusField = new JTextField(){
            @Override
            public JToolTip createToolTip() {
                JToolTip tip = super.createToolTip();
                tip.setBackground(new Color(144, 223, 228));
                tip.setBorder(null);
                return tip;
            }
        };
        
        jabatanField = new JTextField(){
            @Override
            public JToolTip createToolTip() {
                JToolTip tip = super.createToolTip();
                tip.setBackground(new Color(144, 223, 228));
                tip.setBorder(null);
                return tip;
            }
        };
        alamatScroll = new JScrollPane();
        
//</editor-fold>
        
        initComponents();
    }

    
    public HomePanel(String Judul){
        
        //<editor-fold defaultstate="collapsed" desc="Instansiasi">
        daftarKaryawan = new JPanel();
        dataKaryawan = new JPanel();
        homePanel = new JPanel();
        
        tableKaryawan = new JTable(){
            public boolean isCellEditable(int rowIndex, int vColIndex) {
                return false;
            }
        };
        tableScroll = new JScrollPane();
        
        saveBtn = new JButton(){
            @Override
            public JToolTip createToolTip() {
                JToolTip tip = super.createToolTip();
                tip.setBackground(new Color(144, 223, 228));
                tip.setBorder(null);
                return tip;
            }
        };
        lihatDaftarKaryawanBtn = new JButton();
        lihatDataKaryawanBtn = new JButton();
        
        perbaruiDataKaryawanBtn = new JButton();
        backBtn = new JButton(){
            @Override
            public JToolTip createToolTip() {
                JToolTip tip = super.createToolTip();
                tip.setBackground(new Color(144, 223, 228));
                tip.setBorder(null);
                return tip;
            }
        };
        editDataBtn = new JButton(){
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
        tambahDataKaryawanBtn = new JButton(){
            @Override
            public JToolTip createToolTip() {
                JToolTip tip = super.createToolTip();
                tip.setBackground(new Color(144, 223, 228));
                tip.setBorder(null);
                return tip;
            }
        };
        
        bgHomePanel = new JLabel();
        bgDaftarKaryawan = new JLabel();
        bgDataKaryawan = new JLabel();
        
        image = new ImageIcon();
        
        updateKaryawanDialog = new UpdateKaryawanDialog();
        
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
        
        
        alamatField = new JTextPane(){
            @Override
            public JToolTip createToolTip() {
                JToolTip tip = super.createToolTip();
                tip.setBackground(new Color(144, 223, 228));
                tip.setBorder(null);
                return tip;
            }
        };
        
        statusField = new JTextField(){
            @Override
            public JToolTip createToolTip() {
                JToolTip tip = super.createToolTip();
                tip.setBackground(new Color(144, 223, 228));
                tip.setBorder(null);
                return tip;
            }
        };
        
        jabatanField = new JTextField(){
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
        font = new Font("Calibri", Font.PLAIN, 16);
        
//</editor-fold>
        
        userInitComponents(Judul);
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Getter Setter">
    
    public JButton getEditDataBtn() {
        return editDataBtn;
    }

    public void setEditDataBtn(JButton editDataBtn) {
        this.editDataBtn = editDataBtn;
    }

    public JButton getBackBtn() {
        return backBtn;
    }

    public void setBackBtn(JButton backBtn) {
        this.backBtn = backBtn;
    }

    public JLabel getBgDaftarKaryawan() {
        return bgDaftarKaryawan;
    }

    public void setBgDaftarKaryawan(JLabel bgDaftarKaryawan) {
        this.bgDaftarKaryawan = bgDaftarKaryawan;
    }

  public JPanel getHomePanel() {
        return homePanel;
    }

    public void setHomePanel(JPanel homePanel) {
        this.homePanel = homePanel;
    }

    public UpdateKaryawanDialog getUpdateKaryawanDialog() {
        return updateKaryawanDialog;
    }

    public void setUpdateKaryawanDialog(UpdateKaryawanDialog updateKaryawanDialog) {
        this.updateKaryawanDialog = updateKaryawanDialog;
    }

    public ImageIcon getImage() {
        return image;
    }

    public void setImage(ImageIcon image) {
        this.image = image;
    }

    public JPanel getDaftarKaryawan() {
        return daftarKaryawan;
    }

    public void setDaftarKaryawan(JPanel daftarKaryawan) {
        this.daftarKaryawan = daftarKaryawan;
    }

    public JTable getTableKaryawan() {
        return tableKaryawan;
    }

    public void setTableKaryawan(JTable tableKaryawan) {
        this.tableKaryawan = tableKaryawan;
    }

    public JScrollPane getTableScroll() {
        return tableScroll;
    }

    public void setTableScroll(JScrollPane tableScroll) {
        this.tableScroll = tableScroll;
    }

    public JButton getLihatDaftarKaryawanBtn() {
        return lihatDaftarKaryawanBtn;
    }

    public void setLihatDaftarKaryawanBtn(JButton lihatDaftarKaryawanBtn) {
        this.lihatDaftarKaryawanBtn = lihatDaftarKaryawanBtn;
    }

    public JButton getPerbaruiDataKaryawanBtn() {
        return perbaruiDataKaryawanBtn;
    }

    public void setPerbaruiDataKaryawanBtn(JButton perbaruiDataKaryawanBtn) {
        this.perbaruiDataKaryawanBtn = perbaruiDataKaryawanBtn;
    }

    public JLabel getBgHomePanel() {
        return bgHomePanel;
    }

    public void setBgHomePanel(JLabel bgHomePanel) {
        this.bgHomePanel = bgHomePanel;
    }

    public String getSelectedValue() {
        return selectedValue;
    }

    public void setSelectedValue(String selectedValue) {
        this.selectedValue = selectedValue;
    }

    public JButton getTambahDataKaryawanBtn() {
        return tambahDataKaryawanBtn;
    }

    public void setTambahDataKaryawanBtn(JButton tambahDataKaryawanBtn) {
        this.tambahDataKaryawanBtn = tambahDataKaryawanBtn;
    }

    public JPanel getDataKaryawan() {
        return dataKaryawan;
    }

    public void setDataKaryawan(JPanel dataKaryawan) {
        this.dataKaryawan = dataKaryawan;
    }

    public JButton getLihatDataKaryawanBtn() {
        return lihatDataKaryawanBtn;
    }

    public void setLihatDataKaryawanBtn(JButton lihatDataKaryawanBtn) {
        this.lihatDataKaryawanBtn = lihatDataKaryawanBtn;
    }

    public JButton getSaveBtn() {
        return saveBtn;
    }

    public void setSaveBtn(JButton saveBtn) {
        this.saveBtn = saveBtn;
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

    public JComboBox getCboJenisKelamin() {
        return CboJenisKelamin;
    }

    public void setCboJenisKelamin(JComboBox CboJenisKelamin) {
        this.CboJenisKelamin = CboJenisKelamin;
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

    public JScrollPane getAlamatScroll() {
        return alamatScroll;
    }

    public void setAlamatScroll(JScrollPane alamatScroll) {
        this.alamatScroll = alamatScroll;
    }

    public JLabel getBgDataKaryawan() {
        return bgDataKaryawan;
    }

    public void setBgDataKaryawan(JLabel bgDataKaryawan) {
        this.bgDataKaryawan = bgDataKaryawan;
    }

    public JButton getGetDateBtn() {
        return getDateBtn;
    }

    public void setGetDateBtn(JButton getDateBtn) {
        this.getDateBtn = getDateBtn;
    }

    public ZazuliCalendarDateTime getCalendar() {
        return calendar;
    }

    public void setCalendar(ZazuliCalendarDateTime calendar) {
        this.calendar = calendar;
    }

    public JTextField getJabatanField() {
        return jabatanField;
    }

    public void setJabatanField(JTextField jabatanField) {
        this.jabatanField = jabatanField;
    }

    public JTextField getStatusField() {
        return statusField;
    }

    public void setStatusField(JTextField statusField) {
        this.statusField = statusField;
    }



//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="adminInitComponents() Method">
    private void initComponents() {
        this.setSize(650, 458);
        this.setLayout(null);
        this.setVisible(true);
        this.setBackground(Color.red);
        this.setOpaque(true);
        
        //Jpanel
        //Main Home Panel
        getHomePanel().setLayout(null);
        getHomePanel().setVisible(true);
        getHomePanel().setOpaque(true);
        getHomePanel().setBounds(0, 0, 650, 458);
        this.add(getHomePanel());
        //Panel daftar karyawaan
        getDaftarKaryawan().setLayout(null);
        getDaftarKaryawan().setVisible(false);
        getDaftarKaryawan().setOpaque(true);
        getDaftarKaryawan().setBounds(0, 0, 650, 458);
        this.add(getDaftarKaryawan());
        
        //JTable dan ScrollPane
        //tabel karyawan
        getTableKaryawan().setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Id Karyawan", "Nama", "Jenis Kelamin", "Tempat Tanggal Lahir", "Jabatan"
                }
        ));
        getTableKaryawan().setAutoscrolls(true);
        getTableKaryawan().setBorder(null);
        getTableKaryawan().getTableHeader().setReorderingAllowed(false);
        getTableKaryawan().setShowGrid(false);
        getTableKaryawan().setSelectionForeground(Color.black);
        getTableKaryawan().setSelectionBackground(new Color(162, 250, 255));
        getTableKaryawan().setColumnSelectionAllowed(false);
        ///scroll tabel        
        getTableScroll().setViewportView(getTableKaryawan());
        getTableScroll().setBounds(11,90,610,275);
        getDaftarKaryawan().add(getTableScroll());
        
        
        //JButton
        //tombol data karyawan
        getLihatDaftarKaryawanBtn().setOpaque(true);
        getLihatDaftarKaryawanBtn().setBorder(null);
        getLihatDaftarKaryawanBtn().setBounds(90, 213, 196, 140);
        getHomePanel().add(getLihatDaftarKaryawanBtn());
        //tombol perbarui data karyawan
        getPerbaruiDataKaryawanBtn().setOpaque(true);
        getPerbaruiDataKaryawanBtn().setBorder(null);
        getPerbaruiDataKaryawanBtn().setBounds(343, 213, 196, 140);
        getHomePanel().add(getPerbaruiDataKaryawanBtn());
        //tombol back button
        getBackBtn().setOpaque(true);
        getBackBtn().setBorder(null);
        getBackBtn().setToolTipText("Kembali ke Menu Sebelumnya");
        getBackBtn().setBounds(11, 371, 194, 73);
        getDaftarKaryawan().add(getBackBtn());
        //tombol tambah data
        getTambahDataKaryawanBtn().setOpaque(true);
        getTambahDataKaryawanBtn().setEnabled(true);
        getTambahDataKaryawanBtn().setBorder(null);
        getTambahDataKaryawanBtn().setToolTipText("Tambah Bata Baru");
        getTambahDataKaryawanBtn().setBounds(218, 371, 194, 73);
        getDaftarKaryawan().add(getTambahDataKaryawanBtn());
        //tombol edit data
        getEditDataBtn().setOpaque(true);
        getEditDataBtn().setEnabled(false);
        getEditDataBtn().setBorder(null);
        getEditDataBtn().setToolTipText("Ubah Data");
        getEditDataBtn().setBounds(425, 371, 194, 73);
        getDaftarKaryawan().add(getEditDataBtn());
        
        
        //JLabel
        //bg menu home
        getBgHomePanel().setOpaque(true);
        getBgHomePanel().setBounds(0, 0, 630, 458);
        getHomePanel().add(getBgHomePanel());

        getBgDaftarKaryawan().setOpaque(true);
        getBgDaftarKaryawan().setBounds(0, 0, 630, 458);
        getDaftarKaryawan().add(getBgDaftarKaryawan());

        imageControl();
        eventControl();

    }
//</editor-fold>
   
//<editor-fold defaultstate="collapsed" desc="userInitComponents() Method">
    private void userInitComponents(String Judul) {
        
        this.setSize(650, 458);
        this.setLayout(null);
        this.setVisible(true);
        this.setBackground(Color.red);
        this.setOpaque(true);
        
        //Jpanel
        //Main Home Panel
        getHomePanel().setLayout(null);
        getHomePanel().setVisible(true);
        getHomePanel().setOpaque(true);
        getHomePanel().setBounds(0, 0, 650, 458);
        this.add(getHomePanel());
        
        //Panel data karyawan
        getDataKaryawan().setLayout(null);
        getDataKaryawan().setVisible(false);
        getDataKaryawan().setOpaque(true);
        getDataKaryawan().setBounds(0, 0, 650, 458);
        this.add(getDataKaryawan());
        
        //JTextField & Combobox
        getIdKaryawanField().setVisible(true);
        getIdKaryawanField().setBorder(null);
        getIdKaryawanField().setOpaque(false);
        getIdKaryawanField().setEditable( false);
        getIdKaryawanField().setBounds(131,95,183,20);
        getIdKaryawanField().setFont(font);
        getIdKaryawanField().setSelectionColor(new Color(144, 223, 228));
        getIdKaryawanField().setToolTipText("Masukkan ID Karyawan");
        getDataKaryawan().add(getIdKaryawanField());
         //name
        getNameField().setVisible(true);
        getNameField().setBorder(null);
        getNameField().setOpaque(false);
        getNameField().setBounds(131,119,183,20);
        getNameField().setFont(font);
        getNameField().setSelectionColor(new Color(144, 223, 228));
        getNameField().setToolTipText("Masukkan Nama");
        getDataKaryawan().add(getNameField());
         //Combobox JK
        getCboJenisKelamin().setVisible(true);
        getCboJenisKelamin().setOpaque(true);
        getCboJenisKelamin().setBorder(null);
        getCboJenisKelamin().setFont(font);
        getCboJenisKelamin().setBackground(Color.white);
        getCboJenisKelamin().setBounds(130,143,186,20);
        getCboJenisKelamin().setToolTipText("Pilih Jenis Kelamin");
        getDataKaryawan().add(getCboJenisKelamin());

        //Tempat lahir
        getTempatLahirField().setVisible(true);
        getTempatLahirField().setBorder(null);
        getTempatLahirField().setOpaque(false);
        getTempatLahirField().setBounds(131,167,183,20);
        getTempatLahirField().setFont(font);
        getTempatLahirField().setSelectionColor(new Color(144, 223, 228));
        getTempatLahirField().setToolTipText("Masukkan Kota Lahir");
        getDataKaryawan().add(getTempatLahirField());
        //Tanggal Lahir
        getTanggalLahirField().setVisible(true);
        getTanggalLahirField().setBorder(null);
        getTanggalLahirField().setOpaque(false);
        getTanggalLahirField().setBounds(131,191,183,20);
        getTanggalLahirField().setFont(font);
        getTanggalLahirField().setSelectionColor(new Color(144, 223, 228));
        getTanggalLahirField().setToolTipText("Masukkan Tanggal Lahir");
        getDataKaryawan().add(getTanggalLahirField());
        //getDate
        getCalendar().setBorder(null);
        getCalendar().setVisible(true);getCalendar().setBounds(428,191,130,22);
        getCalendar().setFormat("dd-mm-yyyy");
        getCalendar().setEditable(true);
        getCalendar().setFontDate(font);
        getDataKaryawan().add(getCalendar());
        //agama
        getAgamaField().setVisible(true);
        getAgamaField().setBorder(null);
        getAgamaField().setOpaque(false);
        getAgamaField().setBounds(131,269,183,20);
        getAgamaField().setFont(font);
        getAgamaField().setSelectionColor(new Color(144, 223, 228));
        getAgamaField().setToolTipText("Masukkan Agama");
        getDataKaryawan().add(getAgamaField());
        //Jabatan
        //Jabatan Field
        getJabatanField().setVisible(true);
        getJabatanField().setBorder(null);
        getJabatanField().setOpaque(false);
        getJabatanField().setEditable(false);
        getJabatanField().setBounds(433,270,186,20);
        getJabatanField().setFont(font);
        getJabatanField().setSelectionColor(new Color(144, 223, 228));
        getJabatanField().setToolTipText("Jabatan Anda");
        getDataKaryawan().add(getJabatanField());

        //kontak
        getKontakField().setVisible(true);
        getKontakField().setBorder(null);
        getKontakField().setOpaque(false);
        getKontakField().setBounds(131,294,183,20);
        getKontakField().setFont(font);
        getKontakField().setSelectionColor(new Color(144, 223, 228));
        getKontakField().setToolTipText("Masukkan Kontak");
        getDataKaryawan().add(getKontakField());

        //JTextField Status
        getStatusField().setVisible(true);
        getStatusField().setBorder(null);
        getStatusField().setOpaque(false);
        getStatusField().setEditable(false);
        getStatusField().setBounds(433,294,186,20);
        getStatusField().setFont(font);
        getStatusField().setSelectionColor(new Color(144, 223, 228));
        getStatusField().setToolTipText("Status Anda");
        getDataKaryawan().add(getStatusField());
 
        
        //alamatPane & Scroll
        getAlamatField().setVisible(true);
        getAlamatField().setBorder(null);
        getAlamatField().setOpaque(true);
        getAlamatField().setBackground(Color.white);
        getAlamatField().setSelectionColor(new Color(144, 223, 228));
        getAlamatField().setFont(font);
        getAlamatField().setToolTipText("Masukkan Alamat");
        //Scrollpane
        getAlamatScroll().setBorder(null);
        getAlamatScroll().setSize(491, 39);
        getAlamatScroll().setHorizontalScrollBarPolicy(31);
        getAlamatScroll().setWheelScrollingEnabled(true);
        getAlamatScroll().setViewportView(getAlamatField());
        getAlamatScroll().setBounds(131, 325, 491, 39);
        getDataKaryawan().add(getAlamatScroll());
        
        
        //JButton
        //tombol data karyawan
        getLihatDataKaryawanBtn().setOpaque(false);
        getLihatDataKaryawanBtn().setVisible(true);
        getLihatDataKaryawanBtn().setBorder(null);
        getLihatDataKaryawanBtn().setBounds(220, 213, 196, 140);
        getHomePanel().add(getLihatDataKaryawanBtn());
        //tombol back button
        getBackBtn().setOpaque(true);
        getBackBtn().setBorder(null);
        getBackBtn().setToolTipText("Kembali ke Menu Sebelumnya");
        getBackBtn().setBounds(218, 371, 194, 73);
        getDataKaryawan().add(getBackBtn());
        //tombol getdate
        getGetDateBtn().setOpaque(true);
        getGetDateBtn().setBorder(null);
        getGetDateBtn().setToolTipText("Get Date");
        getGetDateBtn().setBounds(559, 190, 60, 21);
        getDataKaryawan().add(getGetDateBtn());
        //tombol save
        getSaveBtn().setOpaque(true);
        getSaveBtn().setBorder(null);
        getSaveBtn().setToolTipText("Simpan Data");
        getSaveBtn().setBounds(425, 371, 194, 73);
        getDataKaryawan().add(getSaveBtn());
        
        
        //JLabel
        //bg menu home
        getBgHomePanel().setOpaque(true);
        getBgHomePanel().setBounds(0, 0, 630, 458);
        getHomePanel().add(getBgHomePanel());

        getBgDataKaryawan().setOpaque(true);
        getBgDataKaryawan().setBounds(0, 0, 630, 458);
        getDataKaryawan().add(getBgDataKaryawan());

        imageControl();
        eventControl();

    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="eventControl() & imageControl()">
    public void eventControl() {
        HomePanelController ControlPanel = new HomePanelController(this);
        
        getDaftarKaryawan().addComponentListener(ControlPanel.componentListener);
        
        
        getPerbaruiDataKaryawanBtn().addActionListener(ControlPanel.buttonActionListener);
        getEditDataBtn().addActionListener(ControlPanel.buttonActionListener);
        getLihatDaftarKaryawanBtn().addActionListener(ControlPanel.buttonActionListener); 
        getBackBtn().addActionListener(ControlPanel.buttonActionListener);
        getTambahDataKaryawanBtn().addActionListener(ControlPanel.buttonActionListener);
       
        getTableKaryawan().addMouseListener(ControlPanel.tableMouseAdapter);
        
        getLihatDataKaryawanBtn().addActionListener(ControlPanel.buttonActionListener);
        getSaveBtn().addActionListener(ControlPanel.buttonActionListener);
        getGetDateBtn().addActionListener(ControlPanel.buttonActionListener);
    
        
    }

    public void imageControl() {

        setImage(new ImageIcon(getClass().getResource("/Pic/WadahHome.png")));
        getBgHomePanel().setIcon(getImage());
        setImage(new ImageIcon(getClass().getResource("/Pic/daftarKaryawan.png")));
        getBgDaftarKaryawan().setIcon(getImage());
        setImage(new ImageIcon(getClass().getResource("/Pic/dataKaryawan.png")));
        getBgDataKaryawan().setIcon(getImage());
        
        

        setImage(new ImageIcon(getClass().getResource("/Pic/BtnDataKaryawanHome.png")));
        getLihatDaftarKaryawanBtn().setIcon(getImage());
        getLihatDataKaryawanBtn().setIcon(getImage());
        setImage(new ImageIcon(getClass().getResource("/Pic/BtnDataKaryawanHome1.png")));
        getLihatDaftarKaryawanBtn().setRolloverIcon(getImage());
        getLihatDataKaryawanBtn().setRolloverIcon(getImage());
        setImage(new ImageIcon(getClass().getResource("/Pic/BtnDataKaryawanHome2.png")));
        getLihatDaftarKaryawanBtn().setPressedIcon(getImage());
        getLihatDataKaryawanBtn().setPressedIcon(getImage());
       

        setImage(new ImageIcon(getClass().getResource("/Pic/BtnPerbaruiDataKaryawanHome.png")));
        getPerbaruiDataKaryawanBtn().setIcon(getImage());
        setImage(new ImageIcon(getClass().getResource("/Pic/BtnPerbaruiDataKaryawanHome1.png")));
        getPerbaruiDataKaryawanBtn().setRolloverIcon(getImage());
        setImage(new ImageIcon(getClass().getResource("/Pic/BtnPerbaruiDataKaryawanHome2.png")));
        getPerbaruiDataKaryawanBtn().setPressedIcon(getImage());

        setImage(new ImageIcon(getClass().getResource("/Pic/editDataBtn.png")));
        getEditDataBtn().setIcon(getImage());
        setImage(new ImageIcon(getClass().getResource("/Pic/editDataBtn1.png")));
        getEditDataBtn().setRolloverIcon(getImage());
        setImage(new ImageIcon(getClass().getResource("/Pic/editDataBtn2.png")));
        getEditDataBtn().setPressedIcon(getImage());
        
        setImage(new ImageIcon(getClass().getResource("/Pic/backBtn.png")));
        getBackBtn().setIcon(getImage());
        setImage(new ImageIcon(getClass().getResource("/Pic/backBtn1.png")));
        getBackBtn().setRolloverIcon(getImage());
        setImage(new ImageIcon(getClass().getResource("/Pic/backBtn2.png")));
        getBackBtn().setPressedIcon(getImage());
        
        setImage(new ImageIcon(getClass().getResource("/Pic/tambahDataBtn.png")));
        getTambahDataKaryawanBtn().setIcon(getImage());
        setImage(new ImageIcon(getClass().getResource("/Pic/tambahDataBtn1.png")));
        getTambahDataKaryawanBtn().setRolloverIcon(getImage());
        setImage(new ImageIcon(getClass().getResource("/Pic/tambahDataBtn2.png")));
        getTambahDataKaryawanBtn().setPressedIcon(getImage());

        setImage(new ImageIcon(getClass().getResource("/Pic/getDateUser.png")));
        getGetDateBtn().setIcon(getImage());
        setImage(new ImageIcon(getClass().getResource("/Pic/getDateUser1.png")));
        getGetDateBtn().setPressedIcon(getImage());

        
        setImage(new ImageIcon(getClass().getResource("/Pic/saveBtn.png")));
        getSaveBtn().setIcon(getImage());
        setImage(new ImageIcon(getClass().getResource("/Pic/saveBtn1.png")));
        getSaveBtn().setRolloverIcon(getImage());
        setImage(new ImageIcon(getClass().getResource("/Pic/saveBtn2.png")));
        getSaveBtn().setPressedIcon(getImage());
        
    }
//</editor-fold>


}
