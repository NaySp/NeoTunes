package model;
import java.util.ArrayList;

public class Influencer extends Producer {

    private ArrayList<PodCast> podcasts;
   
    public Influencer (String name, String url, int playBack, int playTime){
       super(name, url, playBack, playTime);
       podcasts = new ArrayList<PodCast>();
    }

    public ArrayList<PodCast> getPodcasts() {
        return podcasts;
    }

    public void setPodcasts(ArrayList<PodCast> podcasts) {
        this.podcasts = podcasts;
    }
    
}