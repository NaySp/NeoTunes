package model;

public abstract class Audio {

    private String audioName; // song or podcast has name
    private String urlAudio; // both have an image
    private double duration; // how long is the song or podcast
    private int repNum; // both haver reprodution number

    public Audio(String audioName, String urlAudio, double duration, int repNum){
        this.audioName = audioName;
        this.urlAudio = urlAudio;
        this.duration = duration;
        this.repNum = repNum;
    }

    public String getAudioName() {
        return audioName;
    }

    public void setAudioName(String audioName) {
        this.audioName = audioName;
    }

    public String getUrlAudio() {
        return urlAudio;
    }

    public void setUrlAudio(String urlAudio) {
        this.urlAudio = urlAudio;
    }
    
    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public int getRepNum() {
        return repNum;
    }

    public void setRepNum(int repNum) {
        this.repNum = repNum;
    }


}