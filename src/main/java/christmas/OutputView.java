package christmas;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class OutputView {
    public void printMenu(HashMap<String, Integer> menu) {
        System.out.println("<주문 메뉴>");
        for (Entry<String, Integer> element : menu.entrySet()) {
            System.out.printf("%s %d개\n", element.getKey(), element.getValue());
        }
    }

    public void printTotalOrderAmount(int totalOrderAmount) {
        DecimalFormat df = new DecimalFormat("###,###");
        System.out.println("<할인 전 총주문 금액>");
        System.out.printf("%s원\n", df.format(totalOrderAmount));
    }

    public void printGiftMenu(int giftMenu) {
        System.out.println("<증정 메뉴>");
        if (giftMenu == 0) {
            System.out.println("없음");
            return;
        }
        System.out.printf("샴페인 %d개\n", giftMenu);
    }

    public void printBenefit(Map<String, Integer> benefit) {
        DecimalFormat df = new DecimalFormat("###,###");
        System.out.println("<혜택 내역>");
        if (benefit.values().stream().allMatch(value -> value == 0)) {
            System.out.println("없음");
            return;
        }
        for (Entry<String, Integer> element : benefit.entrySet()) {
            if (element.getValue() != 0) {
                System.out.printf("%s: -%s원\n", element.getKey(), df.format((element.getValue())));
            }
        }
    }

    public void printTotalBenefitAmount(int totalBenefitAmount) {
        DecimalFormat df = new DecimalFormat("###,###");
        System.out.println("<총혜택 금액>");
        String message = "-%s원\n";
        if (totalBenefitAmount == 0) {
            message = "%s원\n";
        }
        System.out.printf(message, df.format(totalBenefitAmount));
    }

    public void printFinalMenuAmount(int finalMenuAmount) {
        DecimalFormat df = new DecimalFormat("###,###");
        System.out.println("<할인 후 예상 결제 금액>");
        System.out.printf("%s원\n", df.format(finalMenuAmount));
    }

    public void printEventBadge(String eventBadge) {
        System.out.println("<12월 이벤트 배지>");
        if (eventBadge.isBlank()) {
            System.out.println("없음");
            return;
        }
        System.out.println(eventBadge);
    }
}
