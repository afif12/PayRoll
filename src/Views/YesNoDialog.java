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
import java.awt.event.FocusAdapter;
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

public class YesNoDialog extends JDialog implements SettingViewInterface{

// <editor-fold defaultstate="collapsed" desc="Deklarasi Kelas, Objek, Variabel">
    
    private JPanel mainYesNoDialog;
    private JPanel moveDialog;
    private JLabel bgYesNoDialog;
    private JButton yesBtn;
    private JButton noBtn;
    private ImageIcon image;
    private boolean yes;
    private boolean no;
    private static Point point;
    
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="ExitDialog Construktor">
    public YesNoDialog() {
        super((Frame)null, "Exit Dialog", true);

        mainYesNoDialog=new JPanel();
        moveDialog=new JPanel();
        bgYesNoDialog = new JLabel();
        yesBtn = new JButton();
        noBtn = new JButton();
        point = new Point();
        yes = false;
        no = false;

        initComponents();
    }// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="Getter Setter">
    public JLabel getBgYesNoDialog() {
        return bgYesNoDialog;
    }

    public void setBgYesNoDialog(JLabel bgYesNoDialog) {
        this.bgYesNoDialog = bgYesNoDialog;
    }

    public ImageIcon getImage() {
        return image;
    }

    public void setImage(ImageIcon image) {
        this.image = image;
    }

    public JPanel getMainYesNoDialog() {
        return mainYesNoDialog;
    }

    public void setMainYesNoDialog(JPanel mainYesNoDialog) {
        this.mainYesNoDialog = mainYesNoDialog;
    }


    public JButton getNoBtn() {
        return noBtn;
    }

    public void setNoBtn(JButton noBtn) {
        this.noBtn = noBtn;
    }

    public static Point getPoint() {
        return point;
    }

    public static void setPoint(Point point) {
        YesNoDialog.point = point;
    }

    public boolean getYes() {
        return yes;
    }

    public void setYes(boolean yes) {
        this.yes = yes;
    }

    public JButton getYesBtn() {
        return yesBtn;
    }

    public void setYesBtn(JButton yesBtn) {
        this.yesBtn = yesBtn;
    }

    public boolean getNo() {
        return no;
    }

    public void setNo(boolean no) {
        this.no = no;
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
        this.getRootPane().setDefaultButton(getYesBtn());
        getYesBtn().requestDefaultFocus();
        
        getMainYesNoDialog().setLayout(null);
        getMainYesNoDialog().setOpaque(false);
        getMainYesNoDialog().setBounds(0, 0, 400, 250);
        this.add(getMainYesNoDialog());
        
        getMoveDialog().setLayout(null);
        getMoveDialog().setOpaque(false);
        getMoveDialog().setBounds(0,0,400,34);
        getMainYesNoDialog().add(getMoveDialog());

        getYesBtn().setOpaque(false);
        getYesBtn().setBorder(null);
        getYesBtn().setBounds(133, 200, 125, 40);
        getMainYesNoDialog().add(getYesBtn());

        getNoBtn().setOpaque(false);
        getNoBtn().setBorder(null);

        getNoBtn().setBounds(266, 200, 125, 40);
        getMainYesNoDialog().add(getNoBtn());

        getBgYesNoDialog().setOpaque(true);
        getBgYesNoDialog().setBounds(0, 0, 400, 250);
        getMainYesNoDialog().add(getBgYesNoDialog());

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

        getYesBtn().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                setYes(true);
                setNo(false);
                dispose();
                
            }
        });
        
        getNoBtn().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                setNo(true);
                setYes(false);
                dispose();
            }
        });

    }

    public void imageControl() {
        setImage(new ImageIcon(getClass().getResource("/Pic/bgExitDialog.png")));
        getBgYesNoDialog().setIcon(getImage());

        setImage(new ImageIcon(getClass().getResource("/Pic/yesBtn.png")));
        getYesBtn().setIcon(getImage());
        setImage(new ImageIcon(getClass().getResource("/Pic/yesBtn1.png")));
        getYesBtn().setRolloverIcon(getImage());
        setImage(new ImageIcon(getClass().getResource("/Pic/yesBtn2.png")));
        getYesBtn().setPressedIcon(getImage());

        setImage(new ImageIcon(getClass().getResource("/Pic/noBtn.png")));
        getNoBtn().setIcon(getImage());
        setImage(new ImageIcon(getClass().getResource("/Pic/noBtn1.png")));
        getNoBtn().setRolloverIcon(getImage());
        getNoBtn().setSelectedIcon(getImage());
        setImage(new ImageIcon(getClass().getResource("/Pic/noBtn2.png")));
        getNoBtn().setPressedIcon(getImage());


    }// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="Method Untuk Menggeser ExitDialog ">
    public void formMousePressed(MouseEvent evt) {

        getPoint().x = evt.getX();
        getPoint().y = evt.getY();
    }
    public void formMouseDragged(MouseEvent evt) {

        Point p = this.getLocation();
        this.setLocation(p.x + evt.getX() - getPoint().x, p.y + evt.getY() - getPoint().y);
    }// </editor-fold>

}
