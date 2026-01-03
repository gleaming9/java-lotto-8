package lotto.domain;

import lotto.exception.ErrorMessage;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(String input, WinningNumber winningNumber) {
        int num = parseInput(input);
        validateRange(num);
        validateDuplicate(num, winningNumber);
        bonusNumber = num;
    }

    private int parseInput(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BONUS_NUMBER.getMessage());
        }
    }

    private void validateRange(int num) {
        if (num < 1 || num > 45) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BONUS_NUMBER.getMessage());
        }
    }

    private void validateDuplicate(int num, WinningNumber winningNumber) {
        if (winningNumber.getWinningNumber().contains(num)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_BONUS_NUMBER.getMessage());
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
