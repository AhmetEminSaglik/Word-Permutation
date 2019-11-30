/*
(Bu ne işe yarayacak ?  geri adim attığımda tek_yoldan_giris_sayac--;
  İf(Adimsayisi==tek_yoldan_zorunlu_giris[tek_yoldan_zorunlu_giris_sayaci]=adim_sayisi))
    { doğruca bir adım daha geri atıcam }

 */
 /*
Tek yol diziye girişi almalıyım
int Tek_yon_zorunlu_giris_ilk_adim  //--> atıyorum 75. adımın dogusu tek adimi var 76. adımdaki satir ve sutun buraya eşitlenmeli
 */
import java.util.Random;

public class Oyun_hareket {

    static boolean geri_adim_at = false;
    static boolean zorunlu_yoldan_ilerlendi = false;
    final static int kuzey = 0, kuzeydogu = 1, dogu = 2, guneydogu = 3, guney = 4, guneybati = 5, bati = 6, kuzeybati = 7;
    static int sayac = 0;
    static int kuzey_serberst = 10;
    static int kuzeyDogu_serberst = 10;
    static int dogu_serberst = 10;
    static int guneyDogu_serberst = 10;
    static int guney_serberst = 10;
    static int guneyBati_serberst = 10;
    static int bati_serberst = 10;
    static int kuzeyBati_serberst = 10;
    static int tek_yoldan_zorunlu_giris[] = new int[50];
    static int tek_yoldan_zorunlu_giris_sayaci = 0;
    final static int i = 0, j = 1;
    int Tek_yon_zorunlu_giris_ilk_adim[][] = new int[50][2];
    static int tek_yon_sayacı = 0;
    static Oyun oyun_map = new Oyun();
    static Oyun oyun_map_gecici = new Oyun();

    // yol tıkanmıyor ise true, tıkanıyorsa false
    public boolean[][] Cevreyi_Kontrol_Et_Musayit_Mi() {
        /*Eğer  etrafındaki  yollardan ilerleyip tıkandığımızda adim sayisi 100 olmuyorsa sıkıntı  vardır demektir
        true --> Sıkıntı vardır; false --> Sıkıntı yoktur*/
        boolean geri_bildirim[][] = new boolean[1][8];
//        oyun_map_gecici = oyun_map;
        int ileri_yol_sayaci = 0;
        int kuzey_serberst = -1;
        int kuzeyDogu_serberst = -1;
        int dogu_serberst = -1;
        int guneyDogu_serberst = -1;
        int guney_serberst = -1;
        int guneyBati_serberst = -1;
        int bati_serberst = -1;
        int kuzeyBati_serberst = -1;

        if (Kuzey_Musayit_mi(oyun_map_gecici.dizi, oyun_map_gecici.getSatir(), oyun_map_gecici.getSutun(),
                oyun_map_gecici.getAdim_sayisi(), oyun_map_gecici.muhurlu_bolge, oyun_map_gecici.giris_serbest)) {
            //yalandan_ilerle(bati);

            geri_bildirim[0][kuzey] = true;
            ileri_yol_sayaci++;
            kuzey_serberst = ileri_yol_sayaci;

        } else {
            geri_bildirim[0][kuzey] = false;
        }
        if (KuzeyDogu_Musayit_mi(oyun_map_gecici.dizi, oyun_map_gecici.getSatir(), oyun_map_gecici.getSutun(),
                oyun_map_gecici.getAdim_sayisi(), oyun_map_gecici.muhurlu_bolge, oyun_map_gecici.giris_serbest)) {
            //   yalandan_ilerle(bati);
            ileri_yol_sayaci++;
            kuzeyDogu_serberst = ileri_yol_sayaci;
            geri_bildirim[0][kuzeydogu] = true;
        } else {
            geri_bildirim[0][kuzeydogu] = false;
        }
        if (Dogu_Musayit_mi(oyun_map_gecici.dizi, oyun_map_gecici.getSatir(), oyun_map_gecici.getSutun(),
                oyun_map_gecici.getAdim_sayisi(), oyun_map_gecici.muhurlu_bolge, oyun_map_gecici.giris_serbest)) {
            //      yalandan_ilerle(bati);
            ileri_yol_sayaci++;
            dogu_serberst = ileri_yol_sayaci;
            geri_bildirim[0][dogu] = true;
        } else {
            geri_bildirim[0][dogu] = false;
        }
        if (GuneyDogu_Musayit_mi(oyun_map_gecici.dizi, oyun_map_gecici.getSatir(), oyun_map_gecici.getSutun(),
                oyun_map_gecici.getAdim_sayisi(), oyun_map_gecici.muhurlu_bolge, oyun_map_gecici.giris_serbest)) {
            //    yalandan_ilerle(bati);
            ileri_yol_sayaci++;
            guneyDogu_serberst = ileri_yol_sayaci;
            geri_bildirim[0][guneydogu] = true;
        } else {
            geri_bildirim[0][guneydogu] = false;
        }
        if (Guney_Musayit_mi(oyun_map_gecici.dizi, oyun_map_gecici.getSatir(), oyun_map_gecici.getSutun(),
                oyun_map_gecici.getAdim_sayisi(), oyun_map_gecici.muhurlu_bolge, oyun_map_gecici.giris_serbest)) {
            //  yalandan_ilerle(bati);
            ileri_yol_sayaci++;
            guney_serberst = ileri_yol_sayaci;
            geri_bildirim[0][guney] = true;
        } else {
            geri_bildirim[0][guney] = false;
        }
        if (GuneyBati_Musayit_mi(oyun_map_gecici.dizi, oyun_map_gecici.getSatir(), oyun_map_gecici.getSutun(),
                oyun_map_gecici.getAdim_sayisi(), oyun_map_gecici.muhurlu_bolge, oyun_map_gecici.giris_serbest)) {
            //yalandan_ilerle(bati);
            ileri_yol_sayaci++;
            guneyBati_serberst = ileri_yol_sayaci;
            geri_bildirim[0][guneybati] = true;
        } else {
            geri_bildirim[0][guneybati] = false;
        }
        if (Bati_Musayit_mi(oyun_map_gecici.dizi, oyun_map_gecici.getSatir(), oyun_map_gecici.getSutun(),
                oyun_map_gecici.getAdim_sayisi(), oyun_map_gecici.muhurlu_bolge, oyun_map_gecici.giris_serbest)) {
            /*true doner ise sanki 
            1-)o yönde ilerle(-iyormuşum gibi yapacağım)
            2-) */
            // yalandan_ilerle(bati);
            ileri_yol_sayaci++;
            bati_serberst = ileri_yol_sayaci;
            geri_bildirim[0][bati] = true;
        } else {
            geri_bildirim[0][bati] = false;
        }
        if (KuzeyBati_Musayit_mi(oyun_map_gecici.dizi, oyun_map_gecici.getSatir(), oyun_map_gecici.getSutun(),
                oyun_map_gecici.getAdim_sayisi(), oyun_map_gecici.muhurlu_bolge, oyun_map_gecici.giris_serbest)) {
            //yalandan_ilerle(bati);
            ileri_yol_sayaci++;
            kuzeyBati_serberst = ileri_yol_sayaci;
            geri_bildirim[0][kuzeybati] = true;
        } else {
            geri_bildirim[0][kuzeybati] = false;
        }

        /*  if (oyun_map_gecici.getAdim_sayisi() == 100) {
            return;
        }
        
        if (ileri_yol_sayaci == 0) {
            System.out.println("------->>>>> ------->>>>> ------->>>>> ileri_yol_sayaci  = 0 oldu (Cevreyi kontrol et)");
        }
        if (ileri_yol_sayaci == 1) {

            if (ileri_yol_sayaci == kuzey_serberst) {

                yalandan_ilerle(kuzey);
            } else if (ileri_yol_sayaci == kuzeyDogu_serberst) {
                yalandan_ilerle(kuzeydogu);
            } else if (ileri_yol_sayaci == dogu_serberst) {
                yalandan_ilerle(dogu);
            } else if (ileri_yol_sayaci == Oyun_hareket.guneyDogu_serberst) {
                yalandan_ilerle(guneydogu);
            } else if (ileri_yol_sayaci == guney_serberst) {
                yalandan_ilerle(guney);
            } else if (ileri_yol_sayaci == guneyBati_serberst) {
                yalandan_ilerle(guneybati);
            } else if (ileri_yol_sayaci == bati_serberst) {
                yalandan_ilerle(bati);
            } else if (ileri_yol_sayaci == kuzeyBati_serberst) {
                yalandan_ilerle(kuzeybati);
            }

        } else if (ileri_yol_sayaci == 0) {
            System.out.println("========>=>=>=>=>===>=>=>=>=>=BURAYA HİÇ GİRECEĞİNE İHTİMAL VERMEDİĞİM İÇİN SİLMEDİM DE DOKUNMADIM DA ");
            System.out.println("========>=>=>=>=>===>=>=>=>=>=BURAYA HİÇ GİRECEĞİNE İHTİMAL VERMEDİĞİM İÇİN SİLMEDİM DE DOKUNMADIM DA ");
            System.out.println("========>=>=>=>=>===>=>=>=>=>=BURAYA HİÇ GİRECEĞİNE İHTİMAL VERMEDİĞİM İÇİN SİLMEDİM DE DOKUNMADIM DA ");
            System.out.println("========>=>=>=>=>===>=>=>=>=>=BURAYA HİÇ GİRECEĞİNE İHTİMAL VERMEDİĞİM İÇİN SİLMEDİM DE DOKUNMADIM DA ");
            System.out.println("========>=>=>=>=>===>=>=>=>=>=BURAYA HİÇ GİRECEĞİNE İHTİMAL VERMEDİĞİM İÇİN SİLMEDİM DE DOKUNMADIM DA ");
            System.out.println("========>=>=>=>=>===>=>=>=>=>=BURAYA HİÇ GİRECEĞİNE İHTİMAL VERMEDİĞİM İÇİN SİLMEDİM DE DOKUNMADIM DA ");
            System.out.println("========>=>=>=>=>===>=>=>=>=>=BURAYA HİÇ GİRECEĞİNE İHTİMAL VERMEDİĞİM İÇİN SİLMEDİM DE DOKUNMADIM DA ");
            System.out.println("========>=>=>=>=>===>=>=>=>=>=BURAYA HİÇ GİRECEĞİNE İHTİMAL VERMEDİĞİM İÇİN SİLMEDİM DE DOKUNMADIM DA ");
            System.out.println("========>=>=>=>=>===>=>=>=>=>=BURAYA HİÇ GİRECEĞİNE İHTİMAL VERMEDİĞİM İÇİN SİLMEDİM DE DOKUNMADIM DA ");
            System.out.println("========>=>=>=>=>===>=>=>=>=>=BURAYA HİÇ GİRECEĞİNE İHTİMAL VERMEDİĞİM İÇİN SİLMEDİM DE DOKUNMADIM DA ");
            System.out.println("========>=>=>=>=>===>=>=>=>=>=BURAYA HİÇ GİRECEĞİNE İHTİMAL VERMEDİĞİM İÇİN SİLMEDİM DE DOKUNMADIM DA ");
            System.out.println("========>=>=>=>=>===>=>=>=>=>=BURAYA HİÇ GİRECEĞİNE İHTİMAL VERMEDİĞİM İÇİN SİLMEDİM DE DOKUNMADIM DA ");
            System.out.println("========>=>=>=>=>===>=>=>=>=>=BURAYA HİÇ GİRECEĞİNE İHTİMAL VERMEDİĞİM İÇİN SİLMEDİM DE DOKUNMADIM DA ");


            /*int gecici_satir = oyun_map.getSatir();
            int gecici_sutun = oyun_map.getSutun();

            oyun_map.giris_serbest[oyun_map.getSatir()][oyun_map.getSutun()] = true;
            oyun_map.dizi[oyun_map.getSatir()][oyun_map.getSutun()] = "| * |";
            oyun_map.setAdim_sayisi(oyun_map.getAdim_sayisi() - 1);
            oyun_map.setSatir(Integer.valueOf(oyun_map.son_atlayis_noktasi[oyun_map.getAdim_sayisi()][i]));
            oyun_map.setSutun(Integer.valueOf(oyun_map.son_atlayis_noktasi[oyun_map.getAdim_sayisi()][j]));

            Oyun_hareket.muhurle(gecici_satir, gecici_sutun);
            muhurle(guneybati, guneydogu);
            return false;
        }
        return true;
         */
        return geri_bildirim;
    }

