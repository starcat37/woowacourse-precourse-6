package christmas;

public class BadgeChecker {
    public String badgeCheck(int totalDiscount) {
        if (totalDiscount >= 20000) {
            return Badges.TWENTY_THOUSAND_BADGE.getMessage();
        } else if (totalDiscount >= 10000) {
            return Badges.TEN_THOUSAND_BADGE.getMessage();
        } else if (totalDiscount >= 5000) {
            return Badges.FIVE_THOUSAND_BADGE.getMessage();
        }
        return null;
    }
}
