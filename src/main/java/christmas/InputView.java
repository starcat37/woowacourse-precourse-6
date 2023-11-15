package christmas;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashMap;
import java.util.Map;

public class InputView {
    public int readDate() {
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
        String input = Console.readLine();
        Validator validator = new Validator();
        validator.isDate(input);
        return Integer.parseInt(input);
    }

    public HashMap<String, Integer> readMenu() {
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
        String input = Console.readLine();

        // 파싱 로직
        MenuParser menuParser = new MenuParser();
        Map<String, Integer> menu = menuParser.parseString(input);

        // 검증 로직
        Validator validator = new Validator();
        validator.isMenu(menu);
        validator.isAllDrinks(menu);
        validator.isCountLessThanTwenty(menu);

        return (HashMap<String, Integer>) menu;
    }
}