    //88888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888
    //88888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888
    //88888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888
    //88888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888
    //88888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888
    public void ileri_kontrol_yol_tikanmiyor() {
        //  oyun_map_gecici = oyun_map;SIKINTI VAR BURADA 
        int ileri_yol_sayaci = 0;
        int kuzey_serberst = -1;
        int kuzeyDogu_serberst = -1;
        int dogu_serberst = -1;
        int guneyDogu_serberst = -1;
        int guney_serberst = -1;
        int guneyBati_serberst = -1;
        int bati_serberst = -1;
        int kuzeyBati_serberst = -1;

        /*--ACIKLAMALAR-->İlk if'ler gidilebilecek yonleri sayıyor  ve buna ek olarak
         */
        if (Kuzey_Musayit_mi(oyun_map_gecici.dizi, oyun_map_gecici.getSatir(), oyun_map_gecici.getSutun(),
                oyun_map_gecici.getAdim_sayisi(), oyun_map_gecici.muhurlu_bolge, oyun_map_gecici.giris_serbest)) {
            //yalandan_ilerle(bati);
            ileri_yol_sayaci++;
            kuzey_serberst = ileri_yol_sayaci;

        }
        if (KuzeyDogu_Musayit_mi(oyun_map_gecici.dizi, oyun_map_gecici.getSatir(), oyun_map_gecici.getSutun(),
                oyun_map_gecici.getAdim_sayisi(), oyun_map_gecici.muhurlu_bolge, oyun_map_gecici.giris_serbest)) {
            //   yalandan_ilerle(bati);
            ileri_yol_sayaci++;
            kuzeyDogu_serberst = ileri_yol_sayaci;

        }
        if (Dogu_Musayit_mi(oyun_map_gecici.dizi, oyun_map_gecici.getSatir(), oyun_map_gecici.getSutun(),
                oyun_map_gecici.getAdim_sayisi(), oyun_map_gecici.muhurlu_bolge, oyun_map_gecici.giris_serbest)) {
            //      yalandan_ilerle(bati);
            ileri_yol_sayaci++;
            dogu_serberst = ileri_yol_sayaci;

        }
        if (GuneyDogu_Musayit_mi(oyun_map_gecici.dizi, oyun_map_gecici.getSatir(), oyun_map_gecici.getSutun(),
                oyun_map_gecici.getAdim_sayisi(), oyun_map_gecici.muhurlu_bolge, oyun_map_gecici.giris_serbest)) {
            //    yalandan_ilerle(bati);
            ileri_yol_sayaci++;
            guneyDogu_serberst = ileri_yol_sayaci;

        }
        if (Guney_Musayit_mi(oyun_map_gecici.dizi, oyun_map_gecici.getSatir(), oyun_map_gecici.getSutun(),
                oyun_map_gecici.getAdim_sayisi(), oyun_map_gecici.muhurlu_bolge, oyun_map_gecici.giris_serbest)) {
            //  yalandan_ilerle(bati);
            ileri_yol_sayaci++;
            guney_serberst = ileri_yol_sayaci;

        }
        if (GuneyBati_Musayit_mi(oyun_map_gecici.dizi, oyun_map_gecici.getSatir(), oyun_map_gecici.getSutun(),
                oyun_map_gecici.getAdim_sayisi(), oyun_map_gecici.muhurlu_bolge, oyun_map_gecici.giris_serbest)) {
            //yalandan_ilerle(bati);
            ileri_yol_sayaci++;
            guneyBati_serberst = ileri_yol_sayaci;

        }
        if (Bati_Musayit_mi(oyun_map_gecici.dizi, oyun_map_gecici.getSatir(), oyun_map_gecici.getSutun(),
                oyun_map_gecici.getAdim_sayisi(), oyun_map_gecici.muhurlu_bolge, oyun_map_gecici.giris_serbest)) {
            /*true doner ise sanki 
            1-)o yönde ilerle(-iyormuşum gibi yapacağım)
            2-) */
            // yalandan_ilerle(bati);
            ileri_yol_sayaci++;
            bati_serberst = ileri_yol_sayaci;

        }
        if (KuzeyBati_Musayit_mi(oyun_map_gecici.dizi, oyun_map_gecici.getSatir(), oyun_map_gecici.getSutun(),
                oyun_map_gecici.getAdim_sayisi(), oyun_map_gecici.muhurlu_bolge, oyun_map_gecici.giris_serbest)) {
            //yalandan_ilerle(bati);
            ileri_yol_sayaci++;
            kuzeyBati_serberst = ileri_yol_sayaci;

        }
        if (oyun_map_gecici.getAdim_sayisi() == 100) {
            return;
        }
        if (ileri_yol_sayaci == 1) {

            if (ileri_yol_sayaci == kuzey_serberst) {
                yalandan_ilerle(kuzey);
            } else if (ileri_yol_sayaci == kuzeyDogu_serberst) {
                yalandan_ilerle(kuzeydogu);
            } else if (ileri_yol_sayaci == dogu_serberst) {
                yalandan_ilerle(dogu);
            } else if (ileri_yol_sayaci == Oyun_hareket.guneyDogu_serberst) {
                yalandan_ilerle(guneydogu);
            } else if (ileri_yol_sayaci == guney_serberst) {
                yalandan_ilerle(guney);
            } else if (ileri_yol_sayaci == guneyBati_serberst) {
                yalandan_ilerle(guneybati);
            } else if (ileri_yol_sayaci == bati_serberst) {
                yalandan_ilerle(bati);
            } else if (ileri_yol_sayaci == kuzeyBati_serberst) {
                yalandan_ilerle(kuzeybati);
            }

        } else if (ileri_yol_sayaci == 0) { // asıl dizideki son ilerlemeye yıldız koyulacak

            int gecici_satir = oyun_map.getSatir();
            int gecici_sutun = oyun_map.getSutun();

            oyun_map.giris_serbest[oyun_map.getSatir()][oyun_map.getSutun()] = true;
            oyun_map.dizi[oyun_map.getSatir()][oyun_map.getSutun()] = "| * |";
            oyun_map.setAdim_sayisi(oyun_map.getAdim_sayisi() - 1);
            oyun_map.setSatir(Integer.valueOf(oyun_map.son_atlayis_noktasi[oyun_map.getAdim_sayisi()][i]));
            oyun_map.setSutun(Integer.valueOf(oyun_map.son_atlayis_noktasi[oyun_map.getAdim_sayisi()][j]));

            Oyun_hareket.muhurle(gecici_satir, gecici_sutun);
            muhurle(guneybati, guneydogu);
        }
        /*else {
            //System.out.println("Random sonuç : " + random_sonuc);
            oyun_map_gecici.son_atlayis_noktasi[oyun_map_gecici.getAdim_sayisi()][i] = Integer.toString(oyun_map.getSatir()); //i --> satir
            oyun_map_gecici.son_atlayis_noktasi[oyun_map_gecici.getAdim_sayisi()][j] = Integer.toString(oyun_map.getSutun()); //j--> sutun
            //System.out.println("|||||||||||||||||||||||||||-Son atlayıs noktasi : [" + oyun_map.son_atlayis_noktasi[oyun_map.getAdim_sayisi()][i] + "][" + oyun_map.son_atlayis_noktasi[oyun_map.getAdim_sayisi()][j] + "]");

            if (random_sonuc == kuzey_serberst) {
                //System.out.println("if e girildi  yon kuzey " + kuzey_serberst);

                yalandan_ilerle(kuzey);
            } else if (random_sonuc == kuzeyDogu_serberst) {
                //System.out.println("if e girildi  yon kuzeyDogu_serberst " + kuzeyDogu_serberst);
                yalandan_ilerle(Oyun_hareket.kuzeyDogu_serberst);
            } else if (random_sonuc == dogu_serberst) {
                //System.out.println("if e girildi  yon dogu_serberst " + dogu_serberst);
                yalandan_ilerle(dogu);
            } else if (random_sonuc == guneyDogu_serberst) {
                //System.out.println("if e girildi  yon guneyDogu_serberst " + guneyDogu_serberst);
                yalandan_ilerle(guneydogu);
            } else if (random_sonuc == guney_serberst) {
                //System.out.println("if e girildi  yon guney_serberst " + guney_serberst);
                ilerle(oyun_map.dizi, guney);
            } else if (random_sonuc == guneyBati_serberst) {
                //System.out.println("if e girildi  yon guneyBati_serberst " + guneyBati_serberst);

                yalandan_ilerle(guneybati);
            } else if (random_sonuc == bati_serberst) {
                //System.out.println("if e girildi  yon bati_serberst " + bati_serberst);

                yalandan_ilerle(bati);
            } else if (random_sonuc == kuzeyBati_serberst) {
                //System.out.println("if e girildi  yon kuzeyBati_serberst " + kuzeyBati_serberst);

                yalandan_ilerle(kuzeybati);
            } else {
                //System.out.println("--------------------------------->YON SECİLEMEDİ");
            }

        }*/
    }

