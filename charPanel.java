import java.awt.*;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.lang.Math;

public class charPanel extends JPanel implements ActionListener {

    final int PANEL_WIDTH = 500;
    final int PANEL_HEIGHT = 500;
    Image user;
    Image mass;
    Image pointer;
    Timer timerLaunch;
    JButton launch;
    double x = 200;
    double y = 300;
    double viX = -1;
    double viY = -1;
    int vfX = 2;
    int vfY = -3;
    double mx = 100;
    double my = 100;
    double mr = 50;
    int px = 260;
    int py = 360;
    double angle = 1;
    boolean ccw = false;
    Timer timerV;
    double velocity = -2;

    double dist;
    double theta;

    boolean orbit = false;

    int counter = 0;
    charPanel() {
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.setBackground(Color.black);
        this.setBounds(0, 0, 400, 500);
        //this.addKeyListener(this);


        launch = new JButton("Launch!");
        launch.addActionListener(this);
        user = new ImageIcon("pacman-blue-png-10.png").getImage();
        user = user.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        mass = new ImageIcon("pacman-blue-png-10.png").getImage();
        mass = mass.getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        pointer = new ImageIcon("arrow2.png").getImage();
        pointer = pointer.getScaledInstance(10, 10, Image.SCALE_DEFAULT);

        //timerLaunch = new Timer(10, this);
        timerV = new Timer(10, this);
        this.add(launch);

    }


    public void paint(Graphics g) {

        super.paint(g); // paint background

        Graphics2D g2D = (Graphics2D) g;

        g2D.drawImage(this.user, (int) this.x, (int) this.y, null);
        g2D.drawImage(this.mass, (int) this.mx, (int) this.my, null);
        g2D.drawImage(this.pointer, this.px, this.py, null);
        //timerLaunch.start();
        timerV.start();


    }

    @Override
    public void actionPerformed(ActionEvent e) {
//ORBIT
        dist = Math.sqrt(Math.pow((mx - x), 2) + Math.pow((my - y), 2));
         if (velocity <= 100 / (Math.sqrt(dist))) {
             // if(dist == 200){
             double a = Math.pow((Math.pow(dist, 2) / Math.pow(velocity, 2)), 1 / 3);
             theta = Math.atan(Math.abs(my - y) / Math.abs(mx - x));

             if (this.y < 150) {

                 orbit = true;

                 double r = Math.pow(a, 2) / (2 * Math.sqrt(Math.pow(a * Math.cos(theta), 2) + Math.pow(a / 2 * Math.sin(theta), 2)));
                 this.x = dist * Math.cos(theta) - mx;
                 this.y = dist * Math.sin(theta) - my;
                 theta += 1;
                 dist++;
             }
         }

        if (!orbit) {


            if ((this.mx + this.mr) > this.x && this.x > (this.mx - this.mr) && (this.my + this.mr) > this.y && this.y > (this.my - this.mr)) {

                this.viX = this.vfX;

                this.viY = this.vfY;
            }

//            this.viY = 1 / (2 * (Math.sqrt(this.x)));

            this.x = this.x + this.viX;

            this.y = this.y + this.viY;
            //   }


            if (e.getSource() == launch) {
                launch.setEnabled(false);
                launch.setVisible(true);
                //timerLaunch.start();
//            timerV.stop();
//            timerLaunch.start();

                //freeze key events and slider
            }
            if (py > 300) {
                ccw = !ccw;
            }
            if (ccw) {
                angle += 0.8;
            } else {
                angle -= 0.8;
            }
            this.px = (int) (200 + 50 * Math.cos(angle * Math.PI / 180));
            this.py = (int) (300 + 50 * Math.sin(angle * Math.PI / 180));


/*
            //stop motion, end game for when hits frame
            if (x >= PANEL_WIDTH - user.getWidth(null) || x < 0) {

            }
            if (y >= PANEL_WIDTH - user.getWidth(null) || y < 0) {

            }
      */


        }
        repaint();
        counter ++;

    }
}