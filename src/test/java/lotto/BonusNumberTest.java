package lotto;

import lotto.domain.BonusNumber;
import lotto.domain.WinningNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusNumberTest {

    private WinningNumber createDefaultWinningNumber() {
        return new WinningNumber("1,2,3,4,5,6");
    }

    @DisplayName("보너스 번호가 1에서 45사이의 정수가 아닌 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"0", "47", "-1"})
    void 보너스_번호가_1에서_45사이의_범위가_아닌_경우_예외(String input) {
        WinningNumber winningNumber = createDefaultWinningNumber();

        assertThatThrownBy(() -> new BonusNumber(input, winningNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복될 경우 예외가 발생한다.")
    @Test
    void 보너스_번호가_중복인_경우_예외() {
        WinningNumber winningNumber = createDefaultWinningNumber();

        assertThatThrownBy(() -> new BonusNumber("1", winningNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 유효한 숫자 형식이 아닌 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"a", "1 2", "12a3"})
    void 보너스_번호가_유효한_숫자_형식이_아닌_경우(String input) {
        WinningNumber winningNumber = createDefaultWinningNumber();

        assertThatThrownBy(() -> new BonusNumber(input, winningNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
