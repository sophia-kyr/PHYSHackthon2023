import java.awt.*;

import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.lang.Math;
public class GameWindow extends JFrame {
   //JFrame frame = new JFrame();
   MyPanel panel;
//   Image user;
//   Timer timer;
//   int angle;
//   Shape circleR;
//   int xVelocity = 1;
//   int yVelocity = 1;
//   int x = 0;
//   int y = 0;

    GameWindow(){
        panel = new MyPanel();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    //paint and repaint does current frame
//    public void paint(Graphics g) {
//
//        super.paint(g); // paint background
//
//        Graphics2D ga = (Graphics2D)g;
//        ga.drawImage(user, x, y, null);
//        int c = (100+(200/2));
//        double degrees = angle * Math.PI*2 / 360.0;     //convert degree into radians
//
//        circleR = new Ellipse2D.Float(400, 100, 200, 200);
//
//        //find X and Y on the circle
//        int X = (int)(500 + (100) * java.lang.Math.cos(-degrees));
//        int Y = (int)(200 + (100) * java.lang.Math.sin(-degrees));
//
//        int X1 = (int)(500 + (100) * java.lang.Math.cos(degrees));
//        int Y1 = (int)(200 + (100) * java.lang.Math.sin(degrees));
//
//        //create a line
//        Shape Fa = new Line2D.Float(500,200,X,Y);
//        Shape Fb = new Line2D.Float(500,200,X1,Y1);
//
//        //draw shape
//        ga.draw(circleR);
//        ga.draw(Fa);
//        ga.draw(Fb);
//    }
//    @Override
//    public void actionPerformed(ActionEvent e) {
////        if(x>=PANEL_WIDTH-logo.getWidth(null) || x<0) {
////            xVelocity = xVelocity * -1;
////        }
//        x = x + xVelocity;
//
////        if(y>=PANEL_HEIGHT-logo.getHeight(null) || y<0) {
////            yVelocity = yVelocity * -1;
////        }
//        y = y + yVelocity;
//        repaint();
//    }
}
