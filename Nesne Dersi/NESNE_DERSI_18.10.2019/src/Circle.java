
public class Circle extends Point {

    double r;

    public double getArea() {
        return Math.PI * Math.pow(r, 2);
    }

    public void setR(double r) {
        System.out.println(" gelen r " + r);
        this.r = (r > 2) ? r : (r + 10) ;
        System.out.println("degisiklige ugrayan r " + r);
    }

    @Override
    public double getVolume() {
        return 0.0;
    }

    @Override
    public String getName() {
        return "Circle";
    }

    @Override
    public String toString() {

        return "center = " + super.toString() + "radius = " + this.r + "\n";
    }

}
