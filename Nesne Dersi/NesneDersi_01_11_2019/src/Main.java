/*
yukarı düz çizgi, üçgen  a relationship(extends) 
yukarı kesikli çizgi, üçgen   implements
yukarı düz çizgi, eşkenar dörtgen has a relationship  
 */
public class Main {

    public static void main(String[] args) {
        Kopek kopek = new Kopek();

        Animal animal1 = new Kopek();
        animal1.animalSound();
        animal1.run();

    }

}
