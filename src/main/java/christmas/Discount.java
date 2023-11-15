package christmas;

import java.util.HashMap;
import java.util.Map;

public class Discount {
    public DiscountResult discount(int date, HashMap<String, Integer> menu) {
        Calculator calculator = new Calculator();
        GiftChecker giftChecker = new GiftChecker();
        DiscountChecker discountChecker = new DiscountChecker();
        BadgeChecker badgeChecker = new BadgeChecker();

        // Calculator: 할인 전 총주문 금액 구하기 V
        int totalOrderAmount = calculator.calculateTotalMenu(menu);

        // GiftChecker: 증정 메뉴 조건 해당하는지 확인하기 V
        int giftMenu = giftChecker.giftcheck(totalOrderAmount);

        // DiscountChecker: 혜택들 적용 여부 확인하기 V
        Map<String, Integer> Benefit = discountChecker.checkDiscount(date, menu);

        // Calculator: 혜택 적용 상황 반영한 총혜택 금액 구하기 V
        int totalBenefitAmount = calculator.calculateTotalDiscount(Benefit);

        // Calculator: 할인 후 예상 결제 금액 = (할인 전 총주문 금액) - (총혜택 금액) V
        int finalMenuAmount = calculator.calculateTotalPayment(totalOrderAmount, totalBenefitAmount, giftMenu);

        // BadgeChecker: 총혜택 금액에 따라 12월 이벤트 배지 조건 확인하기 V
        String EventBadge = badgeChecker.badgeCheck(totalBenefitAmount);

        // DiscountResult 객체 생성 및 반환
        return new DiscountResult(totalOrderAmount, giftMenu, Benefit, totalBenefitAmount, finalMenuAmount, EventBadge);
    }
}
