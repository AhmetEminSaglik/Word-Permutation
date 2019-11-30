
public class Point extends Shape {

    int x=3;
    int y=5;

    @Override
    public String getName() {
        return "Point";
    }

    @Override
    public String toString() {
        return "[" + x + "][" + y + "]\n"; //To change body of generated methods, choose Tools | Templates.
    }

}
