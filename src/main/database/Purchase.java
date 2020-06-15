package main.database;

import javafx.beans.property.SimpleStringProperty;

/**
 * Model Object for the
 */
public class Purchase {
    private SimpleStringProperty Name;
    private SimpleStringProperty Surname;
    private SimpleStringProperty Date;
    private SimpleStringProperty Remarks;
    private SimpleStringProperty type;

    public Purchase(String name, String surname, String date, String remarks, String type) {
        this.Name = new SimpleStringProperty(name);
        this.Surname = new SimpleStringProperty(surname);
        this.Date = new SimpleStringProperty(date);
        this.Remarks = new SimpleStringProperty(remarks);
        this.type = new SimpleStringProperty(type);
    }

    public String getName() {
        return Name.get();
    }

    public void setName(String name) {
        Name.set(name);
    }

    public String getSurname() {
        return Surname.get();
    }

    public void setSurname(String surname) {
        Surname.set(surname);
    }

    public String getDate() {
        return Date.get();
    }

    public void setDate(String date) {
        Date.set(date);
    }

    public String getRemarks() {
        return Remarks.get();
    }

    public void setRemarks(String remarks) {
        Remarks.set(remarks);
    }

    public String getType() {
        return type.get();
    }

    public void setType(String type) {
        this.type.set(type);
    }

    @Override
    public String toString() {
        return "Purchase{ " +
                "Name='" + Name + '\'' +
                ", Surname='" + Surname + '\'' +
                ", Date='" + Date + '\'' +
                ", Remarks='" + Remarks + '\'' +
                ", Type='" + type + '\'' +
                " }";
    }
}
