package christmas;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GiftCheckerTest {
    @Test
    void 증정_이벤트_확인_경계값_이상() {
        GiftChecker checker = new GiftChecker();
        assertEquals(1, checker.giftcheck(120000), "120,000: 샴페인 증정O");
    }

    @Test
    void 증정_이벤트_확인_경계값_미만() {
        GiftChecker checker = new GiftChecker();
        assertEquals(0, checker.giftcheck(119999), "119,999: 샴페인 증정X");
    }

    @Test
    void 증정_이벤트_확인_일반_케이스_이상() {
        GiftChecker checker = new GiftChecker();
        assertEquals(1, checker.giftcheck(150000), "150,000: 샴페인 증정O");
    }

    @Test
    void 증정_이벤트_확인_일반_케이스_미만() {
        GiftChecker checker = new GiftChecker();
        assertEquals(0, checker.giftcheck(100000), "100,000: 샴페인 증정X");
    }
}
