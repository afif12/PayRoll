/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

//<editor-fold defaultstate="collapsed" desc="Import">
import Models.JabatanEntityModel;
import Views.JabatanPanel;
import Views.OKDialog;
import Views.UpdateJabatanDialog;
import Views.YesNoDialog;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
//</editor-fold>

/**
 *
 * @author A F I F
 */
public class UpdateJabatanDialogController {
    
//<editor-fold defaultstate="collapsed" desc="Deklarasi Kelas, Objek, dan Variabel">
    private UpdateJabatanDialog updateJabatanDialogView;
    private Point point;
    private ImageIcon image;
    private YesNoDialog yesNoDialog;
    
//</editor-fold>  

//<editor-fold defaultstate="collapsed" desc="Contructor">
    
    public UpdateJabatanDialogController(UpdateJabatanDialog updateJabatanDialogView) {
        this.updateJabatanDialogView = updateJabatanDialogView;
        yesNoDialog = new YesNoDialog();
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Getter Setter">
    
    public UpdateJabatanDialog getUpdateJabatanDialogView() {
        return updateJabatanDialogView;
    }
    
    public void setUpdateJabatanDialogView(UpdateJabatanDialog updateJabatanDialogView) {
        this.updateJabatanDialogView = updateJabatanDialogView;
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

    public YesNoDialog getYesNoDialog() {
        return yesNoDialog;
    }

    public void setYesNoDialog(YesNoDialog yesNoDialog) {
        this.yesNoDialog = yesNoDialog;
    }
    
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Method Code">
    
// <editor-fold defaultstate="collapsed" desc="Method Untuk Menggeser Panel">
    public void formMousePressed(MouseEvent Evt) {
        
        getUpdateJabatanDialogView().getPoint().x = Evt.getX();
        getUpdateJabatanDialogView().getPoint().y = Evt.getY();
    }
    
    public void formMouseDragged(MouseEvent Evt) {
        
        Point p = getUpdateJabatanDialogView().getLocation();
        getUpdateJabatanDialogView().setLocation(p.x + Evt.getX() - getUpdateJabatanDialogView().getPoint().x, p.y + Evt.getY() - getUpdateJabatanDialogView().getPoint().y);
    }
    
    
//</editor-fold>
 
//<editor-fold defaultstate="collapsed" desc="Table Mouse Released">
   public void tabelJabatanMouseReleased(){
        String Value = null;
        
        getUpdateJabatanDialogView().setSelectedValue(getUpdateJabatanDialogView().getTableJabatan().getValueAt(
                getUpdateJabatanDialogView().getTableJabatan().getSelectedRow(), 0).toString());
        
        System.out.println(getUpdateJabatanDialogView().getSelectedValue());
        if(!getUpdateJabatanDialogView().getSelectedValue().isEmpty()){
            String key = getUpdateJabatanDialogView().getSelectedValue();
            JabatanEntityModel model = new JabatanEntityModel(key, "", "", "").detailDataSet();
            
            getUpdateJabatanDialogView().getIdJabatanField().setText(model.getIdJabatan());
            getUpdateJabatanDialogView().getJabatanField().setText(model.getNamaJabatan());
            getUpdateJabatanDialogView().getGajiPokokField().setText(model.getGajiPokok());
            getUpdateJabatanDialogView().getDeskripsiField().setText(model.getDeskripsi());
            
            getUpdateJabatanDialogView().getAddBtn().setVisible(false);
            getUpdateJabatanDialogView().getResetBtn().setVisible(true);
            getUpdateJabatanDialogView().getDeleteBtn().setEnabled(true);
            getUpdateJabatanDialogView().getSaveBtn().setEnabled(true);
        }
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Show Table Method">
    public void tampilDaftarJabatan(ComponentEvent Evt) {
        loadTable();
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Load Data to Table Method">
   private void loadTable(){
        
        JabatanEntityModel model = new JabatanEntityModel("", "", "", "");
        
        String[] Header = new String[]{"Id Jabatan", "Nama Jabatan", "Gaji Pokok", "Deskripsi"};
        DefaultTableModel Record = new DefaultTableModel(model.detailDataSet().getAllValue(), Header);
        int[] wCol = null;
        
        wCol = new int[]{160, 130, 100, 450};
        getUpdateJabatanDialogView().getTableJabatan().setModel(Record);
        initColumnRecord(getUpdateJabatanDialogView().getTableJabatan(), wCol);
        System.out.println("rows : " + getUpdateJabatanDialogView().getTableJabatan().getRowCount());
        getUpdateJabatanDialogView().getTableJabatan().addRowSelectionInterval(0, 0);
        
    }
    
    private void initColumnRecord(JTable table, int[] wCol) {
        TableColumn col = null;
        int i = 0;
        for (i = table.getColumnCount() - 1; i > 0; i--) {
            col = table.getColumnModel().getColumn(i);
            col.setPreferredWidth(wCol[i]);
        }
    }
    
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Validate Method">
    private boolean isValidate() {
        boolean flag;
        
        if (getUpdateJabatanDialogView().getJabatanField().getText().matches("")) {
            setImage(new ImageIcon(getClass().getResource("/Pic/bgFormJabatanDialog.png")));
            OKDialog OK =new OKDialog();
            OK.getBgOKDialog().setIcon(getImage());
            OK.setVisible(true); 
            getUpdateJabatanDialogView().getJabatanField().requestFocus();
            flag = false;
        } else if (getUpdateJabatanDialogView().getGajiPokokField().getText().matches("")) {
            setImage(new ImageIcon(getClass().getResource("/Pic/bgFormGajiPokokDialog.png")));
            OKDialog OK =new OKDialog();
            OK.getBgOKDialog().setIcon(getImage());
            OK.setVisible(true); 
            getUpdateJabatanDialogView().getGajiPokokField().requestFocus();
            flag = false;
        } else if (getUpdateJabatanDialogView().getDeskripsiField().getText().matches("")) {
            setImage(new ImageIcon(getClass().getResource("/Pic/bgFormDeskripsiDialog.png")));
            OKDialog OK =new OKDialog();
            OK.getBgOKDialog().setIcon(getImage());
            OK.setVisible(true); 
            getUpdateJabatanDialogView().getDeskripsiField().requestFocus();
            flag = false;
        } else {
            flag = true;
        }
        return flag;
    }
    
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="CRUD Method">
    private void editDataJabatan(){
        if (isValidate()) {
            JabatanEntityModel model = new JabatanEntityModel(
                    getUpdateJabatanDialogView().getIdJabatanField().getText(),
                    getUpdateJabatanDialogView().getJabatanField().getText(),
                    getUpdateJabatanDialogView().getGajiPokokField().getText(),
                    getUpdateJabatanDialogView().getDeskripsiField().getText()
            );
            
            if(model.editDataValue()){
                setImage(new ImageIcon(getClass().getResource("/Pic/bgBerhasilDisimpanDialog.png")));
                OKDialog OK = new OKDialog();
                OK.getBgOKDialog().setIcon(getImage());
                OK.setVisible(true);
                loadTable();
                resetFieldAndButton();
            }else{
                setImage(new ImageIcon(getClass().getResource("/Pic/bgErrorGagalSimpanDialog.png")));
                OKDialog OK = new OKDialog();
                OK.getBgOKDialog().setIcon(getImage());
                OK.setVisible(true);

                loadTable();
                resetFieldAndButton();
            }
            
        }
    }
    
    private void addDataJabatan() {
        if (isValidate()) {
            JabatanEntityModel model = new JabatanEntityModel(
                    getUpdateJabatanDialogView().getIdJabatanField().getText(),
                    getUpdateJabatanDialogView().getJabatanField().getText(),
                    getUpdateJabatanDialogView().getGajiPokokField().getText(),
                    getUpdateJabatanDialogView().getDeskripsiField().getText()
            );
            
            if (model.addDataValue()) {
                setImage(new ImageIcon(getClass().getResource("/Pic/bgBerhasilDitambahDialog.png")));
                OKDialog OK = new OKDialog();
                OK.getBgOKDialog().setIcon(getImage());
                OK.setVisible(true);
                loadTable();
                resetFieldAndButton();
            } else {
                setImage(new ImageIcon(getClass().getResource("/Pic/bgErrorGagalTambahDialog.png")));
                OKDialog OK = new OKDialog();
                OK.getBgOKDialog().setIcon(getImage());
                OK.setVisible(true);
                loadTable();
                resetFieldAndButton();
            }
            
        }
    }
    
    private void deleteDataJabatan() {
        if (getUpdateJabatanDialogView().getIdJabatanField().getText().equals(getUpdateJabatanDialogView().getLoginJabatanAs())) {
            setImage(new ImageIcon(getClass().getResource("/Pic/bgPenghapusanTidakDibolehkan.png")));
            OKDialog OK = new OKDialog();
            OK.getBgOKDialog().setIcon(getImage());
            OK.setVisible(true);
        } else {

            setImage(new ImageIcon(getClass().getResource("/Pic/bgHapusDialog.png")));
            getYesNoDialog().getBgYesNoDialog().setIcon(getImage());
            getYesNoDialog().setVisible(true);

            if (getYesNoDialog().getYes()) {
                if (isValidate()) {
                    JabatanEntityModel model = new JabatanEntityModel(
                            getUpdateJabatanDialogView().getIdJabatanField().getText(),
                            getUpdateJabatanDialogView().getJabatanField().getText(),
                            getUpdateJabatanDialogView().getGajiPokokField().getText(),
                            getUpdateJabatanDialogView().getDeskripsiField().getText()
                    );

                    if (model.subDataValue()) {
                        setImage(new ImageIcon(getClass().getResource("/Pic/bgBerhasilDihapusDialog.png")));
                        OKDialog OK = new OKDialog();
                        OK.getBgOKDialog().setIcon(getImage());
                        OK.setVisible(true);

                        loadTable();
                        resetFieldAndButton();
                    } else {
                        setImage(new ImageIcon(getClass().getResource("/Pic/bgErrorGagalHapusDialog.png")));
                        OKDialog OK = new OKDialog();
                        OK.getBgOKDialog().setIcon(getImage());
                        OK.setVisible(true);

                        loadTable();
                        resetFieldAndButton();
                    }

                }
            }
        }
    }
//</editor-fold>
    
//<editor-fold defaultstate="collapsed" desc="Reset TextField and Button">
    private void resetFieldAndButton(){
        JabatanEntityModel model = new JabatanEntityModel();
        
        getUpdateJabatanDialogView().getIdJabatanField().setText(model.genIdDataValue());
        getUpdateJabatanDialogView().getJabatanField().setText("");
        getUpdateJabatanDialogView().getGajiPokokField().setText("");
        getUpdateJabatanDialogView().getDeskripsiField().setText("");
        
        getUpdateJabatanDialogView().getAddBtn().setVisible(true);
        getUpdateJabatanDialogView().getResetBtn().setVisible(false);
        getUpdateJabatanDialogView().getDeleteBtn().setEnabled(false);
        getUpdateJabatanDialogView().getSaveBtn().setEnabled(false);
        
    }
    
//</editor-fold>

//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Annonymous Code">
//method code
    public ComponentListener componentListener = new ComponentAdapter() {
        @Override
        public void componentShown(ComponentEvent Evt) {
            tampilDaftarJabatan(Evt);
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
            if (Evt.getSource().equals(getUpdateJabatanDialogView().getBackBtn())) {
                //getUpdateJabatanDialogView().setVisible(false);
                getUpdateJabatanDialogView().dispose();
            } else if (Evt.getSource().equals(getUpdateJabatanDialogView().getResetBtn())) {
                resetFieldAndButton();
            } else if (Evt.getSource().equals(getUpdateJabatanDialogView().getAddBtn())) {
                addDataJabatan();
            } else if (Evt.getSource().equals(getUpdateJabatanDialogView().getSaveBtn())) {
                editDataJabatan();
            } else if (Evt.getSource().equals(getUpdateJabatanDialogView().getDeleteBtn())) {
                deleteDataJabatan();
            }

        }
    };

    public MouseAdapter tableMouseAdapter = new MouseAdapter() {
    
    public void mouseReleased(MouseEvent Evt){
        if(Evt.getSource().equals(getUpdateJabatanDialogView().getTableJabatan())){
            tabelJabatanMouseReleased();
        }
    }
    
    };

//</editor-fold>
    
}
