import javax.swing.*;
import java.awt.*;

public class main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Result");
//        JPanel container = new JPanel();
        MyCanvas diagram = new MyCanvas();

        diagram.setPreferredSize(new Dimension(3000,900));
        JScrollPane scrollableTextArea = new JScrollPane(diagram);

        scrollableTextArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollableTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        frame.getContentPane().add(scrollableTextArea);
//        frame.getContentPane().add(scrPane);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(frame.getWidth()+1, frame.getHeight());
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
