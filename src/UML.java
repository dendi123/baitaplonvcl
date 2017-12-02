import java.awt.*;
import javax.swing.*;

public class UML extends Canvas {
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
        for(int i = 0; i < 5; i++) {
            setBackground(Color.WHITE);
            g1.drawRect(x1, y1, W_max, H_Class); //draw box for class
//            g1.drawString("class 1",x1,y1);
            x2 = x1;
            y2 = y1 + H_Class;
            g1.drawRect(x2,y2,W_max,H_Atr[i]);//draw box for attributes
            x3 = x2;
            y3 = y2 + H_Atr[i];
            g1.drawRect(x3,y3,W_max,H_Met[i]);//draw box for method
            x1 += 200; //khoảng cách giữa các box
        }
    }

    public static void main(String[] args){
        JFrame frame = new JFrame("GUI");
        UML m = new UML();
        frame.add(m);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(1366,768);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}