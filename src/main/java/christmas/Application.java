package christmas;

import java.util.HashMap;

public class Application {
    public static void main(String[] args) {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
        Menu menu = new Menu();

        // 입력
        InputView inputView = new InputView();
        int userDate = 0;
        boolean validDate = false;
        while (!validDate) {
            try {
                userDate = inputView.readDate();
                validDate = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        HashMap<String, Integer> userMenu = new HashMap<>();
        boolean validMenu = false;
        while (!validMenu) {
            try {
                userMenu = inputView.readMenu();
                validMenu = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        // 로직
        Discount discount = new Discount();
        DiscountResult result = discount.discount(userDate, userMenu);

        // 출력
        OutputView outputView = new OutputView();
        System.out.printf("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n%n", userDate);
        outputView.printMenu(userMenu);
        System.out.println();
        outputView.printTotalOrderAmount(result.getTotalOrderAmount());
        System.out.println();
        outputView.printGiftMenu(result.getGiftMenu());
        System.out.println();
        outputView.printBenefit(result.getBenefit());
        System.out.println();
        outputView.printTotalBenefitAmount(result.getTotalBenefitAmount());
        System.out.println();
        outputView.printFinalMenuAmount(result.getFinalMenuAmount());
        System.out.println();
        outputView.printEventBadge(result.getEventBadge());
    }
}
