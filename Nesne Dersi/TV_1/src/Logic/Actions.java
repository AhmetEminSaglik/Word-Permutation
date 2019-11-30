package Logic;

import Gui.KumandaGui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class Actions implements ActionListener {

    KumandaGui kg = null;

    public Actions(KumandaGui kg) {
        this.kg = kg;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("ActionPerformed de yiz ama ne yazılacak buraya bilmiyorum");
        if (e.getSource() == kg.getOnOff()) {
            JOptionPane.showMessageDialog(null, "Burdaa");
            //kg.getJp().setVisible(false);
        }

    }

}
