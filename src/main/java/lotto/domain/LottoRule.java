package lotto.domain;

public enum LottoRule {
    MIN_LOTTO_NUMBER(1),
    MAX_LOTTO_NUMBER(45),
    LOTTO_NUMBER_COUNT(6),
    LOTTO_PRICE(1000);

    private final int value;

    LottoRule(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }
}
