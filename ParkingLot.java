import java.util.*;

public class ParkingLot {
    private String name;
    private Queue<Car> parkingQueue;
    private Stack<Car> parkingLot;
    private LinkedList<Car> parkedCars;

    public ParkingLot(String name, int size) {
        this.name = name;
        this.parkingQueue = new LinkedList<>();
        this.parkingLot = new Stack<>();
        this.parkedCars = new LinkedList<>();
    }

    public void addCarToQueue(Car car) {
        parkingQueue.add(car);
    }

    public Car parkCar() {
        Car car = parkingQueue.poll();
        if (car != null) {
            parkingLot.push(car);
            parkedCars.add(car);
        }
        return car;
    }

    public Car removeCar() {
        Car car = parkingLot.pop();
        parkedCars.remove(car);
        return car;
    }

    public Car findCar(String licensePlate) {
        for (Car car : parkedCars) {
            if (car.getLicensePlate().equals(licensePlate)) {
                return car;
            }
        }
        return null;
    }

    public void sortParkedCars() {
        Collections.sort(parkedCars, Comparator.comparing(Car::getLicensePlate));
    }

    public String getName() {
        return this.name;
    }

    public Queue<Car> getParkingQueue() {
        return this.parkingQueue;
    }

    public Stack<Car> getParkingLot() {
        return this.parkingLot;
    }

    public LinkedList<Car> getParkedCars() {
        return this.parkedCars;
    }
}
