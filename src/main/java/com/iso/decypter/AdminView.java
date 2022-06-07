package com.iso.decypter;

import javax.swing.*;
import java.awt.*;

public class AdminView extends JPanel {
    private JFrame loginFrame=new JFrame();
    public AdminView() {

        setLayout(null);
        setOpaque(true);
        loginFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        loginFrame.setTitle("Admin Login");
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - loginFrame.getWidth()) / 2.6);
        int y = (int) ((dimension.getHeight() - loginFrame.getHeight()) / 2.6);
        loginFrame.setLocation(new Point(x, y));
        loginFrame.add(this);
        loginFrame.setSize(new Dimension(400, 200));

        // Username label constructor
        JLabel label = new JLabel("Username");
        label.setBounds(100, 8, 70, 20);
        add(label);


        // Username TextField constructor
        JTextField username = new JTextField();
        username.setBounds(100, 27, 198, 20);
        add(username);


        // Password Label constructor
        JLabel password1 = new JLabel("Password");
        password1.setBounds(100, 55, 70, 20);
        add(password1);



        // Password TextField
        JPasswordField Password = new JPasswordField();
        Password.setBounds(100, 75, 198, 20);
        add(Password);


        // Button constructor
        JButton button = new JButton("Login");
        button.setBounds(100, 110, 198, 25);
//        button.setForeground(Color.WHITE);
//        button.setBackground(Color.BLACK);
        button.addActionListener(v->{
            if(username.getText().equals("admin") && Password.getText().equals("admin@123")){
                Const.isAdmin=true;
                JOptionPane.showMessageDialog(loginFrame, "Admin mode enabled","Admin", JOptionPane.INFORMATION_MESSAGE);
                loginFrame.dispose();
            }else{
                JOptionPane.showMessageDialog(loginFrame, "Invalid Username or password","Error!!", JOptionPane.ERROR_MESSAGE);
            }

        });
        add(button);
        loginFrame.setVisible(true);
        loginFrame.setResizable(true);
        username.requestFocus();
    }
}
