package Gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainGui {

    JFrame jf = null;
    JPanel jp = null;
    KumandaGui kg = null;
    EkranGui eg = null;

    public MainGui() {
        getJp().add(getEg().getJp());
        getJp().add(getKg().getJp());

        getJf().setVisible(true);

    }

    public JFrame getJf() {
        /* size location ve içerecek paneli ekliyoruz & yada burdaki paneli*/
        if (jf == null) {
            jf = new JFrame("Gelişmiş TV Tekrarı");
            jf.setSize(900, 600);
            jf.setLocation(25, 25);
            jf.setLayout(null);

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

    public KumandaGui getKg() {
        if (kg == null) {
            kg = new KumandaGui(this);
        }
        return kg;
    }

    public void setKg(KumandaGui kg) {
        this.kg = kg;
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
}
