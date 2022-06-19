package com.hospital.api.model;

public class PatientHistory {

  private int pHistory_id;
  private int patientID;
  private double totalAmount;
  private double bill;
  private int NumberOfVisit;

  public PatientHistory() {
  }

  public PatientHistory(int patientID, double totalAmount, double bill, int numberOfVisit) {
    this.patientID = patientID;
    this.totalAmount = totalAmount;
    this.bill = bill;
    NumberOfVisit = numberOfVisit;
  }

  public PatientHistory(int pHistory_id, int patientID, double totalAmount, double bill, int numberOfVisit) {
    this.pHistory_id = pHistory_id;
    this.patientID = patientID;
    this.totalAmount = totalAmount;
    this.bill = bill;
    NumberOfVisit = numberOfVisit;
  }

  public int getpHistory_id() {
    return pHistory_id;
  }

  public void setpHistory_id(int pHistory_id) {
    this.pHistory_id = pHistory_id;
  }

  public int getPatientID() {
    return patientID;
  }

  public void setPatientID(int patientID) {
    this.patientID = patientID;
  }

  public double getTotalAmount() {
    return totalAmount;
  }

  public void setTotalAmount(double totalAmount) {
    this.totalAmount = totalAmount;
  }

  public double getBill() {
    return bill;
  }

  public void setBill(double bill) {
    this.bill = bill;
  }

  public int getNumberOfVisit() {
    return NumberOfVisit;
  }

  public void setNumberOfVisit(int numberOfVisit) {
    NumberOfVisit = numberOfVisit;
  }

  @Override
  public String toString() {
    return "PatientHistory{" +
            "pHistory_id=" + pHistory_id +
            ", patientID=" + patientID +
            ", totalAmount=" + totalAmount +
            ", bill=" + bill +
            ", NumberOfVisit=" + NumberOfVisit +
            '}';
  }
}
