package lotto;

import lotto.domain.WinningNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningNumberTest {
    @DisplayName("당첨 번호가 6개 미만인 경우 예외가 발생한다.")
    @Test
    void 당첨_번호가_6개가_아닌_경우_예외_1() {
        assertThatThrownBy(() -> new WinningNumber("1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 6개 초과인 경우 예외가 발생한다.")
    @Test
    void 당첨_번호가_6개가_아닌_경우_예외_2() {
        assertThatThrownBy(() -> new WinningNumber("1,2,3,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 유효한 숫자 형식이 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,a,2,3,4,5", " 1,2 3,3,4,5,6", "3,,4,5,,6", ""}) // 문자 포함, 숫자 중간에 공백, 빈 문자열
    void 당첨_번호가_유효한_숫자_형식이_아닌_경우_예외(String input) {
        assertThatThrownBy(() -> new WinningNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 1에서 45사이의 범위의 정수가 아닌 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"0,1,2,3,4,5", "5,7,99,2,3,4", "-8,7,6,-99,1,2", "42.15,1,2,3,4,5"}) // 0 포함, 45 초과, 1 미만 , 실수값
    void 당첨_번호가_1에서_45사이의_범위가_아닌_경우_예외(String input) {
        assertThatThrownBy(() -> new WinningNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 중복된 값이 존재할 경우 예외가 발생한다.")
    @Test
    void 당첨_번호가_중복될_경우_예외() {
        assertThatThrownBy(() -> new WinningNumber("1,1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
