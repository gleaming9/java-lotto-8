package lotto.exception;

public enum ErrorMessage {
    NOT_A_NUMBER_PAYMENT("로또 구입 금액은 정수로 입력해야 합니다."),
    LOW_PAYMENT("로또 구입 금액은 1000원 이상이어야 합니다."),
    INVALID_PAYMENT("로또 구입 금액은 1000원 단위로만 구입 가능합니다."),

    INVALID_WINNING_NUMBER_COUNT("당첨 번호는 6개여야 합니다."),
    INVALID_WINNING_NUMBER("당첨 번호는 1~45 사이의 정수여야 합니다."),
    DUPLICATE_WINNING_NUMBER("당첨 번호는 중복될 수 없습니다."),

    INVALID_BONUS_NUMBER("보너스 번호는 1~45 사이의 정수여야 합니다."),
    DUPLICATE_BONUS_NUMBER("보너스 번호는 당첨 번호와 중복될 수 없습니다."),

    INVALID_LOTTO_COUNT("로또 번호는 6개여야 합니다."),
    DUPLICATE_LOTTO_NUMBER("로또 번호는 중복될 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = "[ERROR] " + message;
    }

    public String getMessage() {
        return message;
    }
}
