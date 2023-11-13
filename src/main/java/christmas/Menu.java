package christmas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Menu {
    private Map<String, MenuItem> itemsMap;

    public Menu() {
        itemsMap = new HashMap<>();
        initializeMenu();
    }

    private void initializeMenu() {
        addItem(new MenuItem("애피타이저", "양송이수프", 6000));
        addItem(new MenuItem("애피타이저", "타파스", 5500));
        addItem(new MenuItem("애피타이저", "시저샐러드", 8000));
        addItem(new MenuItem("메인", "티본스테이크", 55000));
        addItem(new MenuItem("메인", "바비큐립", 54000));
        addItem(new MenuItem("메인", "해산물파스타", 35000));
        addItem(new MenuItem("메인", "크리스마스파스타", 25000));
        addItem(new MenuItem("디저트", "초코케이크", 15000));
        addItem(new MenuItem("디저트", "아이스크림", 5000));
        addItem(new MenuItem("음료", "제로콜라", 3000));
        addItem(new MenuItem("음료", "레드와인", 60000));
        addItem(new MenuItem("음료", "샴페인", 25000));
    }

    private void addItem(MenuItem item) {
        itemsMap.put(item.getName(), item);
    }

    public MenuItem getItemByName(String name) {
        return itemsMap.get(name);
    }

    // 전체 메뉴 아이템을 반환하는 메소드
    public List<MenuItem> getAllItems() {
        return new ArrayList<>(itemsMap.values());
    }
}

