package ua.training.bukivskii.notebook.model;

import java.util.ArrayList;

public class Notebook {
    private ArrayList<Abonent> abonents = new ArrayList<>();
    private int abonentsQuantity;

    public Notebook(){
        abonentsQuantity = 0;
    }
    public void addAbonent(Abonent abonentToAdd){
        abonents.add(new Abonent(abonentToAdd));
        abonentsQuantity = abonents.size();
    }

    public Abonent getAbonentByName(String nameToFind) {
        for (Abonent ab:  abonents){
            if (ab.getShortName().equals(nameToFind)){
                return ab;
            }
        }
        return null;
    }
}
