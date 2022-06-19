package com.hospital.api.DAO;

import com.hospital.api.model.Doctor;
import com.hospital.api.model.Patient;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DoctorDao {
    public static List<Doctor> getAllDoctors() {
        List<Doctor> results = new ArrayList<>();
        try{
            ResultSet rs = DBService.query("select * from doctor");
            while (rs.next()){
                results.add(new Doctor(Integer.valueOf(rs.getString("doctor_id")),
                        rs.getString("d_name"),
                        rs.getString("address"),
                        rs.getString("department"),
                        rs.getString("experience"),
                        rs.getString("contact"),
                        Double.valueOf(rs.getString("fee")),
                        rs.getString("d_status")));
            }
            DBService.con.close();
        }  catch (Exception e){
            System.out.println(e);
        }
        return results;
    }

    public static void addDoctor(Doctor obj) {

        try{
            DBService.dmlQuery("INSERT INTO doctor (d_name, address, department, experience, contact, fee, d_status)" +
                    "VALUES ('"+obj.getName()+"','"+obj.getAddress()+"','"+obj.getDepartment()+"'," +
                    "'"+obj.getExperience()+"','"+ obj.getContact()+"',"+obj.getFee()+",'"+obj.getStatus()+"')");
            DBService.con.close();
        }

        catch (Exception e){
            System.out.println(e);
        }
    }

    public static void deleteDoctor(Integer id) {
        try{
            DBService.dmlQuery("DELETE FROM doctor WHERE doctor_id ="+id+"");
            DBService.con.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Doctor getDoctor(Integer id) {
        List<Doctor> results = new ArrayList<>();
        Doctor obj = new Doctor();
        try{
            ResultSet rs = DBService.query("select * from doctor WHERE doctor_id = "+id+"");
            while (rs.next()){
                results.add(new Doctor(Integer.valueOf(rs.getString("doctor_id")),
                        rs.getString("d_name"),
                        rs.getString("address"),
                        rs.getString("department"),
                        rs.getString("experience"),
                        rs.getString("contact"),
                        Double.valueOf(rs.getString("fee")),
                        rs.getString("status")));
            }
            DBService.con.close();
            for (Doctor d: results)
            {
                obj = d;
            }
        }  catch (Exception e){
            System.out.println(e);
        }
        return obj;
    }

    public static void updateDoctor(Doctor obj) {
        try{
            DBService.dmlQuery("UPDATE doctor SET d_name = '"+obj.getName()+"' , address = '"+obj.getAddress()+"'," +
                    " department = '"+obj.getDepartment()+"', experience = '"+obj.getExperience()+"', " +
                    " contact = '"+obj.getContact()+"' , fee = '"+obj.getFee()+"', d_status = '"+obj.getStatus()+"'" +
                    "WHERE doctor_id = "+obj.getDoctor_id()+"");
            DBService.con.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }


}