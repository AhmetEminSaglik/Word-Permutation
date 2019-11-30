package OyunEkrani;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.imageio.stream.ImageInputStream;
import sun.awt.image.ImageAccessException;

public class Buffered_Aktarici {

    public BufferedImage[] karakter_gorsel = new BufferedImage[22];

    public BufferedImage[] cadi_gorsel = new BufferedImage[9];
    public BufferedImage[] iskelet_gorsel = new BufferedImage[18];
    public BufferedImage[] buyucu_gorsel = new BufferedImage[12];
    public BufferedImage[] dana_gorsel = new BufferedImage[9];
    public BufferedImage[] roundlarin_resimleri = new BufferedImage[19];
    public BufferedImage[] skill1_gorsel = new BufferedImage[6];
    public BufferedImage[] dog = new BufferedImage[28];
    public BufferedImage[] yok_ol = new BufferedImage[5];
    public BufferedImage[] karakter_olum = new BufferedImage[10];

    public BufferedImage map1, map2;

    public Buffered_Aktarici() {
        try {

            roundlarin_resimleri[0] = ImageIO.read(new FileImageInputStream(new File("src/images/k1-removebg-preview.png")));
            roundlarin_resimleri[1] = ImageIO.read(new FileImageInputStream(new File("src/images/k2-removebg-preview.png")));
            roundlarin_resimleri[2] = ImageIO.read(new FileImageInputStream(new File("src/images/k3-removebg-preview.png")));
            roundlarin_resimleri[3] = ImageIO.read(new FileImageInputStream(new File("src/images/k4-removebg-preview.png")));
            roundlarin_resimleri[4] = ImageIO.read(new FileImageInputStream(new File("src/images/k6-removebg-preview.png")));
            roundlarin_resimleri[5] = ImageIO.read(new FileImageInputStream(new File("src/images/k7-removebg-preview.png")));
            roundlarin_resimleri[6] = ImageIO.read(new FileImageInputStream(new File("src/images/k8-removebg-preview.png")));
            roundlarin_resimleri[7] = ImageIO.read(new FileImageInputStream(new File("src/images/k9-removebg-preview.png")));
            roundlarin_resimleri[8] = ImageIO.read(new FileImageInputStream(new File("src/images/k11-removebg-preview.png")));
            roundlarin_resimleri[9] = ImageIO.read(new FileImageInputStream(new File("src/images/k12-removebg-preview.png")));
            roundlarin_resimleri[10] = ImageIO.read(new FileImageInputStream(new File("src/images/k13-removebg-preview.png")));
            roundlarin_resimleri[11] = ImageIO.read(new FileImageInputStream(new File("src/images/k14-removebg-preview.png")));
            roundlarin_resimleri[12] = ImageIO.read(new FileImageInputStream(new File("src/images/k16-removebg-preview.png")));
            roundlarin_resimleri[13] = ImageIO.read(new FileImageInputStream(new File("src/images/k17-removebg-preview.png")));
            roundlarin_resimleri[14] = ImageIO.read(new FileImageInputStream(new File("src/images/k18-removebg-preview.png")));
            roundlarin_resimleri[15] = ImageIO.read(new FileImageInputStream(new File("src/images/k19-removebg-preview.png")));

            for (int i = 1; i < 11; i++) {
                String url = "src/images/d_" + i + ".png";
                karakter_olum[i - 1] = ImageIO.read(new FileImageInputStream(new File(url)));
            }

            for (int i = 1; i < 6; i++) {
                String url = "src/images/yok_ol" + i + ".png";
                yok_ol[i - 1] = ImageIO.read(new FileImageInputStream(new File(url)));
            }

            for (int i = 1; i < 29; i++) {
                String url = "src/images/dog" + i + ".png";
                dog[i - 1] = ImageIO.read(new FileImageInputStream(new File(url)));
            }

            for (int i = 1; i < 23; i++) {
                String url = "src/images/s" + i + "-removebg-preview.png";
                karakter_gorsel[i - 1] = ImageIO.read(new FileImageInputStream(new File(url)));
            }
            for (int i = 1; i < 10; i++) {
                String url = "src/images/c" + i + "-removebg-preview.png";
                cadi_gorsel[i - 1] = ImageIO.read(new FileImageInputStream(new File(url)));
            }
            for (int i = 1; i < 19; i++) {
                String url = "src/images/Skeleton" + i + ".png";
                iskelet_gorsel[i - 1] = ImageIO.read(new FileImageInputStream(new File(url)));
            }

            for (int i = 1; i < 13; i++) {
                String url = "src/images/villain" + i + ".png";
                buyucu_gorsel[i - 1] = ImageIO.read(new FileImageInputStream(new File(url)));
            }
            for (int i = 1; i < 10; i++) {
                String url = "src/images/mino" + i + ".png";
                dana_gorsel[i - 1] = ImageIO.read(new FileImageInputStream(new File(url)));
            }

            for (int i = 1; i < 7; i++) {
                String url = "src/images/adalet" + i + ".png";
                skill1_gorsel[i - 1] = ImageIO.read(new FileImageInputStream(new File(url)));
            }

            map1 = ImageIO.read(new FileImageInputStream(new File("src/images/map1.png")));
            map2 = ImageIO.read(new FileImageInputStream(new File("src/images/map2.png")));

        } catch (IOException ex) {
            Logger.getLogger(Buffered_Aktarici.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
