package model;
import java.util.Random;
import java.util.ArrayList;

public class PlayList{

    public static final int ROWS = 6;
    public static final int COLUMNS = 6;

    private ArrayList<Audio> audioList;

    private Random random;
    private String namePlayList;
    private String codePlayList;
    private int songAmount;
    private int podcastAmount;


    public PlayList(String namePlayList){
        this.namePlayList = namePlayList;
        audioList = new ArrayList<Audio>();
        random = new Random();
    }

    /**
     * Allows to fill our matriz
     * @return a message with our matriz filled
     */
    public int [][] fillMatriz(){

        int matriz[][] = new int[ROWS][COLUMNS];

        for(int i= 0; i<ROWS; i++){
            for(int j= 0; j<COLUMNS; j++){
                matriz[i][j] = random.nextInt(9);
            }
        }
        return matriz;
    }


    /**
     * allows to generated a code for the playlist that the user has
     * @param opt the option of what type is the playlist
     */
    public void generateCode(int opt){

        String code = null;
        int[][]matriz = fillMatriz();
        int acu = 1;
        int acu2 = 1;

        switch (opt) {
            case 1:

                for(int i = matriz.length -1; i >= 0; i++){
                    code += matriz[i][0];
                }

                for(int i = 1; i < matriz.length - 1; i++){
                    code += matriz[acu][acu2];
                    acu += 1;
                    acu2 += 1;
                }

                for(int i = matriz.length - 1; i >= 0; i++){
                    code += matriz[i][matriz.length - 1];
                }
                break;

            case 2:

                for(int i=0;i<2;i++){
                    code+=matriz[0][i];
                }
                for(int j=1;j<5;j++){
                    code+=matriz[j][2];
                }
                for(int k=5;k<0;k--){
                    code+=matriz[k][3];
                }
                for(int u=3;u>5;u++){
                    code+=matriz[0][u];
                }
                break;

            case 3:

                for (int i=5;i>=0;i--){
                    for(int j=5;j>=0;j--){
                        int sum = i+j;
                        if (sum%2!=0){
                            if(sum!=1){
                                code+=matriz[i][j]+" ";
                            }
                        }

                    }
                }
                break;
        }

    }


    public int typePlayList(int opt){
        switch(opt){
            case 1:
            return 1;
            case 2:
            return 2;
            case 3:
            return 3;
            default:
            return 0;
        }
    }

    /**
     * Allows add an audio to a playlist, audio must exist
     * @param audio the name of the audio 
     * @return a message with the status
     */
    public String addAudio(Audio audio) {

        String msg = "The audio was added successfully c; ";
        Audio obj = searchAudio(audio.getAudioName());
        if (obj == null) {

            audioList.add(audio);
            if (audio instanceof Song) {
                songAmount++;
            } else {
                podcastAmount++;
            }

        } else {
            msg = "The audio already exists :'c ";
        }
        return msg;

    }



    /**
     * allows to search for an audio
     * this method will help in future
     * @param name the name of the audio
     * @return the postion 
     */
    public Audio searchAudio(String name) {

        Audio obj = null;
        boolean search = false;
        if (audioList != null) {
            for (int i = 0; i < audioList.size() && !search; i++) {
                if (audioList.get(i).getAudioName().equalsIgnoreCase(name)) {
                    obj = audioList.get(i);
                    search = true;
                }
            }
        }
        return obj;
    }


    /**
     * Allowst to remove an audio from a playlist that must exist
     * @param audio the name of the audio
     * @return a message with the status
     */
    public String removeAudio(Audio audio) {

        String msg = "The audio was removed";
        Audio obj = searchAudio(audio.getAudioName());
        if (obj != null) {
            audioList.remove(audio);
        } else {
            msg = "The audio doesn't exist. ";
        }
        return msg;
    }

  
    //** Getters and setters */

    public String getNamePlayList() {
        return namePlayList;
    }

    public void setNamePlayList(String namePlayList) {
        this.namePlayList = namePlayList;
    }

    public String getCodePlayList() {
        return codePlayList;
    }

    public void setCodePlayList(String codePlayList) {
        this.codePlayList = codePlayList;
    }


}