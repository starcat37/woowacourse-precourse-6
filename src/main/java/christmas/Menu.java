package christmas;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<MenuItem> items;

    public Menu() {
        items = new ArrayList<>();
        initializeMenu();
    }

    private void initializeMenu() {
        items.add(new MenuItem("애피타이저", "양송이수프", 6000));
        items.add(new MenuItem("애피타이저", "타파스", 5500));
        items.add(new MenuItem("애피타이저", "시저샐러드", 8000));
        items.add(new MenuItem("메인", "티본스테이크", 55000));
        items.add(new MenuItem("메인", "바비큐립", 54000));
        items.add(new MenuItem("메인", "해산물파스타", 35000));
        items.add(new MenuItem("메인", "크리스마스파스타", 25000));
        items.add(new MenuItem("디저트", "초코케이크", 15000));
        items.add(new MenuItem("디저트", "아이스크림", 5000));
        items.add(new MenuItem("음료", "제로콜라", 3000));
        items.add(new MenuItem("음료", "레드와인", 60000));
        items.add(new MenuItem("음료", "샴페인", 25000));
    }

    // 특정 카테고리의 메뉴 아이템을 반환하는 메소드
    public List<MenuItem> getItemsByCategory(String category) {
        List<MenuItem> filteredItems = new ArrayList<>();
        for (MenuItem item : items) {
            if (item.getCategory().equals(category)) {
                filteredItems.add(item);
            }
        }
        return filteredItems;
    }

    // 전체 메뉴 아이템을 반환하는 메소드
    public List<MenuItem> getAllItems() {
        return new ArrayList<>(items);
    }
}

