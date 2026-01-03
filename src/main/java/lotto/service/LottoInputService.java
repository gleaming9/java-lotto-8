package lotto.service;

import lotto.domain.BonusNumber;
import lotto.domain.Payment;
import lotto.domain.WinningNumber;

public class LottoInputService {
    public static Payment createPayment(String input) {
        return new Payment(input);
    }

    public static WinningNumber createWinningNumber(String input) {
        return new WinningNumber(input);
    }

    public static BonusNumber createBonusNumber(String input, WinningNumber winningNumber) {
        return new BonusNumber(input, winningNumber);
    }
}
