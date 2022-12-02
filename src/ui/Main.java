package ui;

import java.util.Scanner;

import model.NeoTunesController;

public class Main {


    private Scanner reader;
    private NeoTunesController controller;
   

    public Main(){
        reader = new Scanner(System.in);
        controller = new NeoTunesController();
       
    }

    public NeoTunesController getNeoTunes(){
        return controller;
    }

    public Scanner getReader(){
        return this.reader;

    }

    public void setReader(Scanner reader){
        this.reader = reader;
    }

    public static void main(String[] args){

        Main main = new Main();
        int option = 0;
        do{

            option = main.getOptionShowMenu();
            main.executeOption(option);

        }while(option != 0);

    }

    /**
     * allows to validate that what the user type it an int if it has to be
     * @return t
     */
    public int validateInt(){
        int option = -1;

        if(reader.hasNextInt()){
            option = reader.nextInt();
        }
        else{
            reader.next();
            option = -1;
        }
        return option;
    }

    /**
     * allows to validate that what the user type is a double if it has to be
     * @return
     */
    public double validateDouble(){

        double option = -1;
        if(reader.hasNextDouble()){
            option = reader.nextDouble();
        }
        else{
            reader.next();
            option = -1;
        }
        return option;
    }


    /**
     * allows to show what he user can do
     * @return save the option of what wants
     */
    public int getOptionShowMenu(){

            int option = 0;

            System.out.println(" ");
            System.out.println("| <*<*<*<   NeoTunes Streaming   >*>*>*> | \n");
            System.out.println("1. Register Producers: artist and content creators\n" +
                "2. Register Costumers: Estandar and Premium.\n" +
                "3. Register Songs or Podcasts.\n" + 
                "4. Create a Playlist.\n" +
                "5. Edit playlist.\n" +
                "6. Play audio \n"+
                "7. Buy a song. \n"+
                "8. Show reports. \n"+
                "0. Exit.");
            
            option = validateInt();
            
            return option;

    }
    
    /**
     * do what the user type
     * @param option the option that the user gave
     */
    public void executeOption(int option){



		switch(option){
	
            case 1 -> addProducer();

            case 2 -> addCustomer();

            case 3 -> addAudio();

            case 4-> createPlayList();

            case 5-> editPlayList();

            case 6-> playAudio();

            case 7 -> buyAudio();

            case 8 -> reports();
            
            case 0 -> System.out.println("Exit program.");


            default -> System.out.println("Invalid Option");

		}
	}

    /**
     * Allows to add a producer either artist or influencer (contenet creator)
     */
    public void addProducer(){
        
        String msj = "";
    

        System.out.println("Please type what kind of producer u want to register: \n"+
        "1: Artist \n"+
        "2: Influencer \n"+ 
        "option:  ");
        int opt = validateInt();

        if(opt == -1 || opt < 1 || opt > 2){
            System.out.println("Write valid values. ");
        }
        else{
            System.out.println("Type the name of the producer: ");
            String name = reader.next();
            System.out.println("Type the url of the image: ");
            String url = reader.next();

            msj = controller.addProducer(name, url, opt, opt, opt);
            System.out.println(msj);
        }
    }

   
    /**
     * allows add a customer either premium or standard
     */
    public void addCustomer(){

        String  msj = "";

        System.out.println("Type what kind of customer you want to add. \n"+
        "1: Premium \n"+
        "2: Standard");
        int opt = validateInt();

        if(opt == -1 || opt < 1 || opt > 2){
            System.out.println("Write valid values. ");
        }
        else{
            System.out.println("Type the user's nickname :p ");
            String nickName = reader.next();
            System.out.println("Type your identification: ");
            String cc = reader.next();

            msj = controller.addCustomer(nickName, cc, opt);
            System.out.println(msj);

        }
    }
    
