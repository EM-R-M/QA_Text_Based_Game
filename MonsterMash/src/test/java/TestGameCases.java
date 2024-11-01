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
        int[] actualGrid = game.createGrid(height, width);
        // Expected grid should look like this
        int[] expectedGrid = {6, 5};
        // Check the test
        assertTrue(expectedGrid[0] == actualGrid[0] && expectedGrid[1] == actualGrid[1]);

    }
}
