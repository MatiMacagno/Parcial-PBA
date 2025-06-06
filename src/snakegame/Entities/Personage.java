package snakegame.Entities;
import snakegame.Model.Position;

public abstract class Personage {
    
    protected String name;
    protected int hp;
    protected Position position;

    public Personage(String name, Position position) {
        this.name = name;
        this.hp = 100;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
    
    public abstract void move(int direction);
        
}
