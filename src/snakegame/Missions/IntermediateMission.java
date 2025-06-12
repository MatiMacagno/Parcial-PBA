package snakegame.Missions;
import snakegame.Core.Map;
import snakegame.Model.Item;
import snakegame.Model.Position;
import snakegame.Entities.Snake;
import snakegame.Entities.Guard;

public class IntermediateMission extends Mission {

    private int missionNumber;
    private String[] objectives;
    private boolean[] completedObjectives;
    private Map map;
    
    
    public int getMissionNumber() {
        return missionNumber;
    }

    public void setMissionNumber(int missionNumber) {
        this.missionNumber = missionNumber;
    }

    public IntermediateMission(String name, int missionNumber) {
        super(name);
        this.missionNumber = missionNumber;
    }
    
    public IntermediateMission(String name, int missionNumber, String[] objectives) {
        super(name);
        this.missionNumber = missionNumber;
        this.objectives = objectives;
        this.completedObjectives = new boolean[objectives.length];
    }
    
    public IntermediateMission(String name, int missionNumber, String[] objectives, Map map) {
        super(name);
        this.missionNumber = missionNumber;
        this.objectives = objectives;
        this.completedObjectives = new boolean[objectives.length];
        this.map = map;
    }
    
    public void completeObjective(int i) {
        if (i >=0 && i < completedObjectives.length) {
            completedObjectives[i] = true;
            System.out.println("Objetivo completado: " + objectives[i]);
        }
    }
    
    private void createObjectives() {
        if (missionNumber == 1) {
            objectives = new String[] {
                "Obtener la tarjeta de acceso.",
                "Llegar a la puerta del hangar."
            };
        } 
        else if (missionNumber == 2) {
            objectives = new String[] {
                "Recoger explosivos C4.",
                "Abrir la puerta bloqueada."
            };
        }
        
        if (objectives != null) {
            completedObjectives = new boolean[objectives.length];
        }
    }

    private void createMap() {
        if (missionNumber == 1) {
            map = new Map(7, 7, 1);
            
            Item card = new Item("Card");
            Item door = new Item("Door");
            
            map.putItem(card, new Position(3, 5));
            map.putItem(door, new Position(6, 6));
            
            Snake snake = new Snake("Snake", new Position(0, 0));
            map.putPersonage(snake, snake.getPosition());
            
            Guard guard1 = new Guard("Guard", new Position(2, 2));
            Guard guard2 = new Guard("Guard", new Position(5, 4));
            
            map.putPersonage(guard1, guard1.getPosition());
            map.putPersonage(guard2, guard2.getPosition());
        } 
        else if (missionNumber == 2) {
            map = new Map(9, 9, 2);
            
            Item c4 = new Item("C4");
            Item door = new Item("Door");
            
            map.putItem(c4, new Position(5, 7));
            map.putItem(door, new Position(0, 3));
            
            Snake snake = new Snake("Snake", new Position(0, 0));
            map.putPersonage(snake, snake.getPosition());
            
            Guard guard1 = new Guard("Guard", new Position(3, 3));
            Guard guard2 = new Guard("Guard", new Position(7, 7));
            Guard guard3 = new Guard("Guard", new Position(4, 6));
            
            map.putPersonage(guard1, guard1.getPosition());
            map.putPersonage(guard2, guard2.getPosition());
            map.putPersonage(guard3, guard3.getPosition());
        }
    }
    
    @Override
    public void start() {
        if (objectives == null) {
            createObjectives();
        }
        
        System.out.println("Iniciando misión " + name + ".");
        System.out.println("Objetivos:");
        for (int i = 0; i < objectives.length; i++) {
            System.out.println("- " + objectives[i]);
        }
        setMissionUnlocked();
        
        createMap();
        
        System.out.println("Mapa de la misión:");
        map.showMap();   
    }

    @Override
    public boolean verifiedMissionCompleted() {
        for (int i = 0; i < completedObjectives.length; i++) {
            if (!completedObjectives[i]) {
                return false;
            }
        }
        missionCompleted = true;
        return true;
    }
}
