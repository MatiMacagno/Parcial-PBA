package snakegame.Entities;

import snakegame.Model.Position;

public class Guard extends Personage implements InterfaceEnemy {

    public Guard(String name, Position position) {
        super(name, position);
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

    @Override
    public void action() {
        
    }
    
}
