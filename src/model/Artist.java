package model;
import java.util.ArrayList;

public class Artist extends Producer {

    private ArrayList<Song> songs;

 
    public Artist (String name, String url, int playBack, int playTime){
        super(name, url, playBack, playTime);
        songs = new ArrayList<Song>();
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }


    public void setSongs(ArrayList<Song> songs) {
        this.songs = songs;
    }
       
    
}