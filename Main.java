import java.util.Arrays;
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
            ParkingLot.displayMenu();

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    parkingLot.addCarToQueue(scanner);;
                    break;

                case 2:
                    parkingLot.parkCar();
                    break;

                case 3:
                    parkingLot.removeCar(scanner);
                    break;

                case 4:
                    parkingLot.findCarByLicensePlate(scanner);
                    break;

                case 5:
                    parkingLot.sortParkedCars();
                    break;

                case 6:
                    String[] waitingCarLicensePlates = parkingLot.getWaitingCarLicensePlates();
                    if (waitingCarLicensePlates.length == 0) {
                        System.out.println("There are no cars that are waiting in the queue.");
                    } else {
                        System.out.print("Cars waiting in the queue: ");
                        Arrays.stream(waitingCarLicensePlates)
                                .forEach(licensePlate -> System.out.print(licensePlate + "-->"));
                        System.out.println();
                    }
                    break;

                case 7:
                    parkingLot.displayParkingLotDetails();
                    break;

                case 8:
                    parkingLot.exitParkingLotSystem(scanner);
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid option (1-7).");
            }
        }
    }
}

