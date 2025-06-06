package snakegame.Core;
import snakegame.Model.Cell;
import snakegame.Model.Position;

public class Map {
    
    private Cell[][] grid;
    private int width;
    private int height;

    public Map(int width, int height) {
        this.width = width;
        this.height = height;
        this.grid = new Cell[height][width];
    }
    
    public void putPersonage(Position position){
        
    }
    
    public void movePersonage(){
        // Coordina el movimiento dentro del contexto del mapa
    }
    
    public void showMap() {
        // Borde superior
        System.out.print("+");
        for (int j = 0; j < width; j++) {
            System.out.print("-+");
        }
        System.out.println();

        // Filas del mapa
        for (int i = 0; i < height; i++) {
            // Contenido de la fila
            System.out.print("|");
            for (int j = 0; j < width; j++) {
                System.out.print(" |");
            }
            System.out.println();

            // Borde horizontal después de cada fila
            System.out.print("+");
            for (int j = 0; j < width; j++) {
                System.out.print("-+");
            }
            System.out.println();
        }
    }
}
