package model;

public class Song extends Audio implements iSellable {

    private String album;
    private double saleValue; //precio de venta 
    private int soldNum; //numero de veces vendido

    private Gender gender;

    public Song(String audioName, String urlAudio, Producer artist, double duration, String album, double saleValue, int gender){
        super(audioName, urlAudio, duration, artist);
        this.album = album;
        this.saleValue = saleValue;
        soldNum = 0;
        
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

    @Override
    public String sell(){
        soldNum++;
        super.getArtis().updateSoldInfo(super.getDuration());
        return "The song " + getAudioName() + " has been sold... ";
        
    }

    public double totalSell(){
        double totalSells= saleValue*soldNum;
        return totalSells;
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