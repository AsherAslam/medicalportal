package com.hospital.api.model;

public class Doctor {
  private int doctor_id;
  private String name;
  private String address;
  private String Department;
  private String Experience;
  private String contact;
  private double fee;
  private String status;

  public Doctor() {
  }

  public Doctor(String name, String address, String department, String experience, String contact, double fee, String status) {
    this.name = name;
    this.address = address;
    Department = department;
    Experience = experience;
    this.contact = contact;
    this.fee = fee;
    this.status = status;
  }

  public Doctor(int doctor_id, String name, String address, String department, String experience, String contact, double fee, String status) {
    this.doctor_id = doctor_id;
    this.name = name;
    this.address = address;
    Department = department;
    Experience = experience;
    this.contact = contact;
    this.fee = fee;
    this.status = status;
  }

  public double getFee() {
    return fee;
  }

  public void setFee(double fee) {
    this.fee = fee;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public int getDoctor_id() {
    return doctor_id;
  }

  public void setDoctor_id(int doctor_id) {
    this.doctor_id = doctor_id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getDepartment() {
    return Department;
  }

  public void setDepartment(String department) {
    Department = department;
  }

  public String getExperience() {
    return Experience;
  }

  public void setExperience(String experience) {
    Experience = experience;
  }

  public String getContact() {
    return contact;
  }

  public void setContact(String contact) {
    this.contact = contact;
  }

  @Override
  public String toString() {
    return "Doctor{" +
      "doctor_id=" + doctor_id +
      ", name='" + name + '\'' +
      ", address='" + address + '\'' +
      ", Department='" + Department + '\'' +
      ", Experience='" + Experience + '\'' +
      ", contact='" + contact + '\'' +
      '}';
  }
}
