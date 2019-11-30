/*has a relationship       ------  (düz çizgi sahiplik ifadesi) ya da  ----<> (düz çizgi+ baklava dilimi)  (eşkenar dörtgen --> has a ilişkisi kurar) 
can do   implements             - - - - -  - -|> (kesikli çizgi ok)
is a relatiounship  extends      -------|>(düz çizgi ve üçgen)

~  olunca başına public ya da private gelmiyor 
 */
public class MovableCircle implements Movable {

    private MovablePoint center;
    private int radius;

    /*  MovablePoint center;
    int radius;

   MovablePoint center;
    int radius;public MovableCircle(int radious, MovablePoint center) {
        this.radius = radious;
        this.center = center;
    }*/
    public MovableCircle(int x, int y, int xspeed, int yspeed, int radius) {
        center = new MovablePoint(x, y, xspeed, yspeed);
    }

    public void alanHesapla() {
        double alan = 2 * Math.PI * radius * radius;
        System.out.println("alan : " + alan);
    }

    public void cevreHesapla() {
        double cevre = 2 * Math.PI * radius;
        System.out.println("cevre : " + cevre);
    }

    @Override
    public void moveUp() {
        center.x += center.ySpeed;

    }

    @Override
    public void moveDown() {

    }

    @Override
    public void moveLeft() {

    }

    @Override
    public void moveRight() {

    }

    @Override
    public String toString() {
        return "MovableCircle{" + "center=" + center + ", radius=" + radius + '}';
    }

}
