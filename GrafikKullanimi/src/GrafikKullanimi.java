
import java.awt.Color;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

public class GrafikKullanimi extends JPanel {

    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
        int i = 0;

        g.setColor(Color.red); // Bunun altındaki tüm şeyler kırmızı çizilecek
        g.drawRect(100, 10, 30, 40);//kordinatlar  çizgi
        g.fillRect(200, 100, 30, 40); // içi dolu dikdörtgen

        g.setColor(Color.BLUE);

        g.drawOval(100, 100, 60, 30);
        g.fillOval(300, 300, 40, 40);
        g.setColor(Color.YELLOW);
    
        g.drawLine(100,100, 300,300);
        g.setColor(Color.red);
        g.drawLine(0,12, 100,50);
    
    }

    public GrafikKullanimi() {
        setBackground(Color.BLACK);
    }

}
