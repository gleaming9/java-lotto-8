package lotto.parser;

import lotto.domain.Payment;
import lotto.exception.ErrorMessage;

public class PaymentParser {
    public Payment parsePayment(String input){
        int num = parseInput(input);
        return new Payment(num);
    }

    private int parseInput(String input){
        try{
            int num = Integer.parseInt(input.trim());
            validatePaymentRule(num);
            return num;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PAYMENT_RULE.getMessage());
        }
    }

    private void validatePaymentRule(int num){
        if(num < 1000 || num % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PAYMENT_RULE.getMessage());
        }
    }
}
