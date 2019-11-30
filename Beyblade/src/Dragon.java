
public class Dragon extends Beyblade {

    private String kutsalCanavar;
    private String gizliYetenek;

    public Dragon(String kutsalCanavar, String gizliYetenek, String beybladeci, int donusHizi, int saldiriGucu) {
        super(beybladeci, donusHizi, saldiriGucu);
        this.kutsalCanavar = kutsalCanavar;
        this.gizliYetenek = gizliYetenek;
    }

    @Override
    public void BilgileridGoster() {
        super.BilgileridGoster(); //To change body of generated methods, choose Tools | Templates.
        System.out.println("Kutsal Canavar adi : " + kutsalCanavar);
        System.out.println("Gizli yetenek : " + gizliYetenek);
    }

    @Override
    public void kutsalCanavarOrtayaCikar() {
      
        System.out.println(getBeybladeci() + " " + kutsalCanavar + " ortaya cikariyor...");
        System.out.println(getBeybladeci() + " 'ın Saldirisi : Hayalet Kasirgasi ");

    }

}
