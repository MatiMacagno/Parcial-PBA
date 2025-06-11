package snakegame.Core;
import snakegame.Model.Cell;
import snakegame.Model.Position;
import snakegame.Entities.Snake;
import snakegame.Entities.Personage;
import snakegame.Model.Item;

public class Map {
    
    private Cell[][] grid;
    private int width;
    private int height;
    private Snake snake;

    public Map(int width, int height) {
        this.width = width;
        this.height = height;
        this.grid = new Cell[height][width];
        initializeGrid();
    }
    
    private void initializeGrid() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                grid[i][j] = new Cell();
            }
        }
    }
    
    public boolean putPersonage(Personage personage, Position position) {
        if (!isValidPosition(position)) {
            return false;
        }
        
        int x = position.getX();
        int y = position.getY();
        
        if (grid[y][x].getPersonage() != null) {
            return false;
        }
        
        grid[y][x].setPersonage(personage);
        personage.setPosition(position);
        
        return true;
    }
    
    public boolean putItem(Item item, Position position) {
        if (!isValidPosition(position)) {
            return false;
        }
        
        int x = position.getX();
        int y = position.getY();
        
        grid[y][x].setObject(item);
        return true;
    }
    
    public boolean movePersonage(Personage personage, Position newPosition) {
        if (!isValidPosition(newPosition)) {
            System.out.println("Movimiento inválido: fuera de los límites del mapa.");
            return false;
        }
        
        Position currentPosition = personage.getPosition();
        int newX = newPosition.getX();
        int newY = newPosition.getY();
        
        // Verificar si la nueva posición está ocupada por otro personaje
        if (grid[newY][newX].getPersonage() != null) {
            System.out.println("Movimiento inválido: posición ocupada.");
            return false;
        }
        
        // Remover personaje de la posición actual
        if (currentPosition != null && isValidPosition(currentPosition)) {
            int currentX = currentPosition.getX();
            int currentY = currentPosition.getY();
            grid[currentY][currentX].setPersonage(null);
        }
        
        // Colocar personaje en la nueva posición
        grid[newY][newX].setPersonage(personage);
        personage.setPosition(newPosition);
        
        // Si Snake se mueve sobre un item, lo recoge automáticamente
        if (personage == snake && grid[newY][newX].getObject() != null) {
            Item item = grid[newY][newX].getObject();
            item.pickObject();
            grid[newY][newX].setObject(null);
        }
        
        return true;
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
    
    public boolean isValidPosition(Position position) {
        int x = position.getX();
        int y = position.getY();
        return x >= 0 && x < width && y >= 0 && y < height;
    }
}
