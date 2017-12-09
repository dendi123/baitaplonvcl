import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Panel extends JPanel {
    private String className = "";
    private String attributesName = "";
    private String methodsName = "";
    int x, y;
    int lastMouseX = 0, lastMouseY = 0;
    int imageX = 30, imageY = 30;
    double scaleFactor = 1;
    int panelWidth = 960;
    int panelHeight = 720;

    public Panel( Class A, int x, int y) {
        this.className = A.className;
        this.attributesName = A.attributesName;
        this.methodsName = A.methodsName;
        this.x = x;
        this.y = y;
        this.setLocation( x, y);
        //this.setBounds( 100, 100, 200,200);
        this.setLayout( new BoxLayout( this, BoxLayout.Y_AXIS));
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        //
        JLabel labelName = new JLabel(className);
        labelName.setBorder(BorderFactory.createLineBorder(Color.black));
        this.add( labelName);
        //
        JLabel labelAttribute = new JLabel(attributesName);
        labelAttribute.setBorder(BorderFactory.createLineBorder(Color.black));
        this.add( labelAttribute);
        //
        JLabel labelMethod = new JLabel(methodsName);
        labelMethod.setBorder(BorderFactory.createLineBorder(Color.black));
        this.add( labelMethod);
        this.setSize( this.getPreferredSize());
        //
    }

}

