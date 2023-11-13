package christmas;

public class MenuItem {
    private String category; // 메뉴 카테고리
    private String name; // 메뉴 이름
    private int price; // 메뉴 가격

    public MenuItem(String category, String name, int price) {
        this.category = category;
        this.name = name;
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

}
