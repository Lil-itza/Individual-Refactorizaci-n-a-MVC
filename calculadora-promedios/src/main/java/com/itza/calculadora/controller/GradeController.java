package com.itza.calculadora.controller;

import com.itza.calculadora.model.ICalculable;
import com.itza.calculadora.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GradeController implements ActionListener {

    private ICalculable model;
    private MainFrame view;

    public GradeController(ICalculable model, MainFrame view) {
        this.model = model;
        this.view = view;

        this.view.getBtnCalculate().addActionListener(this);
        this.view.getBtnClear().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // BOTÓN CALCULAR
        if (e.getSource() == view.getBtnCalculate()) {
            try {
                // Validación del nombre
                String name = view.getStudentName();
                if (name.isEmpty()) {
                    JOptionPane.showMessageDialog(
                            view,
                            "Student name is required",
                            "Validation error",
                            JOptionPane.WARNING_MESSAGE
                    );
                    return;
                }

                // Obtener notas
                double n1 = view.getGrade1();
                double n2 = view.getGrade2();
                double n3 = view.getGrade3();

                // Validación de rango
                if (!isValidGrade(n1) || !isValidGrade(n2) || !isValidGrade(n3)) {
                    JOptionPane.showMessageDialog(
                            view,
                            "Grades must be between 0 and 10",
                            "Validation error",
                            JOptionPane.WARNING_MESSAGE
                    );
                    return;
                }

                // Lógica de negocio
                double average = model.calculateAverage(n1, n2, n3);
                String status = model.determineStatus(average);

                // Mostrar resultado
                view.setResult(String.format(
                        "%s → %.2f (%s)",
                        name,
                        average,
                        status
                ));

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(
                        view,
                        "Please enter valid numeric grades",
                        "Input error",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }

        // BOTÓN LIMPIAR
        if (e.getSource() == view.getBtnClear()) {
            view.clearFields();
        }
    }

    // Metodo privado de validación
    private boolean isValidGrade(double grade) {
        return grade >= 0 && grade <= 10;
    }
}
