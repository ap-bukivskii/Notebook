package ua.training.bukivskii.notebook.view;

import ua.training.bukivskii.notebook.model.Abonent;
import ua.training.bukivskii.notebook.model.Groups;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class View {
    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printErrorMessage(String field){
        printConcatedMessage(Messages.INPUT_ERROR, field);
    }

    Locale locale = new Locale("ua");
    static String MESSAGES_BUNDLE = "ua\\training\\bukivskii\\notebook\\Messages";

    ResourceBundle messagesBundle = ResourceBundle.getBundle(MESSAGES_BUNDLE, locale);

    //@Deprecated //because is stupid
                //seems not so stupid because we cant use unwrapper in abonent entity
    public void printAbonent(Abonent abonent){
        String tmpGroups = new String("no groups");
        printConcatedMessage("+++",abonent.getShortName(),"+++");
        printConcatedMessage(Messages.FIRST_NAME, ": ", abonent.getFirstName());
        printConcatedMessage(Messages.LAST_NAME, ": ", abonent.getLastName());
        printConcatedMessage(Messages.MIDDLE_NAME, ": ", abonent.getMiddleName());
        printConcatedMessage(Messages.NICKNAME, ": ", abonent.getNickName());
        printConcatedMessage(Messages.COMMENT, ": ", abonent.getComment());

        printMessage(unwrapBundled(Messages.OUTPUT_GROUPS));
        for(Groups g: abonent.getGroups()) {
            tmpGroups = concatString(g.name," ");
        }
        printMessage(tmpGroups);

        printConcatedMessage(Messages.HOME_PHONE, ": ", abonent.getHomePhoneNumber());
        printConcatedMessage(Messages.CELL_PHONE, ": ", abonent.getCellPhoneNumber());
        printConcatedMessage(Messages.CELL_PHONE2, ": ", abonent.getCellPhoneNumber2());
        printConcatedMessage(Messages.EMAIL, ": ", abonent.getEmail());
        printConcatedMessage(Messages.SKYPE_NAME, ": ", abonent.getSkypeName());
        printConcatedMessage(Messages.ADRESS, ": ", abonent.getAdressLong());

        printConcatedMessage(Messages.CREATED, ": ", abonent.getDateOfCreation().toString());
        printConcatedMessage(Messages.LAST_CHANGED, ": ", abonent.getLastChanged().toString());


    }

    public String concatString(String... message){
        StringBuilder concatString = new StringBuilder();
        for (String v : message){
            concatString = concatString.append(unwrapBundled(v));
        }
        return new String(concatString);
    }

    public String unwrapBundled(String message){
        try{
            return messagesBundle.getString(message);
        }catch (MissingResourceException e){
            return message;
        }
    }

    public void printConcatedMessage(String... message){
        printMessage(concatString(message));
    }

    public void askForInput(String field) {
        printConcatedMessage(Messages.ASK_FOR_INPUT , field);
    }
}
