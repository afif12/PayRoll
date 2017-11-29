/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controllers;

//<editor-fold defaultstate="collapsed" desc="Import">
import Models.JabatanEntityModel;
import Models.KaryawanEntityModel;
import Views.OKDialog;
import Views.UpdateKaryawanDialog;
import Views.YesNoDialog;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
public class UpdateKaryawanDialogController {
    
//<editor-fold defaultstate="collapsed" desc="Deklarasi Kelas, Objek, dan Variabel">
 
    private UpdateKaryawanDialog updateKaryawanDialogView;
    private Point point;
    private ImageIcon image;
    private YesNoDialog yesNoDialog;
    
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Contructor">
    
    public UpdateKaryawanDialogController(UpdateKaryawanDialog updateKaryawanDialogView) {
        this.updateKaryawanDialogView = updateKaryawanDialogView;
        yesNoDialog = new YesNoDialog();
    
    }
    
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Getter Setter">
    
    public UpdateKaryawanDialog getUpdateKaryawanDialogView() {
        return updateKaryawanDialogView;
    }
    
    public void setUpdateKaryawanDialogView(UpdateKaryawanDialog updateKaryawanDialogView) {
        this.updateKaryawanDialogView = updateKaryawanDialogView;
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
    
// <editor-fold defaultstate="collapsed" desc="Method Untuk Menggeser Panel Login">
    public void formMousePressed(MouseEvent Evt) {
        
        getUpdateKaryawanDialogView().getPoint().x = Evt.getX();
        getUpdateKaryawanDialogView().getPoint().y = Evt.getY();
    }
    
    public void formMouseDragged(MouseEvent Evt) {
        
        Point p = getUpdateKaryawanDialogView().getLocation();
        getUpdateKaryawanDialogView().setLocation(p.x + Evt.getX() - getUpdateKaryawanDialogView().getPoint().x, p.y + Evt.getY() - getUpdateKaryawanDialogView().getPoint().y);
    }

//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Table Mouse Released">
    private void tabelKaryawanMouseReleased() {
        getUpdateKaryawanDialogView().setSelectedValue(getUpdateKaryawanDialogView().getTableKaryawan().getValueAt(
                getUpdateKaryawanDialogView().getTableKaryawan().getSelectedRow(), 0).toString());
        
        System.out.println(getUpdateKaryawanDialogView().getSelectedValue());
        if(!getUpdateKaryawanDialogView().getSelectedValue().isEmpty()){
            String key = getUpdateKaryawanDialogView().getSelectedValue();
            KaryawanEntityModel model = new KaryawanEntityModel(key,"","","","","","","","","").detailDataSet();
            
            getUpdateKaryawanDialogView().getIdKaryawanField().setText(model.getIdKaryawan());
            getUpdateKaryawanDialogView().getNameField().setText(model.getNamaKaryawan());
            getUpdateKaryawanDialogView().getCboJenisKelamin().setSelectedItem(model.getJenisKelamin());
            getUpdateKaryawanDialogView().getTempatLahirField().setText(model.getTempatLahir());
            getUpdateKaryawanDialogView().getTanggalLahirField().setText(model.getTanggalLahir());
            getUpdateKaryawanDialogView().getAgamaField().setText(model.getAgama());
            getUpdateKaryawanDialogView().getCboJabatan().setSelectedItem(model.getJabatan().getNamaJabatan());
            getUpdateKaryawanDialogView().getKontakField().setText(model.getKontak());
            getUpdateKaryawanDialogView().getCboStatus().setSelectedItem(model.getStatus());
            getUpdateKaryawanDialogView().getAlamatField().setText(model.getAlamat());
            
            getUpdateKaryawanDialogView().getAddBtn().setVisible(false);
            getUpdateKaryawanDialogView().getResetBtn().setVisible(true);
            getUpdateKaryawanDialogView().getDeleteBtn().setEnabled(true);
            getUpdateKaryawanDialogView().getSaveBtn().setEnabled(true);
            
        }
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Show Table Method">
    private void tampilDaftarKaryawan(ComponentEvent Evt){
        loadTable();
    }
//</editor-fold>
    
//<editor-fold defaultstate="collapsed" desc="Load Data to Table Method">
    
    private void loadTable(){
        KaryawanEntityModel model = new KaryawanEntityModel("","","","","","","","","","");
        
        String[] Header = new String[]{"Id Karyawan", "Nama", "Jenis Kelamin", "Tempat Tanggal Lahir", "Jabatan"};
        DefaultTableModel Record = new DefaultTableModel(model.detailDataSet().getAllValue(), Header);
        int[] wCol = null;
        
        wCol = new int[]{195, 170, 100, 150, 150};
        getUpdateKaryawanDialogView().getTableKaryawan().setModel(Record);
        initColumnRecord(getUpdateKaryawanDialogView().getTableKaryawan(), wCol);
        System.out.println("rows : " + getUpdateKaryawanDialogView().getTableKaryawan().getRowCount());
        getUpdateKaryawanDialogView().getTableKaryawan().addRowSelectionInterval(0, 0);
        
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
    private boolean isValidate(){
        boolean flag;
        if(getUpdateKaryawanDialogView().getNameField().getText().matches("")){
            setImage(new ImageIcon(getClass().getResource("/Pic/bgFormNamaKaryawanDialog.png")));
            OKDialog OK =new OKDialog();
            OK.getBgOKDialog().setIcon(getImage());
            OK.setVisible(true);    
            
            getUpdateKaryawanDialogView().getNameField().requestFocus();
            flag = false;
        }else if(getUpdateKaryawanDialogView().getCboJenisKelamin().getSelectedIndex()==0){
            setImage(new ImageIcon(getClass().getResource("/Pic/bgFormJKDialog.png")));
            OKDialog OK =new OKDialog();
            OK.getBgOKDialog().setIcon(getImage());
            OK.setVisible(true); 
            
            getUpdateKaryawanDialogView().getCboJenisKelamin().requestFocus();
            flag = false;
        }else if(getUpdateKaryawanDialogView().getTempatLahirField().getText().matches("")){
            setImage(new ImageIcon(getClass().getResource("/Pic/bgFormTempatLahirDialog.png")));
            OKDialog OK =new OKDialog();
            OK.getBgOKDialog().setIcon(getImage());
            OK.setVisible(true); 
            
            getUpdateKaryawanDialogView().getTempatLahirField().requestFocus();
            flag = false;
        }else if(getUpdateKaryawanDialogView().getTanggalLahirField().getText().matches("")){
            setImage(new ImageIcon(getClass().getResource("/Pic/bgFormTanggalLahirDialog.png")));
            OKDialog OK =new OKDialog();
            OK.getBgOKDialog().setIcon(getImage());
            OK.setVisible(true); 
            
            getUpdateKaryawanDialogView().getTanggalLahirField().requestFocus();
            flag = false;
        }else if(!isDateValidate()){
            setImage(new ImageIcon(getClass().getResource("/Pic/bgFormatTglSalah.png")));
            OKDialog OK =new OKDialog();
            OK.getBgOKDialog().setIcon(getImage());
            OK.setVisible(true); 
            
            getUpdateKaryawanDialogView().getTanggalLahirField().requestFocus();
            flag = false;
        }else if(getUpdateKaryawanDialogView().getAgamaField().getText().matches("")){
            setImage(new ImageIcon(getClass().getResource("/Pic/bgFormAgamaDialog.png")));
            OKDialog OK =new OKDialog();
            OK.getBgOKDialog().setIcon(getImage());
            OK.setVisible(true); 
            
            getUpdateKaryawanDialogView().getAgamaField().requestFocus();
            flag = false;
        }else if(getUpdateKaryawanDialogView().getCboJabatan().getSelectedIndex()==0){
            setImage(new ImageIcon(getClass().getResource("/Pic/bgFormPilihJabatanDialog.png")));
            OKDialog OK =new OKDialog();
            OK.getBgOKDialog().setIcon(getImage());
            OK.setVisible(true); 
            
            getUpdateKaryawanDialogView().getCboJabatan().requestFocus();
            flag = false;
        }else if(getUpdateKaryawanDialogView().getKontakField().getText().matches("")){
            setImage(new ImageIcon(getClass().getResource("/Pic/bgFormKontakDialog.png")));
            OKDialog OK =new OKDialog();
            OK.getBgOKDialog().setIcon(getImage());
            OK.setVisible(true); 
            
            getUpdateKaryawanDialogView().getKontakField().requestFocus();
            flag = false;
        }else if(getUpdateKaryawanDialogView().getCboStatus().getSelectedIndex()==0){
            setImage(new ImageIcon(getClass().getResource("/Pic/bgFormStatusDialog.png")));
            OKDialog OK =new OKDialog();
            OK.getBgOKDialog().setIcon(getImage());
            OK.setVisible(true); 
            
            getUpdateKaryawanDialogView().getCboStatus().requestFocus();
            flag = false;
        }else if(getUpdateKaryawanDialogView().getAlamatField().getText().matches("")){
            setImage(new ImageIcon(getClass().getResource("/Pic/bgFormAlamatDialog.png")));
            OKDialog OK =new OKDialog();
            OK.getBgOKDialog().setIcon(getImage());
            OK.setVisible(true); 
            
            getUpdateKaryawanDialogView().getAlamatField().requestFocus();
            flag = false;
        } else {
            flag = true;
        }
        return flag;
    }
    
//</editor-fold>
    
    public boolean isDateValidate() {
        String date = getUpdateKaryawanDialogView().getTanggalLahirField().getText();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date testDate = null;

        try {
            testDate = sdf.parse(date);
        } catch (ParseException e) {
            return false;
        }
        if (!sdf.format(testDate).equals(date)) {
            return false;
        } else {
            return true;
        }

    }

    
//<editor-fold defaultstate="collapsed" desc="CRUD Method">
    
    private void editDataKaryawan(){
        if (isValidate()) {
            KaryawanEntityModel model = new KaryawanEntityModel(
                    getUpdateKaryawanDialogView().getIdKaryawanField().getText(),
                    getUpdateKaryawanDialogView().getNameField().getText(),
                    getUpdateKaryawanDialogView().getCboJenisKelamin().getSelectedItem().toString(),
                    getUpdateKaryawanDialogView().getTempatLahirField().getText(),
                    getUpdateKaryawanDialogView().getTanggalLahirField().getText(),
                    getUpdateKaryawanDialogView().getAgamaField().getText(),
                    new JabatanEntityModel("", getUpdateKaryawanDialogView().getCboJabatan().getSelectedItem().toString(), "", "").detailDataSet().getIdJabatan(),
                    getUpdateKaryawanDialogView().getCboStatus().getSelectedItem().toString(),
                    getUpdateKaryawanDialogView().getKontakField().getText(),
                    getUpdateKaryawanDialogView().getAlamatField().getText());
            if (model.editDataValue()) {
                setImage(new ImageIcon(getClass().getResource("/Pic/bgBerhasilDisimpanDialog.png")));
                OKDialog OK = new OKDialog();
                OK.getBgOKDialog().setIcon(getImage());
                OK.setVisible(true);

                loadTable();
                resetFieldAndButton();
            } else {
                setImage(new ImageIcon(getClass().getResource("/Pic/bgErrorGagalSimpanDialog.png")));
                OKDialog OK = new OKDialog();
                OK.getBgOKDialog().setIcon(getImage());
                OK.setVisible(true);
                
                loadTable();
                resetFieldAndButton();
            }
            
        }
    }
    
    private void addDataKaryawan(){
        if(isValidate()){
            KaryawanEntityModel model = new KaryawanEntityModel(
                    getUpdateKaryawanDialogView().getIdKaryawanField().getText(),
                    getUpdateKaryawanDialogView().getNameField().getText(),
                    getUpdateKaryawanDialogView().getCboJenisKelamin().getSelectedItem().toString(),
                    getUpdateKaryawanDialogView().getTempatLahirField().getText(),
                    getUpdateKaryawanDialogView().getTanggalLahirField().getText(),
                    getUpdateKaryawanDialogView().getAgamaField().getText(),
                    new JabatanEntityModel("", getUpdateKaryawanDialogView().getCboJabatan().getSelectedItem().toString(), "", "").detailDataSet().getIdJabatan(),
                    getUpdateKaryawanDialogView().getCboStatus().getSelectedItem().toString(),
                    getUpdateKaryawanDialogView().getKontakField().getText(), 
                    getUpdateKaryawanDialogView().getAlamatField().getText());
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
    
    private void deleteDataKaryawan() {
    
        if (getUpdateKaryawanDialogView().getIdKaryawanField().getText().equals(getUpdateKaryawanDialogView().getLoginAs())) {
            setImage(new ImageIcon(getClass().getResource("/Pic/bgPenghapusanTidakDibolehkan.png")));
            OKDialog OK =new OKDialog();
            OK.getBgOKDialog().setIcon(getImage());
            OK.setVisible(true); 
        } else {

            setImage(new ImageIcon(getClass().getResource("/Pic/bgHapusDialog.png")));
            getYesNoDialog().getBgYesNoDialog().setIcon(getImage());
            getYesNoDialog().setVisible(true);

            if (getYesNoDialog().getYes()) {
                if (isValidate()) {
                    KaryawanEntityModel model = new KaryawanEntityModel(
                            getUpdateKaryawanDialogView().getIdKaryawanField().getText(),
                            getUpdateKaryawanDialogView().getNameField().getText(),
                            getUpdateKaryawanDialogView().getCboJenisKelamin().getSelectedItem().toString(),
                            getUpdateKaryawanDialogView().getTempatLahirField().getText(),
                            getUpdateKaryawanDialogView().getTanggalLahirField().getText(),
                            getUpdateKaryawanDialogView().getAgamaField().getText(),
                            new JabatanEntityModel("", getUpdateKaryawanDialogView().getCboJabatan().getSelectedItem().toString(), "", "").detailDataSet().getIdJabatan(),
                            getUpdateKaryawanDialogView().getCboStatus().getSelectedItem().toString(),
                            getUpdateKaryawanDialogView().getKontakField().getText(),
                            getUpdateKaryawanDialogView().getAlamatField().getText());
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
        KaryawanEntityModel model = new KaryawanEntityModel();
        
        getUpdateKaryawanDialogView().getIdKaryawanField().setText(model.genIdDataValue());
        getUpdateKaryawanDialogView().getNameField().setText("");
        model.fillCboJenisKelamin(getUpdateKaryawanDialogView().getCboJenisKelamin());
        getUpdateKaryawanDialogView().getTempatLahirField().setText("");
        getUpdateKaryawanDialogView().getTanggalLahirField().setText("");
        getUpdateKaryawanDialogView().getAgamaField().setText("");
        model.getJabatan().fillCboJabatan(getUpdateKaryawanDialogView().getCboJabatan());
        getUpdateKaryawanDialogView().getKontakField().setText("");
        model.fillCboStatus(getUpdateKaryawanDialogView().getCboStatus());
        getUpdateKaryawanDialogView().getAlamatField().setText("");
        
        getUpdateKaryawanDialogView().getAddBtn().setVisible(true);
        getUpdateKaryawanDialogView().getResetBtn().setVisible(false);
        getUpdateKaryawanDialogView().getDeleteBtn().setEnabled(false);
        getUpdateKaryawanDialogView().getSaveBtn().setEnabled(false);
    }
    
//</editor-fold>
     
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Annonymous Code">
    public ComponentAdapter componentListener = new ComponentAdapter(){
        
        @Override
        public void componentShown(ComponentEvent Evt){
        tampilDaftarKaryawan(Evt);
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
            if (Evt.getSource().equals(getUpdateKaryawanDialogView().getBackBtn())) {
                 //getUpdateKaryawanDialogView().setVisible(false);
                 getUpdateKaryawanDialogView().dispose();
            }else if(Evt.getSource().equals(getUpdateKaryawanDialogView().getGetDateBtn())){
                 getUpdateKaryawanDialogView().getTanggalLahirField().setText(getUpdateKaryawanDialogView().getCalendar().getDateTime("dd-mm-yyyy"));
            }else if (Evt.getSource().equals(getUpdateKaryawanDialogView().getResetBtn())) {
                resetFieldAndButton();
            } else if (Evt.getSource().equals(getUpdateKaryawanDialogView().getAddBtn())) {
                addDataKaryawan();
            } else if (Evt.getSource().equals(getUpdateKaryawanDialogView().getSaveBtn())) {
                editDataKaryawan();
            } else if (Evt.getSource().equals(getUpdateKaryawanDialogView().getDeleteBtn())) {
                deleteDataKaryawan();
            }

        }
    };
    
    public MouseAdapter tableMouseAdapter = new MouseAdapter() {
        public void mouseReleased(MouseEvent Evt){
            if(Evt.getSource().equals(getUpdateKaryawanDialogView().getTableKaryawan())){
                tabelKaryawanMouseReleased();
            }
        }
    };
//</editor-fold>


 
}
