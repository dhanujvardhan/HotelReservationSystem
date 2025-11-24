import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class HotelReservationSystem {

    public static void main(String[] args) {
        HotelManagement hotelManagement = new HotelManagement();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Hotel Reservation System");
            System.out.println("1. Search Available Rooms");
            System.out.println("2. Make Reservation");
            System.out.println("3. View Reservations");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter room category to search (Single/Double/Suite): ");
                    String category = scanner.nextLine();
                    List<Room> availableRooms = hotelManagement.searchAvailableRooms(category);
                    if (availableRooms.isEmpty()) {
                        System.out.println("No rooms available for the category " + category);
                    } else {
                        for (Room room : availableRooms) {
                            System.out.println("Room Number: " + room.getRoomNumber() + ", Price: $" + room.getPrice());
                        }
                    }
                    break;

                case 2:
                    System.out.print("Enter room number to book: ");
                    int roomNumber = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.print("Enter your name: ");
                    String guestName = scanner.nextLine();
                    System.out.print("Enter check-in date (YYYY-MM-DD): ");
                    LocalDate checkIn = LocalDate.parse(scanner.nextLine());
                    System.out.print("Enter check-out date (YYYY-MM-DD): ");
                    LocalDate checkOut = LocalDate.parse(scanner.nextLine());

                    hotelManagement.makeReservation(roomNumber, guestName, checkIn, checkOut);
                    break;

                case 3:
                    hotelManagement.viewReservations();
                    break;

                case 4:
                    System.out.println("Exiting system. Thank you!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println();
        }
    }
}
