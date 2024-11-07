package game.features;

import java.util.Random;

public class Monster {
    int[] monsterLocation = new int[2];
    String monsterType;

    public Monster(int[] grid) {
        Random random = new Random();
        int x = random.nextInt(0, grid[0]);
        int y = random.nextInt(0, grid[1]);

        this.monsterLocation = new int[] {x, y};
    }

    public void message() {
        System.out.println("GRRRRRRR");
    };

    public int[] getMonsterLocation() {
        return monsterLocation;
    }

    public void setMonsterLocation(int[] monsterLocation) {
        this.monsterLocation = monsterLocation;
    }

    public String getMonsterType() {
        return monsterType;
    }

    public void setMonsterType(String monsterType) {
        this.monsterType = monsterType;
    }
}
