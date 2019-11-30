package Logic;

import OyunEkrani.Oyun_Ekrani;
import java.awt.image.BufferedImage;

public class RoundlarveGecisler {

    Oyun_Ekrani oe = null;

    public int kucuk_yaratik_sayaci = 0;
    public int round_sayisi = 1;
    public int boss_hareket_indeksi = 0;
    public long round_sonrasi_saldiri_bekletme;
    public long dogus_animasyonu;
    public long olum_animasyonu;
    public boolean olum = false;

    int scale = 30;

    public boolean round_basladi = false, round = false, boss_round = false;

    public void roundlar() {
        if (!round_basladi) {

            round_sonrasi_saldiri_bekletme = System.currentTimeMillis();
            if (round_sayisi == 5 || round_sayisi == 10 || round_sayisi == 15 || round_sayisi == 20) {
                getOe().getDusman_can().setBounds(15 * scale, 1 * scale, 10 * scale, 1 * scale);
                getOe().getDusman().setCan(200 * round_sayisi * 2);
                getOe().getDusman().setKalan_can(200 * round_sayisi * 2);
                getOe().getDusman().setSg(10 * round_sayisi * 2);
                getOe().getDusman_can().setMaximum(200 * round_sayisi * 2);
                getOe().getDusman_can().setValue(200 * round_sayisi * 2);
                getOe().getDusman().setX(14 * scale);
                getOe().getDusman().setY(7 * scale);
                boss_round = true;
            } else {
                getOe().getDusman_can().setBounds(20 * scale, 1 * scale, 5 * scale, 1 * scale);
                getOe().getDusman().setCan(200 * round_sayisi);
                getOe().getDusman().setKalan_can(200 * round_sayisi);
                getOe().getDusman().setSg(10 * round_sayisi);
                getOe().getDusman_can().setMaximum(200 * round_sayisi);
                getOe().getDusman_can().setValue(200 * round_sayisi);
                getOe().getDusman().setX(15 * scale);
                getOe().getDusman().setY(11 * scale);
                getOe().getDusman().setHareket(-1 * scale);
                round = true;

            }
            getOe().getRound_sayisi().setText(Integer.toString(round_sayisi));
            round_basladi = true;
            round_sayisi++;
        }

        if (round) {
            if (getOe().getDusman().getX() >= 15 * scale) {
                getOe().getDusman().setHareket(-1 * scale);
            } else if (getOe().getDusman().getX() <= 8 * scale) {
                getOe().getDusman().setHareket(1 * scale);
            }

            getOe().getDusman().setX(getOe().getDusman().getX() + getOe().getDusman().getHareket());
            if ((getOe().getDusman().getX() / 30) == 8) {
                getOe().getKahraman().setKahraman_kalan_can(getOe().getKahraman().getKahraman_kalan_can() - getOe().getDusman().getSg());
                getOe().getBizim_can().setValue(getOe().getKahraman().getKahraman_kalan_can());
            } else if ((getOe().getDusman().getX() / 30) == 15) {
                getOe().getOt().dusman_saldiri_suresi += 750;
            }

            if (getOe().getDusman().getKalan_can() <= 0) {
                kucuk_yaratik_sayaci++;
                round = false;
                boss_round = false;
                round_basladi = false;
                getOe().karakter_hareket_indeks = 0;
                dogus_animasyonu = System.currentTimeMillis();
            } else if (getOe().getKahraman().getKahraman_kalan_can() <= 0) {
                if (6 > round_sayisi) {
                    round_sayisi = 1;
                    kucuk_yaratik_sayaci = 0;
                    getOe().karakter_hareket_indeks = 0;
                    olum = true;

                } else {
                    round_sayisi -= 5;
                    kucuk_yaratik_sayaci -= 4;
                    boss_hareket_indeksi = 0;
                    getOe().karakter_hareket_indeks = 0;
                    olum = true;
                }

                round = false;
                boss_round = false;
                round_basladi = false;
                getOe().getOt().oyun_devam_ediyor = false;
                olum_animasyonu = System.currentTimeMillis();
            }
        } else if (boss_round) {
            boss_hareket_indeksi++;
            if (boss_hareket_indeksi == 8) {
                getOe().getKahraman().setKahraman_kalan_can(getOe().getKahraman().getKahraman_kalan_can() - getOe().getDusman().getSg());
                getOe().getBizim_can().setValue(getOe().getKahraman().getKahraman_kalan_can());
            }

            if (getOe().getDusman().getKalan_can() <= 0) {
                boss_hareket_indeksi = 0;
                boss_round = false;
                round_basladi = false;
                getOe().karakter_hareket_indeks = 0;
                dogus_animasyonu = System.currentTimeMillis();
            } else if (getOe().getKahraman().getKahraman_kalan_can() <= 0) {
                round_sayisi -= 5;
                kucuk_yaratik_sayaci -= 4;
                boss_hareket_indeksi = 0;
                getOe().karakter_hareket_indeks = 0;
                boss_round = false;
                round_basladi = false;
                olum = true;
                getOe().getOt().oyun_devam_ediyor = false;
                olum_animasyonu = System.currentTimeMillis();

            }
        }
    }

    public Oyun_Ekrani getOe() {
        return oe;
    }

    public void setOe(Oyun_Ekrani oe) {
        this.oe = oe;
    }

}
