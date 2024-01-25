import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class LaunchPage extends JFrame implements ActionListener {
    //JFrame frame;
    JButton btnUser = new JButton("PLAY");
    Image one;
    Image two;
    Image three;

    //public static String username;
//    JTextField user = new JTextField();
    JTextArea text = new JTextArea("");
    JLabel welcomeMessage = new JLabel("SLING-SHOT ORBIT");

    LaunchPage(){

        one = new ImageIcon("ship.png").getImage();
        one = one.getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        two = new ImageIcon("planet.png").getImage();
        two = two.getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        three = new ImageIcon("target.png").getImage();
        three = three.getScaledInstance(40, 40, Image.SCALE_DEFAULT);


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setBackground(Color.blue);
        this.setLayout(null);
        this.setVisible(true);

        text = new JTextArea(">>>   Select your chosen starting speed and angle using the sliders\n \n" +
                ">>>    When you are ready, press 'launch'!\n \n" +
                ">>>     Press 'play' to activate game");
        text.setBounds(100, 200, 400, 80);

        //(235,235,235,));
        text.setForeground(Color.black);
        text.setFont(new Font(null,Font.ROMAN_BASELINE, 10));
        text.setOpaque(false);
        this.add(text);

        this.setLocationRelativeTo(null);
        //WELCOME MESSAGE
        this.setBackground(Color.black);
        welcomeMessage.setBounds(100,100, 500, 100);
        welcomeMessage.setFont(new Font(null,Font.ROMAN_BASELINE, 30));
        welcomeMessage.setForeground(Color.black);
        //welcomeMessage.set
        //welcomeMessage.setBackground(Color.black);
        this.add(welcomeMessage);

        //USER MESSAGE
//        userMessage.setBounds(20,300, 400, 50);
//        userMessage.setFont(new Font(null,Font.PLAIN, 25));
//        userMessage.setForeground(Color.lightGray);
        //frame.add(userMessage);


        //USERNAME INPUT
//        user.setBounds(20, 400, 300, 30);
//        frame.add(user);


        //OK BUTTON
        btnUser.setBounds(200, 300, 100, 30);
        btnUser.setFocusable(false);
        btnUser.addActionListener(this);
        this.add(btnUser);







    }
    public void paint(Graphics g) {

        super.paint(g); // paint background

        Graphics2D g2D = (Graphics2D) g;

        g2D.drawImage(this.one, 100,50 , null);
        g2D.drawImage(this.two, 200,50 , null);
        g2D.drawImage(this.three, 350,80 , null);

//        g2D.drawImage(this.mass, (int) this.mx, (int) this.my, null);
//        g2D.drawImage(this.target, px, py, null);
        //g2D.drawImage(this.pointer, this.px, this.py, null);
        //timerLaunch.start();
        //timerV.start();


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnUser){
            this.dispose();
            MyFrame myFrame = new MyFrame();
            //String username = user.getText();
        }




    }
}