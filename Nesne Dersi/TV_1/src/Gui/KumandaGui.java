package Gui;

import Logic.Actions;
import java.awt.Color;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class KumandaGui {

    JPanel jp = null;
    JButton onOff = null;
    Actions a = new Actions(this);

    public KumandaGui() {
        getJp().add(getOnOff());
    }

    public JPanel getJp() {
        if (jp == null) {
            jp = new JPanel();
            jp.setBounds(600, 150, 170, 300);
            jp.setLayout(null); // kendimiz pozisyonunu belirliyoruz
        }
        return jp;
    }

    public void setJp(JPanel jp) {
        this.jp = jp;
    }

    public JButton getOnOff() {
        if (onOff == null) {
            onOff = new JButton();
            onOff.setBackground(Color.red);
            //Icon onOffb = new ImageIcon(getClass().getResource("onoff.png"));
            //onOff.setIcon(onOffb);
            onOff.setBounds(5, 5, 50, 50);
            onOff.addActionListener(a);

        }
        return onOff;
    }

    public void setOnOff(JButton onOff) {
        this.onOff = onOff;
    }
}
