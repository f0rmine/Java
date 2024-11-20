package cinema;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Представляє собою квиток з такими даними, як номер місця, ціна, дата придбання, спосіб оплати та ім'я покупця.
 */
public class Ticket {
    private int seatNumber;
    private double price;
    private LocalDate purchaseDate;
    private String paymentMethod;
    private String buyerName;

    public Ticket(int seatNumber, double price, LocalDate purchaseDate, String paymentMethod, String buyerName) {
        this.seatNumber = seatNumber;
        this.price = price;
        this.purchaseDate = purchaseDate;
        this.paymentMethod = paymentMethod;
        this.buyerName = buyerName;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public double getPrice() {
        return price;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public String getBuyerName() {
        return buyerName;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "seatNumber=" + seatNumber +
                ", price=" + price +
                ", purchaseDate=" + purchaseDate +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", buyerName='" + buyerName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return seatNumber == ticket.seatNumber &&
                Double.compare(ticket.price, price) == 0 &&
                Objects.equals(purchaseDate, ticket.purchaseDate) &&
                Objects.equals(paymentMethod, ticket.paymentMethod) &&
                Objects.equals(buyerName, ticket.buyerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seatNumber, price, purchaseDate, paymentMethod, buyerName);
    }
}
