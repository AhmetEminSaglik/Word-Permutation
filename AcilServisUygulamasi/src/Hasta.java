
public class Hasta implements Comparable<Hasta> {

    private String isim;
    private String sikayet;
    private int oncelik;

    public Hasta(String isim, String sikayet) {
        this.isim = isim;
        this.sikayet = sikayet;
        if (sikayet.equals("Apandisit")) {
            this.oncelik = 3;
        } else if (sikayet.equals("Yanik")) {
            this.oncelik = 2;

        } else {
            this.oncelik = 1;
        }
    }

    @Override
    public String toString() {
        String bilgiler = "Hasta adi : " + isim
                + "\nSikayet :" + sikayet
                + "\nOncelik : " + oncelik;
        return bilgiler;
    }

    @Override
    public int compareTo(Hasta hasta) { // -1 soldakini öne atar  &&  1 sağdakini öne atar 
        if (this.oncelik > hasta.oncelik) {
            /* eğer  (this.oncelik) büyükse  (hasta.oncelik) ' den  return -1 ile  
            (this.oncelik ) olan  hastamızı öne geçirce*/
            return -1;

        } else if (this.oncelik < hasta.oncelik) {
            return 1;  // bu sefer hasta.oncelik daha büyük deger olduğu için hasta.oncelik ön sıraya geçecek

        } else {
            return 0;
        }
    }

}
