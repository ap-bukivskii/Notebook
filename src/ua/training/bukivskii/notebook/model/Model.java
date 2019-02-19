package ua.training.bukivskii.notebook.model;

public class Model {
    private Notebook notebook;

    public Model(){
        notebook = new Notebook();
    }

    public Abonent getAbonentFromNotebook(String name) {
        return notebook.getAbonentByName(name);
    }

    public String addAbonentToNotebook(Abonent abonentToAdd) {
        this.notebook.addAbonent(abonentToAdd);
        return abonentToAdd.getShortName();
    }
}
