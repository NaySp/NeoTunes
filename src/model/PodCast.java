package model;

public class PodCast extends Audio {

    
    private String description;
    private Category category;
    

    public PodCast(String audioName, String urlAudio, double duration, int repNum, String description, int category){
        super(audioName, urlAudio, duration, repNum);
        this.description = description;

        switch(category){
            case 1: 

                this.category = Category.POLITIC;
                break;
                
            case 2:

                this.category = Category.ENTERTAINMENT;
                break;

            case 3:

                this.category = Category.VIDEOGAMES;
                break;

            case 4: 

                this.category = Category.FASHION;
                break;
        }
        

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCategory(){
        switch(category){
            case POLITIC:
                return 1;
            case ENTERTAINMENT:
                return 2;
            case VIDEOGAMES:
                return 3;
            case FASHION:
                return 4;
            default:
                return 0;
        }
    }

    




}
