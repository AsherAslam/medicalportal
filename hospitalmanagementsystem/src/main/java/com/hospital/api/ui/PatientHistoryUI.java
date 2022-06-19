package com.hospital.api.ui;

import com.hospital.api.DAO.PatientHistoryDao;

import javax.swing.*;
import java.awt.*;

public class PatientHistoryUI {
    public PatientHistoryUI(){

        JFrame frame=new JFrame();
        JLabel header = new JLabel("Patient History Records");
        JLabel id = new JLabel("ID");
        JLabel patientId = new JLabel("Patient ID");
        JLabel bloodGroup = new JLabel("Blood Group");
        JLabel patientVisit = new JLabel("Patient No. of Visit(s)");

        JTextField idBox = new JTextField();
        JTextField patientIdBox = new JTextField();
        JTextField bloodGroupBox = new JTextField();
        JTextField patientVisitBox = new JTextField();


        JButton add = new JButton("Add");
        JButton update = new JButton("Update");
        JButton delete = new JButton("Delete");
        JButton view = new JButton("View");
        JButton back = new JButton("<");
        JButton exit = new JButton("X");


        back.setBounds(50,50,50,50);
        exit.setBounds(1500,50,50,50);
        header.setBounds(500,100,600,100);
        header.setFont(new Font("Serif", Font.PLAIN,50 ));

        id.setBounds(550,250,100,30);
        idBox.setBounds(700,250,250,30);

        patientId.setBounds(550,300,100,30);
        patientIdBox.setBounds(700,300,250,30);

        bloodGroup.setBounds(550,350,100,30);
        bloodGroupBox.setBounds(700,350,250,30);

        patientVisit.setBounds(550,400,150,30);
        patientVisitBox.setBounds(700,400,250,30);;

        add.setBounds(400,500,100,30);
        update.setBounds(600,500,100,30);
        delete.setBounds(800,500,100,30);
        view.setBounds(1000,500,100,30);


        frame.add(header);
        frame.add(id);
        frame.add(idBox);
        frame.add(patientId);
        frame.add(patientIdBox);
        frame.add(bloodGroup);
        frame.add(bloodGroupBox);
        frame.add(patientVisit);
        frame.add(patientVisitBox);
        frame.add(add);
        frame.add(update);
        frame.add(delete);
        frame.add(view);
        frame.add(back);
        frame.add(exit);

        exit.addActionListener(e->{
            frame.dispose();
        });

        back.addActionListener(e->{
            frame.dispose();
            PatientHistoryUI patientUI = new PatientHistoryUI();
        });

        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(true);
        frame.setLayout(null);
        frame.setVisible(true);
    }

}
