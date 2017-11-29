/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

//<editor-fold defaultstate="collapsed" desc="Import">

import Models.JabatanEntityModel;
import Models.KaryawanEntityModel;
import Views.HomePanel;
import Views.LoginMenu;
import Views.OKDialog;
import Views.YesNoDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
//</editor-fold>

/**
 *
 * @author A F I F
 */

public class HomePanelController {
    
//<editor-fold defaultstate="collapsed" desc="Deklarasi Kelas, Objek, dan Variabel">
    
    private HomePanel homePanelView;
    private ImageIcon image;
    private YesNoDialog yesNoDialog;
    
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Constructor"> 
    public HomePanelController(HomePanel homePanelView) {
        this.homePanelView = homePanelView;
        yesNoDialog = new YesNoDialog();
    }   
//</editor-fold>
  
//<editor-fold defaultstate="collapsed" desc="Getter Setter">
    
    public HomePanel getHomePanelView() {
        return homePanelView;
    }
    
    public void setHomePanelView(HomePanel homePanelView) {
        this.homePanelView = homePanelView;
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
    
    private void tambahDataKarwayanPanelShow(ActionEvent evt) {
        resetForm();
        
        getHomePanelView().getUpdateKaryawanDialog().getAddBtn().setVisible(true);
        getHomePanelView().getUpdateKaryawanDialog().getResetBtn().setVisible(false);
        getHomePanelView().getUpdateKaryawanDialog().getDeleteBtn().setEnabled(false);
        getHomePanelView().getUpdateKaryawanDialog().getSaveBtn().setEnabled(false);
        
        getHomePanelView().getUpdateKaryawanDialog().setLocationRelativeTo(null);
        getHomePanelView().getUpdateKaryawanDialog().setVisible(true);
        
    }
    
    private void resetForm(){
        KaryawanEntityModel model = new KaryawanEntityModel();
        getHomePanelView().getUpdateKaryawanDialog().getIdKaryawanField().setText(model.genIdDataValue());
        getHomePanelView().getUpdateKaryawanDialog().getNameField().setText("");
        model.fillCboJenisKelamin(getHomePanelView().getUpdateKaryawanDialog().getCboJenisKelamin());
        getHomePanelView().getUpdateKaryawanDialog().getTempatLahirField().setText("");
        getHomePanelView().getUpdateKaryawanDialog().getTanggalLahirField().setText("");
        getHomePanelView().getUpdateKaryawanDialog().getAgamaField().setText("");
        model.getJabatan().fillCboJabatan(getHomePanelView().getUpdateKaryawanDialog().getCboJabatan());
        getHomePanelView().getUpdateKaryawanDialog().getKontakField().setText("");
        model.fillCboStatus(getHomePanelView().getUpdateKaryawanDialog().getCboStatus());
        getHomePanelView().getUpdateKaryawanDialog().getAlamatField().setText("");
    }
    
    private void editDataKaryawanPanelShow(ActionEvent Evt){
        String key = getHomePanelView().getSelectedValue();
        KaryawanEntityModel model = new KaryawanEntityModel(key, "","","","","","","","","").detailDataSet();
    
        getHomePanelView().getUpdateKaryawanDialog().getIdKaryawanField().setText(model.getIdKaryawan());
        getHomePanelView().getUpdateKaryawanDialog().getNameField().setText(model.getNamaKaryawan());
        getHomePanelView().getUpdateKaryawanDialog().getCboJenisKelamin().setSelectedItem(model.getJenisKelamin());
        getHomePanelView().getUpdateKaryawanDialog().getTempatLahirField().setText(model.getTempatLahir());
        getHomePanelView().getUpdateKaryawanDialog().getTanggalLahirField().setText(model.getTanggalLahir());
        getHomePanelView().getUpdateKaryawanDialog().getAgamaField().setText(model.getAgama());
        getHomePanelView().getUpdateKaryawanDialog().getCboJabatan().setSelectedItem(model.getJabatan().getNamaJabatan());
        getHomePanelView().getUpdateKaryawanDialog().getKontakField().setText(model.getKontak());
        getHomePanelView().getUpdateKaryawanDialog().getCboStatus().setSelectedItem(model.getStatus());
        getHomePanelView().getUpdateKaryawanDialog().getAlamatField().setText(model.getAlamat());
        
        getHomePanelView().getUpdateKaryawanDialog().getAddBtn().setVisible(false);
        getHomePanelView().getUpdateKaryawanDialog().getResetBtn().setVisible(true);
        getHomePanelView().getUpdateKaryawanDialog().getDeleteBtn().setEnabled(true);
        getHomePanelView().getUpdateKaryawanDialog().getSaveBtn().setEnabled(true);
        
        getHomePanelView().getUpdateKaryawanDialog().setLocationRelativeTo(null);
        getHomePanelView().getUpdateKaryawanDialog().setVisible(true);
        
    }
    
    private void tampilDaftarKaryawan(){
        resetForm();
        loadTable();
    }
    

    
    private void saveDataKaryawan() {
        if (isValidate()) {
            getYesNoDialog().setImage(new ImageIcon(getClass().getResource("/Pic/bgKonfirmasiDataBenar.png")));
            getYesNoDialog().getBgYesNoDialog().setIcon(getYesNoDialog().getImage());
            getYesNoDialog().setVisible(true);

            if (getYesNoDialog().getYes()) {
                KaryawanEntityModel model = new KaryawanEntityModel(
                        getHomePanelView().getIdKaryawanField().getText(),
                        getHomePanelView().getNameField().getText(),
                        getHomePanelView().getCboJenisKelamin().getSelectedItem().toString(),
                        getHomePanelView().getTempatLahirField().getText(),
                        getHomePanelView().getTanggalLahirField().getText(),
                        getHomePanelView().getAgamaField().getText(),
                        new JabatanEntityModel("", getHomePanelView().getJabatanField().getText(), "", "").detailDataSet().getIdJabatan(),
                        getHomePanelView().getStatusField().getText(),
                        getHomePanelView().getKontakField().getText(),
                        getHomePanelView().getAlamatField().getText());
                if (model.editDataValue()) {
                    setImage(new ImageIcon(getClass().getResource("/Pic/bgBerhasilDisimpanDialog.png")));
                    OKDialog OK = new OKDialog();
                    OK.getBgOKDialog().setIcon(getImage());
                    OK.setVisible(true);

                } else {
                    setImage(new ImageIcon(getClass().getResource("/Pic/bgErrorGagalTambahDialog.png")));
                    OKDialog OK = new OKDialog();
                    OK.getBgOKDialog().setIcon(getImage());
                    OK.setVisible(true);

                }
            }

        }

    }

    private boolean isValidate(){
        boolean flag;
        if(getHomePanelView().getNameField().getText().matches("")){
            setImage(new ImageIcon(getClass().getResource("/Pic/bgFormNamaKaryawanDialog.png")));
            OKDialog OK =new OKDialog();
            OK.getBgOKDialog().setIcon(getImage());
            OK.setVisible(true); 
            
            getHomePanelView().getNameField().requestFocus();
            flag = false;
        }else if(getHomePanelView().getCboJenisKelamin().getSelectedIndex()==0){
            setImage(new ImageIcon(getClass().getResource("/Pic/bgFormJKDialog.png")));
            OKDialog OK =new OKDialog();
            OK.getBgOKDialog().setIcon(getImage());
            OK.setVisible(true); 
            
            getHomePanelView().getCboJenisKelamin().requestFocus();
            flag = false;
        }else if(getHomePanelView().getTempatLahirField().getText().matches("")){
            setImage(new ImageIcon(getClass().getResource("/Pic/bgFormTempatLahirDialog.png")));
            OKDialog OK =new OKDialog();
            OK.getBgOKDialog().setIcon(getImage());
            OK.setVisible(true); 
            
            getHomePanelView().getTempatLahirField().requestFocus();
            flag = false;
        }else if(getHomePanelView().getTanggalLahirField().getText().matches("")){
            setImage(new ImageIcon(getClass().getResource("/Pic/bgFormTanggalLahirDialog.png")));
            OKDialog OK =new OKDialog();
            OK.getBgOKDialog().setIcon(getImage());
            OK.setVisible(true); 
            
            getHomePanelView().getTanggalLahirField().requestFocus();
            flag = false;
        }else if(!isDateValidate()){
            setImage(new ImageIcon(getClass().getResource("/Pic/bgFormatTglSalah.png")));
            OKDialog OK =new OKDialog();
            OK.getBgOKDialog().setIcon(getImage());
            OK.setVisible(true); 
            
            getHomePanelView().getTanggalLahirField().requestFocus();
            flag = false;
        }else if(getHomePanelView().getAgamaField().getText().matches("")){
            setImage(new ImageIcon(getClass().getResource("/Pic/bgFormAgamaDialog.png")));
            OKDialog OK =new OKDialog();
            OK.getBgOKDialog().setIcon(getImage());
            OK.setVisible(true); 
            
            getHomePanelView().getAgamaField().requestFocus();
            flag = false;
        }else if(getHomePanelView().getKontakField().getText().matches("")){
            setImage(new ImageIcon(getClass().getResource("/Pic/bgFormKontakDialog.png")));
            OKDialog OK =new OKDialog();
            OK.getBgOKDialog().setIcon(getImage());
            OK.setVisible(true); 
            
            getHomePanelView().getKontakField().requestFocus();
            flag = false;
        }else if(getHomePanelView().getAlamatField().getText().matches("")){
            setImage(new ImageIcon(getClass().getResource("/Pic/bgFormAlamatDialog.png")));
            OKDialog OK =new OKDialog();
            OK.getBgOKDialog().setIcon(getImage());
            OK.setVisible(true); 
            
            getHomePanelView().getAlamatField().requestFocus();
            flag = false;
        } else {
            flag = true;
        }
        return flag;
    }
    
    
    private void loadTable(){
        KaryawanEntityModel model = new KaryawanEntityModel("","","","","","","","","","");
    
        String[] Header = new String[]{"Id Karyawan","Nama","Jenis Kelamin", "Tempat Tanggal Lahir", "Jabatan"};
        DefaultTableModel Record = new DefaultTableModel(model.detailDataSet().getAllValue(), Header);
        int[] wCol = null;
        
        wCol = new int[]{195,170,100,150,150};
        getHomePanelView().getTableKaryawan().setModel(Record);
        initColumnRecord(getHomePanelView().getTableKaryawan(), wCol);
        System.out.println("rows : "+ getHomePanelView().getTableKaryawan().getRowCount());
        getHomePanelView().getTableKaryawan().addRowSelectionInterval(0, 0);
    }
    
    private void initColumnRecord(JTable table, int[]wCol){
        TableColumn col = null;
        int i = 0;
        for (i = table.getColumnCount() - 1; i > 0; i--) {
            col = table.getColumnModel().getColumn(i);
            col.setPreferredWidth(wCol[i]);
        }
    }
    
    private void tabelJabatanMouseReleassed() {
        getHomePanelView().setSelectedValue(getHomePanelView().getTableKaryawan().getValueAt(
                getHomePanelView().getTableKaryawan().getSelectedRow(), 0).toString());

        if (!getHomePanelView().getSelectedValue().isEmpty()) {
            getHomePanelView().getEditDataBtn().setEnabled(true);
            getHomePanelView().getTambahDataKaryawanBtn().setEnabled(false);

        }
    }

    private boolean isDateValidate() {
        String date = getHomePanelView().getTanggalLahirField().getText();
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
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Annonymous Code">
    public ComponentListener componentListener = new ComponentAdapter() {
        @Override
        public void componentShown(ComponentEvent Evt) {
            // tampilDaftarKaryawan(Evt);
            if (Evt.getComponent().equals(getHomePanelView().getDaftarKaryawan())) {
                tampilDaftarKaryawan();
            }
        }
    };

    
    public ActionListener buttonActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent Evt) {
            if (Evt.getSource().equals(getHomePanelView().getPerbaruiDataKaryawanBtn())
                    || Evt.getSource().equals(getHomePanelView().getTambahDataKaryawanBtn())) {
                tambahDataKarwayanPanelShow(Evt);
                loadTable();
            } else if (Evt.getSource().equals(getHomePanelView().getLihatDaftarKaryawanBtn())) {
                getHomePanelView().getHomePanel().setVisible(false);
                getHomePanelView().getDaftarKaryawan().setVisible(true);
                getHomePanelView().getEditDataBtn().setEnabled(false);
                getHomePanelView().getTambahDataKaryawanBtn().setEnabled(true);
            } else if (Evt.getSource().equals(getHomePanelView().getBackBtn())) {
                getHomePanelView().getHomePanel().setVisible(true);
                getHomePanelView().getDaftarKaryawan().setVisible(false);
                getHomePanelView().getDataKaryawan().setVisible(false);
            } else if (Evt.getSource().equals(getHomePanelView().getEditDataBtn())) {
                editDataKaryawanPanelShow(Evt);
                loadTable();
            } else if (Evt.getSource().equals(getHomePanelView().getLihatDataKaryawanBtn())) {
                getHomePanelView().getHomePanel().setVisible(false);
                getHomePanelView().getDataKaryawan().setVisible(true);
            } else if (Evt.getSource().equals(getHomePanelView().getSaveBtn())) {
                saveDataKaryawan();
            } else if (Evt.getSource().equals(getHomePanelView().getGetDateBtn())) {
                getHomePanelView().getTanggalLahirField().setText(getHomePanelView().getCalendar().getDateTime("dd-mm-yyyy"));
               
            }

        }
    };
    
    
    public MouseAdapter tableMouseAdapter = new MouseAdapter(){
        @Override
        public void mouseReleased(MouseEvent Evt){
            if(Evt.getSource().equals(getHomePanelView().getTableKaryawan())){
                tabelJabatanMouseReleassed();
            }
        }
    };
//</editor-fold>


}
