package game.features;

public class Werewolf extends Monster {
    public Werewolf(int[] grid) {
        super(grid);
        this.monsterType = "werewolf";

    }

    @Override
    public void message() {
        System.out.println("I'll eat your heart");
    }
}
