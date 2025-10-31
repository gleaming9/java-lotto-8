package lotto;

import lotto.domain.Payment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PaymentTest {

    @DisplayName("구입 금액이 1000원 미만이면 예외가 발생한다.")
    @Test
    void 구입_금액이_1000원_미만인_경우_예외() {
        assertThatThrownBy(() -> new Payment("-1000"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void 구입_금액이_1000원_단위가_아닌_경우_예외(){
        assertThatThrownBy(() -> new Payment("1600"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 유효한 숫자 형식이 아니면 예외가 발생한다.")
    @ParameterizedTest // 여러 실패 케이스를 하나의 테스트로 실행
    @ValueSource(strings = {"1000a", "1 000", ""}) // 문자, 공백, 빈 문자열
    void 구입_금액이_숫자_형식이_아닌_경우_예외(String input){
        assertThatThrownBy(() -> new Payment(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
