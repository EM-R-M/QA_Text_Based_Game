package game.features;

public class Zombie extends Monster {
    public Zombie(int[] grid) {
        super(grid);
        this.monsterType = "zombie";

    }

    @Override
    public void message() {
        System.out.println("I'll eat your brain");
    }
}
