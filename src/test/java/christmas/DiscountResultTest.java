package christmas;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

public class DiscountResultTest {

    @Test
    void discountResult_생성_및_데이터_검색_테스트() {
        int totalOrderAmount = 142000;
        int giftMenu = 1;
        Map<String, Integer> benefit = new HashMap<>();
        benefit.put(DiscountType.CHRISTMAS.getDescription(), 1200);
        benefit.put(DiscountType.WEEKDAY.getDescription(), 4046);
        benefit.put(DiscountType.WEEKEND.getDescription(), 0);
        benefit.put(DiscountType.STAR.getDescription(), 1000);
        benefit.put(DiscountType.GIFT.getDescription(), 25000);
        int totalBenefitAmount = 1000;
        int finalMenuAmount = 9000;
        String eventBadge = "산타";

        DiscountResult result = new DiscountResult(totalOrderAmount, giftMenu, benefit, totalBenefitAmount, finalMenuAmount, eventBadge);

        assertEquals(totalOrderAmount, result.getTotalOrderAmount());
        assertEquals(giftMenu, result.getGiftMenu());
        assertEquals(benefit, result.getBenefit());
        assertEquals(totalBenefitAmount, result.getTotalBenefitAmount());
        assertEquals(finalMenuAmount, result.getFinalMenuAmount());
        assertEquals(eventBadge, result.getEventBadge());
    }
}
