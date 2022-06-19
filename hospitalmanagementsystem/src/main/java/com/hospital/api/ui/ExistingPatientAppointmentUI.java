package com.hospital.api.ui;

import com.hospital.api.model.Appointment;
import com.hospital.api.model.Patient;
import com.hospital.api.service.AppointmentService;
import com.hospital.api.service.DoctorService;
import com.hospital.api.service.PatientService;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class ExistingPatientAppointmentUI {
    public static void addSuccessful(JFrame frame){
        JOptionPane.showMessageDialog(frame,
                "Appointment Added Successfully ",
                "Adding Appointment",
                JOptionPane.PLAIN_MESSAGE);
    }

    public static void addFailed(JFrame frame){
        JOptionPane.showMessageDialog(frame,
                "Please check and fill all the fields ",
                "Alert",
                JOptionPane.WARNING_MESSAGE);
    }

    public static void deleteSuccessful(JFrame frame){
        JOptionPane.showMessageDialog(frame,
                "Record deleted successfully",
                "Deleted",
                JOptionPane.PLAIN_MESSAGE);
    }

    private static void updateFail(JFrame frame)
    {
        JOptionPane.showMessageDialog(frame,
                "Please check and fill all the fields ",
                "Alert",
                JOptionPane.WARNING_MESSAGE);
    }

    private static void updatePass(JFrame frame )
    {
        JOptionPane.showMessageDialog(frame,
                "Appointment Update Successfully ",
                "Updating Patient",
                JOptionPane.PLAIN_MESSAGE);
    }

    public ExistingPatientAppointmentUI(){
        JFrame frame = new JFrame();
        String p_column[] = {"ID", "Name", "Age", "Address", "Contact", "Gender"};
        String d_column[] = {"ID", "Name", "Address", "Department", "Experience", "Contact", "Fee", "Status"};
        String app_column[] = {"ID", "Patient ID","Patient Name","Date","Doctor ID","Doctor Name"};
        String[][] patient_data= PatientService.viewPatient();
        String[][] doctor_data= DoctorService.viewDoctor();
        String[][] appointment_data= AppointmentService.viewAppointment();
//        JDialog dialog;
        final int[] Row = new int[1];

//        id = DeleteService.getRecordID(className);

        JComboBox p_fieldBox = new JComboBox(p_column);
        JComboBox d_fieldBox = new JComboBox(d_column);
        JComboBox app_fieldBox = new JComboBox(app_column);
        JLabel header = new JLabel("Appointment Panel");
        JLabel patient_header = new JLabel("Patient Records");
        JLabel patient = new JLabel("Patient:");
        patient_header.setFont(new Font("Serif", Font.PLAIN,20 ));
        JLabel doctor_header = new JLabel("Doctor Records");
        JLabel doctor = new JLabel("Doctor:");
        doctor_header.setFont(new Font("Serif", Font.PLAIN,20 ));
        JLabel appointment_header = new JLabel("Appointment Records");
        JLabel appointment= new JLabel("Appointment:");
        appointment_header.setFont(new Font("Serif", Font.PLAIN,20 ));
        JLabel p_name = new JLabel("Patient Name:");
        JLabel p_id = new JLabel("Patient ID");
        JLabel d_name = new JLabel("Doctor Name:");
        JLabel d_id = new JLabel("Doctor ID:");
        JLabel age = new JLabel("Age:");
        JLabel address = new JLabel("Address:");
        JLabel contact = new JLabel("Contact:");
        JLabel gender = new JLabel("Gender:");
//        JLabel date = new JLabel("Date");
        JLabel year = new JLabel("Year");
        JLabel month = new JLabel("Month");
        JLabel day = new JLabel("Day");


//        JTextField p_nameBox = new JTextField();
//        int p_idBox = (PatientService.getLastPatientID())+1;
//        JLabel d_nameBox = new JLabel();
//        JLabel d_idBox = new JLabel();
//        d_idBox.setText("0");
//        JTextField ageBox = new JTextField();
//        JTextField addressBox = new JTextField();
//        JTextField contactBox = new JTextField();
//        String [] gen = {"male", "female"};
//        JComboBox genderBox = new JComboBox();
        JLabel p_nameBox = new JLabel();
        int p_idBox = (PatientService.getLastPatientID())+1;
        JLabel d_nameBox = new JLabel();
        JLabel d_idBox = new JLabel();
        d_idBox.setText("0");
        JLabel ageBox = new JLabel();
        JLabel addressBox = new JLabel();
        JLabel contactBox = new JLabel();
        JLabel genderBox = new JLabel();
        JTextField p_searchBox = new JTextField();
        JTextField d_searchBox = new JTextField();
        JTextField app_searchBox = new JTextField();
        JTextField yearBox = new JTextField();
        JTextField monthBox = new JTextField();
        JTextField dayBox = new JTextField();

        JButton book = new JButton("Book");
        JButton update = new JButton("Update");
        JButton setUpdate = new JButton("Update");
        JButton clear = new JButton("Clear All");
        JButton delete = new JButton("Delete");
        JButton p_search = new JButton("Search");
        JButton d_search = new JButton("Search");
        JButton app_search = new JButton("Search");
        JButton back = new JButton("<");
        JButton exit = new JButton("X");
        JButton[] d_btn = new JButton[1];
        JButton addDoctor = new JButton("Add");
        d_btn[0] = addDoctor;

        JButton[] p_btn = new JButton[1];
        JButton addPatient = new JButton("Add");
        p_btn[0] = addPatient;

        JButton[] btn = new JButton[2];
        btn[0] = delete;
        btn[1] = setUpdate;


//        book.setBounds(1050,600,100,30);
//        update.setBounds(1250,600,100,30);
////        delete.setBounds(1350,600,100,30);
//        clear.setBounds(1100,650,200,30);
        back.setBounds(50,50,50,50);
        exit.setBounds(1500,50,50,50);
        header.setBounds(500,50,800,100);
        header.setFont(new Font("Serif", Font.PLAIN,50 ));

///////////////////////////////////////////////////////////////////////////////////////////////
//        p_id.setBounds(100,200,100,30);
//        p_idBox.setBounds(100,230,100,30);
        patient.setBounds(100,170,200,30);
        p_name.setBounds(100,200,200,30);
        p_nameBox.setBounds(100,230,200,30);
        age.setBounds(400,200,100,30);
        ageBox.setBounds(400,230,200,30);
        address.setBounds(100,280,200,30);
        addressBox.setBounds(100,310,500,30);
        contact.setBounds(100,360,200,30);
        contactBox.setBounds(100,390,200,30);
        gender.setBounds(400,360,100,30);
        genderBox.setBounds(400,390,200,30);
        appointment.setBounds(100,470,200,30);
        year.setBounds(100,500,200,30);
        yearBox.setBounds(100,530,150,30);
        month.setBounds(330,500,200,30);
        monthBox.setBounds(330,530,100,30);
        day.setBounds(500,500,200,30);
        dayBox.setBounds(500,530,100,30);
        doctor.setBounds(100,600,100,30);
        d_id.setBounds(100,630,200,30);
        d_idBox.setBounds(100,660,200,30);
        d_name.setBounds(400,630,100,30);
        d_nameBox.setBounds(400,660,200,30);
        book.setBounds(500,700,100,30);
        update.setBounds(100,700,100,30);



/////////////////////////////////// patient table////////////////////////////////////////////////////////////
        p_fieldBox.setBounds(800, 170,100,30);
        p_searchBox.setBounds(900, 170,200,30);
        p_search.setBounds(1100, 170,100,30);
        patient_header.setBounds(1300,170,200,30);
        JTable patient_jt=new JTable(patient_data,p_column);
        patient_jt.setBounds(100,100,100,600);
        JScrollPane patient_sp=new JScrollPane(patient_jt);
        patient_sp.setBounds(800,200,700,120);

//////////////////////////////////Doctor table/////////////////////////////////////////////////////////////
        d_fieldBox.setBounds(800, 570,100,30);
        d_searchBox.setBounds(900, 570,200,30);
        d_search.setBounds(1100, 570,100,30);
        doctor_header.setBounds(1300,570,200,30);
        JTable doctor_jt=new JTable(doctor_data,d_column);
        doctor_jt.setBounds(100,100,100,600);
        JScrollPane doctor_sp=new JScrollPane(doctor_jt);
        doctor_sp.setBounds(800,600,700,120);

/////////////////////////////////Appointment table//////////////////////////////////////////////////////////////
        app_fieldBox.setBounds(800, 370,100,30);
        app_searchBox.setBounds(900, 370,200,30);
        app_search.setBounds(1100, 370,100,30);
        appointment_header.setBounds(1300,370,200,30);
        JTable appointment_jt=new JTable(appointment_data,app_column);
        appointment_jt.setBounds(100,100,100,600);
        JScrollPane appointment_sp=new JScrollPane(appointment_jt);
        appointment_sp.setBounds(800,400,700,120);

/////////////////////////////////patient table selector//////////////////////////////////////////////////////////////
        ListSelectionModel p_model = patient_jt.getSelectionModel();
        p_model.addListSelectionListener(e->{
            if (!p_model.isSelectionEmpty()){
                int selectedRow = p_model.getMinSelectionIndex();
//                System.out.println(selectedRow);
                Row[0] = selectedRow;
            }
            String[] options = new String[] {"Yes", "No", "Maybe", "Cancel"};

            int response = JOptionPane.showOptionDialog(null, "Message", "Title",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                    null, p_btn,JOptionPane.getDesktopPaneForComponent(null));
        });



/////////////////////////////////Doctor table selector//////////////////////////////////////////////////////////////
        ListSelectionModel d_model = doctor_jt.getSelectionModel();
        d_model.addListSelectionListener(e->{
            if (!d_model.isSelectionEmpty()){
                int selectedRow = d_model.getMinSelectionIndex();
//                System.out.println(selectedRow);
                Row[0] = selectedRow;
            }
            String[] options = new String[] {"Yes", "No", "Maybe", "Cancel"};

            int response = JOptionPane.showOptionDialog(null, "Message", "Title",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                    null, d_btn,JOptionPane.getDesktopPaneForComponent(null));
        });



/////////////////////////////////Appointment table selector//////////////////////////////////////////////////////////////
        ListSelectionModel app_model = appointment_jt.getSelectionModel();
        app_model.addListSelectionListener(e->{
            if (!app_model.isSelectionEmpty()){
                int selectedRow = app_model.getMinSelectionIndex();
//                System.out.println(selectedRow);
                Row[0] = selectedRow;
                System.out.println(Row[0]);
            }
            String[] options = new String[] {"Yes", "No", "Maybe", "Cancel"};

            int response = JOptionPane.showOptionDialog(null, "Message", "Title",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                    null, btn,JOptionPane.getDesktopPaneForComponent(null));
        });



//////////////////////////////////////doctor add//////////////////////////////////////////////////////
        addDoctor.addActionListener(e->{
            d_idBox.setText(doctor_jt.getModel().getValueAt(Row[0],0).toString());
            d_nameBox.setText(doctor_jt.getModel().getValueAt(Row[0],1).toString());
        });

//////////////////////////////////////patient add//////////////////////////////////////////////////////
        addPatient.addActionListener(e->{
            p_nameBox.setText(patient_jt.getModel().getValueAt(Row[0],1).toString());
            ageBox.setText(patient_jt.getModel().getValueAt(Row[0],2).toString());
            addressBox.setText(patient_jt.getModel().getValueAt(Row[0],3).toString());
            contactBox.setText(patient_jt.getModel().getValueAt(Row[0],4).toString());
            genderBox.setText(patient_jt.getModel().getValueAt(Row[0],5).toString());
        });

/////////////////////////////////////booking appointment//////////////////////////////////////////////////////////
        book.addActionListener(e->{
            boolean check = AppointmentService.checkInput(yearBox.getText(), monthBox.getText(),dayBox.getText(),
                    p_nameBox.getText(),ageBox.getText(),addressBox.getText(),
                    contactBox.getText(),genderBox.getText(),
                    Integer.parseInt(d_idBox.getText()),d_nameBox.getText());
            if(check){
                LocalDate date = LocalDate.of(Integer.valueOf(yearBox.getText()),
                        Integer.valueOf(monthBox.getText()),Integer.valueOf(dayBox.getText()));
                PatientService.addPatient(new Patient(p_nameBox.getText(),Integer.parseInt(ageBox.getText()),
                        addressBox.getText(), contactBox.getText(),
                        genderBox.getText()));

                AppointmentService.addAppointment(new Appointment(p_nameBox.getText(),p_idBox,date,
                        d_nameBox.getText(),Integer.parseInt(d_idBox.getText())));

                addSuccessful(frame);
                frame.dispose();
                ExistingPatientAppointmentUI existingPatientAppointmentUI = new ExistingPatientAppointmentUI();
            }
            else {
                addFailed(frame);
            }
        });
/////////////////////////////////////deleting appointment//////////////////////////////////////////////////////////
        delete.addActionListener(e->{
            Integer id = Integer.parseInt((appointment_jt.getModel().getValueAt(Row[0],0)).toString());
            System.out.println(id);
            AppointmentService.deleteAppointment(id);
            deleteSuccessful(frame);
            frame.dispose();
            ExistingPatientAppointmentUI existingPatientAppointmentUI = new ExistingPatientAppointmentUI();

        });
//////////////////////////////////setup update appointment//////////////////////////////////////////////////////////
        Integer update_id;
        setUpdate.addActionListener(e->{
            LocalDate date = LocalDate.parse((appointment_jt.getModel().getValueAt(Row[0],3)).toString());
            yearBox.setText(String.valueOf(date.getYear()));
            monthBox.setText(String.valueOf(date.getMonthValue()));
            dayBox.setText(String.valueOf(date.getDayOfMonth()));
        });
//////////////////////////////////update appointment//////////////////////////////////////////////////////////
        update.addActionListener(e->{
            Integer id = Integer.parseInt((appointment_jt.getModel().getValueAt(Row[0],0)).toString());
            boolean check = AppointmentService.checkDate(yearBox.getText(), monthBox.getText(),dayBox.getText());
            if (!check){
                LocalDate date = LocalDate.of(Integer.valueOf(yearBox.getText()),
                        Integer.valueOf(monthBox.getText()),Integer.valueOf(dayBox.getText()));
                AppointmentService.updateAppointmentDate(date,id);
                updatePass(frame);
                frame.dispose();
                ExistingPatientAppointmentUI existingPatientAppointmentUI = new ExistingPatientAppointmentUI();
            }
            else {
                updateFail(frame);
            }
        });

//////////////////////////////////patient doctor//////////////////////////////////////////////////////////
        p_search.addActionListener(e->{
            frame.dispose();
            ExistingPatientAppointmentUI existingPatientAppointmentUI = new ExistingPatientAppointmentUI(
                    p_fieldBox.getItemAt(p_fieldBox.getSelectedIndex()).toString(),p_searchBox.getText(),
                    d_fieldBox.getItemAt(d_fieldBox.getSelectedIndex()).toString(),d_searchBox.getText(),
                    app_fieldBox.getItemAt(app_fieldBox.getSelectedIndex()).toString(),app_searchBox.getText()
            );
        });
//////////////////////////////////search doctor//////////////////////////////////////////////////////////
        d_search.addActionListener(e->{
            frame.dispose();
            ExistingPatientAppointmentUI existingPatientAppointmentUI = new ExistingPatientAppointmentUI(
                    p_fieldBox.getItemAt(p_fieldBox.getSelectedIndex()).toString(),p_searchBox.getText(),
                    d_fieldBox.getItemAt(d_fieldBox.getSelectedIndex()).toString(),d_searchBox.getText(),
                    app_fieldBox.getItemAt(app_fieldBox.getSelectedIndex()).toString(),app_searchBox.getText()
            );
        });
//////////////////////////////////search appointment//////////////////////////////////////////////////////
        app_search.addActionListener(e->{
            frame.dispose();
            ExistingPatientAppointmentUI existingPatientAppointmentUI = new ExistingPatientAppointmentUI(
                    p_fieldBox.getItemAt(p_fieldBox.getSelectedIndex()).toString(),p_searchBox.getText(),
                    d_fieldBox.getItemAt(d_fieldBox.getSelectedIndex()).toString(),d_searchBox.getText(),
                    app_fieldBox.getItemAt(app_fieldBox.getSelectedIndex()).toString(),app_searchBox.getText()
            );
        });


        frame.add(patient);
        frame.add(doctor);
        frame.add(appointment);
        frame.add(year);
        frame.add(yearBox);
        frame.add(month);
        frame.add(monthBox);
        frame.add(day);
        frame.add(dayBox);
        frame.add(age);
        frame.add(ageBox);
        frame.add(gender);
        frame.add(genderBox);
        frame.add(p_id);
        frame.add(d_id);
        frame.add(d_idBox);
        frame.add(header);
        frame.add(clear);
        frame.add(patient_header);
        frame.add(doctor_header);
        frame.add(appointment_header);
        frame.add(p_fieldBox);
        frame.add(d_fieldBox);
        frame.add(app_fieldBox);
        frame.add(patient_sp);
        frame.add(doctor_sp);
        frame.add(appointment_sp);
        frame.add(p_search);
        frame.add(d_search);
        frame.add(app_search);
        frame.add(p_searchBox);
        frame.add(d_searchBox);
        frame.add(app_searchBox);
        frame.add(p_name);
        frame.add(d_name);
        frame.add(p_nameBox);
        frame.add(d_nameBox);
        frame.add(address);
        frame.add(addressBox);
        frame.add(contact);
        frame.add(contactBox);
        frame.add(book);
        frame.add(update);
        frame.add(delete);
//        frame.add(sp);
        frame.add(back);
        frame.add(exit);

        exit.addActionListener(e->{
            frame.dispose();
        });

        back.addActionListener(e->{
            frame.dispose();
            AppointmentUI appointmentUI = new AppointmentUI();
        });

        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(true);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public ExistingPatientAppointmentUI(String p_type, String p_text, String doc_type, String doc_text,
                                        String app_type, String app_text){

        JFrame frame = new JFrame();
        String p_column[] = {"ID", "Name", "Age", "Address", "Contact", "Gender"};
        String d_column[] = {"ID", "Name", "Address", "Department", "Experience", "Contact", "Fee", "Status"};
        String app_column[] = {"ID", "Patient ID","Patient Name","Date","Doctor ID","Doctor Name"};

        String[][] patient_data;
        if(p_text.equalsIgnoreCase("")||p_type.equalsIgnoreCase("")) {
            patient_data= PatientService.viewPatient();
        }
        else{
            patient_data= PatientService.viewSearchPatient(p_type,p_text);
        }

        String[][] doctor_data;
        if(doc_text.equalsIgnoreCase("")||doc_type.equalsIgnoreCase("")){
            doctor_data= DoctorService.viewDoctor();
        }
        else {
            doctor_data= DoctorService.viewSearchDoctor(doc_type,doc_text);
        }

        String[][] appointment_data;
        if(app_text.equalsIgnoreCase("")||app_type.equalsIgnoreCase("")){
            appointment_data= AppointmentService.viewAppointment();
        }
        else{
            appointment_data= AppointmentService.viewSearchAppointment(app_type,app_text);
        }

//        JDialog dialog;
        final int[] Row = new int[1];

//        id = DeleteService.getRecordID(className);

        JComboBox p_fieldBox = new JComboBox(p_column);
        JComboBox d_fieldBox = new JComboBox(d_column);
        JComboBox app_fieldBox = new JComboBox(app_column);
        JLabel header = new JLabel("Appointment Panel");
        JLabel patient_header = new JLabel("Patient Records");
        JLabel patient = new JLabel("Patient:");
        patient_header.setFont(new Font("Serif", Font.PLAIN,20 ));
        JLabel doctor_header = new JLabel("Doctor Records");
        JLabel doctor = new JLabel("Doctor:");
        doctor_header.setFont(new Font("Serif", Font.PLAIN,20 ));
        JLabel appointment_header = new JLabel("Appointment Records");
        JLabel appointment= new JLabel("Appointment:");
        appointment_header.setFont(new Font("Serif", Font.PLAIN,20 ));
        JLabel p_name = new JLabel("Patient Name:");
        JLabel p_id = new JLabel("Patient ID");
        JLabel d_name = new JLabel("Doctor Name:");
        JLabel d_id = new JLabel("Doctor ID:");
        JLabel age = new JLabel("Age:");
        JLabel address = new JLabel("Address:");
        JLabel contact = new JLabel("Contact:");
        JLabel gender = new JLabel("Gender:");
//        JLabel date = new JLabel("Date");
        JLabel year = new JLabel("Year");
        JLabel month = new JLabel("Month");
        JLabel day = new JLabel("Day");


//        JTextField p_nameBox = new JTextField();
//        int p_idBox = (PatientService.getLastPatientID())+1;
//        JLabel d_nameBox = new JLabel();
//        JLabel d_idBox = new JLabel();
//        d_idBox.setText("0");
//        JTextField ageBox = new JTextField();
//        JTextField addressBox = new JTextField();
//        JTextField contactBox = new JTextField();
//        String [] gen = {"male", "female"};
//        JComboBox genderBox = new JComboBox();
        JLabel p_nameBox = new JLabel();
        int p_idBox = (PatientService.getLastPatientID())+1;
        JLabel d_nameBox = new JLabel();
        JLabel d_idBox = new JLabel();
        d_idBox.setText("0");
        JLabel ageBox = new JLabel();
        JLabel addressBox = new JLabel();
        JLabel contactBox = new JLabel();
        JLabel genderBox = new JLabel();
        JTextField p_searchBox = new JTextField();
        JTextField d_searchBox = new JTextField();
        JTextField app_searchBox = new JTextField();
        JTextField yearBox = new JTextField();
        JTextField monthBox = new JTextField();
        JTextField dayBox = new JTextField();

        JButton book = new JButton("Book");
        JButton update = new JButton("Update");
        JButton setUpdate = new JButton("Update");
        JButton clear = new JButton("Clear All");
        JButton delete = new JButton("Delete");
        JButton p_search = new JButton("Search");
        JButton d_search = new JButton("Search");
        JButton app_search = new JButton("Search");
        JButton back = new JButton("<");
        JButton exit = new JButton("X");
        JButton[] d_btn = new JButton[1];
        JButton addDoctor = new JButton("Add");
        d_btn[0] = addDoctor;

        JButton[] p_btn = new JButton[1];
        JButton addPatient = new JButton("Add");
        p_btn[0] = addPatient;

        JButton[] btn = new JButton[2];
        btn[0] = delete;
        btn[1] = setUpdate;


//        book.setBounds(1050,600,100,30);
//        update.setBounds(1250,600,100,30);
////        delete.setBounds(1350,600,100,30);
//        clear.setBounds(1100,650,200,30);
        back.setBounds(50,50,50,50);
        exit.setBounds(1500,50,50,50);
        header.setBounds(500,50,800,100);
        header.setFont(new Font("Serif", Font.PLAIN,50 ));

///////////////////////////////////////////////////////////////////////////////////////////////
//        p_id.setBounds(100,200,100,30);
//        p_idBox.setBounds(100,230,100,30);
        patient.setBounds(100,170,200,30);
        p_name.setBounds(100,200,200,30);
        p_nameBox.setBounds(100,230,200,30);
        age.setBounds(400,200,100,30);
        ageBox.setBounds(400,230,200,30);
        address.setBounds(100,280,200,30);
        addressBox.setBounds(100,310,500,30);
        contact.setBounds(100,360,200,30);
        contactBox.setBounds(100,390,200,30);
        gender.setBounds(400,360,100,30);
        genderBox.setBounds(400,390,200,30);
        appointment.setBounds(100,470,200,30);
        year.setBounds(100,500,200,30);
        yearBox.setBounds(100,530,150,30);
        month.setBounds(330,500,200,30);
        monthBox.setBounds(330,530,100,30);
        day.setBounds(500,500,200,30);
        dayBox.setBounds(500,530,100,30);
        doctor.setBounds(100,600,100,30);
        d_id.setBounds(100,630,200,30);
        d_idBox.setBounds(100,660,200,30);
        d_name.setBounds(400,630,100,30);
        d_nameBox.setBounds(400,660,200,30);
        book.setBounds(500,700,100,30);
        update.setBounds(100,700,100,30);



/////////////////////////////////// patient table////////////////////////////////////////////////////////////
        p_fieldBox.setBounds(800, 170,100,30);
        p_searchBox.setBounds(900, 170,200,30);
        p_search.setBounds(1100, 170,100,30);
        patient_header.setBounds(1300,170,200,30);
        JTable patient_jt=new JTable(patient_data,p_column);
        patient_jt.setBounds(100,100,100,600);
        JScrollPane patient_sp=new JScrollPane(patient_jt);
        patient_sp.setBounds(800,200,700,120);

//////////////////////////////////Doctor table/////////////////////////////////////////////////////////////
        d_fieldBox.setBounds(800, 570,100,30);
        d_searchBox.setBounds(900, 570,200,30);
        d_search.setBounds(1100, 570,100,30);
        doctor_header.setBounds(1300,570,200,30);
        JTable doctor_jt=new JTable(doctor_data,d_column);
        doctor_jt.setBounds(100,100,100,600);
        JScrollPane doctor_sp=new JScrollPane(doctor_jt);
        doctor_sp.setBounds(800,600,700,120);

/////////////////////////////////Appointment table//////////////////////////////////////////////////////////////
        app_fieldBox.setBounds(800, 370,100,30);
        app_searchBox.setBounds(900, 370,200,30);
        app_search.setBounds(1100, 370,100,30);
        appointment_header.setBounds(1300,370,200,30);
        JTable appointment_jt=new JTable(appointment_data,app_column);
        appointment_jt.setBounds(100,100,100,600);
        JScrollPane appointment_sp=new JScrollPane(appointment_jt);
        appointment_sp.setBounds(800,400,700,120);

/////////////////////////////////patient table selector//////////////////////////////////////////////////////////////
        ListSelectionModel p_model = patient_jt.getSelectionModel();
        p_model.addListSelectionListener(e->{
            if (!p_model.isSelectionEmpty()){
                int selectedRow = p_model.getMinSelectionIndex();
//                System.out.println(selectedRow);
                Row[0] = selectedRow;
            }
            String[] options = new String[] {"Yes", "No", "Maybe", "Cancel"};

            int response = JOptionPane.showOptionDialog(null, "Message", "Title",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                    null, p_btn,JOptionPane.getDesktopPaneForComponent(null));
        });



/////////////////////////////////Doctor table selector//////////////////////////////////////////////////////////////
        ListSelectionModel d_model = doctor_jt.getSelectionModel();
        d_model.addListSelectionListener(e->{
            if (!d_model.isSelectionEmpty()){
                int selectedRow = d_model.getMinSelectionIndex();
//                System.out.println(selectedRow);
                Row[0] = selectedRow;
            }
            String[] options = new String[] {"Yes", "No", "Maybe", "Cancel"};

            int response = JOptionPane.showOptionDialog(null, "Message", "Title",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                    null, d_btn,JOptionPane.getDesktopPaneForComponent(null));
        });



/////////////////////////////////Appointment table selector//////////////////////////////////////////////////////////////
        ListSelectionModel app_model = appointment_jt.getSelectionModel();
        app_model.addListSelectionListener(e->{
            if (!app_model.isSelectionEmpty()){
                int selectedRow = app_model.getMinSelectionIndex();
//                System.out.println(selectedRow);
                Row[0] = selectedRow;
                System.out.println(Row[0]);
            }
            String[] options = new String[] {"Yes", "No", "Maybe", "Cancel"};

            int response = JOptionPane.showOptionDialog(null, "Message", "Title",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                    null, btn,JOptionPane.getDesktopPaneForComponent(null));
        });



//////////////////////////////////////doctor add//////////////////////////////////////////////////////
        addDoctor.addActionListener(e->{
            d_idBox.setText(doctor_jt.getModel().getValueAt(Row[0],0).toString());
            d_nameBox.setText(doctor_jt.getModel().getValueAt(Row[0],1).toString());
        });

//////////////////////////////////////patient add//////////////////////////////////////////////////////
        addPatient.addActionListener(e->{
            p_nameBox.setText(patient_jt.getModel().getValueAt(Row[0],1).toString());
            ageBox.setText(patient_jt.getModel().getValueAt(Row[0],2).toString());
            addressBox.setText(patient_jt.getModel().getValueAt(Row[0],3).toString());
            contactBox.setText(patient_jt.getModel().getValueAt(Row[0],4).toString());
            genderBox.setText(patient_jt.getModel().getValueAt(Row[0],5).toString());
        });

/////////////////////////////////////booking appointment//////////////////////////////////////////////////////////
        book.addActionListener(e->{
            boolean check = AppointmentService.checkInput(yearBox.getText(), monthBox.getText(),dayBox.getText(),
                    p_nameBox.getText(),ageBox.getText(),addressBox.getText(),
                    contactBox.getText(),genderBox.getText(),
                    Integer.parseInt(d_idBox.getText()),d_nameBox.getText());
            if(check){
                LocalDate date = LocalDate.of(Integer.valueOf(yearBox.getText()),
                        Integer.valueOf(monthBox.getText()),Integer.valueOf(dayBox.getText()));
                PatientService.addPatient(new Patient(p_nameBox.getText(),Integer.parseInt(ageBox.getText()),
                        addressBox.getText(), contactBox.getText(),
                        genderBox.getText()));

                AppointmentService.addAppointment(new Appointment(p_nameBox.getText(),p_idBox,date,
                        d_nameBox.getText(),Integer.parseInt(d_idBox.getText())));

                addSuccessful(frame);
                frame.dispose();
                ExistingPatientAppointmentUI existingPatientAppointmentUI = new ExistingPatientAppointmentUI();
            }
            else {
                addFailed(frame);
            }
        });
/////////////////////////////////////deleting appointment//////////////////////////////////////////////////////////
        delete.addActionListener(e->{
            Integer id = Integer.parseInt((appointment_jt.getModel().getValueAt(Row[0],0)).toString());
            System.out.println(id);
            AppointmentService.deleteAppointment(id);
            deleteSuccessful(frame);
            frame.dispose();
            ExistingPatientAppointmentUI existingPatientAppointmentUI = new ExistingPatientAppointmentUI();

        });
//////////////////////////////////setup update appointment//////////////////////////////////////////////////////////
        Integer update_id;
        setUpdate.addActionListener(e->{
            LocalDate date = LocalDate.parse((appointment_jt.getModel().getValueAt(Row[0],3)).toString());
            yearBox.setText(String.valueOf(date.getYear()));
            monthBox.setText(String.valueOf(date.getMonthValue()));
            dayBox.setText(String.valueOf(date.getDayOfMonth()));
        });
//////////////////////////////////update appointment//////////////////////////////////////////////////////////
        update.addActionListener(e->{
            Integer id = Integer.parseInt((appointment_jt.getModel().getValueAt(Row[0],0)).toString());
            boolean check = AppointmentService.checkDate(yearBox.getText(), monthBox.getText(),dayBox.getText());
            if (!check){
                LocalDate date = LocalDate.of(Integer.valueOf(yearBox.getText()),
                        Integer.valueOf(monthBox.getText()),Integer.valueOf(dayBox.getText()));
                AppointmentService.updateAppointmentDate(date,id);
                updatePass(frame);
                frame.dispose();
                ExistingPatientAppointmentUI existingPatientAppointmentUI = new ExistingPatientAppointmentUI();
            }
            else {
                updateFail(frame);
            }
        });

//////////////////////////////////patient doctor//////////////////////////////////////////////////////////
        p_search.addActionListener(e->{
            frame.dispose();
            ExistingPatientAppointmentUI existingPatientAppointmentUI = new ExistingPatientAppointmentUI(
                    p_fieldBox.getItemAt(p_fieldBox.getSelectedIndex()).toString(),p_searchBox.getText(),
                    d_fieldBox.getItemAt(d_fieldBox.getSelectedIndex()).toString(),d_searchBox.getText(),
                    app_fieldBox.getItemAt(app_fieldBox.getSelectedIndex()).toString(),app_searchBox.getText()
            );
        });
//////////////////////////////////search doctor//////////////////////////////////////////////////////////
        d_search.addActionListener(e->{
            frame.dispose();
            ExistingPatientAppointmentUI existingPatientAppointmentUI = new ExistingPatientAppointmentUI(
                    p_fieldBox.getItemAt(p_fieldBox.getSelectedIndex()).toString(),p_searchBox.getText(),
                    d_fieldBox.getItemAt(d_fieldBox.getSelectedIndex()).toString(),d_searchBox.getText(),
                    app_fieldBox.getItemAt(app_fieldBox.getSelectedIndex()).toString(),app_searchBox.getText()
            );
        });
//////////////////////////////////search appointment//////////////////////////////////////////////////////
        app_search.addActionListener(e->{
            frame.dispose();
            ExistingPatientAppointmentUI existingPatientAppointmentUI = new ExistingPatientAppointmentUI(
                    p_fieldBox.getItemAt(p_fieldBox.getSelectedIndex()).toString(),p_searchBox.getText(),
                    d_fieldBox.getItemAt(d_fieldBox.getSelectedIndex()).toString(),d_searchBox.getText(),
                    app_fieldBox.getItemAt(app_fieldBox.getSelectedIndex()).toString(),app_searchBox.getText()
            );
        });


        frame.add(patient);
        frame.add(doctor);
        frame.add(appointment);
        frame.add(year);
        frame.add(yearBox);
        frame.add(month);
        frame.add(monthBox);
        frame.add(day);
        frame.add(dayBox);
        frame.add(age);
        frame.add(ageBox);
        frame.add(gender);
        frame.add(genderBox);
        frame.add(p_id);
        frame.add(d_id);
        frame.add(d_idBox);
        frame.add(header);
        frame.add(clear);
        frame.add(patient_header);
        frame.add(doctor_header);
        frame.add(appointment_header);
        frame.add(p_fieldBox);
        frame.add(d_fieldBox);
        frame.add(app_fieldBox);
        frame.add(patient_sp);
        frame.add(doctor_sp);
        frame.add(appointment_sp);
        frame.add(p_search);
        frame.add(d_search);
        frame.add(app_search);
        frame.add(p_searchBox);
        frame.add(d_searchBox);
        frame.add(app_searchBox);
        frame.add(p_name);
        frame.add(d_name);
        frame.add(p_nameBox);
        frame.add(d_nameBox);
        frame.add(address);
        frame.add(addressBox);
        frame.add(contact);
        frame.add(contactBox);
        frame.add(book);
        frame.add(update);
        frame.add(delete);
//        frame.add(sp);
        frame.add(back);
        frame.add(exit);

        exit.addActionListener(e->{
            frame.dispose();
        });

        back.addActionListener(e->{
            frame.dispose();
            AppointmentUI appointmentUI = new AppointmentUI();
        });

        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(true);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        ExistingPatientAppointmentUI existingPatientAppointmentUI = new ExistingPatientAppointmentUI();
    }
}
