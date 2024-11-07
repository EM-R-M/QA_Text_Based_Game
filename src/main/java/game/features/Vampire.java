package game.features;

public class Vampire extends Monster {
    public Vampire(int[] grid) {
        super(grid);
        this.monsterType = "vampire";

    }

    @Override
    public void message() {
        System.out.println("I'll drink your blood");
    }
}
