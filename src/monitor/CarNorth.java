package monitor;

public class CarNorth extends Thread {

    private int carId;
    private Bridge bridge;

    public CarNorth(int carId, Bridge bridge) {
        this.carId = carId;
        this.bridge = bridge;
    }

    @Override
    public void run() {
        try {
            bridge.crossBridgeNorth(carId);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}