package OyunEkrani;

import Logic.Actions;
import java.awt.Color;
import java.awt.Font;
import javax.swing.AbstractButton;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ToolTipManager;

public class Oyun_Ekrani_Menu {

    private final int scale = 30;

    private JPanel oyun_ekrani_menu_jpanel = null;

    private JButton skill1_gelistir = null;
    private JButton skill2_gelistir = null;

    private JButton skill3_gelistir = null;

    private JButton sg_gelistir = null;
    private JButton sh_gelistir = null;
    private JButton can_gelistir = null;

    private JButton ekonomi_auto = null;
    private JButton ekonomi_click = null;

    private JLabel gold_icon = null;
    private JTextField gold_miktari = null;
    
    private JLabel menu_bg = null;

    private Actions action = null;
    private Oyun_Ekrani oe = null;

    public Oyun_Ekrani_Menu(Actions action, Oyun_Ekrani oe) {
        this.action = action;
        this.oe = oe;

        ToolTipManager.sharedInstance().setInitialDelay(0);
        getOe().getOyun_ekrani_jlayered_pane().add(getSkill1_gelistir(), new Integer(2));
        getOe().getOyun_ekrani_jlayered_pane().add(getSkill2_gelistir(), new Integer(2));
        getOe().getOyun_ekrani_jlayered_pane().add(getSkill3_gelistir(), new Integer(2));

        getOe().getOyun_ekrani_jlayered_pane().add(getSg_gelistir(), new Integer(2));
        getOe().getOyun_ekrani_jlayered_pane().add(getSh_gelistir(), new Integer(2));
        getOe().getOyun_ekrani_jlayered_pane().add(getCan_gelistir(), new Integer(2));

        getOe().getOyun_ekrani_jlayered_pane().add(getEkonomi_auto(), new Integer(2));
        getOe().getOyun_ekrani_jlayered_pane().add(getEkonomi_click(), new Integer(2));

        getOe().getOyun_ekrani_jlayered_pane().add(getGold_icon(), new Integer(2));
        getOe().getOyun_ekrani_jlayered_pane().add(getGold_miktari(), new Integer(2));

    }



    public JButton getSkill1_gelistir() {
        if (skill1_gelistir == null) {
            skill1_gelistir = new JButton();
            skill1_gelistir.setBounds(scale * 2, scale * 16, 2 * scale, 2 * scale);
            skill1_gelistir.setIcon(new ImageIcon("src/images/skill1_icon_1.png"));
            skill1_gelistir.setToolTipText("Move Ahead");
            skill1_gelistir.addActionListener(action);

        }
        return skill1_gelistir;
    }

    public JButton getSkill2_gelistir() {
        if (skill2_gelistir == null) {
            skill2_gelistir = new JButton();
            skill2_gelistir.setBounds(scale * 6, scale * 16, 2 * scale, 2 * scale);
            skill2_gelistir.setIcon(new ImageIcon("src/images/sh_skill_icon_1.png"));
            skill2_gelistir.setToolTipText("Move Ahead");
            skill2_gelistir.addActionListener(action);
        }
        return skill2_gelistir;
    }

    public JButton getSkill3_gelistir() {
        if (skill3_gelistir == null) {
            skill3_gelistir = new JButton();
            skill3_gelistir.setBounds(scale * 10, scale * 16, 2 * scale, 2 * scale);
            skill3_gelistir.setIcon(new ImageIcon("src/images/can_skill_icon_1.png"));
            skill3_gelistir.setToolTipText("Move Ahead");
            skill3_gelistir.addActionListener(action);

        }
        return skill3_gelistir;
    }

    public JButton getSg_gelistir() {
        if (sg_gelistir == null) {
            sg_gelistir = new JButton();
            sg_gelistir.setBounds(scale * 2, scale * 19, 2 * scale, 2 * scale);
            sg_gelistir.setIcon(new ImageIcon("src/images/sg_icon.png"));
            sg_gelistir.setToolTipText("Move Ahead");
            sg_gelistir.addActionListener(action);

        }
        return sg_gelistir;
    }

    public JButton getSh_gelistir() {
        if (sh_gelistir == null) {
            sh_gelistir = new JButton();
            sh_gelistir.setBounds(scale * 6, scale * 19, 2 * scale, 2 * scale);
            sh_gelistir.setIcon(new ImageIcon("src/images/sh_icon.png"));
            sh_gelistir.setToolTipText("Move Ahead");
            sh_gelistir.addActionListener(action);

        }
        return sh_gelistir;
    }

    public JButton getCan_gelistir() {
        if (can_gelistir == null) {
            can_gelistir = new JButton();
            can_gelistir.setBounds(scale * 10, scale * 19, 2 * scale, 2 * scale);
            can_gelistir.setIcon(new ImageIcon("src/images/health_increase.png"));
            can_gelistir.setToolTipText("Can geliştir");
            can_gelistir.addActionListener(action);
        }
        return can_gelistir;
    }

    public JButton getEkonomi_auto() {
        if (ekonomi_auto == null) {
            ekonomi_auto = new JButton();
            ekonomi_auto.setBounds(scale * 18, scale * 16, 5 * scale, 2 * scale);
            ekonomi_auto.setBorder(BorderFactory.createEmptyBorder());
            ekonomi_auto.setIcon(new ImageIcon("src/images/ekonomi_icon.png"));
            ekonomi_auto.setFont(new Font("Arial", Font.BOLD, 31));
            ekonomi_auto.setText("AUTO");
            ekonomi_auto.setHorizontalTextPosition(SwingConstants.LEFT);
            ekonomi_auto.setHorizontalAlignment(SwingConstants.RIGHT);
            ekonomi_auto.addActionListener(action);
        }
        return ekonomi_auto;
    }

    public JButton getEkonomi_click() {
        if (ekonomi_click == null) {
            ekonomi_click = new JButton();
            ekonomi_click.setBounds(scale * 18, scale * 19, 5 * scale, 2 * scale);
            ekonomi_click.setBorder(BorderFactory.createEmptyBorder());
            ekonomi_click.setIcon(new ImageIcon("src/images/ekonomi_icon.png"));
            ekonomi_click.setFont(new Font("Arial", Font.BOLD, 28));
            ekonomi_click.setText("CLICK");
            ekonomi_click.setHorizontalTextPosition(SwingConstants.LEFT);
            ekonomi_click.setHorizontalAlignment(SwingConstants.RIGHT);
            ekonomi_click.addActionListener(action);
        }
        return ekonomi_click;
    }

    public JLabel getGold_icon() {
        if (gold_icon == null) {
            gold_icon = new JLabel();
            gold_icon.setBounds(scale * 14, scale * 17, 2 * scale, 2 * scale);
            gold_icon.setIcon(new ImageIcon("src/images/gold_icon.png"));
            //gold_icon.
        }
        return gold_icon;
    }

    public JTextField getGold_miktari() {
        if (gold_miktari == null) {
            gold_miktari = new JTextField();
            gold_miktari.setBounds(scale * 14, scale * 19, 2 * scale, 1 * scale);
            gold_miktari.setHorizontalAlignment(SwingConstants.CENTER);
            gold_miktari.setText("100");
            gold_miktari.setEditable(false);
        }
        return gold_miktari;
    }
    
        public JLabel getMenu_bg() {
        if (menu_bg == null) {
            menu_bg = new JLabel();
            menu_bg.setIcon(new ImageIcon("src/images/oyun_menu_alt.png"));
            menu_bg.setBounds(0, 15 * scale, 25 * scale, 7 * scale);
        }
        return menu_bg;
    }

    public Oyun_Ekrani getOe() {
        return oe;
    }
    

}
