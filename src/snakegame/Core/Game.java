package snakegame.Core;
import snakegame.Missions.Mission;
import snakegame.Missions.IntermediateMission;
import snakegame.Missions.FinalMission;

public class Game {
    
    private Mission[] missions;
    private int completedMisions;
    private int currentMission;
    private String progressCode;
    private String password;
    private boolean completedGame;
    
    public Game() {
        initialize();
    }
    
    // Inicialmente 0 misiones completadas
    private void initialize() {
        completedMisions = 0;  
        currentMission = 0;
        completedGame = false;
        progressCode = "";
        createMissions();
    }
    
    private void createMissions() {
        missions = new Mission[3];
        
        // Objetivos Mision 1 - Hangar de entrada
        String[] objectives1 = {
            "Obtener la tarjeta de acceso.", 
            "Llegar a la puerta del hangar."
        };
        missions[0] = new IntermediateMission("Hangar de entrada.", 1, objectives1);
        
        // Objetivos Misión 2 - Almacén de armas 
        String[] objectives2 = {
            "Recoger explosivos C4.",
            "Abrir la puerta bloqueada."
        };
        missions[1] = new IntermediateMission("Almacén de armas.", 2, objectives2);
        
        // Misión 3 - Batalla Final
        missions[2] = new FinalMission("Hangar de Metal Geear: Batalla final.");
    }
}
