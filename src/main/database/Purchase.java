package main.database;

public class Purchase {
    private String Name;
    private String Surname;
    private String Date;
    private String Remarks;

    public Purchase(String name, String surname, String date, String remarks) {
        Name = name;
        Surname = surname;
        Date = date;
        Remarks = remarks;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getRemarks() {
        return Remarks;
    }

    public void setRemarks(String remarks) {
        Remarks = remarks;
    }

    @Override
    public String toString() {
        return "Purchase{ " +
                "Name='" + Name + '\'' +
                ", Surname='" + Surname + '\'' +
                ", Date='" + Date + '\'' +
                ", Remarks='" + Remarks + '\'' +
                " }";
    }
}
