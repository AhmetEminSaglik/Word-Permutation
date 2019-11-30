
public class BeybladeFabrikasi {

    public Beyblade elimizdeki_Beybladeler(String beyblade_turu) {  //Public String void int gibi class ismi olan Beyblade kullandık
        if (beyblade_turu.equals("Dragon")) {
            return new Dragon("Mavi Ejderha", "Takao", "Kutsal Canavarla konusma", 800, 300);

        } else if (beyblade_turu.equals("Dranza")) {
            return new Dranza("Kai", 600, 400, "Kırmızı Anka Kusu");
        } else if (beyblade_turu.equals("Drayga")) {
            return new Drayga("Beyaz Kaplan", "Rei", 800, 250);

        } else if (beyblade_turu.contains("Draciel")) {
            return new Draciel("Kara Kaplumbaga", "Max", 400, 1000);
        } else {
            return null;
        }
    }
}