    /**
     * allows add an audio, either song or podcast
     */
    public void addAudio(){

        String msj;
        String name;
        String audioName;
        String urlAudio;
        String album;
        String description;

        double duration;
        double saleValue;

        int repNum;

        int opt = 0;
        int gender = 0;
        int category = 0;
        int hours = 0;
        int minutes = 0;
        int seconds = 0;

        System.out.println("Welcome to add song or audio <<< ");
        System.out.println("Please write the name of the artist or influencer which the audio will belong");
        name = reader.next();
        System.out.println("Please type the name of the song or podcast. ");
        audioName = reader.next();
        System.out.println("Please type the url of the image that will have the song or podcast. ");
        urlAudio = reader.next();
        
        System.out.println("Now choose what type is it:\n"+
        "1. Song\n"+
        "2. Podcast\n");
        opt = validateInt();

        if(opt == -1 || opt < 1 || opt > 2){
            System.out.println("Please write a valid option >:c ");

        } else if(opt == 1){

            System.out.println("-> Let's continue, adding our song. ");
            System.out.println("Type the album to which the song belongs");
            album = reader.next();
            System.out.println("Please enter your sales value");
            saleValue = validateDouble();
            System.out.println("Now choose wich gender the song belongs\n"+
            "1. ROCK\n"+
            "2. POP\n"+
            "3. TRAP\n"+
            "4. HOUSE\n");
            gender = validateInt();

            System.out.println("Type the duradion song's in format mm:ss minutes and seconds... ");
            String songDuration = reader.next();

            if (songDuration.length() != 5) {
                System.out.println("Invalid format");

            } else if (songDuration.charAt(2) != ':') {
                System.out.println("Invalid format");

            } else if (Integer.parseInt(songDuration.substring(0, 2)) > 59
                    || Integer.parseInt(songDuration.substring(3, 5)) > 59){
                System.out.println("Invalid format");

            }else if(gender == -1 || gender < 1 || gender > 4 ){
                System.out.println("type a valid gender >:| ");

            }else if(saleValue == -1){
                System.out.println("write a valid price. ");
            }

            else{
                minutes = Integer.parseInt(songDuration.substring(0, 2));
                seconds = Integer.parseInt(songDuration.substring(3, 5));
                msj = controller.addAudioSong(name, audioName, urlAudio, minutes, seconds, 0, album, saleValue, opt, gender);
                System.out.println(msj);
            }
            
        } else if(opt == 2){

            System.out.println("-> let's continue adding our PodCast. ");
            System.out.println("Please type a short description of de podCast. ");
            description = reader.next();
            System.out.println("Please choose wich category belong to the podcast.\n"+
            "1. POLITIC\n"+
            "2. ENTERTAIMENT\n"+
            "3. VIDEOGAMES\n"+
            "4. FASHION ");
            category = validateInt();
            System.out.println("Type the duradion podcast in format hh:mm:ss minutes and seconds... ");
            String songDuration = reader.next();

            if (songDuration.length() != 8) {
                System.out.println("Invalid format");
            } else if (songDuration.charAt(2) != ':' && songDuration.charAt(5) != ':') {
                System.out.println("Invalid format");
            } else if (Integer.parseInt(songDuration.substring(0, 2)) > 24
                    || Integer.parseInt(songDuration.substring(3, 5)) > 59
                    || Integer.parseInt(songDuration.substring(6, 8)) > 59) {
                    System.out.println("Invalid format"); 

            }else if(category == -1 || category < 1 || category > 4){
                System.out.println("Write a valid category. ");
            }
            else{
                msj = controller.addAudioPodCast(name, audioName, urlAudio, hours, minutes, seconds, 0, description, gender);
                System.out.println(msj);
            }

        }
    }

    /**
     * allows create a playlist
     */
    public void createPlayList(){

        String playName;
        String idUser;
        

        System.out.println("Type ur id");
        idUser = reader.next();
        System.out.println("Type the play list's name: ");
        playName = reader.next();
        String msj = controller.registerPlayList(idUser, playName);
        System.out.println(msj);
    }
    
