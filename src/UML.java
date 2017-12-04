import java.awt.*;
import javax.swing.*;

class MyCanvas extends Canvas {
    private int H_Class;
    private int H_Met[] = {70,50,40,60,30,70,50,40,60,30,70,50,40,60,30} ;
    private int H_Atr[] = {100,130,150,200,50,100,130,150,200,50,100,130,150,200,50} ;
    private int W_max;
    private int x1,x2,x3;
    private int y1,y2,y3;
    public void paint(Graphics g) {
        Graphics2D g1 = (Graphics2D) g;
        x1 = 50;
        y1 = 50;
        W_max = 150;
        H_Class = 30;
        String className = "Shape";
        Font font = new Font("Courier New",Font.BOLD,13);
        FontMetrics metrics = g.getFontMetrics(font);
        for(int i = 0; i < 5; i++) {
            int x_txt_class = x1 + (W_max - metrics.stringWidth(className)) / 2;
            int y_txt_class = y1 + ((H_Class - metrics.getHeight()) / 2) + metrics.getAscent();
            setBackground(Color.WHITE);
            g1.drawRect(x1, y1, W_max, H_Class); //draw box for class
            x2 = x1;
            y2 = y1 + H_Class;
            g1.drawRect(x2,y2,W_max,H_Atr[i]);//draw box for attributes
            x3 = x2;
            y3 = y2 + H_Atr[i];
            g1.drawRect(x3,y3,W_max,H_Met[i]);//draw box for method
            x1 += 200; //khoảng cách giữa các box
            g1.setFont(font);
            g1.drawString(className,x_txt_class,y_txt_class);//print classname
        }
    }

    public static void main(String[] args){
        JFrame frame = new JFrame("GUI");
        MyCanvas m = new MyCanvas();
        frame.add(m);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(1366,768);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}