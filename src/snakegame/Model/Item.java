package snakegame.Model;

public class Item {
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Item(String type) {
        this.type = type;
    }
    
    public void pickObject(){
        System.out.println("Haz agarrado el objeto: " + type + ".");
    }
}
