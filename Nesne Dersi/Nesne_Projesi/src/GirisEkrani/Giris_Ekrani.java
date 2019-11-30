package GirisEkrani;

import Logic.Actions;
import OyunEkrani.Oyun_Ekrani;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class Giris_Ekrani {

    JFrame giris_ekrani_jframe = null;
    JLayeredPane giris_ekrani_jlayeredpane = null;

    JButton giris_ekrani_start = null;
    JButton giris_ekrani_hakkimizda = null;
    JButton giris_ekrani_cikis = null;

    JLabel giris_ekrani_label = null;

    Actions action = new Actions();
    Oyun_Ekrani oe = null;

    final int JFrame_height = 690;
    final int JFrame_width = 750;
    final int scale = 30;

    public Giris_Ekrani() {
        action.setGe(this);
        action.setOe(this.getOe());
        getGiris_ekrani_jframe();
        getGiris_ekrani_jframe().add(getGiris_ekrani_jlayeredpane());
        getGiris_ekrani_jlayeredpane().add(getGiris_ekrani_label(), new Integer(1));
        getGiris_ekrani_jlayeredpane().add(getGiris_ekrani_start(), new Integer(2));
        getGiris_ekrani_jlayeredpane().add(getGiris_ekrani_cikis(), new Integer(2));

    }

    public JFrame getGiris_ekrani_jframe() {
        if (giris_ekrani_jframe == null) {
            giris_ekrani_jframe = new JFrame();
            giris_ekrani_jframe.setSize(JFrame_width, JFrame_height);
            giris_ekrani_jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            giris_ekrani_jframe.setLocationRelativeTo(null);
            giris_ekrani_jframe.setResizable(false);
            giris_ekrani_jframe.setVisible(true);
        }
        return giris_ekrani_jframe;
    }

    public JLayeredPane getGiris_ekrani_jlayeredpane() {
        if (giris_ekrani_jlayeredpane == null) {
            giris_ekrani_jlayeredpane = new JLayeredPane();
            giris_ekrani_jlayeredpane.setLayout(null);
            giris_ekrani_jlayeredpane.setBounds(0, 0, 750, 660);
            giris_ekrani_jlayeredpane.setBackground(Color.black);
        }
        return giris_ekrani_jlayeredpane;
    }

    public JButton getGiris_ekrani_start() {
        if (giris_ekrani_start == null) {
            giris_ekrani_start = new JButton();
            giris_ekrani_start.setBounds(9 * scale+15, 15 * scale, 5 * scale, 2 * scale);
            giris_ekrani_start.setIcon(new ImageIcon("src/images/giris_ekrani_start.png"));
            giris_ekrani_start.addActionListener(action);

        }
        return giris_ekrani_start;
    }

    public JButton getGiris_ekrani_cikis() {
        if (giris_ekrani_cikis == null) {
            giris_ekrani_cikis = new JButton();
            giris_ekrani_cikis.setBounds(9 * scale+15, 18 * scale-(scale/2), 5 * scale, 2 * scale);
            giris_ekrani_cikis.setFont(new Font("Serif", Font.BOLD, 20));
            giris_ekrani_cikis.setIcon(new ImageIcon("src/images/giris_ekrani_cikis.png"));
            giris_ekrani_cikis.addActionListener(action);
        }
        return giris_ekrani_cikis;
    }

    public JLabel getGiris_ekrani_label() {
        if (giris_ekrani_label == null) {
            giris_ekrani_label = new JLabel();
            giris_ekrani_label.setBounds(0, 0, 25 * scale, 22 * scale);
            giris_ekrani_label.setIcon(new ImageIcon("src/images/ana_menu_bg.png"));
        }
        return giris_ekrani_label;
    }

    public Oyun_Ekrani getOe() {
        if (oe == null) {
            oe = new Oyun_Ekrani();
        }
        return oe;
    }

}
