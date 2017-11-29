/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

//<editor-fold defaultstate="collapsed" desc="Import">

import Controllers.JabatanPanelController;
import Interface.SettingViewInterface;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolTip;
import javax.swing.table.DefaultTableModel;
//</editor-fold>

/**
 *
 * @author S F I F
 */

public class JabatanPanel extends JPanel implements SettingViewInterface {

//<editor-fold defaultstate="collapsed" desc="Deklarasi Kelas, Objek, dan Variabel">
    
    private JPanel jabatanPanel;
    private JPanel daftarJabatan;
    //JTable
    private JTable tableJabatan;
    private JScrollPane tableScroll;
    //JButton
    private JButton lihatDataJabatanBtn;
    private JButton perbaruiDataJabatanBtn;
    private JButton editDataBtn;
    private JButton backBtn;
    private JButton tambahDataJabatanBtn;
      
    private JLabel bgJabatanPanel;
    private JLabel bgDaftarJabatan;
    private UpdateJabatanDialog updateJabatanDialog;
    private ImageIcon image;
    
    private String selectedValue;
    
//</editor-fold>
 
//<editor-fold defaultstate="collapsed" desc="Construktor">
    
    public JabatanPanel() {
        
        daftarJabatan = new JPanel();
        jabatanPanel = new JPanel();
        
        tableJabatan = new JTable(){
            public boolean isCellEditable(int rowIndex, int vColIndex) {
                return false;
            }
        };
        tableScroll = new JScrollPane();
        
        lihatDataJabatanBtn = new JButton();
        perbaruiDataJabatanBtn = new JButton();
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
        tambahDataJabatanBtn = new JButton(){
            @Override
            public JToolTip createToolTip() {
                JToolTip tip = super.createToolTip();
                tip.setBackground(new Color(144, 223, 228));
                tip.setBorder(null);
                return tip;
            }
        };
        
        bgJabatanPanel = new JLabel();
        bgDaftarJabatan = new JLabel();
        
        image = new ImageIcon();
        
        updateJabatanDialog = new UpdateJabatanDialog();
        
        initComponents();
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

    public JLabel getBgDaftarJabatan() {
        return bgDaftarJabatan;
    }

    public void setBgDaftarJabatan(JLabel bgDaftarJabatan) {
        this.bgDaftarJabatan = bgDaftarJabatan;
    }

  public JPanel getJabatanPanel() {
        return jabatanPanel;
    }

    public void setJabatanPanel(JPanel jabatanPanel) {
        this.jabatanPanel = jabatanPanel;
    }

    public UpdateJabatanDialog getUpdateJabatanDialog() {
        return updateJabatanDialog;
    }

    public void setUpdateJabatanDialog(UpdateJabatanDialog updateJabatanDialog) {
        this.updateJabatanDialog = updateJabatanDialog;
    }

    public ImageIcon getImage() {
        return image;
    }

    public void setImage(ImageIcon image) {
        this.image = image;
    }

    public JPanel getDaftarJabatan() {
        return daftarJabatan;
    }

    public void setDaftarJabatan(JPanel daftarJabatan) {
        this.daftarJabatan = daftarJabatan;
    }

    public JTable getTableJabatan() {
        return tableJabatan;
    }

    public void setTableJabatan(JTable tableJabatan) {
        this.tableJabatan = tableJabatan;
    }

    public JScrollPane getTableScroll() {
        return tableScroll;
    }

    public void setTableScroll(JScrollPane tableScroll) {
        this.tableScroll = tableScroll;
    }

    public JButton getLihatDataJabatanBtn() {
        return lihatDataJabatanBtn;
    }

    public void setLihatDataJabatanBtn(JButton lihatDataJabatanBtn) {
        this.lihatDataJabatanBtn = lihatDataJabatanBtn;
    }

    public JButton getPerbaruiDataJabatanBtn() {
        return perbaruiDataJabatanBtn;
    }

    public void setPerbaruiDataJabatanBtn(JButton perbaruiDataJabatanBtn) {
        this.perbaruiDataJabatanBtn = perbaruiDataJabatanBtn;
    }

    public JLabel getBgJabatanPanel() {
        return bgJabatanPanel;
    }

    public void setBgJabatanPanel(JLabel bgHomePanel) {
        this.bgJabatanPanel = bgHomePanel;
    }

    public JButton getTambahDataJabatanBtn() {
        return tambahDataJabatanBtn;
    }

    public void setTambahDataJabatanBtn(JButton tambahDataJabatanBtn) {
        this.tambahDataJabatanBtn = tambahDataJabatanBtn;
    }

    public String getSelectedValue() {
        return selectedValue;
    }

    public void setSelectedValue(String selectedValue) {
        this.selectedValue = selectedValue;
    }

//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="initComponents() Method">
    private void initComponents() {
        this.setSize(650, 458);
        this.setLayout(null);
        this.setVisible(true);
        this.setBackground(Color.red);
        this.setOpaque(true);
        
        //Jpanel
        //Main Home Panel
        getJabatanPanel().setLayout(null);
        getJabatanPanel().setVisible(true);
        getJabatanPanel().setOpaque(true);
        getJabatanPanel().setBounds(0, 0, 650, 458);
        this.add(getJabatanPanel());
        //Panel daftar karyawaan
        getDaftarJabatan().setLayout(null);
        getDaftarJabatan().setVisible(false);
        getDaftarJabatan().setOpaque(true);
        getDaftarJabatan().setBounds(0, 0, 650, 458);
        this.add(getDaftarJabatan());
        
        //JTable dan ScrollPane
        //tabel karyawan
         getTableJabatan().setModel(new DefaultTableModel(
                new Object [][]{
                
                },
                new String[]{
                    "Id Jabatan", "Nama Jabatan", "Gaji Pokok", "Deskripsi",
                }
        ));
        getTableJabatan().setAutoscrolls(true);
        getTableJabatan().setBorder(null);
        getTableJabatan().getTableHeader().setReorderingAllowed(false);
        getTableJabatan().setShowGrid(false);
        getTableJabatan().setSelectionForeground(Color.black);
        getTableJabatan().setSelectionBackground(new Color(162, 250, 255));
        getTableJabatan().setColumnSelectionAllowed(false);
        //scroll tabel        
        getTableScroll().setViewportView(getTableJabatan());
        getTableScroll().setBounds(11,90,610,275);
        getDaftarJabatan().add(getTableScroll());
        
        
        //JButton
        //tombol data karyawan
        getLihatDataJabatanBtn().setOpaque(true);
        getLihatDataJabatanBtn().setBorder(null);
        getLihatDataJabatanBtn().setBounds(90, 213, 196, 140);
        getJabatanPanel().add(getLihatDataJabatanBtn());
        //tombol perbarui data karyawan
        getPerbaruiDataJabatanBtn().setOpaque(true);
        getPerbaruiDataJabatanBtn().setBorder(null);
        getPerbaruiDataJabatanBtn().setBounds(343, 213, 196, 140);
        getJabatanPanel().add(getPerbaruiDataJabatanBtn());
        //tombol back button
        getBackBtn().setOpaque(true);
        getBackBtn().setBorder(null);
        getBackBtn().setToolTipText("Kembali ke Menu Sebelumnya");
        getBackBtn().setBounds(11, 371, 194, 73);
        getDaftarJabatan().add(getBackBtn());
        //tombol tambah data
        getTambahDataJabatanBtn().setOpaque(true);
        getTambahDataJabatanBtn().setEnabled(true);
        getTambahDataJabatanBtn().setBorder(null);
        getTambahDataJabatanBtn().setToolTipText("Tambah Bata Baru");
        getTambahDataJabatanBtn().setBounds(218, 371, 194, 73);
        getDaftarJabatan().add(getTambahDataJabatanBtn());
        //tombol edit data
        getEditDataBtn().setOpaque(true);
        getEditDataBtn().setEnabled(false);
        getEditDataBtn().setBorder(null);
        getEditDataBtn().setToolTipText("Ubah Data");
        getEditDataBtn().setBounds(425, 371, 194, 73);
        getDaftarJabatan().add(getEditDataBtn());
        
        
        //JLabel
        //bg menu home
        getBgJabatanPanel().setOpaque(true);
        getBgJabatanPanel().setBounds(0, 0, 630, 458);
        getJabatanPanel().add(getBgJabatanPanel());

        getBgDaftarJabatan().setOpaque(true);
        getBgDaftarJabatan().setBounds(0, 0, 630, 458);
        getDaftarJabatan().add(getBgDaftarJabatan());

        imageControl();
        eventControl();

    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="eventControl() & imageControl()">
    public void eventControl() {
        JabatanPanelController ControlPanel = new JabatanPanelController(this);
        
        getDaftarJabatan().addComponentListener(ControlPanel.componentListener);
        
        getPerbaruiDataJabatanBtn().addActionListener(ControlPanel.buttonActionListener);  
        getEditDataBtn().addActionListener(ControlPanel.buttonActionListener);
        getLihatDataJabatanBtn().addActionListener(ControlPanel.buttonActionListener);
        getBackBtn().addActionListener(ControlPanel.buttonActionListener); 
        getTambahDataJabatanBtn().addActionListener(ControlPanel.buttonActionListener);
        
        getTableJabatan().addMouseListener(ControlPanel.tableMouseAdapter);
    }

    public void imageControl() {

        setImage(new ImageIcon(getClass().getResource("/Pic/WadahJabatan.png")));
        getBgJabatanPanel().setIcon(getImage());
        setImage(new ImageIcon(getClass().getResource("/Pic/daftarJabatan.png")));
        getBgDaftarJabatan().setIcon(getImage());

        setImage(new ImageIcon(getClass().getResource("/Pic/BtnLihatJabatanJabatan.png")));
        getLihatDataJabatanBtn().setIcon(getImage());
        setImage(new ImageIcon(getClass().getResource("/Pic/BtnLihatJabatanJabatan1.png")));
        getLihatDataJabatanBtn().setRolloverIcon(getImage());
        setImage(new ImageIcon(getClass().getResource("/Pic/BtnLihatJabatanJabatan2.png")));
        getLihatDataJabatanBtn().setPressedIcon(getImage());

        setImage(new ImageIcon(getClass().getResource("/Pic/BtnPerbaruiDataJabatanJabatan.png")));
        getPerbaruiDataJabatanBtn().setIcon(getImage());
        setImage(new ImageIcon(getClass().getResource("/Pic/BtnPerbaruiDataJabatanJabatan1.png")));
        getPerbaruiDataJabatanBtn().setRolloverIcon(getImage());
        setImage(new ImageIcon(getClass().getResource("/Pic/BtnPerbaruiDataJabatanJabatan2.png")));
        getPerbaruiDataJabatanBtn().setPressedIcon(getImage());

        setImage(new ImageIcon(getClass().getResource("/Pic/tambahDataBtn.png")));
        getTambahDataJabatanBtn().setIcon(getImage());
        setImage(new ImageIcon(getClass().getResource("/Pic/tambahDataBtn1.png")));
        getTambahDataJabatanBtn().setRolloverIcon(getImage());
        setImage(new ImageIcon(getClass().getResource("/Pic/tambahDataBtn2.png")));
        getTambahDataJabatanBtn().setPressedIcon(getImage());

        
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
        
    }
//</editor-fold>

}
