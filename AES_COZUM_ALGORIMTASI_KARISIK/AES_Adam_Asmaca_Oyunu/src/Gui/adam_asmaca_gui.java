package Gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Locale;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class adam_asmaca_gui extends JPanel {

    int yanlis_harf_sayisi = 0;
    JPanel jp = null;
    //JTextField asma_alt_cizgi = null;

    JLabel asma_alt_cizgi = null;
    JLabel asma_orta_cizgi = null;
    JLabel asma_ust_cizgi = null;
    JLabel asma_adam_kafasi = null;
    JLabel asma_adam_sag_kol = null;
    JLabel asma_adam_sol_kol = null;
    JLabel asma_adam_sag_bacak = null;
    JLabel asma_adam_sol_bacak = null;


    /*public JTextField getAsma_alt_cizgi() {
        if (asma_alt_cizgi == null) {
            asma_alt_cizgi = new JTextField();

            asma_alt_cizgi.setBackground(Color.blue);
            JTextField.setDefaultLocale(Locale.UK);
            asma_alt_cizgi.setText("");
            asma_alt_cizgi.setForeground(Color.BLACK);
            Font f = new Font("Serif", Font.ITALIC, 14);
            asma_alt_cizgi.setFont(f);
            asma_alt_cizgi.setBounds(100, 100, 100, 100);

        }
        return asma_alt_cizgi;
    }*/
    public JLabel getAsma_alt_cizgi() {
        if (asma_alt_cizgi == null) {
            asma_alt_cizgi = new JLabel("");
            //JLabel.setDefaultLocale(Locale.UK);
            asma_alt_cizgi.setForeground(Color.blue);
            asma_alt_cizgi.setText("asdfasfdasfasdf");

        }
        return asma_alt_cizgi;
    }

    public void setAsma_alt_cizgi(JLabel asma_alt_cizgi) {
        this.asma_alt_cizgi = asma_alt_cizgi;
    }

    /*public JTextField getAsma_alt_cizgi() {
        if (asma_alt_cizgi == null) {
            asma_alt_cizgi = new JTextField();

            asma_alt_cizgi.setBackground(Color.blue);
            JTextField.setDefaultLocale(Locale.UK);
            asma_alt_cizgi.setText("");
            asma_alt_cizgi.setForeground(Color.BLACK);
            Font f = new Font("Serif", Font.ITALIC, 14);
            asma_alt_cizgi.setFont(f);
            asma_alt_cizgi.setBounds(100, 100, 100, 100);

        }
        return asma_alt_cizgi;
    }*/

 /*public void setAsma_alt_cizgi(JTextField asma_alt_cizgi) {
        this.asma_alt_cizgi = asma_alt_cizgi;
    }*/
    public JLabel getAsma_orta_cizgi() {
        return asma_orta_cizgi;
    }

    public void setAsma_orta_cizgi(JLabel asma_orta_cizgi) {
        this.asma_orta_cizgi = asma_orta_cizgi;
    }

    public JLabel getAsma_ust_cizgi() {
        return asma_ust_cizgi;
    }

    public void setAsma_ust_cizgi(JLabel asma_ust_cizgi) {
        this.asma_ust_cizgi = asma_ust_cizgi;
    }

    public JLabel getAsma_adam_kafasi() {
        return asma_adam_kafasi;
    }

    public void setAsma_adam_kafasi(JLabel asma_adam_kafasi) {
        this.asma_adam_kafasi = asma_adam_kafasi;
    }

    public JLabel getAsma_adam_sag_kol() {
        return asma_adam_sag_kol;
    }

    public void setAsma_adam_sag_kol(JLabel asma_adam_sag_kol) {
        this.asma_adam_sag_kol = asma_adam_sag_kol;
    }

    public JLabel getAsma_adam_sol_kol() {
        return asma_adam_sol_kol;
    }

    public void setAsma_adam_sol_kol(JLabel asma_adam_sol_kol) {
        this.asma_adam_sol_kol = asma_adam_sol_kol;
    }

    public JLabel getAsma_adam_sag_bacak() {
        return asma_adam_sag_bacak;
    }

    public void setAsma_adam_sag_bacak(JLabel asma_adam_sag_bacak) {
        this.asma_adam_sag_bacak = asma_adam_sag_bacak;
    }

    public JLabel getAsma_adam_sol_bacak() {
        return asma_adam_sol_bacak;
    }

    public void setAsma_adam_sol_bacak(JLabel asma_adam_sol_bacak) {
        this.asma_adam_sol_bacak = asma_adam_sol_bacak;
    }

    /*public adam_asmaca_gui() {
        //        getJp().add(jp);
        getJp().add(getAsma_alt_cizgi());
    }*/
    

   



    public adam_asmaca_gui() {
        setBackground(Color.CYAN);
        setBounds(500, 5, 350, 700);
        add(getAsma_alt_cizgi());
    }
    

    public int getYanlis_harf_sayisi() {
        return yanlis_harf_sayisi;
    }

    public void setYanlis_harf_sayisi(int yanlis_harf_sayisi) {
        this.yanlis_harf_sayisi = yanlis_harf_sayisi;
    }
    @Override
 public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(java.awt.Color.blue);
        //          x   y    width  height
        g2d.fillOval(100, 100, 100, 100);
        /*g2d.setColor(java.awt.Color.blue);
        g2d.fillRect(10, 300, 10, 150);
        g2d.setColor(java.awt.Color.yellow);
        g2d.fillRect(50, 150, 100, 10);
        g2d.setColor(java.awt.Color.orange);
        g2d.drawLine(100, 100, 250, 250);*/
        switch (yanlis_harf_sayisi) {
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;
            case 10:
                break;

        }
    }
}
