package com.itza.calculadora.model;

public class GradeManager implements ICalculable {

    @Override
    public double calculateAverage(double n1, double n2, double n3) {
        return (n1 + n2 + n3) / 3;
    }

    @Override
    public String determineStatus(double average) {
        return average >= 7.0 ? "Approved" : "Failed";
    }
}
