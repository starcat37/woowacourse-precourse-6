package christmas;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

public class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    void calculateTotalMenu_테스트() {
        // 메뉴와 수량 설정
        HashMap<String, Integer> menu = new HashMap<>();
        menu.put("티본스테이크", 2); // 메뉴1의 가격을 가정함 (예: 5000원)
        menu.put("바비큐립", 3); // 메뉴2의 가격을 가정함 (예: 7000원)

        // 총 주문 금액 계산
        int totalMenu = calculator.calculateTotalMenu(menu);
        assertEquals(2 * 55000 + 3 * 54000, totalMenu);
    }

    @Test
    void calculateTotalDiscount_테스트() {
        // 할인 정보 설정
        HashMap<String, Integer> discountResult = new HashMap<>();
        discountResult.put(DiscountType.CHRISTMAS.getDescription(), 1100);
        discountResult.put(DiscountType.WEEKDAY.getDescription(), 2023);

        // 총 할인 금액 계산
        int totalDiscount = calculator.calculateTotalDiscount(discountResult);
        assertEquals(1100 + 2023, totalDiscount);
    }

    @Test
    void calculateTotalPayment_증정_포함_테스트() {
        int totalMenu = 20000;
        int totalDiscount = 3000;
        int giftMenu = 1;

        int totalPayment = calculator.calculateTotalPayment(totalMenu, totalDiscount, giftMenu);
        assertEquals(totalMenu - totalDiscount + 25000, totalPayment);
    }

    @Test
    void calculateTotalPayment_증정_미포함_테스트() {
        int totalMenu = 20000;
        int totalDiscount = 3000;
        int giftMenu = 0;

        int totalPayment = calculator.calculateTotalPayment(totalMenu, totalDiscount, giftMenu);
        assertEquals(totalMenu - totalDiscount, totalPayment);
    }
}
