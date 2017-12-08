import javax.swing.*;
import java.awt.*;

public class main {
    static MainClass mainClass;
    public static void main(String[] args) {
        mainClass = new MainClass( "D:\\baitaplonvcl\\src\\test");


        JFrame frame = new JFrame("Result");
//        JPanel container = new JPanel();
        /*
        MyCanvas diagram = new MyCanvas();

        diagram.setPreferredSize(new Dimension(3000,900));
        JScrollPane scrollableTextArea = new JScrollPane();
        scrollableTextArea.setViewportView( diagram);
        scrollableTextArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollableTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        frame.getContentPane().add(scrollableTextArea);
//        frame.getContentPane().add(scrPane);
        */
        JPanel mainPanel = new JPanel();
        int k =1;
        for( Class A: mainClass.list) {
            mainPanel.add( new Panel( A, 100, 300*k));
            k++;
        }
        mainPanel.setLayout(null);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView( mainPanel);
        mainPanel.setPreferredSize( new Dimension( 20000, 20000));
        mainPanel.setLocation(0 ,0 );
        frame.add(  scrollPane);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(frame.getWidth()+1, frame.getHeight());
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
