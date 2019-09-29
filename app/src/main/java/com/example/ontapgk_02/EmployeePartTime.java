package com.example.ontapgk_02;

public class EmployeePartTime extends Employeee {
    @Override
    public double TinhLuong() {
        return 150;
    }

    @Override
    public String toString() {
        return super.toString() + " --> PartTime = " + TinhLuong();
    }
}
