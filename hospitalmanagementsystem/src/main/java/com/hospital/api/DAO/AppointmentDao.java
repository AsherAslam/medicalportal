package com.hospital.api.DAO;

import com.hospital.api.model.Appointment;
import com.hospital.api.model.Doctor;
import com.hospital.api.model.Patient;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDao {
    public static List<Appointment> getAllAppointment() {
        List<Appointment> results = new ArrayList<>();
        try{
            ResultSet rs = DBService.query("select * from appointment");
            while (rs.next()){
                results.add(new Appointment(Integer.valueOf(rs.getString("appointment_id")),
                        rs.getString("patient_name"),
                        Integer.valueOf(rs.getString("patient_id")),
                        LocalDate.parse(rs.getString("appointment_date")),
                        rs.getString("doctor_name"),
                        Integer.valueOf(rs.getString("doctor_id"))));
            }
            DBService.con.close();
        }  catch (Exception e){
            System.out.println(e);
        }
        return results;
    }

    public static void addAppointment(Appointment obj) {
            try{
                DBService.dmlQuery("INSERT INTO appointment (patient_name, patient_id, appointment_date," +
                        " doctor_name, doctor_id)" +
                        "VALUES ('"+obj.getPatient_name()+"',"+obj.getPatient_id()+",'"+obj.getDate()+"'," +
                        "'"+obj.getDoctor_name()+"',"+obj.getDoctor_id()+")");
                DBService.con.close();
            }
            catch (Exception e){
                System.out.println(e);
            }
    }

    public static void deleteAppointment(Integer id) {
        try{
            DBService.dmlQuery("DELETE FROM appointment WHERE appointment_id ="+id+"");
            DBService.con.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void updateAppointmentDate(LocalDate date, Integer id) {
        try{
            DBService.dmlQuery("UPDATE appointment SET appointment_date = '"+date+"' WHERE appointment_id ="+id+"");
            DBService.con.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}