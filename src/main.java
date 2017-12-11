import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class main extends JPanel{
    static MainClass mainClass;
    public main(){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }
                int x = 300, y = 200;
                mainClass = new MainClass(fileInput.filename);
                JFrame frame = new JFrame("Result");
//                JPanel mainPanel = new JPanel();
                MainPanel mainPanel = new MainPanel();
                int k =1;
                for( Class A: mainClass.list) {
                    mainPanel.add( new Panel(A,(x * k),y));
                    k++;
                }
                mainPanel.setLayout(null);
                mainPanel.setBackground(Color.WHITE);
                JScrollPane scrollPane = new JScrollPane(mainPanel);
                scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
                scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                scrollPane.setViewportView(mainPanel);
                mainPanel.setPreferredSize(new Dimension(2000,2000));
                mainPanel.setLocation(0,0);

                JButton paint = new JButton("Export");
                paint.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        BufferedImage image = new BufferedImage(mainPanel.getWidth(), mainPanel.getHeight(), BufferedImage.TYPE_INT_RGB);
                        Graphics2D g = image.createGraphics();
                        mainPanel.printAll(g);
                        g.dispose();
                        try {
                            ImageIO.write(image, "png", new File("Paint.png"));
                        } catch (IOException exp) {
                            exp.printStackTrace();
                        }
                        finally {
                            JOptionPane.showMessageDialog(null,"Export Successfully");
                        }
                    }
                });

                frame.add(paint, BorderLayout.SOUTH);
                frame.add(scrollPane);
                frame.setSize(1366,768);
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                frame.setVisible(true);
                frame.setLocationRelativeTo(null);
            }
        });
    }
}

