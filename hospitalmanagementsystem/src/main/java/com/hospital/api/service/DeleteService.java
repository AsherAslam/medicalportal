package com.hospital.api.service;

import com.hospital.api.model.Doctor;
import com.hospital.api.model.Patient;
import com.hospital.api.model.Staff;

public class DeleteService {
//    public static Integer[] getRecordID(String className){
//        Integer id[] = null;
//        switch (className){
//            case "patient":
//                id = PatientService.getPatientID();
//                break;
//
//            case "doctor":
//                id = DoctorService.getDoctorID();
//                break;
//
//            case "staff":
//                id = StaffService.getStaffID();
//                break;
//        }
//        return id;
//    }

//    public static boolean deleteRecord(String className,Integer id){
//        boolean check;
//        if(id<=0)
//        {
//            return false;
//        }
//        else {
//        switch (className){
//            case "patient":
//                check=PatientService.deletePatient(id);
//                break;
//
//            case "doctor":
//                check=DoctorService.deleteDoctor(id);
//                break;
//
//            case "staff":
//                check=StaffService.deleteStaff(id);
//                break;
//        }
//        return true;
//        }
//    }

    public static Object getObjectRecord(String className,Integer id){
        Object obj=null;
        switch (className){
            case "patient":
                obj =(Patient) PatientService.getPatient(id);
                break;

            case "doctor":
                obj =(Doctor) DoctorService.getDoctor(id);
                break;

            case "staff":
                obj =(Staff) StaffService.getStaff(id);
                break;
        }
        return obj;

    }

    public static String[][] viewRecord(String className){
        String data[][] =null;
        switch (className){
            case "patient":
//                data = PatientService.viewPatient();
                break;
            case "doctor":
                data = DoctorService.viewDoctor();
                break;
            case "staff":
                data = StaffService.viewStaff();
                break;
        }
        return data;
    }
}
