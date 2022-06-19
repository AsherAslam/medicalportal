package com.hospital.api.DAO;

import com.hospital.api.model.Patient;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PatientDao {

    public static List<Patient> getAllPatients() {
        List<Patient> results = new ArrayList<>();
        try{
            ResultSet rs = DBService.query("select * from patient");
            while (rs.next()){
                results.add(new Patient(Integer.valueOf(rs.getString("patient_id")),
                        rs.getString("p_name"),
                        Integer.valueOf(rs.getString("age")),
                        rs.getString("address"),
                        rs.getString("contact"),
                        rs.getString("gender")));
            }
            DBService.con.close();
        }  catch (Exception e){
            System.out.println(e);
        }
        return results;
    }

    public static void addPatient(Patient obj){
        try{
            DBService.dmlQuery("INSERT INTO patient (p_name, age, address, contact, gender)" +
                    "VALUES ('"+obj.getName()+"',"+obj.getAge()+",'"+obj.getAddress()+"'," +
                    "'"+obj.getContact()+"','"+obj.getGender()+"')");
            DBService.con.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public static void deletePatient(Integer id){
        try{
            DBService.dmlQuery("DELETE FROM patient WHERE patient_id ="+id+"");
            DBService.con.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Patient getPatient(Integer id) {
        List<Patient> results = new ArrayList<>();
        Patient obj = new Patient();
        try{
            ResultSet rs = DBService.query("select * from patient WHERE patient_id ="+id+" ");
            while (rs.next()){
                results.add(new Patient(Integer.valueOf(rs.getString("patient_id")),
                        rs.getString("p_name"),
                        Integer.valueOf(rs.getString("age")),
                        rs.getString("address"),
                        rs.getString("contact"),
                        rs.getString("gender")));
            }
            DBService.con.close();
            for (Patient p: results)
            {
                   obj = p;
            }
        }  catch (Exception e){
            System.out.println(e);
        }
        return obj;
    }

    public static void updatePatient(Patient obj) {
        try{
            DBService.dmlQuery("UPDATE patient SET p_name = '"+obj.getName()+"' , age = "+obj.getAge()+"" +
                    ", address = '"+obj.getAddress()+"', contact = '"+obj.getContact()+"'" +
                    ", gender = '"+obj.getGender()+"' WHERE patient_id = "+obj.getPatient_id()+"");
            DBService.con.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
