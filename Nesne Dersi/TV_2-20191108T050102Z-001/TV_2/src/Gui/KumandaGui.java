package Gui;

import Logic.Actions;
import Logic.MouseListeners;
import java.awt.Color;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.TransferHandler;
import javax.swing.text.Caret;

public class KumandaGui {

    JPanel jp = null;
    JButton onOff = null;
    EkranGui eg = null;
    Actions a = new Actions(this);
    DMainGui dmg = null; // Ana panelin rengini değiştirmek için bunu açtım ve null atadım 
    //ve buraya this ile gönderdim aynı paneli almak için
    JLabel lbl_tıklama = null;
    MouseListeners mouselistener = new MouseListeners(this);
    JTextField text_fied = null;

    public KumandaGui(DMainGui dmg) {

        this.dmg = dmg;
        this.eg = dmg.getEg();
        getJp().add(getOnOff());
        getJp().add(getLbl_tıklama());
        getJp().add(getText_fied());
    }

    public JPanel getJp() {
        if (jp == null) {
            jp = new JPanel();
            jp.setBounds(700, 105, 170, 311);
            jp.setBackground(Color.LIGHT_GRAY);
            jp.setLayout(null);
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
            Icon onOffb = new ImageIcon(getClass().getResource("Onoff.png"));
            onOff.setIcon(onOffb);
            onOff.setBounds(0, 0, 80, 80);
            onOff.addActionListener(a);
        }
        return onOff;
    }

    public void setOnOff(JButton onOff) {
        this.onOff = onOff;
    }

    public EkranGui getEg() {
        return eg;
    }

    public DMainGui getDmg() {
        return dmg;
    }

    public JLabel getLbl_tıklama() {
        if (lbl_tıklama == null) {
            lbl_tıklama = new JLabel("label tıklayabilirsiniz");
            lbl_tıklama.setBounds(0, 50, 100, 100);

            lbl_tıklama.addMouseListener(mouselistener);

        }
        return lbl_tıklama;
    }

    public void setLbl_tıklama(JLabel lbl_tıklama) {
        this.lbl_tıklama = lbl_tıklama;
    }

    public JTextField getText_fied() {
        if (text_fied == null) {
            text_fied = new JTextField();
            text_fied.setBounds(0, 150, 150, 30);
            text_fied.setOpaque(false);
            text_fied.setTransferHandler(new TransferHandler("asdkfjasfdjfs"));
            text_fied.setToolTipText("tooltip");
         
        }
        return text_fied;
    }

    public void setText_fied(JTextField text_fied) {
        this.text_fied = text_fied;
    }

}
