import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MyFrame extends JFrame implements ChangeListener{

    charPanel charpanel;

    JSlider slider;
    JPanel spanel;

    int velocity;

    final int PANEL_WIDTH = 500;
    final int PANEL_HEIGHT = 500;

    MyFrame(){

        charpanel = new charPanel();
        spanel = new JPanel();

        spanel.setBounds(400, 0, 50, 500);


        this.setPreferredSize(new Dimension(PANEL_WIDTH,PANEL_HEIGHT));
        this.setBackground(Color.black);
        this.spanel.setBackground(Color.black);

        slider = new JSlider(JSlider.VERTICAL,0, 10, 5);
        slider.addChangeListener(this);
        slider.setBounds(450, 50, 50, 50);
        slider.setMajorTickSpacing(10);
        slider.setMinorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);




        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(charpanel);
        this.add(this.spanel);
        this.spanel.add(this.slider);
        this.setLayout(null);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setLayout(null);

    }

    @Override
    public void stateChanged(ChangeEvent e) {
        velocity = this.slider.getValue();
    }
}