    public void yalandan_ilerle(int yon) {
        oyun_map_gecici.giris_serbest[oyun_map_gecici.getSatir()][oyun_map_gecici.getSutun()] = false;
        switch (yon) {
            case kuzey:
                oyun_map_gecici.setSatir(oyun_map_gecici.getSatir() + 3);
                break;
            case kuzeydogu:
                oyun_map_gecici.setSatir(oyun_map_gecici.getSatir() + 2);
                oyun_map_gecici.setSutun(oyun_map_gecici.getSutun() + 2);
                break;
            case dogu:
                oyun_map_gecici.setSutun(oyun_map_gecici.getSutun() + 3);
                break;
            case guneydogu:
                oyun_map_gecici.setSatir(oyun_map_gecici.getSatir() - 2);
                oyun_map_gecici.setSutun(oyun_map_gecici.getSutun() + 2);
                break;
            case guney:
                oyun_map_gecici.setSatir(oyun_map_gecici.getSatir() - 3);
                break;
            case guneybati:
                oyun_map_gecici.setSatir(oyun_map_gecici.getSatir() - 2);
                oyun_map_gecici.setSutun(oyun_map_gecici.getSutun() - 2);
                break;
            case bati:
                oyun_map_gecici.setSutun(oyun_map_gecici.getSutun() - 3);
                break;
            case kuzeybati:
                oyun_map_gecici.setSatir(oyun_map_gecici.getSatir() + 2);
                oyun_map_gecici.setSutun(oyun_map_gecici.getSutun() - 2);
                break;
            default:
                System.out.println("yalandan ilerle de hata oluştumus");
        }
        oyun_map_gecici.setAdim_sayisi(oyun_map_gecici.getAdim_sayisi() + 1);

        oyun_map_gecici.giris_serbest[oyun_map_gecici.getSatir()][oyun_map_gecici.getSutun()] = false;
        boolean ileri_kontrol_noktalari[][] = new boolean[1][8];
        /* System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<HANGİ GİRİSLER YASAK ????????????>>>>>>>>>>>>>>>>>>>");
        System.out.println("");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (oyun_map.giris_serbest[i][j] == false) {
                    System.out.println(" asıl--->oyun_map.giris_serbest[" + i + "][" + j + "]" + oyun_map.giris_serbest[i][j]);
                    System.out.println("gecici--->oyun_map_gecici.giris_serbest[" + i + "][" + j + "]" + oyun_map_gecici.giris_serbest[i][j]);
                }
            }
        }*/
 /* System.out.println("----switch sonrasi----> oyun_map_gecici :  adim sayisi :" + oyun_map_gecici.getAdim_sayisi());
        System.out.println("----switch sonrasi----> oyun_map_gecici :  satir : " + oyun_map_gecici.getSatir());
        System.out.println("----switch sonrasi----> oyun_map_gecici :  sutun :" + oyun_map_gecici.getSutun());*/

        ileri_kontrol_noktalari = Cevreyi_Kontrol_Et_Musayit_Mi();

        /*  for (int k = 0; k < 8; k++) {
            if (ileri_kontrol_noktalari[0][k]) {
                System.out.println("( yalandan ileri kontrol)------->>>ileri_kontrol_noktalari [" + 0 + "][" + k + "]:" + ileri_kontrol_noktalari[0][k]);
            }
        }*/
        int sayac = 0;
        for (int i = 0; i < 8; i++) {
            if (ileri_kontrol_noktalari[0][i] == true) {
                sayac++;
                System.out.println("yon : " + i + " sayac =" + sayac);

            }

        }

        if (sayac > 1) {

            System.out.println(" sayac>1 return e girdi ve yalandan ilerle fonk. çıktı");
            oyun_map_gecici.setAdim_sayisi(oyun_map_gecici.getAdim_sayisi() - 1);
            System.out.println("************************************************* yon sayac bitti");
            return;
            //daha bi de bunlara adım sayisi 100 olmuyorsa diye bir şey eklemeliyim

        } else if (sayac < 1) {
            if (tek_yon_sayacı == 0) {
                tek_yon_sayacı++;
                geri_adim_at = true;
                System.out.println(" sayac<1 return e girdi ve yalandan ilerle fonk. çıktı");
                oyun_map_gecici.setAdim_sayisi(oyun_map_gecici.getAdim_sayisi() - 1);
                System.out.println("************************************************* yon sayac bitti");
                return;
            } else if (tek_yon_sayacı == 1) {
                System.out.println("\n\n\n------------------------------------------------------"
                        + "\nBURADA BİR SIKINTI VAR  SAYAC 2. DEFA =0 OLDU"
                        + "\n ARTIK GERİ Mİ GELİRİM BAŞKA BİR ŞEY Mİ YAPARIM O ZAMAN DÜŞÜNÜRÜM\n"
                        + "------------------------------------------------------\n\n\n");
                System.out.println("BELKİDE ZORUNLU OLARAK BİR YOLA SOKTUĞUMUZDA BURAYA GELEBİLİR");
                oyun_map.setSatir(Integer.valueOf(oyun_map.son_atlayis_noktasi[oyun_map.getAdim_sayisi()][i]));
                oyun_map.setSutun(Integer.valueOf(oyun_map.son_atlayis_noktasi[oyun_map.getAdim_sayisi()][j]));
                int yerel_adim_sayisi = Integer.MIN_VALUE;
                while (yerel_adim_sayisi != tek_yoldan_zorunlu_giris[tek_yoldan_zorunlu_giris_sayaci]) {
                    oyun_map.setAdim_sayisi(oyun_map.getAdim_sayisi() - 1);
                    yerel_adim_sayisi = oyun_map.getAdim_sayisi();

                }
                tek_yoldan_zorunlu_giris_sayaci--;
                /*int satir = gecici_satir - oyun_map.getSatir();
        int sutun = gecici_sutun - oyun_map.getSutun();
        switch (satir) {
            case 3:
                oyun_map.muhurlu_bolge[oyun_map.getAdim_sayisi()][kuzey] = true;*/ /*Buraası tekyolsayacı=1 olup da tekrar tekyon çıkarsa diye zorla soktuğumuzda gelebilme ihtimali olan bir yer
                zorla soktuğumuz o yerin  etrafına bakarız ve o en büyüğü alırız (karşılaştırma yaparken) 
                son adım sayılarına bakacaz ve*/ // zorunlu ilerletme olunca  baştaki serbert ilerlemeyi if koşuluyla sokmalıyım else de ise serbert bırakmalıyım
                {
                    return;
                }
            }
        }

        System.out.println(" !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!sayac=1 çıkmadı");
        System.out.println(" !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!sayac=1 çıkmadı");
        System.out.println(" !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!sayac=1 çıkmadı");

        System.out.println("************************************************* yon sayac bitti");
        if (tek_yon_sayacı == 1 && sayac == 1) {
            System.out.println("Hem tek_yon_sayacı = " + tek_yon_sayacı + "\n Hemde sayac = " + sayac);
            System.out.println("Diziyle bu yoldan ilerlemelim");
            tek_yoldan_zorunlu_giris[tek_yoldan_zorunlu_giris_sayaci] = oyun_map.getAdim_sayisi();
            oyun_map.son_atlayis_noktasi[oyun_map.getAdim_sayisi()][i] = Integer.toString(oyun_map.getSatir()); //i --> satir
            oyun_map.son_atlayis_noktasi[oyun_map.getAdim_sayisi()][j] = Integer.toString(oyun_map.getSutun()); //j--> sutun
            oyun_map.setAdim_sayisi(oyun_map.getAdim_sayisi() + 1);
            for (int i = 0; i < 8; i++) {
                if (ileri_kontrol_noktalari[0][i] == true) {

                    System.out.println("İLERLENİLCEK  ---> ---> ---> yon : " + i + " sayac =" + sayac);

                    switch (yon) {
                        case kuzey:
                            ilerle(oyun_map.dizi, yon);
                            break;
                        case kuzeydogu:
                            ilerle(oyun_map.dizi, yon);
                            break;
                        case dogu:
                            ilerle(oyun_map.dizi, yon);
                            break;
                        case guneydogu:
                            ilerle(oyun_map.dizi, yon);
                            break;
                        case guney:
                            ilerle(oyun_map.dizi, yon);
                            break;
                        case guneybati:
                            ilerle(oyun_map.dizi, yon);
                            break;
                        case bati:
                            ilerle(oyun_map.dizi, yon);
                            break;
                        case kuzeybati:
                            ilerle(oyun_map.dizi, yon);
                            break;
                        default:
                            System.out.println("yalandan ilerle de hata oluştumus");

                    }
                    zorunlu_yoldan_ilerlendi = true;
                    Tek_yon_zorunlu_giris_ilk_adim[tek_yoldan_zorunlu_giris_sayaci][i] = oyun_map.getSatir();
                    Tek_yon_zorunlu_giris_ilk_adim[tek_yoldan_zorunlu_giris_sayaci][j] = oyun_map.getSutun();
                    tek_yoldan_zorunlu_giris_sayaci++;

                }
            }

            return;
        }

        if (ileri_kontrol_noktalari[0][0]) {
            System.out.println("Şuanki konum : [" + oyun_map_gecici.getSatir() + "][" + oyun_map_gecici.getSutun() + "] ");
            System.out.println(" sayac=1 çıkmadı ve kuzeye gidiyoruz");
            yalandan_ilerle(kuzey);
        }
        if (ileri_kontrol_noktalari[0][1]) {
            System.out.println("Şuanki konum : [" + oyun_map_gecici.getSatir() + "][" + oyun_map_gecici.getSutun() + "] ");
            System.out.println(" sayac=1 çıkmadı ve kuzeydogu gidiyoruz");
            yalandan_ilerle(kuzeydogu);
        }
        if (ileri_kontrol_noktalari[0][2]) {
            System.out.println("Şuanki konum : [" + oyun_map_gecici.getSatir() + "][" + oyun_map_gecici.getSutun() + "] ");
            System.out.println(" sayac=1 çıkmadı ve dogu gidiyoruz");
            yalandan_ilerle(dogu);
        }
        if (ileri_kontrol_noktalari[0][3]) {
            System.out.println("Şuanki konum : [" + oyun_map_gecici.getSatir() + "][" + oyun_map_gecici.getSutun() + "] ");
            System.out.println(" sayac=1 çıkmadı ve guneydogu gidiyoruz");
            yalandan_ilerle(guneydogu);
        }
        if (ileri_kontrol_noktalari[0][4]) {
            System.out.println("Şuanki konum : [" + oyun_map_gecici.getSatir() + "][" + oyun_map_gecici.getSutun() + "] ");
            System.out.println(" sayac=1 çıkmadı ve guney gidiyoruz");
            yalandan_ilerle(guney);
        }
        if (ileri_kontrol_noktalari[0][5]) {
            System.out.println("Şuanki konum : [" + oyun_map_gecici.getSatir() + "][" + oyun_map_gecici.getSutun() + "] ");
            System.out.println(" sayac=1 çıkmadı ve guneybati gidiyoruz");
            yalandan_ilerle(guneybati);
        }
        if (ileri_kontrol_noktalari[0][6]) {
            System.out.println("Şuanki konum : [" + oyun_map_gecici.getSatir() + "][" + oyun_map_gecici.getSutun() + "] ");
            System.out.println(" sayac=1 çıkmadı ve bati gidiyoruz");
            yalandan_ilerle(bati);
        }
        if (ileri_kontrol_noktalari[0][7]) {
            System.out.println("Şuanki konum : [" + oyun_map_gecici.getSatir() + "][" + oyun_map_gecici.getSutun() + "] ");
            System.out.println("Şuanki konum : [" + oyun_map_gecici.getSatir() + "][" + oyun_map_gecici.getSutun() + "] ");
            System.out.println(" sayac=1 çıkmadı ve kuzeybati gidiyoruz");
            yalandan_ilerle(kuzeybati);
        }
    }

