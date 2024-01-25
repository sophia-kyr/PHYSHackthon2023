import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MyFrame extends JFrame implements ChangeListener{

    charPanel charpanel;

    JSlider Vslider;
    JSlider Aslider;
    JPanel spanel;
    JLabel vlabel;
    JLabel alabel;
    ImageIcon icon;
    JPanel vpanel;
    JTextArea titles;


    public static int Ivelocity;
    public static int Iangle;

    final int PANEL_WIDTH = 1200;
    final int PANEL_HEIGHT = 800;

    MyFrame(){

//        vpanel = new JPanel();
//        vpanel.setBounds(450, 0, 100, 500);
//       // this.addKeyListener( this);
//        vpanel.setBackground(Color.GRAY);


        spanel = new JPanel();

//        Image imIcon = new ImageIcon("arrow2.png").getImage();
//        imIcon = imIcon.getScaledInstance(30, 30, Image.SCALE_DEFAULT);
//        icon = new ImageIcon(imIcon);
//
//        label = new JLabel();
//        label.setBounds(260,360,100,100);
//        label.setIcon(icon);
//        vpanel.add(label);
//        this.add(vpanel);

        charpanel = new charPanel();

        spanel.setBounds(810, 10, 200, 800);
        spanel.setLayout(null);
        spanel.setBackground(Color.black);
        this.setBackground(Color.black);
        spanel.setForeground(Color.black);

        titles = new JTextArea("     speed             incident angle");
        titles.setBounds(820,70, 200, 20);
        titles.setBackground(Color.BLACK);
        titles.setForeground(Color.white);
        this.spanel.add(titles);

        this.setPreferredSize(new Dimension(PANEL_WIDTH,PANEL_HEIGHT));
        this.setBackground(Color.black);
        this.spanel.setBackground(Color.WHITE);

        Vslider = new JSlider(JSlider.VERTICAL,0, 10, 5);
        Vslider.addChangeListener(this);
        Vslider.setBounds(830, 100, 80, 200);
        Vslider.setMajorTickSpacing(10);
        Vslider.setMinorTickSpacing(1);
        Vslider.setPaintTicks(true);
        Vslider.setPaintLabels(true);


        Aslider = new JSlider(JSlider.VERTICAL,0, 180, 90);
        Aslider.addChangeListener(this);
        Aslider.setBounds(910, 100, 100, 200);
        Aslider.setMajorTickSpacing(30);
        Aslider.setMinorTickSpacing(5);
        Aslider.setPaintTicks(true);
        Aslider.setPaintLabels(true);


        //this.setLayout(null);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(charpanel);
        this.add(this.spanel);
        this.spanel.add(this.Vslider);
        this.spanel.add(this.Aslider);
    }
    @Override
    public void stateChanged(ChangeEvent e) {
        //System.out.println(this.slider.getValue());
        Ivelocity = this.Vslider.getValue();
        Iangle = this.Aslider.getValue();

    }

}