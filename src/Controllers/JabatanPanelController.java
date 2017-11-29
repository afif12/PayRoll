/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

//<editor-fold defaultstate="collapsed" desc="Import">
import Connection.ConnectionDB;
import Models.JabatanEntityModel;
import Views.JabatanPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
//</editor-fold>

/**
 *
 * @author A F I F
 */
public class JabatanPanelController {

//<editor-fold defaultstate="collapsed" desc="Deklarasi Kelas, Objek, dan Variabel">
    private JabatanPanel jabatanPanelView;
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Constructor">
    public JabatanPanelController(JabatanPanel jabatanPanelView) {
        this.jabatanPanelView = jabatanPanelView;
    }

//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Getter Setter">
    public JabatanPanel getJabatanPanelView() {
        return jabatanPanelView;
    }

    public void setJabatanPanelView(JabatanPanel jabatanPanelView) {
        this.jabatanPanelView = jabatanPanelView;
    }

//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Method Code">
    private void tambahDataJabatanPanelShow(ActionEvent Evt) {
        JabatanEntityModel model = new JabatanEntityModel();
        getJabatanPanelView().getUpdateJabatanDialog().getIdJabatanField().setText(model.genIdDataValue());
        getJabatanPanelView().getUpdateJabatanDialog().getJabatanField().setText("");
        getJabatanPanelView().getUpdateJabatanDialog().getGajiPokokField().setText("");
        getJabatanPanelView().getUpdateJabatanDialog().getDeskripsiField().setText("");
      
        getJabatanPanelView().getUpdateJabatanDialog().getAddBtn().setVisible(true);
        getJabatanPanelView().getUpdateJabatanDialog().getResetBtn().setVisible(false);
        getJabatanPanelView().getUpdateJabatanDialog().getDeleteBtn().setEnabled(false);
        getJabatanPanelView().getUpdateJabatanDialog().getSaveBtn().setEnabled(false);
        
        getJabatanPanelView().getUpdateJabatanDialog().setLocationRelativeTo(null);
        getJabatanPanelView().getUpdateJabatanDialog().setVisible(true);

    }

    private void editDataJabatanPanelShow(ActionEvent Evt) {
        String key = getJabatanPanelView().getSelectedValue();
        JabatanEntityModel model = new JabatanEntityModel(key, "", "", "").detailDataSet();

        getJabatanPanelView().getUpdateJabatanDialog().getIdJabatanField().setText(model.getIdJabatan());
        getJabatanPanelView().getUpdateJabatanDialog().getJabatanField().setText(model.getNamaJabatan());
        getJabatanPanelView().getUpdateJabatanDialog().getGajiPokokField().setText(model.getGajiPokok());
        getJabatanPanelView().getUpdateJabatanDialog().getDeskripsiField().setText(model.getDeskripsi());

        getJabatanPanelView().getUpdateJabatanDialog().getAddBtn().setVisible(false);
        getJabatanPanelView().getUpdateJabatanDialog().getResetBtn().setVisible(true);
        getJabatanPanelView().getUpdateJabatanDialog().getDeleteBtn().setEnabled(true);
        getJabatanPanelView().getUpdateJabatanDialog().getSaveBtn().setEnabled(true);

        getJabatanPanelView().getUpdateJabatanDialog().setLocationRelativeTo(null);
        getJabatanPanelView().getUpdateJabatanDialog().setVisible(true);

    }

    private void tampilDaftarJabatan(ComponentEvent Evt) {
        loadTable();
    }

    private void loadTable() {
        JabatanEntityModel model = new JabatanEntityModel("", "", "", "");

        String[] Header = new String[]{"Id Jabatan", "Nama Jabatan", "Gaji Pokok", "Deskripsi"};
        DefaultTableModel Record = new DefaultTableModel(model.detailDataSet().getAllValue(), Header);
        int[] wCol = null;

        wCol = new int[]{160, 130, 100, 450};
        getJabatanPanelView().getTableJabatan().setModel(Record);
        initColumnRecord(getJabatanPanelView().getTableJabatan(), wCol);
        System.out.println("rows : " + getJabatanPanelView().getTableJabatan().getRowCount());
        getJabatanPanelView().getTableJabatan().addRowSelectionInterval(0, 0);

    }

    private void initColumnRecord(JTable table, int[] wCol) {
        TableColumn col = null;
        int i = 0;
        for (i = table.getColumnCount() - 1; i > 0; i--) {
            col = table.getColumnModel().getColumn(i);
            col.setPreferredWidth(wCol[i]);
        }
    }

    private void tabelJabatanMouseReleassed(){
        String Value = null;
        
        getJabatanPanelView().setSelectedValue(getJabatanPanelView().getTableJabatan().getValueAt(
        getJabatanPanelView().getTableJabatan().getSelectedRow(), 0).toString());
        
       if(!getJabatanPanelView().getSelectedValue().isEmpty()){
            getJabatanPanelView().getEditDataBtn().setEnabled(true);
            getJabatanPanelView().getTambahDataJabatanBtn().setEnabled(false);
            
        }
    }

//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Annonymous Code">
    public ComponentListener componentListener = new ComponentAdapter() {
        @Override
        public void componentShown(ComponentEvent Evt) {
            tampilDaftarJabatan(Evt);
        }
    };

    public ActionListener buttonActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent Evt) {
            if (Evt.getSource().equals(getJabatanPanelView().getPerbaruiDataJabatanBtn())
                    || Evt.getSource().equals(getJabatanPanelView().getTambahDataJabatanBtn())) {
                tambahDataJabatanPanelShow(Evt);
                loadTable();
            } else if (Evt.getSource().equals(getJabatanPanelView().getLihatDataJabatanBtn())) {
                getJabatanPanelView().getJabatanPanel().setVisible(false);
                getJabatanPanelView().getDaftarJabatan().setVisible(true);
                getJabatanPanelView().getEditDataBtn().setEnabled(false);
                getJabatanPanelView().getTambahDataJabatanBtn().setEnabled(true);
            } else if (Evt.getSource().equals(getJabatanPanelView().getBackBtn())) {
                getJabatanPanelView().getJabatanPanel().setVisible(true);
                getJabatanPanelView().getDaftarJabatan().setVisible(false);
            } else if (Evt.getSource().equals(getJabatanPanelView().getEditDataBtn())) {
                editDataJabatanPanelShow(Evt);
                loadTable();
            } 

        }
    };
    
    public MouseAdapter tableMouseAdapter = new MouseAdapter() {

        @Override
        public void mouseReleased(MouseEvent Evt) {
            if (Evt.getSource().equals(getJabatanPanelView().getTableJabatan())) {
                tabelJabatanMouseReleassed();
            }
        }

    };

//</editor-fold>

}
