package christmas;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class DiscountChecker {
    public Map<String, Integer> checkDiscount(int date, HashMap<String, Integer> menu) {
        // 할인 종류(String), 할인된 금액(Integer)
        HashMap<String, Integer> discountResult = new HashMap<>();
        GiftChecker giftcheck = new GiftChecker();
        Calculator calculator = new Calculator();

        discountResult.put(DiscountType.CHRISTMAS.getDescription(), checkChristmasDiscount(date));
        discountResult.put(DiscountType.WEEKDAY.getDescription(), checkWeekdayDiscount(date, menu));
        discountResult.put(DiscountType.WEEKEND.getDescription(), checkWeekendDiscount(date, menu));
        discountResult.put(DiscountType.STAR.getDescription(), checkStarDiscount(date));
        discountResult.put(DiscountType.GIFT.getDescription(), giftcheck.giftcheck(calculator.calculateTotalMenu(menu)) * 25000);

        return discountResult;
    }

    private int checkChristmasDiscount(int date) {
        if (date <= 25) {
            return 1000 + (date-1) * 100;
        }
        return 0;
    }

    private int checkWeekdayDiscount(int date, HashMap<String, Integer> menu) {
        Validator validator = new Validator();
        boolean isWeekend = validator.isWeekendDate(date);
        if (isWeekend) {
            return 0;
        }

        int dessertCount = 0;

        Menu predefinedMenu = new Menu();
        for (Map.Entry<String, Integer> entry : menu.entrySet()) {
            String itemName = entry.getKey();
            MenuItem menuItem = predefinedMenu.getItemByName(itemName);

            if (Objects.equals(menuItem.getCategory(), "디저트")) {
                dessertCount += entry.getValue();
            }
        }
        return dessertCount * 2023;
    }

    private int checkWeekendDiscount(int date, HashMap<String, Integer> menu) {
        Validator validator = new Validator();
        boolean isWeekend = validator.isWeekendDate(date);
        if (!isWeekend) {
            return 0;
        }

        int mainCount = 0;

        Menu predefinedMenu = new Menu();
        for (Map.Entry<String, Integer> entry : menu.entrySet()) {
            String itemName = entry.getKey();
            MenuItem menuItem = predefinedMenu.getItemByName(itemName);

            if (Objects.equals(menuItem.getCategory(), "메인")) {
                mainCount += 1;
            }
        }
        return mainCount * 2023;
    }

    private int checkStarDiscount(int date) {
        Validator validator = new Validator();
        boolean isStar = validator.isStarDate(date);
        if (!isStar) {
            return 0;
        }
        return 1000;
    }
}
