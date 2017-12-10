import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class main extends JPanel{
    static MainClass mainClass;
//đc rồi đấy. The bayg day filePath tu cho fileChooser sang UMl thi lam the nao ha anh, là sao. Tức là khi mà fileChooser rồi mình có đường dẫn folder project. Thì em muốn đẩy đường dẫn đó tự động, chứ kp thủ công như hiện tại
    public main(){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                mainClass = new MainClass( "D:\\baitaplonvcl\\src\\test");// đây này đây là thủ công cố định, bảo huy sửa lại là đc.Oke để bảo nó. vãi lồn anh huy đang đi nhậu :) địt con mẹ :) drag phải biết đc tọa ddoojj box
                // box set boder m biết nó rộng daigf bao nhiêu ko ??
                // giờ nhá, drag nghĩa là m kéo đến vị trí khác thì hình sẽ đc vẽ lại, thử làm theo cách chiều nay t chỉ xem đc ko, làm tiếp đi oke để t làm thử. Có gì tí t hỏi nhé. Code drag vẫn giống cái test ý hả? ừ
//                mainClass = new MainClass(test.getFilePathFolder());
//                System.out.println(test.getFilePathFolder());
                JFrame frame = new JFrame("Result");
//                JPanel mainPanel = new JPanel();
                MainPanel mainPanel = new MainPanel();
                int k =1;
                for( Class A: mainClass.list) {
                    mainPanel.add( new Panel(A,300 * k,200));
                    k++;
                }
                mainPanel.setLayout(null);
                JScrollPane scrollPane = new JScrollPane();
                scrollPane.setViewportView(mainPanel);
                mainPanel.setPreferredSize(new Dimension( 4000, 4000));
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
