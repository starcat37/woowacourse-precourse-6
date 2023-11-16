package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {

        // 1. 구입 금액 입력
        Purchase purchase = new Purchase();
        int purchase_amount = purchase.purchase();
        int purchase_count = purchase_amount / 1000;

        // 2. 로또 발행
        Issuance issuance = new Issuance();
        List<List<Integer>> purchase_lottos = issuance.Issue(purchase_count);

        // 3. 로또 발행 내역 출력
        OutputIssuance outputIssuance = new OutputIssuance();
        outputIssuance.print(purchase_count, purchase_lottos);

        // 4. 당첨 번호 입력
        List<Integer> win_numbers = new ArrayList<>();
        Lotto winLotto = null;
        boolean valid_input = false;
        while (!valid_input) {
            try {
                System.out.println(Messages.WIN_NUMBER_PROMPT.getMessage());
                String[] string_numbers = Console.readLine().split(",");
                win_numbers = Arrays.stream(string_numbers)
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

                winLotto = new Lotto(win_numbers);
                valid_input = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        ArrayList<Integer> win_lottos = winLotto.getNumbers();
        System.out.println();

        // 5. 보너스 번호 입력
        BonusLotto bonusLotto = new BonusLotto();
        int bonus_lotto = bonusLotto.inputBonus(win_lottos);

        // 6. 구매 번호와 당첨 번호 비교
        CompareResult compareResult = new CompareResult();
        List<Integer> win_counts = compareResult.compare(purchase_lottos, win_lottos, bonus_lotto);

        ComputeResult computeResult = new ComputeResult();
        int total_return = computeResult.computeTotal(win_counts);

        // 7. 당첨 내역 출력
        OutputWin outputWin = new OutputWin();
        outputWin.print(win_counts);

        // 8. 수익률 출력
        OutputReturn outputReturn = new OutputReturn();
        outputReturn.print(total_return, purchase_amount);
    }
}