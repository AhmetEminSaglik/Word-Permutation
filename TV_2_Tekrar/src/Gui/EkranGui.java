package Gui;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class EkranGui {
    
    JPanel jp = null;
    JLabel ekran;
    
    public EkranGui() {
    }
    
    public JPanel getJp() {
        if (jp == null) {
            jp = new JPanel();
            jp.setBounds(0, 0, 500, 355);
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
            ekran.setBounds(0, 0, 100, 20);
        }
        return ekran;
    }
    
    public void setEkran(JLabel ekran) {
        this.ekran = ekran;
    }
    
}
