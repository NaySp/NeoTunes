package model;

public class Reproduction {

    private Audio audio;
    private int reproduction;

    public Reproduction(Audio audio) {
        this.audio = audio;
        reproduction = 0;
    }

    //** getters and setters */
    
    public void updateInfo(){
        reproduction++;
    }

    public Audio getAudio() {
        return audio;
    }

    public void setAudio(Audio audio) {
        this.audio = audio;
    }

    public int getPlayback() {
        return reproduction;
    }

    public void setPlayback(int reproduction) {
        this.reproduction = reproduction;
    }

}