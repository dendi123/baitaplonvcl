//import javax.swing.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.KeyEvent;
//
//class MyMenuBar extends JFrame implements ActionListener {
//
//    private JMenuBar menuBar = new JMenuBar();
//    private JMenu zoom = new JMenu("Zoom");
//    private JMenuItem zoomIn = new JMenuItem("Zoom In");
//    private JMenuItem zoomOut = new JMenuItem("Zoom Out");
//    static private int menuWidth = 700;
//    static private int menuHeight = 400;
//
//
//    private JButton createJButton(String buttonName) {
//        JButton btn = new JButton(buttonName);
//        btn.addActionListener(this);
//        return btn;
//    }
//
//    public JMenuBar MenuBar(){
//        zoom.add(zoomIn);
//        zoom.add(zoomOut);
//
//        menuBar.add(zoom);
//        mFile.setMnemonic(KeyEvent.VK_F);
//        mHelp.setMnemonic(KeyEvent.VK_H);
//        itemAbout.setMnemonic(KeyEvent.VK_A);
//        itemAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
//        itemExit.setMnemonic(KeyEvent.VK_X);
//        itemExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,ActionEvent.CTRL_MASK));
//
//        itemAbout.addActionListener(this);
//        itemExit.addActionListener(this);
//        return menuBar;
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e){
//        if(e.getSource() == itemAbout ){
//            String aboutCoder = "+) Nguyễn Xuân Việt Cường - 16020208" + "\n" + "+) Đỗ Xuân Anh - 16020192";
//            String about = "---JAVAtoUML---" + "\n" + "Class : K61-CA-CLC1" + "\n" + aboutCoder +"\n\n" + "*VER 1.0*";
//            JOptionPane.showMessageDialog(null, about, "About", JOptionPane.CLOSED_OPTION);
//        }
//
//        if(e.getActionCommand().equalsIgnoreCase("Exit") ){
//            System.exit(0);
//        }
//    } {
//}
