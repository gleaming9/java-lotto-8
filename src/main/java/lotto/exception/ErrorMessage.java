package lotto.exception;

public enum ErrorMessage {
    INSUFFICIENT_PAYMENT("[ERROR] 구입 금액은 1000원 이상이어야 합니다."),
    INVALID_PAYMENT_FORMAT("[ERROR] 구입 금액은 공백이나 문자 없이 숫자로만 입력해야 합니다."),
    INVALID_PAYMENT_UNIT("[ERROR] 구입 금액은 1000원 단위로 입력해야 합니다."),

    INVALID_WINNING_NUMBER_SIZE("[ERROR] 당첨 번호는 6개여야 합니다."),
    INVALID_WINNING_NUMBER_FORMAT("[ERROR] 당첨 번호는 공백이나 문자 없이 숫자로만 입력해야 합니다."),
    INVALID_WINNING_NUMBER_RANGE("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATE_WINNING_NUMBER("[ERROR] 당첨 번호에 중복된 숫자가 있을 수 없습니다."),

    INVALID_BONUS_NUMBER_FORMAT("[ERROR] 보너스 번호는 공백이나 문자 없이 숫자로만 입력해야 합니다."),
    INVALID_BONUS_NUMBER_RANGE("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATE_BONUS_NUMBER("[ERROR] 보너스 번호는 당첨 번호와 중복된 숫자가 있을 수 없습니다."),

    INVALID_LOTTO_SIZE("[ERROR] 로또 번호는 6개여야 합니다."),
    DUPLICATE_LOTTO_NUMBER("[ERROR] 로또 번호에 중복된 숫자가 있을 수 없습니다.");

    private final String message;

    ErrorMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
