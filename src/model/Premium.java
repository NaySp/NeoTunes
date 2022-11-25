package model;
import java.util.ArrayList;

public class Premium extends Customer {

    private ArrayList<Shop> songs;
    private ArrayList<PlayList> playlists;

    public Premium (String nickName, String cc){
        super(nickName, cc);
        songs = new ArrayList<Shop>();
        playlists = new ArrayList<PlayList>();
        
    }

    public String addAudio(Audio audio) {
        String msg = "";
        Shop obj = searchAudio(audio.getAudioName());
        
        if (obj == null) {
            if (audio instanceof Song) {
                Song s = (Song) audio;
                msg+=s.sell();
                super.getShops().add(new Shop(s));

            } else {
                msg = "The audio is not a song.";
            } 
        } else {
            msg = "The song already exists";
        }

        return msg;
    }

    @Override
    public String addPlayList(String nickName){
        String msj = "Play list added succesfully. ";
        PlayList obj = searchPlaylist(nickName);

        if(obj == null){
            playlists.add(new PlayList(nickName));
        } 
        else{
            msj = "Playlist already exists, broo ";
        }
        return msj;
    }

    @Override
    public String addAudioPlayList(String name, Audio audio){
       
        String msj = "The audio was added succesfully";
        PlayList obj = searchPlaylist(name);
        if (obj != null) {
            msj = obj.addAudio(audio);
        } else {
            msj = "The playlist does not exist";
        }

        return msj;
    }

    
    @Override
    public String removeAudioPlayList(String name, Audio audio){
        String msj = "The audio was removed succesfully";
        PlayList obj = searchPlaylist(name);
        if (obj != null) {
            msj = obj.removeAudio(audio);
        } else {
            msj = "The playlist does not exist";
        }
        return msj;
    }

    public PlayList searchPlaylist(String name) {

        PlayList obj = null;
        boolean search = false;
        if (playlists != null) {
            for (int i = 0; i < playlists.size() && !search; i++) {
                if (playlists.get(i).getNamePlayList().equalsIgnoreCase(name)) {
                    obj = playlists.get(i);
                    search = true;
                }
            }
        }

        return obj;

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
    public String editPlaylist(String name, String changeName) {

        String msj = "The playlist was edited successfully";
        PlayList obj = searchPlaylist(name);
        if (obj != null) {
            obj.setNamePlayList(changeName);
        } else {
            msj = "The playlist does not exist";
        }
        return msj;

    }

    @Override
    public ArrayList<Shop> getShops() {
        return songs;
    }

    @Override
    public void setShops(ArrayList<Shop> songs) {
        this.songs = songs;
    }

    @Override
    public ArrayList<PlayList> getPlaylists() {
        return playlists;
    }

    @Override
    public void setPlaylists(ArrayList<PlayList> playlists) {
        this.playlists = playlists;
    }
}