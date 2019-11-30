
public class Circle implements GeometricObject {

    protected double radius = 1.0; // --> # protected  ||| + private ||| - public 

    public Circle(double radius) {

        this.radius = radius;
    }

    @Override
    public double cevreBul() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double alanbul() {
        return Math.PI * radius * radius;
    }

}
