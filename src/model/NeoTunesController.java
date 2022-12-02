package model;

import java.util.Random;
import java.util.ArrayList;

public class NeoTunesController{

    private ArrayList<Customer> customers;
    private ArrayList<Producer> producers;
    private ArrayList<Audio> audios;
    private PlayList playList;

    public static Random random = new Random();

        
    public NeoTunesController(){

        producers = new ArrayList<Producer>();
        customers = new ArrayList<Customer>();
        audios = new ArrayList<Audio>();
        
    }

    public boolean addProducer(Producer producer){
        return producers.add(producer);
    }

    public boolean addCustomer(Customer customer){
        return customers.add(customer);
    }

    /**
     * This methos allows to search a producer, either artist or content creator(influencer)
     * it will help in future methods
     * @param name the name of the producer 
     * @return the producer that can be null or the position 
     */
    public Producer searchProducer(String name){

        Producer producer = null;
        boolean isFound = false;

        for(int i = 0; i < producers.size() && !isFound; i++){
            if(producers.get(i).getName().equalsIgnoreCase(name)){
                producer = producers.get(i);
                isFound = true;
            }
        }
        return producer;
    }

    /**
     * This method allows to search for a customer either premium or standard.
     * it will help in future methods
     * @param nickName the name of the customer 
     * @return the customer that can be null or the position 
     */
    public Customer searchCustomer(String nickName){

        Customer customer = null;
        boolean isFound = false;

        for(int i = 0; i < customers.size() && !isFound; i++){
            if(customers.get(i).getNickName().equalsIgnoreCase(nickName)){
                customer = customers.get(i);
                isFound = true;
            }
        }
        return customer;
    }
    
    /**
     * This method allows to add a producer either artist or content creator(influencer)
     * @param name the name of the producer
     * @param url the image that will have
     * @param playBack the atribute of accumaliton of productions 
     * @param playTime the total time played 
     * @param opt what the user choose, if the producer will be artist or influencer 
     * @return a message whit the status if the user was o wan't added.
     */
    public String addProducer(String name, String url, int playBack, int playTime, int opt){
       
        String msj = "";
        Producer producer = searchProducer(name);
        Producer newProducer;


        if(producer != null){
            msj = "This producer already exists.";
        }else if(opt == 1){
            newProducer = new Artist(name, url, playBack, playTime);
            producers.add(newProducer);
            msj = "Artist added successfully." ;
        }
        else if(opt == 2){
            newProducer = new Influencer(name, url, playBack, playTime);
            producers.add(newProducer);
            msj = "Influencer added successfully.";

        }
        return msj;
    }


    /**
     * This methos allows to create a customer, either standard or premium
     * @param nickName the nickname that the customer will have.
     * @param cc the idententication of the customer
     * @param opt if the user choose register an standard or premium
     * @return a message if the customer were added successfully or don't
     */
    public String addCustomer(String nickName, String cc, int opt){
        String msj = "";
        Customer  customer = searchCustomer(nickName);
        Customer newCustomer;
  
        if(customer != null){
            msj = "This customer already exits :c ";
        }else if(opt == 1) {
            newCustomer = new Premium(nickName, cc);
            customers.add(newCustomer);
            msj = "Premium customer added. :* ";
        }
        else if(opt == 2){
            newCustomer = new Standard(nickName, cc);
            customers.add(newCustomer);
            msj = "Standar customer added.";
        }
        return msj;
    }

    /**
     * This methos allows to search for a user either podcast or song
     * It will help in future methods 
     * @param audioName the name of the audio
     * @return the position of the audio or the null position 
     */
    public Audio searchAudio(String audioName){
        Audio audio = null;
        boolean isFound = false;
        for(int i = 0; i < audios.size() && !isFound; i++){
            if(audios.get(i).getAudioName().equalsIgnoreCase(audioName)){
                audio = audios.get(i);
                isFound = true;
            }
        }
        return audio;
    }

    
    /**
     * This methos allows to convert in seconds
     * It will help us in future methods
     * @param h the hours
     * @param m the minutes
     * @param s the seconds
     * @return the seconds convert.
     */
    public int toSeconds(int h, int m, int s){
        int seconds = 0;
        seconds += (h * 3600) + m * 60 + s;
        return seconds;
    }


