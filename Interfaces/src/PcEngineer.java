    // implementte imzayı attık burda ise bütün fonksiyonları teker teker yazmalıyız 

public class PcEngineer implements IEngineer {

    private boolean askerlik;
    private boolean adli_sicil;

    public PcEngineer(boolean askerlik, boolean adli_sicil) {
        this.askerlik = askerlik;
        this.adli_sicil = adli_sicil;
    }

    @Override
    public void askerlik_durumu_sorgula() {
        if (askerlik) {
            System.out.println("I did my military service...");
        } else {
            System.out.println("I have not done my military service yet...");
        }
    }

    @Override
    public String mezuniye_ort(double derece) {
        return "Ortlamam: " + derece;

    }

    @Override
    public void adli_sicil_sorgula() {
        if (adli_sicil) {
            System.out.println("I have a criminal record...");
        } else {
            System.out.println("I do not have any criminal records...");
        }
    }

    @Override
    public void is_tecrübesi(String[] array) {
        System.out.print("I worked as a computer engineer in these companies : ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");

        }
        System.out.println();
    }

}
