package com.itza.calculadora.model;

public interface ICalculable {

    double calculateAverage(double n1, double n2, double n3);

    String determineStatus(double average);
}
