package com.itza.calculadora.view;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private JTextField txtName;
    private JTextField txtGrade1;
    private JTextField txtGrade2;
    private JTextField txtGrade3;
    private JLabel lblResult;
    private JButton btnCalculate;
    private JButton btnClear;

    public MainFrame() {

        setTitle("Academic Average Calculator");
        setSize(350, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new GridLayout(7, 2, 5, 5));

        add(new JLabel("Student Name:"));
        txtName = new JTextField();
        add(txtName);

        add(new JLabel("Grade 1:"));
        txtGrade1 = new JTextField();
        add(txtGrade1);

        add(new JLabel("Grade 2:"));
        txtGrade2 = new JTextField();
        add(txtGrade2);

        add(new JLabel("Grade 3:"));
        txtGrade3 = new JTextField();
        add(txtGrade3);

        btnCalculate = new JButton("Calculate");
        btnClear = new JButton("Clear");

        add(btnCalculate);
        add(btnClear);

        add(new JLabel("Result:"));
        lblResult = new JLabel("");
        add(lblResult);
    }

    // ===== GETTERS =====
    public String getStudentName() {
        return txtName.getText().trim();
    }

    public double getGrade1() {
        return Double.parseDouble(txtGrade1.getText());
    }

    public double getGrade2() {
        return Double.parseDouble(txtGrade2.getText());
    }

    public double getGrade3() {
        return Double.parseDouble(txtGrade3.getText());
    }

    public JButton getBtnCalculate() {
        return btnCalculate;
    }

    public JButton getBtnClear() {
        return btnClear;
    }

    // ===== SETTERS =====
    public void setResult(String result) {
        lblResult.setText(result);
    }

    public void clearFields() {
        txtName.setText("");
        txtGrade1.setText("");
        txtGrade2.setText("");
        txtGrade3.setText("");
        lblResult.setText("");
    }
}
