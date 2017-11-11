/**
 * Created by CCNE on 13/10/2017.
 */
public class Shape {
    private String color = "red";
    private boolean filled = true;
    Shape(){

    }
    
    Shape(String color,boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
