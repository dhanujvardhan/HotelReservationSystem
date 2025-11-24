import java.time.LocalDate;

public class Reservation {
    private int reservationId;
    private int roomNumber;
    private String guestName;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private double amountPaid;

    public Reservation(int reservationId, int roomNumber, String guestName,
                       LocalDate checkInDate, LocalDate checkOutDate, double amountPaid) {
        this.reservationId = reservationId;
        this.roomNumber = roomNumber;
        this.guestName = guestName;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.amountPaid = amountPaid;
    }

    // Getters
    public int getReservationId() { return reservationId; }
    public int getRoomNumber() { return roomNumber; }
    public String getGuestName() { return guestName; }
    public LocalDate getCheckInDate() { return checkInDate; }
    public LocalDate getCheckOutDate() { return checkOutDate; }
    public double getAmountPaid() { return amountPaid; }
}
