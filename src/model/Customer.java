package model;

public abstract class Customer extends User {

    String nickName;
    String cc;
    

    public Customer(String nickName, String cc){
        super();
        this.nickName = nickName;
        this.cc = cc;       
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
}