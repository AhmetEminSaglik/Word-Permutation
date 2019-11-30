package Gui;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainGui {
    
    JFrame jf = null;
    JPanel jp = null;
    
    public MainGui() {
        getJp().setBackground(Color.getHSBColor(0.7f, 0.5f, 0.3f));
        
        getJf().setVisible(true);
    }
    
    public JFrame getJf() {
        if (jf == null) {
            jf = new JFrame("Oyun denemesi");
            jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            jf.setLocation(25, 25);
            jf.setSize(700, 700);
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
    
}
