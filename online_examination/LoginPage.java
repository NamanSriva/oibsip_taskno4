package online_examination;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPage implements ActionListener {

    JFrame frame=new JFrame();
    JButton loginButton= new JButton("Login");
    JButton resetButton= new JButton("Reset");
    JTextField userIDField = new JTextField();
    JPasswordField userPasswordField= new JPasswordField();
    JLabel userIDLabel= new JLabel("USERID:");
    JLabel userPasswordLabel= new JLabel("PASSWORD:");
    JLabel messageLabel= new JLabel("WELCOME TO EXAM PORTAL");


    HashMap<String,String> logininfo=new HashMap<>();


    LoginPage(HashMap<String,String> loginInfoOriginal){


        logininfo=loginInfoOriginal;


        userIDLabel.setBounds(50,100,75,25);
        userPasswordLabel.setBounds(50,150,75,25);

        messageLabel.setBounds(150,250,500,35);
        messageLabel.setFont(new Font(null,Font.ITALIC,25));

        userIDField.setBounds(125,100,200,25);
        userPasswordField.setBounds(125,150,200,25);



        loginButton.setBounds(125,200,100,25);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);
        
        resetButton.setBounds(225,200,100,25);
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);

        frame.add(loginButton);
        frame.add(resetButton);
        frame.add(userIDField);
        frame.add(userPasswordField);
        frame.add(messageLabel);
        frame.add(userIDLabel);
        frame.add(userPasswordLabel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,420);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){

        if(e.getSource()==resetButton){
            userIDField.setText("");
            userPasswordField.setText("");
            messageLabel.setText("");
        }

        if(e.getSource()==loginButton){
            String userID=userIDField.getText();
            String password= String.valueOf(userPasswordField.getPassword());

            if(logininfo.containsKey(userID)){
                if(logininfo.get(userID).equals(password)){
                   messageLabel.setForeground(Color.green);
                   messageLabel.setText("Login Successful !!!");
                   frame.dispose();
                   Quiz quiz=new Quiz();
              }

                 else{
                messageLabel.setForeground(Color.red);
                messageLabel.setText("Wrong Password !!!");
                }
            }

            else {
                messageLabel.setForeground(Color.blue);
                messageLabel.setText("User Name not found !!!");
            }
        }

    }

    
}
