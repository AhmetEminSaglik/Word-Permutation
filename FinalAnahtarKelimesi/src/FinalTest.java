
public class FinalTest {

    public final int obje_sayisi;// = 4; // ya burda ya da constructer  da deger vermeliyiz
    public final String isim;
    private static int say = 0;

    public FinalTest(String isim) {
        this.isim = isim;
        //obje_sayisi = 4;
        say++;
        obje_sayisi = say;
    }

    public int getSay() {
        return say;
    }

    public void setSay(int say) {
        this.say = say;
    }

}