    /**
     * This method allows the user to add audio of type song 
     * @param name the name of the producer that will belongs the audio, most be created and be artist.
     * @param audioName name of the audio
     * @param urlAudio url image off the auio
     * @param m the minutes of the song
     * @param s the seconds of the song
     * @param repNum the atribute of the reproductions
     * @param album the album were the song will belongs
     * @param saleValue the price of the song if it will be saled
     * @param soldNum the atribute of number of times that the song will be sold
     * @param gender the gender of the song, must choose one: rock, pop, trap or house
     * @return a message with the status of what happend.
     */
    public String addAudioSong(String name, String audioName, String urlAudio, int m, int s, int repNum, String album, double saleValue, int soldNum, int gender){
        
        String msj;
        Producer producer = searchProducer(name);
        int duration = toSeconds(0, m, s);

        if(producer == null){
            msj = "The producer does not exist. ";
        }else{

            if(producer instanceof Artist){
                Audio song = searchAudio(audioName);
                if(song != null){
                    msj = "this audio already exist. ";
                }
                else{
                    Audio newAudio = new Song(audioName, urlAudio, producer, duration, album, saleValue, gender);
                    audios.add(newAudio);
                    Artist artist = ((Artist)(producer));
                    artist.getSongs().add(new Song(audioName, urlAudio, artist, duration, album, saleValue, gender));
                    
                    msj = "Song has been added successfully. ";    
                }
            }
            else{
                msj = "The producer is not an artist. ";
            }
            
        }
        return msj;
    }

    /**
     * This methos allows to create an audio of type podcast
     * @param nickName the name of the producer that will belongs the podcat, must be a 
     * @param audioName the name of the audio in this case, pocast
     * @param urlAudio the url image of the podcast
     * @param h the hours that could have the podcast
     * @param m the minutes
     * @param s and the seconds that could have 
     * @param repNum an atribute of the number of repetions 
     * @param description a short describtion that the audio will have
     * @param category the category of the song, must choose one. Could be: politic, entertaiment, videogamer or fashion 
     * @return
     */
    public String addAudioPodCast(String nickName, String audioName, String urlAudio, int h, int m, int s, int repNum,  String description, int category){
        
        String msj;
        Producer producer = searchProducer(nickName);
        int duration = toSeconds(h,m,s);

        if(producer == null){
            msj = "The producer does not exist. ";

        }else{
            if(producer instanceof Influencer){
                Audio podCast = searchAudio(audioName);
                if(podCast != null){
                    msj = "this audio already exist. ";
                }
                else{
                    Audio newAudio = new PodCast(audioName, urlAudio, duration, producer, repNum, description, category);
                    audios.add(newAudio);
                    Influencer influencer = ((Influencer)(producer));
                    influencer.getPodcasts().add(new PodCast(audioName, urlAudio, duration, influencer, repNum, description, category));
                    msj = "PodCast has been added successfully. ";
                }
            }
            else{
                msj = "The producer is not an influencer. ";
            }  
        }
        return msj;
        
    }

    /**
     * This method allows to create a playList for an user standar or premium that must exist.
     * @param nickName the name of the user
     * @param playName the name of the playlist
     * @return a message with the status of what happend.
     */
    public String registerPlayList(String nickName, String playName){

        String msj = "";
        Customer customer = searchCustomer(nickName);

        if(customer == null){
            msj = "This customer does not exits :c ";
        }
        else{

            if(customer instanceof Standard){
                msj = ((Standard) customer).addPlayList(playName);
            } else if(customer instanceof Premium){
                msj = ((Premium) customer).addPlayList(playName);
            }

        }
        return msj;

    }

    /**
     * This methods allows the users to change their playlist's that must exist.
     * you could change name, add or delate song
     * @param nickName the identification of the user
     * @param name the name that have the playlist
     * @param newName the name that could be the new name if the user choose it
     * @return
     */
    public String editPlaylist(String nickName, String name, String newName) {
        String msj = "The playlist was edited successfully";
        Customer customer = searchCustomer(nickName);

        if (customer != null) {

            if(customer instanceof Standard){
                msj = ((Standard) customer).editPlaylist(nickName, newName);
            } else if(customer instanceof Premium){
                msj = ((Premium) customer).editPlaylist(nickName, newName);
            }
           
        } else {
            msj = "The customer does not exist >:c ";
        }

        return msj;
    }

    /**
     * This methos allows to add audion on a playlist and both must exist.
     * @param nameSong the name of the song that the user want to add
     * @param namePlaylist the name that the user gave to their playList
     * @param nick the identification of the user that must belong the playlist
     * @return a message with the status of what happend
     */
    public String addAudioToPlaylist(String nameSong, String namePlaylist, String nick) {
        String msj = "";
        Customer customer = searchCustomer(nick);
        Audio song = searchAudio(nameSong);

        if (customer != null) {
            if (song != null) {
                    msj = ((Customer) customer).addAudioPlayList(nick, song);

            }else{
                msj = "The audio does not exist";
            }
        }else {
            msj = "The user does not exist";
        }
        return msj;
    }

