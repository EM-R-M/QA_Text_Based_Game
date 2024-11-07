import game.features.Game;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Game game = new Game();
        Scanner scanner = new Scanner(System.in);

        System.out.println("What size of grid do you want to play in?");
        System.out.print("Height: ");
        int height = scanner.nextInt();
        System.out.print("Width: ");
        int width = scanner.nextInt();
        // ignore any more inputs
        scanner.nextLine();

        // Create the game set-up
        game.createGrid(height, width);
        game.startLocation();
        game.placeTreasure();

        boolean gameFinished = false;
        while (!gameFinished) {

            printMap(game.getGrid(), game.getCurrentLoc());
            System.out.println("\n\nWhere would you like to move?");
            System.out.println("UP / DOWN / LEFT / RIGHT");
            String movement = scanner.nextLine();
            game.makeMove(movement);

            if (game.getDistanceToTreasure() == 0) {
                System.out.println();
                System.out.println("YOU WIN");
                System.out.println("CONGRATS YOU HAVE FOUND THE TREASURE!");
                gameFinished = true;
            } else {
                System.out.println("\nDistance to treasure: " + game.getDistanceToTreasure());
            }
        }

    }

    public static void printMap(int[] grid, int[] currentLoc){
        System.out.println();
        for (int i = 0; i < grid[0]; i++){
            for (int j = 0; j < grid[1]; j++){
                System.out.print("--" );
            }
            System.out.print("-" );
            System.out.println();
            for (int j = 0; j < grid[1]; j++){
                if (currentLoc[0] == i && currentLoc[1] == j){
                    System.out.print("|x" );
                } else {
                    System.out.print("| ");
                }
            }
            System.out.print("|");
            System.out.println();
        }
        for (int j = 0; j < grid[1]; j++){
            System.out.print("--" );
        }
        System.out.print("-" );
    }
}
