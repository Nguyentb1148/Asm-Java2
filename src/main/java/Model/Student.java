package Model;

import java.util.Date;

public  class Student {
    protected String name;
    protected String idPerson;
    protected Date birthday;
    protected String email;
    protected String phoneNumber;
    protected boolean sex;
    protected String address;



    public Student(String name, String idPerson, Date birthday, String email, String phoneNumber, boolean sex, String address){
        this.address=address;
        this.idPerson=idPerson;
        this.name=name;
        this.birthday=birthday;
        this.email=email;
        this.phoneNumber=phoneNumber;
        this.sex=sex;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getIdPerson() {
        return idPerson;
    }
    public void setIdPerson(String idPerson) {
        this.idPerson = idPerson;
    }
    public Date getBirthday() {
        return birthday;
    }
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public boolean getSex() {
        return sex;
    }
    public void setSex(boolean sex) {
        this.sex = sex;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public void display() {
        System.out.println(name+" "+idPerson+" "+birthday+" " +email+" 0"+phoneNumber+" "+sex+" "+address);
    }
}