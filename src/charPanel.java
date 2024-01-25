import java.awt.*;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.lang.Math;

public class charPanel extends JPanel implements ActionListener{



    final int PANEL_WIDTH = 1000;
    final int PANEL_HEIGHT = 800;
    Image user;
    Image mass;
    Image pointer;
    Timer timerLaunch;
    JButton launch;
    double x = 300;
    double y = 600;
    double viX = -1;
    double viY = -1;
    int vfX = 2;
    int vfY = -3;
    double mx = 300;
    double my = 200;
    double mr = 50;
    int px = 260;
    int py = 360;
    double angle = 1;
    boolean ccw = false;
    Timer timerV;
    double velocity = -4;
    JLabel label;
    ImageIcon icon;
    Image target;
    double dist;
    double theta;

    double ESCAPE = 50;
    boolean orbit = false;

    double distOG;
    double thetaOG;

    int frame = 2;

    boolean stop = false;

    //obtains distance between planet and satellite

//    public boolean withinRange(double satelliteX, double satelliteY, double planetX, double planetY){
//        if (((satelliteY - 5) < planetY) && planetY < (satelliteY + 5)) {
//            if (((satelliteX - 5) < planetX) && planetX < (satelliteX + 5)) {
//                return true;
//            }
//        }
//        return false;
//    }

    public double currentVelocity(double viX, double viY){
        return Math.sqrt((viX)*(viX)+(viY)*(viY));
    }

    public double calculateDistance(double planetX, double planetY, double satelliteX, double satelliteY){
        return Math.sqrt(((planetX - satelliteX)*(planetX - satelliteX)+(planetY-satelliteY)*(planetY-satelliteY)));
    }

    //obtains escape velocity at current distance from planet
    public double calculateEscapeVelocity(double escape, double distance){
        return (escape/Math.sqrt(distance));
    }

    //calculates angle between satellite and planet, as though planet were origin, going clockwise from the vertical
    public double calculateAngle(double planetX, double planetY, double satelliteX, double satelliteY){
        if ((satelliteX >= planetX) && (satelliteY > planetY)){
            System.out.println("1");
            return (Math.PI/2) - (Math.atan((satelliteX - planetX)/(satelliteY - planetY)));

        }
        if ((satelliteX >= planetX) && (satelliteY < planetY)){
            System.out.println("2");
            return 2*(Math.PI) - (Math.atan((planetY - satelliteY)/(satelliteX - planetX)));
        }
        if ((satelliteX < planetX) && (satelliteY > planetY)){
            System.out.println("3");
            return (Math.PI/2) + (Math.atan((planetX - satelliteX)/(satelliteY - planetY)));
        }
        if ((satelliteX < planetX) && (satelliteY < planetY)){
            System.out.println("4");
            return Math.PI + (Math.atan((planetY - satelliteY)/(planetX - satelliteX)));
        }

        System.out.println("5");
        return (Math.PI)/2.0;



    }
    charPanel() {
//        this.addKeyListener( this);
//
//        Image imIcon = new ImageIcon("arrow2.png").getImage();
//        imIcon = imIcon.getScaledInstance(30, 30, Image.SCALE_DEFAULT);
//        icon = new ImageIcon(imIcon);
//
//        label = new JLabel();
//        label.setBounds(260,360,100,100);
//        label.setIcon(icon);
//        this.add(label);

        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.setBackground(Color.black);
        this.setBounds(10, 10, 800, 800);
        //this.addKeyListener(this);
        target = new ImageIcon("target.png").getImage();
        target = target.getScaledInstance(20, 20, Image.SCALE_DEFAULT);

        launch = new JButton("Launch!");
        launch.addActionListener(this);
        user = new ImageIcon("ship.png").getImage();
        user = user.getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        mass = new ImageIcon("planet.png").getImage();
        mass = mass.getScaledInstance(100, 100, Image.SCALE_DEFAULT);
//        pointer = new ImageIcon("arrow2.png").getImage();
//        pointer = pointer.getScaledInstance(10, 10, Image.SCALE_DEFAULT);

        //timerLaunch = new Timer(10, this);
        timerV = new Timer(10, this);
        this.add(launch);

    }


    public void paint(Graphics g) {

        super.paint(g); // paint background

        Graphics2D g2D = (Graphics2D) g;

        g2D.drawImage(this.user, (int) this.x, (int) this.y, null);
        g2D.drawImage(this.mass, (int) this.mx, (int) this.my, null);
        g2D.drawImage(this.target, 500, (int) 200, null);
        //g2D.drawImage(this.pointer, this.px, this.py, null);
        //timerLaunch.start();
        //timerV.start();


    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == launch){
            timerV.start();
        }
//ORBIT
        dist = calculateDistance(mx, my, this.x, this.y);
             // if(dist == 200){ double a = Math.pow((Math.pow(dist, 2) / Math.pow(velocity, 2)), 1 / 3);

