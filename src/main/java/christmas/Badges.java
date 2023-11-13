package christmas;

public enum Badges {
    FIVE_THOUSAND_BADGE("별"),
    TEN_THOUSAND_BADGE("트리"),
    TWENTY_THOUSAND_BADGE("산타");

    private final String badge;
    Badges(String badge) {
        this.badge = badge;
    }

    public String getMessage() {
        return badge;
    }
}
