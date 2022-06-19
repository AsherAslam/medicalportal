package com.hospital.api.DAO;
import com.hospital.api.model.Car;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CarDao {

    public static List<Car> getAllCars() {
        List<Car> results = new ArrayList<>();
        try{
            ResultSet rs = DBService.query("select * from car");
            while (rs.next()){
                results.add(new Car(Long.valueOf(rs.getString("id")),
                        rs.getString("c_name"),
                        rs.getString("model")));
            }
            DBService.con.close();
        }  catch (Exception e){
            System.out.println(e);
        }
        return results;
    }
}
