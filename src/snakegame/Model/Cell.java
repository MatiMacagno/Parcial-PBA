package snakegame.Model;
import snakegame.Entities.Personage;

public class Cell {
    private Personage personage;
    private Item object;

    public Personage getPersonage() {
        return personage;
    }

    public void setPersonage(Personage personage) {
        this.personage = personage;
    }
    
    public Item getObject() {
        return object;
    }

    public void setObject(Item object) {
        this.object = object;
    }
    
    public Cell() {
    }

    public Cell(Item object) {
        this.object = object;
    }

    public Cell(Personage personage) {
        this.personage = personage;
    }
    
    public boolean isEmpty() {
        return personage == null;
    }
  
    public boolean hasPersonage() {
        return personage != null;
    }
    
    public boolean hasObject() {
        return object != null;
    }
}
