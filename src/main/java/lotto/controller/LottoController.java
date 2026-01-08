package lotto.controller;

import lotto.domain.BonusNumber;
import lotto.domain.Payment;
import lotto.domain.WinningNumber;
import lotto.parser.BonusNumberParser;
import lotto.parser.PaymentParser;
import lotto.parser.WinningNumberParser;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    PaymentParser paymentParser = new PaymentParser();
    WinningNumberParser winningNumberParser = new WinningNumberParser();
    BonusNumberParser bonusNumberParser = new BonusNumberParser();

    public void run() {
        Payment payment = setUpPayment();
        WinningNumber winningNumber = setUpWinningNumber();
        BonusNumber bonusNumber = setUpBonusNumber(winningNumber);
    }

    private Payment setUpPayment() {
        try {
            String input = InputView.getPayment();
            return paymentParser.parsePayment(input);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return setUpPayment();
        }
    }

    private WinningNumber setUpWinningNumber() {
        try {
            String input = InputView.getWinningNumber();
            return winningNumberParser.parseWinningNumber(input);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return setUpWinningNumber();
        }
    }

    private BonusNumber setUpBonusNumber(WinningNumber winningNumber) {
        try {
            String input = InputView.getBonusNumber();
            return bonusNumberParser.parseBonusNumber(input, winningNumber);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return setUpBonusNumber(winningNumber);
        }
    }
}
