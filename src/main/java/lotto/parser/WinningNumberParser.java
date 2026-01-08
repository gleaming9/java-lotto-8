package lotto.parser;

import lotto.domain.WinningNumber;
import lotto.exception.ErrorMessage;

import java.util.*;

public class WinningNumberParser {
    private static final String BASE_DELIMITER = ",";

    public WinningNumber parseWinningNumber(String input) {
        List<Integer> numbers = parseNumberList(input);
        return new WinningNumber(numbers);
    }

    private List<Integer> parseNumberList(String input) {
        String[] numberStrings = input.split(BASE_DELIMITER);
        List<Integer> winningNumberList = new ArrayList<>();

        for (String numStr : numberStrings) {
            int num = parseNumber(numStr);
            winningNumberList.add(num);
        }

        validateDuplicate(winningNumberList);
        Collections.sort(winningNumberList);
        return winningNumberList;
    }

    private int parseNumber(String numStr) {
        try {
            int num = Integer.parseInt(numStr);
            validateRange(num);
            return num;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_WINNING_NUMBER_RANGE.getMessage());
        }
    }

    private void validateRange(int num) {
        if (num < 1 || num > 45) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_WINNING_NUMBER_RANGE.getMessage());
        }
    }

    private void validateDuplicate(List<Integer> numbers){
        Set<Integer> myset = new HashSet<>(numbers);
        if(myset.size() != numbers.size()){
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_WINNING_NUMBER.getMessage());
        }
    }
}
