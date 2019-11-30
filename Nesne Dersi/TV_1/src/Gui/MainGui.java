package Gui;

import java.awt.Color;
import javax.swing.*;

public class MainGui {

    JFrame jf = null;
    JPanel jp = null;
    EkranGui eg = null;
    KumandaGui kg = null;

    public MainGui() {
        getJp().setBackground(Color.getHSBColor(0.5f, 0.2f, 0.6f));
        getJp().add(getEg().getJp());
        getJp().add(getKg().getJp());

        getJf().setVisible(true);
    }

    public JFrame getJf() {
        if (jf == null) {
            jf = new JFrame("TV Ünitesi");
            jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            jf.setLocation(25, 25);
            jf.setSize(1000, 600);

            jf.setContentPane(getJp());
        }
        return jf;
    }

    public void setJf(JFrame jf) {
        this.jf = jf;
    }

    public JPanel getJp() {
        if (jp == null) {
            jp = new JPanel();
            jp.setLayout(null);
        }
        return jp;
    }

    public void setJp(JPanel jp) {
        this.jp = jp;
    }

    public EkranGui getEg() {
        if (eg == null) {
            eg = new EkranGui();
        }
        return eg;
    }

    public void setEg(EkranGui eg) {
        this.eg = eg;
    }

    public KumandaGui getKg() {
        if (kg == null) {
            kg = new KumandaGui();
        }
        return kg;
    }

    public void setKg(KumandaGui kg) {
        this.kg = kg;
    }

}