    /**
     * Remove allows to quit a song that must exist in ther playlist's
     * @param name the name of the playlist
     * @param nick the identification user
     * @param songName the name of te song
     * @return a message with the status of what happend
     */
    public String removeAudioFromPlaylist(String name, String nick, String songName) {
        String msj = "The song was removed successfully";
        Customer customer = searchCustomer(nick);
        Audio song = searchAudio(songName);

        if (customer != null){
            if (song != null) {
                msj = ((Customer) customer).removeAudioPlayList(name, song);
            }else{
                msj = "The audio doesn't exists.";
            }
        }else{
            msj = "The customer does not exist";
        }

        return msj;

    }


    
    /**
     * this method allows to play an audio that must exist.
     * @param idUser the identification of the user who want's to play it
     * @param nameAudio the name of the audio
     * @return a message with the reproducton
     */
    public String playAudio(String idUser, String nameAudio){
        String msj = "";
        Customer customer = searchCustomer(idUser);
        Audio audio = searchAudio(nameAudio);

        if(customer != null){
            if(audio != null){

                if(customer instanceof Premium premium){
                    msj = premium.playAudio(audio);

                }else if(customer instanceof Standard standard){

                    if(audio instanceof Song){
                        if(standard.songAd()){
                            msj += showAnunce();
                            msj += "\n"+ ((Standard) customer).playAudio(audio);

                        }else{
                            msj += "\n"+((Standard) customer).playAudio(audio);
                        }
                    
                    } else{
                        msj += showAnunce();
                        msj += "\n"+((Standard) customer).playAudio(audio);
                    }
                    
                
                }
                
            }else{
                msj = "Sorry dude, that audio doesn't exists. ";
            }

        }else{
            msj = "That customer doesn't exist. ";
        }

        return msj;
    }
    
    /**
     * Allows to show anunce if the user is not premium
     * @return a message with the anunce
     */
    public String showAnunce(){
        String msj = "";
        int ad = random.nextInt(3);
        switch (ad) {
            case 0:
                msj = Anunce.COKE.plays();
                break;
            case 1:
                msj = Anunce.NIKE.plays();
                break;
            case 2:
                msj = Anunce.MyM.plays();
                break;
        }
        return msj;
    }

    /**
     * This method allows the customer to buy an audio that must be a song
     * @param idUser the identification of the user who want's to buy it
     * @param nameAudio the name of the song that must exist's fot be buy it
     * @return a message with the status of what happend
     */
    public String buySong(String idUser, String nameAudio) {

        String msj = "";
        Customer customer = searchCustomer(idUser);
        Audio audio = searchAudio(nameAudio);

        if (customer != null) {
            if (audio != null && audio instanceof Song) {
                if (customer instanceof Premium premium) {
                    msj = premium.addAudio(audio);
                } else if (customer instanceof Standard standard) {
                    msj = standard.addAudio(audio);
                }
            } else {
                msj = "The audio does not exist or is not a song :c ";
            }
        } else {
            msj = "The user does not exist";
        }

        return msj;
    }

        
    /**
     * allReproduction allows to count the reproductions of views
     * @return a message wit the views.
     */
    public String allReproduction(){
        String msj = ""; 
        int allViews=0;

        if(audios.size()!=0){
            for(int i=0;i<audios.size();i++){
            allViews+=audios.get(i).getRepNum();
            }
        }
        msj = "The total views is:  " + allViews ;
        return msj;
    }

    /**
     * This method allows you to show the most listened to genre by listing them all
     * @return a message with the status
     */
    public String mostListenGender() {

        String msj = "";
        int[] total = new int[4];

        for (int i = 0; i < total.length; i++) {
            total[i] = totalplaybackGenders()[i];
        }

        int max = 0;
        int pos = -1;

        for (int i = 0; i < total.length; i++) {
            if (total[i] > max) {
                max = total[i];
                pos = i;
            }
        }

        switch (pos) {
            case 0:msj = "The most listened genre is: Rock, with a total of " + max + " plays";
                break;
            case 1:msj = "The most listened genre is: Pop, with a total of " + max + " plays";
                break;
            case 2:msj = "The most listened genre is: trap, with a total of " + max + " plays";
                break;
            case 3:msj = "The most listened genre is: House, with a total of " + max + " plays";
                break;
            default:msj = "No songs have been listened to";
                break;
        }        
        return msj;
    }

