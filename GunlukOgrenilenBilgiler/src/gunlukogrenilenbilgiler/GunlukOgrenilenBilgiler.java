package gunlukogrenilenbilgiler;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GunlukOgrenilenBilgiler {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true) {

            try (BufferedWriter KelimeYazdirma = new BufferedWriter(new FileWriter("03.08.2019.doc", true));
                    BufferedWriter OzelKaliplar = new BufferedWriter(new FileWriter("Kaliplar.txt", true));
                    BufferedWriter HosCumleler = new BufferedWriter(new FileWriter("HosCumleler.txt", true));
                    BufferedWriter IdomsUsa = new BufferedWriter(new FileWriter("IdomsUsa", true));
                    BufferedWriter pratik_gereken_bildigim_kelimeler = new BufferedWriter(new FileWriter("pratik_gereken_bildigim_kelimeler.txt", true))) {

                while (true) {
                    System.out.println("(Cikisicin q' ye basiniz, Kaydetmek icin s' ye basiniz)");
                    System.out.println("1-) Kelime eklemek istiyorsaniz,\n"
                            + "2-) Kalip  eklemek isyiorsaniz,\n"
                            + "3-) Hosunuza giden cumleyi eklemek icin,\n"
                            + "4-) To add idoms press,\n"
                            + "5-) Bildigim ama pratigim olmayan kelimeler,\n");
                    String secim = scanner.nextLine();
                    if (secim.equals("q")) {
                        System.out.println("Programdan Cikiliyor");
                        return;
                    } else if (secim.equals("s")) {
                        break;
                    } else if (secim.equals("1")) {
                        while (true) {
                            System.out.print("Eklenecek Kelime : ");
                            String kelime = scanner.nextLine();
                            if (kelime.equals("q")) {
                                System.out.println("Kelime Eklemeden Cikiliyor....");
                                break;

                            } else {
                                int i = 1;
                                KelimeYazdirma.write("**************************************************************************");
                                KelimeYazdirma.newLine();
                                KelimeYazdirma.write("word : " + kelime.replace("i", "I").toUpperCase());
                                KelimeYazdirma.newLine();
                                System.out.print("Meaning : ");
                                kelime = scanner.nextLine();
                                KelimeYazdirma.write("Meaning : " + kelime);
                                KelimeYazdirma.newLine();
                                KelimeYazdirma.newLine();
                                System.out.print("Synonyms : ");
                                String synonyms = scanner.nextLine();
                                KelimeYazdirma.write("Synonyms :" + synonyms);
                                KelimeYazdirma.newLine();
                                KelimeYazdirma.newLine();

                                System.out.println("example of word in sentence : ");
                                kelime = scanner.nextLine();
                                KelimeYazdirma.write(i + "-)" + kelime);

                                System.out.println("Do yu want to add another example for this word ? (Yes :Enter sentence, No : q)");

                                while (true) {
                                    String add = scanner.nextLine();
                                    if (add.equals("q")) {
                                        System.out.println("exiting word");
                                        KelimeYazdirma.newLine();

                                        break;
                                    } else {
                                        i++;

                                        KelimeYazdirma.newLine();
                                        System.out.println("Do yu want to add another example for this word ? (Yes :Enter sentence, No : q)");

                                        KelimeYazdirma.write(i + "-)" + add);
                                    }
                                }
                            }
                        }
                    } else if (secim.equals("2")) {
                        while (true) {
                            System.out.println("Cumleyi giriniz : ");

                            String Kalip = scanner.nextLine();
                            if (Kalip.equals("q")) {
                                System.out.println("Kalip Eklemeden Cikiliyor");
                                break;
                            } else {
                                OzelKaliplar.write("**************************************************************************");
                                OzelKaliplar.newLine();
                                OzelKaliplar.newLine();
                                OzelKaliplar.write(Kalip);

                                System.out.println("Aciklama yapmak istemiyorsaniz q ye basiniz :");
                                Kalip = scanner.nextLine();
                                if (Kalip.equals("q")) {
                                    System.out.println("Aciklama yapilmadi");

                                } else {
                                    OzelKaliplar.write(Kalip);
                                    System.out.println("Aciklama yapildi");
                                }
                                OzelKaliplar.newLine();
                                OzelKaliplar.newLine();
                            }
                        }
                    } else if (secim.equals("3")) {
                        System.out.println("Hosunuza giden cumleyi giriniz (Cikmam icin q ye basiniz): ");

                        while (true) {
                            HosCumleler.write("**************************************************************************");
                            String HosCumle = scanner.nextLine();
                            if (HosCumle.equals("q")) {
                                System.out.println("Hos cumle eklemeden cikiliyor");
                                break;
                            } else {
                                HosCumleler.write(HosCumle);
                                System.out.println("Başka Hos Cumle girebilirsiniz(ya da q ile cikabilirsiniz)");
                            }
                        }

                    } else if (secim.equals("4")) {
                        while (true) {

                            System.out.print("Idom : ");

                            String idom = scanner.nextLine();
                            System.out.println();
                            if (idom.equals("q")) {

                                System.out.println("Idom eklemeden cikiliyor");
                                break;
                            } else {

                                IdomsUsa.write("/////////////////////////////////////////////////////////////////////////");
                                IdomsUsa.newLine();
                                IdomsUsa.newLine();

                                IdomsUsa.write(idom.replace('i', 'I').toUpperCase());
                                IdomsUsa.newLine();
                                IdomsUsa.newLine();
                                System.out.print("Meaning : ");
                                String idomMeaning = scanner.nextLine();
                                IdomsUsa.write(idomMeaning);
                                IdomsUsa.newLine();
                                System.out.println("Example or q to quit");
                                int i = 1;
                                String idomExample = "";
                                while (true) {
                                    idomExample = scanner.nextLine();
                                    if (idomExample.equals("q")) {
                                        System.out.println("Suanki Idomdan Cikiliyor...");
                                        break;
                                    } else {
                                        IdomsUsa.write(i + "-)" + idomExample);
                                        IdomsUsa.newLine();
                                        i++;
                                        System.out.print("Another example : ");
                                    }
                                }
                                System.out.println("Another");
                            }
                        }
                        IdomsUsa.write("**************************************************************************");
                    } else if (secim.equals("5")) {
                        while (true) {
                            System.out.print("Eklenecek Kelime : ");
                            String kelime = scanner.nextLine();
                            if (kelime.equals("q")) {
                                System.out.println("Kelime Eklemeden Cikiliyor....");
                                break;

                            } else {
                                int i = 1;
                                pratik_gereken_bildigim_kelimeler.write("**************************************************************************");
                                pratik_gereken_bildigim_kelimeler.newLine();
                                pratik_gereken_bildigim_kelimeler.write("word : " + kelime.replace("i", "I").toUpperCase());
                                pratik_gereken_bildigim_kelimeler.newLine();
                                System.out.print("Meaning : ");
                                kelime = scanner.nextLine();
                                pratik_gereken_bildigim_kelimeler.write("Meaning : " + kelime);
                                pratik_gereken_bildigim_kelimeler.newLine();
                                pratik_gereken_bildigim_kelimeler.newLine();
                                System.out.print("Synonyms : ");
                                String synonyms = scanner.nextLine();
                                pratik_gereken_bildigim_kelimeler.write("Synonyms :" + synonyms);
                                pratik_gereken_bildigim_kelimeler.newLine();
                                pratik_gereken_bildigim_kelimeler.newLine();

                                System.out.println("example of word in sentence : ");
                                kelime = scanner.nextLine();
                                pratik_gereken_bildigim_kelimeler.write(i + "-)" + kelime);

                                System.out.println("Do yu want to add another example for this word ? (Yes :Enter sentence, No : q)");

                                while (true) {
                                    String add = scanner.nextLine();
                                    if (add.equals("q")) {
                                        System.out.println("exiting word");
                                        pratik_gereken_bildigim_kelimeler.newLine();

                                        break;
                                    } else {
                                        i++;

                                        pratik_gereken_bildigim_kelimeler.newLine();
                                        System.out.println("Do yu want to add another example for this word ? (Yes :Enter sentence, No : q)");

                                        pratik_gereken_bildigim_kelimeler.write(i + "-)" + add);
                                    }
                                }
                            }
                        }

                    } else {

                        System.out.println("Hatali islem tekrar deneyiniz ");
                    }

                }

            } catch (IOException ex) {
                System.out.println("Dosya acilirken hata olustu...");
            }
            System.out.println("Basarili bir sekilde kaydedildi");
            System.out.println("****************************************************");
        }
    }
}
