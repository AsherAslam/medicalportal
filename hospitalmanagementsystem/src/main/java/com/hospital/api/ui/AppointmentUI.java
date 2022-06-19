package com.hospital.api.ui;

import com.hospital.api.model.Patient;
import com.hospital.api.service.AppointmentService;
import com.hospital.api.service.DoctorService;
import com.hospital.api.service.PatientService;
import com.hospital.api.ui.HomeUi;

import javax.swing.*;
import java.awt.*;

public class AppointmentUI {
  public AppointmentUI(){
    JFrame frame=new JFrame();
    JLabel header = new JLabel("Appointment Records");


    JButton newPatient = new JButton("Appointment For New Patient");
    JButton existPatient = new JButton("Appointment For Existing Patient");

    JButton back = new JButton("<");
    JButton exit = new JButton("X");


    newPatient.setBounds(600,300,300,50);
    existPatient.setBounds(600,400,300,50);

    back.setBounds(50,50,50,50);
    exit.setBounds(1500,50,50,50);
    header.setBounds(550,100,600,100);
    header.setFont(new Font("Serif", Font.PLAIN,50 ));

    frame.add(newPatient);
    frame.add(existPatient);
    frame.add(header);
    frame.add(back);
    frame.add(exit);

    newPatient.addActionListener(e->{
      frame.dispose();
      NewPatientAppointmentUI newPatientAppointmentUI = new NewPatientAppointmentUI();
    });

    existPatient.addActionListener(e->{
      frame.dispose();
      ExistingPatientAppointmentUI existingPatientAppointmentUI = new ExistingPatientAppointmentUI();
    });

    exit.addActionListener(e->{
      frame.dispose();
    });

    back.addActionListener(e->{
      frame.dispose();
      HomeUi homeUi = new HomeUi();
    });

    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    frame.setUndecorated(true);
    frame.setLayout(null);
    frame.setVisible(true);

  }
}
