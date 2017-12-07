import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

class DrawPane extends JPanel {

    private List<DrawnShape> drawings;
    private DrawnShape curShape;

    public DrawPane() {
        drawings = new ArrayList<DrawnShape>();
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(300, 300));
        addMouseListener(clickListener);
        addMouseMotionListener(moveListener);
    }

    @Override
    protected void paintComponent(Graphics g2) {
        super.paintComponent(g2);
        Graphics2D g = (Graphics2D) g2;
        for (DrawnShape s : drawings) {
            s.draw(g);
        }
        g.setColor(Color.BLACK);
        g.setStroke(new BasicStroke(2));

        if (curShape == null)
            return;
        curShape.draw(g);
    }

    private MouseListener clickListener = new MouseAdapter() {

        @Override
        public void mousePressed(MouseEvent e) {
            curShape = new DrawnShape(e.getPoint(), e.getPoint());
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            drawings.add(new DrawnShape(curShape.getClickP(), e.getPoint()));
            curShape = null;
        }
    };

    private MouseMotionListener moveListener = new MouseMotionListener() {

        @Override
        public void mouseDragged(MouseEvent e) {
            curShape = new DrawnShape(curShape.getClickP(), e.getPoint());
            repaint();
        }
        @Override
        public void mouseMoved(MouseEvent e) {
        }
    };
}

class DrawnShape {

    private Point p1, p2;

    public DrawnShape(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public Point getClickP() {
        return p1;
    }

    public void draw(Graphics2D g) {
        g.drawLine(p1.x, p1.y, p2.x, p1.y);
        g.drawLine(p1.x, p1.y, p1.x, p2.y);
        g.drawLine(p2.x, p2.y, p2.x, p1.y);
        g.drawLine(p2.x, p2.y, p1.x, p2.y);
    }
}