import javax.swing.*;
import java.awt.*;

public class fileInput{
    public static void main(String[] args){
        JFrame frame = new JFrame("Java Program");
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);
        JLabel titleTop = new JLabel("Analyze a Java Project");
        titleTop.setFont(new Font("Courier New",Font.ITALIC,22));
        titleTop.setBounds(170,20,300,40);
        JLabel path = new JLabel("Path:");
        path.setFont(new Font("Courier New",Font.BOLD,17));
        path.setBounds(50,100,100,40);
        JButton browse = new JButton("Browse..");
        browse.setBounds(510,105,90,28);
        JButton analyze = new JButton("Analyze");
        analyze.setFont(new Font("Courier New",Font.BOLD,17));
        analyze.setBounds(250,190,120,50);
        JTextField filePath = new JTextField();
        filePath.setBounds(100,105,400,30);
        panel.add(titleTop);
        panel.add(path);
        panel.add(browse);
        panel.add(analyze);
        panel.add(filePath);
        frame.add(panel);
        frame.setSize(640,320);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
