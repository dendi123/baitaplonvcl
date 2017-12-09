import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class main {
    static MainClass mainClass;

    public static void main(String[] args) throws Exception{
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                mainClass = new MainClass( "D:\\baitaplonvcl\\src\\test");
                JFrame frame = new JFrame("Result");
                JPanel mainPanel = new JPanel();
                int k =1;
                for( Class A: mainClass.list) {
                    mainPanel.add( new Panel(A,300 * k,200));
                    k++;
                }
                mainPanel.setLayout(null);
                JScrollPane scrollPane = new JScrollPane();
                scrollPane.setViewportView( mainPanel);
                mainPanel.setPreferredSize( new Dimension( 4000, 4000));
                mainPanel.setLocation(0 ,0 );

                frame.add( scrollPane);
                frame.setSize(1366,768);
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                frame.setVisible(true);
                frame.setLocationRelativeTo(null);
            }
        });
    }
}