    /**
     * Allows to list most listend gender of one user 
     * @param nick the identification user
     * @return a message with the status
     */
    public String mostListenedGender(String nick) {
        
        String msj = "";
        Customer customer = searchCustomer(nick);

        if (customer != null) {

            msj = customer.mostHearedGender();

        } else {
            msj = "The user doesn't exists.";
        }
        return msj;

    }

    /**
     * Allows count play back gender
     * @return a message with the total
     */
    public int[] totalplaybackGenders() {
        int[] total = new int[4];

        for (int i = 0; i < customers.size(); i++) {
            Customer obj = customers.get(i);
    
            for (int j = 0; j < total.length; j++) {
                total[j] += obj.playbackPerGender()[j];
            } 
        }
        return total;
    }

    /**
     * @return
     */
    public int[] totalplaybackCategories() {
        int[] total = new int[4];

        for (int i = 0; i < customers.size(); i++) {
            Customer obj = customers.get(i);
       
            for (int j = 0; j < total.length; j++) {
                total[j] += obj.playbackPerCategory()[j];
            }
        }
        return total;
    }
    
    /**
     * @return
     */
    public String mostListenCategory() {
        String msj = "";
        int[] total = new int[4];
        for (int i = 0; i < total.length; i++) {
            total[i] = totalplaybackCategories()[i];
        }
        int max = 0;
        int pos = -1;
        for (int i = 0; i < total.length; i++) {
            if (total[i] > max) {
                max = total[i];
                pos = i;
            }
        }
        switch (pos) {
            case 0:msj = "The most listened category is: Policy, with a total of " + max + " plays";
                break;
            case 1:msj = "The most listened category is: Entertainment, with a total of " + max + " plays";
                break;
            case 2:msj = "The most listened category is: Videogames, with a total of " + max + " plays";
                break;
            case 3:msj = "The most listened category is: Fashion, with a total of " + max + " plays";
                break;
            default:msj = "No podcast have been listened to";
                break;
        }
        return msj;
    }

    /**
     * This method allows you to show the most listened to category by listing them all
     * Allows list the most listend category of a user 
     * @param nick identification user
     * @return a message with the status
     */
    public String mostListenedCategory(String nick) {
        String msj = "";
        Customer customer = searchCustomer(nick);

        if (customer != null) {

            msj = customer.mostHearedCategory();
    
        } else {
            msj = "The user does not exist";
        }
        return msj;
    }

    /**
     * Allows to show top five of producers in a on a scale based on your reproductions
     * Most exists producers.
     * @return the top five
     */
    public String topFive() {

        String msj = "no songs or podcasts have been listened to";
        Artist[] top5A = new Artist[5];
        Influencer[] top5C = new Influencer[5];

        ArrayList<Artist> artists = new ArrayList<Artist>();
        ArrayList<Influencer> influencers = new ArrayList<Influencer>();

        for (int i = 0; i < producers.size(); i++) {
            if (producers.get(i) instanceof Artist) {
                artists.add((Artist) producers.get(i));
            } else if (producers.get(i) instanceof Influencer) {
                influencers.add((Influencer) producers.get(i));
            }
        }

        Producer max = null;
        int count = 0;
        max = artists.get(0);

        for (int i = 0; i < artists.size(); i++) {

            if (artists.get(i).getPlayBack() > max.getPlayBack()) {
                max = artists.get(i);
            }
            if (i == artists.size() - 1) {
                if ((top5A[4] == null)) {

                    top5A[count] = (Artist) max;
                    count++;
                    artists.remove(max);
                    if (!artists.isEmpty()) {
                        max = artists.get(0);
                        i = 0;
                    }
                }
            }

        }

        count = 0;
        max = influencers.get(0);
        for (int i = 0; i < influencers.size(); i++) {

            if (influencers.get(i).getPlayBack() > max.getPlayBack()) {
                max = influencers.get(i);
            }
            if (i == influencers.size() - 1) {
                if ((top5C[4] == null)) {

                    top5C[count] = (Influencer) max;
                    count++;
                    influencers.remove(max);
                    if (!influencers.isEmpty()) {
                        max = influencers.get(0);
                        i = 0;
                    }
                }
            }

        }
        for (int i = 0; i < top5A.length; i++) {
            if (top5A[i] != null) {
                msj = "The top 5 artists are:\n ";
                msj += (i + 1) + "." + top5A[i].getName() + " with " + top5A[i].getPlayBack() + " plays";
            }
        }
        for (int i = 0; i < top5C.length; i++) {
            if (top5C[i] != null) {
                msj += "\nThe top 5 content creators are:\n ";
                msj += (i + 1) + "." + top5C[i].getName() + " with " + top5C[i].getPlayBack() + " plays";
            }
        }

        return msj;

    }

