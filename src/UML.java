import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MyCanvas extends JPanel {
    private int classHeight;
    private String className[] = {"Shape","Circle","Layer","Check"};
    private String attributesName[] = {"- color:String","- check:boolean","- check:boolean","- check:boolean","- check:boolean","- check:boolean"};
    private String methodsName[] = {"+ Shape()","+ Shape(String, boolean)","+ getColor(): String"};
    private int boxWidth;
    private int x1,x2,x3;
    private int y1,y2,y3;

    private void drawArrowLine(Graphics g, int x1, int y1, int x2, int y2, int d, int h) {
        int dx = x2 - x1, dy = y2 - y1;
        double D = Math.sqrt(dx*dx + dy*dy);
        double xm = D - d, xn = xm, ym = h, yn = -h, x;
        double sin = dy / D, cos = dx / D;

        x = xm*cos - ym*sin + x1;
        ym = xm*sin + ym*cos + y1;
        xm = x;

        x = xn*cos - yn*sin + x1;
        yn = xn*sin + yn*cos + y1;
        xn = x;

        int[] xpoints = {x2, (int) xm, (int) xn};
        int[] ypoints = {y2, (int) ym, (int) yn};

        g.drawLine(x1, y1, x2, y2);
        g.fillPolygon(xpoints, ypoints, 3);
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g1 = (Graphics2D) g;
        x1 = 50;y1 = 50;boxWidth = 250;classHeight = 30;
        Font font = new Font("Courier New",Font.PLAIN,13);
//        g1.scale(scaleFactor,scaleFactor);
        FontMetrics metrics = g1.getFontMetrics(font);
        for(int i = 0; i < 4; i++) {
            g1.setFont(font);
            setBackground(Color.WHITE);
            g1.drawString(className[i],x1 + (boxWidth - metrics.stringWidth(className[i]))/2,y1+(classHeight - metrics.getHeight())/2 + metrics.getAscent());//print classname
            g1.drawRect(x1, y1, boxWidth, classHeight); //draw box for class
//            g1.setColor(Color.GRAY);
//            g1.fillRect(x1, y1, boxWidth, classHeight);
            x2 = x1; y2 = y1 + classHeight;
            g1.drawRect(x2,y2,boxWidth,attributesName.length*25);//draw box for attributes
//            g.setColor(Color.ORANGE);
//            g.fillRect(x2,y2,boxWidth,attributesName.length*25);
            for(int j = 0; j < attributesName.length; j++){
                g1.drawString(attributesName[j],(x2+10),(y2+20*(j+1)));
            }
            x3 = x2; y3 = y2 + attributesName.length*25;
            g1.drawRect(x3,y3,boxWidth,methodsName.length*25);//draw box for method
            for(int j = 0; j < methodsName.length; j++){
                g1.drawString(methodsName[j],(x3+10),(y3+(j+1)*20));
            }
            x1 += 350; //khoảng cách giữa các box
        }
        drawArrowLine(g1,300,50+(attributesName.length*25)/2,400,50+(attributesName.length*25)/2,5,5);
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

