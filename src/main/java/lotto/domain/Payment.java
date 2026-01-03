package lotto.domain;

import lotto.exception.ErrorMessage;

public class Payment {
    private final long payment;
    private final int lottoCount;

    public Payment(String input) {
        payment = validate(input);
        lottoCount = calculateLottoCount();
    }

    private long validate(String input) {
        long price = parseInput(input);
        validateRange(price);
        return price;
    }

    private long parseInput(String input) {
        try {
            return Long.parseLong(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_A_NUMBER_PAYMENT.getMessage());
        }
    }

    private void validateRange(long price) {
        if (price < 1000) {
            throw new IllegalArgumentException(ErrorMessage.LOW_PAYMENT.getMessage());
        }
        if (price % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PAYMENT.getMessage());
        }
    }

    private int calculateLottoCount() {
        long cnt = payment / 1000;
        return (int) cnt;
    }

    public long getPayment() {
        return payment;
    }

    public int getLottoCount() {
        return lottoCount;
    }
}
