
class Hayvan {
    
    private String isim;
    
    public Hayvan(String isim) {
        this.isim = isim;
    }
    
    public String getIsim() {
        return isim;
    }
    
    public void setIsim(String isim) {
        this.isim = isim;
    }
    
    public String konus() {
        return "Hayvan konuşuyor...";
    }
}

class Kedi extends Hayvan {
    
    public Kedi(String isim) {
        super(isim);
    }
    
    @Override
    public String konus() {
        return this.getIsim() + " miyavlıyor..."; //To change body of generated methods, choose Tools | Templates.
    }
    
}

class Kopek extends Hayvan {
    
    public Kopek(String isim) {
        super(isim);
    }
    
    @Override
    public String konus() {
        return this.getIsim() + " Havlıyor..."; //To change body of generated methods, choose Tools | Templates.
    }
    
}

class At extends Hayvan {
    
    public At(String isim) {
        super(isim);
    }
    
    @Override
    public String konus() {
        return this.getIsim() + " Kişniyor..."; //To change body of generated methods, choose Tools | Templates.
    }
    
}

class Kus extends Hayvan {
    
    public Kus(String isim) {
        super(isim);
    }
    
    @Override
    public String konus() {
        return this.getIsim() + " Ötüyor"; //To change body of generated methods, choose Tools | Templates.
    }
    
}

public class Main {

    /*
    public static void konustur(Hayvan hayvan) {
        
        
            System.out.println(hayvan.konus());
        
    }  */
    public static void konustur(Object object) {
        if (object instanceof Kopek) {
            Kopek kopek = (Kopek) object;//tür dönüşümü yapıyoruz kopeğe dönüştürüyoruz
            System.out.println(kopek.konus());
        } else if (object instanceof Kedi) {
            Kedi kedi = (Kedi) object;
            System.out.println(kedi.konus());
        } else if (object instanceof At) {
            At at = (At) object;
            System.out.println(at.konus());
        } else if (object instanceof Hayvan) {
            Hayvan hayvan = (Hayvan) object;
            System.out.println(hayvan.konus());
        }
    }
    
    public static void main(String[] args) {
        /* Hayvan hayvan = new Hayvan("");
        Hayvan hayvan1 = new Kedi("Tekir");//Kedi hayvan sınıfıymış gibi olup hata çıkarmıyor bu işe yarıyor polmorhism 
        Hayvan hayvan2 = new Kopek("Karabaş");//1 tane referans birden farklı obje gibi davranıyor
        Hayvan hayvan3 = new At("Şahbatur");
        System.out.println(hayvan.konus());
        System.out.println(hayvan1.konus());
        System.out.println(hayvan2.konus());
        System.out.println(hayvan3.konus());*/

 /*konustur(new Kedi("Tekir"));
        konustur(new Kopek("Karabas"));
        konustur(new At("Şahbatur "));
        Kopek kopek = new Kopek("pitpul");
         */
        Kopek kopek = new Kopek("Karabas");
        Kedi kedi = new Kedi("Tekir");
        At at = new At("Şahbatur");
        Hayvan hayvan = new Hayvan("Limon");
        Hayvan hayvan1 = new Hayvan("Timsah");
        Kus kus = new Kus("Zeytin");
        konustur(kopek);
        konustur(kedi);
        konustur(at);
        konustur(hayvan);
        konustur(kus);
        konustur(hayvan1);


        /*  if (kopek instanceof Kopek) {   // referansı objeye ait olup olmadığı belirlemek için 0-1 degeri  
            //döndüren kod -->  (refereans)instanceof (Nesne)
            System.out.println(kopek.getIsim() + " Bu nesne kopek sınıfından ");
        } else {
            System.out.println(kopek.getIsim() + " Bu nesne Kopek sınıfından DEĞİL");
        }
        if (kopek instanceof Hayvan) {   // referansı objeye ait olup olmadığı belirlemek için 0-1 degeri  
            //döndüren kod -->  (refereans)instanceof (Nesne)
            System.out.println(kopek.getIsim() + " Bu nesne Hayvan sınıfından ");
        } else {
            System.out.println(kopek.getIsim() + " Bu nesne Hayvan sınıfından DEĞİL");
        }*/ /*___Şartlar____
    Bir tane ana class (Bizim burda ana clasımız Hayvan clasımız )
    Geri kalanlar alt sınıf 
    Alt classların referansların üst classların referansına eşitleyebiliyoruz
     Bir diper güzel yanıda eğer override edilmemişse üst fonksiyonundaki metot çalışır */
    }
}
