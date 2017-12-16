/**
 * Created by VAIO on 27-Oct-17.
 */
public class Triangle extends Shape {
    private double edge_1;
    private double edge_2;
    private double topPointX;
    private double topPointY;
    private double angle;

    Triangle(double edge_1, double edge_2, double topPointX, double topPointY, double angle) {
        this.edge_1 = edge_1;
        this.edge_2 = edge_2;
        this.topPointX = topPointX;
        this.topPointY = topPointY;
        this.angle = angle;
    }

    Triangle() {

    }

    public double getEdge_1() {
        return edge_1;
    }

    public void setEdge_1(double edge_1) {
        this.edge_1 = edge_1;
    }

    public double getEdge_2() {
        return edge_2;
    }

    public void setEdge_2(double edge_2) {
        this.edge_2 = edge_2;
    }

    public double getTopPointX() {
        return topPointX;
    }

    public void setTopPointX(double topPointX) {
        this.topPointX = topPointX;
    }

    public double getTopPointY() {
        return topPointY;
    }

    public void setTopPointY(double topPointY) {
        this.topPointY = topPointY;
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public void move(double addX , double addY) {
        topPointX += addX;
        topPointY += addY;
    }
}
