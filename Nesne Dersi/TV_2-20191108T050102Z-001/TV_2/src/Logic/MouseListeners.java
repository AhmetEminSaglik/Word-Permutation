package Logic;

import Gui.KumandaGui;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

public class MouseListeners implements MouseListener {

    KumandaGui kg = null;

    public MouseListeners(KumandaGui kg) {
        setKg(kg);
        JOptionPane.showMessageDialog(null, " referans : " + kg);
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //JOptionPane.showMessageDialog(null, "mouse Clicked");
        System.out.println("Clicked");
    }

    @Override
    public void mousePressed(MouseEvent e) {
     //   JOptionPane.showMessageDialog(null, "mouse Pressed");
     System.out.println("Pressed");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //JOptionPane.showMessageDialog(null, "mouse Released");
    System.out.println("Released");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
       // JOptionPane.showMessageDialog(null, "mouse Entered");
       System.out.println("Entered");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //JOptionPane.showMessageDialog(null, "mouse Exited");
    System.out.println("Exited");
    }

    public KumandaGui getKg() {

        return kg;
    }

    public void setKg(KumandaGui kg) {
        this.kg = kg;
    }

}