        double escapeVelocity = calculateEscapeVelocity(ESCAPE, dist);


        if ((Math.abs(velocity) < escapeVelocity || orbit) && frame >= 3) {

            System.out.println("Orbit");

                orbit = true;

                //double r = Math.pow(a, 2) / (2 * Math.sqrt(Math.pow(a * Math.cos(theta), 2) + Math.pow(a / 2 * Math.sin(theta), 2)));
                this.x = dist * Math.cos(theta) + mx;
                this.y = dist * Math.sin(theta) + my;

                double tempVelocity = velocity;
                velocity = velocity * (distOG / dist);

                if (thetaOG < Math.PI / 2) {
                    theta -= Math.abs((velocity) / 120);
                } else {
                    theta += Math.abs((velocity) / 120);
                }

                velocity = tempVelocity;
                repaint();


        }




        if (!orbit) {

            System.out.println("Not Orbit; incident angle = " + MyFrame.Iangle);
            if (velocity != 0) {
                velocity = MyFrame.Ivelocity;
            }
            System.out.println(velocity);
            viX = velocity * Math.cos(Math.toRadians(MyFrame.Iangle));
            viY = (-1) * velocity * Math.sin(Math.toRadians(MyFrame.Iangle));
//            viX *=  MyFrame.Ivelocity;
//            viY *= (-1) * MyFrame.Ivelocity;

            theta = calculateAngle(mx, my, this.x, this.y);
            thetaOG = theta;

            double a = Math.pow((Math.pow(dist, 2) / Math.pow(velocity, 2)), 1/3);
            if ((this.mx + this.mr) > this.x && this.x > (this.mx - this.mr) && (this.my + this.mr) > this.y && this.y > (this.my - this.mr)) {

                this.viX = this.vfX;

                this.viY = this.vfY;
            }


                this.x = this.x + this.viX;
                this.y = this.y + this.viY;



            velocity = Math.sqrt((viX)*(viX) + (viY)*(viY));
            //   }


            if (e.getSource() == launch) {
                launch.setEnabled(false);
                launch.setVisible(true);
                //timerLaunch.start();
//            timerV.stop();
//            timerLaunch.start();

                //freeze key events and slider
            }
//            if (py > 300) {
//                ccw = !ccw;
//            }
//            if (ccw) {
//                angle += 0.8;
//            } else {
//                angle -= 0.8;
//            }
//            this.px = (int) (200 + 50 * Math.cos(angle * Math.PI / 180));
//            this.py = (int) (300 + 50 * Math.sin(angle * Math.PI / 180));
//

/*
            //stop motion, end game for when hits frame
            if (x >= PANEL_WIDTH - user.getWidth(null) || x < 0) {

            }
            if (y >= PANEL_WIDTH - user.getWidth(null) || y < 0) {

            }
      */

            distOG = dist;
        }
        repaint();

        frame ++;

    }

//    @Override
//    public void keyTyped(KeyEvent e) {
//
//        switch(e.getKeyChar()) {
//            case KeyEvent.VK_LEFT:
//                angle += 0.8;
//                break;
//            case KeyEvent.VK_RIGHT:
//                angle -= 0.8;
//                break;
//        }
//
////        if (e.isActionKey() == ) {
////                angle += 0.8;
////        } else {
////                angle -= 0.8;
////        }
//        this.px = (int) (200 + 50 * Math.cos(angle * Math.PI / 180));
//        this.py = (int) (300 + 50 * Math.sin(angle * Math.PI / 180));
//        repaint();
//    }
//
//    @Override
//    public void keyPressed(KeyEvent e) {
//
//    }
//
//    @Override
//    public void keyReleased(KeyEvent e) {
//
//    }


//
//    @Override
//    public void keyTyped(KeyEvent e) {
//        switch (e.getKeyChar()) {
//            case 'a':
//                label.setLocation(label.getX() - 10, label.getY());
//                break;
//            case 'w':
//                label.setLocation(label.getX(), label.getY() - 10);
//                break;
//            case 's':
//                label.setLocation(label.getX(), label.getY() + 10);
//                break;
//            case 'd':
//                label.setLocation(label.getX() + 10, label.getY());
//                break;
//        }
//
//    }
//
//    @Override
//    public void keyPressed(KeyEvent e) {
//        switch (e.getKeyCode()) {
//            case 37:
//                label.setLocation(label.getX() - 10, label.getY());
//                break;
//            case 38:
//                label.setLocation(label.getX(), label.getY() - 10);
//                break;
//            case 39:
//                label.setLocation(label.getX() + 10, label.getY());
//                break;
//            case 40:
//                label.setLocation(label.getX(), label.getY() + 10);
//                break;
//        }
//    }
//
//    @Override
//    public void keyReleased(KeyEvent e) {
//
//    }
}