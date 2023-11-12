package christmas;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class MenuParser {
    public Map<String, Integer> parseString(String input) {
        Validator validator = new Validator();
        validator.isProperForm(input);
        validator.isDuplicatedMenu(input);
        return Arrays.stream(input.split(","))
                .map(s -> s.split("-"))
                .collect(Collectors.toMap(a -> a[0], a -> Integer.parseInt(a[1])));
    }
}
