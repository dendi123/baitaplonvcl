/**
 * Created by CCNE on 13/10/2017.
 */
public class Circle extends Shape {
    private double radius = 1.0;
    private double centralPointX;
    private double centralPointY;
    private final double PI = 3.14;
    Circle() {

    }

    Circle(double radius, double centralPointX , double centralPointY) {
        this.centralPointX = centralPointX;
        this.centralPointY = centralPointY;
        this.radius = radius;
    }

    Circle(double radius, String color, boolean filled) {
        this.radius = radius;
        this.setColor(color);
        this.setFilled(filled);
    }

    public double getRadius() {
        return radius;
    }

    public double getArea() {
        return PI*radius*radius;
    }

    public double getParameter() {
        return 2*PI*radius;
    }

    public void setCentralPointX(double centralPointX) {
        this.centralPointX = centralPointX;
    }

    public double getCentralPointX() {
        return centralPointX;
    }

    public void setCentralPointY(double centralPointY) {
        this.centralPointY = centralPointY;
    }

    public double getCentralPointY() {
        return centralPointY;
    }

    public void move(double addX , double addY) {
        centralPointY += addX;
        centralPointY += addY;
    }

    public void testing2(double test1, double test2, double test3 , double test4)
    {
        centralPointX += test1;
        centralPointY += test2;
        test3+=centralPointX+centralPointY;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public void testing(double test1 , double test2 , double test3)
    {
        centralPointX += test1;
        centralPointY += test2;
        test3+=centralPointX+centralPointY;
    }

}
