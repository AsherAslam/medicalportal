package com.hospital.api.ui;

import com.hospital.api.ui.HomeUi;

import javax.swing.*;
import java.awt.*;

public class Start {
  public Start() {
    JFrame jFrame=new JFrame("Hospital management system");
    final ImageIcon icon = new ImageIcon("C:\\Users\\HP\\OneDrive\\Documents\\stepway\\bg-cloud.jpg");
    JTextArea text = new JTextArea()
    {
      Image img = icon.getImage();
      // instance initializer
      {setOpaque(false);}
      public void paintComponent(Graphics graphics)
      {
        graphics.drawImage(img, 0, 0, this);
        super.paintComponent(graphics);
      }
    };
    JLabel jLabel=new JLabel("Medical Portal");
    JLabel user = new JLabel("Username");
    JLabel password = new JLabel("Password");
    JTextField userBox = new JTextField();
    JTextField passwordBox = new JTextField();
    JButton start=new JButton("START");
    JButton exit = new JButton("X");


    user.setBounds(550,350,100,30);
    userBox.setBounds(650,350,200,30);
    password.setBounds(550,400,100,30);
    passwordBox.setBounds(650,400,200,30);
    start.setBounds(600,500,150,30);
    exit.setBounds(1500,50,50,50);
    jLabel.setBounds(400,100,1200,200);

    jLabel.setFont(new Font("Serif", Font.PLAIN,70 ));
    user.setFont(new Font("Serif", Font.PLAIN,20 ));
    password.setFont(new Font("Serif", Font.PLAIN,20 ));


    jFrame.add(start);
    jFrame.add(exit);
    jFrame.add(jLabel);
    jFrame.add(user);
    jFrame.add(password);
    jFrame.add(userBox);
    jFrame.add(passwordBox);

//    jFrame.setSize(500,500);
    JScrollPane pane = new JScrollPane(text);
    Container content = jFrame.getContentPane();
    content.add(pane, BorderLayout.CENTER);
    jFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    jFrame.setUndecorated(true);
    jFrame.setLayout(null);
    jFrame.setVisible(true);
    start.addActionListener(e->{
      jFrame.dispose();
      HomeUi homeUi = new HomeUi();
    });

    exit.addActionListener(e->{
      jFrame.dispose();
    });
  }


}
