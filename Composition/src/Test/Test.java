package Test;
//Has a iliskisi vardır  enharitance ise is a iliskisi vardır 

public class Test {

    
    public static void main(String[] args) {
        Resolution resolutaion = new Resolution(1920, 1080);
        Monitor monitor = new Monitor("VS197DE", "ASUS", "18.5", resolutaion);
        Kasa kasa = new Kasa("Shadow Blade", "Shadow", "Temperli Cam");
        Anakart anakart = new Anakart("B250-PRO", "Asus", 10, "Windows 10");

        Bilgisayar pc = new Bilgisayar(monitor, kasa, anakart);
        pc.getKasa().bilgisayar_ac();
        pc.getMonitor().monitoru_kapat();
        System.out.println("****************************");
        System.out.println("Monitor modeli (pc.getMonitor()): " + pc.getMonitor());
        System.out.println("Anakart modeli (pc.getAnakart()): " + pc.getAnakart());
        System.out.println("Kasa modeli (pc.getKasa()): " + pc.getKasa());
        System.out.println("*************");
        System.out.println("Monitor modeli (pc.getMonitor().getModel()): " + pc.getMonitor().getModel());
        System.out.println("Anakart modeli (pc.getAnakart().getModel()): " + pc.getAnakart().getModel());
        System.out.println("Kasa modeli (pc.getKasa().getModel()): " + pc.getKasa().getModel());

        System.out.println("****************************");
        System.out.println(pc.getMonitor().getBoyut());

        System.out.println(pc.getAnakart().getIsletim_sistemi());
        pc.getAnakart().isletim_sistemi_yukle("Ubuntu 16.04");
        System.out.println("*****************************************************");
        System.out.println(pc.getAnakart().getIsletim_sistemi());
        System.out.println(pc.getMonitor().getResolution().getEn());
        System.out.println(pc.getMonitor().getResolution().getBoy());

    }

}
