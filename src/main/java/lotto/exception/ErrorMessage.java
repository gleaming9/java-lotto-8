package lotto.exception;

public enum ErrorMessage {
    INSUFFICIENT_PAYMENT("[ERROR] 구입 금액은 1000원 이상이어야 합니다."),
    INVALID_PAYMENT_FORMAT("[ERROR] 구입 금액은 공백이나 문자 없이 숫자로만 입력해야 합니다."),
    INVALID_PAYMENT_UNIT("[ERROR] 구입 금액은 1000원 단위로 입력해야 합니다.");

    private final String message;

    ErrorMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
