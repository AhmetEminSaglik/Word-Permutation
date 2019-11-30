package Gui;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainGui {

    JFrame jf = null;
    JPanel jp = null;
    Kelime_oyunu_gui kog = null;
    adam_asmaca_gui aag = null;

    public MainGui() {
        getJp().setBackground(Color.green);

        getJp().add(getAag());
        //getJp().add(getKog().getJp());
        getJf().setVisible(true);
        

    }

    public JFrame getJf() {
        if (jf == null) {
            jf = new JFrame("Adam Asmaca Oyunu");
            jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            jf.setLocation(0, 0);
            jf.setSize(1370, 740);
            jf.setContentPane(getJp()); // niye getJp yazıyoruz ? 

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

    public Kelime_oyunu_gui getKog() {
        if (kog == null) {
            kog = new Kelime_oyunu_gui();
        }
        return kog;
    }

    public void setKog(Kelime_oyunu_gui kog) {
        this.kog = kog;
    }

    public adam_asmaca_gui getAag() {
        if (aag == null) {
            aag = new adam_asmaca_gui();
        }
        return aag;
    }

    public void setAag(adam_asmaca_gui aag) {
        this.aag = aag;
    }

}
