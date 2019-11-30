
public interface IDeneme {

    /*private da hata veriyor çünkü constructer yok 
    interface de obje üretemiyoruz o yüzden private alanlar 
    yasaklanmış şekilde karşımıza çıkar*/
    //private int a = 4;
    public int a = 4;
    /*static olmamasına rağmen direk eriştik  
    ÇÜNKÜ  interface obje üretemeyiz o yüzden olduğu gibi kullanabiliyoruz 
    static gibi yani */
    public static int b = 5; //eğer interface de public tanımlıyorsak doğruca deger vermemiz gerekiyor 

    public static String deneme1 = "Deneme1";
    public String deneme2 = "Deneme2";
    public final int c = 6;

    public static void deneme(){
        System.out.println("interface de static tanımlanmış metot ile Deneme yazdirma");}
}
