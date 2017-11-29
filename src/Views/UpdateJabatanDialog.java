/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

//<editor-fold defaultstate="collapsed" desc="Import">
import Controllers.UpdateJabatanDialogController;
import Interface.SettingViewInterface;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Point;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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
public class UpdateJabatanDialog extends JDialog implements SettingViewInterface {

//<editor-fold defaultstate="collapsed" desc="Deklarasi Kelas, Objek, dan Variabel">
    //JPanel
    private JPanel UpdateJabatanPanel;
    private JPanel movePanel;
    //JLabel
    private JLabel bgJabatanPanel;
    //JTable & Jscrollpane
    private JTable tableJabatan;
    private JScrollPane tableScroll;
    //Jbutton
    private JButton backBtn;
    private JButton saveBtn;
    private JButton deleteBtn;
    private JButton addBtn;
    private JButton resetBtn;
    //JTextField
    private JTextField idJabatanField;
    private JTextField jabatanField;
    private JTextField gajiPokokField;
    private JTextPane deskripsiField;
    private JScrollPane deskripsiScroll;
    
    private ImageIcon image;
    private Point point;
    private boolean isBackBtn;
    
    private Font font;
    
    private String selectedValue;
    private String loginJabatanAs;
    
   

//</editor-fold>
    
//<editor-fold defaultstate="collapsed" desc="Construktor">
    public UpdateJabatanDialog(){
        super((Frame) null, "Perbarui Data Jabatan", true);

        //<editor-fold defaultstate="collapsed" desc="Instansiasi">
        UpdateJabatanPanel = new JPanel();
        movePanel = new JPanel();
        bgJabatanPanel = new JLabel();

        backBtn = new JButton() {
            @Override
            public JToolTip createToolTip() {
                JToolTip tip = super.createToolTip();
                tip.setBackground(new Color(144, 223, 228));
                tip.setBorder(null);
                return tip;
            }
        };
        saveBtn = new JButton() {
            @Override
            public JToolTip createToolTip() {
                JToolTip tip = super.createToolTip();
                tip.setBackground(new Color(144, 223, 228));
                tip.setBorder(null);
                return tip;
            }
        };
        deleteBtn = new JButton() {
            @Override
            public JToolTip createToolTip() {
                JToolTip tip = super.createToolTip();
                tip.setBackground(new Color(144, 223, 228));
                tip.setBorder(null);
                return tip;
            }
        };
        addBtn = new JButton() {
            @Override
            public JToolTip createToolTip() {
                JToolTip tip = super.createToolTip();
                tip.setBackground(new Color(144, 223, 228));
                tip.setBorder(null);
                return tip;
            }
        };
        resetBtn = new JButton() {
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

        tableJabatan = new JTable(){
            public boolean isCellEditable(int rowIndex, int vColIndex) {
                return false;
            }
        };
        tableScroll = new JScrollPane();

        idJabatanField = new JTextField() {
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
        gajiPokokField = new JTextField() {
            @Override
            public JToolTip createToolTip() {
                JToolTip tip = super.createToolTip();
                tip.setBackground(new Color(144, 223, 228));
                tip.setBorder(null);
                return tip;
            }
        };
        deskripsiField = new JTextPane() {
            @Override
            public JToolTip createToolTip() {
                JToolTip tip = super.createToolTip();
                tip.setBackground(new Color(144, 223, 228));
                tip.setBorder(null);
                return tip;
            }
        };
        deskripsiScroll = new JScrollPane() {
            @Override
            public JToolTip createToolTip() {
                JToolTip tip = super.createToolTip();
                tip.setBackground(new Color(144, 223, 228));
                tip.setBorder(null);
                return tip;
            }
        };

        font = new Font("Calibri", Font.PLAIN, 19);

//</editor-fold>
        
        setLocationRelativeTo(null);
        initComponents();

    }

//</editor-fold>
           
//<editor-fold defaultstate="collapsed" desc="Getter Setter">
      public String getLoginJabatanAs() {
        return loginJabatanAs;
    }

    public void setLoginJabatanAs(String loginJabatanAs) {
        this.loginJabatanAs = loginJabatanAs;
    }
  
    public JTextField getIdJabatanField() {
        return idJabatanField;
    }

    public void setIdJabatanField(JTextField idJabatanField) {
        this.idJabatanField = idJabatanField;
    }

    public JTextField getJabatanField() {
        return jabatanField;
    }

    public void setJabatanField(JTextField jabatanField) {
        this.jabatanField = jabatanField;
    }

    public JTextField getGajiPokokField() {
        return gajiPokokField;
    }

    public void setGajiPokokField(JTextField gajiPokokField) {
        this.gajiPokokField = gajiPokokField;
    }

    public JTextPane getDeskripsiField() {
        return deskripsiField;
    }

    public void setDeskripsiField(JTextPane deskripsiField) {
        this.deskripsiField = deskripsiField;
    }

    public JScrollPane getDeskripsiScroll() {
        return deskripsiScroll;
    }

    public void setDeskripsiScroll(JScrollPane deskripsiScroll) {
        this.deskripsiScroll = deskripsiScroll;
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

    public JTable getTableJabatan() {
        return tableJabatan;
    }

    public void setTable(JTable tableKaryawan) {
        this.tableJabatan = tableKaryawan;
    }

    public JPanel getUpdateJabatanPanel() {
        return UpdateJabatanPanel;
    }
    
    public void setUpdateJabatanPanel(JPanel UpdateJabatanPanel) {
        this.UpdateJabatanPanel = UpdateJabatanPanel;
    }
    
    public JPanel getMovePanel() {
        return movePanel;
    }
    
    public void setMovePanel(JPanel movePanel) {
        this.movePanel = movePanel;
    }
    
    public JLabel getBgJabatanPanel() {
        return bgJabatanPanel;
    }
    
    public void setBgJabatanPanel(JLabel bgJabatanPanel) {
        this.bgJabatanPanel = bgJabatanPanel;
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

    public String getSelectedValue() {
        return selectedValue;
    }

    public void setSelectedValue(String selectedValue) {
        this.selectedValue = selectedValue;
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
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="initComponents() Method">
    private void initComponents(){
        this.setSize(800,511);
        this.setLocationRelativeTo(null);
        this.setUndecorated(true);
        this.add(getUpdateJabatanPanel());
        
        //JPanel
        //mainPanel
        getUpdateJabatanPanel().setLayout(null);
        getUpdateJabatanPanel().setOpaque(false);
        getUpdateJabatanPanel().setBounds(0,0,800,511);
        
        //movepanel
        getMovePanel().setLayout(null);
        getMovePanel().setOpaque(false);
        getMovePanel().setBounds(0,0, 800, 45);
        getUpdateJabatanPanel().add(getMovePanel());
        
        //JTable
        //tabel karyawan
        
        getTableJabatan().setModel(new DefaultTableModel(
                new Object [][]{
                
                },
                new String[]{
                    "Id Jabatan", "Nama Jabatan", "Gaji Pokok", "Deskripsi",
                }
        ));
        getTableJabatan().setBorder(null);
        getTableJabatan().setShowGrid(false);
        getTableJabatan().setSelectionForeground(Color.black);
        getTableJabatan().setSelectionBackground(new Color(162, 250, 255));
        getTableJabatan().getTableHeader().setReorderingAllowed(false);
        //table scroll
        getTableScroll().setViewportView(getTableJabatan());
        getTableScroll().setBounds(5,149,791,275);
        getUpdateJabatanPanel().add(getTableScroll());
        
        //JTextField
        //jabatan id
        getIdJabatanField().setVisible(true);
        getIdJabatanField().setBorder(null);
        getIdJabatanField().setOpaque(false);
        getIdJabatanField().setEditable(false);
        getIdJabatanField().setBounds(141, 57, 237, 24);
        getIdJabatanField().setFont(font);
        getIdJabatanField().setSelectionColor(new Color(144, 223, 228));
        getIdJabatanField().setToolTipText("ID Jabatan");
        getUpdateJabatanPanel().add(getIdJabatanField());
        //jabatan
        getJabatanField().setVisible(true);
        getJabatanField().setBorder(null);
        getJabatanField().setOpaque(false);
        getJabatanField().setBounds(141, 88, 237, 24);
        getJabatanField().setFont(font);
        getJabatanField().setSelectionColor(new Color(144, 223, 228));
        getJabatanField().setToolTipText("Masukkan Nama Jabatan");
        getUpdateJabatanPanel().add(getJabatanField());
        //gaji pokok
        getGajiPokokField().setVisible(true);
        getGajiPokokField().setBorder(null);
        getGajiPokokField().setOpaque(false);
        getGajiPokokField().setBounds(141, 118, 237, 24);
        getGajiPokokField().setFont(font);
        getGajiPokokField().setSelectionColor(new Color(144, 223, 228));
        getGajiPokokField().setToolTipText("Masukkan Gaji Pokok");
        getUpdateJabatanPanel().add(getGajiPokokField());
        //deskripsi
        getDeskripsiField().setBorder(null);
        getDeskripsiField().setOpaque(false);
        getDeskripsiField().setSelectionColor(new Color(144, 223, 228));
        getDeskripsiField().setFont(font);
        getDeskripsiField().setToolTipText("Masukkan Deskripsi");
        //Scroll deskripsi
        getDeskripsiScroll().setBorder(null);
        getDeskripsiScroll().setSize(252, 89);
        getDeskripsiScroll().setHorizontalScrollBarPolicy(31);
        getDeskripsiScroll().setWheelScrollingEnabled(true);
        getDeskripsiScroll().setViewportView(getDeskripsiField());
        getDeskripsiScroll().setBounds(544, 56, 252, 89);
        getUpdateJabatanPanel().add(getDeskripsiScroll());
       
        //JButton
        //tombol back
        getBackBtn().setOpaque(true);
        getBackBtn().setBorder(null);
        getBackBtn().setVisible(true);
        getBackBtn().setToolTipText("Kembali ke Menu Sebelumnya");
        getBackBtn().setBounds(3, 431, 194, 73);
        getUpdateJabatanPanel().add(getBackBtn());
        //tombol update
        getSaveBtn().setOpaque(true);
        getSaveBtn().setBorder(null);
        getSaveBtn().setVisible(true);
        getSaveBtn().setEnabled(false);
        getSaveBtn().setToolTipText("Simpan Data");
        getSaveBtn().setBounds(403, 431, 194, 73);
        getUpdateJabatanPanel().add(getSaveBtn());
        //tombol delete
        getDeleteBtn().setOpaque(true);
        getDeleteBtn().setBorder(null);
        getDeleteBtn().setVisible(true);
        getDeleteBtn().setEnabled(false);
        getDeleteBtn().setToolTipText("Hapus Data");
        getDeleteBtn().setBounds(203, 431, 194, 73);
        getUpdateJabatanPanel().add(getDeleteBtn());
        //tombol tambah
        getAddBtn().setOpaque(true);
        getAddBtn().setBorder(null);
        getAddBtn().setVisible(true);
        getAddBtn().setToolTipText("Tambah data");
        getAddBtn().setBounds(603, 431, 194, 73);
        getUpdateJabatanPanel().add(getAddBtn());
        //reset Btn 
        getResetBtn().setOpaque(true);
        getResetBtn().setBorder(null);
        getResetBtn().setVisible(false);
        getResetBtn().setToolTipText("Kosongkan Field");
        getResetBtn().setBounds(603, 431, 194, 73);
        getUpdateJabatanPanel().add(getResetBtn());
        
        
        //Jlabel
        //Gambar Background untuk main panel
        getBgJabatanPanel().setOpaque(true);
        getBgJabatanPanel().setBounds(0,0,800,511);
        getUpdateJabatanPanel().add(getBgJabatanPanel());
        
        eventControl();
        imageControl();
    }
    
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="eventControl() & imageControl() Method ">
    public void eventControl() {
        UpdateJabatanDialogController ControlPanel = new UpdateJabatanDialogController(this);
        
        this.addComponentListener(ControlPanel.componentListener);
        getTableJabatan().addMouseListener(ControlPanel.tableMouseAdapter);
        
        getMovePanel().addMouseListener(ControlPanel.panelPressed);
        getMovePanel().addMouseMotionListener(ControlPanel.panelDragged);
        
        getBackBtn().addActionListener(ControlPanel.buttonActionListener);
        getAddBtn().addActionListener(ControlPanel.buttonActionListener);
        getResetBtn().addActionListener(ControlPanel.buttonActionListener);
        getSaveBtn().addActionListener(ControlPanel.buttonActionListener);
        getDeleteBtn().addActionListener(ControlPanel.buttonActionListener);
      
    
    }

    public void imageControl() {
        setImage(new ImageIcon(getClass().getResource("/Pic/perbaruiJabatan.png")));
        getBgJabatanPanel().setIcon(getImage());
        
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
        
        
        
    }
//</editor-fold>

}
