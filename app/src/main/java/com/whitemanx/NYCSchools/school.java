package com.whitemanx.NYCSchools;

public class school {
    //will be to make new accounts
    protected String name;



    protected String numStudents;
    protected String phone;
    protected String website;
    protected String city;
    protected int index;
    //scores
    protected String math;


    protected String critical;
    protected String verbal;



    //default constructor
  public  school(){
        name = "UNKOWN";
        numStudents = "UNKOWN";
        phone = "UNKOWN";
        website = "UNKOWN";
        city = "UNKOWN";
        math = "UNKOWN";
        critical =  "UNKOWN";
        verbal=  "UNKOWN";

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    protected String email;

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }




    // Setter for the name
    public void setName(String newName) {
        this.name = newName;
    }

    // Getter for the name
    public String getName() {
        return this.name;
    }



    public String getMath() {
        return math;
    }

    public void setMath(String math) {
        this.math = math;
    }

    public String getCritical() {
        return critical;
    }

    public void setCritical(String critical) {
        this.critical = critical;
    }

    public String getVerbal() {
        return verbal;
    }

    public void setVerbal(String verbal) {
        this.verbal = verbal;
    }
    // Setter for the phone
    public void setPhone(String newPhone) {
        this.phone = newPhone ;
    }

    // Getter for the name
    public String getPhone() {
        return this.phone;
    }

    // Setter for the phone
    public void setCity(String newCity) {
        this.city = newCity ;
    }

    // Getter for the name
    public String getCity() {
        return this.city;
    }
    public String getNumStudents() {
        return numStudents;
    }

    public void setNumStudents(String numStudents) {
        this.numStudents = numStudents;
    }

}
