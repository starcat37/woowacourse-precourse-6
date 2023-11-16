package christmas;

public class GiftChecker {
    public int giftcheck(int totalAmount) {
        if (totalAmount >= 120000) {
            return 1;
        }
        return 0;
    }
}
