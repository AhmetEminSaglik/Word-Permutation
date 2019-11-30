
import java.util.ArrayList;

//ÇALIŞIYOR AMA FAZLA DEGER ALAMIYOR
public class main2 {

    static ArrayList<String> arraylist = new ArrayList();

    static boolean ilk_giris = true;
    static int i, j;

    static boolean basamak_deger_esitlendi = false;

    public static int true_sayisi_ayarlama(int Kelime) {
        int toplam = 0;
        for (int i = 1; i < Kelime; i++) {
            toplam += i;
        }
        return toplam;
    }

    public static void oz(String[] Kelime, boolean[][] dizi_kontrol) {

        //  String[] Kelime = new String[Kelime.length];
        String arraya_eklenecek_Kelime = "";
        if (ilk_giris == true) {

            ilk_giris = false;

            for (int i = 1; i <= dizi_kontrol.length - 1; i++) {

                for (int j = 1; j < dizi_kontrol.length; j++) {
                    dizi_kontrol[i][j] = false;
                }
            }

            for (int ekle = 0; ekle < Kelime.length; ekle++) {
                Kelime[ekle] = Kelime[ekle];
                arraya_eklenecek_Kelime += Kelime[ekle];
            }

            arraylist.add(arraya_eklenecek_Kelime);
            //dizi_kontrol[1][0] = true;
            //System.out.println("deneme : (ozyinemele çağırmadan önce) "+deneme ); KONTROL NOKTASI

            oz(Kelime, dizi_kontrol);
        } else {

            /*false olanla işlem yapsın  [Max-1][1-Max] arası*/
            int dongu = 1;
            int true_sayisi = 0;

            boolean for_ici_for_cikis = false;
            for (i = 1; i <= Kelime.length - 1; i++) {
                for (j = 1; j <= dongu; j++) {
                    if (dizi_kontrol[i][j] == false) {
                        for_ici_for_cikis = true;

                        break;
                    }
                    true_sayisi++;
                }

                if (for_ici_for_cikis == true) {
                    break;
                }

                dongu++;
                if (true_sayisi == true_sayisi_ayarlama(Kelime.length)) {

                    return;
                }

            }

            String[] gecici_harf = new String[1];

            gecici_harf[0] = Kelime[i]; //--> Kelime K  A   L   E   M
            //                         //-->        4  3   2   1   0
            Kelime[i] = Kelime[i - 1];
            Kelime[i - 1] = gecici_harf[0];
            dongu = 1;

            for (int ekle = 0; ekle < Kelime.length; ekle++) {

                arraya_eklenecek_Kelime += Kelime[ekle];
            }

            arraylist.add(arraya_eklenecek_Kelime);

            dizi_kontrol[i][j] = true;

            for (int true_false_i = 1; true_false_i < i; true_false_i++) {
                for (int true_false_j = 1; true_false_j <= dongu; true_false_j++) {
                    dizi_kontrol[true_false_i][true_false_j] = false;
                }
                dongu++;
            }
            oz(Kelime, dizi_kontrol);

        }

    }

    public static void main(String[] args) {

        //int test = 10; System.out.format("asdfas %d sadf",test);
        String[] Word = {"A", "B", "C", "D", "E", "K"};
        boolean[][] dizi_kontrol = new boolean[Word.length][Word.length];
        //  ozyineleme(Word);

        oz(Word, dizi_kontrol);

        for (int yazdir = 0; yazdir < arraylist.size(); yazdir++) {
            System.out.println((yazdir + 1) + "-) " + arraylist.get(yazdir));
        }
    }
}
