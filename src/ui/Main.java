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



    public Scanner getReader(){
        return reader;

    }

    public static void main(String[] args){
        Main main = new Main();
        int option = 0;
        do{
            option = main.getOptionShowMenu();
            main.executeOption(option);
        }while(option != 0);

        main.getReader().close();
    }

    public int validateIntegerOption(){
        int option = 0;

        if(reader.hasNextInt()){
            option = reader.nextInt();
        }
        else{
            reader.nextLine();
            option = -1;
        }
        return option;
    }


    public int getOptionShowMenu(){
        int option = 0;
        System.out.println(optionMenu());
        option = validateIntegerOption();
        return option;
    }

    public String optionMenu( ){
        return
        "\n"+
        "| <*<*<*<   NeoTunes Streaming   >*>*>*> | \n" +
        "\n"+
			"1. Register Producers: artist and content creators\n" +
			"2. Register Costumers: Estandar and Premium.\n" +
			"3. Register Songs and Podcasts.\n" + 
			"4. Create a Playlist.\n" +
			"5. Edit playlist.\n" +
			"6. Share a playlist.\n" +
			"7. consult if a particular apartment is available.\n" +
            "8. \n"+
            "9. \n"+
			"0. Exit.  "; 

    }
    
    public void executeOption(int option){



		switch(option){
	
			case 1 -> addProducer();

            case 2 -> addCustomer();
		
			case 0 -> System.out.println("Exit program.");


			default -> System.out.println("Invalid Option");

		}
	}

    public void addProducer(){
        
        System.out.println("Please type what kind of producer u want to register: ");
        System.out.println("1: Artist \n"+
        "2: Influencer "+ "option:");

        int type = reader.nextInt();

        System.out.println("Type the name of the producer: ");
        String name = reader.next();
        System.out.println("date");
        String date = reader.next();
        System.out.println("Type the url of the image: ");
        String url = reader.next();


        switch (type) {
            case 1: 
                System.out.println(controller.addProducerArtist(null, null, null, type, type));
                break;
            case 2:
                System.out.println(controller.addProducerInfluencer(null, null, null, type, type));
                break;
            default: 
                System.out.println("Invalid option, try again. ");
        }

    }

    public void addCustomer(){

        System.out.println("Type what kind of customer you want to add. \n"+
        "1: Premium \n"+
        "2: Standard");
        int opt = validateIntegerOption();

        if(opt == -1 || opt < 1 || opt > 2){
            System.out.println("Write valid values. ");
        }
        else{
            System.out.println("Type the user's nickname :p ");
            String nickName = reader.next();
            System.out.println("Type your identification: ");
            String cc = reader.next();
            System.out.println("date");
            String tempDate = reader.next();
       
                switch (opt){
                    case 1: 
                        System.out.println(controller.addCustomerPremium(nickName,cc,tempDate));
                        break;
                    case 2:
                        System.out.println(controller.addCustomerStandard(nickName,cc,tempDate));
                        break;

                }

        }

    }




    
}