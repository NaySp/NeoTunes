package model;

public enum Anunce implements Playable {

    NIKE("Nike, Just do it"),
    COKE("Coca-cola, open happiness"),
    MyM("M&M, Melts in your mouth, not in your hands");
    
    private String message;
    
    /**
     * The anunce that will be reproduced
     * @param message with the anunce
     */
    Anunce(String message) {
        this.message = message;
    }

    
    @Override
    public String plays() {
        String msg = "Sponsored by: " + message;
        return msg;
    }

}