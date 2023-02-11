package monitor;

public class Main {

    public static void main(String[] args) {
        Bridge bridge = new Bridge();
        for (int i = 1; i <= 10; i++) {
            new CarNorth(i, bridge).start();
            new CarSouth(i + 10, bridge).start();
        }
    }
}