    public static boolean Ilerlenecek_yon_var_mi(String dizi[][], int satir, int sutun, int adimSayisi, boolean muhurluBolge[][], boolean girisSerberst[][]) {
        if (Kuzey_Musayit_mi(dizi, satir, sutun, adimSayisi, muhurluBolge, girisSerberst)
                || KuzeyDogu_Musayit_mi(dizi, satir, sutun, adimSayisi, muhurluBolge, girisSerberst)
                || Dogu_Musayit_mi(dizi, satir, sutun, adimSayisi, muhurluBolge, girisSerberst)
                || GuneyDogu_Musayit_mi(dizi, satir, sutun, adimSayisi, muhurluBolge, girisSerberst)
                || Guney_Musayit_mi(dizi, satir, sutun, adimSayisi, muhurluBolge, girisSerberst)
                || GuneyBati_Musayit_mi(dizi, satir, sutun, adimSayisi, muhurluBolge, girisSerberst)
                || Bati_Musayit_mi(dizi, satir, sutun, adimSayisi, muhurluBolge, girisSerberst)
                || KuzeyBati_Musayit_mi(dizi, satir, sutun, adimSayisi, muhurluBolge, girisSerberst)) {

            return true;
        } else {

            return false;
        }
    }

    public static boolean Kuzey_Musayit_mi(String dizi[][], int satir, int sutun, int adimSayisi, boolean muhurluBolge[][], boolean girisSerberst[][]) {
        try {
            if (satir + 3 < 10
                    && !muhurluBolge[adimSayisi][kuzey]
                    && girisSerberst[satir + 3][sutun]) {
                //System.out.println("K-->oyun_map.giris_serbest[" + (oyun_map.getSatir() + 3) + "][" + (oyun_map.getSutun()) + "] : " + oyun_map.giris_serbest[oyun_map.getSatir() + 3][oyun_map.getSutun()]);
                //System.out.println("kontrol edilirken adim sayisi : " + oyun_map.getAdim_sayisi()
                //+ "      !oyun_map.muhurlu_bolge["+oyun_map.getAdim_sayisi()+"][kuzey]" + !oyun_map.muhurlu_bolge[oyun_map.getAdim_sayisi()][kuzey]);

                return true;
            } else {
                /*  System.out.println("YON KUZEY RETURN FALSE   ==>>> satir :" + satir + " , sutun :" + sutun + ", adim sayisi :" + adimSayisi + "muhurlu bolge mi : "
                        + muhurluBolge[satir][kuzey] + "giris serberst mi :" + girisSerberst[satir][sutun]);*/

                return false;
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            //System.out.println("------------------------------------------> Kuzey_Musayit_mi SINIR DIŞI");
        }
        return false;
    }

    public static boolean Guney_Musayit_mi(String dizi[][], int satir, int sutun, int adimSayisi, boolean muhurluBolge[][], boolean girisSerberst[][]) {
        try {
            if (satir - 3 >= 0
                    && !muhurluBolge[adimSayisi][guney]
                    && girisSerberst[satir - 3][sutun]) {
                //System.out.println("G-->oyun_map.giris_serbest[" + (oyun_map.getSatir() - 3) + "][" + (oyun_map.getSutun()) + "] : " + oyun_map.giris_serbest[oyun_map.getSatir() - 3][oyun_map.getSutun()]);
                //System.out.println("kontrol edilirken adim sayisi : " + oyun_map.getAdim_sayisi()
                //+ "      !oyun_map.muhurlu_bolge["+oyun_map.getAdim_sayisi()+"][guney]" + !oyun_map.muhurlu_bolge[oyun_map.getAdim_sayisi()][guney]);
                return true;
            } else {
                /*  System.out.println("YON GUNEY RETURN FALSE   ==>>> satir :" + satir + " , sutun :" + sutun + ", adim sayisi :" + adimSayisi + "muhurlu bolge mi : "
                        + muhurluBolge[satir][kuzey] + "giris serberst mi :" + girisSerberst[satir][sutun]);*/

                return false;
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            //System.out.println("------------------------------------------> Guney_Musayit_mi  SINIR DIŞI");
        }
        return false;
    }

    public static boolean Dogu_Musayit_mi(String dizi[][], int satir, int sutun, int adimSayisi, boolean muhurluBolge[][], boolean girisSerberst[][]) {

        try {
            if (sutun + 3 < 10
                    && !muhurluBolge[adimSayisi][dogu]
                    && girisSerberst[satir][sutun + 3]) {
                //System.out.println("D-->oyun_map.giris_serbest[" + (oyun_map.getSatir()) + "][" + (oyun_map.getSutun() + 3) + "] : " + oyun_map.giris_serbest[oyun_map.getSatir()][oyun_map.getSutun() + 3]);
                //System.out.println("kontrol edilirken adim sayisi : " + oyun_map.getAdim_sayisi()
                //+ "      !oyun_map.muhurlu_bolge["+oyun_map.getAdim_sayisi()+"][dogu]" + !oyun_map.muhurlu_bolge[oyun_map.getAdim_sayisi()][dogu]);
                return true;
            } else {
                /* System.out.println("YON DOGU RETURN FALSE   ==>>> satir :" + satir + " , sutun :" + sutun + ", adim sayisi :" + adimSayisi + "muhurlu bolge mi : "
                        + muhurluBolge[satir][kuzey] + "giris serberst mi :" + girisSerberst[satir][sutun]);*/

                return false;
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            //System.out.println("------------------------------------------> Dogu_Musayit_mi SINIR DIŞI");
        }
        return false;
    }

    /*if (oyun_map.getSatir() + 2 < 10 && oyun_map.getSutun() - 2 >= 0
                && !oyun_map.muhurlu_bolge[oyun_map.getAdim_sayisi()][kuzeybati]
                && oyun_map.giris_serbest[oyun_map.getSatir() + 2][oyun_map.getSutun() - 2]) */
    public static boolean Bati_Musayit_mi(String dizi[][], int satir, int sutun, int adimSayisi, boolean muhurluBolge[][], boolean girisSerberst[][]) {
        try {
            if (sutun - 3 >= 0
                    && !muhurluBolge[adimSayisi][bati]
                    && girisSerberst[satir][sutun - 3]) {
                //System.out.println("B-->oyun_map.giris_serbest[" + (oyun_map.getSatir()) + "][" + (oyun_map.getSutun() - 3) + "] : " + oyun_map.giris_serbest[oyun_map.getSatir()][oyun_map.getSutun() - 3]);
                //System.out.println("kontrol edilirken adim sayisi : " + oyun_map.getAdim_sayisi()
                //+ "      !oyun_map.muhurlu_bolge["+oyun_map.getAdim_sayisi()+"][bati]" + !oyun_map.muhurlu_bolge[oyun_map.getAdim_sayisi()][bati]);
                return true;
            } else {

                /*System.out.println("YON BATİ RETURN FALSE   ==>>> satir :" + satir + " , sutun :" + sutun + ", adim sayisi :" + adimSayisi + "muhurlu bolge mi : "
                        + muhurluBolge[satir][kuzey] + "giris serberst mi :" + girisSerberst[satir][sutun]);*/
                return false;
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            //System.out.println("------------------------------------------> Bati_Musayit_mi SINIR DIŞI");
        }
        return false;
    }

    public static boolean KuzeyDogu_Musayit_mi(String dizi[][], int satir, int sutun, int adimSayisi, boolean muhurluBolge[][], boolean girisSerberst[][]) {
        try {
            if (satir + 2 < 10 && sutun + 2 < 10
                    && !muhurluBolge[adimSayisi][kuzeydogu]
                    && girisSerberst[satir + 2][sutun + 2]) {
                //System.out.println("KD-->oyun_map.giris_serbest[" + (oyun_map.getSatir() + 2) + "][" + (oyun_map.getSatir() + 2) + "] : " + oyun_map.giris_serbest[oyun_map.getSatir() + 2][oyun_map.getSutun() + 2]);
                //System.out.println("kontrol edilirken adim sayisi : " + oyun_map.getAdim_sayisi()
                //+ "      !oyun_map.muhurlu_bolge["+oyun_map.getAdim_sayisi()+"][kuzeydogu]" + !oyun_map.muhurlu_bolge[oyun_map.getAdim_sayisi()][kuzeydogu]);
                return true;
            } else {
                /*  System.out.println("YON KUZEYDOGU RETURN FALSE   ==>>> satir :" + satir + " , sutun :" + sutun + ", adim sayisi :" + adimSayisi + "muhurlu bolge mi : "
                   + muhurluBolge[satir][kuzey] + "giris serberst mi :" + girisSerberst[satir][sutun]);*/

                return false;
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            //System.out.println("------------------------------------------> KuzeyDogu_Musayit_mi SINIR DIŞI");
        }
        return false;
    }

    public static boolean GuneyDogu_Musayit_mi(String dizi[][], int satir, int sutun, int adimSayisi, boolean muhurluBolge[][], boolean girisSerberst[][]) {
        try {
            if (satir - 2 >= 0 && sutun + 2 < 10
                    && !muhurluBolge[adimSayisi][guneydogu]
                    && girisSerberst[satir - 2][sutun + 2]) {
                //System.out.println("DG-->oyun_map.giris_serbest[" + (oyun_map.getSatir() - 2) + "][" + (oyun_map.getSatir() + 2) + "] : " + oyun_map.giris_serbest[oyun_map.getSatir() - 2][oyun_map.getSutun() + 2]);
                //System.out.println("kontrol edilirken adim sayisi : " + oyun_map.getAdim_sayisi()
                //+ "      !oyun_map.muhurlu_bolge["+oyun_map.getAdim_sayisi()+"][guneydogu]" + !oyun_map.muhurlu_bolge[oyun_map.getAdim_sayisi()][guneydogu]);
                return true;
            } else {
                /*   System.out.println("YON GUNEYDOGU RETURN FALSE   ==>>> satir :" + satir + " , sutun :" + sutun + ", adim sayisi :" + adimSayisi + "muhurlu bolge mi : "
                        + muhurluBolge[satir][kuzey] + "giris serberst mi :" + girisSerberst[satir][sutun]);*/

                return false;
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            //System.out.println("------------------------------------------> GuneyDogu_Musayit_mi SINIR DIŞI");
        }
        return false;
    }

    public static boolean KuzeyBati_Musayit_mi(String dizi[][], int satir, int sutun, int adimSayisi, boolean muhurluBolge[][], boolean girisSerberst[][]) {

        try {
            if (satir + 2 < 10 && sutun - 2 >= 0
                    && !muhurluBolge[adimSayisi][kuzeybati]
                    && girisSerberst[satir + 2][sutun - 2]) {

                //System.out.println("KB-->oyun_map.giris_serbest[" + (oyun_map.getSatir() + 2) + "][" + (oyun_map.getSutun() - 2) + "] : " + oyun_map.giris_serbest[oyun_map.getSatir() + 2][oyun_map.getSutun() - 2]);
                //System.out.println("kontrol edilirken adim sayisi : " + oyun_map.getAdim_sayisi()
                //+ "      !oyun_map.muhurlu_bolge[oyun_map.getAdim_sayisi()][kuzeybati]" + !oyun_map.muhurlu_bolge[oyun_map.getAdim_sayisi()][kuzeybati]);
                return true;
            } else {
                /*  System.out.println("YON KUZEYBATİ RETURN FALSE   ==>>> satir :" + satir + " , sutun :" + sutun + ", adim sayisi :" + adimSayisi + "muhurlu bolge mi : "
                        + muhurluBolge[satir][kuzey] + "giris serberst mi :" + girisSerberst[satir][sutun]);*/

                return false;
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            //System.out.println("------------------------------------------> KuzeyBati_Musayit_mi SINIR DIŞI");
        }
        return false;
    }

    public static boolean GuneyBati_Musayit_mi(String dizi[][], int satir, int sutun, int adimSayisi, boolean muhurluBolge[][], boolean girisSerberst[][]) {
        try {
            if (satir - 2 >= 0 && sutun - 2 >= 0
                    && !muhurluBolge[adimSayisi][guneybati]
                    && girisSerberst[satir - 2][sutun - 2]) {
                //System.out.println("GB-->oyun_map.giris_serbest[" + (oyun_map.getSatir() - 2) + "][" + (oyun_map.getSutun() - 2) + "] : " + oyun_map.giris_serbest[oyun_map.getSatir() - 2][oyun_map.getSutun() - 2]);
                //System.out.println("kontrol edilirken adim sayisi : " + oyun_map.getAdim_sayisi()
                //+ "      !oyun_map.muhurlu_bolge[oyun_map.getAdim_sayisi()][guneybati]" + !oyun_map.muhurlu_bolge[oyun_map.getAdim_sayisi()][guneybati]);
                return true;
            } else {
                /*  System.out.println("YON GUNEYBATİ RETURN FALSE   ==>>> satir :" + satir + " , sutun :" + sutun + ", adim sayisi :" + adimSayisi + "muhurlu bolge mi : "
                        + muhurluBolge[satir][kuzey] + "giris serberst mi :" + girisSerberst[satir][sutun]);*/

                return false;
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            //System.out.println("------------------------------------------> GuneyBati_Musayit_mi SINIR DIŞI");
        }
        return false;
    }

    public static void ilerlenecek_Yonleri_belirle() {

        //System.out.println("---------------------------------------------------------------------------");
        //System.out.println("oyun_map.giris_serbest[oyun_map.getSatir()][oyun_map.getSutun()]  :" + oyun_map.giris_serbest[oyun_map.getSatir()][oyun_map.getSutun()]);
        //oyun_map.giris_serbest[oyun_map.getSatir()][oyun_map.getSutun()] = false;
        //System.out.println("oyun_map.giris_serbest[oyun_map.getSatir()][oyun_map.getSutun()]  :" + oyun_map.giris_serbest[oyun_map.getSatir()][oyun_map.getSutun()]);
        //System.out.println("---------------------------------------------------------------------------");
        //System.out.println("WHİLE SONARSİ -->ilerie-->oyun_map.giris_serbest[" + oyun_map.getSatir() + "][" + oyun_map.getSutun() + "] : " + oyun_map.giris_serbest[oyun_map.getSatir()][oyun_map.getSutun()]);
        //System.out.println("****************************************");
        int sayac = 0;
        int kuzey_serberst = -1;
        int kuzeyDogu_serberst = -1;
        int dogu_serberst = -1;
        int guneyDogu_serberst = -1;
        int guney_serberst = -1;
        int guneyBati_serberst = -1;
        int bati_serberst = -1;
        int kuzeyBati_serberst = -1;

        if (Kuzey_Musayit_mi(oyun_map.dizi, oyun_map.getSatir(), oyun_map.getSutun(), oyun_map.getAdim_sayisi(), oyun_map.muhurlu_bolge, oyun_map.giris_serbest)) {

            kuzey_serberst = sayac;
            sayac++;
        } else {
            // System.out.println(" kuzeye girmedi satir :" + oyun_map.getSatir() + " ," + oyun_map.getSutun() + " ");
        }
        if (KuzeyDogu_Musayit_mi(oyun_map.dizi, oyun_map.getSatir(), oyun_map.getSutun(), oyun_map.getAdim_sayisi(), oyun_map.muhurlu_bolge, oyun_map.giris_serbest)) {
            kuzeyDogu_serberst = sayac;
            sayac++;
        } else {
            //   System.out.println(" kuzeydogu girmedi satir :" + oyun_map.getSatir() + " ," + oyun_map.getSutun() + " ");
        }

        if (Dogu_Musayit_mi(oyun_map.dizi, oyun_map.getSatir(), oyun_map.getSutun(), oyun_map.getAdim_sayisi(), oyun_map.muhurlu_bolge, oyun_map.giris_serbest)) {
            dogu_serberst = sayac;
            sayac++;
        } else {
            // System.out.println(" dogu girmedi satir :" + oyun_map.getSatir() + " ," + oyun_map.getSutun() + " ");
        }
        if (GuneyDogu_Musayit_mi(oyun_map.dizi, oyun_map.getSatir(), oyun_map.getSutun(), oyun_map.getAdim_sayisi(), oyun_map.muhurlu_bolge, oyun_map.giris_serbest)) {
            guneyDogu_serberst = sayac;
            sayac++;
        } else {
            //  System.out.println(" guneydogu girmedi satir :" + oyun_map.getSatir() + " ," + oyun_map.getSutun() + " ");
        }
        if (Guney_Musayit_mi(oyun_map.dizi, oyun_map.getSatir(), oyun_map.getSutun(), oyun_map.getAdim_sayisi(), oyun_map.muhurlu_bolge, oyun_map.giris_serbest)) {
            guney_serberst = sayac;
            sayac++;
        } else {
            // System.out.println(" guney girmedi satir :" + oyun_map.getSatir() + " ," + oyun_map.getSutun() + " ");
        }
        if (GuneyBati_Musayit_mi(oyun_map.dizi, oyun_map.getSatir(), oyun_map.getSutun(), oyun_map.getAdim_sayisi(), oyun_map.muhurlu_bolge, oyun_map.giris_serbest)) {
            guneyBati_serberst = sayac;
            sayac++;
        } else {
            //  System.out.println(" guneybati girmedi satir :" + oyun_map.getSatir() + " ," + oyun_map.getSutun() + " ");
        }
        if (Bati_Musayit_mi(oyun_map.dizi, oyun_map.getSatir(), oyun_map.getSutun(), oyun_map.getAdim_sayisi(), oyun_map.muhurlu_bolge, oyun_map.giris_serbest)) {
            bati_serberst = sayac;

            sayac++;
        } else {
            //System.out.println(" bati girmedi satir :" + oyun_map.getSatir() + " ," + oyun_map.getSutun() + " ");
        }
        if (KuzeyBati_Musayit_mi(oyun_map.dizi, oyun_map.getSatir(), oyun_map.getSutun(), oyun_map.getAdim_sayisi(), oyun_map.muhurlu_bolge, oyun_map.giris_serbest)) {
            kuzeyBati_serberst = sayac;
            sayac++;
        } else {
            //  System.out.println(" kuzeyebati girmedi satir :" + oyun_map.getSatir() + " ," + oyun_map.getSutun() + " ");
        }

        Random random = new Random();
        System.out.println("sayac :" + sayac);
        if (sayac == 0) {
            System.out.println("!!!!!----_____====--->İlerlenecek yon olmadığı halde ilerlenecek yon varmış gibi giriyor kodda hata olabilir!!!");
        }
        int random_sonuc = random.nextInt(sayac);

        //System.out.println("Random sonuç : " + random_sonuc);
        oyun_map.son_atlayis_noktasi[oyun_map.getAdim_sayisi()][i] = Integer.toString(oyun_map.getSatir()); //i --> satir
        oyun_map.son_atlayis_noktasi[oyun_map.getAdim_sayisi()][j] = Integer.toString(oyun_map.getSutun()); //j--> sutun
        //System.out.println("|||||||||||||||||||||||||||-Son atlayıs noktasi : [" + oyun_map.son_atlayis_noktasi[oyun_map.getAdim_sayisi()][i] + "][" + oyun_map.son_atlayis_noktasi[oyun_map.getAdim_sayisi()][j] + "]");

        if (random_sonuc == kuzey_serberst) {
            //System.out.println("if e girildi  yon kuzey " + kuzey_serberst);

            ilerle(oyun_map.dizi, kuzey);
        } else if (random_sonuc == kuzeyDogu_serberst) {
            //System.out.println("if e girildi  yon kuzeyDogu_serberst " + kuzeyDogu_serberst);
            ilerle(oyun_map.dizi, kuzeydogu);
        } else if (random_sonuc == dogu_serberst) {
            //System.out.println("if e girildi  yon dogu_serberst " + dogu_serberst);
            ilerle(oyun_map.dizi, dogu);
        } else if (random_sonuc == guneyDogu_serberst) {
            //System.out.println("if e girildi  yon guneyDogu_serberst " + guneyDogu_serberst);
            ilerle(oyun_map.dizi, guneydogu);
        } else if (random_sonuc == guney_serberst) {
            //System.out.println("if e girildi  yon guney_serberst " + guney_serberst);
            ilerle(oyun_map.dizi, guney);
        } else if (random_sonuc == guneyBati_serberst) {
            //System.out.println("if e girildi  yon guneyBati_serberst " + guneyBati_serberst);
            ilerle(oyun_map.dizi, guneybati);
        } else if (random_sonuc == bati_serberst) {
            //System.out.println("if e girildi  yon bati_serberst " + bati_serberst);
            ilerle(oyun_map.dizi, bati);
        } else if (random_sonuc == kuzeyBati_serberst) {
            //System.out.println("if e girildi  yon kuzeyBati_serberst " + kuzeyBati_serberst);
            ilerle(oyun_map.dizi, kuzeybati);
        } else {
            System.out.println("--------------------------------->YON SECİLEMEDİ");
        }
        oyun_map.giris_serbest[oyun_map.getSatir()][oyun_map.getSutun()] = false;
        System.out.println("ILERLEME KAYDEDİLDİ : " + oyun_map.getSatir() + " , " + oyun_map.getSutun() + " = " + oyun_map.giris_serbest[oyun_map.getSatir()][oyun_map.getSutun()]);

    }

    public static void ilerle(String dizi[][], int yon) {
        oyun_map.giris_serbest[oyun_map.getSatir()][oyun_map.getSutun()] = false;
        oyun_map.setAdim_sayisi(oyun_map.getAdim_sayisi() + 1);
        System.out.println("Adim sayisi  : " + oyun_map.getAdim_sayisi() + "  yonu : " + yon);
        switch (yon) {
            case kuzey:
                try {
                    //System.out.println("İLERLEME ONCESİ -->oyun_map.giris_serbest[" + oyun_map.getSatir() + "][" + oyun_map.getSutun() + "] : " + oyun_map.giris_serbest[oyun_map.getSatir()][oyun_map.getSutun()]);
                    oyun_map.setSatir(oyun_map.getSatir() + 3);
                    //System.out.println("İLERLEME KAYDEDİLDİ -->oyun_map.giris_serbest[" + oyun_map.getSatir() + "][" + oyun_map.getSutun() + "] : " + oyun_map.giris_serbest[oyun_map.getSatir()][oyun_map.getSutun()]);
                } catch (ArrayIndexOutOfBoundsException ex) {
                    //System.out.println(" >>>>>>>>>>>>>>>>>>>>>>>>>--------------------------------->kuzeye ilerle sınır dışı");
                }
                break;
            case kuzeydogu:
                try {
                    //System.out.println("İLERLEME ONCESİ -->oyun_map.giris_serbest[" + oyun_map.getSatir() + "][" + oyun_map.getSutun() + "] : " + oyun_map.giris_serbest[oyun_map.getSatir()][oyun_map.getSutun()]);
                    oyun_map.setSatir(oyun_map.getSatir() + 2);
                    oyun_map.setSutun(oyun_map.getSutun() + 2);
                    //System.out.println("İLERLEME KAYDEDİLDİ -->oyun_map.giris_serbest[" + oyun_map.getSatir() + "][" + oyun_map.getSutun() + "] : " + oyun_map.giris_serbest[oyun_map.getSatir()][oyun_map.getSutun()]);
                } catch (ArrayIndexOutOfBoundsException ex) {
                    //System.out.println(" >>>>>>>>>>>>>>>>>>>>>>>>>--------------------------------->kuzeydogu ilerle sınır dışı");
                }
                break;
            case dogu:
                try {
                    //System.out.println("İLERLEME ONCESİ -->oyun_map.giris_serbest[" + oyun_map.getSatir() + "][" + oyun_map.getSutun() + "] : " + oyun_map.giris_serbest[oyun_map.getSatir()][oyun_map.getSutun()]);
                    oyun_map.setSutun(oyun_map.getSutun() + 3);
                    //System.out.println("İLERLEME KAYDEDİLDİ -->oyun_map.giris_serbest[" + oyun_map.getSatir() + "][" + oyun_map.getSutun() + "] : " + oyun_map.giris_serbest[oyun_map.getSatir()][oyun_map.getSutun()]);
                } catch (ArrayIndexOutOfBoundsException ex) {
                    //System.out.println(" >>>>>>>>>>>>>>>>>>>>>>>>>--------------------------------->dogu ilerle sınır dışı");
                }
                break;
            case guneydogu:
                try {
                    //System.out.println("İLERLEME ONCESİ -->oyun_map.giris_serbest[" + oyun_map.getSatir() + "][" + oyun_map.getSutun() + "] : " + oyun_map.giris_serbest[oyun_map.getSatir()][oyun_map.getSutun()]);
                    oyun_map.setSatir(oyun_map.getSatir() - 2);
                    oyun_map.setSutun(oyun_map.getSutun() + 2);
                    //System.out.println("İLERLEME KAYDEDİLDİ -->oyun_map.giris_serbest[" + oyun_map.getSatir() + "][" + oyun_map.getSutun() + "] : " + oyun_map.giris_serbest[oyun_map.getSatir()][oyun_map.getSutun()]);
                } catch (ArrayIndexOutOfBoundsException ex) {
                    //System.out.println(" >>>>>>>>>>>>>>>>>>>>>>>>>--------------------------------->guneydogu ilerle sınır dışı");
                }
                break;
            case guney:
                try {
                    //System.out.println("İLERLEME ONCESİ -->oyun_map.giris_serbest[" + oyun_map.getSatir() + "][" + oyun_map.getSutun() + "] : " + oyun_map.giris_serbest[oyun_map.getSatir()][oyun_map.getSutun()]);
                    oyun_map.setSatir(oyun_map.getSatir() - 3);
                    //System.out.println("İLERLEME KAYDEDİLDİ -->oyun_map.giris_serbest[" + oyun_map.getSatir() + "][" + oyun_map.getSutun() + "] : " + oyun_map.giris_serbest[oyun_map.getSatir()][oyun_map.getSutun()]);
                } catch (ArrayIndexOutOfBoundsException ex) {
                    //System.out.println(" >>>>>>>>>>>>>>>>>>>>>>>>>--------------------------------->guney ilerle sınır dışı");
                }
                break;
            case guneybati:
                try {
                    //System.out.println("İLERLEME ONCESİ -->oyun_map.giris_serbest[" + oyun_map.getSatir() + "][" + oyun_map.getSutun() + "] : " + oyun_map.giris_serbest[oyun_map.getSatir()][oyun_map.getSutun()]);
                    oyun_map.setSatir(oyun_map.getSatir() - 2);
                    oyun_map.setSutun(oyun_map.getSutun() - 2);
                    //System.out.println("İLERLEME KAYDEDİLDİ -->oyun_map.giris_serbest[" + oyun_map.getSatir() + "][" + oyun_map.getSutun() + "] : " + oyun_map.giris_serbest[oyun_map.getSatir()][oyun_map.getSutun()]);
                } catch (ArrayIndexOutOfBoundsException ex) {
                    //System.out.println(" >>>>>>>>>>>>>>>>>>>>>>>>>--------------------------------->guneybati ilerle sınır dışı");
                }
                break;

            case bati:
                try {
                    //System.out.println("İLERLEME ONCESİ -->oyun_map.giris_serbest[" + oyun_map.getSatir() + "][" + oyun_map.getSutun() + "] : " + oyun_map.giris_serbest[oyun_map.getSatir()][oyun_map.getSutun()]);
                    //System.out.println("İLERLEME ONCESİ -->oyun_map.giris_serbest[" + oyun_map.getSatir() + "][" + oyun_map.getSutun() + "] : " + oyun_map.giris_serbest[oyun_map.getSatir()][oyun_map.getSutun()]);
                    oyun_map.setSutun(oyun_map.getSutun() - 3);
                    //System.out.println("İLERLEME KAYDEDİLDİ -->oyun_map.giris_serbest[" + oyun_map.getSatir() + "][" + oyun_map.getSutun() + "] : " + oyun_map.giris_serbest[oyun_map.getSatir()][oyun_map.getSutun()]);
                } catch (ArrayIndexOutOfBoundsException ex) {
                    //System.out.println(" >>>>>>>>>>>>>>>>>>>>>>>>>--------------------------------->bati ilerle sınır dışı");
                }
                break;

            case kuzeybati:
                try {
                    //System.out.println("İLERLEME ONCESİ -->oyun_map.giris_serbest[" + oyun_map.getSatir() + "][" + oyun_map.getSutun() + "] : " + oyun_map.giris_serbest[oyun_map.getSatir()][oyun_map.getSutun()]);
                    oyun_map.setSatir(oyun_map.getSatir() + 2);
                    oyun_map.setSutun(oyun_map.getSutun() - 2);
                    //System.out.println("İLERLEME KAYDEDİLDİ -->oyun_map.giris_serbest[" + oyun_map.getSatir() + "][" + oyun_map.getSutun() + "] : " + oyun_map.giris_serbest[oyun_map.getSatir()][oyun_map.getSutun()]);
                } catch (ArrayIndexOutOfBoundsException ex) {
                    //System.out.println(" >>>>>>>>>>>>>>>>>>>>>>>>>--------------------------------->kuzeybati ilerle sınır dışı");
                }
                break;

            default:
            //System.out.println("switch(yon de )--> default a girdi");
        }

        //System.out.println("[oyun_map.getSatir()] ANLIK SATIR -->" + oyun_map.getSatir() + "    [oyun_map.getSutun()] ANLIK SUTUN -->" + oyun_map.getSutun());
        //System.out.println("Adim sayisi :" + oyun_map.getAdim_sayisi());
        if (oyun_map.getAdim_sayisi() < 10) {

            dizi[oyun_map.getSatir()][oyun_map.getSutun()] = "| " + Integer.toString(oyun_map.getAdim_sayisi()) + " |";
        } else if (oyun_map.getAdim_sayisi() < 100) {
            dizi[oyun_map.getSatir()][oyun_map.getSutun()] = "|" + Integer.toString(oyun_map.getAdim_sayisi()) + " |";
        } else {
            dizi[oyun_map.getSatir()][oyun_map.getSutun()] = "|" + Integer.toString(oyun_map.getAdim_sayisi()) + "|";
        }

    }

    public static void GeriGel() {
        int gecici_satir = oyun_map.getSatir();
        int gecici_sutun = oyun_map.getSutun();

        oyun_map.giris_serbest[oyun_map.getSatir()][oyun_map.getSutun()] = true;
        oyun_map.dizi[oyun_map.getSatir()][oyun_map.getSutun()] = "| 0 |";
        oyun_map.setAdim_sayisi(oyun_map.getAdim_sayisi() - 1);
        oyun_map.setSatir(Integer.valueOf(oyun_map.son_atlayis_noktasi[oyun_map.getAdim_sayisi()][i]));
        oyun_map.setSutun(Integer.valueOf(oyun_map.son_atlayis_noktasi[oyun_map.getAdim_sayisi()][j]));

        Oyun_hareket.muhurle(gecici_satir, gecici_sutun);

        for (int i = 0; i < 8; i++) {
            oyun_map.muhurlu_bolge[oyun_map.getAdim_sayisi() + 1][i] = false;
            System.out.println("muhurlu bolge temizleniyor [" + (oyun_map.getAdim_sayisi() + 1) + "]");
        }
        if (oyun_map.getAdim_sayisi() == 1) {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    oyun_map.dizi[i][j] = "|   |";
                    oyun_map.giris_serbest[i][j] = true;

                }
            }

            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 8; j++) {
                    oyun_map.muhurlu_bolge[i][j] = false;
                }
            }

            oyun_map.setSutun(oyun_map.getSutun() + 1);
            if (oyun_map.getSutun() == 10) {

                oyun_map.setSatir(oyun_map.getSatir() + 1);
                oyun_map.setSutun(0);
                if (oyun_map.getSatir() == 10) {
                    for (int i = 0; i < 15; i++) {
                        System.out.println("BÜTÜN İHTİMALLER DENENMİŞTİR");
                    }
                    return;

                }
            }

            oyun_map.giris_serbest[oyun_map.getSatir()][oyun_map.getSutun()] = false;
            oyun_map.dizi[oyun_map.getSatir()][oyun_map.getSutun()] = "| " + Integer.toString(oyun_map.getAdim_sayisi()) + " |";

        }

    }

    public static void muhurle(int gecici_satir, int gecici_sutun) {

        int satir = gecici_satir - oyun_map.getSatir();
        int sutun = gecici_sutun - oyun_map.getSutun();
        switch (satir) {
            case 3:
                oyun_map.muhurlu_bolge[oyun_map.getAdim_sayisi()][kuzey] = true;
                //System.out.println("[" + oyun_map.getAdim_sayisi() + "] [kuzey] MÜHÜRLENDİ>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                break;
            case -3:
                oyun_map.muhurlu_bolge[oyun_map.getAdim_sayisi()][guney] = true;
                //System.out.println("[" + oyun_map.getAdim_sayisi() + "] [guney] MÜHÜRLENDİ>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                break;
            case 2:
                switch (sutun) {
                    case 2:
                        oyun_map.muhurlu_bolge[oyun_map.getAdim_sayisi()][kuzeydogu] = true;
                        //System.out.println("[" + oyun_map.getAdim_sayisi() + "] [kuzeydogu] MÜHÜRLENDİ>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                        break;
                    case -2:
                        oyun_map.muhurlu_bolge[oyun_map.getAdim_sayisi()][kuzeybati] = true;
                        //System.out.println("[" + oyun_map.getAdim_sayisi() + "] [kuzeybati] MÜHÜRLENDİ>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                        break;

                }
                break;
            case -2:
                switch (sutun) {
                    case 2:
                        oyun_map.muhurlu_bolge[oyun_map.getAdim_sayisi()][guneydogu] = true;
                        //System.out.println("[" + oyun_map.getAdim_sayisi() + "] [guneydogu] MÜHÜRLENDİ>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                        break;
                    case -2:
                        oyun_map.muhurlu_bolge[oyun_map.getAdim_sayisi()][guneybati] = true;
                        //System.out.println("[" + oyun_map.getAdim_sayisi() + "] [guneydogu] MÜHÜRLENDİ>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                        break;
                }

        }
        switch (sutun) {
            case 3:
                oyun_map.muhurlu_bolge[oyun_map.getAdim_sayisi()][dogu] = true;
                //System.out.println("[" + oyun_map.getAdim_sayisi() + "] [dogu] MÜHÜRLENDİ>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                break;
            case -3:
                oyun_map.muhurlu_bolge[oyun_map.getAdim_sayisi()][bati] = true;
                //System.out.println("[" + oyun_map.getAdim_sayisi() + "] [bati] MÜHÜRLENDİ>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                break;
        }

    }

}
