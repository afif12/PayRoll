/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author A F I F
 */
public class SimpleDigitalClock extends JPanel {

    String stringWaktu;
    int jam, menit, detik;
    String correctionjam = "";
    String correctionmenit = "";
    String correctiondetik = "";
    
    
    public void setstringWaktu(String stringWaktu) {
        this.stringWaktu = stringWaktu;
    }

    SimpleDigitalClock() {
        this.setBackground(new Color(61, 61, 61));
        Timer t1 = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        });
        t1.start();
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        Calendar now = Calendar.getInstance();
        jam = now.get(Calendar.HOUR_OF_DAY);
        menit = now.get(Calendar.MINUTE);
        detik = now.get(Calendar.SECOND);

        if (jam < 10) {
            this.correctionjam = "0";
        }
        if (jam >= 10) {
            this.correctionjam = "";
        }

        if (menit < 10) {
            this.correctionmenit = "0";
        }
        if (menit >= 10) {
            this.correctionmenit = "";
        }

        if (detik < 10) {
            this.correctiondetik = "0";
        }
        if (detik >= 10) {
            this.correctiondetik = "";
        }
        setstringWaktu(correctionjam + jam + ":" + correctionmenit + menit + ":" + correctiondetik + detik);
        g.setColor(new Color(0, 240, 225));

        Font myFont = new Font("century gothic", Font.PLAIN, 35);
        g.setFont(myFont);

        FontMetrics fmtrc = g.getFontMetrics();
        int pjg = fmtrc.stringWidth(stringWaktu);

        int x = (getWidth() / 2) - (pjg / 2);

        // g.drawString(stringWaktu, (int) length/6, length/2);
        // g.drawString(stringWaktu, (int) 19, 45);
        g.drawString(stringWaktu, x, 43);

    }
}
