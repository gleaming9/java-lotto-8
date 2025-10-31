package lotto.domain;

import lotto.exception.ErrorMessage;

public class Payment {
    private static final int LOTTO_PRICE = 1000;
    private final int amount;

    public Payment(String input){
        this.amount = validate(input);
    }

    private int validate(String input){
        int num = parseNumericInput(input);
        validatePaymentRules(num);
        return num;
    }

    private int parseNumericInput(String input){
        try{
            return Integer.parseInt(input.trim());
        }
        catch(NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PAYMENT_FORMAT.getMessage());
        }
    }

    private void validatePaymentRules(int num){
        if(num < LOTTO_PRICE) {
            throw new IllegalArgumentException(ErrorMessage.INSUFFICIENT_PAYMENT.getMessage());
        }
        if(num % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PAYMENT_UNIT.getMessage());
        }
    }
}
