package pl.saramak.panel.panels.direction;

public class Direction {
    public static final Direction UP = new Direction(1);
    public static final Direction DOWN = new Direction(-1);
    private int speed;

    public Direction(int speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Direction{" +
                "speed=" + speed +
                '}';
    }
}
