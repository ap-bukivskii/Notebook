package ua.training.bukivskii.notebook;

import ua.training.bukivskii.notebook.controller.Controller;
import ua.training.bukivskii.notebook.model.Model;
import ua.training.bukivskii.notebook.view.View;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Model model = new Model();
        View viev   = new View();
        Controller controller = new Controller(model, viev);
        controller.process();
    }
}
