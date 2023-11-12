package christmas;

import java.nio.channels.Pipe;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Validator {

    public void isDate(String string) {
        isTypeNumber(string);
        int date = Integer.parseInt(string);
        isBetweenRangeNumber(date);
    }

    private void isTypeNumber(String string) {
        if (!string.matches("\\d+")) {
            throw new IllegalArgumentException(ErrorMessages.TYPE_NUMBER_ERROR.getMessage());
        }
    }
    private void isBetweenRangeNumber(int number) {
        if (number < 1 || number > 31) {
            throw new IllegalArgumentException(ErrorMessages.BETWEEN_NUMBER_ERROR.getMessage());
        }
    }

    public void isMenu(Map<String, Integer> menu) {
        isInMenu(menu);
        isPlusNumber(menu);
    }

    private void isInMenu(Map<String, Integer> menu) {
        Menu restaurantMenu = new Menu(); // Assuming this gets the full menu
        List<String> availableItems = restaurantMenu.getAllItems().stream()
                .map(MenuItem::getName)
                .toList();

        for (String item : menu.keySet()) {
            if (!availableItems.contains(item)) {
                throw new IllegalArgumentException(ErrorMessages.MENU_ERROR.getMessage());
            }
        }
    }

    private void isPlusNumber(Map<String, Integer> menu) {
        for (Integer quantity : menu.values()) {
            if (quantity <= 0) {
                throw new IllegalArgumentException(ErrorMessages.MENU_ERROR.getMessage());
            }
        }
    }

    public void isProperForm(String string) {
        String[] items = string.split(",");
        for (String item : items) {
            String[] parts = item.split("-");
            if (parts.length != 2) {
                throw new IllegalArgumentException(ErrorMessages.MENU_ERROR.getMessage());
            }
            try {
                Integer.parseInt(parts[1]);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(ErrorMessages.MENU_ERROR.getMessage());
            }
        }
    }

        public void isDuplicatedMenu(String string) {
            Set<String> uniqueItems = new HashSet<>();
            String[] items = string.split(",");
            for (String item : items) {
                String name = item.split("-")[0];
                if (!uniqueItems.add(name)) {
                    throw new IllegalArgumentException(ErrorMessages.MENU_ERROR.getMessage());
                }
            }
        }
    }
