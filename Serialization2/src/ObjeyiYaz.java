
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ObjeyiYaz {

    public static void main(String[] args) {
        Ogrenci ogrenci1 = new Ogrenci("Ahmet Emin", 1234, "Yazılım Mühendisliği");
        Ogrenci ogrenci2 = new Ogrenci("Oğuz", 678, "Finansal Matematik");
        Ogrenci ogrenci3 = new Ogrenci("Mehmet", 123, "Bilgisayar Mühendisliği");

        Ogrenci[] ogrenci_array = {ogrenci1, ogrenci2, ogrenci3};
        ArrayList<Ogrenci> ogrenci_list = new ArrayList<Ogrenci>(Arrays.asList(ogrenci_array));

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Ogrenciler.bin"))) { //dosyamızın byte şeklinde oluştuğunu gösterir
            out.writeObject(ogrenci_array);
            out.writeObject(ogrenci_list);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ObjeyiYaz.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Dosya bulunamadı...");
        } catch (IOException ex) {
            Logger.getLogger(ObjeyiYaz.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Dosya açılırken IOException oluştu...");
        }
    }
}
