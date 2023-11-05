import java.awt.*;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class sliderPanel implements ChangeListener{

    JSlider slider;

    sliderPanel(){
        slider = new JSlider(JSlider.VERTICAL,0, 10, 5);
        slider.addChangeListener(this);
        slider.setMajorTickSpacing(10);
        slider.setMinorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
    }

    @Override
    public void stateChanged(ChangeEvent e) {

    }
}
