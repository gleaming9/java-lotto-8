package lotto.exception;

public enum ErrorMessage {
    INVALID_PAYMENT_RULE("로또 구입 금액은 1000원 단위 양수여야 합니다."),

    INVALID_WINNING_NUMBER_RANGE("당첨 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATE_WINNING_NUMBER("당첨 번호는 서로 다른 숫자여야 합니다."),

    INVALID_BONUS_NUMBER_RANGE("보너스 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATE_BONUS_NUMBER("보너스 번호는 당첨 번호와 서로 다른 숫자여야 합니다."),

    INVALID_LOTTO_NUMBER_RANGE("로또 번호는 1부터 45사이의 숫자여야 합니다.");

    private static final String errorPrefix = "[ERROR] ";
    private final String message;

    ErrorMessage(String message){
        this.message = errorPrefix + message;
    }

    public String getMessage() {
        return message;
    }
}
