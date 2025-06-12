package snakegame.Core;
import snakegame.Model.Cell;
import snakegame.Model.Position;
import snakegame.Entities.Snake;
import snakegame.Entities.Personage;
import snakegame.Model.Item;

public class Map {
    
    private final Cell[][] grid;
    private final int width;
    private final int height;
    private final int missionNumber; 
    
    public Map(int width, int height, int missionNumber) {
        this.width = width;
        this.height = height;
        this.missionNumber = missionNumber;
        this.grid = new Cell[height][width];
        initializeGrid();
    }
    
    public Cell[][] getGrid() {
        return grid;
    }
    
    public int getMissionNumber() {
        return missionNumber;
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

        if (personage.getName().equals("Snake")) {
            Snake snake = (Snake) personage;
            if (grid[newY][newX].getObject() != null) {
                Item item = grid[newY][newX].getObject();
                item.pickObject(snake);
                grid[newY][newX].setObject(null);
            }
        }
        
        // Colocar personaje en la nueva posición
        grid[newY][newX].setPersonage(personage);
        personage.setPosition(newPosition);
        
        // Verificar si Snake ha sido capturado después del movimiento
        if (personage.getName().equals("Snake")) {
            if (isSnakeCaptured((Snake) personage)) {
                System.out.println("¡Snake ha sido capturado! Debe comenzar nuevamente.");
                return false;
            }
        }
        
        return true;
    }

    private boolean hasEnemyAt(Position position) {
        int centerX = position.getX();
        int centerY = position.getY();
        
        // Verificar las 8 celdas adyacentes (incluyendo diagonales)
        for (int deltaY = -1; deltaY <= 1; deltaY++) {
            for (int deltaX = -1; deltaX <= 1; deltaX++) {
                // Saltar la celda central (donde está Snake)
                if (deltaX == 0 && deltaY == 0) {
                    continue;
                }
                
                Position adjacentPosition = new Position(centerX + deltaX, centerY + deltaY);
                
                // Verificar si la posición es válida y tiene un enemigo
                if (isValidPosition(adjacentPosition)) {
                    int adjX = adjacentPosition.getX();
                    int adjY = adjacentPosition.getY();
                    
                    Personage personage = grid[adjY][adjX].getPersonage();
                    
                    // Verificar si hay un personaje y si es un enemigo (cualquier personaje que no sea Snake)
                    if (personage != null && !personage.getName().equals("Snake")) {
                        System.out.println("¡Snake ha sido capturado por un enemigo en la posición (" + adjX + "," + adjY + ")!");
                        return true;
                    }
                }
            }
        }
        
        return false;
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
                char symbol = getCellSymbol(i, j);
                System.out.print(symbol + "|");
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
    
    private char getCellSymbol(int row, int col) {
        Cell cell = grid[row][col];

        if (cell.hasPersonage()) {
            Personage personage = cell.getPersonage();

            if (personage.getName().equals("Snake")) {
                return 'S';
            }
            
            else if (personage.getName().equals("Guard")) {
                return 'G';
            }
        }

        // Verificar si hay un objeto en la celda
        if (cell.hasObject()) {
            Item item = cell.getObject();

            String itemType = item.getType();

            switch (itemType) {
                case "Card":
                    return 'C';
                case "C4":
                    return 'X';
                case "Door":
                    return 'D';
               
                default:
                    return ' ';
            }
        }
        return ' ';
    }
    
    public boolean isValidPosition(Position position) {
        int x = position.getX();
        int y = position.getY();
        return x >= 0 && x < width && y >= 0 && y < height;
    }

    public boolean isSnakeCaptured(Snake snake) {
        if (snake == null || snake.getPosition() == null) {
            return false;
        }
        return hasEnemyAt(snake.getPosition());
    }
    
    
}
