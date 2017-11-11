import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by CCNE on 20/10/2017.
 */
public class Layer {
    private ArrayList<Shape> listOfShape;
    Layer() {
        listOfShape = new ArrayList<Shape>();
    }

    public void deleteTriangle() {

        for (Iterator<Shape> it = listOfShape.iterator();it.hasNext();) {
            Shape shape = it.next();
            if (shape instanceof Triangle) it.remove();
        }
    }

    public void deleteCircle() {

        for (Iterator<Shape> it = listOfShape.iterator();it.hasNext();) {
            Shape shape = it.next();
            if (shape instanceof Circle) it.remove();
        }
    }

    public void addShape(Shape shape) {
        listOfShape.add(shape);
    }

    public boolean doRemainCircle() {
        for (Shape shape : listOfShape) {
            if (shape instanceof Circle) return true;
        }
        return false;
    }

    public boolean doRemainTriangle() {
        for (Shape shape : listOfShape) {
            if (shape instanceof Triangle) return true;
        }
        return false;
    }
}
