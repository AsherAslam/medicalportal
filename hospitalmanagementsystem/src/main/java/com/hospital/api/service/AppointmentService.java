package com.hospital.api.service;

import com.hospital.api.DAO.AppointmentDao;
import com.hospital.api.DAO.DoctorDao;
import com.hospital.api.DAO.PatientDao;
import com.hospital.api.model.Appointment;
import com.hospital.api.model.Doctor;
import com.hospital.api.model.Patient;
//import sun.util.resources.LocaleData;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AppointmentService {
    public static boolean checkInput(String year, String month, String day, String patientName,
                                     String age, String address, String contact, String gender,
                                     Integer doctorID, String doctorName) {

        if(year.equalsIgnoreCase("")|| year==null || checkIntegerConversion(year) ||
                month.equalsIgnoreCase("")|| month==null || checkIntegerConversion(month) ||
                day.equalsIgnoreCase("")|| day==null || checkIntegerConversion(day) ||
                patientName.equalsIgnoreCase("") || patientName == null ||
                checkIntegerConversion(age) || age == null ||
                address.equalsIgnoreCase("") || address == null ||
                contact.equalsIgnoreCase("" ) || contact == null ||
                gender.equalsIgnoreCase("") || gender == null|| doctorID<=0 ||
                doctorName.equalsIgnoreCase("") || doctorName == null||
                        checkDate(year,month,day))
        {
            return false;
        }
        else{
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

    public static boolean checkDate(String year, String month, String day){
        LocalDate date;
        try{
            date = LocalDate.of(Integer.valueOf(year),Integer.valueOf(month),Integer.valueOf(day));
        }
        catch (Exception e){
            return true;
        }
//        LocalDate.now().isAfter(date)
        if(date.isAfter(LocalDate.now())||date.equals(LocalDate.now()))
        {
            return false;
        }
        else {
            return true;
        }
    }


    public static String[][] viewAppointment() {
        List<Appointment> appointments = new ArrayList<>(AppointmentDao.getAllAppointment());
        String data[][] =new String[appointments.size()][6];
        int row = 0;
        for (Appointment app : appointments) {
            data[row][0] = String.valueOf(app.getAppointment_id());
            data[row][1] = String.valueOf(app.getPatient_id());
            data[row][2] = app.getPatient_name();
            data[row][3] = String.valueOf(app.getDate());
            data[row][4] = String.valueOf(app.getDoctor_id());
            data[row][5] = app.getDoctor_name();
            row++;
        }
        return data;
    }

    public static void addAppointment(Appointment obj) {
        AppointmentDao.addAppointment(obj);
    }

    public static void deleteAppointment(Integer id) {
        AppointmentDao.deleteAppointment(id);
    }

    public static void updateAppointmentDate(LocalDate date, Integer id) {
        AppointmentDao.updateAppointmentDate(date,id);
    }

    public static String[][] viewSearchAppointment(String app_type, String app_text) {
        List<Appointment> appointments = new ArrayList<>(AppointmentDao.getAllAppointment());
        String data[][]=new String[appointments.size()][6];
        switch (app_type){
            case "ID":
//                data = viewSearchAppointmentByID(appointments,app_text);
                break;
        }
        return data;
    }

    private static String[][] viewSearchAppointmentByID(List<Appointment> appointments, String app_text) {
        String data[][] =new String[appointments.size()][6];
        int row = 0;
        for (Appointment app : appointments) {
            if (app.getAppointment_id() == Integer.parseInt(app_text)){
                data[row][0] = String.valueOf(app.getAppointment_id());
                data[row][1] = String.valueOf(app.getPatient_id());
                data[row][2] = app.getPatient_name();
                data[row][3] = String.valueOf(app.getDate());
                data[row][4] = String.valueOf(app.getDoctor_id());
                data[row][5] = app.getDoctor_name();
                row++;
            }
        }
        return data;
    }
}