
public class Dranza extends Beyblade {

    private String kutsalCanavar;

    public Dranza(String beybladeci, int donusHizi, int saldiriGucu, String kutsalCanavar) {
        super(beybladeci, donusHizi, saldiriGucu);
        this.kutsalCanavar = kutsalCanavar;
    }

    @Override
    public void BilgileridGoster() {
        super.BilgileridGoster(); //To change body of generated methods, choose Tools | Templates.
        System.out.println("Kutsal Canavar adi : " + kutsalCanavar);
    }

    @Override
    public void kutsalCanavarOrtayaCikar() {
        
        System.out.println(getBeybladeci() + " " + kutsalCanavar + " ortaya cikariyor...");
        System.out.println(getBeybladeci() + " 'ın Saldirisi : Alev  Kılıcı");
    }

}
