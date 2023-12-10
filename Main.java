import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter parking lot name: ");
        String parkingLotName = scanner.nextLine();

        System.out.print("Enter parking lot capacity: ");
        int parkingLotCapacity = scanner.nextInt();

        ParkingLot parkingLot = new ParkingLot(parkingLotName, parkingLotCapacity);

        while (true) {
            System.out.println("\nParking Lot Options:");
            System.out.println("1. Add car to queue");
            System.out.println("2. Park car");
            System.out.println("3. Remove car");
            System.out.println("4. Find car by license plate");
            System.out.println("5. Sort parked cars");
            System.out.println("6. Get parking lot details");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter car license plate: ");
                    String licensePlate = scanner.next();
                    Car car = new Car(licensePlate);
                    parkingLot.addCarToQueue(car);
                    System.out.println("Car added to queue.");
                    break;

                case 2:
                    Car parkedCar = parkingLot.parkCar();
                    if (parkedCar != null) {
                        System.out.println("Car " + parkedCar.getLicensePlate() + " parked successfully.");
                    } else {
                        System.out.println("Parking lot is full.");
                    }
                    break;

                case 3:
                    if (parkingLot.getParkedCars().isEmpty()) {
                        System.out.println("There are currently no parked cars to be removed.");
                    } else {
                        Car removedCar = parkingLot.removeCar();
                        if (removedCar != null) {
                            System.out.println("Car " + removedCar.getLicensePlate() + " removed successfully.");
                        } else {
                            System.out.println("Error removing car.");
                        }
                    }
                    break;

                case 4:
                    if (parkingLot.getParkedCars().isEmpty()) {
                        System.out.println("There are currently no parked cars to search for.");
                    } else {
                        System.out.print("Enter car license plate: ");
                        licensePlate = scanner.next();
                        Car foundCar = parkingLot.findCar(licensePlate);
                        if (foundCar != null) {
                            System.out.println("Car " + foundCar.getLicensePlate() + " found in parking lot.");
                        } else {
                            System.out.println("Car not found in parking lot.");
                        }
                    }
                    break;

                case 5:
                    if (parkingLot.getParkedCars().isEmpty()) {
                        System.out.println("There are currently no parked cars to get sorted.");
                    } else {
                        parkingLot.sortParkedCars();
                        System.out.println("Parked cars sorted by license plate.");
                    }
                    break;

                case 6:
                    System.out.println("Parking Lot Name: " + parkingLot.getName());
                    System.out.println("Parking Lot Capacity: " + parkingLot.getCapacity());
                    System.out.println("Parking Queue Size: " + parkingLot.getParkingQueue().size());
                    System.out.print("Parked Cars: ");
                    parkingLot.getParkedCars().forEach(Car -> System.out.print(" | " + Car.getLicensePlate() + " | "));
                    System.out.println();
                    break;

                case 7:
                    System.out.println("Exiting parking lot management system.");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid option (1-7).");
            }
        }
    }
}
