package model;


import java.util.ArrayList;

public class NeoTunesController{

    private ArrayList<Customer> customers;
    private ArrayList<Producer> producers;
    private ArrayList<Audio> audios;
    

        
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

    public String addAudioSong(String name, String audioName, String urlAudio, double duration, int repNum, String album, double saleValue, int soldNum, int gender){
        
        String msj;
        Producer producer = searchProducer(name);

        if(producer == null){
            msj = "The producer does not exist. ";
        }else{

            if(producer instanceof Artist){
                Audio song = searchAudio(audioName);
                if(song != null){
                    msj = "this audio already exist. ";
                }
                else{
                    Audio newAudio = new Song(audioName, urlAudio, duration, repNum, album, saleValue, soldNum, gender);
                    audios.add(newAudio);
                    msj = "Song has been added successfully. ";    
                }
            }
            else{
                msj = "The producer is not an artist. ";
            }
            
        }
        return msj;
    }

    public String addAudioPodCast(String nickName, String audioName, String urlAudio, double duration, int repNum,  String description, int category){
        
        String msj;

        Producer producer = searchProducer(nickName);

        if(producer == null){
            msj = "The producer does not exist. ";

        }else{
            if(producer instanceof Influencer){
                Audio podCast = searchAudio(audioName);
                if(podCast != null){
                    msj = "this audio already exist. ";
                }
                else{
                    Audio newAudio = new PodCast(audioName, urlAudio, duration, repNum, description, category);
                    audios.add(newAudio);
                    msj = "PodCast has been added successfully. ";
                }
            }
            else{
                msj = "The producer is not an influencer. ";
            }  
        }
        return msj;
        
    }


    


}