package christmas;

import java.util.HashMap;
import java.util.Map;

public class Calculator {

    public int calculateTotalMenu(HashMap<String, Integer> menu) {
        Menu predefinedMenu = new Menu();
        int totalAmount = 0;

        for (Map.Entry<String, Integer> entry : menu.entrySet()) {
            String itemName = entry.getKey();
            Integer quantity = entry.getValue();

            MenuItem menuItem = predefinedMenu.getItemByName(itemName);
            if (menuItem != null) {
                totalAmount += menuItem.getPrice() * quantity;
            }
        }

        return totalAmount;
    }

    public int calculateTotalDiscount(Map<String, Integer> discountResult) {
        return discountResult.values().stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    public int calculateTotalPayment(int totalMenu, int totalDiscount) {
        return totalMenu - totalDiscount;
    }
}
