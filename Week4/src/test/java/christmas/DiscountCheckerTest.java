package christmas;

import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.HashMap;

public class DiscountCheckerTest {
    private DiscountChecker discountChecker;
    private HashMap<String, Integer> menu;

    @BeforeEach
    void setUp() {
        discountChecker = new DiscountChecker();
        menu = new HashMap<>();
        menu.put("양송이수프", 1);
    }

    @Test
    void checkDiscount_크리스마스_할인() {
        Map<String, Integer> discount = discountChecker.checkDiscount(25, menu);
        assertEquals(1000 + 24 * 100, discount.get(DiscountType.CHRISTMAS.getDescription()));
    }

    @Test
    void checkDiscount_크리스마스_할인_미적용() {
        Map<String, Integer> discount = discountChecker.checkDiscount(26, menu);
        assertEquals(0, discount.get(DiscountType.CHRISTMAS.getDescription()));
    }

    @Test
    void checkDiscount_평일_할인() {
        menu.put("아이스크림", 1);
        Map<String, Integer> discount = discountChecker.checkDiscount(3, menu);
        assertTrue(discount.get(DiscountType.WEEKDAY.getDescription()) > 0);
    }

    @Test
    void checkDiscount_주말_할인() {
        menu.put("바비큐립", 1);
        Map<String, Integer> discount = discountChecker.checkDiscount(2, menu);
        assertTrue(discount.get(DiscountType.WEEKEND.getDescription()) > 0);
    }

    @Test
    void checkDiscount_별_할인() {
        menu.put("티본스테이크", 1);
        Map<String, Integer> discount = discountChecker.checkDiscount(25, menu);
        assertEquals(1000, discount.get(DiscountType.STAR.getDescription()));
    }

    @Test
    void checkDiscount_선물_증정() {
        menu.put("티본스테이크", 5);
        Map<String, Integer> discount = discountChecker.checkDiscount(10, menu);
        assertEquals(25000, discount.get(DiscountType.GIFT.getDescription()));
    }
}
