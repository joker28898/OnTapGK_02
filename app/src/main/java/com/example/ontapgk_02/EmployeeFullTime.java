package com.example.ontapgk_02;

public class EmployeeFullTime extends Employeee {

    @Override
    public double TinhLuong() {
        return 500;
    }

    @Override
    public String toString() {
        return super.toString() + " --> FullTime = " + TinhLuong();
    }
}
