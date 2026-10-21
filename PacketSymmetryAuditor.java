public class PacketSymmetryAuditor {
    public static void main(String[] args) {
        String networkPacket = "HEADER-RADAR-HEADER";
        
        String cleaned = networkPacket.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int len = cleaned.length();

        TransactionStack stack = new TransactionStack(len);
        RequestQueue queue = new RequestQueue(len);

        for (char c : cleaned.toCharArray()) {
            stack.push(c);
            queue.enqueue(c);
        }

        boolean isSymmetric = true;

        while (!stack.isEmpty() && !queue.isEmpty()) {
            char stackChar = stack.pop();
            char queueChar = queue.dequeue();
            if (stackChar != queueChar) {
                isSymmetric = false;
                break;
            }
        }

        System.out.println("=== PACKET SYMMETRY AUDIT LOG ===");
        System.out.println("Raw Packet Payload: " + networkPacket);
        System.out.println("Bi-directional Symmetry Verified: " + (isSymmetric ? "PASS (Symmetric Palindrome)" : "FAIL (Asymmetric)"));
    }
}
// Updated for PDC Lab Assignment 2

// Update commit log
