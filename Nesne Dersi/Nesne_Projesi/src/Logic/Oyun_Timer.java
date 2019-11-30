package Logic;

import OyunEkrani.Oyun_Ekrani;
import com.sun.glass.events.ViewEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;

public class Oyun_Timer implements ActionListener {

    public boolean oyun_devam_ediyor = false;

    long dusman_saldiri_suresi = System.currentTimeMillis();
    long baslangic = System.currentTimeMillis();
    long gold_auto_sure = System.currentTimeMillis();
    int saldiri_hizi_azaltici = 700;

    Oyun_Ekrani oe = null;
    Timer timer = null;

    public Oyun_Timer(Oyun_Ekrani oe) {
        this.oe = oe;
    }

    public void stop() {
        timer.stop();
    }

    public void start() {
        timer = new Timer(20, this);
        timer.start();
    }

    public Oyun_Ekrani getOe() {
        return oe;
    }

    public void setOe(Oyun_Ekrani oe) {
        this.oe = oe;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (oyun_devam_ediyor) {
            if ((saldiri_hizi_azaltici - getOe().getKahraman().getSh() < System.currentTimeMillis() - baslangic) && System.currentTimeMillis() - getOe().getRvg().round_sonrasi_saldiri_bekletme > 100 && (getOe().getRvg().round || getOe().getRvg().boss_round)) {
                oe.karakter_hareket_indeks++;
                if (oe.karakter_hareket_indeks == 6) {
                    getOe().getDusman().setKalan_can(getOe().getDusman().getKalan_can() - oe.getKahraman().getSg());
                    getOe().getDusman_can().setValue(getOe().getDusman().getKalan_can());
                    getOe().getDusman_can().setToolTipText(Integer.toString(getOe().getDusman().getKalan_can()));
                } else if (oe.karakter_hareket_indeks == 11) {
                    oe.getDusman().setKalan_can(oe.getDusman().getKalan_can() - oe.getKahraman().getSg() * 2);
                    getOe().getDusman_can().setValue(getOe().getDusman().getKalan_can());
                    getOe().getDusman_can().setToolTipText(Integer.toString(getOe().getDusman().getKalan_can()));
                } else if (oe.karakter_hareket_indeks == 18) {
                    oe.getDusman().setKalan_can(oe.getDusman().getKalan_can() - oe.getKahraman().getSg() * 3);
                    getOe().getDusman_can().setValue(getOe().getDusman().getKalan_can());
                    getOe().getDusman_can().setToolTipText(Integer.toString(getOe().getDusman().getKalan_can()));
                }
                baslangic = System.currentTimeMillis();
            }

            if (getOe().getAction().skill2_control && (System.currentTimeMillis() - getOe().getAction().skill2_baslangic_sure) > 5000) {
                getOe().getAction().skill2_control = false;
                saldiri_hizi_azaltici = 700;
            }

            if (System.currentTimeMillis() - gold_auto_sure > 1000) {
                getOe().getKahraman().setGold(getOe().getKahraman().getGold() + getOe().getKahraman().getEkonomi_auto());
                getOe().getOem().getGold_miktari().setText(Integer.toString(getOe().getKahraman().getGold()));
                gold_auto_sure = System.currentTimeMillis();
            }
            if (System.currentTimeMillis() - dusman_saldiri_suresi > 50 && System.currentTimeMillis() - getOe().getRvg().dogus_animasyonu > 3000) {
                dusman_saldiri_suresi = System.currentTimeMillis();
                getOe().getRvg().roundlar();
                getOe().dogus_animasyonu = false;
            } else if (500 > System.currentTimeMillis() - getOe().getRvg().dogus_animasyonu) {
                getOe().yok_ol_animasyonu = true;
                getOe().dog_hareket_indeks = 0;
            } else if (3000 > System.currentTimeMillis() - getOe().getRvg().dogus_animasyonu) {
                getOe().yok_ol_animasyonu = false;
                getOe().yok_ol_indeksi = 0;
                getOe().dogus_animasyonu = true;

            }

            if (getOe().getAction().skill1_control) {
                if (System.currentTimeMillis() - getOe().getAction().skill1_baslangic_sure > 100) {
                    getOe().skill1_hareket_indeks++;
                    getOe().getAction().skill1_baslangic_sure = System.currentTimeMillis();
                }
            }
        } else if (getOe().getRvg().olum && System.currentTimeMillis() - getOe().getRvg().olum_animasyonu > 400) {
            getOe().getRvg().olum_animasyonu = System.currentTimeMillis();
            getOe().karakter_olum_indeks++;
        }
        oe.repaint();

    }

}
