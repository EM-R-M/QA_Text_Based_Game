import game.features.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestGameCases {

    Game game = new Game();

    @Test
    public void testCreateGrid() {
        // Test height and width
        int height = 6;
        int width = 5;
        // Create the grid using the method
        game.createGrid(height, width);
        // Expected grid should look like this
        int[] expectedGrid = {6, 5};
        // Check the test
        assertTrue(expectedGrid[0] == game.getGrid()[0] && expectedGrid[1] == game.getGrid()[1]);
    }

    @Test
    public void testStartLocation() {
        game.createGrid(3, 3);
        game.startLocation();
        assertTrue(game.getCurrentLoc()[0] >= 0 && game.getCurrentLoc()[0] < 3 && game.getCurrentLoc()[1] >= 0 && game.getCurrentLoc()[1] < 3);
    }

    @Test
    public void testPlaceTreasureInBounds() {
        game.createGrid(4, 4);
        game.startLocation();
        game.placeTreasure();
        assertTrue(game.getTreasureLoc()[0] >= 0 && game.getTreasureLoc()[0] < 4 && game.getTreasureLoc()[1] >= 0 && game.getTreasureLoc()[1] < 4);
    }

    @Test
    public void testTreasureNotInStartLoc() {
        game.createGrid(4, 4);
        game.startLocation();
        game.placeTreasure();
        assertTrue(game.getTreasureLoc()[0] != game.getCurrentLoc()[0] && game.getTreasureLoc()[1] != game.getCurrentLoc()[1]);
    }

    @Test
    public void testWinCondition() {
        game.setCurrentLoc(new int[]{2, 2});
        game.setTreasureLoc(new int[]{2, 2});
        assertTrue(game.getTreasureLoc()[0] == game.getCurrentLoc()[0] && game.getTreasureLoc()[1] == game.getCurrentLoc()[1]);
    }

    @Test
    public void testNotWinCondition() {
        game.setCurrentLoc(new int[]{3, 2});
        game.setTreasureLoc(new int[]{2, 1});
        assertFalse(game.getTreasureLoc()[0] == game.getCurrentLoc()[0] && game.getTreasureLoc()[1] == game.getCurrentLoc()[1]);
    }

    @Test
    public void testDistanceToTreasure() {
        game.setCurrentLoc(new int[]{3, 2});
        game.setTreasureLoc(new int[]{2, 1});
        int expectedResult = 2;
        int actualResult = game.getDistanceToTreasure();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testUp() {
        game.createGrid(4, 4);
        game.setCurrentLoc(new int[]{3, 2});
        game.makeMove("up");
        int[] expectedLocation = new int[]{4, 2};
        assertTrue(expectedLocation[0] == game.getCurrentLoc()[0] && expectedLocation[1] == game.getCurrentLoc()[1]);
    }

    @Test
    public void testDown() {
        game.createGrid(4, 4);
        game.setCurrentLoc(new int[]{3, 2});
        game.makeMove("DOWN");
        int[] expectedLocation = new int[]{2, 2};
        assertTrue(expectedLocation[0] == game.getCurrentLoc()[0] && expectedLocation[1] == game.getCurrentLoc()[1]);
    }

    @Test
    public void testLeft() {
        game.createGrid(4, 4);
        game.setCurrentLoc(new int[]{3, 2});
        game.makeMove("Left");
        int[] expectedLocation = new int[]{3, 1};
        assertTrue(expectedLocation[0] == game.getCurrentLoc()[0] && expectedLocation[1] == game.getCurrentLoc()[1]);
    }

    @Test
    public void testRight() {
        game.createGrid(4, 4);
        game.setCurrentLoc(new int[]{3, 2});
        game.makeMove("rigHT");
        int[] expectedLocation = new int[]{3, 3};
        assertTrue(expectedLocation[0] == game.getCurrentLoc()[0] && expectedLocation[1] == game.getCurrentLoc()[1]);
    }

    @Test
    public void testCreateWerewolf() {
        game.createGrid(3, 3);
        Werewolf monster1 = new Werewolf(game.getGrid());

        assertEquals("werewolf", monster1.getMonsterType());
    }

    @Test
    public void testCreateVampire() {
        game.createGrid(3, 3);
        Vampire monster2 = new Vampire(game.getGrid());

        assertEquals("vampire", monster2.getMonsterType());
    }

    @Test
    public void testCreateZombie() {
        game.createGrid(3, 3);
        Zombie monster3 = new Zombie(game.getGrid());

        assertEquals("zombie", monster3.getMonsterType());
    }

    @Disabled
    @Test
    public void testInvalidMove() {
        game.setCurrentLoc(new int[]{3, 2});
    }

}
