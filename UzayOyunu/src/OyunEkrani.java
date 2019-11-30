
import java.awt.HeadlessException;
import javax.swing.JFrame;

public class OyunEkrani extends JFrame {

    public OyunEkrani(String title) throws HeadlessException {
        super(title);
    }

    public static void main(String[] args) {
        OyunEkrani ekran = new OyunEkrani("kasdlkflfsj");
        ekran.setResizable(false);
        ekran.setFocusable(false);//işlemlerimizi JFrame e odaklanmasını ordaki işlemleri yapmasını istemiyoru
        //birazdan yapacağımız ekrana odaklanacak
        ekran.setSize(800, 600);
        ekran.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Oyun oyun = new Oyun();

        oyun.requestFocus(); //klavyeden işlemlerimizi anlaması için bize odağı ver diyor

        oyun.addKeyListener(oyun);

        oyun.setFocusable(true); // artık kendi yaptığımız oyuna odaklanacaz

        /*          SIRASI ÇOK ÇOOK ÇOOOOOK ÖNEMLİ
        EĞER  REQUESTFOCUS()-ADDKEYLISTENER()-SETFOCUSABLE --> YER DEĞİŞİRSE KLAVYE İNPUT HATASI OLUR*/
        oyun.setFocusTraversalKeysEnabled(false);// klavye işlemleri anlamsı için bir işlem false diyoruz ki bizim işlemlerimizi anlasın
        ekran.add(oyun);

        ekran.setVisible(true); // yani JFrame bu JPanele eklenince oyun açılacak

    }
}
