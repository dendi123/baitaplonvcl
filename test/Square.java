/**
 * Created by VAIO on 19-Oct-17.
 */
public class Square extends Rectangle {
    public Square(){

    }

    public Square(double side) {
        this.setWidth(side);
        this.setLength(side);
    }

    public Square(double side , String color , boolean filled) {
        this.setWidth(side);
        this.setLength(side);
        this.setColor(color);
        this.setFilled(filled);
    }

    public double getSide() {
        return this.getWidth();
    }

    public void setSide(double side) {
        this.setWidth(side);
        this.setLength(side);
    }

    public void setWidth(double side) {
        this.setWidth(side);
    }

    public void setLength(double side) {
        this.setLength(side);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
