/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;


import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author karadeniz
 */
public class EkranGui {
    

    JPanel jp = null;
    JLabel ekran;

    public EkranGui() {
       
        getJp().add(getEkran());
    }

    public JPanel getJp() {
        if (jp == null) {
            jp = new JPanel();
            jp.setBounds(50, 50, 500, 355);
            jp.setLayout(null);
        }
        return jp;
    }

    public void setJp(JPanel jp) {
        this.jp = jp;
    }


    public JLabel getEkran() {
        if (ekran == null) {
            ekran = new JLabel();
            ekran.setBounds(0, 0, 500, 355);
        }
        return ekran;
    }

    public void setEkran(JLabel ekran) {
        this.ekran = ekran;
    }

}
