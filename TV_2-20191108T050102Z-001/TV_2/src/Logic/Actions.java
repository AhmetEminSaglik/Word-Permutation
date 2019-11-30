/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Gui.DMainGui;
import Gui.KumandaGui;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author karadeniz
 */
public class Actions implements ActionListener {

    KumandaGui kumGui = null;

    public Actions(KumandaGui a) {
        setKumGui(a);
    }

    public KumandaGui getKumGui() {

        return kumGui;
    }

    public void setKumGui(KumandaGui kumGui) {
        this.kumGui = kumGui;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == getKumGui().getOnOff()) {

            JOptionPane.showMessageDialog(null, "Tek Basamaklı.. ");

            JOptionPane.showMessageDialog(null, "     getKumGui().getEg().getJp().setBackground(Color.blue); \n"
                    + "(Ekran paneli mavi olacak)");
            getKumGui().getEg().getJp().setBackground(Color.blue);

            JOptionPane.showMessageDialog(null, "       getKumGui().getJp().setBackground(Color.green); \n"
                    + "(Kumanda paneli yeşil olacak)");
            getKumGui().getJp().setBackground(Color.green);

            JOptionPane.showMessageDialog(null, " getKumGui().getDmg().getJp().setBackground(Color.yellow);\n"
                    + "ile mainpanelin arka planı değişir");
            getKumGui().getDmg().getJp().setBackground(Color.yellow);

            JOptionPane.showMessageDialog(null, "     DMainGui dmg = new DMainGui(); \n"
                    + "mg.getJp().setBackground(Color.red);\n"
                    + "Yeni JFrame Panelini açar böyle");

            DMainGui dmg = new DMainGui();
            //dmg.getJf().setBackground(Color.red);
            dmg.getJp().setBackground(Color.red);
            dmg.getJf().setDefaultCloseOperation(1);

        }
    }
}
