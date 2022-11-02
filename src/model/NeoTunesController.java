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

    public String addProducerArtist(String name, String date, String url, int playBack, int playTime){
       
        String msj;
        Producer newProducer = new Artist(name, date, url, playBack, playTime);
        producers.add(newProducer);
        msj = "Artist added successfully. ";
        return msj;

    }
    
    public String addProducerInfluencer(String name, String date, String url, int playBack, int playTime){
       
        String msj;
        Producer newProducer = new Influencer(name, date, url, playBack, playTime);
        producers.add(newProducer);
        msj = "Influencer added successfully. ";
        return msj;

    }

    public String addCustomerStandard(String nickName, String cc, String tempDate){
        
        String msj;
        Customer newCustomer = new Standard(nickName, cc, tempDate);
        customers.add(newCustomer);
        msj = "Standar customer added.";
        return msj;
    }

    public String addCustomerPremium(String nickName, String cc, String tempDate){
        
        String msj;
        Customer newCustomer = new Premium(nickName, cc, tempDate);
        customers.add(newCustomer);
        msj = "Premium customer added. :* ";
        return msj;

    }
     

}