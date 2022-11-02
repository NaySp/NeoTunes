package model;

public class Song {

    String songName;
    String album;
    String urlSong;


    double saleValue; //precio de venta 
    int numPlay;  //numero de reproducciones
    int timeSold; //numero de veces vendido

    public Song(String songName, String album, String urlSong, double saleValue, int numPlay, int timeSold){

        this.songName = songName;
        this.album = album;
        this.urlSong = urlSong;

        this.saleValue = saleValue;

        this.numPlay = numPlay;
        this.timeSold = timeSold;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getUrlSong() {
        return urlSong;
    }

    public void setUrlSong(String urlSong) {
        this.urlSong = urlSong;
    }

    public double getSaleValue() {
        return saleValue;
    }

    public void setSaleValue(double saleValue) {
        this.saleValue = saleValue;
    }

    public int getNumPlay() {
        return numPlay;
    }

    public void setNumPlay(int numPlay) {
        this.numPlay = numPlay;
    }

    public int getTimeSold() {
        return timeSold;
    }

    public void setTimeSold(int timeSold) {
        this.timeSold = timeSold;
    }


}