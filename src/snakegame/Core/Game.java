package snakegame.Core;
import snakegame.Missions.Mission;
import snakegame.Missions.IntermediateMission;
import snakegame.Missions.FinalMission;
import snakegame.Entities.Snake;
import snakegame.Model.Position;
import java.util.Scanner;

public class Game {
    
    private Mission[] missions;
    private int completedMisions;
    private int currentMission;
    private String progressCode;
    private boolean completedGame;
    private Scanner scanner;
    private Snake snake;

    public Game() {
        initialize();
    }
    
    private void initialize() {
        completedMisions = 0;  
        currentMission = 1;
        completedGame = false;
        progressCode = "";
        snake = new Snake("Snake", new Position(0,0));
        scanner = new Scanner(System.in);
        createMissions();
        missions[0].setMissionUnlocked();
    }
    
    private void createMissions() {
        missions = new Mission[3];
        
        missions[0] = new IntermediateMission("Hangar de entrada.", 1, snake);
        
        missions[1] = new IntermediateMission("Almacén de armas.", 2, snake);
        
        missions[2] = new FinalMission("Hangar de Metal Gear: Batalla final.");
    }
    
    public void startGame() {
        System.out.println("    METAL GEAR SOLID - JUEGO    ");
        boolean exit = false;
        while (!exit && !completedGame) {
            System.out.println("MENÚ PRINCIPAL");
            System.out.println("1. Iniciar misión");
            System.out.println("2. Guardar estado");
            System.out.println("3. Cargar estado");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opción: ");
            int option = scanner.nextInt();
            
            switch (option) {
                case 1:
                    startMission();
                    break;
                case 2:
                    saveGame();
                    break;
                case 3:
                    loadGame();
                    break;
                case 0:
                    exit = true;
                    System.out.println("¡Hasta la vista, Snake!");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
        
        if (completedGame) {
            System.out.println("¡FELICITACIONES! Has completado todas las misiones.");
        }
    }

    private void startMission() {
        if (currentMission > missions.length) {
            System.out.println("No hay más misiones disponibles.");
            return;
        }
        
        if (currentMission == 2 && !missions[0].isMissionCompleted()) {
            System.out.println("No puedes iniciar la misión 2 sin completar la misión 1.");
            return;
        }
        
        missions[currentMission - 1].startMission();
    }

    private void saveGame() {
        System.out.println("Guardando estado del juego...");
        System.out.print("Introduce tu código de progreso: ");
        progressCode = scanner.nextLine();
        System.out.println("Código de progreso: " + progressCode);
        System.out.println("Guarda este código para continuar tu partida más tarde.");
    }

    private void loadGame() {
        System.out.println("Cargando estado del juego...");
        System.out.print("Introduce tu código de progreso: ");
        scanner.nextLine();
        String code = scanner.nextLine();
        
        if (code == progressCode) {
            for (int i = 0; i < currentMission; i++) {
                missions[i].setMissionUnlocked();
                if (i < completedMisions) {
                    missions[i].setMissionCompleted(true);
                }
            }
                
            System.out.println("Juego cargado correctamente.");
            System.out.println("Misión actual: " + currentMission);
            System.out.println("Misiones completadas: " + completedMisions);
        } else {
            System.out.println("Código de progreso inválido.");
        }
    }
}