    /**
     * Allows to show top ten of the most listened auidos.
     * The top ten most have one audio per type played.
     * @return top ten
     */
    public String topTen() {

        String msj = "no songs or podcasts have been listened to";
        Song[] top10A = new Song[10];
        PodCast[] top10P = new PodCast[10];

        ArrayList<Song> songs = new ArrayList<Song>();
        ArrayList<PodCast> podcasts = new ArrayList<PodCast>();

        for (int i = 0; i < audios.size(); i++) {
            if (audios.get(i) instanceof Song) {
                songs.add((Song) audios.get(i));
            } else if (audios.get(i) instanceof PodCast) {
                podcasts.add((PodCast) audios.get(i));
            }
        }

        int counter = 0;
        Audio max = null;
        max = songs.get(0);
        for (int i = 0; i < songs.size(); i++) {

            if (songs.get(i).getRepNum() > max.getRepNum()) {
                max = songs.get(i);
            }
            if (i == songs.size() - 1) {
                if ((top10A[9] == null)) {

                    top10A[counter] = (Song) max;
                    counter++;
                    songs.remove(max);
                    if (!songs.isEmpty()) {
                        max = songs.get(0);
                        i = 0;
                    }
                }
            }

        }

        counter = 0;
        max = podcasts.get(0);
        for (int i = 0; i < podcasts.size(); i++) {

            if (podcasts.get(i).getRepNum() > max.getRepNum()) {
                max = podcasts.get(i);
            }
            if (i == podcasts.size() - 1) {
                if ((top10P[9] == null)) {

                    top10P[counter] = (PodCast) max;
                    counter++;
                    podcasts.remove(max);
                    if (!podcasts.isEmpty()) {
                        max = podcasts.get(0);
                        i = 0;
                    }
                }
            }

        }
        for (int i = 0; i < top10A.length; i++) {
            if (top10A[i] != null) {
                msj = "The top 10 songs are:\n ";
                msj += (i + 1) + "." + top10A[i].getAudioName() + "with genre: " + top10A[i].getGender()+ " with "
                        + top10A[i].getRepNum() + " plays";
            }
        }

        for (int i = 0; i < top10P.length; i++) {
            if (top10P[i] != null) {
                msj += "\nThe top 10 podcasts are:\n ";
                msj += (i + 1) + "." + top10P[i].getAudioName() + "with Category: " + top10P[i].getCategory()
                        + " with " + top10P[i].getRepNum() + " plays";
            }
        }

        return msj;
    }

    /**
     * Show the sales of songs
     * @return a message with the status
     */
    public String allSalesSongs(){

        String msj = ""; 
        double totalSales = 0.0; 

        if(audios.size()>0){

            for(int i =0; i< audios.size(); i++){
                if(audios.get(i) instanceof Song){
                    Song song = ( (Song)(audios.get(i)) );
                    totalSales += song.getSaleValue() *  song.getSoldNum(); 
                    msj = " The total number of songs sold is: " + totalSales; 
                }
            }
        }else{
            msj="The platform doesn't have audios for report. ";
        }
        return msj; 
    }

    /**
     * Allows show songs that has been sold type by type
     * @return a message with the status
     */
    public String showSongsSold(){
        String msj = ""; 
        int countRock = 0;
        int countPop =0;
        int countTrap =0;
        int countHouse =0; 
        if(audios.size()!=0){
            for(int i =0; i< audios.size(); i++){
                if(audios.get(i) instanceof Song){
                    Song song = ( (Song)(audios.get(i)) );
                    switch(song.getGender()){
                         case 1:
                          countHouse += song.getSoldNum(); 
                          break;
                         case 2:
                         countPop += song.getSoldNum(); 
                          break;
                         case 3:
                         countRock += song.getSoldNum(); 
                          break;
                         case 4:
                         countTrap += song.getSoldNum(); 
                          break;
    
                         default:
                          break;
                    }
                    msj = "The amount of sales according to the genre is: \n" +
                    "House: " + countHouse + "\n"+
                    "Pop: " +  countPop + "\n"+
                    "Rock: " + countRock +"\n"+
                    "Trap: "+ countTrap + "\n"; 
                }
            }
        }else{
            msj="There are non songs to report.";
        }
        return msj; 
        
    }


}