package ua.training.bukivskii.notebook.controller;

import ua.training.bukivskii.notebook.model.Abonent;
import ua.training.bukivskii.notebook.model.Groups;
import ua.training.bukivskii.notebook.model.LoginAlreadyExistsException;
import ua.training.bukivskii.notebook.model.Model;
import ua.training.bukivskii.notebook.view.Messages;
import ua.training.bukivskii.notebook.view.View;

import java.util.Scanner;

public class UtilController {
    private Model model;
    private View view;
    private Scanner scanner;

    public UtilController(Model model, View view, Scanner scanner) {
        this.scanner = scanner;
        this.model = model;
        this.view = view;
    }

    public String inputValidString(String field, String regexp){
        String res;
        view.askForInput(field);
        while (! (scanner.hasNextLine()&&(res = scanner.nextLine().trim()).matches(regexp))){
            view.printErrorMessage(field);
        }
        return res;
    }

    private void addGroups(String groupsToAdd,Abonent abonent){
        for(Groups gr: Groups.values()) {

            if (groupsToAdd.contains(gr.getName()) || groupsToAdd.contains(Integer.toString(gr.getGroupID()))) {
                abonent.addGroup(gr);
            }
        }
    }
    public String addNewAbonent() {
        Abonent abToAdd = createAbonent();
        while(true) {
            try {
                return model.addAbonentToNotebook(abToAdd);
            } catch (LoginAlreadyExistsException loginExists) {
                view.printMessage(String.format(view.unwrapBundled(Messages.LOGIN_EXISTS_ERROR), loginExists.getLogin()));
                abToAdd = loginExists.getAbonentCaused();
                changeLogin(abToAdd);
            }
        }
    }

    private void changeLogin(Abonent ab) {
        ab.setNickName(inputValidString(Messages.NICKNAME,Regexps.nickNameRegexp));
    }

    public Abonent createAbonent(){
        Abonent tempAbonent = new Abonent();

        tempAbonent.setFirstName(inputValidString(Messages.FIRST_NAME,Regexps.firstNameRegexp));
        tempAbonent.setLastName(inputValidString(Messages.LAST_NAME,Regexps.lastNameRegexp));
        tempAbonent.setMiddleName(inputValidString(Messages.MIDDLE_NAME,Regexps.middleNameRegexp));

        tempAbonent.generateShortName();

        tempAbonent.setNickName(inputValidString(Messages.NICKNAME,Regexps.nickNameRegexp));
        tempAbonent.setComment(inputValidString(Messages.COMMENT,Regexps.commentRegexp));

        addGroups(inputValidString(Messages.INPUT_GROUPS,Regexps.groupsRegexp), tempAbonent);

        tempAbonent.setHomePhoneNumber(inputValidString(Messages.HOME_PHONE,Regexps.homePhoneNumberRegexp));
        tempAbonent.setCellPhoneNumber(inputValidString(Messages.CELL_PHONE,Regexps.cellPhoneNumberRegexp));
        tempAbonent.setCellPhoneNumber2(inputValidString(Messages.CELL_PHONE2,Regexps.cellPhoneNumber2Regexp));
        tempAbonent.setEmail(inputValidString(Messages.EMAIL,Regexps.emailRegexp));
        tempAbonent.setSkypeName(inputValidString(Messages.SKYPE_NAME,Regexps.skypeNameRegexp));
        tempAbonent.setIndex(inputValidString(Messages.INDEX,Regexps.indexRegexp));
        tempAbonent.setCity(inputValidString(Messages.CITY,Regexps.cityRegexp));
        tempAbonent.setStreet(inputValidString(Messages.STREET,Regexps.streetRegexp));
        tempAbonent.setHouse(inputValidString(Messages.HOUSE,Regexps.houseRegexp));
        tempAbonent.setAppartment(inputValidString(Messages.APPARTMENT,Regexps.appartmentRegexp));
        tempAbonent.generateAdressLong();

        return tempAbonent;
    }

}
