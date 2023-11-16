package christmas;

import java.util.Map;

public class DiscountResult {
    private final int totalOrderAmount;
    private final int giftMenu;
    private final Map<String, Integer> benefit;
    private final int totalBenefitAmount;
    private final int finalMenuAmount;
    private final String eventBadge;

    public DiscountResult(int totalOrderAmount, int giftMenu, Map<String, Integer> benefit, int totalBenefitAmount, int finalMenuAmount, String eventBadge) {
        this.totalOrderAmount = totalOrderAmount;
        this.giftMenu = giftMenu;
        this.benefit = benefit;
        this.totalBenefitAmount = totalBenefitAmount;
        this.finalMenuAmount = finalMenuAmount;
        this.eventBadge = eventBadge;
    }

    // Getter 메서드들
    public int getTotalOrderAmount() {
        return totalOrderAmount;
    }

    public int getGiftMenu() {
        return giftMenu;
    }

    public Map<String, Integer> getBenefit() {
        return benefit;
    }

    public int getTotalBenefitAmount() {
        return totalBenefitAmount;
    }

    public int getFinalMenuAmount() {
        return finalMenuAmount;
    }

    public String getEventBadge() {
        return eventBadge;
    }
}
