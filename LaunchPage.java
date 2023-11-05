
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class LaunchPage extends JFrame implements ActionListener {
    JFrame frame = new JFrame();
    JButton btnUser = new JButton("ok");

    //String username;
    JTextField user = new JTextField();
    JLabel userMessage = new JLabel("Enter Player Username");
    JLabel welcomeMessage = new JLabel("GAME NAME");

    LaunchPage(){

        //WELCOME MESSAGE
        welcomeMessage.setBounds(0,0, 500, 100);
        welcomeMessage.setFont(new Font(null,Font.PLAIN, 40));
        welcomeMessage.setForeground(Color.lightGray);
        frame.add(welcomeMessage);

        //USER MESSAGE
        userMessage.setBounds(20,300, 400, 50);
        userMessage.setFont(new Font(null,Font.PLAIN, 25));
        userMessage.setForeground(Color.lightGray);
        frame.add(userMessage);


        //USERNAME INPUT
        user.setBounds(20, 400, 300, 30);
        frame.add(user);


        //OK BUTTON
        btnUser.setBounds(300, 400, 100, 30);
        btnUser.setFocusable(false);
        btnUser.addActionListener(this);
        frame.add(btnUser);

        this.setBackground(Color.black);

        //SET FRAME
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setBackground(Color.black);
        frame.setLayout(null);
        frame.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnUser){
            frame.dispose();
            MyFrame myFrame = new MyFrame();
            String username = user.getText();
        }




    }
}
