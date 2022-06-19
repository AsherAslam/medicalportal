package com.hospital.api.service;


import com.hospital.api.DAO.DoctorDao;
import com.hospital.api.DAO.PatientDao;
import com.hospital.api.model.Doctor;
import com.hospital.api.model.Patient;

import java.util.ArrayList;
import java.util.List;

public class DoctorService {


    public static boolean checkInput(String name, String address, String department,
                                     String experience, String contact, String fee) {
        if(name.equalsIgnoreCase("")||name == null||
            address.equalsIgnoreCase("")||address==null||
            department.equalsIgnoreCase("")||department==null ||
            experience.equalsIgnoreCase("") || experience == null ||
            contact.equalsIgnoreCase("") || contact == null ||
            fee.equalsIgnoreCase("") || fee == null || checkIntegerConversion(fee))
        {
            return false;
        }
        else {
            return true;
        }
    }

    public static boolean checkIntegerConversion(String txt) {
        try {
            double num = Double.parseDouble(txt);
            if (num <= 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return true;
        }
    }


        public static void addDoctor(Doctor obj) {

        DoctorDao.addDoctor(obj);
    }

    public static String[][] viewDoctor() {
        List<Doctor> doctors = new ArrayList<>(DoctorDao.getAllDoctors());
        String data[][] =new String[doctors.size()][8];
        int row = 0;
        for (Doctor d : doctors) {
            data[row][0] = String.valueOf(d.getDoctor_id());
            data[row][1] = d.getName();
            data[row][2] = d.getAddress();
            data[row][3] = d.getDepartment();
            data[row][4] = d.getExperience();
            data[row][5] = d.getContact();
            data[row][6] = String.valueOf(d.getFee());
            data[row][7] = d.getStatus();
            row++;
        }
        return data;
    }

    public static Integer[] getDoctorID() {
        List<Doctor> doctors = new ArrayList<>(DoctorDao.getAllDoctors());
        Integer id[] = new Integer[doctors.size()+1];
        id[0]=-1;
        int row=1;
        for (Doctor d : doctors) {
            id[row] = d.getDoctor_id();
            row++;
        }
        return id;
    }

    public static boolean deleteDoctor(Integer id) {
        if(id<=0)
        {
            return false;
        }
        else {
            DoctorDao.deleteDoctor(id);
            return true;
        }
    }

    public static Doctor getDoctor(Integer id) {
        Doctor obj = DoctorDao.getDoctor(id);
        return obj;
    }

    public static void updateDoctor(Doctor obj) {
        DoctorDao.updateDoctor(obj);
    }

    public static String[][] viewSearchDoctor(String type, String text) {
        List<Doctor> doctors = new ArrayList<>(DoctorDao.getAllDoctors());
        String data[][]=new String[doctors.size()][6];
//        {"ID", "Name", "Address", "Designation", "Experience", "Contact", "Fee", "Status"}
        switch (type){
            case "ID":
                data = viewSearchDoctorByID(doctors,text);
                break;

            case "Name":
                data = viewSearchDoctorByName(doctors,text);
                break;

            case "Address":
                data = viewSearchDoctorByAddress(doctors,text);
                break;

            case "Department":
                data = viewSearchDoctorByDepartment(doctors,text);
                break;

            case "Experience":
                data = viewSearchDoctorByExperience(doctors,text);
                break;

            case "Contact":
                data = viewSearchDoctorByContact(doctors,text);
                break;

            case "Fee":
                data = viewSearchDoctorByFee(doctors,text);
                break;

            case "Status":
                data = viewSearchDoctorByStatus(doctors,text);
                break;
        }
        return data;
    }

    private static String[][] viewSearchDoctorByStatus(List<Doctor> doctors, String text) {
        String data[][] = new String[doctors.size()][8];
        int row = 0;
        for (Doctor d: doctors){
            if (d.getStatus().equalsIgnoreCase(text) || d.getStatus().contains(text)){
                data[row][0] = String.valueOf(d.getDoctor_id());
                data[row][1] = d.getName();
                data[row][2] = d.getAddress();
                data[row][3] = d.getDepartment();
                data[row][4] = d.getExperience();
                data[row][5] = d.getContact();
                data[row][6] = String.valueOf(d.getFee());
                data[row][7] = d.getStatus();
                row++;
            }
        }
        return data;
    }

    private static String[][] viewSearchDoctorByFee(List<Doctor> doctors, String text) {
        String data[][] = new String[doctors.size()][8];
        int row = 0;
        for (Doctor d: doctors){
            if (d.getFee() == Double.parseDouble(text)){
                data[row][0] = String.valueOf(d.getDoctor_id());
                data[row][1] = d.getName();
                data[row][2] = d.getAddress();
                data[row][3] = d.getDepartment();
                data[row][4] = d.getExperience();
                data[row][5] = d.getContact();
                data[row][6] = String.valueOf(d.getFee());
                data[row][7] = d.getStatus();
                row++;
            }
        }
        return data;
    }

    private static String[][] viewSearchDoctorByContact(List<Doctor> doctors, String text) {
        String data[][] = new String[doctors.size()][8];
        int row = 0;
        for (Doctor d: doctors){
            if (d.getContact().equalsIgnoreCase(text) || d.getContact().contains(text)){
                data[row][0] = String.valueOf(d.getDoctor_id());
                data[row][1] = d.getName();
                data[row][2] = d.getAddress();
                data[row][3] = d.getDepartment();
                data[row][4] = d.getExperience();
                data[row][5] = d.getContact();
                data[row][6] = String.valueOf(d.getFee());
                data[row][7] = d.getStatus();
                row++;
            }
        }
        return data;
    }

    private static String[][] viewSearchDoctorByExperience(List<Doctor> doctors, String text) {String data[][] = new String[doctors.size()][8];
        int row = 0;
        for (Doctor d: doctors){
            if (d.getExperience().equalsIgnoreCase(text) || d.getExperience().contains(text)){
                data[row][0] = String.valueOf(d.getDoctor_id());
                data[row][1] = d.getName();
                data[row][2] = d.getAddress();
                data[row][3] = d.getDepartment();
                data[row][4] = d.getExperience();
                data[row][5] = d.getContact();
                data[row][6] = String.valueOf(d.getFee());
                data[row][7] = d.getStatus();
                row++;
            }
        }
        return data;
    }

    private static String[][] viewSearchDoctorByDepartment(List<Doctor> doctors, String text) {
        String data[][] = new String[doctors.size()][8];
        int row = 0;
        for (Doctor d: doctors){
            if (d.getDepartment().equalsIgnoreCase(text) || d.getDepartment().contains(text)){
                data[row][0] = String.valueOf(d.getDoctor_id());
                data[row][1] = d.getName();
                data[row][2] = d.getAddress();
                data[row][3] = d.getDepartment();
                data[row][4] = d.getExperience();
                data[row][5] = d.getContact();
                data[row][6] = String.valueOf(d.getFee());
                data[row][7] = d.getStatus();
                row++;
            }
        }
        return data;
    }

    private static String[][] viewSearchDoctorByAddress(List<Doctor> doctors, String text) {
        String data[][] = new String[doctors.size()][8];
        int row = 0;
        for (Doctor d: doctors){
            if (d.getAddress().equalsIgnoreCase(text) || d.getAddress().contains(text)){
                data[row][0] = String.valueOf(d.getDoctor_id());
                data[row][1] = d.getName();
                data[row][2] = d.getAddress();
                data[row][3] = d.getDepartment();
                data[row][4] = d.getExperience();
                data[row][5] = d.getContact();
                data[row][6] = String.valueOf(d.getFee());
                data[row][7] = d.getStatus();
                row++;
            }
        }
        return data;
    }

    private static String[][] viewSearchDoctorByName(List<Doctor> doctors, String text) {
        String data[][] = new String[doctors.size()][8];
        int row = 0;
        for (Doctor d: doctors){
            if (d.getName().equalsIgnoreCase(text) || d.getName().contains(text)){
                data[row][0] = String.valueOf(d.getDoctor_id());
                data[row][1] = d.getName();
                data[row][2] = d.getAddress();
                data[row][3] = d.getDepartment();
                data[row][4] = d.getExperience();
                data[row][5] = d.getContact();
                data[row][6] = String.valueOf(d.getFee());
                data[row][7] = d.getStatus();
                row++;
            }
        }
        return data;
    }

    private static String[][] viewSearchDoctorByID(List<Doctor> doctors, String text) {
        String data[][] = new String[doctors.size()][8];
        int row = 0;
        for (Doctor d: doctors){
            if (d.getDoctor_id()==Integer.parseInt(text)){
                data[row][0] = String.valueOf(d.getDoctor_id());
                data[row][1] = d.getName();
                data[row][2] = d.getAddress();
                data[row][3] = d.getDepartment();
                data[row][4] = d.getExperience();
                data[row][5] = d.getContact();
                data[row][6] = String.valueOf(d.getFee());
                data[row][7] = d.getStatus();
                row++;
            }
        }
        return data;
    }


}