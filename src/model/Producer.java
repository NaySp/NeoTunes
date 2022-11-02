package model;

public abstract class Producer{

    String name;
    String date; //temporaly until i understand, maybe :x
    String url;

    int playBack; // accumulated reproduction
    int playTime; // total time played

    public Producer (String name, String date, String url, int playBack, int playTime){
        
        this.name = name;
        this.date = date;
        this.url = url;

        this.playBack = playBack;
        this.playTime = playTime;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }



    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }



    public int getPlayBack() {
        return playBack;
    }

    public void setPlayBack(int playBack) {
        this.playBack = playBack;
    }

    public int getPlayTime() {
        return playTime;
    }

    public void setPlayTime(int playTime) {
        this.playTime = playTime;
    }

}