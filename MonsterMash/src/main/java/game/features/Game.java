package game.features;

import java.util.Random;

public class Game {
    private int[] grid = new int[2];
    private int[] currentLoc = new int[2];

    public void createGrid(int height, int width){
        this.grid = new int[] {height, width};
    }

    public void startLocation() {
        Random random = new Random();
        int x = random.nextInt(0, grid[0]);
        int y = random.nextInt(0, grid[1]);
        this.currentLoc = new int[] {x, y};
    }

    // Getters and setters
    public int[] getGrid() {
        return grid;
    }

    public int[] getCurrentLoc() {
        return currentLoc;
    }
}
