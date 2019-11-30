package Gui;

import java.awt.Color;
import javax.swing.*;

public class MainGui {

    JFrame jf = null;
    JPanel jp = null;

    public MainGui() {
        getJp().setBackground(Color.getHSBColor(0.5f, 0.2f, 0.6f));
        getJf().setVisible(true);
    }

    public JFrame getJf() {
        if (jf == null) {
            jf = new JFrame("TV Ünitesi");
            jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            jf.setLocation(25, 25);
            jf.setSize(1000, 600);
            jf.setContentPane(jp);
        }
        return jf;
    }

    public void setJf(JFrame jf) {
        this.jf = jf;
    }

    public JPanel getJp() {
        if (jp == null) {
            jp = new JPanel();
        }
        return jp;
    }

    public void setJp(JPanel jp) {
        this.jp = jp;
    }

}
