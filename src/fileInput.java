
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

//day la ban cu chua day filePath sang. Con cai ban nay d ra clg la ban moi huy vua sua va d chay dc ^^
public class fileInput  {
    public static void main(String[] args) throws Exception{
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

        browse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                JFileChooser file = new JFileChooser();
                JTextField filePath = new JTextField();
                filePath.setBounds(100,105,400,30);

                file.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int path = file.showOpenDialog(null);
                if(path==JFileChooser.APPROVE_OPTION)
                {
                    File f = file.getSelectedFile();
                    String filename = f.getAbsolutePath();
                    filePath.setText(filename);
                    filePath.setEditable(true);
                    panel.add(filePath);
                }
                else if(path==JFileChooser.CANCEL_OPTION)
                {
                    filePath.setText("Cancel choose folder");
                }
//                path.setText(file.getSelectedFile().getAbsolutePath());
            }
        });

        JButton analyze = new JButton("Analyze");
        analyze.setFont(new Font("Courier New",Font.BOLD,17));
        analyze.setBounds(250,190,120,50);

        analyze.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               new main();
            }
        });

        JTextField filePath = new JTextField();
        filePath.setEditable(false);
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
