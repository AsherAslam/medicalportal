package com.hospital.api.model;

import java.time.LocalDate;
import java.util.Date;

public final class Appointment {
  private int appointment_id;
  private String patient_name;
  private int patient_id;
  private LocalDate date;
  private String doctor_name;
  private int doctor_id;

  public Appointment() {
  }

  public Appointment(String patient_name, int patient_id, LocalDate date, String doctor_name, int doctor_id) {
    this.patient_name = patient_name;
    this.patient_id = patient_id;
    this.date = date;
    this.doctor_name = doctor_name;
    this.doctor_id = doctor_id;
  }

  public Appointment(int appointment_id, String patient_name, int patient_id, LocalDate date, String doctor_name, int doctor_id) {
    this.appointment_id = appointment_id;
    this.patient_name = patient_name;
    this.patient_id = patient_id;
    this.date = date;
    this.doctor_name = doctor_name;
    this.doctor_id = doctor_id;
  }

  public int getAppointment_id() {
    return appointment_id;
  }

  public void setAppointment_id(int appointment_id) {
    this.appointment_id = appointment_id;
  }

  public String getPatient_name() {
    return patient_name;
  }

  public void setPatient_name(String patient_name) {
    this.patient_name = patient_name;
  }

  public int getPatient_id() {
    return patient_id;
  }

  public void setPatient_id(int patient_id) {
    this.patient_id = patient_id;
  }

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public String getDoctor_name() {
    return doctor_name;
  }

  public void setDoctor_name(String doctor_name) {
    this.doctor_name = doctor_name;
  }

  public int getDoctor_id() {
    return doctor_id;
  }

  public void setDoctor_id(int doctor_id) {
    this.doctor_id = doctor_id;
  }
}
