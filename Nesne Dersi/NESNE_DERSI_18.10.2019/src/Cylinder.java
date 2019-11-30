
public class Cylinder extends Circle {

    int h=3;

    public double getArea() {
        return 2 * Math.PI * Math.pow(super.r, 2) + 2 * Math.PI * this.r * h;
    }

    public double getVolume() {
        return Math.PI * Math.pow(r, 2) * this.h;
    }

    @Override
    public String toString() {
        return super.toString() + "height = " + this.h;
    }

    @Override
    public String getName() {
        return "Cylinder";
    }

}
