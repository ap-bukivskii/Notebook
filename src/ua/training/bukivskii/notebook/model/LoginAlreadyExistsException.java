package ua.training.bukivskii.notebook.model;

public class LoginAlreadyExistsException extends Exception  {
    Abonent ab;

    LoginAlreadyExistsException (Abonent ab){
        this.ab = ab;
    }

    public String getLogin() {
        return ab.getNickName();
    }

    public Abonent getAbonentCaused(){
        return ab;
    }
}
