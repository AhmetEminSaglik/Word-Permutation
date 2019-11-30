package Gui;

import java.awt.Color;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JPanel;

public class KumandaGui {

    JPanel jp = null;
    JButton[] tuslar = null;
    MainGui mg = null;
    EkranGui eg = null;

    public KumandaGui(MainGui mg) {
        this.mg = mg;
        this.eg = mg.getEg();

        getJp().add(getTuslar()[10]);
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

    public JButton[] getTuslar() {
        if (tuslar == null) {
            tuslar = new JButton[10];

            for (int i = 0; i < 10; i++) {
                if (i == 0) {

                    tuslar[i].setLocation(10, 10);
                    tuslar[i].setBounds(0, 0, 100, 50);
                    tuslar[i].setBackground(Color.red);

                } else {
                    tuslar[i].setLocation(30, 30);
                    int m = 5;
                    Insets Insets = new Insets(30, 30, 30, 30);
                    tuslar[i].setMargin(Insets);

                }
            }
        }
        return tuslar;
    }

    public void setTuslar(JButton[] tuslar) {
        this.tuslar = tuslar;
    }

}
