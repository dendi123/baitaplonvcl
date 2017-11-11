/**
 * Created by VAIO on 19-Oct-17.
 */
public class Rectangle extends Shape {
        private double width = 1.0;
        private double length = 1.0;
        private double conerPointX ;
        private double conerPointY ;

    public Rectangle() {

    }

    public Rectangle(double width , double length, double conerPointX, double conerPointY) {
        this.width = width;
        this.length = length;
        this.conerPointX = conerPointX;
        this.conerPointY = conerPointY;
    }

    public Rectangle(double width, double length , String color, boolean filled) {
        this.width = width;
        this.length = length;
        this.setColor(color);
        this.setFilled(filled);
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getWidth() {
        return width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getArea() {
        return this.width*this.length;
    }

    public double getParameter() {
        return (this.width+this.length)*2;
    }

    public void move(double addX , double addY) {
        conerPointX += addX;
        conerPointY += addY;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
