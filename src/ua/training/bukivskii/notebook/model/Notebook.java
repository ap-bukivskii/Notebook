package ua.training.bukivskii.notebook.model;

import java.util.ArrayList;

public class Notebook {
    private ArrayList<Abonent> abonents;
    private ArrayList<String> reservedLogins;

    public Notebook(){
        abonents = new ArrayList<>();
        reservedLogins = new ArrayList<>();
        reservedLogins.add("viktor");
        reservedLogins.add("hector");
        reservedLogins.add("tolik");
    }
    public void addAbonent(Abonent abonentToAdd) throws LoginAlreadyExistsException {
        if(getListOfAbonents().toString().contains(abonentToAdd.getNickName())){
           throw new LoginAlreadyExistsException(abonentToAdd) ;
        }
        if(reservedLogins.toString().contains(abonentToAdd.getNickName())){
            throw new LoginAlreadyExistsException(abonentToAdd) ;
        }

        abonents.add(new Abonent(abonentToAdd));
    }

    public Abonent getAbonentByLogin(String loginToFind) {
        for (Abonent ab:  abonents){
            if (ab.getNickName().equals(loginToFind)){
                return ab;
            }
        }
        return null;
    }
    public ArrayList<String> getListOfAbonents(){
        ArrayList<String> list = new ArrayList<>();
        for(Abonent ab:abonents){
            list.add(ab.getNickName());
        }
        return list;
    }
}
