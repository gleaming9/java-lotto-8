package lotto.domain;

import lotto.exception.ErrorMessage;

import java.util.*;

public class WinningNumber {
    private final List<Integer> winningNumber;

    public WinningNumber(String input) {
        winningNumber = validate(input);
        Collections.sort(winningNumber);
    }

    private List<Integer> validate(String input) {
        List<String> rawNumbers = parseInput(input);
        List<Integer> parsedNumbers = convertNumbers(rawNumbers);
        validateDuplicate(parsedNumbers);
        return parsedNumbers;
    }

    private List<String> parseInput(String input) {
        List<String> numbers = List.of(input.split(","));
        validateCount(numbers);
        return numbers;
    }

    private List<Integer> convertNumbers(List<String> numbers) {
        List<Integer> result = new ArrayList<>();
        for (String number : numbers) {
            int num = parseNumber(number);
            validateRange(num);
            result.add(num);
        }
        return result;
    }

    private void validateCount(List<String> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_WINNING_NUMBER_COUNT.getMessage());
        }
    }

    private int parseNumber(String numberString) {
        try {
            return Integer.parseInt(numberString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_WINNING_NUMBER.getMessage());
        }
    }

    private void validateRange(int num) {
        if (num < 1 || num > 45) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_WINNING_NUMBER.getMessage());
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> myset = new HashSet<>(numbers);
        if (myset.size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_WINNING_NUMBER.getMessage());
        }
    }

    public List<Integer> getWinningNumber() {
        return winningNumber;
    }
}
