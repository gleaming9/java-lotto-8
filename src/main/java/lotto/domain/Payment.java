package lotto.domain;

import lotto.exception.ErrorMessage;

public class Payment {
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
        if(num < LottoRule.LOTTO_PRICE.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.INSUFFICIENT_PAYMENT.getMessage());
        }
        if(num % LottoRule.LOTTO_PRICE.getValue() != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PAYMENT_UNIT.getMessage());
        }
    }

    public int getAmount(){
        return amount;
    }
}
