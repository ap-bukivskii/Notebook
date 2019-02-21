package ua.training.bukivskii.notebook.model;

public class Model {
    private Notebook notebook;

    public Model(){
        notebook = new Notebook();
    }

    public Abonent getAbonentFromNotebook(String name) {
        return notebook.getAbonentByLogin(name);
    }

    public String addAbonentToNotebook(Abonent abonentToAdd) throws LoginAlreadyExistsException {
        this.notebook.addAbonent(abonentToAdd);
        return abonentToAdd.getNickName();
    }
}
