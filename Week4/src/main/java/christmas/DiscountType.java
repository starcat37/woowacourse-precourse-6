package christmas;

public enum DiscountType {
    CHRISTMAS("크리스마스 디데이 할인"),
    WEEKDAY("평일 할인"),
    WEEKEND("주말 할인"),
    STAR("특별 할인"),
    GIFT("증정 이벤트");

    private final String description;

    DiscountType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
