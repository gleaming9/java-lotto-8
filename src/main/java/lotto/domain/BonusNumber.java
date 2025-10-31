package lotto.domain;

import lotto.exception.ErrorMessage;

public class BonusNumber {
    private final int number;

    public BonusNumber(String input, WinningNumber winningNumber) {
        this.number = validate(input, winningNumber);
    }

    private int validate(String input, WinningNumber winningNumber) {
        int num = parseInput(input);
        validateDuplication(num, winningNumber);
        return num;
    }

    private int parseInput(String input) {
        try {
            int num = Integer.parseInt(input);
            validateRange(num);
            return num;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BONUS_NUMBER_FORMAT.getMessage());
        }
    }

    private void validateRange(int num) {
        if (num < LottoRule.MIN_LOTTO_NUMBER.getValue() || num > LottoRule.MAX_LOTTO_NUMBER.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BONUS_NUMBER_RANGE.getMessage());
        }
    }

    private void validateDuplication(int num, WinningNumber winningNumber) {
        if(winningNumber.getNumbers().contains(num)){
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_BONUS_NUMBER.getMessage());
        }
    }

    public int getNumber(){
        return number;
    }
}
