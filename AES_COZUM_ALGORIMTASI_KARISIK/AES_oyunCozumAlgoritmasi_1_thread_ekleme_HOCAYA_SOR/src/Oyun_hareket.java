
import java.util.Random;

public class Oyun_hareket {

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
    final static int Max_Satir =5;
    final static int Max_Sutun = 5;

    final static int i = 0, j = 1;

    static Oyun oyun_map = new Oyun();

    public static boolean Ilerlenecek_yon_var_mi(String dizi[][]) {
        if (Kuzey_Musayit_mi(dizi) || KuzeyDogu_Musayit_mi(dizi) || Dogu_Musayit_mi(dizi) || GuneyDogu_Musayit_mi(dizi)
                || Guney_Musayit_mi(dizi) || GuneyBati_Musayit_mi(dizi) || Bati_Musayit_mi(dizi) || KuzeyBati_Musayit_mi(dizi)) {

            return true;
        } else {

            return false;
        }
    }

    public static boolean Kuzey_Musayit_mi(String dizi[][]) {
        try {
            if (oyun_map.getSatir() + 3 < Max_Satir
                    && !oyun_map.muhurlu_bolge[oyun_map.getAdim_sayisi()][kuzey]
                    && oyun_map.giris_serbest[oyun_map.getSatir() + 3][oyun_map.getSutun()]) {
                //System.out.println("K-->oyun_map.giris_serbest[" + (oyun_map.getSatir() + 3) + "][" + (oyun_map.getSutun()) + "] : " + oyun_map.giris_serbest[oyun_map.getSatir() + 3][oyun_map.getSutun()]);
                //System.out.println("kontrol edilirken adim sayisi : " + oyun_map.getAdim_sayisi()
                //+ "      !oyun_map.muhurlu_bolge["+oyun_map.getAdim_sayisi()+"][kuzey]" + !oyun_map.muhurlu_bolge[oyun_map.getAdim_sayisi()][kuzey]);
                return true;
            } else {

                return false;
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            //System.out.println("------------------------------------------> Kuzey_Musayit_mi SINIR DIŞI");
        }
        return false;
    }

    public static boolean Guney_Musayit_mi(String dizi[][]) {
        try {
            if (oyun_map.getSatir() - 3 >= 0
                    && !oyun_map.muhurlu_bolge[oyun_map.getAdim_sayisi()][guney]
                    && oyun_map.giris_serbest[oyun_map.getSatir() - 3][oyun_map.getSutun()]) {
                //System.out.println("G-->oyun_map.giris_serbest[" + (oyun_map.getSatir() - 3) + "][" + (oyun_map.getSutun()) + "] : " + oyun_map.giris_serbest[oyun_map.getSatir() - 3][oyun_map.getSutun()]);
                //System.out.println("kontrol edilirken adim sayisi : " + oyun_map.getAdim_sayisi()
                //+ "      !oyun_map.muhurlu_bolge["+oyun_map.getAdim_sayisi()+"][guney]" + !oyun_map.muhurlu_bolge[oyun_map.getAdim_sayisi()][guney]);
                return true;
            } else {

                return false;
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            //System.out.println("------------------------------------------> Guney_Musayit_mi  SINIR DIŞI");
        }
        return false;
    }

    public static boolean Dogu_Musayit_mi(String dizi[][]) {

        try {
            if (oyun_map.getSutun() + 3 < Max_Sutun
                    && !oyun_map.muhurlu_bolge[oyun_map.getAdim_sayisi()][dogu]
                    && oyun_map.giris_serbest[oyun_map.getSatir()][oyun_map.getSutun() + 3]) {
                //System.out.println("D-->oyun_map.giris_serbest[" + (oyun_map.getSatir()) + "][" + (oyun_map.getSutun() + 3) + "] : " + oyun_map.giris_serbest[oyun_map.getSatir()][oyun_map.getSutun() + 3]);
                //System.out.println("kontrol edilirken adim sayisi : " + oyun_map.getAdim_sayisi()
                //+ "      !oyun_map.muhurlu_bolge["+oyun_map.getAdim_sayisi()+"][dogu]" + !oyun_map.muhurlu_bolge[oyun_map.getAdim_sayisi()][dogu]);
                return true;
            } else {

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
    public static boolean Bati_Musayit_mi(String dizi[][]) {
        try {
            if (oyun_map.getSutun() - 3 >= 0
                    && !oyun_map.muhurlu_bolge[oyun_map.getAdim_sayisi()][bati]
                    && oyun_map.giris_serbest[oyun_map.getSatir()][oyun_map.getSutun() - 3]) {
                //System.out.println("B-->oyun_map.giris_serbest[" + (oyun_map.getSatir()) + "][" + (oyun_map.getSutun() - 3) + "] : " + oyun_map.giris_serbest[oyun_map.getSatir()][oyun_map.getSutun() - 3]);
                //System.out.println("kontrol edilirken adim sayisi : " + oyun_map.getAdim_sayisi()
                //+ "      !oyun_map.muhurlu_bolge["+oyun_map.getAdim_sayisi()+"][bati]" + !oyun_map.muhurlu_bolge[oyun_map.getAdim_sayisi()][bati]);
                return true;
            } else {

                return false;
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            //System.out.println("------------------------------------------> Bati_Musayit_mi SINIR DIŞI");
        }
        return false;
    }

    public static boolean KuzeyDogu_Musayit_mi(String dizi[][]) {
        try {
            if (oyun_map.getSatir() + 2 < Max_Satir && oyun_map.getSutun() + 2 < Max_Sutun
                    && !oyun_map.muhurlu_bolge[oyun_map.getAdim_sayisi()][kuzeydogu]
                    && oyun_map.giris_serbest[oyun_map.getSatir() + 2][oyun_map.getSutun() + 2]) {
                //System.out.println("KD-->oyun_map.giris_serbest[" + (oyun_map.getSatir() + 2) + "][" + (oyun_map.getSatir() + 2) + "] : " + oyun_map.giris_serbest[oyun_map.getSatir() + 2][oyun_map.getSutun() + 2]);
                //System.out.println("kontrol edilirken adim sayisi : " + oyun_map.getAdim_sayisi()
                //+ "      !oyun_map.muhurlu_bolge["+oyun_map.getAdim_sayisi()+"][kuzeydogu]" + !oyun_map.muhurlu_bolge[oyun_map.getAdim_sayisi()][kuzeydogu]);
                return true;
            } else {

                return false;
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            //System.out.println("------------------------------------------> KuzeyDogu_Musayit_mi SINIR DIŞI");
        }
        return false;
    }

    public static boolean GuneyDogu_Musayit_mi(String dizi[][]) {
        try {
            if (oyun_map.getSatir() - 2 >= 0 && oyun_map.getSutun() + 2 < Max_Sutun
                    && !oyun_map.muhurlu_bolge[oyun_map.getAdim_sayisi()][guneydogu]
                    && oyun_map.giris_serbest[oyun_map.getSatir() - 2][oyun_map.getSutun() + 2]) {
                //System.out.println("DG-->oyun_map.giris_serbest[" + (oyun_map.getSatir() - 2) + "][" + (oyun_map.getSatir() + 2) + "] : " + oyun_map.giris_serbest[oyun_map.getSatir() - 2][oyun_map.getSutun() + 2]);
                //System.out.println("kontrol edilirken adim sayisi : " + oyun_map.getAdim_sayisi()
                //+ "      !oyun_map.muhurlu_bolge["+oyun_map.getAdim_sayisi()+"][guneydogu]" + !oyun_map.muhurlu_bolge[oyun_map.getAdim_sayisi()][guneydogu]);
                return true;
            } else {

                return false;
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            //System.out.println("------------------------------------------> GuneyDogu_Musayit_mi SINIR DIŞI");
        }
        return false;
    }

    public static boolean KuzeyBati_Musayit_mi(String dizi[][]) {

        try {
            if (oyun_map.getSatir() + 2 < Max_Satir && oyun_map.getSutun() - 2 >= 0
                    && !oyun_map.muhurlu_bolge[oyun_map.getAdim_sayisi()][kuzeybati]
                    && oyun_map.giris_serbest[oyun_map.getSatir() + 2][oyun_map.getSutun() - 2]) {
                //System.out.println("KB-->oyun_map.giris_serbest[" + (oyun_map.getSatir() + 2) + "][" + (oyun_map.getSutun() - 2) + "] : " + oyun_map.giris_serbest[oyun_map.getSatir() + 2][oyun_map.getSutun() - 2]);
                //System.out.println("kontrol edilirken adim sayisi : " + oyun_map.getAdim_sayisi()
                //+ "      !oyun_map.muhurlu_bolge[oyun_map.getAdim_sayisi()][kuzeybati]" + !oyun_map.muhurlu_bolge[oyun_map.getAdim_sayisi()][kuzeybati]);
                return true;
            } else {

                return false;
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            //System.out.println("------------------------------------------> KuzeyBati_Musayit_mi SINIR DIŞI");
        }
        return false;
    }

    public static boolean GuneyBati_Musayit_mi(String dizi[][]) {
        try {
            if (oyun_map.getSatir() - 2 >= 0 && oyun_map.getSutun() - 2 >= 0
                    && !oyun_map.muhurlu_bolge[oyun_map.getAdim_sayisi()][guneybati]
                    && oyun_map.giris_serbest[oyun_map.getSatir() - 2][oyun_map.getSutun() - 2]) {
                //System.out.println("GB-->oyun_map.giris_serbest[" + (oyun_map.getSatir() - 2) + "][" + (oyun_map.getSutun() - 2) + "] : " + oyun_map.giris_serbest[oyun_map.getSatir() - 2][oyun_map.getSutun() - 2]);
                //System.out.println("kontrol edilirken adim sayisi : " + oyun_map.getAdim_sayisi()
                //+ "      !oyun_map.muhurlu_bolge[oyun_map.getAdim_sayisi()][guneybati]" + !oyun_map.muhurlu_bolge[oyun_map.getAdim_sayisi()][guneybati]);
                return true;
            } else {

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
        oyun_map.giris_serbest[oyun_map.getSatir()][oyun_map.getSutun()] = false;
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

        if (Kuzey_Musayit_mi(oyun_map.dizi)) {

            kuzey_serberst = sayac;
            sayac++;
        }
        if (KuzeyDogu_Musayit_mi(oyun_map.dizi)) {
            kuzeyDogu_serberst = sayac;
            sayac++;
        }

        if (Dogu_Musayit_mi(oyun_map.dizi)) {
            dogu_serberst = sayac;
            sayac++;
        }
        if (GuneyDogu_Musayit_mi(oyun_map.dizi)) {
            guneyDogu_serberst = sayac;
            sayac++;
        }
        if (Guney_Musayit_mi(oyun_map.dizi)) {
            guney_serberst = sayac;
            sayac++;
        }
        if (GuneyBati_Musayit_mi(oyun_map.dizi)) {
            guneyBati_serberst = sayac;
            sayac++;
        }
        if (Bati_Musayit_mi(oyun_map.dizi)) {
            bati_serberst = sayac;

            sayac++;
        }
        if (KuzeyBati_Musayit_mi(oyun_map.dizi)) {
            kuzeyBati_serberst = sayac;
            sayac++;
        }

        Random random = new Random();
       // System.out.println("sayac :" + sayac);
        int random_sonuc = random.nextInt(sayac);
        //System.out.println("kuzey_serberst = " + kuzey_serberst);
        //System.out.println("kuzeyDogu_serberst = " + kuzeyDogu_serberst);
        //System.out.println("dogu_serberst = " + dogu_serberst);
        //System.out.println("guneyDogu_serberst = " + guneyDogu_serberst);
        //System.out.println("guney_serberst = " + guney_serberst);
        //System.out.println("guneyBati_serberst = " + guneyBati_serberst);
        //System.out.println("bati_serberst = " + bati_serberst);
        //System.out.println("kuzeybati = " + kuzeyBati_serberst);

        if (sayac == 0) {
            //System.out.println("!!!!!----_____====--->İlerlenecek yon olmadığı halde ilerlenecek yon varmış gibi giriyor kodda hata olabilir!!!");
        } else {
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
                //System.out.println("--------------------------------->YON SECİLEMEDİ");
            }

        }
    }

    public static void ilerle(String dizi[][], int yon) {
        oyun_map.giris_serbest[oyun_map.getSatir()][oyun_map.getSutun()] = false;
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

        oyun_map.setAdim_sayisi(oyun_map.getAdim_sayisi() + 1);

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

    public static void muhurle(int gecici_satir, int gecici_sutun) {
        int satir = gecici_satir - oyun_map.getSatir();
        int sutun = gecici_sutun - oyun_map.getSutun();
        //System.out.println(" <<>> ADİM SAYİSİ <<>>:" + oyun_map.getAdim_sayisi());
        //System.out.println("----------------------------------------------------------------------------------->>>>>>satir :" + satir);
        //System.out.println("----------------------------------------------------------------------------------->>>>>>sutun :" + sutun);

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
