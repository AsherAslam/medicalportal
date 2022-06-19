package com.hospital.api.service;
import com.hospital.api.model.Car;
import com.hospital.api.DAO.CarDao;

import java.util.List;

public class CarService {

    public List<Car> getAllCars(){
        return CarDao.getAllCars();
    }

}
