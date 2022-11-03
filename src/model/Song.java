package model;

public class Song extends Audio {

    private String album;

    private double saleValue; //precio de venta 
    private int soldNum; //numero de veces vendido

    private Gender gender;

    public Song(String audioName, String urlAudio, double duration, int repNum, String album, double saleValue, int soldNum, int gender){
        super(audioName, urlAudio, duration, repNum);
        this.album = album;
        this.saleValue = saleValue;
        this.soldNum = soldNum;
        
        switch(gender){
            case 1:
                this.gender = Gender.ROCK;
                break;
            case 2:
                this.gender = Gender.POP;
                break;
            case 3:
                this.gender = Gender.TRAP;
                break;
            case 4: 
                this.gender = Gender.HOUSE;
                break;
        }

    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public double getSaleValue() {
        return saleValue;
    }

    public void setSaleValue(double saleValue) {
        this.saleValue = saleValue;
    }

    public int getSoldNum() {
        return soldNum;
    }

    public void setSoldNum(int soldNum) {
        this.soldNum = soldNum;
    }

    public int getGender(){
        switch(gender){
            case ROCK:
                return 1;
            case POP:
                return 2;
            case TRAP:
                return 3;
            case HOUSE:
                return 4;
            default:
                return 0;
        }
    }




}