
public class MachineEngineer implements IEngineer, ICalisma {

    @Override
    public void calis() {
        System.out.println("Makine mühendisi çalışıyor");
    }

    private boolean askerlik;
    private boolean adli_sicil;

    public MachineEngineer(boolean askerlik, boolean adli_sicil) {
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
        if (array.length == 0) {
            System.out.println("I do not have any work experience...");
        } else {
            System.out.println("I worked as a machine engineer in these companies : ");
            for (String a : array) {
                System.out.print(a + ", ");
            }
        }
        System.out.println();
    }

    public void referans_getir(String[] array) {
        if (array.length == 0) {
            System.out.println("I don't have any references...");
        } else {
            System.out.println("My References: ");
            for (String a : array) {
                System.out.println(a);
            }
        }

    }
}
