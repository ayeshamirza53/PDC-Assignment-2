public class ReutersQuoteEvent extends TradeEvent {
    private double bidPrice;
    private double askPrice;

    public ReutersQuoteEvent(String senderId, long timestamp, double basePrice, double bidPrice, double askPrice) {
        super(senderId, timestamp, basePrice);
        this.bidPrice = bidPrice;
        this.askPrice = askPrice;
    }

    @Override
    public void dispatch() {
        double spread = askPrice - bidPrice;
        System.out.println("[REUTERS QUOTE DISPATCH] Sender: " + senderId + 
                           " | Bid: $" + bidPrice + 
                           " | Ask: $" + askPrice + 
                           " | Bid-Ask Spread: $" + String.format("%.4f", spread));
    }
}
// Updated for PDC Lab Assignment 2

// Update commit log

// Incremental commit update
