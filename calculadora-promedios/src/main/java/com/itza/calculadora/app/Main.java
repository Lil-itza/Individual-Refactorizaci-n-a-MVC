package com.itza.calculadora.app;

import com.itza.calculadora.controller.GradeController;
import com.itza.calculadora.model.GradeManager;
import com.itza.calculadora.view.MainFrame;

public class Main {

    public static void main(String[] args) {

        // Instanciar MVC
        GradeManager model = new GradeManager();
        MainFrame view = new MainFrame();
        new GradeController(model, view);

        // Mostrar la interfaz
        view.setVisible(true);
    }
}
