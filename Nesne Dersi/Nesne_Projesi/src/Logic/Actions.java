package Logic;

import GirisEkrani.Giris_Ekrani;
import OyunEkrani.Oyun_Ekrani;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Actions implements ActionListener {

    Giris_Ekrani ge = null;
    Oyun_Ekrani oe = null;

    public boolean skill1_control = false;
    public long skill1_baslangic_sure;
    public boolean skill2_control = false;
    public long skill2_baslangic_sure;

    int scale = 30;

    public Oyun_Ekrani getOe() {
        return oe;
    }

    public void setOe(Oyun_Ekrani oe) {
        this.oe = oe;
    }

    public void setGe(Giris_Ekrani ge) {
        this.ge = ge;
    }

    public Giris_Ekrani getGe() {
        return ge;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (getGe() != null) {

            if (ae.getSource() == getGe().getGiris_ekrani_start()) {
                getOe().getOyun_ekrani_jframe().setVisible(true);
                getGe().getGiris_ekrani_jframe().setVisible(false);
            } else if (ae.getSource() == getGe().getGiris_ekrani_cikis()) {
                System.exit(0);
            }

        } else if (getOe() != null) {
            if ((ae.getSource() == getOe().getSaldir())) {
                if (!getOe().getOt().oyun_devam_ediyor) {
                    
                    getOe().getOt().oyun_devam_ediyor = true;
                }
                getOe().getOt().baslangic -= 1000;
                getOe().getKahraman().setGold(getOe().getKahraman().getGold() + getOe().getKahraman().getEkonomi_click());
                getOe().getOem().getGold_miktari().setText(Integer.toString(getOe().getKahraman().getGold()));
            } else if (ae.getSource() == getOe().getOem().getCan_gelistir()) {
                getOe().getKahraman().setCan(getOe().getKahraman().can_gelistir());
                getOe().getBizim_can().setMaximum(getOe().getKahraman().getCan());
            } else if (ae.getSource() == getOe().getOem().getSg_gelistir()) {
                getOe().getKahraman().sg_gelistir();
            } else if (ae.getSource() == getOe().getOem().getSh_gelistir()) {
                getOe().getKahraman().sh_gelistir();
            } else if (ae.getSource() == getOe().getOem().getSkill1_gelistir()) {
                //Burası en son yapılıcak.
            } else if (ae.getSource() == getOe().getOem().getSkill2_gelistir()) {
                getOe().getKahraman().skill2_gelistir();

            } else if (ae.getSource() == getOe().getOem().getSkill3_gelistir()) {
                getOe().getKahraman().skill3_gelistir();
            } else if (ae.getSource() == getOe().getSkill1()) {
                skill1_control = true;
                skill1_baslangic_sure=System.currentTimeMillis();
            } else if (ae.getSource() == getOe().getSkill2()) {
                skill2_control = true;
                skill2_baslangic_sure = System.currentTimeMillis();
                getOe().getOt().saldiri_hizi_azaltici -= getOe().getKahraman().getSkill2();
            } else if (ae.getSource() == getOe().getSkill3()) {
                getOe().getKahraman().setKahraman_kalan_can(getOe().getKahraman().getKahraman_kalan_can() + getOe().getKahraman().getSkill3());
                getOe().getBizim_can().setValue(getOe().getKahraman().getKahraman_kalan_can());
                getOe().getBizim_can().setToolTipText(Integer.toString(getOe().getKahraman().getKahraman_kalan_can()));

            } else if (ae.getSource() == getOe().getOem().getEkonomi_auto()) {
                getOe().getKahraman().ekonomi_auto_gelistir();
            } else if (ae.getSource() == getOe().getOem().getEkonomi_click()) {
                getOe().getKahraman().ekonomi_click_gelistir();
            }

        }

    }

}
