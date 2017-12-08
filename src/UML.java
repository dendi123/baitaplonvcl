import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Panel extends JPanel {
    private String className = "<html>Shape <br>";
    private String attributesName = "<html> - color:String <br>- check:boolean<br>- check:boolean <br>";
    private String methodsName = "<html>+ Shape()<br>+ Shape(String, boolean) <br>";
    int x, y;

    public Panel( Class A, int x, int y) {
        this.className = A.className;
        this.attributesName = A.attributesName;
        this.methodsName = A.methodsName;
        this.x = x;
        this.y = y;
        this.setLocation( x, y);
        //this.setBounds( 100, 100, 200,200);
        this.setLayout( new BoxLayout( this, BoxLayout.Y_AXIS));
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        //
        JLabel labelName = new JLabel(className);
        labelName.setBorder(BorderFactory.createLineBorder(Color.black));
        this.add( labelName);
        //
        JLabel labelAttribute = new JLabel(attributesName);
        labelAttribute.setBorder(BorderFactory.createLineBorder(Color.black));
        this.add( labelAttribute);
        //
        JLabel labelMethod = new JLabel(methodsName);
        labelMethod.setBorder(BorderFactory.createLineBorder(Color.black));
        this.add( labelMethod);
        this.setSize( this.getPreferredSize());
        //
    }

//    class MouseMotionHandler extends MouseMotionAdapter implements MouseListener, MouseWheelListener {
//        public void mousePressed(MouseEvent e) {
//            int lastMouseX = e.getX();
//            int lastMouseY = e.getY();
//        }
//
//        public void mouseWheelMoved(MouseWheelEvent e) {
//            int notches = e.getWheelRotation();
//            scaleFactor = scaleFactor + notches / 10.0;
//            if (scaleFactor < 0.5) {
//                // scaleFactor = 0.5;
//            } else if (scaleFactor > 3.0) {
//                scaleFactor = 3.0;
//            }
//            panelWidth*=scaleFactor;
//            panelHeight*=scaleFactor;
//            repaint();
//        }
//
//        public void mouseReleased(MouseEvent e) {
//        }
//
//        public void mouseEntered(MouseEvent e) {
//        }
//
//        public void mouseExited(MouseEvent e) {
//        }
//
//        public void mouseClicked(MouseEvent e) {
//        }
//    }
}

