
public class Main {

    public static void main(String[] args) {
        MovablePoint map = new MovablePoint(5, 5, 10, 10);
        //MovableCircle mac = new MovableCircle(21, map);
        // mac.alanHesapla();
        //mac.cevreHesapla();
        System.out.println("map : " + map);
        System.out.println("*************************************");
        //System.out.println("mac : " + mac);

        MovableRectangle mr = new MovableRectangle(0, 0, 10, 10, 5, 5);
        System.out.println("mr : " + mr);
        System.out.println("*************************************");
        mr.moveUp();

    }

}
