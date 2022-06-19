package com.hospital.api.service;

import com.hospital.api.DAO.PatientDao;
import com.hospital.api.DAO.StaffDao;
import com.hospital.api.model.Patient;
import com.hospital.api.model.Staff;

import java.util.ArrayList;
import java.util.List;

public class StaffService {
    public static boolean checkInput(String name, String address, String designation,
                                     String salary, String contact) {
        if(name.equalsIgnoreCase("")||
            name == null ||
                address.equalsIgnoreCase("")||
                    address == null ||
                        designation.equalsIgnoreCase("")||
                            designation == null ||
                                checkIntegerConversion(salary) || salary == null ||
                                    contact.equalsIgnoreCase("") ||
                                        contact == null){
            return false;
        }
        else {
            return true;
        }
    }

    public static boolean checkIntegerConversion(String txt){
        try{
            int num = Integer.parseInt(txt);
            if(num<=0){
                return true;
            }
            else {
                return false;
            }
        }
        catch (Exception e){
            return true;
        }
    }

    public static void addStaff(Staff obj) {
        StaffDao.addStaff(obj);
    }
    
    public static String[][] viewStaff(){
        List<Staff> staffs = new ArrayList<>(StaffDao.getAllStaff());
        String data[][] = new String[staffs.size()][6];
        int row=0;
        for (Staff s: staffs){
            data[row][0]=String.valueOf(s.getStaff_id());
            data[row][1]=s.getName();
            data[row][2] = s.getAddress();
            data[row][3] = s.getDesignation();
            data[row][4] = String.valueOf(s.getSalary());
            data[row][5] = s.getContact();
            row++;
        }
        return data;
    }

    public static Integer[] getStaffID(){
        List<Staff> staffs = new ArrayList<>(StaffDao.getAllStaff());
        Integer id[] = new Integer[staffs.size()+1];
        id[0] = -1;
        int row=1;
        for (Staff s: staffs){
            id[row]=s.getStaff_id();
            row++;
        }
        return id;
    }

    public static boolean deleteStaff(Integer id){
        if(id<=0)
        {
            return false;
        }
        else {
            StaffDao.deleteStaff(id);
            return true;
        }
    }

    public static Staff getStaff(Integer id) {
        Staff obj = StaffDao.getStaff(id);
        return obj;
    }

    public static void updateStaff(Staff obj) {
        StaffDao.updateStaff(obj);
    }
}