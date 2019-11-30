package OyunEkrani;

import Logic.Actions;
import Logic.Oyun_Timer;
import Logic.RoundlarveGecisler;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Oyun_Ekrani extends JPanel {

    Kahraman kahraman = null;
    Dusman dusman = null;
    Oyun_Timer ot = null;
    RoundlarveGecisler rvg = null;

    Actions action = null;
    Buffered_Aktarici ba = null;

    JButton skill1 = null;
    JButton skill2 = null;
    JButton skill3 = null;
    JButton saldir = null;
    JTextField altin = null;
    Oyun_Ekrani_Menu oem = null;

    JProgressBar bizim_can = null;
    JProgressBar dusman_can = null;

    JLayeredPane oyun_ekrani_jlayered_pane = null;
    JFrame oyun_ekrani_jframe = null;
    JTextField round_sayisi_textfield = null;

    final int scale = 30;
    public int karakter_olum_indeks = 0;
    public int karakter_hareket_indeks = 0;
    public int skill1_hareket_indeks = 0;
    public int dog_hareket_indeks = 0;
    public boolean dogus_animasyonu = true;
    public int yok_ol_indeksi = 0;
    public boolean yok_ol_animasyonu = false;

    public Oyun_Ekrani() {
        getOt(); // Oyun başlarsa oyun içi timer başlar.
        getBa(); //Tüm resimleri başta almak için başta bir kere çalıştırıldı.
        getRvg();
        getOyun_ekrani_jframe().add(getOyun_ekrani_jlayered_pane());

        getOyun_ekrani_jlayered_pane().add(this, new Integer(1));
        setBounds(0, 0, 25 * scale, 15 * scale);
        setLayout(null);

        getOyun_ekrani_jlayered_pane().add(getSkill1(), new Integer(2));
        getOyun_ekrani_jlayered_pane().add(getSkill2(), new Integer(2));
        getOyun_ekrani_jlayered_pane().add(getSkill3(), new Integer(2));
        getOyun_ekrani_jlayered_pane().add(getSaldir(), new Integer(2));
        getOyun_ekrani_jlayered_pane().add(getBizim_can(), new Integer(2));
        getOyun_ekrani_jlayered_pane().add(getDusman_can(), new Integer(2));
        getOyun_ekrani_jlayered_pane().add(getRound_sayisi(), new Integer(3));

        getOyun_ekrani_jlayered_pane().add(getOem().getMenu_bg(), new Integer(1));

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (getRvg().round_sayisi <= 11) {
            g.drawImage(ba.map1, 0, 0, 25 * scale, 15 * scale, this);
        } else {
            g.drawImage(ba.map2, 0, 0, 25 * scale, 15 * scale, this);
        }
        if (getRvg().olum) {
            if (karakter_olum_indeks >= 10) {
                karakter_olum_indeks = 0;
                getOt().oyun_devam_ediyor = true;
                getRvg().olum = false;
                getKahraman().setKahraman_kalan_can(getKahraman().getCan());
                getBizim_can().setValue(getKahraman().getKahraman_kalan_can());
            }

            g.drawImage(getBa().karakter_olum[karakter_olum_indeks], -2 * scale, 7 * scale, getBa().karakter_olum[karakter_olum_indeks].getWidth() * 4, getBa().karakter_olum[karakter_olum_indeks].getHeight() * 4, this);

        } else {
            if (karakter_hareket_indeks >= 22) {
                karakter_hareket_indeks = 0;
            }
            g.drawImage(ba.karakter_gorsel[karakter_hareket_indeks], (-2) * scale, 7 * scale, ba.karakter_gorsel[karakter_hareket_indeks].getWidth() * 4, ba.karakter_gorsel[karakter_hareket_indeks].getHeight() * 4, this);

            if (getRvg().round) {
                g.drawImage(getBa().roundlarin_resimleri[getRvg().kucuk_yaratik_sayaci], getDusman().getX(), getDusman().getY(), getBa().roundlarin_resimleri[getRvg().kucuk_yaratik_sayaci].getWidth(), getBa().roundlarin_resimleri[getRvg().kucuk_yaratik_sayaci].getHeight(), this);
            } else if (getRvg().boss_round) {
                if (getRvg().round_sayisi == 6) {
                    if (getRvg().boss_hareket_indeksi >= 18) {
                        getRvg().boss_hareket_indeksi = 0;
                    }
                    g.drawImage(getBa().iskelet_gorsel[getRvg().boss_hareket_indeksi], getDusman().getX(), getDusman().getY() + 11, getBa().iskelet_gorsel[0].getWidth() * 3, getBa().iskelet_gorsel[0].getHeight() * 3, this);
                } else if (getRvg().round_sayisi == 11) {
                    if (getRvg().boss_hareket_indeksi >= 9) {
                        getRvg().boss_hareket_indeksi = 0;
                    }
                    g.drawImage(getBa().cadi_gorsel[getRvg().boss_hareket_indeksi], getDusman().getX(), getDusman().getY() - 2 * scale, getBa().cadi_gorsel[0].getWidth() * 3, getBa().cadi_gorsel[0].getHeight() * 3, this);
                } else if (getRvg().round_sayisi == 16) {
                    if (getRvg().boss_hareket_indeksi >= 9) {
                        getRvg().boss_hareket_indeksi = 0;
                    }
                    g.drawImage(getBa().dana_gorsel[getRvg().boss_hareket_indeksi], getDusman().getX(), getDusman().getY() + (2 * scale), getBa().dana_gorsel[0].getWidth() * 3, getBa().dana_gorsel[0].getHeight() * 3, this);
                } else if (getRvg().round_sayisi == 21) {
                    if (getRvg().boss_hareket_indeksi >= 12) {
                        getRvg().boss_hareket_indeksi = 0;
                    }
                    g.drawImage(getBa().buyucu_gorsel[getRvg().boss_hareket_indeksi], getDusman().getX(), getDusman().getY() - 100, getBa().buyucu_gorsel[0].getWidth() * 3, getBa().buyucu_gorsel[0].getHeight() * 3, this);
                }

            }

            if (getAction().skill1_control) {
                if (skill1_hareket_indeks >= 6) {
                    getAction().skill1_control = false;
                    skill1_hareket_indeks = 0;
                } else {
                    if (skill1_hareket_indeks == 5) {
                        getDusman().setKalan_can(getDusman().getKalan_can() - getKahraman().getSkill1());
                        getDusman_can().setValue(getDusman().getKalan_can());
                    }
                    g.drawImage(getBa().skill1_gorsel[skill1_hareket_indeks], 4 * scale, 1 * scale + 15, getBa().skill1_gorsel[skill1_hareket_indeks].getWidth(), getBa().skill1_gorsel[skill1_hareket_indeks].getHeight(), this);
                }

            }

            if (yok_ol_animasyonu) {
                if (yok_ol_indeksi >= 5) {
                    yok_ol_indeksi = 0;
                }
                g.drawImage(getBa().yok_ol[yok_ol_indeksi], 10 * scale, 2 * scale, getBa().yok_ol[yok_ol_indeksi].getWidth() * 7, getBa().yok_ol[yok_ol_indeksi].getHeight() * 7, this);
                yok_ol_indeksi++;
            } else if (dogus_animasyonu) {
                if (dog_hareket_indeks >= 28) {
                    dog_hareket_indeks = 0;
                }

                g.drawImage(getBa().dog[dog_hareket_indeks], 12 * scale, 5 * scale, getBa().dog[dog_hareket_indeks].getWidth() * 3, getBa().dog[dog_hareket_indeks].getHeight() * 3, this);
                dog_hareket_indeks++;
            }

        }
    }

    public JFrame getOyun_ekrani_jframe() {
        if (oyun_ekrani_jframe == null) {
            oyun_ekrani_jframe = new JFrame();
            oyun_ekrani_jframe.setSize(25 * scale, 23 * scale);
            oyun_ekrani_jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            oyun_ekrani_jframe.setLocationRelativeTo(null);
            oyun_ekrani_jframe.setResizable(false);
            oyun_ekrani_jframe.setVisible(false);

        }
        return oyun_ekrani_jframe;
    }

    public JLayeredPane getOyun_ekrani_jlayered_pane() {
        if (oyun_ekrani_jlayered_pane == null) {
            oyun_ekrani_jlayered_pane = new JLayeredPane();
            oyun_ekrani_jlayered_pane.setBounds(0, 0, 25 * scale, 22 * scale);
            oyun_ekrani_jlayered_pane.setLayout(null);
        }
        return oyun_ekrani_jlayered_pane;
    }

    public JButton getSkill1() {
        if (skill1 == null) {
            skill1 = new JButton();
            skill1.setBounds(2 * scale, 13 * scale, 2 * scale, 2 * scale);
            skill1.setIcon(new ImageIcon("src/images/skill1_icon.png"));
            skill1.setToolTipText("Move Ahead");
            skill1.addActionListener(getAction());
        }
        return skill1;
    }

    public JButton getSkill2() {
        if (skill2 == null) {
            skill2 = new JButton();
            skill2.setBounds(6 * scale, 13 * scale, 2 * scale, 2 * scale);
            skill2.setIcon(new ImageIcon("src/images/sh_skill_icon.png"));
            skill2.setToolTipText("Move Ahead");
            skill2.addActionListener(getAction());

        }
        return skill2;
    }

    public JButton getSkill3() {
        if (skill3 == null) {
            skill3 = new JButton();
            skill3.setBounds(10 * scale, 13 * scale, 2 * scale, 2 * scale);
            skill3.setIcon(new ImageIcon("src/images/can_skill_icon.png"));
            skill3.setToolTipText("Move Ahead");
            skill3.addActionListener(getAction());

        }
        return skill3;
    }

    public JButton getSaldir() {
        if (saldir == null) {
            saldir = new JButton();
            saldir.setBounds(18 * scale, 13 * scale, 5 * scale, 2 * scale);
            saldir.setBorder(BorderFactory.createEmptyBorder());
            saldir.setIcon(new ImageIcon("src/images/attack_icon.png"));
            saldir.setToolTipText("Move Ahead");
            saldir.setFont(new Font("Arial", Font.BOLD, 21));
            saldir.setText("ATTACK");
            saldir.setHorizontalTextPosition(SwingConstants.LEFT);
            saldir.setHorizontalAlignment(SwingConstants.RIGHT);
            saldir.addActionListener(getAction());
        }
        return saldir;
    }

    public JProgressBar getBizim_can() {
        if (bizim_can == null) {
            bizim_can = new JProgressBar(0, 300);
            bizim_can.setBounds(0 * scale, 1 * scale, 7 * scale, 1 * scale);
            bizim_can.setBackground(Color.red);
            bizim_can.setForeground(Color.yellow);
            bizim_can.setValue(getKahraman().getCan());
            bizim_can.setToolTipText(Integer.toString((getKahraman().getCan())));
        }
        return bizim_can;
    }

    public JProgressBar getDusman_can() {
        if (dusman_can == null) {
            dusman_can = new JProgressBar(0, 200);
            dusman_can.setBounds(20 * scale, 1 * scale, 5 * scale, 1 * scale);
            dusman_can.setBackground(Color.red);
            dusman_can.setForeground(Color.YELLOW);
            dusman_can.setValue(200);
            dusman_can.setToolTipText(String.valueOf(200));
            dusman_can.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        }
        return dusman_can;
    }

    public JTextField getRound_sayisi() {
        if (round_sayisi_textfield == null) {
            round_sayisi_textfield = new JTextField();
            round_sayisi_textfield.setBounds(11 * scale, 0, 3 * scale, 2 * scale);
            round_sayisi_textfield.setBackground(new Color(126, 146, 176, 0));
            round_sayisi_textfield.setEditable(false);
            round_sayisi_textfield.setFont(new Font("Arial", Font.BOLD, 50));
            round_sayisi_textfield.setForeground(new Color(27, 137, 60));
            round_sayisi_textfield.setHorizontalAlignment(SwingConstants.CENTER);

        }
        return round_sayisi_textfield;
    }

    public Oyun_Ekrani_Menu getOem() {
        if (oem == null) {
            oem = new Oyun_Ekrani_Menu(getAction(), this);
        }
        return oem;
    }

    public Actions getAction() {
        if (action == null) {
            action = new Actions();
            action.setOe(this);
        }
        return action;
    }

    public Kahraman getKahraman() {
        if (kahraman == null) {
            kahraman = new Kahraman();
        }
        return kahraman;
    }

    public Dusman getDusman() {
        if (dusman == null) {
            dusman = new Dusman();
        }
        return dusman;
    }

    public Buffered_Aktarici getBa() {
        if (ba == null) {
            ba = new Buffered_Aktarici();
        }
        return ba;
    }

    public Oyun_Timer getOt() {
        if (ot == null) {
            ot = new Oyun_Timer(this);
            ot.start();
        }
        return ot;
    }

    public RoundlarveGecisler getRvg() {
        if (rvg == null) {
            rvg = new RoundlarveGecisler();
            rvg.setOe(this);
        }
        return rvg;
    }

    @Override
    public void repaint() {
        super.repaint();
    }

}
