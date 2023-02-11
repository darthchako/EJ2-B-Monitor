package monitor;

public class Bridge {

    private int direction = 0;
    private int carsOnBridge = 0;
    private int waitingCarsNorth = 0;
    private int waitingCarsSouth = 0;

    public synchronized void crossBridgeNorth(int carId) throws InterruptedException {
        waitingCarsNorth++;
        while (direction == 1 || carsOnBridge > 0) {
            wait();
        }
        waitingCarsNorth--;
        direction = 1;
        carsOnBridge++;
        System.out.println("Car " + carId + " from North is crossing the bridge");
        Thread.sleep(1000);
        carsOnBridge--;
        System.out.println("Car " + carId + " from North has crossed the bridge");
        if (carsOnBridge == 0) {
            direction = 0;
            notifyAll();
        }
    }

    public synchronized void crossBridgeSouth(int carId) throws InterruptedException {
        waitingCarsSouth++;
        while (direction == -1 || carsOnBridge > 0) {
            wait();
        }
        waitingCarsSouth--;
        direction = -1;
        carsOnBridge++;
        System.out.println("Car " + carId + " from South is crossing the bridge");
        Thread.sleep(1000);
        carsOnBridge--;
        System.out.println("Car " + carId + " from South has crossed the bridge");
        if (carsOnBridge == 0) {
            direction = 0;
            notifyAll();
        }
    }
}