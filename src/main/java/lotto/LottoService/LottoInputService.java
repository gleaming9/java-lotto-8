package lotto.LottoService;

import lotto.domain.BonusNumber;
import lotto.domain.Payment;
import lotto.domain.WinningNumber;

public class LottoInputService {
    public Payment createPayment(String input){
        return new Payment(input);
    }

    public WinningNumber createWinningNumber(String input){
        return new WinningNumber(input);
    }

    public BonusNumber createBonusNumber(String input, WinningNumber winningNumber){
        return new BonusNumber(input, winningNumber);
    }
}
