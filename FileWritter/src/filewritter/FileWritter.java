package filewritter;

import java.io.FileWriter;
import java.io.IOException;

public class FileWritter {

    public static void main(String[] args) {
        System.out.println("FileWriter ile [FileOutputStream & FileInputStream] gibi byte çevirmeye gerek yok"
                + "\n Stringi olduğu gibi aktarabiliriz");
        System.out.println("");
        FileWriter writer = null;

        try {
            writer = new FileWriter("dosya.txt",true);
            //writer.write("Ahmet Emin SAĞLIK\n");
            //writer.write("Mustafa Murat Coşkun\n");
            writer.write("Ahmet Seyid");
        } catch (IOException ex) {
            System.out.println("Dosya açılırken hata oluştu  Exception");
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException ex) {
                    System.out.println("Dosya kapatılırken hata oluştu");
                }
            }
        }
    }

}
