package model;

public abstract class Customer {

    String nickName;
    String cc;
    String tempDate;

    public Customer(String nickName, String cc, String tempDate){
        this.nickName = nickName;
        this.cc = cc;
        this.tempDate = tempDate;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getTempDate() {
        return tempDate;
    }

    public void setTempDate(String tempDate) {
        this.tempDate = tempDate;
    }
    
}