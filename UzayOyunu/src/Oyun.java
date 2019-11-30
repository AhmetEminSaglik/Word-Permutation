
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

//KeyListener-->  klavye işlemlerini anlamsı için bunu aktif etmesi gerekiyor

/*ActionListener--> hareket etmesi için gerekiyor   
    ------> Timer her çalıştığında ActionListener harekete geçecek böylece top hareket edecek*/
class Ates {

    private int x;
    private int y;

    public Ates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

}

public class Oyun extends JPanel implements KeyListener, ActionListener {

    Timer timer = new Timer(5, this);

    private int gecen_sure = 0;
    private int harcanan_ates = 0;

    private BufferedImage image;

    private ArrayList<Ates> atesler = new ArrayList<Ates>();

    private int atesdirY = 1;

    private int topX = 0;

    private int topdirX = 2;

    private int uzayGemisiX = 10;

    private int dirUzayX = 20;

    public boolean kontrolEt() {
        for (Ates ates : atesler) {
            if (new Rectangle(ates.getX(), ates.getY(), 10, 20).intersects(new Rectangle(topX, 0, 20, 20))) {
                return true;

            }

        }
        return false;
    }

    public Oyun() {
        try {
            image = ImageIO.read(new FileImageInputStream(new File("uzaygemisi.png")));
        } catch (IOException ex) {
            Logger.getLogger(Oyun.class.getName()).log(Level.SEVERE, null, ex);
        }
        setBackground(Color.BLACK);
        timer.start(); // timer başladıktan her 5 ms bi actionPerformed çalışacak
    }

    @Override
    public void paint(Graphics g) {
        gecen_sure += 5;
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
        g.setColor(Color.red);

        g.fillOval(topX, 0, 20, 20);

        g.drawImage(image, uzayGemisiX, 495, image.getWidth() / 10, image.getHeight() / 10, this);
        for (Ates ates : atesler) {
            if (ates.getY() < 0) {
                atesler.remove(ates);
            }
        }
        g.setColor(Color.BLUE);
        for (Ates ates : atesler) {
            g.fillRect(ates.getX(), ates.getY(), 10, 20);
        }
        if (kontrolEt()) {

            timer.stop();

            String message = "Kazandınız"
                    + "\nHarcanan Ateş :" + harcanan_ates
                    + "\nGeçen Süre:" + gecen_sure / 1000.0;
            JOptionPane.showMessageDialog(this, message);
            System.exit(0);
        }

    }

    @Override
    public void repaint() { // her çağrıldığında paint ti çağırır
        super.repaint(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int c = e.getKeyCode();//sola  basınca sola basılmış degeri döndürecek (sag içinde geçerli    )

        if (c == KeyEvent.VK_LEFT) {
            if (uzayGemisiX <= 10) {
                uzayGemisiX = 10;
            } else {
                uzayGemisiX -= 3*dirUzayX;
            }
        } else if (c == KeyEvent.VK_RIGHT) {
            if (uzayGemisiX >= 740) {
                uzayGemisiX = 740;
            } else {
                uzayGemisiX += dirUzayX;
            }
        } else if (c == KeyEvent.VK_UP) {
            atesler.add(new Ates(uzayGemisiX + 15, 470)); // görüntü kayması var merkezden  alıyor o zamnda yanlış mış gibi oluyor
            harcanan_ates++;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (Ates ates : atesler) {
            ates.setY(ates.getY() - atesdirY);

        }
        topX += topdirX;

        if (topX >= 750) {
            topdirX = -topdirX; // max sınıra ulaşınca başlangıç olan 0 a geri dönecek

        }
        if (topX <= 0) {
            topdirX = -topdirX;
        }
        repaint();
    }
}
