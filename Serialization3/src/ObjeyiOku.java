
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class ObjeyiOku {

    public static void main(String[] args) {

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("ogrenciler.bin"))) {
            Ogrenci ogrenci = (Ogrenci) in.readObject();
            System.out.println(ogrenci);
            System.out.println("Öğrenci sayisi : " + Ogrenci.getOgrenci_sayisi());
        } catch (FileNotFoundException ex) {
            System.out.println("Dosya Bulunamadi...");
        } catch (IOException ex) {
            System.out.println("Dosya açılırken IOException oluştu... ");
        } catch (ClassNotFoundException ex) {
            System.out.println("Class bulunamadı...");
        }
    }

}
