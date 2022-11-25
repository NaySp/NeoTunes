package model;
import java.util.ArrayList;

public abstract class Customer extends User {

    String nickName;
    String cc;

    private ArrayList<PlayList> playlists;
    private ArrayList<Shop>shops;
    private ArrayList<Reproduction> reproductions;
    
    public Customer(String nickName, String cc){
        super();
        this.nickName = nickName;
        this.cc = cc;       
        playlists = new ArrayList<PlayList>();
        reproductions = new ArrayList<Reproduction>();
    }

    /**
     * Will help us to reproduce an audio
     * @param audio the audio
     * @return a message wit the status
     */
    public String playAudio(Audio audio) {
        
        String msj = "";
        msj += audio.plays();
        Reproduction obj = searchReproduction(audio.getAudioName());
        if (obj == null) {
            reproductions.add(new Reproduction(audio));
        } else {
            obj.updateInfo();
        }

        return msj;
    }

    public Reproduction searchReproduction(String name) {
        Reproduction obj = null;
        boolean search = false;
        for (int i = 0; i < reproductions.size() && !search; i++) {
            if (reproductions.get(i).getAudio().getAudioName().equalsIgnoreCase(name)) {
                obj = reproductions.get(i);
                search = true;
            }
        }
        return obj;
    }

    /**
     * Allows count per playback gender
     * @return the number of reproductions
     */
    public int[] playbackPerGender() {
        int[] playbacksG = new int[4];
        for (int i = 0; i < reproductions.size(); i++) {
            if (reproductions.get(i).getAudio() instanceof Song a) {
                switch (a.getGender()){
                    case 1:
                        playbacksG[0] += reproductions.get(i).getPlayback();
                        break;
                    case 2:
                        playbacksG[1] += reproductions.get(i).getPlayback();
                        break;
                    case 3:
                        playbacksG[2] += reproductions.get(i).getPlayback();
                        break;
                    case 4:
                        playbacksG[3] += reproductions.get(i).getPlayback();
                        break;
                    default:
                        break;
                }
            }
        }
        return playbacksG;
    }

    
    /**
     * Allows show most heared
     * @return the message
     */
    public String mostHearedGender() {

        String msj = "";
        int[] genres = playbackPerGender();
        int max = 0;
        int pos = -1;
        for (int i = 0; i < genres.length; i++) {
            if (genres[i] > max) {
                max = genres[i];
                pos = i;
            }
        }
        switch (pos) {
            case 0:msj = "The most heared genre is: Pop, with " + max + " plays.";
                break;
            case 1:msj = "The most heared genre is: Rock, with " + max + " plays.";
                break;
            case 2:msj = "The most heared genre is: trap, with " + max + " plays.";
                break;
            case 3:msj = "The most heared genre is: house, with " + max + " plays.";
                break;
            default:
                msj = "no songs have been played.";
                break;
        }
        return msj;
    }

 
    /**
     * Allows show most heared category
     * @return a message
     */
    public String mostHearedCategory() {

        String msj = "";
        int[] category = playbackPerCategory();
        int max = 0;
        int pos = -1;
        for (int i = 0; i < category.length; i++) {
            if (category[i] > max) {
                max = category[i];
                pos = i;
            }
        }
        switch (pos) {
            case 0:
                msj = "The most heared genre is: Politic, with " + max + " plays.";
                break;
            case 1:
                msj = "The most heared genre is: Entertainment, with " + max + " plays.";
                break;
            case 2:
                msj = "The most heared genre is: Videogames, with " + max + " plays.";
                break;
            case 3:
                msj = "The most heared genre is: Fashion, with " + max + " plays.";
                break;
            default:
                msj = "non podcast's have been played.";
                break;
        }
        return msj;
    }


    /**
     * Allows coutn play back per category
     * @return the number of play back
     */
    public int[] playbackPerCategory(){

        int[] playbacksC = new int[4];

        for (int i = 0; i < reproductions.size(); i++) {

            if (reproductions.get(i).getAudio() instanceof PodCast) {

                PodCast p = (PodCast) reproductions.get(i).getAudio();

                switch (p.getCategory()) {
                    case 1:
                        playbacksC[0] += reproductions.get(i).getPlayback();
                        break;
                    case 2:
                        playbacksC[1] += reproductions.get(i).getPlayback();
                        break;
                    case 3:
                        playbacksC[2] += reproductions.get(i).getPlayback();
                        break;
                    case 4:
                        playbacksC[3] += reproductions.get(i).getPlayback();
                        break;
                    default:
                        break;
                }
            }
        }
        return playbacksC;
    }

    //**Getters and setters */

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }
    
    public ArrayList<PlayList> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(ArrayList<PlayList> playlists) {
        this.playlists = playlists;
    }

    public ArrayList<Shop> getShops() {
        return shops;
    }

    public void setShops(ArrayList<Shop> shops) {
        this.shops = shops;
    }

    //**Methods that will heredate the son class */

    public abstract String addPlayList(String nickName);

    public abstract String addAudioPlayList(String nickName, Audio audio);

    public abstract String removeAudioPlayList(String nickName, Audio audio);

    public abstract String editPlaylist(String name, String changeName);


    

}