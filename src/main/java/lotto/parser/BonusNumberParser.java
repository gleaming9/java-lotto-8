package lotto.parser;

import lotto.domain.BonusNumber;
import lotto.domain.WinningNumber;
import lotto.exception.ErrorMessage;

public class BonusNumberParser {
    public BonusNumber parseBonusNumber(String input, WinningNumber winningNumber) {
        int num = parseNumber(input);
        validateDuplicate(num, winningNumber);
        return new BonusNumber(num);
    }

    private int parseNumber(String input) {
        try {
            int num = Integer.parseInt(input);
            validateRange(num);
            return num;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BONUS_NUMBER_RANGE.getMessage());
        }
    }

    private void validateRange(int num) {
        if (num < 1 || num > 45) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BONUS_NUMBER_RANGE.getMessage());
        }
    }

    private void validateDuplicate(int num, WinningNumber winningNumber) {
        if (winningNumber.getWinningNumber().contains(num)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_BONUS_NUMBER.getMessage());
        }
    }
}
