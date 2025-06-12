package snakegame.Entities;

import snakegame.Model.Position;
import snakegame.Model.Item;

public class Snake extends Personage {
    
    private boolean hasCard;
    private boolean hasC4;
    
    public Snake(String name, Position position) {
        super(name, new Position(0, 0));
    }

    public boolean isHasCard() {
        return hasCard;
    }

    public void setHasCard(boolean hasCard) {
        this.hasCard = hasCard;
    }

    public boolean isHasC4() {
        return hasC4;
    }

    public void setHasC4(boolean hasC4) {
        this.hasC4 = hasC4;
    }
    
    @Override
    public void move(int direction) {
        int newX = this.position.getX();
        int newY = this.position.getY();

        switch(direction) {
            case 0: // Arriba
                newY++;
                break;
            case 1: // Abajo
                newY--;
                break;
            case 2: // Izquierda
                newX--;
                break;
            case 3: // Derecha
                newX++;
                break;
            default:
                // Dirección inválida
                break;
        }
        
        this.position = new Position(newX, newY);
    }
   
}
