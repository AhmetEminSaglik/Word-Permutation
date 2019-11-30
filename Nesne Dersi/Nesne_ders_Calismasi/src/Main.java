
public class Main {

    public static void main(String[] args) {

        Author Victor_Hugo = new Author("Victor Hugo", "victorhugo@gmail.com", 'm');
        Book Sefiller = new Book("Sefiller", Victor_Hugo, 17.50, 1000);
        Book Deniz_Iscileri = new Book("Deniz İşçileri", Victor_Hugo, 25.50, 250);

        Author Fyodor_Dostoyevski = new Author("Fyodor Dostoyevski", "Fyodor_Dostoyevski@hotmail.com", 'm');
        Book Suc_ve_Ceza = new Book("Suç ve Ceza", Fyodor_Dostoyevski, 22.75, 1453);
        Book Insan_ne_ile_yasar = new Book("İnsan Ne İle Yaşar", Fyodor_Dostoyevski, 19.00, 1550);

        System.out.println(Deniz_Iscileri);

        System.out.println(Sefiller);
        System.out.println(Suc_ve_Ceza);
        System.out.println(Insan_ne_ile_yasar);

    }

}
