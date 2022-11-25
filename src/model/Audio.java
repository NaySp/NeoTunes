package model;

public abstract class Audio implements Playable{

    private String audioName; // song or podcast has name
    private String urlAudio; // both have an image
    private double duration; // how long is the song or podcast
    private int repNum; // both haver reprodution number
    private Producer autor;
    


    public Audio(String audioName, String urlAudio, double duration, Producer autor){
        this.audioName = audioName;
        this.urlAudio = urlAudio;
        this.duration = duration;
        this.autor = (Producer) autor;

        repNum = 0;
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


    public Audio(String audioName) {
        this.audioName = audioName;
    }


    public Producer getArtis() {
        return autor;
    }


    public void setAutor(Producer artist) {
        this.autor = (Producer) artist;
    }

    @Override
    public String plays(){
        repNum+=1;
        autor.setPlayBack(autor.getPlayBack() + 1);
        return "The audio " + getAudioName() + " is playing";
    }

    
}