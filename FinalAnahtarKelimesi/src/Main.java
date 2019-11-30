
public class Main {

    public static void main(String[] args) {
        FinalTest f1 = new FinalTest("obje1");
        FinalTest f2 = new FinalTest("obje2");
        System.out.println("Obje Sayisi" + f1.obje_sayisi);
        System.out.println("Obje Sayisi" + f2.obje_sayisi);
         
        System.out.println("Databese İsmi : " + Database.databaseIsmi);
        System.out.println("Username : " + Database.userName);
        System.out.println("Password : " + Database.password);

    }
}
