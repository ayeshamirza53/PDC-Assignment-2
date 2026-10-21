public class FIXOrderEvent extends TradeEvent {
    private String clOrdId;

    public FIXOrderEvent(String senderId, long timestamp, double basePrice, String clOrdId) {
        super(senderId, timestamp, basePrice); // Invokes parent constructor[cite: 7]
        this.clOrdId = clOrdId;
    }

    @Override
    public void dispatch() {
        double transactionFee = basePrice * 0.0015; // 0.15% fee[cite: 7]
        double finalPrice = basePrice + transactionFee;
        System.out.println("[FIX ORDER DISPATCH] Client Order ID: " + clOrdId + 
                           " | Sender: " + senderId + 
                           " | Base: $" + basePrice + 
                           " | Fee (0.15%): $" + String.format("%.2f", transactionFee) + 
                           " | Total: $" + String.format("%.2f", finalPrice));
    }
}
// Updated for PDC Lab Assignment 2

// Update commit log
