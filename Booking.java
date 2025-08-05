import java.sql.*;
import java.util.Scanner;

public class Booking {
    public static void bookSeat() {
        try (Connection con = DBConnection.getConnection();
             Scanner sc = new Scanner(System.in)) {

            Bus.viewBuses();

            System.out.print("\nEnter Bus ID to book: ");
            int busId = sc.nextInt();
            sc.nextLine();  // clear buffer

            System.out.print("Enter Passenger Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Seat Number: ");
            int seat = sc.nextInt();

            // Check if seat is already booked
            PreparedStatement check = con.prepareStatement("SELECT * FROM booking WHERE bus_id = ? AND seat_number = ?");
            check.setInt(1, busId);
            check.setInt(2, seat);
            ResultSet rs = check.executeQuery();

            if (rs.next()) {
                System.out.println("Seat already booked.");
                return;
            }

            PreparedStatement pst = con.prepareStatement("INSERT INTO booking (bus_id, passenger_name, seat_number) VALUES (?, ?, ?)");
            pst.setInt(1, busId);
            pst.setString(2, name);
            pst.setInt(3, seat);

            int rows = pst.executeUpdate();
            System.out.println(rows > 0 ? "Booking successful!" : "Booking failed.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void viewBookings() {
        try (Connection con = DBConnection.getConnection();
             Scanner sc = new Scanner(System.in)) {

            System.out.print("Enter Bus ID: ");
            int busId = sc.nextInt();

            PreparedStatement pst = con.prepareStatement("SELECT * FROM booking WHERE bus_id = ?");
            pst.setInt(1, busId);

            ResultSet rs = pst.executeQuery();
            System.out.println("\nBookings for Bus ID: " + busId);
            while (rs.next()) {
                System.out.println("Seat: " + rs.getInt("seat_number") + ", Passenger: " + rs.getString("passenger_name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
