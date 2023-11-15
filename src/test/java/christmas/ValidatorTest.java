package christmas;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

public class ValidatorTest {

    private Validator validator;
    private HashMap<String, Integer> menu;

    @BeforeEach
    void setUp() {
        validator = new Validator();
        menu = new HashMap<>();
    }

    // isDate 메소드 테스트
    @Test
    void 날짜_유효성_검사_유효한_날짜() {
        assertDoesNotThrow(() -> validator.isDate("15"), "유효한 날짜면 예외 발생X");
    }

    @Test
    void 날짜_유효성_검사_유효하지_않은_날짜() {
        assertThrows(IllegalArgumentException.class, () -> validator.isDate("32"), "유효하지 않은 날짜면 IllegalArgumentException 발생");
    }

    @Test
    void 날짜_유효성_검사_숫자가_아닌_문자열() {
        assertThrows(IllegalArgumentException.class, () -> validator.isDate("abc"), "숫자가 아닌 문자열은 IllegalArgumentException 발생");
    }

    // isMenu 메소드 테스트
    @Test
    void 메뉴_유효성_검사_유효한_메뉴() {
        Map<String, Integer> validMenu = new HashMap<>();
        validMenu.put("초코케이크", 1);
        assertDoesNotThrow(() -> validator.isMenu(validMenu), "유효한 메뉴는 예외 발생X");
    }

    @Test
    void 메뉴_유효성_검사_메뉴에_없는_아이템() {
        Map<String, Integer> invalidMenu = new HashMap<>();
        invalidMenu.put("닭한마리", 1);
        assertThrows(IllegalArgumentException.class, () -> validator.isMenu(invalidMenu), "없는 메뉴는 IllegalArgumentException 발생");
    }

    @Test
    void 메뉴_유효성_검사_음수_또는_0_수량() {
        Map<String, Integer> negativeQuantityMenu = new HashMap<>();
        negativeQuantityMenu.put("음식1", -1);
        assertThrows(IllegalArgumentException.class, () -> validator.isMenu(negativeQuantityMenu), "음수 또는 0의 수량은 IllegalArgumentException 발생");
    }

    // isProperForm 메소드 테스트
    @Test
    void 형식_유효성_검사_올바른_형식() {
        assertDoesNotThrow(() -> validator.isProperForm("음식1-1,음식2-2"), "올바른 형식은 예외를 발생X");
    }

    @Test
    void 형식_유효성_검사_잘못된_형식() {
        assertThrows(IllegalArgumentException.class, () -> validator.isProperForm("제로콜라3,타파스2-2"), "잘못된 형식은 IllegalArgumentException 발생");
    }

    // isDuplicatedMenu 메소드 테스트
    @Test
    void 중복_메뉴_검사_중복_없음() {
        assertDoesNotThrow(() -> validator.isDuplicatedMenu("제로콜라-1,타파스-2"), "중복되지 않은 메뉴는 예외 발생X");
    }

    @Test
    void 중복_메뉴_검사_중복_존재() {
        assertThrows(IllegalArgumentException.class, () -> validator.isDuplicatedMenu("제로콜라-1,제로콜라-2"), "중복된 메뉴는 IllegalArgumentException 발생");
    }

    // isWeekendDate 메소드 테스트
    @Test
    void 주말_날짜_검사_주말() {
        assertTrue(validator.isWeekendDate(2), "주말 날짜는 true 반환");
    }

    @Test
    void 주말_날짜_검사_평일() {
        assertFalse(validator.isWeekendDate(3), "평일 날짜는 false 반환");
    }

    // isStarDate 메소드 테스트
    @Test
    void 별_날짜_검사_별_날짜() {
        assertTrue(validator.isStarDate(25), "별 날짜는 true 반환");
    }

    @Test
    void 별_날짜_검사_비별_날짜() {
        assertFalse(validator.isStarDate(4), "별이 아닌 날짜는 false 반환");
    }

    // isMoreThanTenThousand 메소드 테스트
    @Test
    void isMoreThanTenThousand_이상() {
        assertTrue(validator.isMoreThanTenThousand(10000));
    }

    @Test
    void isMoreThanTenThousand_미만() {
        assertFalse(validator.isMoreThanTenThousand(9999));
    }

    // isAllDrinks 메소드 테스트
    @Test
    void isAllDrinks_모든_음료() {
        menu.put("제로콜라", 1);
        menu.put("레드와인", 2);
        assertThrows(IllegalArgumentException.class, () -> validator.isAllDrinks(menu));
    }

    @Test
    void isAllDrinks_음료_아님() {
        menu.put("제로콜라", 1);
        menu.put("타파스", 2);
        assertDoesNotThrow(() -> validator.isAllDrinks(menu));
    }

    @Test
    void isCountLessThanTwenty_미만() {
        for (int i = 1; i < 21; i++) {
            menu.put("메뉴" + i, 1);
        }
        assertDoesNotThrow(() -> validator.isCountLessThanTwenty(menu));
    }

    @Test
    void isCountLessThanTwenty_초과() {
        for (int i = 1; i < 22; i++) {
            menu.put("메뉴" + i, 1);
        }
        assertThrows(IllegalArgumentException.class, () -> validator.isCountLessThanTwenty(menu));
    }


}
