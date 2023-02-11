package monitor;

public class CarSouth extends Thread {

    private int carId;
    private Bridge bridge;

    public CarSouth(int carId, Bridge bridge) {
        this.carId = carId;
        this.bridge = bridge;
    }

    @Override
    public void run() {
        try {
            bridge.crossBridgeSouth(carId);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}