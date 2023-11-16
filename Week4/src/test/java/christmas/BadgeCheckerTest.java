package christmas;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BadgeCheckerTest {

    @Test
    void 배지_확인_산타_배지() {
        BadgeChecker checker = new BadgeChecker();
        assertEquals(Badges.TWENTY_THOUSAND_BADGE.getMessage(), checker.badgeCheck(20000), "20,000: 산타 배지 받음");
    }

    @Test
    void 배지_확인_트리_배지() {
        BadgeChecker checker = new BadgeChecker();
        assertEquals(Badges.TEN_THOUSAND_BADGE.getMessage(), checker.badgeCheck(10000), "10,000: 트리 배지 받음");
    }

    @Test
    void 배지_확인_별_배지() {
        BadgeChecker checker = new BadgeChecker();
        assertEquals(Badges.FIVE_THOUSAND_BADGE.getMessage(), checker.badgeCheck(5000), "5,000: 별 배지를 받음");
    }

    @Test
    void 배지_확인_경계값_미만() {
        BadgeChecker checker = new BadgeChecker();
        assertEquals("", checker.badgeCheck(4999), "4,999: 배지 없음");
    }

    @Test
    void 배지_확인_할인_없음() {
        BadgeChecker checker = new BadgeChecker();
        assertEquals("", checker.badgeCheck(0), "0: 배지 없음");
    }
}
