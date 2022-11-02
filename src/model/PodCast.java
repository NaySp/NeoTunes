package model;

public class PodCast {

    String podName;
    String description;
    String category;
    String urlPod;

    int duration;
    int repro;

    public PodCast(String podName, String description, String category, String urlPod, int duration, int repro){

        this.podName = podName;
        this.description = description;
        this.category = category;
        this.urlPod = urlPod;

        this.duration = duration;
        this.repro = repro;
        
     
    }

    public String getPodName() {
        return podName;
    }

    public void setPodName(String podName) {
        this.podName = podName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getUrlPod() {
        return urlPod;
    }

    public void setUrlPod(String urlPod) {
        this.urlPod = urlPod;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getRepro() {
        return repro;
    }

    public void setRepro(int repro) {
        this.repro = repro;
    }   


}
