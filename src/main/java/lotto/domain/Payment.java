package lotto.domain;

import lotto.exception.ErrorMessage;

public class Payment {
    private final int amount;
    private final int lottoCount;

    public Payment(String input){
        this.amount = validate(input);
        this.lottoCount = calculateLottoCount();
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

    private int calculateLottoCount(){
        return amount/LottoRule.LOTTO_PRICE.getValue();
    }

    public int getAmount(){
        return amount;
    }

    public int getLottoCount(){
        return lottoCount;
    }
}
