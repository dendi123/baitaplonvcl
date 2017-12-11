import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import javax.swing.*;
import java.awt.Rectangle;

class Panel extends JPanel {
    private String className = "";
    private String attributesName = "";
    private String methodsName = "";
    int x, y;

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Panel(Class A, int x, int y) {
        this.className = A.className;
        this.attributesName = A.attributesName;
        this.methodsName = A.methodsName;
        this.x = x;
        this.y = y;
        this.setLocation(x,y);
        this.setBackground(Color.WHITE);
        //this.setBounds( 100, 100, 200,200);
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        //
        JLabel labelName = new JLabel(className);
        labelName.setBorder(BorderFactory.createLineBorder(Color.black));
        this.add(labelName);
        //
        JLabel labelAttribute = new JLabel(attributesName);
        labelAttribute.setBorder(BorderFactory.createLineBorder(Color.black));
        this.add(labelAttribute);
        //
        JLabel labelMethod = new JLabel(methodsName);
        labelMethod.setBorder(BorderFactory.createLineBorder(Color.black));
        this.add(labelMethod);
        this.setSize(this.getPreferredSize());
        //
    }
}

class MainPanel extends JPanel {
    int lastMouseX = 0, lastMouseY = 0;
    double scaleFactor = 1;
    int panelWidth = 960;
    int panelHeight = 720;
    int imageX = getX(), imageY = getY();
    MainClass m = new MainClass();
////    private Point origin = new Point(panelWidth, panelHeight);
////    private Point mousePt;


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
        g2.getFontMetrics().getHeight();
        at.scale(scaleFactor, scaleFactor);
        g2.transform(at);
    }

    class MouseMotionHandler extends MouseMotionAdapter implements MouseListener, MouseWheelListener {

        public void mousePressed(MouseEvent e) {
            lastMouseX = e.getX();
            lastMouseY = e.getY();

//            mousePt = e.getPoint();
//            System.out.println("FFFFFFFFFFFFFFFFFFFFFFFF");
        }

//        @Override
//        public void mouseDragged(MouseEvent e) {
//            int dx = e.getX() - mousePt.x;
//            int dy = e.getY() - mousePt.y;
//            origin.setLocation(origin.x + dx, origin.y + dy);
//            mousePt = e.getPoint();
//            repaint();
//        }

        public void mouseDragged(MouseEvent e) {
            Rectangle rec = new Rectangle(imageX,imageY,getWidth(),getHeight());

            if (rec.contains(e.getX()/scaleFactor,e.getY()/scaleFactor)) {
                int xDiff = e.getX() - lastMouseX;
                int yDiff = e.getY() - lastMouseY;
                imageX = imageX + (int) (xDiff / scaleFactor);
                imageY = imageY + (int) (yDiff / scaleFactor);
                lastMouseX = e.getX();
                lastMouseY = e.getY();
                panelWidth = Math.max(panelWidth, imageX + 300);
                panelHeight = Math.max(panelWidth, imageY + 300);
                System.out.println("dddddddddddddddddd");
                //this.setPreferredSize(panelWidth,panelHeight);
                repaint();
            }
        }

        public void mouseWheelMoved(MouseWheelEvent e) {
            int notches = e.getWheelRotation();
            scaleFactor = scaleFactor + notches / 10.0;
            if (scaleFactor < 0.5) {
                scaleFactor = 0.5;
            }
            else if (scaleFactor > 3.0) {
                scaleFactor = 3.0;
            }
            panelWidth*=scaleFactor;
            panelHeight*=scaleFactor;
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

