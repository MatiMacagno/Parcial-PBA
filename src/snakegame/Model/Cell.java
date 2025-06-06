package snakegame.Model;
import snakegame.Entities.Personage;

public class Cell {
    private Personage personage;
    private Object object;

    public Personage getPersonage() {
        return personage;
    }

    public void setPersonage(Personage personage) {
        this.personage = personage;
    }
    
    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
    
    public Cell() {
    }

    public Cell(Object object) {
        this.object = object;
    }

    public Cell(Personage personage) {
        this.personage = personage;
    }
  
}
