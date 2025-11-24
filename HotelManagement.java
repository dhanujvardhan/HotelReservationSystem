import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HotelManagement {
    private List<Room> rooms;
    private List<Reservation> reservations;
    private int reservationCounter;

    public HotelManagement() {
        rooms = new ArrayList<>();
        reservations = new ArrayList<>();
        reservationCounter = 1;
        initializeRooms();
    }

    private void initializeRooms() {
        rooms.add(new Room(101, "Single", 100.0));
        rooms.add(new Room(102, "Double", 150.0));
        rooms.add(new Room(201, "Suite", 300.0));
        // Add more rooms if needed
    }

    public List<Room> searchAvailableRooms(String category) {
        return rooms.stream()
                .filter(room -> room.isAvailable() && room.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }

    public Reservation makeReservation(int roomNumber, String guestName,
                                       LocalDate checkIn, LocalDate checkOut) {
        Room room = rooms.stream()
                .filter(r -> r.getRoomNumber() == roomNumber && r.isAvailable())
                .findFirst()
                .orElse(null);

        if (room == null) {
            System.out.println("Room not available.");
            return null;
        }

        double amount = room.getPrice() * (checkOut.toEpochDay() - checkIn.toEpochDay());
        boolean paymentStatus = processPayment(amount);

        if (!paymentStatus) {
            System.out.println("Payment failed.");
            return null;
        }

        room.setAvailable(false);
        Reservation reservation = new Reservation(reservationCounter++, roomNumber, guestName,
                checkIn, checkOut, amount);
        reservations.add(reservation);
        System.out.println("Reservation successful. ID: " + reservation.getReservationId());
        return reservation;
    }

    private boolean processPayment(double amount) {
        // Simulated payment processing (always returns true here)
        System.out.println("Processing payment: $" + amount);
        return true;
    }

    public void viewReservations() {
        if (reservations.isEmpty()) {
            System.out.println("No reservations found.");
        } else {
            for (Reservation r : reservations) {
                System.out.println("Reservation ID: " + r.getReservationId() +
                        ", Room: " + r.getRoomNumber() +
                        ", Guest: " + r.getGuestName() +
                        ", Check-in: " + r.getCheckInDate() +
                        ", Check-out: " + r.getCheckOutDate() +
                        ", Amount Paid: $" + r.getAmountPaid());
            }
        }
    }
}