    /**
     * allows edit playlist
     */
    public void editPlayList(){
        String playName;
        String idUser;
        String changeName;
        String audioName;

        int opt;

        System.out.println("Type ur name ;) ");
        idUser = reader.next();
        System.out.println("Please, type play list's name");
        playName = reader.next();
        do {
            System.out.println("Select the action to do : \n"+
            "1. Change playlist's name\n"+
            "2. Add audio\n"+
            "3. Remove audio");
            opt = validateInt();
            if (opt < 1 && opt > 3) {
                System.out.println("Invalid option");
            }
        } while (opt < 1 && opt > 3);
        switch (opt) {
            case 1:
                System.out.println("Type new playlist's name");
                changeName = reader.next();
                System.out.println(controller.editPlaylist(idUser, playName, changeName)); 
                break;
            case 2:
                System.out.println("Type the audio's nameee");
                audioName = reader.next();
                System.out.println(controller.addAudioToPlaylist(idUser, playName, audioName ));;    
                break;
            case 3:
                System.out.println("Type audio's name");
                audioName = reader.next();
                System.out.println(controller.removeAudioFromPlaylist(idUser, audioName, playName));
                 
            default:
                break;
        }

    }

    /**
     * allows play an audio
     */
    public void playAudio(){
        String audioName;
        String idUser;

        System.out.println("Type ur id");
        idUser = reader.next();
        System.out.println("Type audio's name");
        audioName = reader.next();
        System.out.println(controller.playAudio(idUser, audioName));

    }

    /**
     * allows buy an audio
     */
    public void buyAudio(){
        String audioName;
        String idUser;

        System.out.println("Type the name's song u want to buy");
        audioName = reader.next();
        System.out.println("Please type ur id");
        idUser = reader.next();
        System.out.println(controller.buySong(audioName, idUser));

    }

    
    /**
     *  allows to show type of reports that the user want to look for
     */
    public void reports(){
        int opt;
        int option;
        String idUser;

        System.out.println(" >>>> Welcome to show reports, choose what u want to know ;) \n"+
        
        "\n\n 1. Show total playback. "+
        "\n 2. Show most listened genre"+
        "\n 3. Show most listened category"+
        "\n 4. Show top 5 producers"+
        "\n 5. Show top 10 audios"+
        "\n 6. Show total sales"+
        "\n 7. Show most saled song"+
        "\n 0. Go back menu. ");
        opt = validateInt();

        switch (opt) {
            case 0:
                System.out.println("Go back menu. ");
                
                break;
            case 1:
                System.out.println(controller.allReproduction());
                break;
        
            case 2:
               
                do{
                    System.out.println("Type what do u want\n"+
                    "1. All the app\n"+
                    "2. An specific user\n");
                    option = validateInt();
                    if (option < 1 && option > 2){
                        System.out.println("Invalid option");
                    }
                        
                } while(option < 1 && option > 2);

                if (option == 1) {
                    System.out.println(controller.mostListenGender());
                } else {
                    System.out.print("Enter the user's nick : ");
                    idUser = reader.next();
                    System.out.println(controller.mostListenedGender(idUser));
                }
                break;
            
            case 3:
                
                do{
                    System.out.println("Type what do u want\n"+
                    "1. All the app\n"+
                    "2. An specific user\n");
                    option = validateInt();
                    if (option < 1 && option > 2){
                        System.out.println("Invalid option");
                    }
                        
                } while(option < 1 && option > 2);

                if (option == 1) {
                    System.out.println(controller.mostListenCategory());
                } else {
                    System.out.print("Enter the user's nick : ");
                    idUser = reader.next();
                    System.out.println(controller.mostListenedCategory(idUser));
                }  
                break;

            case 4:
                System.out.println(controller.topFive());

                break;
            
            case 5:
                System.out.println(controller.topTen());

                break;
            
            case 6:
                System.out.println(controller.allSalesSongs());
                break;

            case 7:
                System.out.println(controller.showSongsSold());
                break;

            default:
                System.out.println("That's an invalid optionnn");
                break;
        }
        
    }

    
}