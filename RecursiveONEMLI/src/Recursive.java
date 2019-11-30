
public class Recursive {

    public static int recursive_int(int deger) {
        boolean sayac;
        if (deger % 3 == 0) {
            sayac = true;
        } else {
            sayac = false;
        }

        int sonuc = 1;
        if (deger < 2) {
            System.out.println("SONUC DONDURUYOR VE YAZILAN DEGER " + sonuc);
            return sonuc;
        } else {
            System.out.println("recursive_int(deger-1); ONCE " + "  Sayac : " + sayac + deger);
            recursive_int(deger - 1);
            System.out.println("recursive_int(deger-1); TEN SONRA " + "  Sayac : " + sayac + deger);
        }
        System.out.println("Bu yazınını çıkmaması lazım normalde");
        return deger;
    }

    public static void recursive_void(int deger) {
        boolean sayac;
        if (deger % 3 == 0) {
            sayac = true;
        } else {
            sayac = false;
        }

        int sonuc = 1;
        if (deger < 2) {
            System.out.println("Bitti " + deger);

        } else {
            recursive_void(deger - 1);
        }
        System.out.println("Bu yazınını çıkmaması lazım normalde" + "  sayac : " + sayac + "  deger :" + deger);

    }

    public static void main(String[] args) {
        System.out.println("-------> recursive_int " + recursive_int(10));
        System.out.println("[[[Anladığım kadarıyla iç içe girdikten sonra  return olunca  returnde sonra ki kodlara"
                + " daha sonra donuyor ]]]");
        //recursive_int(10);
        //System.out.println("recursive_void"); recursive_void(10);
    }
}
