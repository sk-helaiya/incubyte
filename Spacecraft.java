import java.util.ArrayList;
import java.util.Scanner;

class Spacecraft {

    private static final String[] DIRECTIONS = {"N", "S", "E", "W", "Up", "Down"};
    private static final int FORWARD = 1;
    private static final int BACKWARD = -1;
    private static final int UP = 1;
    private static final int DOWN = -1;

    private int x;
    private int y;
    private int z;
    private int direction;

    public Spacecraft(int x, int y, int z, int direction) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.direction = direction;
    }

    public void move(char command) {
        switch (command) {
            case 'f':
                move(FORWARD);
                break;
            case 'b':
                move(BACKWARD);
                break;
            case 'r':
                turn(90);
                break;
            case 'l':
                turn(-90);
                break;
            case 'u':
                move(UP);
                break;
            case 'd':
                move(DOWN);
                break;
        }
    }

    private void move(int direction) {
        switch (this.direction) {
            case 0: // N
                y += direction;
                break;
            case 1: // S
                y -= direction;
                break;
            case 2: // E
                x += direction;
                break;
            case 3: // W
                x -= direction;
                break;
            case 4: // Up
                z += direction;
                break;
            case 5: // Down
                z -= direction;
                break;
        }
    }

    private void turn(int angle) {
        this.direction = (this.direction + angle) % 6;
    }

    public String toString() {
        return String.format("(%d, %d, %d) - %s", x, y, z, DIRECTIONS[direction]);
    }

   public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int z = scanner.nextInt();
        int direction = scanner.nextInt();
        Spacecraft spacecraft = new Spacecraft(x, y, z, direction);
        String[] commands = scanner.nextLine().split(" ");
        for (String command : commands) {
            if (command.isEmpty()) {
                return;
            }
            spacecraft.move(command.charAt(0));
        }
        System.out.println(spacecraft);
    }
}