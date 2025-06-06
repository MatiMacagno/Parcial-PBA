package snakegame.Model;

public class Object {
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object(String type) {
        this.type = type;
    }
    
    public void pickObject(){
        System.out.println("Haz agarrado el objeto: " + type + ".");
    }
}
