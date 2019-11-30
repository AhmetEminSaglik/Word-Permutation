package OyunEkrani;

public class Kahraman {

    private int kahraman_kalan_can= 300;
    private int sg = 10;
    private int sh = 100;
    private int can = 300;

    private int skill1 = 100;
    private int skill2 = 200;
    private int skill3 = 100;

    private int gold = 100;

    private int ekonomi_auto = 5;
    private int ekonomi_click = 2;

    public void sg_gelistir() {
        sg += 20;
    }

    public void sh_gelistir() {
        sh += 10;
    }

    public int can_gelistir() {
        can += 20;
        return can;
    }

    public void ekonomi_auto_gelistir() {
        ekonomi_auto += 2;
    }

    public void ekonomi_click_gelistir() {
        ekonomi_click += 1;
    }
    
    public void skill1_gelistir(){
        skill1+=20;
    }
    
    public void skill2_gelistir(){
        skill2+=20;
    }
    
    public void skill3_gelistir(){
        skill3+=20;
    }

    public int getSg() {
        return sg;
    }

    public int getSh() {
        return sh;
    }

    public int getCan() {
        return can;
    }

    public int getSkill1() {
        return skill1;
    }

    public int getSkill2() {
        return skill2;
    }

    public int getSkill3() {
        return skill3;
    }

    public int getGold() {
        return gold;
    }

    public int getEkonomi_auto() {
        return ekonomi_auto;
    }

    public int getEkonomi_click() {
        return ekonomi_click;
    }

    public int getKahraman_kalan_can() {
        return kahraman_kalan_can;
    }
   
    
    
    
    
    //Set metodları

    public void setKahraman_kalan_can(int kahraman_kalan_can) {
        this.kahraman_kalan_can = kahraman_kalan_can;
    }

    public void setSg(int sg) {
        this.sg = sg;
    }

    public void setSh(int sh) {
        this.sh = sh;
    }

    public void setCan(int can) {
        this.can = can;
    }

    public void setSkill1(int skill1) {
        this.skill1 = skill1;
    }

    public void setSkill2(int skill2) {
        this.skill2 = skill2;
    }

    public void setSkill3(int skill3) {
        this.skill3 = skill3;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public void setEkonomi_auto(int ekonomi_auto) {
        this.ekonomi_auto = ekonomi_auto;
    }

    public void setEkonomi_click(int ekonomi_click) {
        this.ekonomi_click = ekonomi_click;
    }
    

}
