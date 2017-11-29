/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

// <editor-fold defaultstate="collapsed" desc="Import Kelas dan Objek yg diperlukan">
import Interface.SettingViewInterface;
import static Views.MainMenu.getPoint;
import java.awt.Frame;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;// </editor-fold>

/**
 *
 * @author A F I F
 */

public class OKDialog extends JDialog implements SettingViewInterface {

// <editor-fold defaultstate="collapsed" desc="Deklarasi Kelas, Objek, dan Variabel">
    private JPanel mainOKDialog;
    private JPanel moveDialog;
    private JLabel bgOKDialog;
    private JButton okBtn;
    private ImageIcon image;
    private boolean ok;
    private static Point point;// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="Constructor">
    public OKDialog() {
        super((Frame)null, "Exit Dialog", true);

       
        mainOKDialog = new JPanel();
        moveDialog = new JPanel();
        bgOKDialog = new JLabel();
        okBtn = new JButton();
        point = new Point();
        ok = false;
       

        initComponents();
    }// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="Getter Setter">
    public JLabel getBgOKDialog() {
        return bgOKDialog;
    }

    public void setBgOKDialog(JLabel bgOKDialog) {
        this.bgOKDialog = bgOKDialog;
    }

    public ImageIcon getImage() {
        return image;
    }

    public void setImage(ImageIcon image) {
        this.image = image;
    }

    public JPanel getMainOKDialog() {
        return mainOKDialog;
    }

    public void setMainOKDialog(JPanel mainOKDialog) {
        this.mainOKDialog = mainOKDialog;
    }


    public static Point getPoint() {
        return point;
    }

    public static void setPoint(Point point) {
        OKDialog.point = point;
    }

    public boolean getYes() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public JButton getOkBtn() {
        return okBtn;
    }

    public void setOkBtn(JButton okBtn) {
        this.okBtn = okBtn;
    }


    public JPanel getMoveDialog() {
        return moveDialog;
    }

    public void setMoveDialog(JPanel moveDialog) {
        this.moveDialog = moveDialog;
    }
    // </editor-fold>
    
// <editor-fold defaultstate="collapsed" desc="initComponets() Method">
    private void initComponents() {
        this.setSize(400, 250);
        this.setLocationRelativeTo(null);
        this.setUndecorated(true);
        this.setAutoRequestFocus(true);
        this.setAlwaysOnTop(true);
        getRootPane().setDefaultButton(okBtn);

        getMainOKDialog().setLayout(null);
        getMainOKDialog().setOpaque(false);
        getMainOKDialog().setBounds(0, 0, 400, 250);
        this.add(getMainOKDialog());
        
        getMoveDialog().setLayout(null);
        getMoveDialog().setOpaque(false);
        getMoveDialog().setBounds(0,0,400,34);
        getMainOKDialog().add(getMoveDialog());

        getOkBtn().setOpaque(false);
        getOkBtn().setBorder(null);
        getOkBtn().setBounds(137, 176, 125, 40);
        getMainOKDialog().add(getOkBtn());

        getBgOKDialog().setOpaque(true);
        getBgOKDialog().setBounds(0, 0, 400, 250);
        getMainOKDialog().add(getBgOKDialog());

        eventControl();
        imageControl();

    }// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="eventControl()& imageControl() Methode">
    public void eventControl() {

        getMoveDialog().addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        getMoveDialog().addMouseMotionListener(new MouseMotionAdapter() {

            @Override
            public void mouseDragged(MouseEvent evt) {
                formMouseDragged(evt);

            }
        });

        getOkBtn().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                setOk(true);
                dispose();

            }
        });
/*
        this.addKeyListener(new KeyAdapter() {
            
            @Override
            public void keyReleased(KeyEvent KE){
                if(KE.getKeyCode() == KeyEvent.VK_ENTER){
                    getOkBtn().doClick();
                }
            }
        }); */
    } 

    public void imageControl() {
        setImage(new ImageIcon(getClass().getResource("/Pic/bgExitDialog.png")));
        getBgOKDialog().setIcon(getImage());

        setImage(new ImageIcon(getClass().getResource("/Pic/okBtn.png")));
        getOkBtn().setIcon(getImage());
        
        setImage(new ImageIcon(getClass().getResource("/Pic/okBtn1.png")));
        getOkBtn().setRolloverIcon(getImage());
        
        setImage(new ImageIcon(getClass().getResource("/Pic/okBtn2.png")));
        getOkBtn().setPressedIcon(getImage());



    }// </editor-fold>

//<editor-fold defaultstate="collapsed" desc="Method Code">
    
// <editor-fold defaultstate="collapsed" desc="Method Untuk Menggeser ExitDialog ">
    public void formMousePressed(MouseEvent evt) {
        
        getPoint().x = evt.getX();
        getPoint().y = evt.getY();
    }
    public void formMouseDragged(MouseEvent evt) {
        
        Point p = this.getLocation();
        this.setLocation(p.x + evt.getX() - getPoint().x, p.y + evt.getY() - getPoint().y);
    }// </editor-fold>
    
    
//</editor-fold>
  
}
