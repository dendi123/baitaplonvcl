import javax.swing.*;
import java.awt.*;

public class main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Result");
//        JPanel container = new JPanel();
        MyCanvas diagram = new MyCanvas();//tao doi tuong canvas moi ma??, vai lozz dat ten :))<3
//
//        JScrollPane scrPane = new JScrollPane(diagram,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
// tao dc nhung dang bi de anh, thay ko
        //thay nnao t cung dang chua biet sua
        diagram.setPreferredSize(new Dimension(3000,900));
        JScrollPane scrollableTextArea = new JScrollPane(diagram);

        scrollableTextArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollableTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        frame.getContentPane().add(scrollableTextArea);
//        frame.getContentPane().add(scrPane);
       // frame.add(new ModernScrollPane(diagram));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(frame.getWidth()+1, frame.getHeight());
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
