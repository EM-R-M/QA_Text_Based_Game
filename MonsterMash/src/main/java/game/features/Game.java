package game.features;

import java.util.Random;

public class Game {
    private int[] grid = new int[2];
    private int[] currentLoc = new int[2];
    private int[] treasureLoc = new int[2];

    public void createGrid(int height, int width){
        this.grid = new int[] {height, width};
    }

    public void startLocation() {
        Random random = new Random();
        int x = random.nextInt(0, grid[0]);
        int y = random.nextInt(0, grid[1]);
        this.currentLoc = new int[] {x, y};
    }

    public void placeTreasure() {
        Random random = new Random();
        boolean validLoc = true;
        while (validLoc) {
            int x = random.nextInt(0, grid[0]);
            int y = random.nextInt(0, grid[1]);

            if (x != currentLoc[0] && y != currentLoc[1]) {
                validLoc = false;
                this.treasureLoc = new int[] {x, y};
            }
        }
    }

    public int getDistanceToTreasure(){
        int verticalMoves = Math.abs(currentLoc[0] - treasureLoc[0]);
        int horizontalMoves = Math.abs(currentLoc[1] - treasureLoc[1]);
        // Add them together to get the total moves
        return verticalMoves + horizontalMoves;
    }

    public void makeMove(String userInput) {
        switch(userInput.toLowerCase()) {
            case "up":
                currentLoc[0] += 1;
                break;
            case "down":
                currentLoc[0] -= 1;
                break;
            case "left":
                currentLoc[1] -= 1;
                break;
            case "right":
                currentLoc[1] += 1;
                break;
        }
    }

    // Getters and setters
    public int[] getGrid() {
        return grid;
    }

    public int[] getCurrentLoc() {
        return currentLoc;
    }
    public void setCurrentLoc(int[] currentLoc) {
        this.currentLoc = currentLoc;
    }

    public int[] getTreasureLoc() {
        return treasureLoc;
    }

    public void setTreasureLoc(int[] treasureLoc) {
        this.treasureLoc = treasureLoc;
    }

}
