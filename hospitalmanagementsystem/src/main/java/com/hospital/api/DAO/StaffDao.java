package com.hospital.api.DAO;

import com.hospital.api.model.Patient;
import com.hospital.api.model.Staff;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StaffDao {
    public static List<Staff> getAllStaff() {
        List<Staff> results = new ArrayList<>();
        try{
            ResultSet rs = DBService.query("select * from staff");
            while (rs.next()){
                results.add(new Staff(Integer.valueOf(rs.getString("staff_id")),
                        rs.getString("s_name"),
                        rs.getString("address"),
                        rs.getString("designation"),
                        Integer.valueOf(rs.getString("salary")),
                        rs.getString("contact")));
            }
            DBService.con.close();
        }  catch (Exception e){
            System.out.println(e);
        }
        return results;
    }

    public static void addStaff(Staff obj) {
        try{
            DBService.dmlQuery("INSERT INTO staff (s_name, address, designation, salary, contact)" +
                    "Values ('"+obj.getName()+"','"+obj.getAddress()+"','"+obj.getDesignation()+"'," +
                    ""+obj.getSalary()+",'"+obj.getContact()+"')");
            DBService.con.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void deleteStaff(Integer id){
        try{
            DBService.dmlQuery("DELETE FROM staff WHERE staff_id ="+id+"");
            DBService.con.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Staff getStaff(Integer id) {
        List<Staff> results = new ArrayList<>();
        Staff obj = new Staff();
        try{
            ResultSet rs = DBService.query("select * from staff where staff_id = "+id+"");
            while (rs.next()){
                results.add(new Staff(Integer.valueOf(rs.getString("staff_id")),
                        rs.getString("s_name"),
                        rs.getString("address"),
                        rs.getString("designation"),
                        Integer.valueOf(rs.getString("salary")),
                        rs.getString("contact")));
            }
            DBService.con.close();
            for (Staff s:results) {
                obj = s;
            }
        }  catch (Exception e){
            System.out.println(e);
        }
        return obj;
    }

    public static void updateStaff(Staff obj) {
        try{
            DBService.dmlQuery("UPDATE staff SET s_name = '"+obj.getName()+"', address = '"+obj.getAddress()+"', " +
                    "designation = '"+obj.getDesignation()+"', salary = "+obj.getSalary()+", " +
                    "contact = '"+obj.getContact()+"' WHERE staff_id = "+obj.getStaff_id()+"");
            DBService.con.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}