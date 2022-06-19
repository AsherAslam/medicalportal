package com.hospital.api.ui;

import com.hospital.api.model.Doctor;
import com.hospital.api.service.DoctorService;
import com.hospital.api.service.PatientService;

import javax.swing.*;
import java.awt.*;

public class DoctorCurdUI {

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
    public DoctorCurdUI(){

        JFrame frame=new JFrame();
        String column[] = {"ID", "Name", "Address", "Department", "Experience", "Contact", "Fee", "Status"};
        String[][] data= DoctorService.viewDoctor();
        JDialog dialog;
        final int[] Row = new int[1];

        JLabel header = new JLabel("Doctor Records");
        JLabel name = new JLabel("Name");
        JLabel address = new JLabel("Address");
        JLabel department = new JLabel("Department");
        JLabel experience = new JLabel("Experience");
        JLabel contact = new JLabel("Contact");
        JLabel fee = new JLabel("Visiting Fees");
        JLabel status = new JLabel("Current status");

        JTextField nameBox = new JTextField();
        JTextField addressBox = new JTextField();
        JTextField departmentBox = new JTextField();
        JTextField experienceBox = new JTextField();
        JTextField contactBox = new JTextField();
        JTextField feeBox = new JTextField();
        String [] stat = {"available","not-available"};
        JComboBox statusBox = new JComboBox(stat);
        JTextField searchBox = new JTextField();
        JComboBox fieldBox = new JComboBox(column);


        JButton add = new JButton("Add");
        JButton update = new JButton("Update");
        JButton delete = new JButton("Delete");
        JButton search = new JButton("Search");
        JButton setUpdate = new JButton("Update");
        JButton back = new JButton("<");
        JButton exit = new JButton("X");
        JButton clear = new JButton("Clear All");

        JButton[] btn = new JButton[2];
        btn[0] = delete;
        btn[1] = setUpdate;

        add.setBounds(1050,700,100,30);
        update.setBounds(1250,700,100,30);
//        delete.setBounds(1350,600,100,30);
        clear.setBounds(1100,750,200,30);
        back.setBounds(50,50,50,50);
        exit.setBounds(1500,50,50,50);
        header.setBounds(450,50,800,100);
        header.setFont(new Font("Serif", Font.PLAIN,50 ));

        fieldBox.setBounds(1000,200,100,30);
        searchBox.setBounds(1150,200,200,30);
        search.setBounds(1360,200,100,30);

        name.setBounds(1000,300,100,30);
        nameBox.setBounds(1100,300,250,30);

        address.setBounds(1000,350,100,30);
        addressBox.setBounds(1100,350,250,30);

        department.setBounds(1000,400,100,30);
        departmentBox.setBounds(1100,400,250,30);

        experience.setBounds(1000,450,100,30);
        experienceBox.setBounds(1100,450,250,30);

        contact.setBounds(1000,500,100,30);
        contactBox.setBounds(1100,500,250,30);

        fee.setBounds(1000,550,100,30);
        feeBox.setBounds(1100,550,250,30);

        status.setBounds(1000,600,100,30);
        statusBox.setBounds(1100,600,250,30);


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

        frame.add(header);
        frame.add(clear);
        frame.add(fieldBox);
        frame.add(search);
        frame.add(searchBox);
        frame.add(fee);
        frame.add(feeBox);
        frame.add(statusBox);
        frame.add(status);
        frame.add(name);
        frame.add(nameBox);
        frame.add(department);
        frame.add(departmentBox);
        frame.add(address);
        frame.add(addressBox);
        frame.add(contact);
        frame.add(contactBox);
        frame.add(experience);
        frame.add(experienceBox);
        frame.add(add);
        frame.add(update);
        frame.add(delete);
        frame.add(sp);
        frame.add(back);
        frame.add(exit);

        exit.addActionListener(e->{
            frame.dispose();
        });

        back.addActionListener(e->{
            frame.dispose();
            HomeUi homeUi = new HomeUi();
        });

        add.addActionListener(e->{
            boolean check = DoctorService.checkInput(nameBox.getText(),addressBox.getText(),departmentBox.getText(),
                    experienceBox.getText(),contactBox.getText(),feeBox.getText());

            if(check)
            {
                DoctorService.addDoctor(new Doctor(nameBox.getText(),addressBox.getText(),departmentBox.getText(),
                        experienceBox.getText(),contactBox.getText(),Double.parseDouble(feeBox.getText()),
                        statusBox.getItemAt(statusBox.getSelectedIndex()).toString()));
                addSuccessful(frame);
                frame.dispose();
                DoctorCurdUI doctorCurdUI = new DoctorCurdUI();
            }
            else {
                addFailed(frame);
            }
        });

        delete.addActionListener(e->{
            Integer id = Integer.parseInt((jt.getModel().getValueAt(Row[0],0)).toString());
            System.out.println(id);
            DoctorService.deleteDoctor(id);
            deleteSuccessful(frame);
            frame.dispose();
            DoctorCurdUI doctorCurdUI = new DoctorCurdUI();
        });

        update.addActionListener(e->{
            Integer objId = Integer.parseInt((jt.getModel().getValueAt(Row[0],0)).toString());
            boolean check = DoctorService.checkInput(nameBox.getText(),addressBox.getText(),departmentBox.getText(),
                    experienceBox.getText(),contactBox.getText(), feeBox.getText());
            if(check)
            {
                DoctorService.updateDoctor(new Doctor(objId,nameBox.getText(),
                        addressBox.getText(),departmentBox.getText(),
                        experienceBox.getText(),contactBox.getText(),Double.parseDouble(feeBox.getText()),
                        statusBox.getItemAt(statusBox.getSelectedIndex()).toString()));
                updatePass(frame);
                frame.dispose();
                DoctorCurdUI doctorCurdUI = new DoctorCurdUI();
            }
            else{
                updateFail(frame);
            }
        });

        setUpdate.addActionListener(e->{
              nameBox.setText(jt.getModel().getValueAt(Row[0],1).toString());
              addressBox.setText(jt.getModel().getValueAt(Row[0],2).toString());
              departmentBox.setText(jt.getModel().getValueAt(Row[0],3).toString());
              experienceBox.setText(jt.getModel().getValueAt(Row[0],4).toString());
              contactBox.setText(jt.getModel().getValueAt(Row[0],5).toString());
              feeBox.setText(jt.getModel().getValueAt(Row[0],6).toString());
              statusBox.setSelectedItem(jt.getModel().getValueAt(Row[0],7));
        });

        clear.addActionListener(e->{
            frame.dispose();
            DoctorCurdUI doctorCurdUI = new DoctorCurdUI();
        });

        search.addActionListener(e->{
            frame.dispose();
            DoctorCurdUI doctorCurdUI=
                    new DoctorCurdUI(fieldBox.getItemAt(fieldBox.getSelectedIndex()).toString(),searchBox.getText());

        });




        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(true);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    public DoctorCurdUI(String type, String text){

        JFrame frame=new JFrame();
        String column[] = {"ID", "Name", "Address", "Department", "Experience", "Contact", "Fee", "Status"};
        String[][] data= DoctorService.viewSearchDoctor(type, text);
        JDialog dialog;

        final int[] Row = new int[1];

        JLabel header = new JLabel("Doctor Records");
        JLabel name = new JLabel("Name");
        JLabel address = new JLabel("Address");
        JLabel department = new JLabel("Department");
        JLabel experience = new JLabel("Experience");
        JLabel contact = new JLabel("Contact");
        JLabel fee = new JLabel("Visiting Fees");
        JLabel status = new JLabel("Current status");

        JTextField nameBox = new JTextField();
        JTextField addressBox = new JTextField();
        JTextField departmentBox = new JTextField();
        JTextField experienceBox = new JTextField();
        JTextField contactBox = new JTextField();
        JTextField feeBox = new JTextField();
        String [] stat = {"available","not-available"};
        JComboBox statusBox = new JComboBox(stat);
        JTextField searchBox = new JTextField();
        searchBox.setText(text);
        JComboBox fieldBox = new JComboBox(column);


        JButton add = new JButton("Add");
        JButton update = new JButton("Update");
        JButton delete = new JButton("Delete");
        JButton search = new JButton("Search");
        JButton setUpdate = new JButton("Update");
        JButton back = new JButton("<");
        JButton exit = new JButton("X");
        JButton clear = new JButton("Clear All");

        JButton[] btn = new JButton[2];
        btn[0] = delete;
        btn[1] = setUpdate;

        add.setBounds(1050,700,100,30);
        update.setBounds(1250,700,100,30);
//        delete.setBounds(1350,600,100,30);
        clear.setBounds(1100,750,200,30);
        back.setBounds(50,50,50,50);
        exit.setBounds(1500,50,50,50);
        header.setBounds(450,50,800,100);
        header.setFont(new Font("Serif", Font.PLAIN,50 ));

        fieldBox.setBounds(1000,200,100,30);
        searchBox.setBounds(1150,200,200,30);
        search.setBounds(1360,200,100,30);

        name.setBounds(1000,300,100,30);
        nameBox.setBounds(1100,300,250,30);

        address.setBounds(1000,350,100,30);
        addressBox.setBounds(1100,350,250,30);

        department.setBounds(1000,400,100,30);
        departmentBox.setBounds(1100,400,250,30);

        experience.setBounds(1000,450,100,30);
        experienceBox.setBounds(1100,450,250,30);

        contact.setBounds(1000,500,100,30);
        contactBox.setBounds(1100,500,250,30);

        fee.setBounds(1000,550,100,30);
        feeBox.setBounds(1100,550,250,30);

        status.setBounds(1000,600,100,30);
        statusBox.setBounds(1100,600,250,30);


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

        frame.add(header);
        frame.add(clear);
        frame.add(fieldBox);
        frame.add(search);
        frame.add(searchBox);
        frame.add(fee);
        frame.add(feeBox);
        frame.add(statusBox);
        frame.add(status);
        frame.add(name);
        frame.add(nameBox);
        frame.add(department);
        frame.add(departmentBox);
        frame.add(address);
        frame.add(addressBox);
        frame.add(contact);
        frame.add(contactBox);
        frame.add(experience);
        frame.add(experienceBox);
        frame.add(add);
        frame.add(update);
        frame.add(delete);
        frame.add(sp);
        frame.add(back);
        frame.add(exit);

        exit.addActionListener(e->{
            frame.dispose();
        });

        back.addActionListener(e->{
            frame.dispose();
            HomeUi homeUi = new HomeUi();
        });

        add.addActionListener(e->{
            boolean check = DoctorService.checkInput(nameBox.getText(),addressBox.getText(),departmentBox.getText(),
                    experienceBox.getText(),contactBox.getText(),feeBox.getText());

            if(check)
            {
                DoctorService.addDoctor(new Doctor(nameBox.getText(),addressBox.getText(),departmentBox.getText(),
                        experienceBox.getText(),contactBox.getText(),Double.parseDouble(feeBox.getText()),
                        statusBox.getItemAt(statusBox.getSelectedIndex()).toString()));
                addSuccessful(frame);
                frame.dispose();
                DoctorCurdUI doctorCurdUI = new DoctorCurdUI();
            }
            else {
                addFailed(frame);
            }
        });

        delete.addActionListener(e->{
            Integer id = Integer.parseInt((jt.getModel().getValueAt(Row[0],0)).toString());
            System.out.println(id);
            DoctorService.deleteDoctor(id);
            deleteSuccessful(frame);
            frame.dispose();
            DoctorCurdUI doctorCurdUI = new DoctorCurdUI();
        });

        update.addActionListener(e->{
            Integer objId = Integer.parseInt((jt.getModel().getValueAt(Row[0],0)).toString());
            boolean check = DoctorService.checkInput(nameBox.getText(),addressBox.getText(),departmentBox.getText(),
                    experienceBox.getText(),contactBox.getText(), feeBox.getText());
            if(check)
            {
                DoctorService.updateDoctor(new Doctor(objId,nameBox.getText(),
                        addressBox.getText(),departmentBox.getText(),
                        experienceBox.getText(),contactBox.getText(),Double.parseDouble(feeBox.getText()),
                        statusBox.getItemAt(statusBox.getSelectedIndex()).toString()));
                updatePass(frame);
                frame.dispose();
                DoctorCurdUI doctorCurdUI = new DoctorCurdUI();
            }
            else{
                updateFail(frame);
            }
        });

        setUpdate.addActionListener(e->{
            nameBox.setText(jt.getModel().getValueAt(Row[0],1).toString());
            addressBox.setText(jt.getModel().getValueAt(Row[0],2).toString());
            departmentBox.setText(jt.getModel().getValueAt(Row[0],3).toString());
            experienceBox.setText(jt.getModel().getValueAt(Row[0],4).toString());
            contactBox.setText(jt.getModel().getValueAt(Row[0],5).toString());
            feeBox.setText(jt.getModel().getValueAt(Row[0],6).toString());
            statusBox.setSelectedItem(jt.getModel().getValueAt(Row[0],7));
        });

        clear.addActionListener(e->{
            frame.dispose();
            DoctorCurdUI doctorCurdUI = new DoctorCurdUI();
        });

        search.addActionListener(e->{
            frame.dispose();
            DoctorCurdUI doctorCurdUI=
                    new DoctorCurdUI(fieldBox.getItemAt(fieldBox.getSelectedIndex()).toString(),searchBox.getText());

        });




        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(true);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        DoctorCurdUI dd = new DoctorCurdUI();
    }
}
