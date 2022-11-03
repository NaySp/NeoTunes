package model;

import java.util.ArrayList;

public class NeoTunesController{

    private ArrayList<Customer> customers;
    private ArrayList<Producer> producers;

        
    public NeoTunesController(){

        producers = new ArrayList<Producer>();
        customers = new ArrayList<Customer>();
        
    }

    public boolean addCustomer(Customer customer){
        return customers.add(customer);
    }
    
    public String addProducer(String name, String date, String url, int playBack, int playTime){
       
        int opt = 0;
        String msj = "";
        Producer newProducer;

        if(opt == 1){
            newProducer = new Artist(name, date, url, playBack, playTime);
            producers.add(newProducer);
            msj = "Artist added successfully." ;
        }
        else if(opt == 2){
            newProducer = new Influencer(name, date, url, playBack, playTime);
            producers.add(newProducer);
            msj = "Influencer added successfully.";

        }

        return msj;
    }


    public String addCustomer(String nickName, String cc, String tempDate, int opt){

        String msj = "";
        Customer newCustomer;
  
        if (opt == 1) {
            newCustomer = new Premium(nickName, cc, tempDate);
            customers.add(newCustomer);
            msj = "Premium customer added. :* ";
        }
        else if(opt == 2){
            newCustomer = new Standard(nickName, cc, tempDate);
            customers.add(newCustomer);
            msj = "Standar customer added.";
        }
        return msj;
    }

}