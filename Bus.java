import java.sql.*;
import java.util.Scanner;

public class Bus {
    public static void addBus() {
        try (Connection con = DBConnection.getConnection();
             Scanner sc = new Scanner(System.in)) {
                 System.out.print("Enter Bus ID: ");
            int id = sc.nextInt();
            sc.nextLine();  // clear buffer

            System.out.print("Enter Bus Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Total Seats: ");
            int seats = sc.nextInt();

            PreparedStatement pst = con.prepareStatement("INSERT INTO bus VALUES (?, ?, ?)");
            pst.setInt(1, id);
            pst.setString(2, name);
            pst.setInt(3, seats);

            int rows = pst.executeUpdate();
            System.out.println(rows > 0 ? "Bus added successfully." : "Failed to add bus.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void viewBuses() {
        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement()) {

            ResultSet rs = st.executeQuery("SELECT * FROM bus");
            System.out.println("\nAvailable Buses:");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("bus_id") + ", Name: " + rs.getString("bus_name") + ", Total Seats: " + rs.getInt("total_seats"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
