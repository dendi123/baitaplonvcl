import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import javax.swing.*;

class Panel extends JPanel {
    private String className = "";
    private String attributesName = "";
    private String methodsName = "";
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
}
// cai mainparl nay co lam gì tren day đâu JFRAMe nó hiện cái Panel ma> Uh thi minh zoom cai panel ma. co cai scale cua anh kia con gi, nhung cai bang
// cai diagram đâu vẽ trên panel này. Co ma?
// nhận rồi nhưng hình như nó đ thay đổi
class MainPanel extends JPanel {
    int lastMouseX = 0, lastMouseY = 0;
    double scaleFactor = 1;
    int panelWidth = 960;
    int panelHeight = 720;
    private double scale = 1.5;
    MainPanel(){
        MouseMotionHandler mouseHandler = new MouseMotionHandler();
        addMouseMotionListener(mouseHandler);
        addMouseListener(mouseHandler);
        addMouseWheelListener(mouseHandler);
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        AffineTransform at = new AffineTransform();
        at.scale(scaleFactor, scaleFactor);
        g2.transform(at);

        //ngon roofi
        //=))). ok, còn gì nữa ko. Cofn cai file input luc chay file main y
    }
    class MouseMotionHandler extends MouseMotionAdapter implements
            MouseListener, MouseWheelListener {

        public void mousePressed(MouseEvent e) {
            lastMouseX = e.getX();
            lastMouseY = e.getY();
//            System.out.println("FSDFSDF");
        }
//        public void mouseDragged(MouseEvent e) {
//            Rectangle rec = new Rectangle(imageX,imageY,300,300);
//
//            if (rec.contains(e.getX()/scaleFactor,e.getY()/scaleFactor)) {
//                int xDiff = e.getX() - lastMouseX;
//                int yDiff = e.getY() - lastMouseY;
//                imageX = imageX + (int) (xDiff / scaleFactor);
//                imageY = imageY + (int) (yDiff / scaleFactor);
//                lastMouseX = e.getX();
//                lastMouseY = e.getY();
//                panelWidth = Math.max(panelWidth, imageX + 300);
//                panelHeight = Math.max(panelWidth, imageY + 300);
//                //this.setPreferredSize(panelWidth,panelHeight);
//                repaint();
//            }
//        }

        public void mouseWheelMoved(MouseWheelEvent e) {
            int notches = e.getWheelRotation();
            scaleFactor = scaleFactor + notches / 10.0;
            if (scaleFactor < 0.5) {
                //scaleFactor = 0.5;
            } else if (scaleFactor > 3.0) {
                scaleFactor = 3.0;
            }
            panelWidth*=scaleFactor;
            panelHeight*=scaleFactor;
            System.out.println("FSDFSDF");
            //this.setPreferredSize(panelWidth,panelHeight);
            repaint();
        }

        public void mouseReleased(MouseEvent e) {
        }

        public void mouseEntered(MouseEvent e) {
        }

        public void mouseExited(MouseEvent e) {
        }

        public void mouseClicked(MouseEvent e) {
        }
    }
}

