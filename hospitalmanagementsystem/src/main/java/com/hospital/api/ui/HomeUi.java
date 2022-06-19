package com.hospital.api.ui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;



public class HomeUi {
  public HomeUi() {
    JFrame frame = new JFrame();

    JButton patientButton = new JButton("Patient Details");
    JButton appointmentButton = new JButton("Appointment List");
    JButton doctorButton = new JButton("Doctor Details");
    JButton staffButton = new JButton("Staff Details");
    JButton back = new JButton("<");
    JButton exit = new JButton("X");


    patientButton.setBounds(350, 250, 400, 50);
    appointmentButton.setBounds(850, 250, 400, 50);
    doctorButton.setBounds(350, 350, 400, 50);
    staffButton.setBounds(850, 350, 400, 50);
    back.setBounds(50, 50, 50, 50);
    exit.setBounds(1500, 50, 50, 50);


    frame.add(patientButton);
    frame.add(appointmentButton);
    frame.add(doctorButton);
    frame.add(staffButton);
    frame.add(back);
    frame.add(exit);

//    frame.setSize(500,500);
    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    frame.setUndecorated(true);
    frame.setLayout(null);
    frame.setVisible(true);

    exit.addActionListener(e -> {
      frame.dispose();
    });

    back.addActionListener(e -> {
      frame.dispose();
      Start start = new Start();
    });

    patientButton.addActionListener(e -> {
      frame.dispose();
      PatientCurdUI patientCurdUI = new PatientCurdUI();
    });

    doctorButton.addActionListener(e -> {
      frame.dispose();
      DoctorCurdUI doctorCurdUI = new DoctorCurdUI();
    });

    staffButton.addActionListener(e -> {
      frame.dispose();
      StaffCurdUI staffUI = new StaffCurdUI();
    });

    appointmentButton.addActionListener(e -> {
      frame.dispose();
      AppointmentUI appointmentUI = new AppointmentUI();
    });

  }
}
