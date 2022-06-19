package com.hospital.api.ui;

import com.hospital.api.model.Patient;
import com.hospital.api.model.Staff;
import com.hospital.api.service.PatientService;
import com.hospital.api.service.StaffService;

import javax.swing.*;
import java.awt.*;

public class StaffCurdUI {

    public static void addSuccessful(JFrame frame){
        JOptionPane.showMessageDialog(frame,
                "Staff Added Successfully ",
                "Adding Staff",
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

    public StaffCurdUI(){
        JFrame frame = new JFrame();
        String column[] = {"ID","Name","Address","Designation","Salary","Contact"};
        String[][] data= StaffService.viewStaff();;
        JDialog dialog;
        final int[] Row = new int[1];

//        id = DeleteService.getRecordID(className);
        JComboBox fieldBox = new JComboBox(column);
        JLabel header = new JLabel("STAFF RECORD");
        JLabel name = new JLabel("Name");
        JLabel address = new JLabel("Address");
        JLabel designation = new JLabel("Designation");
        JLabel salary = new JLabel("Salary");
        JLabel contact = new JLabel("Contact");


        JTextField nameBox = new JTextField();
        JTextField addressBox = new JTextField();
        JTextField contactBox = new JTextField();
        JTextField designationBox = new JTextField();
        JTextField salaryBox = new JTextField();
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

        address.setBounds(1000,350,100,30);
        addressBox.setBounds(1100,350,250,30);

        designation.setBounds(1000,400,100,30);
        designationBox.setBounds(1100,400,250,30);

        contact.setBounds(1000,500,100,30);
        contactBox.setBounds(1100,500,250,30);

        salary.setBounds(1000,450,100,30);
        salaryBox.setBounds(1100,450,250,30);

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
            boolean check = StaffService.checkInput(nameBox.getText(),addressBox.getText(),designationBox.getText(),
                    salaryBox.getText(),contactBox.getText());
            if (check){
                StaffService.addStaff(new Staff(nameBox.getText(),addressBox.getText(),designationBox.getText(),
                        Integer.parseInt(salaryBox.getText()),contactBox.getText()));
                addSuccessful(frame);
                frame.dispose();
                StaffCurdUI staffCurdUI = new StaffCurdUI();
            }
            else {
                addFailed(frame);
            }
        });

/////////////////////// Update value set-up Button //////////////////////////////////////////////
//        JTable finalJt = jt;
        setUpdate.addActionListener(e->{
            nameBox.setText(jt.getModel().getValueAt(Row[0],1).toString());
            addressBox.setText(jt.getModel().getValueAt(Row[0],2).toString());
            designationBox.setText(jt.getModel().getValueAt(Row[0],3).toString());
            salaryBox.setText(jt.getModel().getValueAt(Row[0],4).toString());
            contactBox.setText(jt.getModel().getValueAt(Row[0],5).toString());
        });


/////////////////////// Delete Button //////////////////////////////////////////////

        delete.addActionListener(e->{
            Integer id = Integer.parseInt((jt.getModel().getValueAt(Row[0],0)).toString());
            System.out.println(id);
            StaffService.deleteStaff(id);
            deleteSuccessful(frame);
            frame.dispose();
            StaffCurdUI staffCurdUI = new StaffCurdUI();
        });

/////////////////////// update Button //////////////////////////////////////////////

        update.addActionListener(e->{
            boolean check;
            Integer objId = Integer.parseInt((jt.getModel().getValueAt(Row[0],0)).toString());
            check = StaffService.checkInput(nameBox.getText(),addressBox.getText(),
                    designationBox.getText(), salaryBox.getText(),contactBox.getText());
            if (check){
                StaffService.updateStaff(new Staff(objId,nameBox.getText(),addressBox.getText(),
                        designationBox.getText(), Integer.parseInt(salaryBox.getText()),
                        contactBox.getText()));
                updatePass(frame);
                frame.dispose();
                StaffCurdUI staffCurdUI = new StaffCurdUI();
            }
            else {
                updateFail(frame);
            }
        });


/////////////////////// Search Button //////////////////////////////////////////////

        search.addActionListener(e->{

        });

/////////////////////// /////////////////////////////////////////////////////////

        frame.add(name);
        frame.add(nameBox);
        frame.add(address);
        frame.add(addressBox);
        frame.add(contact);
        frame.add(contactBox);
        frame.add(designation);
        frame.add(designationBox);
        frame.add(salary);
        frame.add(salaryBox);
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
        new StaffCurdUI();
    }
}

