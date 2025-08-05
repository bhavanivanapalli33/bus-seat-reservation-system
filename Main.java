import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Bus Seat Reservation System ===");
            System.out.println("1. Add Bus");
            System.out.println("2. View Buses");
            System.out.println("3. Book Seat");
            System.out.println("4. View Bookings");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    Bus.addBus();
                    break;
                case 2:
                    Bus.viewBuses();
                    break;
                case 3:
                    Booking.bookSeat();
                    break;
                case 4:
                    Booking.viewBookings();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } while (choice != 0);
    }
}
