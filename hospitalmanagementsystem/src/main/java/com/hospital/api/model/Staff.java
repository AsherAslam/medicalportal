package com.hospital.api.model;

public class Staff {

  private int staff_id;
  private String name;
  private String address;
  private String designation;
  private int salary;
  private String contact;

  public Staff() {
  }

  public Staff(int staff_id, String name, String address, String designation, int salary, String contact) {
    this.staff_id = staff_id;
    this.name = name;
    this.address = address;
    this.designation = designation;
    this.salary = salary;
    this.contact = contact;
  }

  public Staff(String name, String address, String designation, int salary, String contact) {
    this.name = name;
    this.address = address;
    this.designation = designation;
    this.salary = salary;
    this.contact = contact;
  }

  public int getStaff_id() {
    return staff_id;
  }

  public void setStaff_id(int staff_id) {
    this.staff_id = staff_id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDesignation() {
    return designation;
  }

  public void setDesignation(String designation) {
    this.designation = designation;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public int getSalary() {
    return salary;
  }

  public void setSalary(int salary) {
    this.salary = salary;
  }

  public String getContact() {
    return contact;
  }

  public void setContact(String contact) {
    this.contact = contact;
  }

  @Override
  public String toString() {
    return "Staff{" +
      "staff_id=" + staff_id +
      ", name='" + name + '\'' +
      ", designation='" + designation + '\'' +
      ", address='" + address + '\'' +
      ", salary=" + salary +
      ", contact='" + contact + '\'' +
      '}';
  }
}
