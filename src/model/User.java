package model;
import java.time.LocalDate;


public abstract class User{

    private LocalDate date;

    public User(){
        this.date = LocalDate.now();
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    
}