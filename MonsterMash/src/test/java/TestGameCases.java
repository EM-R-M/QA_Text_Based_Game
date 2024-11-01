import game.features.Game;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
}
