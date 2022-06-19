package com.hospital.api.ui;

import com.hospital.api.model.Doctor;
import com.hospital.api.model.Patient;
import com.hospital.api.model.Staff;
import com.hospital.api.service.DoctorService;
import com.hospital.api.service.PatientService;
import com.hospital.api.service.StaffService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class PatientCurdUI {

    public static void addSuccessful(JFrame frame){
        JOptionPane.showMessageDialog(frame,
                "Patient Added Successfully ",
                "Adding Patient",
                JOptionPane.PLAIN_MESSAGE);
    }

    public static void addFailed(JFrame frame){
        JOptionPane.showMessageDialog(frame,
                "Please check and fill all the fields ",
                "Alert",
                JOptionPane.WARNING_MESSAGE);
    }

//    public static void deleteFailed(JFrame frame){
//        JOptionPane.showMessageDialog(frame,
//                "Item already deleted or missing ",
//                "Alert",
//                JOptionPane.WARNING_MESSAGE);
//    }

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
                "Patient Update Successfully ",
                "Updating Patient",
                JOptionPane.PLAIN_MESSAGE);
    }

    public PatientCurdUI(){
        JFrame frame = new JFrame();
        String column[] = {"ID", "Name", "Age", "Address", "Contact", "Gender"};
        String[][] data= PatientService.viewPatient();
//        JDialog dialog;
        final int[] Row = new int[1];

//        id = DeleteService.getRecordID(className);

        JComboBox fieldBox = new JComboBox(column);
        JLabel header = new JLabel("PATIENT RECORD");
        JLabel name = new JLabel("Name");
        JLabel age = new JLabel("Age");
        JLabel address = new JLabel("Address");
        JLabel contact = new JLabel("Contact");
        JLabel gender = new JLabel("Gender");


        JTextField nameBox = new JTextField();
        JTextField ageBox = new JTextField();
        JTextField addressBox = new JTextField();
        JTextField contactBox = new JTextField();
        String [] gen = {"male", "female"};
        JComboBox genderBox = new JComboBox(gen);
        JTextField searchBox = new JTextField();

        JButton add = new JButton("Add");
        JButton update = new JButton("Update");
        JButton setUpdate = new JButton("Update");
        JButton clear = new JButton("Clear All");
        JButton delete = new JButton("Delete");
        JButton search = new JButton("Search");
        JButton back = new JButton("<");
        JButton exit = new JButton("X");

        JButton[] btn = new JButton[2];
        btn[0] = delete;
        btn[1] = setUpdate;


        add.setBounds(1050,600,100,30);
        update.setBounds(1250,600,100,30);
//        delete.setBounds(1350,600,100,30);
        clear.setBounds(1100,650,200,30);
        back.setBounds(50,50,50,50);
        exit.setBounds(1500,50,50,50);
        header.setBounds(450,50,800,100);
        header.setFont(new Font("Serif", Font.PLAIN,50 ));


        fieldBox.setBounds(1000,200,100,30);
        searchBox.setBounds(1150,200,200,30);
        search.setBounds(1360,200,100,30);


        name.setBounds(1000,300,100,30);
        nameBox.setBounds(1100,300,250,30);

        age.setBounds(1000,350,100,30);
        ageBox.setBounds(1100,350,250,30);

        address.setBounds(1000,400,100,30);
        addressBox.setBounds(1100,400,250,30);

        contact.setBounds(1000,450,100,30);
        contactBox.setBounds(1100,450,250,30);

        gender.setBounds(1000,500,100,30);
        genderBox.setBounds(1100,500,250,30);

        JTable jt=new JTable(data,column);
        jt.setBounds(100,100,100,600);
        JScrollPane sp=new JScrollPane(jt);
        sp.setBounds(100,200,800,600);




////////////////////////////////////////////////////////////////////////////////////////////////////////
        //////////////setting value from table to text field

//        ListSelectionModel model = jt.getSelectionModel();
        ListSelectionModel model = jt.getSelectionModel();
        model.addListSelectionListener(e->{
            if (!model.isSelectionEmpty()){
                int selectedRow = model.getMinSelectionIndex();
//                System.out.println(selectedRow);
                Row[0] = selectedRow;
            }
            String[] options = new String[] {"Yes", "No", "Maybe", "Cancel"};

            int response = JOptionPane.showOptionDialog(null, "Message", "Title",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                    null, btn,JOptionPane.getDesktopPaneForComponent(null));
            //////////////////
//                    int pane = JOptionPane.showOptionDialog(null, "Message", "Title",
//                     JOptionPane.PLAIN_MESSAGE,
//                     btn,options[0]);
//            System.out.println(pane);
        });

////////////////////////////////////////////////////////////////////////////////////////////////////////

        exit.addActionListener(e->{
            frame.dispose();
        });

        back.addActionListener(e->{
            frame.dispose();
            HomeUi homeUi = new HomeUi();
        });

//        JTable finalJt = jt;

        add.addActionListener(e->{
                    boolean check = PatientService.checkInput(nameBox.getText(),ageBox.getText(),addressBox.getText(),
                            contactBox.getText(),genderBox.getItemAt(genderBox.getSelectedIndex()).toString());


                    if(check)
                    {
                        PatientService.addPatient(new Patient(nameBox.getText(),Integer.parseInt(ageBox.getText()),addressBox.getText(),
                                contactBox.getText(),genderBox.getItemAt(genderBox.getSelectedIndex()).toString()));
                        addSuccessful(frame);
                        frame.dispose();
                        PatientCurdUI patientCurdUI = new PatientCurdUI();
                    }
                    else {
                        addFailed(frame);
                    }
        });

/////////////////////// Update value set-up Button //////////////////////////////////////////////
//        JTable finalJt = jt;
        setUpdate.addActionListener(e->{
                    nameBox.setText(jt.getModel().getValueAt(Row[0],1).toString());
                    ageBox.setText(jt.getModel().getValueAt(Row[0],2).toString());
                    addressBox.setText(jt.getModel().getValueAt(Row[0],3).toString());
                    contactBox.setText(jt.getModel().getValueAt(Row[0],4).toString());
                    genderBox.setSelectedItem(jt.getModel().getValueAt(Row[0],5));
        });


/////////////////////// Delete Button //////////////////////////////////////////////

        delete.addActionListener(e->{
                Integer id = Integer.parseInt((jt.getModel().getValueAt(Row[0],0)).toString());
                System.out.println(id);
                PatientService.deletePatient(id);
                deleteSuccessful(frame);
                frame.dispose();
                PatientCurdUI patientCurdUI = new PatientCurdUI();
        });

/////////////////////// update Button //////////////////////////////////////////////

        update.addActionListener(e->{
            boolean check;
            Integer objId = Integer.parseInt((jt.getModel().getValueAt(Row[0],0)).toString());
            check = PatientService.checkInput(nameBox.getText(),ageBox.getText(),addressBox.getText(),
                    contactBox.getText(),genderBox.getItemAt(genderBox.getSelectedIndex()).toString());
            if(check)
            {
                PatientService.updatePatient(new Patient(objId,nameBox.getText(),
                        Integer.parseInt(ageBox.getText()),addressBox.getText(),
                        contactBox.getText(),genderBox.getItemAt(genderBox.getSelectedIndex()).toString()));
                updatePass(frame);
                frame.dispose();
                PatientCurdUI patientCurdUI = new PatientCurdUI();
            }
            else {
                updateFail(frame);
            }
        });


/////////////////////// Search Button //////////////////////////////////////////////

        search.addActionListener(e->{
            frame.dispose();
            PatientCurdUI patientCurdUI =
                    new PatientCurdUI(fieldBox.getItemAt(fieldBox.getSelectedIndex()).toString(),searchBox.getText());
        });

/////////////////////// /////////////////////////////////////////////////////////
///////////////////////setting clear /////////////////////////////////////////////////////////
        clear.addActionListener(e->{
            frame.dispose();
            PatientCurdUI patientCurdUI = new PatientCurdUI();
        });

/////////////////////// /////////////////////////////////////////////////////////

        frame.add(name);
        frame.add(nameBox);
        frame.add(age);
        frame.add(ageBox);
        frame.add(address);
        frame.add(addressBox);
        frame.add(contact);
        frame.add(contactBox);
        frame.add(gender);
        frame.add(genderBox);
        frame.add(fieldBox);
        frame.add(add);
        frame.add(update);
        frame.add(delete);
        frame.add(clear);
        frame.add(search);
        frame.add(searchBox);
        frame.add(header);
        frame.add(sp);
        frame.add(back);
        frame.add(exit);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(true);
        frame.setLayout(null);
        frame.setVisible(true);
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public PatientCurdUI(String type, String text){
        JFrame frame = new JFrame();
        String column[] = {"ID", "Name", "Age", "Address", "Contact", "Gender"};
        String[][] data= PatientService.viewSearchPatient(type, text);
        JDialog dialog;
        final int[] Row = new int[1];

//        id = DeleteService.getRecordID(className);

        JComboBox fieldBox = new JComboBox(column);
        JLabel header = new JLabel("PATIENT RECORD");
        JLabel name = new JLabel("Name");
        JLabel age = new JLabel("Age");
        JLabel address = new JLabel("Address");
        JLabel contact = new JLabel("Contact");
        JLabel gender = new JLabel("Gender");


        JTextField nameBox = new JTextField();
        JTextField ageBox = new JTextField();
        JTextField addressBox = new JTextField();
        JTextField contactBox = new JTextField();
        String [] gen = {"male", "female"};
        JComboBox genderBox = new JComboBox(gen);
        JTextField searchBox = new JTextField();

        JButton add = new JButton("Add");
        JButton update = new JButton("Update");
        JButton setUpdate = new JButton("Update");
        JButton clear = new JButton("Clear All");
        JButton delete = new JButton("Delete");
        JButton search = new JButton("Search");
        JButton back = new JButton("<");
        JButton exit = new JButton("X");

        JButton[] btn = new JButton[2];
        btn[0] = delete;
        btn[1] = setUpdate;

        searchBox.setText(text);
        fieldBox.setSelectedItem(type);

        add.setBounds(1050,600,100,30);
        update.setBounds(1250,600,100,30);
//        delete.setBounds(1350,600,100,30);
        clear.setBounds(1100,650,200,30);
        back.setBounds(50,50,50,50);
        exit.setBounds(1500,50,50,50);
        header.setBounds(450,50,800,100);
        header.setFont(new Font("Serif", Font.PLAIN,50 ));


        fieldBox.setBounds(1000,200,100,30);
        searchBox.setBounds(1150,200,200,30);
        search.setBounds(1360,200,100,30);


        name.setBounds(1000,300,100,30);
        nameBox.setBounds(1100,300,250,30);

        age.setBounds(1000,350,100,30);
        ageBox.setBounds(1100,350,250,30);

        address.setBounds(1000,400,100,30);
        addressBox.setBounds(1100,400,250,30);

        contact.setBounds(1000,450,100,30);
        contactBox.setBounds(1100,450,250,30);

        gender.setBounds(1000,500,100,30);
        genderBox.setBounds(1100,500,250,30);

        JTable jt=new JTable(data,column);
        jt.setBounds(100,100,100,600);
        JScrollPane sp=new JScrollPane(jt);
        sp.setBounds(100,200,800,600);




////////////////////////////////////////////////////////////////////////////////////////////////////////
        //////////////setting value from table to text field

//        ListSelectionModel model = jt.getSelectionModel();
        ListSelectionModel model = jt.getSelectionModel();
        model.addListSelectionListener(e->{
            if (!model.isSelectionEmpty()){
                int selectedRow = model.getMinSelectionIndex();
//                System.out.println(selectedRow);
                Row[0] = selectedRow;
            }
            String[] options = new String[] {"Yes", "No", "Maybe", "Cancel"};

            int response = JOptionPane.showOptionDialog(null, "Message", "Title",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                    null, btn,JOptionPane.getDesktopPaneForComponent(null));
            //////////////////
//                    int pane = JOptionPane.showOptionDialog(null, "Message", "Title",
//                     JOptionPane.PLAIN_MESSAGE,
//                     btn,options[0]);
//            System.out.println(pane);
        });

////////////////////////////////////////////////////////////////////////////////////////////////////////

        exit.addActionListener(e->{
            frame.dispose();
        });

        back.addActionListener(e->{
            frame.dispose();
            HomeUi homeUi = new HomeUi();
        });

//        JTable finalJt = jt;

        add.addActionListener(e->{
            boolean check = PatientService.checkInput(nameBox.getText(),ageBox.getText(),addressBox.getText(),
                    contactBox.getText(),genderBox.getItemAt(genderBox.getSelectedIndex()).toString());


            if(check)
            {
                PatientService.addPatient(new Patient(nameBox.getText(),Integer.parseInt(ageBox.getText()),addressBox.getText(),
                        contactBox.getText(),genderBox.getItemAt(genderBox.getSelectedIndex()).toString()));
                addSuccessful(frame);
            }
            else {
                addFailed(frame);
            }
        });

/////////////////////// Update value set-up Button //////////////////////////////////////////////
//        JTable finalJt = jt;
        setUpdate.addActionListener(e->{
            nameBox.setText(jt.getModel().getValueAt(Row[0],1).toString());
            ageBox.setText(jt.getModel().getValueAt(Row[0],2).toString());
            addressBox.setText(jt.getModel().getValueAt(Row[0],3).toString());
            contactBox.setText(jt.getModel().getValueAt(Row[0],4).toString());
            genderBox.setSelectedItem(jt.getModel().getValueAt(Row[0],5));
        });


/////////////////////// Delete Button //////////////////////////////////////////////

        delete.addActionListener(e->{
            Integer id = Integer.parseInt((jt.getModel().getValueAt(Row[0],0)).toString());
            System.out.println(id);
            PatientService.deletePatient(id);
            deleteSuccessful(frame);
            frame.dispose();
            PatientCurdUI patientCurdUI = new PatientCurdUI();
        });

/////////////////////// update Button //////////////////////////////////////////////

        update.addActionListener(e->{
            boolean check;
            Integer objId = Integer.parseInt((jt.getModel().getValueAt(Row[0],0)).toString());
            check = PatientService.checkInput(nameBox.getText(),ageBox.getText(),addressBox.getText(),
                    contactBox.getText(),genderBox.getItemAt(genderBox.getSelectedIndex()).toString());
            if(check)
            {
                PatientService.updatePatient(new Patient(objId,nameBox.getText(),
                        Integer.parseInt(ageBox.getText()),addressBox.getText(),
                        contactBox.getText(),genderBox.getItemAt(genderBox.getSelectedIndex()).toString()));
                updatePass(frame);
                frame.dispose();
                PatientCurdUI patientCurdUI = new PatientCurdUI();
            }
            else {
                updateFail(frame);
            }
        });


/////////////////////// Search Button //////////////////////////////////////////////

        search.addActionListener(e->{
            frame.dispose();
            PatientCurdUI patientCurdUI =
                    new PatientCurdUI(fieldBox.getItemAt(fieldBox.getSelectedIndex()).toString(),searchBox.getText());

        });

///////////////////////setting clear /////////////////////////////////////////////////////////
        clear.addActionListener(e->{
            frame.dispose();
            PatientCurdUI patientCurdUI = new PatientCurdUI();
        });

/////////////////////// /////////////////////////////////////////////////////////

        frame.add(name);
        frame.add(nameBox);
        frame.add(age);
        frame.add(ageBox);
        frame.add(address);
        frame.add(addressBox);
        frame.add(contact);
        frame.add(contactBox);
        frame.add(gender);
        frame.add(genderBox);
        frame.add(fieldBox);
        frame.add(add);
        frame.add(update);
        frame.add(delete);
        frame.add(clear);
        frame.add(search);
        frame.add(searchBox);
        frame.add(header);
        frame.add(sp);
        frame.add(back);
        frame.add(exit);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(true);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new PatientCurdUI();
    }
}

