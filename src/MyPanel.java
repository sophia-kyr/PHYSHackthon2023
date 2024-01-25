import java.awt.*;

import java.awt.event.*;
import javax.swing.*;

public class MyPanel extends JPanel implements ActionListener{

    final int PANEL_WIDTH = 500;
    final int PANEL_HEIGHT = 500;
    Image arrow;
    Timer timer;
    double angle = 0;
    int x = 50;
    int y = 500;
    int r = 50;
    boolean ccw = true;

    MyPanel(){
        this.setPreferredSize(new Dimension(PANEL_WIDTH,PANEL_HEIGHT));
        this.setBackground(Color.black);
        arrow = new ImageIcon("arrow2.png").getImage();
        //backgroundImage = new ImageIcon("space.png").getImage();
        timer = new Timer(10, this);
        timer.start();
    }

    public void paint(Graphics g) {

        super.paint(g); // paint background

        Graphics2D g2D = (Graphics2D) g;

        //g2D.drawImage(backgroundImage, 0, 0, null);
        g2D.drawImage(arrow, x, y, null);

    }

    //    @Override
//    public void actionPerformed(ActionEvent e) {
//
//        if(x>=PANEL_WIDTH-enemy.getWidth(null) || x<0) {
//            xVelocity = xVelocity * -1;
//        }
//        x = x + xVelocity;
//
//        if(y>=PANEL_HEIGHT-enemy.getHeight(null) || y<0) {
//            yVelocity = yVelocity * -1;
//        }
//        y = y + yVelocity;
//        repaint();
//    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(this.ccw){
            angle += 0.5;
        }
        else{
            angle -= 0.5;
        }

        if(x<0) {
            this.ccw = false;
        }
        if(y>=PANEL_HEIGHT-arrow.getHeight(null) || y<0) {
            this.ccw = true;
        }


        //transform as well as rotate

        this.x = (int)(50 + this.r * Math.cos(this.angle * Math.PI/180));

        this.y = (int)(500 + this.r * Math.sin(this.angle * Math.PI/180));

        repaint();
    }
}