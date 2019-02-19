package ua.training.bukivskii.notebook.model;

import ua.training.bukivskii.notebook.view.Messages;

import java.util.*;

public class Abonent {
    private String firstName;
    private String lastName;
    private String middleName;
    private String shortName;
    private String nickName;
    private String comment;
    private ArrayList<Groups> groups;
    private String homePhoneNumber;
    private String cellPhoneNumber;
    private String cellPhoneNumber2;
    private String email;
    private String skypeName;
    private String index;
    private String city;
    private String street;
    private String house;
    private String appartment;
    private String adressLong;
    private Date dateOfCreation;
    private Date lastChanged;

    public Abonent(){
        this.setDateOfCreation();
        this.updateLastChanged();
        groups = new ArrayList<>();
    }

    public Abonent(Abonent ab){
        this.firstName = ab.getFirstName();
        this.lastName = ab.getLastName();
        this.middleName = ab.getMiddleName();
        this.shortName = ab.getShortName();
        this.nickName = ab.getNickName();
        this.comment = ab.getComment();
        this.groups = new ArrayList<>();
        this.groups = ab.getGroups();
        this.homePhoneNumber = ab.getHomePhoneNumber();
        this.cellPhoneNumber = ab.getCellPhoneNumber();
        this.cellPhoneNumber2 = ab.getCellPhoneNumber2();
        this.email = ab.getEmail();
        this.skypeName = ab.getSkypeName();
        this.index = ab.getIndex();
        this.city = ab.getCity();
        this.street = ab.getStreet();
        this.house = ab.getHouse();
        this.appartment = ab.getAppartment();
        this.adressLong = ab.getAdressLong();
        this.dateOfCreation = ab.getDateOfCreation();
        this.updateLastChanged();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        this.updateLastChanged();
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        this.updateLastChanged();
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
        this.updateLastChanged();
    }

    public String getShortName() {
        return shortName;
    }

    public void generateShortName() {
        StringBuilder sn = new StringBuilder();
        sn = sn.append(lastName).append(" ").append(firstName.charAt(0)).append(".");
        this.shortName = new String(sn);
        this.updateLastChanged();
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
        this.updateLastChanged();
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
        this.updateLastChanged();
    }

    public ArrayList<Groups> getGroups() {
        return groups;
    }

    public void addGroup(Groups group) {
        this.groups.add(group);
    }

    public String getHomePhoneNumber() {
        return homePhoneNumber;
    }

    public void setHomePhoneNumber(String homePhoneNumber) {
        this.homePhoneNumber = homePhoneNumber;
        this.updateLastChanged();
    }

    public String getCellPhoneNumber() {
        return cellPhoneNumber;
    }

    public void setCellPhoneNumber(String cellPhoneNumber) {
        this.cellPhoneNumber = cellPhoneNumber;
        this.updateLastChanged();
    }

    public String getCellPhoneNumber2() {
        return cellPhoneNumber2;
    }

    public void setCellPhoneNumber2(String cellPhoneNumber2) {
        this.cellPhoneNumber2 = cellPhoneNumber2;
        this.updateLastChanged();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        this.updateLastChanged();
    }

    public String getSkypeName() {
        return skypeName;
    }

    public void setSkypeName(String skypeName) {
        this.skypeName = skypeName;
        this.updateLastChanged();
    }

    public String getAdressLong() {
        return adressLong;
    }

    public void generateAdressLong() { // TODO something does not feel right
        StringBuilder adr = new StringBuilder();
        adr = adr.append(index).append(", ");
        adr = adr.append(city).append(", ");
        adr = adr.append(street).append(", ");
        if(appartment.equals("")){
            adr = adr.append(house).append(".");
        }
        else {
            adr = adr.append(house).append(", ");
            adr = adr.append(appartment).append(".");
        }
        this.adressLong = new String(adr);
        this.updateLastChanged();
    }

    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    private void setDateOfCreation() {
        this.dateOfCreation = new Date();
    }

    public Date getLastChanged() {
        return lastChanged;
    }

    private void updateLastChanged() {
        this.lastChanged = new Date();
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
        this.updateLastChanged();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
        this.updateLastChanged();
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
        this.updateLastChanged();
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
        this.updateLastChanged();
    }

    public String getAppartment() {
        return appartment;
    }

    public void setAppartment(String appartment) {
        this.appartment = appartment;
        this.updateLastChanged();
    }

    @Override
    public String toString(){
        StringBuilder tmp = new StringBuilder();
        tmp.append("+++").append(this.getShortName()).append("+++\n");
        tmp.append("First name: ").append(this.getFirstName()).append("\n"); //TODO can we use bundle here?
        tmp.append("Last name: ").append(this.getLastName()).append("\n");
        tmp.append("Middle name: ").append( this.getMiddleName()).append("\n");
        tmp.append("Nickname: ").append( this.getNickName()).append("\n");
        tmp.append("Comment: ").append( this.getComment()).append("\n");

        tmp.append("Group(s): ");
        for(Groups g: this.getGroups()) {
            tmp.append(g.name).append(" ");
        }
        tmp.append("\n");

        tmp.append("Homephone: ").append( this.getHomePhoneNumber()).append("\n");
        tmp.append("Cell phone: ").append( this.getCellPhoneNumber()).append("\n");
        tmp.append("Additional cell phone: ").append( this.getCellPhoneNumber2()).append("\n");
        tmp.append("E-mail: ").append( this.getEmail()).append("\n");
        tmp.append("Skype name: ").append( this.getSkypeName()).append("\n");
        tmp.append("Address: ").append( this.getAdressLong()).append("\n");

        tmp.append("Created on: ").append( this.getDateOfCreation()).append("\n");
        tmp.append("Last changed on: ").append( this.getLastChanged()).append("\n");

        return new String(tmp);
    }

}
