// crtl+shift + enter  güzel oluyor aynı yöntemle de düzeltilebiliyor 

public class Main {

    public static void main(String[] args) {
        //IEngineer engineer1=new IEngineer(); interface ile referans obje oluşturulamaz
        PcEngineer engineer1 = new PcEngineer(false, false);
//yada  IEngineer engineer1 = new PcEngineer(false, false);   yazabiliriz.  ÇÜNKÜ
//İnterfaceleren herhangi bir obje oluşturamıyoruz  ANCAK onların referanslarını onları implement eden  classların
// objelerine referans olarak gösterbiliyoruz. 

        engineer1.askerlik_durumu_sorgula();
        engineer1.adli_sicil_sorgula();
        System.out.println(engineer1.mezuniye_ort(3.07));
        String[] tecrube = {"Vestel", "Havelsan", "Türsat"};
        engineer1.is_tecrübesi(tecrube);

        System.out.println("********************************************");

        MachineEngineer engineer2 = new MachineEngineer(true, true);
        String[] tecrube2 = {};
        String[] referans = {"Mustafa Murat Coskun", "Ahmet Emin  Sağlık"};
        engineer2.adli_sicil_sorgula();
        engineer2.askerlik_durumu_sorgula();
        System.out.println(engineer2.mezuniye_ort(2.01));

        engineer2.is_tecrübesi(tecrube2);
        
        //engineer2.referans_getir(referans);  yerine 
        // ((MachineEngineer) engineer2).referans_getir(referans); // yazarsak hatamız düzelir ama gerek yok 
        //Bunun yerine   IEngineer engineer2 = new MachineEngineer(true, true); --->   MachineEngineer engineer2 = new MachineEngineer(true, true);
        //yazariz olur biter
        engineer2.calis();
        
        

    }

}
