package model;
import java.util.ArrayList;

public class Standard extends Customer {

    public static final int SIZE_AUDIOS = 100;
    public static final int SIZE_PLAYLISTS = 20;
    

    public Standard (String nickName, String cc){
        super(nickName, cc);
        
        
    }


    @Override
    public String addPlayList(String nickName){
        String msj = "Play list added succesfully. ";
        PlayList obj = searchPlayList(nickName);
        boolean space = isAvailable();

        if(obj == null){
            if(space){
                for (int i = 0; i < super.getPlaylists().size() && obj == null; i++) {
                    if (super.getPlaylists().get(i) == null) {
                        super.getPlaylists().add(new PlayList(nickName));
                        obj = super.getPlaylists().get(i);
                    }
                }
            } else {
                msj = "The user can not add more playlists, pay premium if u want more ;)";
            }
        } else {
            msj = "The playlis already exists. ";
        }
        return msj;
    }

    @Override
    public String addAudioPlayList(String name, Audio audio){
       
        String msj = "The audio was added succesfully";
        PlayList obj = searchPlayList(name);
        if (obj != null) {
            msj = obj.addAudio(audio);
        } else {
            msj = "The playlist does not exist";
        }

        return msj;
    }


    public String addAudio(Audio audio) {

        String msj = "";
        Shop obj = searchAudio(audio.getAudioName());

        boolean available = songExits();
        if (obj == null) {
            if (available) {

                if (audio instanceof Song) {
                    Song s = (Song) audio;
                    msj += s.sell();
                    super.getShops().add(new Shop(s));

                } else {
                    msj = "The audio is not a song.";
                }

            } else {
                msj = "The user has reached the maximum number of songs";
            }
        } else {
            msj = "The song already exists";
        }

        return msj;
    }


    public PlayList searchPlayList(String nickName){
        PlayList obj = null;
        boolean isFound = false;

        for(int i = 0; i < super.getPlaylists().size() && !isFound; i++){
            if(super.getPlaylists().get(i) != null && getPlaylists().get(i).getNamePlayList().equalsIgnoreCase(nickName)){
                obj = super.getPlaylists().get(i);
                isFound = true;
            }
        }
        return obj;
    }

    public boolean isAvailable(){
        boolean available = false;
        if (super.getPlaylists().size() < SIZE_PLAYLISTS) {
            available = true;
        }
        return available;
    }

    public boolean songExits(){
        boolean available = false;
        if (super.getShops().size() < SIZE_AUDIOS) {
            available = true;
        }
        return available;
    }

    public Shop searchAudio(String name) {
        Shop obj = null;
        boolean search = false;
        for (int i = 0; i < super.getShops().size() && !search; i++) {
            if (super.getShops().get(i).getSong().getAudioName().equalsIgnoreCase(name)) {
                obj = super.getShops().get(i);
                search = true;
            }
        }

        return obj;
    }

    @Override
    public String removeAudioPlayList(String name, Audio audio){
        String msj = "The audio was removed succesfully";
        PlayList obj = searchPlayList(name);
        if (obj != null) {
            msj = obj.removeAudio(audio);
        } else {
            msj = "The playlist does not exist";
        }
        return msj;
    }

    @Override
    public String editPlaylist(String playName, String changeName) {
        String msg = "The playlist was edited succesfully";
        PlayList obj = searchPlayList(playName);
        if (obj != null) {
            obj.setNamePlayList(playName);
        } else {
            msg = "The playlist does not exist";
        }
        return msg;
    }


 

}