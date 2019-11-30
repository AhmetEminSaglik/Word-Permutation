    
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ObjeyiYaz {
    
    public static void main(String[] args) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Ogrenci.bin"))) { //dosyamızın byte şeklinde oluştuğunu gösterir
            Ogrenci ogrenci1 = new Ogrenci("Ahmet Emin ", 1234, "Yazılım Mühendisliği");
            Ogrenci ogrenci2 = new Ogrenci("Oğuz", 678, "Finanasal Matematik");
            out.writeObject(ogrenci1);
            out.writeObject(ogrenci2);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ObjeyiYaz.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Dosya bulunamadı...");
        } catch (IOException ex) {
            Logger.getLogger(ObjeyiYaz.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Dosya açılırken IOException oluştu...");
        }
    }
}
