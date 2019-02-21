package ua.training.bukivskii.notebook.controller;
import ua.training.bukivskii.notebook.model.Model;
import ua.training.bukivskii.notebook.view.Messages;
import ua.training.bukivskii.notebook.view.View;

import java.util.Scanner;

public class Controller {
    private Model model;
    private View view;
    private UtilController uContr;
    private Scanner scan;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        this.scan = new Scanner(System.in);
        uContr = new UtilController(model,view,scan);
    }

    public void process(){
        view.printConcatedMessage(view.concatString(Messages.ADDED_ABONENT_NAME), uContr.addNewAbonent());
        view.printMessage(view.unwrapBundled(Messages.ASK_FOR_NAME_TO_PRINT));
        view.printAbonent(model.getAbonentFromNotebook(uContr.inputValidString(Messages.NICKNAME,Regexps.nickNameRegexp)));
    }
}
