package snakegame.Model;
import snakegame.Entities.Snake;

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

    public void pickObject(Snake snake) {
        if (snake != null) {
            if ("card".equalsIgnoreCase(type)) {
                snake.setHasCard(true);
                System.out.println("¡Snake ha recogido una tarjeta de acceso!");
            } else if ("c4".equalsIgnoreCase(type)) {
                snake.setHasC4(true);
                System.out.println("¡Snake ha recogido explosivos C4!");
            } else {
                System.out.println("Snake ha recogido un objeto: " + type);
            }
        }
    }
}
