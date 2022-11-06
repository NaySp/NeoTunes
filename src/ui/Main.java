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


    public int getOptionShowMenu(){

            int option = 0;

            System.out.println(" ");
            System.out.println("| <*<*<*<   NeoTunes Streaming   >*>*>*> | \n");
            System.out.println("1. Register Producers: artist and content creators\n" +
                "2. Register Costumers: Estandar and Premium.\n" +
                "3. Register Songs or Podcasts.\n" + 
                "4. Create a Playlist.\n" +
                "5. Edit playlist.\n" +
                "0. Exit.");
            
            option = validateInt();
            
            return option;

    }
    
    public void executeOption(int option){



		switch(option){
	
            case 1 -> addProducer();

            case 2 -> addCustomer();

            case 3 -> addAudio();
            
            case 0 -> System.out.println("Exit program.");


            default -> System.out.println("Invalid Option");

		}
	}

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
     * 
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

        System.out.println("Welcome to add song or audio <<< ");
        System.out.println("Please write the name of the artist or influencer which the audio will belong");
        name = reader.next();
        System.out.println("Please type the name of the song or podcast. ");
        audioName = reader.next();
        System.out.println("Please type the url of the image that will have the song or podcast. ");
        urlAudio = reader.next();
        System.out.println("Please write the duration of the song or podcast");
        duration = validateDouble();
    
        System.out.println("Now choose what type is it:\n"+
        "1. Song\n"+
        "2. Podcast\n");
        opt = validateInt();

        if(opt == -1 || opt < 1 || opt > 2){
            System.out.println("Please write a valid option >:c ");
        }else if(duration == -1){
            System.out.println("write a valid value in duration. ");
        }else if(opt == 1){
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
            if(gender == -1 || gender < 1 || gender > 4 ){
                System.out.println("type a valid gender >:| ");
            }else if(saleValue == -1)
                System.out.println("write a valid price. ");
            else{
                msj = controller.addAudioSong(name, audioName, urlAudio, duration, 0, album, saleValue, opt, gender);
                System.out.println(msj);
            }
        }else if(opt == 2){
            System.out.println("-> let's continue adding our PodCast. ");
            System.out.println("Please type a short description of de podCast. ");
            description = reader.next();
            System.out.println("Please choose wich category belong to the podcast.\n"+
            "1. POLITIC\n"+
            "2. ENTERTAIMENT\n"+
            "3. VIDEOGAMES\n"+
            "4. FASHION ");
            category = validateInt();
            if(category == -1 || category < 1 || category > 4){
                System.out.println("Write a valid category. ");
            }
            else{
                msj = controller.addAudioPodCast(name, audioName, urlAudio, duration, 0, description, gender);
                System.out.println(msj);
            }

        }
    }

    
    
    
}