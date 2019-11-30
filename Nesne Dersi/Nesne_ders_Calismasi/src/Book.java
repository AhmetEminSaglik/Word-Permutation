
public class Book {

    private String name;
    private Author author;
    private double price;
    private int qty;

    public Book(String name, Author author, double price, int qty) {
        setName(name);
        //this.name = name;

        this.author = author;
        this.price = price;
        this.qty = qty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        System.out.println(author);
        System.out.print("----------------");
        String bilgiler
                = /*"Author's Name : " + getAuthor().getName()
                + "\nAuthor's Email :" + getAuthor().getEmail()
                + "\nAuthor's Gender : " + getAuthor().getGender()+*/ "\nBook Name : " + getName()
                + "\nBook Price : " + getPrice()
                + "\nBook QTY : " + getQty()
                + "\n*****************************************************************************************************\n";

        return bilgiler + getAuthor().toString() + "\n" + "\n" + "\n" + "\n" + "\n";
    }

}
