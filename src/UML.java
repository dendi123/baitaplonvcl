import java.awt.*;
import javax.swing.*;

class MyCanvas extends JPanel {
    private int H_Class;
    private String className[] = {"Shape","Circle","Layer","Check"};
    private String attributesName[] = {"- color:String","- check:boolean","- check:boolean","- check:boolean","- check:boolean","- check:boolean"};
    private String methodsName[] = {"+ Shape()","+ Shape(String, boolean)","+ getColor(): String"};
    private int W_max;
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

    public void paintComponent(Graphics g) {
        Graphics2D g1 = (Graphics2D) g;
        x1 = 50;
        y1 = 50;
        W_max = 250;
        H_Class = 30;
        Font font = new Font("Courier New",Font.PLAIN,13);
        FontMetrics metrics = g1.getFontMetrics(font);
        for(int i = 0; i < 4; i++) {
            g1.setFont(font);
            setBackground(Color.WHITE);
            g1.drawString(className[i],x1 + (W_max - metrics.stringWidth(className[i]))/2,y1+(H_Class - metrics.getHeight())/2 + metrics.getAscent());//print classname
            g1.drawRect(x1, y1, W_max, H_Class); //draw box for class
            x2 = x1;
            y2 = y1 + H_Class;
            g1.drawRect(x2,y2,W_max,attributesName.length*25);//draw box for attributes
            for(int j = 0; j < attributesName.length; j++){
                g1.drawString(attributesName[j],(x2+10),(y2+20*(j+1)));
            }
            x3 = x2;
            y3 = y2 + attributesName.length*25;
            g1.drawRect(x3,y3,W_max,methodsName.length*25);//draw box for method
            for(int j = 0; j < methodsName.length; j++){
                g1.drawString(methodsName[j],(x3+10),(y3+(j+1)*20));
            }
            x1 += 350; //khoảng cách giữa các box
        }
        drawArrowLine(g1,300,50+(attributesName.length*25)/2,400,50+(attributesName.length*25)/2,5,5);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Result");
        JPanel container = new JPanel();
        JScrollPane scrPane = new JScrollPane(container);
        scrPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        MyCanvas diagram = new MyCanvas();
        frame.add(diagram);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(1366, 768);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}