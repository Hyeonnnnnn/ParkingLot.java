import java.util.*;

public class ParkingLot {
    private String name;
    private Queue<Car> parkingQueue;
    private Stack<Car> parkingLot;
    private LinkedList<Car> parkedCars;
    private int capacity;

    public ParkingLot(String name, int size) {
        this.name = name;
        this.parkingQueue = new LinkedList<>();
        this.parkingLot = new Stack<>();
        this.parkedCars = new LinkedList<>();
        this.capacity = size;
    }

    public static void displayMenu() {
        System.out.println("\nParking Lot Options:");
        System.out.println("1. Add car to queue");
        System.out.println("2. Park car");
        System.out.println("3. Remove car");
        System.out.println("4. Find car by license plate");
        System.out.println("5. Sort parked cars");
        System.out.println("6. Check queue");
        System.out.println("7. Get parking lot details");
        System.out.println("8. Exit");
    }

    public void addCarToQueue(Scanner scanner) {
        System.out.print("Enter car license plate: ");
        String licensePlate = scanner.next();
        Car car = new Car(licensePlate);
        parkingQueue.add(car);
        System.out.println("Car added to queue.");
    }

    public void parkCar() {
        if (parkingQueue.isEmpty()) {
            System.out.println("There are no cars that are waiting in the queue.");
        } else if (parkedCars.size() < capacity) {
            Car car = parkingQueue.poll();
            parkingLot.push(car);
            parkedCars.add(car);
            System.out.println("Car " + car.getLicensePlate() + " parked successfully.");
        } else {
            System.out.println("The parking lot is currently full.");
        }
    }

    public void removeCar(Scanner scanner) {
        if (parkedCars.isEmpty()) {
            System.out.println("There are currently no parked cars to be removed.");
            return;
        }

        System.out.print("Enter car license plate: ");
        String licensePlate = scanner.next();

        Iterator<Car> iterator = parkedCars.iterator();
        boolean found = false;

        while (iterator.hasNext()) {
            Car car = iterator.next();
            if (car.getLicensePlate().equalsIgnoreCase(licensePlate)) {
                iterator.remove();
                found = true;
                System.out.println("Car " + car.getLicensePlate() + " removed successfully.");
                break; // Exit the loop after removing the car
            }
        }

        if (!found) {
            System.out.println("Car not found in parking lot. No removal performed.");
        }
    }


    public void findCarByLicensePlate(Scanner scanner) {
        if (parkedCars.isEmpty()) {
            System.out.println("There are currently no parked cars to search for.");
        } else {
            System.out.print("Enter car license plate: ");
            String licensePlate = scanner.next();
            Car foundCar = findCar(licensePlate);
            if (foundCar != null) {
                System.out.println("Car " + foundCar.getLicensePlate() + " found in parking lot.");
            } else {
                System.out.println("Car not found in parking lot.");
            }
        }
    }

    public void sortParkedCars() {
        if (parkedCars.isEmpty()) {
            System.out.println("There are currently no parked cars to get sorted.");
        } else {
            Collections.sort(parkedCars, Comparator.comparing(Car::getLicensePlate));
            System.out.println("Parked cars sorted by license plate.");
        }
    }

    public String[] getWaitingCarLicensePlates() {
        return parkingQueue.stream()
                .map(Car::getLicensePlate)
                .toArray(String[]::new);
    }

    public void displayParkingLotDetails() {
        System.out.println("Parking Lot Name: " + name);
        System.out.println("Parking Lot Capacity: " + capacity);
        System.out.println("Parking Queue Size: " + parkingQueue.size());
        System.out.print("Parked Cars: ");
        parkedCars.forEach(car -> System.out.print(" " + car.getLicensePlate() + " ||"));
        System.out.println();
    }

    private Car findCar(String licensePlate) {
        for (Car car : parkedCars) {
            if (car.getLicensePlate().equals(licensePlate)) {
                return car;
            }
        }
        return null;
    }

    public void exitParkingLotSystem(Scanner scanner) {
        System.out.println("Exiting parking lot management system.");
        scanner.close();
        System.exit(0);
    }

    // Additional methods for your parking lot functionality
}


